package edu.mum.cs.cs544.dao;

import java.util.List;

// E is the entity and K is the primary key
public interface GenericDao<E,K> {
    public void add(E entity) ;
    public void saveOrUpdate(E entity) ;
    public void update(E entity) ;
    public void remove(E entity);
    public E find(K key);
    public List<E> getAll() ;
}