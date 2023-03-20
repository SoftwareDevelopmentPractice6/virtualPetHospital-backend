package pet.hospital.backend.common.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    public static Date stringToDate(String javaDate) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        
        try {
            return sdf.parse(javaDate);
        } catch (Exception e) {
            return null;
        }
    }
}
