package domain;

import java.util.Date;

public class Order {
    private int o_id;
    private Double money;
    private Date startTime;
    private Date endTime;

    public Order(int o_id, Double money, Date startTime, Date endTime) {
        this.o_id = o_id;
        this.money = money;
        this.startTime = startTime;
        this.endTime = endTime;
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
                '}';
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
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
