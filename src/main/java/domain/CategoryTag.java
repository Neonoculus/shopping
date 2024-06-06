package domain;

public class CategoryTag {
    private int c_id;
    private int t_id;

    public CategoryTag(int c_id, int t_id) {
        this.c_id = c_id;
        this.t_id = t_id;
    }

    public CategoryTag() {
    }

    @Override
    public String toString() {
        return "CategoryTag{" +
                "c_id=" + c_id +
                ", t_id=" + t_id +
                '}';
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }
}
