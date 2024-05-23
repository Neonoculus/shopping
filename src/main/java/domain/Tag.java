package domain;

public class Tag {
    private int t_id;
    private String name;

    public Tag(int t_id, String name) {
        this.t_id = t_id;
        this.name = name;
    }

    public Tag() {
    }

    @Override
    public String toString() {
        return "Tag{" +
                "t_id=" + t_id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
