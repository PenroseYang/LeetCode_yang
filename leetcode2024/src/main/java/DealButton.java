import java.io.Serializable;
import java.util.Objects;

/**
 * @author yangzhe14
 * @since 2023/12/28
 */
public class DealButton implements Serializable {

    private static final long serialVersionUID = -9059238552685688359L;

    /**
     * 立即抽奖
     */
    private String content;

    /**
     * 是否能点击
     */
    private Integer canClick;

    /**
     * 如果抽奖有问题，点击之后弹出toast
     */
    private String toast;

    public boolean canClick() {
        return Objects.equals(canClick, 1);
    }

    private DealButton(String content, Integer canClick, String toast) {
        this.content = content;
        this.canClick = canClick;
        this.toast = toast;
    }

    public static DealButtonBuilder builder() {
        return new DealButtonBuilder();
    }

    public static class DealButtonBuilder {
        private String content;
        private Integer canClick;
        private String toast;

        public DealButtonBuilder content(String content) {
            this.content = content;
            return this;
        }

        public DealButtonBuilder canClick(boolean canClick) {
            if (canClick) {
                this.canClick = ButtonCanClickEnum.CAN_CLICK.getCode();
            } else {
                this.canClick = ButtonCanClickEnum.CAN_NOT_CLICK.getCode();
            }
            return this;
        }

        public DealButtonBuilder toast(String toast) {
            this.toast = toast;
            return this;
        }

        public DealButton build() {
            return new DealButton(content, canClick, toast);
        }
    }
}