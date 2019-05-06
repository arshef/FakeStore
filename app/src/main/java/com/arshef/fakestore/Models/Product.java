package com.arshef.fakestore.Models;

import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.NotNull;
import com.orm.dsl.Unique;

public class Product extends SugarRecord {
    @NotNull
    @Unique
    int Id;
    @NotNull
    String Title;
    @NotNull
    int Price;
}
