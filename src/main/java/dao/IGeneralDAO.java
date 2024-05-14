/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IGeneralDAO<T>{
    List<T> findAll();
    T findOne(String id);
    T save(T object);
    boolean delete(String id);
}