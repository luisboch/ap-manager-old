package com.apmanager.domain.dao.impl;

import com.apmanager.domain.dao.GenericDAO;
import com.apmanager.domain.entity.Product;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author luis
 */
public class ProductDAO extends GenericDAO<Product> {

    public ProductDAO(EntityManager em) {
        super(em);
    }
    
    @Override
    public List<Product> search(String search) {
        String sql = "select p from Product p";
        Query q = em.createQuery(sql);
        return q.getResultList();
    }

    @Override
    public void save(Product object) {
        object.setRegisterDate(new Date());
        super.save(object);
    }
    
    
    
}