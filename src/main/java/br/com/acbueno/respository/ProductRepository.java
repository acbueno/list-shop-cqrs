package br.com.acbueno.respository;

import java.util.List;

import br.com.acbueno.entity.Product;
import br.com.acbueno.respository.exceptions.RepositoryException;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {

    public List<Product> findAllProduct() {
       return listAll();
    }

    public List<Product> findProductByBrandName(String brandName) {
        try {
            return find("brandName", brandName).list();
        } catch (Exception e) {
            throw new NotFoundException(String.format("Not found product by brand name: %s", brandName));
        }
    }

    @Transactional
    public void deleteByBrandName(String brandName) {
        try {
            Product firstResult = find("brandName", brandName).firstResult();
            delete(firstResult);
        } catch (Exception e) {
            throw new NotFoundException(String.format("Not found brandName: %s", brandName));
        }
    }

    @Transactional
    public Product save(Product product) throws RepositoryException {
        try {
            persist(product);
        } catch (Exception e) {
            throw new RepositoryException(String.format("Error persist data exception: %s", e.getMessage()));
        }
        return product;
    }

    public List<Product> listProductByPruchaseId(Long id) {
        try {
            return list("id", id);
        } catch (Exception e) {
            throw new NotFoundException(String.format("Not found product by id: %s", id));
        }
    }

}
