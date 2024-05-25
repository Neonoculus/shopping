package domain;

public class Buyer {
    private int b_id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String photo;

    public Buyer(int b_id, String name, String email, String address, String phone,String photo) {
        this.b_id = b_id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.photo = photo;
    }

    public Buyer() {
    }

    @Override
    public String toString() {
        return "buyer{" +
                "b_id=" + b_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
