package com.cupofjava.commands;

//import com.cupofjava.domain.ProductFeature;

import java.math.BigDecimal;

    public class ProductForm {
        private Long _id;
        private String description;
        private BigDecimal price;
        private String imageUrl;
//        private ProductFeature productFeature;

        public Long getId() {
            return _id;
        }

        public void setId(Long id) {
            this._id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
//
//        public ProductFeature getProductFeature() {
//            return productFeature;
//        }
//
//        public void setProductFeature(ProductFeature productFeature) {
//            this.productFeature = productFeature;
//        }
    }


