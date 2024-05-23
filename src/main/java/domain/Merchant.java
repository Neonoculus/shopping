package domain;

public class Merchant {
    private int m_id;
    private String name;
    private String phone;
    private String address;

    public Merchant(int m_id, String name, String phone, String address) {
        this.m_id = m_id;
        this.name = name;
        this.phone = phone;
        this.address = address;
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
}
