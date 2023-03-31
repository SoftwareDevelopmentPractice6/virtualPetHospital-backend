/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-25 15:02:58
 * @LastEditors: pikapikapi pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-31 09:08:23
 * @FilePath: /virtualPetHospital-backend/intermediator/src/main/java/pet/hospital/backend/intermediator/controller/SystemController.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.intermediator.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pet.hospital.backend.intermediator.constant.Constants;
import pet.hospital.backend.intermediator.service.SystemService;

@RestController
@CrossOrigin
@Tag(name = "系统管理模块")
@RequestMapping(
        value = "/api/system",
        produces = {"application/json;charset=UTF-8"})
public class SystemController {
    @Autowired
    SystemService systemService;

    @Operation(summary = "获取入院信息列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"admissionList\":[{\"careLevel\":\"this is a test\",\"admissionId\":1,\"remark\":\"oxjoq\",\"carePrice\":1,\"admissionRoom\":{\"roomRole\":\"this is a test\",\"roomName\":\"testroom\"},\"roomStandard\":\"testroom\"},{\"careLevel\":\"High\",\"admissionId\":2,\"remark\":\"comment on normal room\",\"carePrice\":555.25,\"admissionRoom\":{\"roomRole\":\"RAD\",\"roomName\":\"admission room\"},\"roomStandard\":\"normal room 3\"}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/admission")
    public ResponseEntity<JSONObject> getAdmissions(
            @Parameter(description = "房间标准") @RequestParam(required = false) String roomStandard,
            @Parameter(description = "互理级别") @RequestParam(required = false) String careLevel,
            @Parameter(description = "备注，支持模糊查询") @RequestParam(required = false) String remark,
            @Parameter(description = "住院价格") @RequestParam(required = false) Double carePrice,
            @Parameter(description = "科室名称") @RequestParam(required = false) String roomName) {
        return systemService
                .getAdmissions(roomStandard, careLevel, remark, carePrice, roomName)
                .toResponseEntity();
    }

