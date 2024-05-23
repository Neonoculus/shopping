package domain;

public class GoodsTag {
    private int t_id;
    private int g_id;

    public GoodsTag(int t_id, int g_id) {
        this.t_id = t_id;
        this.g_id = g_id;
    }

    public GoodsTag() {
    }

    @Override
    public String toString() {
        return "GoodsTag{" +
                "t_id=" + t_id +
                ", g_id=" + g_id +
                '}';
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }
}
