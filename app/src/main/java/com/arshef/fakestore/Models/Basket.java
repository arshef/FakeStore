package com.arshef.fakestore.Models;


import com.orm.SugarRecord;
import com.orm.dsl.NotNull;
import com.orm.dsl.Unique;

import java.util.List;

public class Basket extends SugarRecord {
    @NotNull
    @Unique
    int Id;
    List<Product> Products;
    @NotNull
    int Price;
    @NotNull
    User user;
}
