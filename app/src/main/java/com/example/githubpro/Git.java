package com.example.githubpro;

public class Git {

     private String type;
     private String sort;
     private String direction;

    public Git(String type, String sort, String direction) {
        this.type = type;
        this.sort = sort;
        this.direction = direction;
    }

    public String getType() {
        return type;
    }

    public String getSort() {
        return sort;
    }

    public String getDirection() {
        return direction;
    }

}
