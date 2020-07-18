package com.yanes.database;

/**
 * Created by claud on 4/20/2018.
 */

public class Final {
    private String State;
    private String Type;
    private String Name;
    private String Description;

    Final(){}
    public Final(String state, String type, String name, String description) {
        Name = name;
        State = state;
        Type = type;
        Description = description;
    }



    public String getState() {
        return State;
    }

    public String getType() {
        return Type;
    }
    public String getName() { return Name; }

    public String getDescription() {
        return Description;
    }
    public void setState(String state) {
        State = state;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setName(String name) { Name = name;  }

    public void setDescription(String description) {
        Description = description;
    }



    @Override
    public String toString() {
        return Name;
    }

}
