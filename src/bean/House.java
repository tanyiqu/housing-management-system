package bean;

/**
 * 房源类
 */
public class House {
    private String houseId;
    private String host;
    private String houseName;
    private String type;
    private int area;
    private String year;
    private String addr;
    private String room;
    private int price;
    private boolean soldout;


    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSoldout() {
        return soldout;
    }

    public void setSoldout(boolean soldout) {
        this.soldout = soldout;
    }

    @Override
    public String toString() {
        return "House{" +
                "houseId='" + houseId + '\'' +
                ", host='" + host + '\'' +
                ", houseName='" + houseName + '\'' +
                ", type='" + type + '\'' +
                ", area=" + area +
                ", year='" + year + '\'' +
                ", addr='" + addr + '\'' +
                ", room='" + room + '\'' +
                ", price=" + price +
                ", soldout=" + soldout +
                '}';
    }
}
