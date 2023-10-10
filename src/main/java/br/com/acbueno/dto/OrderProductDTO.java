package br.com.acbueno.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderProductDTO {

    @JsonProperty("brand_name")
    private String brandName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("amount")
    private int amount;

    @JsonProperty("price")
    private Double price;

}
