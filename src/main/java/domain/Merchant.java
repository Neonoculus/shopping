package domain;

public class Merchant {
    private int m_id;
    private String name;
    private String phone;
    private String address;
    private String email;
    private String photo;
    private String note;

    public Merchant(int m_id, String name, String phone, String address,String email,String photo,String note) {
        this.m_id = m_id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email =email;
        this.photo = photo;
        this.note = note;
    }

    public Merchant() {
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "m_id=" + m_id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                ", note='" + note + '\'' +
                '}';
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
