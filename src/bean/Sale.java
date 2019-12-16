package bean;

/**
 * 出售记录
 */
public class Sale {
    private String buyer_username;
    private String buyer_truename;
    private String houseId;
    private String housename;
    private int price;
    private String date;

    public String getBuyer_username() {
        return buyer_username;
    }

    public void setBuyer_username(String buyer_username) {
        this.buyer_username = buyer_username;
    }

    public String getBuyer_truename() {
        return buyer_truename;
    }

    public void setBuyer_truename(String buyer_truename) {
        this.buyer_truename = buyer_truename;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getHousename() {
        return housename;
    }

    public void setHousename(String housename) {
        this.housename = housename;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
