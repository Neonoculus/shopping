package domain;

public class Cart {
    private int g_id;
    private int b_id;
    private int count;
    private Double money;
    private int status;

    public Cart(int g_id, int b_id, int count, Double money, int status) {
        this.g_id = g_id;
        this.b_id = b_id;
        this.count = count;
        this.money = money;
        this.status = status;
    }

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "g_id=" + g_id +
                ", b_id=" + b_id +
                ", count=" + count +
                ", money=" + money +
                ", status=" + status +
                '}';
    }
    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
