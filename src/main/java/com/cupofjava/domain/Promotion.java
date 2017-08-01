//package com.cupofjava.domain;
//
//import org.hibernate.validator.constraints.Range;
//import org.springframework.beans.factory.annotation.Value;
//
//import javax.persistence.*;
//import javax.validation.constraints.*;
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.util.Date;
//
//@Entity
//public class Promotion {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long promID;
//    private Product product;
//    @Future
//    private Date dateFrom;  // wybrac odpowiedni typ daty, aby sie dobrze parsował w thymeleafie lub czymś innym.
//    @Future
//    private Date dateTo;
//    @DecimalMax("100.0") @DecimalMin("0.0")
//    private double discount;
//    private BigDecimal promotionalPrice;
//
//
//    public Promotion(Product product, Date dateFrom, Date dateTo, double discount) {
//        this.product = product;
//        this.dateFrom = dateFrom;
//        this.dateTo = dateTo;
//        this.discount = discount;
//        this.promotionalPrice = CountPromotionalPrice(discount, product.getPrice());
//    }
//
//    public Promotion() {
//    }
//
//
//    private static BigDecimal CountPromotionalPrice(double discount, BigDecimal price){
//         BigDecimal promotionalPrice  = price.multiply(new BigDecimal(discount));
//         return promotionalPrice;
//    }
//
//    public Long getPromID() {
//        return promID;
//    }
//
//    public void setPromID(Long promID) {
//        this.promID = promID;
//    }
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id")
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public Date getDateFrom() {
//        return dateFrom;
//    }
//
//    public void setDateFrom(Date dateFrom) {
//        this.dateFrom = dateFrom;
//    }
//
//    public Date getDateTo() {
//        return dateTo;
//    }
//
//    public void setDateTo(Date dateTo) {
//        this.dateTo = dateTo;
//    }
//
//    public double getDiscount() {
//        return discount;
//    }
//
//    public void setDiscount(double discount) {
//        this.discount = discount;
//    }
//
//    public BigDecimal getPromotionalPrice() {
//        return promotionalPrice;
//    }
//
//    public void setPromotionalPrice(BigDecimal promotionalPrice) {
//        this.promotionalPrice = promotionalPrice;
//    }
//}
