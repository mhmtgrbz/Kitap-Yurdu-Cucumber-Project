package techproed.pojo;

public class EdebiyatKitaplariPojo {

    private int id;
    private String isim;

    public EdebiyatKitaplariPojo() {
    }

    public EdebiyatKitaplariPojo(int id, String isim) {
        this.id = id;
        this.isim = isim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    @Override
    public String toString() {
        return "EdebiyatKitaplariPojo{" +
                "id=" + id +
                ", isim='" + isim + '\'' +
                '}';
    }
}
