package com.example.marija.restoranstariprojekat.backend;

import com.example.marija.restoranstariprojekat.database.FoodMenuItem;

/**
 * Created by marija.radisavljevic on 5/26/2016.
 */
public class SelectedFilter {

    //selection
    private Integer numberOfTable;
    private boolean numberOfTable_selectied;

    private boolean paidOrNot;
    private boolean paidOrNot_selected;

    private FoodMenuItem kategory;
    private boolean kategory_selected;

    private boolean all;


    public Integer getNumberOfTable() {
        return numberOfTable;
    }

    public void setNumberOfTable(Integer numberOfTable) {
        this.numberOfTable = numberOfTable;
    }

    public boolean isNumberOfTable_selectied() {
        return numberOfTable_selectied;
    }

    public void setNumberOfTable_selectied(boolean numberOfTable_selectied) {
        this.numberOfTable_selectied = numberOfTable_selectied;
    }

    public boolean isPaidOrNot() {
        return paidOrNot;
    }

    public void setPaidOrNot(boolean paidOrNot) {
        this.paidOrNot = paidOrNot;
    }

    public boolean isPaidOrNot_selected() {
        return paidOrNot_selected;
    }

    public void setPaidOrNot_selected(boolean paidOrNot_selected) {
        this.paidOrNot_selected = paidOrNot_selected;
    }

    public FoodMenuItem getKategory() {
        return kategory;
    }

    public void setKategory(FoodMenuItem kategory) {
        this.kategory = kategory;
    }

    public boolean isKategory_selected() {
        return kategory_selected;
    }

    public void setKategory_selected(boolean kategory_selected) {
        this.kategory_selected = kategory_selected;
    }

    public boolean isAll() {
        return all;
    }

    public void setAll(boolean all) {
        this.all = all;
    }
}