    @Operation(summary = "新增入院信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"careLevel\":\"Low\",\"admissionId\":2,\"remark\":\"comment on normal room\",\"carePrice\":555.25,\"admissionRoom\":{\"roomRole\":\"RAD\",\"roomName\":\"admission room\"},\"roomStandard\":\"normal room 2\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/admission")
    public ResponseEntity<JSONObject> addAdmission(
            @Parameter(
                            description = "新增的入院信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"roomStandard\": \"normal room\", \"careLevel\": \"High\", \"remark\": \"comment on normal room\", \"carePrice\": 555.25, \"roomName\": \"admission room\"}"))
                    @RequestBody
                    JSONObject newAdmissionInfo) {
        return systemService
                .addAdmission(
                        newAdmissionInfo.getString(Constants.roomStandard),
                        newAdmissionInfo.getString(Constants.careLevel),
                        newAdmissionInfo.getString(Constants.remark),
                        newAdmissionInfo.getDouble(Constants.carePrice),
                        newAdmissionInfo.getString(Constants.roomName))
                .toResponseEntity();
    }

    @Operation(summary = "更改入院信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"careLevel\":\"High\",\"admissionId\":2,\"remark\":\"comment on normal room\",\"carePrice\":555.25,\"admissionRoom\":{\"roomRole\":\"RAD\",\"roomName\":\"admission room\"},\"roomStandard\":\"normal room 3\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PutMapping(value = "/admission")
    public ResponseEntity<JSONObject> updateAdmission(
            @Parameter(
                            description = "更改后的入院信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"admissionId\": 2, \"roomStandard\": \"normal room\", \"careLevel\": \"High\", \"remark\": \"comment on normal room\", \"carePrice\": 555.25, \"roomName\": \"admission room\"}"))
                    @RequestBody
                    JSONObject newAdmissionInfo) {
        return systemService
                .updateAdmission(
                        newAdmissionInfo.getInteger(Constants.admissionId),
                        newAdmissionInfo.getString(Constants.roomStandard),
                        newAdmissionInfo.getString(Constants.careLevel),
                        newAdmissionInfo.getString(Constants.remark),
                        newAdmissionInfo.getDouble(Constants.carePrice),
                        newAdmissionInfo.getString(Constants.roomName))
                .toResponseEntity();
    }

    @Operation(summary = "删除入院信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"careLevel\":\"Low\",\"admissionId\":2,\"remark\":\"comment on normal room\",\"carePrice\":555.25,\"roomStandard\":\"normal room 2\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @DeleteMapping(value = "/admission/{admissionId}")
    public ResponseEntity<JSONObject> deleteAdmission(
            @Parameter(description = "入院信息Id") @PathVariable int admissionId) {
        return systemService.deleteAdmission(admissionId).toResponseEntity();
    }

    @Operation(summary = "获取档案信息列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"archiveList\":[{\"petName\":\"Tom\",\"petSex\":\"M\",\"petType\":\"cat\",\"storeTime\":\"2022-12-31 11:11:11\",\"ownerTel\":\"12345678910\",\"diseaseType\":\"Psychosis\",\"archiveId\":1}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/archive")
    public ResponseEntity<JSONObject> getArchives(
            @Parameter(description = "记录时间") @RequestParam(required = false) String storeTime,
            @Parameter(description = "疾病类型") @RequestParam(required = false) String diseaseType,
            @Parameter(description = "宠物类型") @RequestParam(required = false) String petType,
            @Parameter(description = "宠物名字") @RequestParam(required = false) String petName,
            @Parameter(description = "宠物性别") @RequestParam(required = false) Character petSex,
            @Parameter(description = "主人联系电话") @RequestParam(required = false) String ownerTel) {
        return systemService
                .getArchives(storeTime, diseaseType, petType, petName, petSex, ownerTel)
                .toResponseEntity();
    }

    @Operation(summary = "新增档案信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"petName\":\"Tom\",\"petSex\":\"M\",\"petType\":\"cat\",\"storeTime\":\"2022-12-31 12:12:12\",\"ownerTel\":\"12345678910\",\"diseaseType\":\"Psychosis\",\"archiveId\":2},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/archive")
    public ResponseEntity<JSONObject> addArchive(
            @Parameter(
                            description = "新增的档案信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"storeTime\": \"2022-12-31 12:12:12\", \"diseaseType\": \"Psychosis\", \"petType\": \"cat\", \"petName\": \"Tom\", \"petSex\": \"M\", \"ownerTel\": \"12345678910\"}"))
                    @RequestBody
                    JSONObject newArchiveInfo) {
        return systemService
                .addArchive(
                        newArchiveInfo.getString(Constants.storeTime),
                        newArchiveInfo.getString(Constants.diseaseType),
                        newArchiveInfo.getString(Constants.petType),
                        newArchiveInfo.getString(Constants.petName),
                        newArchiveInfo.getString(Constants.petSex).charAt(0),
                        newArchiveInfo.getString(Constants.ownerTel))
                .toResponseEntity();
    }

    @Operation(summary = "更改档案信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"petName\":\"Tom\",\"petSex\":\"M\",\"petType\":\"cat\",\"storeTime\":\"2022-12-31 12:22:09\",\"ownerTel\":\"12345678910\",\"diseaseType\":\"Psychosis\",\"archiveId\":1},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PutMapping(value = "/archive")
    public ResponseEntity<JSONObject> updateArchive(
            @Parameter(
                            description = "更改后的档案信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"archiveId\": 2, \"storeTime\": \"2022-12-31 11:11:11\", \"diseaseType\": \"Psychosis\", \"petType\": \"cat\", \"petName\": \"Tom\", \"petSex\": \"M\", \"ownerTel\": \"12345678910\"}"))
                    @RequestBody
                    JSONObject newArchiveInfo) {
        return systemService
                .updateArchive(
                        newArchiveInfo.getInteger(Constants.archiveId),
                        newArchiveInfo.getString(Constants.storeTime),
                        newArchiveInfo.getString(Constants.diseaseType),
                        newArchiveInfo.getString(Constants.petType),
                        newArchiveInfo.getString(Constants.petName),
                        newArchiveInfo.getString(Constants.petSex).charAt(0),
                        newArchiveInfo.getString(Constants.ownerTel))
                .toResponseEntity();
    }

    @Operation(summary = "删除档案信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"petName\":\"Tom\",\"petSex\":\"M\",\"petType\":\"cat\",\"storeTime\":\"2022-12-31 12:12:12\",\"ownerTel\":\"12345678910\",\"diseaseType\":\"Psychosis\",\"archiveId\":2},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @DeleteMapping(value = "/archive/{archiveId}")
    public ResponseEntity<JSONObject> deleteArchive(@Parameter(description = "档案信息Id") @PathVariable int archiveId) {
        return systemService.deleteArchive(archiveId).toResponseEntity();
    }

    @Operation(summary = "获取收费信息列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"chargeList\":[{\"itemName\":\"testCharge\",\"chargeId\":1,\"chargePrice\":7.3}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/charge/{itemName}")
    public ResponseEntity<JSONObject> getChargesByItemName(
            @Parameter(description = "收费名称") @PathVariable String itemName,
            @Parameter(description = "收费价格") @RequestParam(required = false) Double chargePrice) {
        return systemService.getCharges(itemName, chargePrice).toResponseEntity();
    }

    @Operation(summary = "获取收费信息列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"chargeList\":[{\"itemName\":\"testCharge\",\"chargeId\":1,\"chargePrice\":7.3}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/charge")
    public ResponseEntity<JSONObject> getCharges(
            @Parameter(description = "收费价格") @RequestParam(required = false) Double chargePrice) {
        return systemService.getCharges(null, chargePrice).toResponseEntity();
    }

    @Operation(summary = "新增收费信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"itemName\":\"Charge Item 2\",\"chargeId\":2,\"chargePrice\":13.12},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/charge")
    public ResponseEntity<JSONObject> addCharge(
            @Parameter(
                            description = "新增的收费信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example = "{\"itemName\": \"Charge Item 1\", \"chargePrice\": 123.12}"))
                    @RequestBody
                    JSONObject newChargeInfo) {
        return systemService
                .addCharge(newChargeInfo.getString(Constants.itemName), newChargeInfo.getDouble(Constants.chargePrice))
                .toResponseEntity();
    }

    @Operation(summary = "更改收费信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"itemName\":\"Charge Item 1\",\"chargeId\":1,\"chargePrice\":123.12},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PutMapping(value = "/charge")
    public ResponseEntity<JSONObject> updateCharge(
            @Parameter(
                            description = "更改后的收费信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"chargeId\": 2, \"itemName\": \"Charge Item 1\", \"chargePrice\": 123.12}"))
                    @RequestBody
                    JSONObject newChargeInfo) {
        return systemService
                .updateCharge(
                        newChargeInfo.getInteger(Constants.chargeId),
                        newChargeInfo.getString(Constants.itemName),
                        newChargeInfo.getDouble(Constants.chargePrice))
                .toResponseEntity();
    }

    @Operation(summary = "删除收费信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"itemName\":\"Charge Item 2\",\"chargeId\":2,\"chargePrice\":13.12},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @DeleteMapping(value = "/charge/{chargeId}")
    public ResponseEntity<JSONObject> deleteCharge(@Parameter(description = "收费信息Id") @PathVariable int chargeId) {
        return systemService.deleteCharge(chargeId).toResponseEntity();
    }

    @Operation(summary = "获取化验信息列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examineList\":[{\"examineName\":\"testroom\",\"examineRoom\":{\"roomRole\":\"this is a test\",\"roomName\":\"testroom\"},\"examineId\":2,\"examinePrice\":1.2},{\"examineName\":\"Examine Item 4\",\"examineRoom\":{\"roomRole\":\"RAD\",\"roomName\":\"examine room\"},\"examineId\":3,\"examinePrice\":13.12}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/examine/{examineName}")
    public ResponseEntity<JSONObject> getExaminesByExamineName(
            @Parameter(description = "化验名称，支持模糊查询") @PathVariable String examineName,
            @Parameter(description = "化验价格") @RequestParam(required = false) Double examinePrice,
            @Parameter(description = "科室名称") @RequestParam(required = false) String roomName) {
        return systemService.getExamines(examineName, examinePrice, roomName).toResponseEntity();
    }

    @Operation(summary = "获取化验信息列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examineList\":[{\"examineName\":\"testroom\",\"examineRoom\":{\"roomRole\":\"this is a test\",\"roomName\":\"testroom\"},\"examineId\":2,\"examinePrice\":1.2},{\"examineName\":\"Examine Item 4\",\"examineRoom\":{\"roomRole\":\"RAD\",\"roomName\":\"examine room\"},\"examineId\":3,\"examinePrice\":13.12}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/examine")
    public ResponseEntity<JSONObject> getExamines(
            @Parameter(description = "化验价格") @RequestParam(required = false) Double examinePrice,
            @Parameter(description = "科室名称") @RequestParam(required = false) String roomName) {
        return systemService.getExamines(null, examinePrice, roomName).toResponseEntity();
    }

    @Operation(summary = "新增化验信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examineName\":\"Examine Item 4\",\"examineRoom\":{\"roomRole\":\"RAD\",\"roomName\":\"examine room\"},\"examineId\":3,\"examinePrice\":13.12},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/examine")
    public ResponseEntity<JSONObject> addExamine(
            @Parameter(
                            description = "新增的化验信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"examineName\": \"Examine Item 1\", \"examinePrice\": 123.12, \"roomName\": \"examine room\"}"))
                    @RequestBody
                    JSONObject newExamineInfo) {
        return systemService
                .addExamine(
                        newExamineInfo.getString(Constants.examineName),
                        newExamineInfo.getDouble(Constants.examinePrice),
                        newExamineInfo.getString(Constants.roomName))
                .toResponseEntity();
    }

    @Operation(summary = "更改化验信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examineName\":\"Examine Item 4\",\"examineRoom\":{\"roomRole\":\"RAD\",\"roomName\":\"examine room\"},\"examineId\":3,\"examinePrice\":123.12},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PutMapping(value = "/examine")
    public ResponseEntity<JSONObject> updateExamine(
            @Parameter(
                            description = "更改后的化验信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"examineId\": 2, \"examineName\": \"Examine Item 1\", \"examinePrice\": 123.12, \"roomName\": \"examine room\"}"))
                    @RequestBody
                    JSONObject newExamineInfo) {
        return systemService
                .updateExamine(
                        newExamineInfo.getInteger(Constants.examineId),
                        newExamineInfo.getString(Constants.examineName),
                        newExamineInfo.getDouble(Constants.examinePrice),
                        newExamineInfo.getString(Constants.roomName))
                .toResponseEntity();
    }

    @Operation(summary = "删除化验信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examineName\":\"testroom\",\"examineId\":2,\"examinePrice\":1.2},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @DeleteMapping(value = "/examine/{examineId}")
    public ResponseEntity<JSONObject> deleteExamine(@Parameter(description = "化验信息Id") @PathVariable int examineId) {
        return systemService.deleteExamine(examineId).toResponseEntity();
    }

    @Operation(summary = "获取药品信息列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"medicineList\":[{\"medicineCategory\":\"wdff\",\"isVaccine\":0,\"medicinePrice\":3.1,\"medicineId\":1,\"specification\":\"fhiqhi\",\"medicineName\":\"testmed\",\"manufacturer\":\"aa\"}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/medicine/{medicineName}")
    public ResponseEntity<JSONObject> getMedicinesByMedicineName(
            @Parameter(description = "药物名称") @PathVariable String medicineName,
            @Parameter(description = "药物价格") @RequestParam(required = false) Double medicinePrice,
            @Parameter(description = "药物说明，支持模糊查询") @RequestParam(required = false) String manufacturer,
            @Parameter(description = "药物类别") @RequestParam(required = false) String medicineCategory,
            @Parameter(description = "药物规格，支持模糊查询") @RequestParam(required = false) String specification,
            @Parameter(description = "是否为疫苗0/1") @RequestParam(required = false) Integer isVaccine) {
        return systemService
                .getMedicines(medicineName, medicinePrice, manufacturer, medicineCategory, specification, isVaccine)
                .toResponseEntity();
    }

    @Operation(summary = "获取药品信息列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"medicineList\":[{\"medicineCategory\":\"wdff\",\"isVaccine\":0,\"medicinePrice\":3.1,\"medicineId\":1,\"specification\":\"fhiqhi\",\"medicineName\":\"testmed\",\"manufacturer\":\"aa\"}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/medicine")
    public ResponseEntity<JSONObject> getMedicines(
            @Parameter(description = "药物价格") @RequestParam(required = false) Double medicinePrice,
            @Parameter(description = "药物说明，支持模糊查询") @RequestParam(required = false) String manufacturer,
            @Parameter(description = "药物类别") @RequestParam(required = false) String medicineCategory,
            @Parameter(description = "药物规格，支持模糊查询") @RequestParam(required = false) String specification,
            @Parameter(description = "是否为疫苗0/1") @RequestParam(required = false) Integer isVaccine) {
        return systemService
                .getMedicines(null, medicinePrice, manufacturer, medicineCategory, specification, isVaccine)
                .toResponseEntity();
    }

    @Operation(summary = "新增药品信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"medicineCategory\":\"Mental\",\"isVaccine\":0,\"medicinePrice\":123.12,\"medicineId\":2,\"specification\":\"Specification 1\",\"medicineName\":\"Medicine Item 2\",\"manufacturer\":\"Manufacturer 1\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/medicine")
    public ResponseEntity<JSONObject> addMedicine(
            @Parameter(
                            description = "新增的药品信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"medicineName\": \"Medicine Item 1\", \"medicinePrice\": 123.12, \"manufacturer\": \"Manufacturer 1\", \"medicineCategory\": \"Mental\", \"specification\": \"Specification 1\", \"isVaccine\": 0}"))
                    @RequestBody
                    JSONObject newMedicineInfo) {
        return systemService
                .addMedicine(
                        newMedicineInfo.getString(Constants.medicineName),
                        newMedicineInfo.getDouble(Constants.medicinePrice),
                        newMedicineInfo.getString(Constants.manufacturer),
                        newMedicineInfo.getString(Constants.medicineCategory),
                        newMedicineInfo.getString(Constants.specification),
                        newMedicineInfo.getInteger(Constants.isVaccine))
                .toResponseEntity();
    }

    @Operation(summary = "更改药品信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"medicineCategory\":\"Mental\",\"isVaccine\":0,\"medicinePrice\":123.12,\"medicineId\":1,\"specification\":\"Specification 1\",\"medicineName\":\"Medicine Item 1\",\"manufacturer\":\"Manufacturer 1\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PutMapping(value = "/medicine")
    public ResponseEntity<JSONObject> updateMedicine(
            @Parameter(
                            description = "更改后的药品信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"medicineId\": 2, \"medicineName\": \"Medicine Item 1\", \"medicinePrice\": 123.12, \"manufacturer\": \"Manufacturer 1\", \"medicineCategory\": \"Mental\", \"specification\": \"Specification 1\", \"isVaccine\": 0}"))
                    @RequestBody
                    JSONObject newMedicineInfo) {
        return systemService
                .updateMedicine(
                        newMedicineInfo.getInteger(Constants.medicineId),
                        newMedicineInfo.getString(Constants.medicineName),
                        newMedicineInfo.getDouble(Constants.medicinePrice),
                        newMedicineInfo.getString(Constants.manufacturer),
                        newMedicineInfo.getString(Constants.medicineCategory),
                        newMedicineInfo.getString(Constants.specification),
                        newMedicineInfo.getInteger(Constants.isVaccine))
                .toResponseEntity();
    }

    @Operation(summary = "删除药品信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"medicineCategory\":\"Mental\",\"isVaccine\":0,\"medicinePrice\":123.12,\"medicineId\":2,\"specification\":\"Specification 1\",\"medicineName\":\"Medicine Item 2\",\"manufacturer\":\"Manufacturer 1\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @DeleteMapping(value = "/medicine/{medicineId}")
    public ResponseEntity<JSONObject> deleteMedicine(@Parameter(description = "药品信息Id") @PathVariable int medicineId) {
        return systemService.deleteMedicine(medicineId).toResponseEntity();
    }

    @Operation(summary = "获取科室信息列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"roomList\":[{\"roomRole\":\"this is a test\",\"roomName\":\"testroom\"}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/room/{roomKeyword}")
    public ResponseEntity<JSONObject> getRoomsByRoomName(
            @Parameter(description = "科室名称关键字，支持模糊查询") @PathVariable String roomKeyword,
            @Parameter(description = "科室人员角色，NRAD顺序表示无权限、前台、医助、医师") @RequestParam(required = false) String roomRole) {
        return systemService.getRooms(roomKeyword, roomRole).toResponseEntity();
    }

    @Operation(summary = "获取科室信息列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"roomList\":[{\"roomRole\":\"this is a test\",\"roomName\":\"testroom\"}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/room")
    public ResponseEntity<JSONObject> getRooms(
            @Parameter(description = "科室人员角色，NRAD顺序表示无权限、前台、医助、医师") @RequestParam(required = false) String roomRole) {
        return systemService.getRooms(null, roomRole).toResponseEntity();
    }

    @Operation(summary = "新增科室信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"roomRole\":\"RAD\",\"roomName\":\"Prepare 2\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/room")
    public ResponseEntity<JSONObject> addRoom(
            @Parameter(
                            description = "新增的科室信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example = "{\"roomName\": \"Prepare\", \"roomRole\": \"RAD\"}"))
                    @RequestBody
                    JSONObject newRoomInfo) {
        return systemService
                .addRoom(newRoomInfo.getString(Constants.roomName), newRoomInfo.getString(Constants.roomRole))
                .toResponseEntity();
    }

    @Operation(summary = "更改科室信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"roomRole\":\"RAD\",\"roomName\":\"Prepare\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PutMapping(value = "/room")
    public ResponseEntity<JSONObject> updateRoom(
            @Parameter(
                            description = "更改后的科室信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"previousRoomName\": \"test room\", \"roomName\": \"Prepare\", \"roomRole\": \"RAD\"}"))
                    @RequestBody
                    JSONObject newRoomInfo) {
        return systemService
                .updateRoom(
                        newRoomInfo.getString(Constants.previousRoomName),
                        newRoomInfo.getString(Constants.roomName),
                        newRoomInfo.getString(Constants.roomRole))
                .toResponseEntity();
    }

    @Operation(summary = "删除科室信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"roomRole\":\"this is a test\",\"roomName\":\"testroom\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @DeleteMapping(value = "/room/{roomName}")
    public ResponseEntity<JSONObject> deleteRoom(@Parameter(description = "科室信息Id") @PathVariable String roomName) {
        return systemService.deleteRoom(roomName).toResponseEntity();
    }

    @Operation(summary = "获取功能信息列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"featureList\":[{\"funcDescription\":\"b\",\"funcName\":\"a\",\"featureRoom\":{\"roomRole\":\"RAD\",\"roomName\":\"Prepare\"},\"funcFlow\":\"z\",\"funcRole\":\"w\",\"funcTool\":\"uuu\",\"funcId\":1,\"funcVideo\":\"a\"}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/feature/{funcName}")
    public ResponseEntity<JSONObject> getFeaturesByFeatureName(
            @Parameter(description = "具体功能名") @PathVariable String funcName,
            @Parameter(description = "具体功能描述，支持模糊查询") @RequestParam(required = false) String funcDescription,
            @Parameter(description = "具体功能流程，支持模糊查询") @RequestParam(required = false) String funcFlow,
            @Parameter(description = "操作人员，NRAD顺序表示无权限、前台、医助、医师") @RequestParam(required = false) String funcRole,
            @Parameter(description = "具体功能使用工具") @RequestParam(required = false) String funcTool,
            @Parameter(description = "对应科室名") @RequestParam(required = false) String roomName) {
        return systemService
                .getFeatures(null, funcName, funcDescription, funcFlow, funcRole, funcTool, roomName)
                .toResponseEntity();
    }

    @Operation(summary = "获取功能信息列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"featureList\":[{\"funcDescription\":\"b\",\"funcName\":\"a\",\"featureRoom\":{\"roomRole\":\"RAD\",\"roomName\":\"Prepare\"},\"funcFlow\":\"z\",\"funcRole\":\"w\",\"funcTool\":\"uuu\",\"funcId\":1,\"funcVideo\":\"a\"}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/feature")
    public ResponseEntity<JSONObject> getFeatures(
            @Parameter(description = "具体功能描述，支持模糊查询") @RequestParam(required = false) String funcDescription,
            @Parameter(description = "具体功能流程，支持模糊查询") @RequestParam(required = false) String funcFlow,
            @Parameter(description = "操作人员，NRAD顺序表示无权限、前台、医助、医师") @RequestParam(required = false) String funcRole,
            @Parameter(description = "具体功能使用工具") @RequestParam(required = false) String funcTool,
            @Parameter(description = "对应科室名") @RequestParam(required = false) String roomName) {
        return systemService
                .getFeatures(null, null, funcDescription, funcFlow, funcRole, funcTool, roomName)
                .toResponseEntity();
    }

    @Operation(summary = "新增功能信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"funcDescription\":\"Inject Vaccine Description\",\"funcName\":\"Inject Vaccine\",\"featureRoom\":{\"roomRole\":\"RAD\",\"roomName\":\"Prepare\"},\"funcFlow\":\"Inject Vaccine Order\",\"funcRole\":\"NAN\",\"funcTool\":\"Needle Tubing\",\"funcId\":2,\"funcVideo\":\"system/feature/90ca72f7-7dd1-438c-b986-a529ba68c6b3/Inject Vaccine/video\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/feature")
    public ResponseEntity<JSONObject> addFeature(
            @Parameter(
                            description = "新增的功能信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"funcName\": \"Prepare Vaccine\", \"funcDescription\": \"Prepare Vaccine Description\", \"funcFlow\": \"Prepare Vaccine Order\", \"funcRole\": \"NAD\", \"funcTool\": \"Needle Tubing\", \"roomName\": \"Prepare Room\"}"))
                    @RequestBody
                    JSONObject newFeatureInfo) {
        return systemService
                .addFeatureAutomatically(
                        newFeatureInfo.getString(Constants.funcName),
                        newFeatureInfo.getString(Constants.funcDescription),
                        newFeatureInfo.getString(Constants.funcFlow),
                        newFeatureInfo.getString(Constants.funcRole),
                        newFeatureInfo.getString(Constants.funcTool),
                        newFeatureInfo.getString(Constants.roomName))
                .toResponseEntity();
    }

    @Operation(summary = "更改功能信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"funcDescription\":\"Prepare Vaccine Description\",\"funcName\":\"Prepare Vaccine\",\"featureRoom\":{\"roomRole\":\"RAD\",\"roomName\":\"Prepare 2\"},\"funcFlow\":\"Prepare Vaccine Order\",\"funcRole\":\"NAD\",\"funcTool\":\"Needle Tubing\",\"funcId\":1,\"funcVideo\":\"a\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PutMapping(value = "/feature")
    public ResponseEntity<JSONObject> updateFeature(
            @Parameter(
                            description = "更改后的功能信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"funcId\": 2, \"funcName\": \"Prepare Vaccine\", \"funcDescription\": \"Prepare Vaccine Description\", \"funcFlow\": \"Prepare Vaccine Order\", \"funcRole\": \"NAD\", \"funcTool\": \"Needle Tubing\", \"roomName\": \"Prepare Room\"}"))
                    @RequestBody
                    JSONObject newFeatureInfo) {
        return systemService
                .updateFeatureAutomatically(
                        newFeatureInfo.getInteger(Constants.funcId),
                        newFeatureInfo.getString(Constants.funcName),
                        newFeatureInfo.getString(Constants.funcDescription),
                        newFeatureInfo.getString(Constants.funcFlow),
                        newFeatureInfo.getString(Constants.funcRole),
                        newFeatureInfo.getString(Constants.funcTool),
                        newFeatureInfo.getString(Constants.roomName))
                .toResponseEntity();
    }

    @Operation(summary = "删除功能信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"funcDescription\":\"Inject Vaccine Description\",\"funcName\":\"Inject Vaccine\",\"featureRoom\":{\"roomRole\":\"RAD\",\"roomName\":\"Prepare\"},\"funcFlow\":\"Inject Vaccine Order\",\"funcRole\":\"NAN\",\"funcTool\":\"Needle Tubing\",\"funcId\":2,\"funcVideo\":\"system/feature/90ca72f7-7dd1-438c-b986-a529ba68c6b3/Inject Vaccine/video\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @DeleteMapping(value = "/feature/{funcId}")
    public ResponseEntity<JSONObject> deleteFeature(@Parameter(description = "功能信息Id") @PathVariable int funcId) {
        return systemService.deleteFeature(funcId).toResponseEntity();
    }
}
