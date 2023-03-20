package pet.hospital.backend.intermediator.helper;

import java.util.Date;
import java.util.Objects;

public class ValueHelper {

    private static String defaultStringValue = "This field is currently Empty.";

    private static int defaultIntValue = -1;

    private static Date defaultDateValue = null;

    public static String setNullableValue(String value) {
        return Objects.equals(value, null) ? ValueHelper.defaultStringValue : value;
    }

    public static int setNullableValue(Integer value) {
        return Objects.equals(value, null) ? ValueHelper.defaultIntValue : value;
    }

    public static Date setNullableValue(Date value) {
        return Objects.equals(value, null) ? ValueHelper.defaultDateValue : value;
    }
}
