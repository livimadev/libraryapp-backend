package com.lectorium.service;

import com.lectorium.model.Menu;

import java.util.List;

public interface IMenuService {

    List<Menu> getMenusByUsername(String username);
}
