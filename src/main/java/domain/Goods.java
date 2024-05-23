package domain;

public class Goods {
    private int g_id;
    private int c_id;
    private int m_id;
    private String name;
    private String photo;
    private Double price;
    private String describe;
    private int status;

    public Goods(int g_id, int c_id, int m_id, String name, String photo, Double price, String describe, int status) {
        this.g_id = g_id;
        this.c_id = c_id;
        this.m_id = m_id;
        this.name = name;
        this.photo = photo;
        this.price = price;
        this.describe = describe;
        this.status = status;
    }

    public Goods() {
    }

    @Override
    public String toString() {
        return "Goods{" +
                "g_id=" + g_id +
                ", c_id=" + c_id +
                ", m_id=" + m_id +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", price=" + price +
                ", describe='" + describe + '\'' +
                ", status=" + status +
                '}';
    }

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
