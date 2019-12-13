package bean;

/**
 * 卖方登记卡
 */
public class SellerCard {
    private String id;
    private String name;
    private int price;
    private String soldout;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSoldout() {
        return soldout;
    }

    public void setSoldout(String soldout) {
        this.soldout = soldout;
    }
}
