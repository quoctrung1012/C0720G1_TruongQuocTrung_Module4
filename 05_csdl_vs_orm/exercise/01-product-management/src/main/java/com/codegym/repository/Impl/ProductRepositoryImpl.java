package com.codegym.repository.Impl;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery =
                BaseRepository.entityManager.createQuery("select s from product s", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(Integer id) {
//        TypedQuery<Product> typedQuery =
//                BaseRepository.entityManager.createQuery("select s from product s where s.id = :idProduct", Product.class);
//        typedQuery.setParameter("idProduct",id);
//        return typedQuery.getSingleResult();
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void update(Integer id, Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void delete(Integer id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findById(id));
        entityTransaction.commit();
    }
}
