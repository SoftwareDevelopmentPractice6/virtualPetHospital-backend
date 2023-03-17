/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-17 23:56:51
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-18 00:40:07
 * @FilePath: /virtualPetHospital-backend/login/src/main/java/pet/hospital/backend/login/helper/ResponseHelper.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.common.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import pet.hospital.backend.common.constant.Constants;

public class ResponseHelper {

    public static int requestErrorCode = 515;

    public static int authorityErrorCode = 401;

    public static int successCode = 200;

    public static JSONObject constructSuccessResponse(Object object) {
        JSONObject res = new JSONObject();
        res.put(Constants.code, ResponseHelper.successCode);
        res.put(Constants.data, JSONObject.parseObject(JSON.toJSONString(object)));
        return res;
    }

    public static JSONObject constructFailedResponse(int code) {
        JSONObject res = new JSONObject();
        res.put(Constants.code, code);
        res.put(Constants.data, null);
        return res;
    }
}
