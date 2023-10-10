package br.com.acbueno.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.acbueno.dto.PurchaseResponseDTO;
import br.com.acbueno.entity.Purchase;
import br.com.acbueno.respository.PurchaseRespository;
import br.com.acbueno.service.PurchaseQueryService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PurchaseQueryServieImpl implements PurchaseQueryService {

    @Inject
    private PurchaseRespository purchaseRespository;

    @Override
    public PurchaseResponseDTO getPurchaseById(Long id) {
        return PurchaseResponseDTO.convert(purchaseRespository.findById(id));
    }

    @Override
    public List<PurchaseResponseDTO> getPurchaseByDate(String date) {
        //@formatter:off
        LocalDate localDate = convertStringDateToLocalDate(date);
        List<PurchaseResponseDTO> listPurchaseResponseDTOs = new ArrayList<>();
        purchaseRespository.findPurchaseByDate(localDate).forEach(it ->
            listPurchaseResponseDTOs.add(PurchaseResponseDTO.convert(it)));
        //@formatter:on
        return listPurchaseResponseDTOs;
    }

    private LocalDate convertStringDateToLocalDate(String date) {
        Date dateFormatt = null;
        try {
            dateFormatt = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        LocalDate localDate = dateFormatt.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDate();
        return localDate;
    }

    @Override
    public List<PurchaseResponseDTO> getAllPurchase() {
        //@formatter:off
        List<PurchaseResponseDTO> listPurchaseDTO = new ArrayList<>();
        purchaseRespository.listAll().forEach(it ->
            listPurchaseDTO.add(PurchaseResponseDTO.convert(it)));
        //@formatter:on
        return listPurchaseDTO;
    }

}
