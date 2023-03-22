/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-15 23:37:18
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-21 14:32:29
 * @FilePath: /virtualPetHospital-backend/intermediator/src/main/java/pet/hospital/backend/intermediator/enumTypes/EnumCode.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.intermediator.helper;

public enum EnumCode {
    SUCCESS(200, "ok"),

    AUTHORITY_ERROR(401, "Unauthorized"),

    REQUEST_ERROR(515, "Request failed"),

    INTERNAL_ERROR(500, "Server internal error"),

    FILE_EMPTY_ERROR(431, "File empty error"),

    FILE_TRANSFER_ERROR(430, "File transfer error");

    private int code; // 状态码
    private String message; // 描述

    private EnumCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static EnumCode getEnumCodeType(int code) {
        switch (code) {
            case 200:
                return EnumCode.SUCCESS;
            case 401:
                return EnumCode.AUTHORITY_ERROR;
            case 515:
                return EnumCode.REQUEST_ERROR;
            default:
                return EnumCode.INTERNAL_ERROR;
        }
    }
}
