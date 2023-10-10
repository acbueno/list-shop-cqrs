package br.com.acbueno.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductRequestDTO {

    @JsonProperty("brand-name")
    private String brandName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("amount")
    private int amount;

    @JsonProperty("price")
    private double price;

    @JsonProperty("purchase_id")
    private long purchaseId;

}
