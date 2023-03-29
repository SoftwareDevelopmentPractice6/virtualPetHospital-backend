package pet.hospital.backend.intermediator.helper;

import com.alibaba.fastjson.JSONObject;
import java.util.Objects;
import pet.hospital.backend.intermediator.constant.Constants;

public class ResponseHelper {

    public static ResponseData<JSONObject> forwardResponseDataDirectly(JSONObject apiRes) {
        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }
}
