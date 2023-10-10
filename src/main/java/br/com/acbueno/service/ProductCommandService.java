package br.com.acbueno.service;

import br.com.acbueno.dto.ProductRequestDTO;
import br.com.acbueno.dto.ProductResponseDTO;

public interface ProductCommandService {

    Boolean cancelProductByBrandName(String brandName);

    ProductResponseDTO createProduct(ProductRequestDTO productDTO);



}
