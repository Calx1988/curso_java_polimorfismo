package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
    private Date manufactureDate;

    public UsedProduct() {
        super();
    }

    public UsedProduct(String name, Double price, Date manufacturedDate) {
        super(name, price);
        this.manufactureDate = manufacturedDate;
    }

    public Date getManufacturedDate() {
        return manufactureDate;
    }

    public void setManufacturedDate(Date manufacturedDate) {
        this.manufactureDate = manufacturedDate;
    }

    @Override
    public String priceTag(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return getName()+ " (used) $" +String.format("%.2f",getPrice())+ " (Manufacture date: " +sdf.format(manufactureDate)+")";
    }
}
