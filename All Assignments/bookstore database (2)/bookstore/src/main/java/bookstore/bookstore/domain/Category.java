package bookstore.bookstore.domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryid;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Bookstore> bookstores;

    public Category() {
    }

    public Category(String name) {
        super();
        this.name = name;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bookstore> getBookstores() {
        return bookstores;
    }

    public void setBookstores(List<Bookstore> bookstores) {
        this.bookstores = bookstores;
    }

    @Override
    public String toString() {
        return "Category [categoryid=" + categoryid + ", name=" + name + "]";
    }

}
