package br.com.acbueno.service.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.acbueno.dto.ProductResponseDTO;
import br.com.acbueno.entity.Product;
import br.com.acbueno.respository.ProductRepository;
import br.com.acbueno.service.ProductQueryService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProductQueryServiceImpl implements ProductQueryService {

    @Inject
    ProductRepository productRepository;

    @Override
    public ProductResponseDTO getProductById(Long id) {
        return ProductResponseDTO.convert(productRepository.findById(id));
    }

    @Override
    public List<ProductResponseDTO> getAllProduct() {
        List<ProductResponseDTO> listProductResponseDTOs = new ArrayList<>();
        List<Product> listAllProduct = productRepository.listAll();

        for (Product product : listAllProduct) {
            listProductResponseDTOs.add(ProductResponseDTO.convert(product));
        }

        return listProductResponseDTOs;
    }

    @Override
    public List<ProductResponseDTO> getProductsByBrandName(String brandName) {
        List<ProductResponseDTO> listProductResponseDTO = new ArrayList<>();
        productRepository.findProductByBrandName(brandName).forEach( it -> {
            listProductResponseDTO.add(ProductResponseDTO.convert(it));
        });

        return  listProductResponseDTO;
    }

}
