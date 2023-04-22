/*
 * @Author: dafenqi-11 diaozehao@163.com
 * @Date: 2023-03-24 19:59:48
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-25 01:23:59
 * @FilePath: \virtualPetHospital-backend\system\src\main\java\pet\hospital\backend\system\service\ArchiveService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.system.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.hospital.backend.common.constant.Constants;
import pet.hospital.backend.common.helper.ResponseHelper;
import pet.hospital.backend.common.helper.SearchJudgeHelper;
import pet.hospital.backend.system.dao.ArchiveRepository;
import pet.hospital.backend.system.entity.Archive;

@Service
public class ArchiveService {

    @Autowired
    private ArchiveRepository archiveRepository;

    public JSONObject getArchive(
            Date storeTime, String diseaseType, String petType, String petName, Character petSex, String ownerTel) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.archiveList,
                JSONObject.parseArray(JSON.toJSONString(archiveRepository.findAll().stream()
                        .filter(archive -> SearchJudgeHelper.softEquals(storeTime, archive.getStoreTime())
                                && SearchJudgeHelper.softEquals(diseaseType, archive.getDiseaseType())
                                && SearchJudgeHelper.softEquals(petType, archive.getPetType())
                                && SearchJudgeHelper.softEquals(petName, archive.getPetName())
                                && SearchJudgeHelper.softEquals(petSex, archive.getPetSex())
                                && SearchJudgeHelper.softEquals(ownerTel, archive.getOwnerTel()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addArchive(
            Date storeTime, String diseaseType, String petType, String petName, char petSex, String ownerTel) {

        List<Archive> targetArchiveList = archiveRepository.findAll().stream()
                .filter(archive -> Objects.equals(archive.getStoreTime(), storeTime)
                        && Objects.equals(archive.getOwnerTel(), ownerTel))
                .collect(Collectors.toList());

        if (Objects.equals(targetArchiveList.size(), 0)) {

            Archive newArchive = new Archive();
            newArchive.setStoreTime(storeTime);
            newArchive.setDiseaseType(diseaseType);
            newArchive.setPetType(petType);
            newArchive.setPetName(petName);
            newArchive.setPetSex(petSex);
            newArchive.setOwnerTel(ownerTel);

            Archive addedArchive = archiveRepository.saveAndFlush(newArchive);

            return ResponseHelper.constructSuccessResponse(addedArchive);
        } else {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        }
    }

    public JSONObject updateArchive(
            int archiveId,
            Date storeTime,
            String diseaseType,
            String petType,
            String petName,
            char petSex,
            String ownerTel) {
        Optional<Archive> targetArchiveOptional = archiveRepository.findById(archiveId);

        if (targetArchiveOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            List<Archive> targetArchiveList = archiveRepository.findAll().stream()
                    .filter(archive -> Objects.equals(archive.getStoreTime(), storeTime)
                            && Objects.equals(archive.getOwnerTel(), ownerTel)
                            && !Objects.equals(archive.getArchiveId(), archiveId))
                    .collect(Collectors.toList());

            if (!Objects.equals(targetArchiveList.size(), 0)) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                Archive targetArchive = targetArchiveOptional.get();
                targetArchive.setStoreTime(storeTime);
                targetArchive.setDiseaseType(diseaseType);
                targetArchive.setPetType(petType);
                targetArchive.setPetName(petName);
                targetArchive.setPetSex(petSex);
                targetArchive.setOwnerTel(ownerTel);

                Archive updatedArchive = archiveRepository.saveAndFlush(targetArchive);

                return ResponseHelper.constructSuccessResponse(updatedArchive);
            }
        }
    }

    public JSONObject deleteArchive(int archiveId) {
        Optional<Archive> targetArchiveOptional = archiveRepository.findById(archiveId);

        if (targetArchiveOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            archiveRepository.deleteById(archiveId);

            if (archiveRepository.findById(archiveId).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetArchiveOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
