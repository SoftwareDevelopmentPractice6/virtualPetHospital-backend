/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-15 23:47:20
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-16 11:49:03
 * @FilePath: /virtualPetHospital-backend/intermediator/src/main/java/pet/hospital/backend/intermediator/helper/ResponseData.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.intermediator.helper;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import pet.hospital.backend.intermediator.constant.Constants;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseData<T> {

    private int code; // 状态码
    private String message; // 提示消息
    private T data; // 响应结果集数据

    public void parserEnum(EnumCode enumCode) {
        this.code = enumCode.getCode();
        this.message = enumCode.getMessage();
    }

    public static <T> ResponseData<T> success(T data) {

        ResponseData<T> responseData = new ResponseData<T>();
        responseData.parserEnum(EnumCode.SUCCESS);
        responseData.setData(data);
        return responseData;
    }

    public static <T> ResponseData<T> error(EnumCode enumCode) {

        ResponseData<T> responseData = new ResponseData<T>();
        responseData.parserEnum(enumCode);
        return responseData;
    }

    public static <T> ResponseData<T> generator(int code, String message) {
        ResponseData<T> responseData = new ResponseData<T>();
        responseData.setCode(code);
        responseData.setMessage(message);
        return responseData;
    }

    public ResponseEntity<JSONObject> toResponseEntity() {
        JSONObject responseBody = new JSONObject();
        responseBody.put(Constants.code, this.code);
        responseBody.put(Constants.message, this.message);
        responseBody.put(Constants.data, this.data);
        return ResponseEntity.status(this.code).body(responseBody);
    }
}
