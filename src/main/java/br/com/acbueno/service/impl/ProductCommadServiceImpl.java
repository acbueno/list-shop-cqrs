package br.com.acbueno.service.impl;

import org.jboss.logging.Logger;

import br.com.acbueno.dto.ProductRequestDTO;
import br.com.acbueno.dto.ProductResponseDTO;
import br.com.acbueno.entity.Product;
import br.com.acbueno.entity.Purchase;
import br.com.acbueno.respository.ProductRepository;
import br.com.acbueno.respository.PurchaseRespository;
import br.com.acbueno.service.ProductCommandService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProductCommadServiceImpl implements ProductCommandService {

    @Inject
    ProductRepository productRepository;

    @Inject
    PurchaseRespository purchaseRespository;

    private static final Logger LOGGER = Logger.getLogger(ProductCommadServiceImpl.class);

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productResquestDTO) {
        Product newProduct = null;
        ProductResponseDTO productResponseDTO = null;
        try {
            Double totalPrice = (productResquestDTO.getPrice() * productResquestDTO.getAmount());
            Purchase findById = purchaseRespository.findById(productResquestDTO.getPurchaseId());
            newProduct = Product.builder()
                    .brandName(productResquestDTO.getBrandName())
                    .description(productResquestDTO.getDescription())
                    .amount(productResquestDTO.getAmount())
                    .price(productResquestDTO.getPrice())
                    .totalPrice(totalPrice)
                    .purchase(findById)
                    .build();
            productRepository.save(newProduct);

           productResponseDTO = ProductResponseDTO.convert(newProduct);

        } catch (Exception e) {
           LOGGER.error(String.format("Error persist data: %s", e.getMessage()));
        }

        return productResponseDTO;
    }

    @Override
    public Boolean cancelProductByBrandName(String name) {
        try {
            productRepository.deleteByBrandName(name);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
