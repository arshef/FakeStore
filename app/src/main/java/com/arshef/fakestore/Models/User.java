package com.arshef.fakestore.Models;

import com.orm.SugarRecord;
import com.orm.dsl.NotNull;
import com.orm.dsl.Unique;

import java.util.ArrayList;
import java.util.List;

public class User extends SugarRecord {
    @Unique
    @NotNull
    String Username;
    @NotNull
    String Password;
    List<Basket> Baskets;

    public User() {
    }

    public User(String username, String password) {
        Username = username;
        Password = password;
        Baskets = new ArrayList<>();
    }

    public List<Basket> getBaskets() {
        return Baskets;
    }

    public void setBaskets(List<Basket> baskets) {
        Baskets = baskets;
    }
}
