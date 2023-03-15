package pet.hospital.backend.medicalRecordManagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "病例模块", version = "0.0.1-SNAPSHOT", description = "虚拟宠物医院API文档-病例模块"))
public class MedicalRecordManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalRecordManagementApplication.class, args);
    }
}
