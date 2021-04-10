package com.example.myntra.Model;

import java.util.ArrayList;

public class PopulateRecommendation {
    String name;
    ArrayList<String> pid;

    public PopulateRecommendation() {
    }

    public PopulateRecommendation(String name, ArrayList<String> pid) {
        this.name = name;
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPid() {
        return pid;
    }

    public void setPid(ArrayList<String> pid) {
        this.pid = pid;
    }
}
