package Tutorial.Models;
import javax.persistence.Embeddable;
// import javax.validation.constraints.NotNull;
// import javax.validation.constraints.Size;

@Embeddable
public class Address {
    
    private String city;
    private String subCity;
    private String woreda;
    private String kebele;
    private String houseNumber;


    public Address() {

    }


    public Address(String city, String subCity, String woreda, String kebele, String houseNumber) {
        this.city = city;
        this.subCity = subCity;
        this.woreda = woreda;
        this.kebele = kebele;
        this.houseNumber = houseNumber;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public String getSubCity() {
        return subCity;
    }


    public void setSubCity(String subCity) {
        this.subCity = subCity;
    }


    public String getWoreda() {
        return woreda;
    }


    public void setWoreda(String woreda) {
        this.woreda = woreda;
    }


    public String getKebele() {
        return kebele;
    }


    public void setKebele(String kebele) {
        this.kebele = kebele;
    }


    public String getHouseNumber() {
        return houseNumber;
    }


    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    

   
}
