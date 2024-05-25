package domain;

public class OrderDetails {
    private int g_id;
    private long o_id;
    private int count;
    private Double money;

    public OrderDetails(int g_id, long o_id, int count, Double money) {
        this.g_id = g_id;
        this.o_id = o_id;
        this.count = count;
        this.money = money;
    }

    public OrderDetails() {
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "g_id=" + g_id +
                ", o_id=" + o_id +
                ", count=" + count +
                ", money=" + money +
                '}';
    }

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public long getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
