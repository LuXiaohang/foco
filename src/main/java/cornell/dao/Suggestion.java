package cornell.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Suggestion {
    @Id
    @GeneratedValue
    private Long id;

    private String ssuggestion;

    public Suggestion(){}

    public Suggestion(String ssuggestion) {
        this.ssuggestion = ssuggestion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsuggestion() {
        return ssuggestion;
    }

    public void setSsuggestion(String ssuggestion) {
        this.ssuggestion = ssuggestion;
    }

    @Override
    public String toString() {
        return "Suggestion{" +
                "id=" + id +
                ", ssuggestion='" + ssuggestion + '\'' +
                '}';
    }
}
