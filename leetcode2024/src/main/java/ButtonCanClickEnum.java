/**
 * @author yangzhe14
 * @since 2024/8/20
 */
public enum ButtonCanClickEnum {
    CAN_CLICK(1, "可以点击"),
    CAN_NOT_CLICK(0, "不可以点击"),
    ;

    private final Integer code;
    private final String message;


    ButtonCanClickEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

}