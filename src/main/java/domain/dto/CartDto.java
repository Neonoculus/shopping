package domain.dto;

import domain.Cart;



public class CartDto extends Cart {

    private String name;
    private String photo;

    public CartDto(int g_id, int b_id, int count, Double money, int status, String name, String photo) {
        super(g_id, b_id, count, money, status);
        this.name = name;
        this.photo = photo;
    }

    public CartDto() {
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "g_id=" + getG_id() +
                ", b_id=" + getB_id() +
                ", count=" + getCount() +
                ", money=" + getMoney() +
                ", status=" + getStatus() +
                "name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                '}';
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
}
