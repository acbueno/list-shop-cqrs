package br.com.acbueno.respository;

import java.time.LocalDate;
import java.util.List;

import br.com.acbueno.entity.Purchase;
import br.com.acbueno.respository.exceptions.RepositoryException;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PurchaseRespository implements PanacheRepository<Purchase> {

    public List<Purchase> listAllShopping(){
        return listAll();
    }

    public List<Purchase> findPurchaseByDate(LocalDate date) {
        try {
            return find("datePurchase", date).list();
        } catch (Exception e) {
            throw new NotFoundException(String.format("Not found purchase by date :%s", date));
        }
    }

    @Transactional
    public Purchase save(Purchase purchase) throws RepositoryException {
        try {
             persist(purchase);
        } catch (Exception e) {
            throw new RepositoryException(String.format("Error persist Purchase :%", e.getMessage()));
        }
        return purchase;
    }

    @Transactional
    public void deletePurchase(Long id) throws RepositoryException {
        try {
            Purchase findById = findById(id);
            delete(findById);
        } catch (Exception e) {
            throw new RepositoryException(String.format("Cannot find id Purchase: %s", e.getMessage()));
        }
    }

}
