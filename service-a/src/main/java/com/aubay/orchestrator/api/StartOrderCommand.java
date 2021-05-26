package com.aubay.orchestrator.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class StartOrderCommand implements Serializable {

    @NotBlank
    private String name;

    @NotBlank
    private String product;

    @NotNull
    private Long quantity;

    public StartOrderCommand() {
    }

    public StartOrderCommand(String name, String product, Long quantity) {
        this.name = name;
        this.product = product;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
