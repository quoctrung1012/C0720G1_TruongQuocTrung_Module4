package ccom.codegym.service.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceGeneric<T> {

    List<T> findAll();
    T findById(Long id);
    T save(T t);
    void remove(Long id);
    Page<T> findPageAll(Pageable pageable);
    Page<T> searchByName(String string, Pageable pageable);
}
