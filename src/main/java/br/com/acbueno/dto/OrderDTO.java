package br.com.acbueno.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {

    @JsonProperty("item")
    private List<OrderProductDTO> orderProductDTO;

    @JsonProperty("total-price")
    private Double totalPrice;


}
