package com.lectorium.service.impl;

import com.lectorium.exception.ModelNotFoundException;
import com.lectorium.repo.IGenericRepo;
import com.lectorium.service.IGenericService;

import java.lang.reflect.Method;
import java.util.List;

public abstract class GenericService<T,ID> implements IGenericService<T,ID> {
    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        // TODO verificar el id de la entidad
        getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND: " + id));
        // t.setIdPublisher(id); Java Reflection
        Class<?> clazz = t.getClass();
        String className = clazz.getSimpleName();

        // setIdXYZ
        String methodName = "setId" + className;
        Method setIdMethod = clazz.getMethod(methodName, id.getClass());
        setIdMethod.invoke(t, id);

        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND: " + id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND: " + id));
        getRepo().deleteById(id);
    }
}
