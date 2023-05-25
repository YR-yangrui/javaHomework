package com.huawei.classroom.student.h59;

import java.util.List;

public class Reaction {
    private List<String> reactants;
    private List<String> products;

    public List<String> getReactants() {
        return reactants;
    }

    public void setReactants(List<String> reactants) {
        this.reactants = reactants;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public Reaction(List<String> reactants, List<String> products) {
        this.reactants = reactants;
        this.products = products;
    }
}
