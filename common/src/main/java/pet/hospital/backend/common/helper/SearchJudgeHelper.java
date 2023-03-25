/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-20 17:23:45
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-24 20:56:39
 * @FilePath: /virtualPetHospital-backend/common/src/main/java/pet/hospital/backend/common/helper/JudgeHelper.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.common.helper;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.Objects;
import pet.hospital.backend.common.constant.Constants;

public class SearchJudgeHelper {

    /**
     *
     * @param toBeJudged      Value to be judged.
     * @param referencedValue Value of reference, aka value to be compared to.
     * @return If toBeJudged is null, then return true; otherwise, return toBeJudged
     *         == referencedValue.
     */
    public static Boolean softEquals(Integer toBeJudged, int referencedValue) {
        return Objects.equals(toBeJudged, null) ? true : Objects.equals(referencedValue, toBeJudged);
    }

    public static Boolean softEquals(Double toBeJudged, double referencedValue) {
        return Objects.equals(toBeJudged, null) ? true : Objects.equals(referencedValue, toBeJudged);
    }

    public static Boolean softEquals(Character toBeJudged, char referencedValue) {
        return Objects.equals(toBeJudged, null) ? true : Objects.equals(referencedValue, toBeJudged);
    }

    public static Boolean softEquals(String toBeJudged, String referencedValue) {
        try {
            return (Objects.equals(toBeJudged, null) || Objects.equals(toBeJudged, ""))
                    ? true
                    : Objects.equals(referencedValue, URLDecoder.decode(toBeJudged, Constants.UTF8));
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    public static Boolean softEquals(Date toBeJudged, Date referencedValue) {
        return Objects.equals(toBeJudged, null) ? true : Objects.equals(referencedValue, toBeJudged);
    }

    /**
     *
     * @param child  Value to be judged.
     * @param parent Value of reference.
     * @return If child is null or empty string, then return true; otherwise, return
     *         whether parent includes child.
     */
    public static Boolean softIncludes(String child, String parent) {
        child = (Objects.equals(child, null) || Objects.equals(child, "")) ? "" : child;
        try {
            return !Objects.equals(parent.indexOf(URLDecoder.decode(child, Constants.UTF8)), -1);
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }
}
