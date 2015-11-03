package com.gmaslowski.sdp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static javax.persistence.CascadeType.ALL;

@Entity
public class Basket {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = ALL)
    private List<BasketItem> basketItemList = newArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<BasketItem> getBasketItemList() {
        return basketItemList;
    }

    public void setBasketItemList(List<BasketItem> basketItemList) {
        this.basketItemList = basketItemList;
    }

    public void addProduct(Product product, Long quantity) {
        basketItemList.add(new BasketItem(product, quantity));
    }
}
