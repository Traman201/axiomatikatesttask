package com.romantest.autocredit.dao;

import java.util.List;

public interface DAO <T, Id>{
    void save(T o);
    List<T> getAll();
    T getById(Id id);
}
