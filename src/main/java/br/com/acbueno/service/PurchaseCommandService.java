package br.com.acbueno.service;

import br.com.acbueno.dto.PurchaseRequestDTO;
import br.com.acbueno.dto.PurchaseResponseDTO;

public interface PurchaseCommandService {

    PurchaseResponseDTO createPurchaseDTO(PurchaseRequestDTO purchaseDTO);

    void cancelPurchaseDTO(Long idPurchase);

}
