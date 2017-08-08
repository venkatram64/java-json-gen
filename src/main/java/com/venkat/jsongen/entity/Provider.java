package com.venkat.jsongen.entity;

/**
 * Created by venkatram.veerareddy on 8/8/2017.
 */
public class Provider {

    private String providerId;
    private String providerName;
    private Product product;

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
