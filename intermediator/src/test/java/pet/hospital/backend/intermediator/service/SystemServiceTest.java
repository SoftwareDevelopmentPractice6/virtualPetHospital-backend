package pet.hospital.backend.intermediator.service;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pet.hospital.backend.intermediator.constant.Constants;

@SpringBootTest
public class SystemServiceTest {

    @Autowired
    protected SystemService systemService;

    @MockBean
    protected RestTemplate restTemplate;

    @BeforeEach
    void init() {
        Mockito.when(restTemplate.postForObject(Mockito.anyString(), Mockito.any(), Mockito.any()))
                .thenReturn(null);
    }

    @Test
    void testAddAdmission() {
        String api = "api/system/admission/add";

        MultiValueMap<String, String> mockRequestEntity = new LinkedMultiValueMap<>();
        mockRequestEntity.add(Constants.roomStandard, "normol");
        mockRequestEntity.add(Constants.careLevel, "high");
        mockRequestEntity.add(Constants.remark, "very good");
        mockRequestEntity.add(Constants.carePrice, String.valueOf(100.0));
        mockRequestEntity.add(Constants.roomName, "a");

        systemService.addAdmission("normol", "high", "very good", 100.0, "a");
        Mockito.verify(restTemplate)
                .postForObject(
                        Mockito.eq(Constants.systemModuleBaseUrl + api),
                        Mockito.eq(mockRequestEntity),
                        Mockito.eq((JSONObject.class)));
    }

    @Test
    void testAddArchive() {
        String api = "api/system/archive/add";

        MultiValueMap<String, String> mockRequestEntity = new LinkedMultiValueMap<>();
        mockRequestEntity.add(Constants.storeTime, "9999-12-31 12:12:12");
        mockRequestEntity.add(Constants.diseaseType, "aa");
        mockRequestEntity.add(Constants.petType, "b");
        mockRequestEntity.add(Constants.petName, "c");
        mockRequestEntity.add(Constants.petSex, String.valueOf('1'));
        mockRequestEntity.add(Constants.ownerTel, "111111");

        systemService.addArchive("9999-12-31 12:12:12", "aa", "b", "c", '1', "111111");
        Mockito.verify(restTemplate)
                .postForObject(
                        Mockito.eq(Constants.systemModuleBaseUrl + api),
                        Mockito.eq(mockRequestEntity),
                        Mockito.eq((JSONObject.class)));
    }

    @Test
    void testAddCharge() {

    }

    @Test
    void testAddExamine() {
    }

    @Test
    void testAddFeature() {
    }

    @Test
    void testAddFeatureAutomatically() {
    }

    @Test
    void testAddMedicine() {
    }

    @Test
    void testAddRoom() {
    }

    @Test
    void testDeleteAdmission() {
    }

    @Test
    void testDeleteArchive() {
    }

    @Test
    void testDeleteCharge() {
    }

    @Test
    void testDeleteExamine() {
    }

    @Test
    void testDeleteFeature() {
    }

    @Test
    void testDeleteMedicine() {
    }

    @Test
    void testDeleteRoom() {
    }

    @Test
    void testGetAdmissions() {
    }

    @Test
    void testGetArchives() {
    }

    @Test
    void testGetCharges() {
    }

    @Test
    void testGetExamines() {
    }

    @Test
    void testGetFeatures() {
    }

    @Test
    void testGetMedicines() {
    }

    @Test
    void testGetRooms() {
    }

    @Test
    void testUpdateAdmission() {
    }

    @Test
    void testUpdateArchive() {
    }

    @Test
    void testUpdateCharge() {
    }

    @Test
    void testUpdateExamine() {
    }

    @Test
    void testUpdateFeature() {
    }

    @Test
    void testUpdateFeatureAutomatically() {
    }

    @Test
    void testUpdateMedicine() {
    }

    @Test
    void testUpdateRoom() {
    }
}
