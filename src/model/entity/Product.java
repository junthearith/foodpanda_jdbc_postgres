package model.entity;

import java.sql.Date;

public class Product {
    private Integer id;
    private String productName;
    private String productCode;
    private boolean isDeleted;
    private Date importedDate;
    private Date expiredDate;
    private String description;

    public Product() {
    }

    public Product(Integer id, String productName, String productCode, boolean isDeleted, Date importedDate, Date expiredDate, String description) {
        this.id = id;
        this.productName = productName;
        this.productCode = productCode;
        this.isDeleted = isDeleted;
        this.importedDate = importedDate;
        this.expiredDate = expiredDate;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getImportedDate() {
        return importedDate;
    }

    public void setImportedDate(Date importedDate) {
        this.importedDate = importedDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
