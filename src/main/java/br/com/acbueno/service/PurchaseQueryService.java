package br.com.acbueno.service;

import java.time.LocalDate;
import java.util.List;

import br.com.acbueno.dto.PurchaseResponseDTO;

public interface PurchaseQueryService {

    PurchaseResponseDTO getPurchaseById(Long id);

    List<PurchaseResponseDTO> getPurchaseByDate(String localDate);

    List<PurchaseResponseDTO> getAllPurchase();



}
