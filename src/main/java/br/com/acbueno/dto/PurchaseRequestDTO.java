package br.com.acbueno.dto;

import java.time.LocalDate;
import org.modelmapper.ModelMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.acbueno.entity.Purchase;
import lombok.Data;

@Data
public class PurchaseRequestDTO {

    @JsonProperty("name-purchase")
    private String namePurchase;

    @JsonProperty("date-purchase")
    private LocalDate datePurchase;

    public static PurchaseRequestDTO convert(Purchase purchase) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(purchase, PurchaseRequestDTO.class);
    }

}
