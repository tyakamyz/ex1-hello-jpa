package hellojpa;

import javax.persistence.*;

@Entity
@DiscriminatorColumn
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {
    @Id @GeneratedValue
    private long id;

    private String name;
    private long price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
