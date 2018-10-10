package cornell.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class FoodInfo {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String foodType;
    private String location;
    private String description;
    private String img;
    private Timestamp time;

    public FoodInfo(){}

    public FoodInfo(String name, String foodType, String location, String description, String img) {
        this.name = name;
        this.foodType = foodType;
        this.location = location;
        this.description = description;
        this.img = img;
        this.time = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "FoodInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foodType='" + foodType + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                ", time=" + time +
                '}';
    }
}
