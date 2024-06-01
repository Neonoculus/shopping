package domain;

import java.util.Date;

public class Order {
    private long o_id;
    private Double money;
    private Date startTime;
    private Date endTime;
    private int b_id;
    private String name;
    private String phone;
    private String address;
    private int status;

    public Order(long o_id,int b_id,String name,String phone,String address, Double money, Date startTime, Date endTime,int status) {
        this.o_id = o_id;
        this.b_id = b_id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.money = money;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "o_id=" + o_id +
                ", money=" + money +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", b_id=" + b_id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }

    public long getO_id() {
        return o_id;
    }

    public void setO_id(long o_id) {
        this.o_id = o_id;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
