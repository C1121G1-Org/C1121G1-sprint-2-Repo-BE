package api.dto;

public class ChargeMoneyDto {
   private String guestId;
    public ChargeMoneyDto() {
    }
    public ChargeMoneyDto(String guestId, String value) {
        this.guestId = guestId;
        this.value = value;
    }

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
