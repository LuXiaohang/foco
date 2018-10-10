package cornell.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class FoodComment {
    @Id
    @GeneratedValue
    private Long id;

    private Long foodId;
    private String comment;
    private Timestamp time;

    public FoodComment(){}

    public FoodComment(Long foodId, String comment) {
        this.foodId = foodId;
        this.comment = comment;
        this.time = new Timestamp(System.currentTimeMillis());
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "FoodComment{" +
                "id=" + id +
                ", foodId=" + foodId +
                ", comment='" + comment + '\'' +
                ", time=" + time +
                '}';
    }
}
