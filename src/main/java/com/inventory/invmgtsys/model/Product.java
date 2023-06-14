package com.inventory.invmgtsys.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="product_tbl")
public class Product {
    @Id
    @SequenceGenerator(name = "product_sequence",sequenceName = "product_sequence",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "product_sequence",strategy =GenerationType.SEQUENCE)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name ="image")
    private String image;

    @Column(name="added_date")
    private String addedDate;

    @Column(name = "status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name ="category_id")
    private Category category;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}