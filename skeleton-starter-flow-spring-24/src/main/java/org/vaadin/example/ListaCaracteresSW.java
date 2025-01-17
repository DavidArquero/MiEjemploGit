package org.vaadin.example;

import java.util.ArrayList;

public class ListaCaracteresSW {

    private int count;
    private String next;
    private String prev;
    private ArrayList<CaracterSW> results;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public ArrayList<CaracterSW> getResults() {
        return results;
    }

    public void setResults(ArrayList<CaracterSW> results) {
        this.results = results;
    }

    public ListaCaracteresSW(int count, ArrayList<CaracterSW> results, String prev, String next) {
        this.count = count;
        this.results = results;
        this.prev = prev;
        this.next = next;
    }
}
