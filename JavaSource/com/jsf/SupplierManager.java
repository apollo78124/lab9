package com.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Handle CRUD actions for Supplier class.
 * 
 * @author blink
 * @version 1.0
 * 
 */
@Dependent
@Stateless
public class SupplierManager implements Serializable {
    private static final long serialVersionUID = 1L;
    @PersistenceContext(unitName="inventory-jpa") EntityManager em;

    /**
     * Find Supplier record from database.
     * 
     * @param id primary key of supplier record.
     * @return the Supplier record with key = id, null if not found.
     */
    public Supplier find(int id) {
        return em.find(Supplier.class, id);
    }
    
    /**
     * Find Supplier record from database.
     * 
     * @param id primary key of supplier record.
     * @return the Supplier record with key = id, null if not found.
     */
    public List<Supplier> findByName(String name) {
        
        String sql = "SELECT p FROM Supplier p where p.supplierName LIKE :fname";

        TypedQuery<Supplier> query = em.createQuery(sql , Supplier.class);
        query.setParameter("fname","%"+name+"%");
        return query.getResultList();
    }
    
    

    /**
     * Persist Supplier record into database.  id must be unique.
     * @param supplier the record to be persisted.
     */

    public void persist(Supplier supplier) {
        em.persist(supplier);
    }
    
    /**
     * merge Supplier record fields into existing database record.
     * @param supplier the record to be merged.
     */
    public void merge(Supplier supplier) {
        em.merge(supplier);
    }
/**
 * Remove supplier from database.
 * @param supplier record to be removed from database
 */
    public void remove(Supplier supplier) {
        //attach supplier
        supplier = find(supplier.getId());
        em.remove(supplier);
    }

/**
     * Return Suppliers table as array of Supplier.
     * @return Supplier[] of all records in Suppliers table
     */
    
    public List<Supplier> getAll() {
        TypedQuery<Supplier> query = em.createQuery("select s from Supplier s",
                Supplier.class); 
        List<Supplier> suppliers = query.getResultList();
        
        return suppliers;
    }
}
