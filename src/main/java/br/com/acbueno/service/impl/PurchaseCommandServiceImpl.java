package br.com.acbueno.service.impl;

import java.time.LocalDate;
import java.util.List;
import org.jboss.logging.Logger;
import br.com.acbueno.dto.PurchaseRequestDTO;
import br.com.acbueno.dto.PurchaseResponseDTO;
import br.com.acbueno.entity.Product;
import br.com.acbueno.entity.Purchase;
import br.com.acbueno.respository.ProductRepository;
import br.com.acbueno.respository.PurchaseRespository;
import br.com.acbueno.respository.exceptions.RepositoryException;
import br.com.acbueno.service.PurchaseCommandService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PurchaseCommandServiceImpl implements PurchaseCommandService {

    @Inject
    private PurchaseRespository purchaseRespository;

    @Inject
    private ProductRepository productRepository;

    private static final Logger LOGGER = Logger.getLogger(PurchaseCommandServiceImpl.class);

    @Override
    public PurchaseResponseDTO createPurchaseDTO(PurchaseRequestDTO purchaseDTO) {
        Purchase purchase = Purchase.builder().datePurchase(LocalDate.now())
                .namePurchase(purchaseDTO.getNamePurchase())
                .build();

        try {
            purchaseRespository.save(purchase);
        } catch (RepositoryException e) {
            LOGGER.error(String.format("Error persist data :%s", e.getMessage()));
        }

        return PurchaseResponseDTO.convert(purchase);
    }

    @Override
    public void cancelPurchaseDTO(Long idPurcchase) {
        Purchase purchase = purchaseRespository.findById(idPurcchase);
        List<Product> listProductByPruchaseId = productRepository.listProductByPruchaseId(idPurcchase);
        deleteProductReferencesPurchase(purchase, listProductByPruchaseId);
    }

    @Transactional
    protected void deleteProductReferencesPurchase(Purchase purchase, List<Product> listProductByPruchaseId) {
        for (Product product : listProductByPruchaseId) {
             productRepository.deleteById(product.getId());
        }

        purchaseRespository.delete(purchase);
    }

}
