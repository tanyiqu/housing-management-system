package bean;

/**
 * 买方登记卡
 */
public class BuyerCard {
    private String name;
    private int price;
    private String date;
    private String hostname;
    private String hosttel;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getHosttel() {
        return hosttel;
    }

    public void setHosttel(String hosttel) {
        this.hosttel = hosttel;
    }

}
