package br.com.acbueno.dto;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.acbueno.entity.Product;
import br.com.acbueno.entity.Purchase;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class ProductResponseDTO {

    @JsonProperty("brand_name")
    private String brandName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("amount")
    private int amount;

    @JsonProperty("price")
    private double price;

    @JsonProperty("purchase")
    private PurchaseRequestDTO purchase;

    @JsonProperty("total-price")
    private double totalPrice;

    public static ProductResponseDTO convert(Product product) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(product, ProductResponseDTO.class);
    }

}
