package com.banking.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao <T, I extends Serializable> {

    //Retrieves all elements that match conditions

    List<T> findAll();
    T findById(I id);
    T save(T obj);
    T update(T obj);
    void delete(T obj);

    default boolean isUnique(T obj) {

        return true;

    }

}
