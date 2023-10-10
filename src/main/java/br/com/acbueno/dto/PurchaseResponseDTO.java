package br.com.acbueno.dto;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.acbueno.entity.Purchase;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class PurchaseResponseDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name-purchase")
    private String namePurchase;

    @JsonProperty("data-purchase")
    private LocalDate datePurchase;

    public static PurchaseResponseDTO convert(Purchase purchase) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(purchase, PurchaseResponseDTO.class);
    }

}
