package com.lavanderiapiscis.sistemaweb.service;

import java.util.List;
import com.lavanderiapiscis.sistemaweb.model.InsumoModel;

public interface InsumoService {
    List<InsumoModel> findAll();
    InsumoModel findById(int id);
    void add(InsumoModel insumo);
    void update(InsumoModel insumo, int id);
    void delete(int id);
    void enable(int id);
    void disable(int id);
}
