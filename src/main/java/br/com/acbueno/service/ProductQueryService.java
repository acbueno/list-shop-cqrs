package br.com.acbueno.service;

import java.util.List;

import br.com.acbueno.dto.ProductResponseDTO;

public interface ProductQueryService {

    ProductResponseDTO getProductById(Long id);

    List<ProductResponseDTO> getAllProduct();

    List<ProductResponseDTO> getProductsByBrandName(String brandName);

}
