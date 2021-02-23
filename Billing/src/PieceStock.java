import java.util.List;

public class PieceStock {

    int count,id;
    float rate;
    double tax;
    Integer size;
    String design;
    String material;
    String name;

    public PieceStock(int count, double tax, int id, float rate, Integer size, String design, String material, String name) {
        this.count = count;
        this.tax = tax;
        this.id = id;
        this.rate = rate;
        this.size = size;
        this.design = design;
        this.material = material;
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
