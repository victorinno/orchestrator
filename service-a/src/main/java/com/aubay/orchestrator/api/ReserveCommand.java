package com.aubay.orchestrator.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ReserveCommand implements Serializable {
    @NotBlank
    private String product;

    @NotNull
    private Long quantity;

    public ReserveCommand() {
    }

    public ReserveCommand(String product, Long quantity) {
        this.product = product;
        this.quantity = quantity;
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
