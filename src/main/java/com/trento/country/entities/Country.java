package com.trento.country.entities;

public class Country {
    private int id;
    private String name;
    private String capital;
    private static int idInc;

    public Country(String name) {
        id++;
        this.name = name;
        this.capital = "missing";
    }

    public Country(String name, String capital) {
        this.id = idInc++;
        this.name = name;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getId() {
        return this.id;
    }
}
