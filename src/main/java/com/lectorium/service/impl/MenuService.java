package com.lectorium.service.impl;

import com.lectorium.model.Menu;
import com.lectorium.repo.IGenericRepo;
import com.lectorium.repo.IMenuRepo;
import com.lectorium.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService extends GenericService<Menu, Integer> implements IMenuService {
    private final IMenuRepo repo;

    @Override
    protected IGenericRepo<Menu, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Menu> getMenusByUsername(String username) {
        return repo.getMenusByUsername(username);
    }
}
