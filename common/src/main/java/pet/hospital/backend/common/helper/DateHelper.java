/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-20 18:14:55
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-22 21:39:24
 * @FilePath: /virtualPetHospital-backend/common/src/main/java/pet/hospital/backend/common/helper/DateHelper.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.common.helper;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import pet.hospital.backend.common.constant.Constants;

public class DateHelper {
    public static Date stringToDate(String javaDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return sdf.parse(URLDecoder.decode(javaDate, Constants.UTF8));
        } catch (Exception e) {
            return null;
        }
    }
}
