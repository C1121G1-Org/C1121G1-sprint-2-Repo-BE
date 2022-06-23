package api.dto;

public class ChargeMoneyDto {
   private String guestId;

    public String getId() {
        return guestId;
    }

    public void setId(String guestId) {
        this.guestId = guestId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;
}
