package domain;

public class Like {
    private int g_id;
    private int b_id;

    public Like(int g_id, int b_id) {
        this.g_id = g_id;
        this.b_id = b_id;
    }

    public Like() {
    }

    @Override
    public String toString() {
        return "Like{" +
                "g_id=" + g_id +
                ", b_id=" + b_id +
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
}
