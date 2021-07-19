package ru.skillbench.tasks.basics.entity;

public class LocationImpl implements Location{
    private String name;
    private Type type;
    private Location parent;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void setParent(Location parent) {
        this.parent = parent;
    }

    @Override
    public String getParentName() {
        if(parent == null)
            return "--";
        return parent.getName();
    }

    @Override
    public Location getTopLocation() {
        if(parent == null)
            return this;
        else
            return parent.getTopLocation();
    }

    @Override
    public boolean isCorrect() {
        if (parent == null)
            return true;
        if (parent.getType().compareTo(this.getType()) < 0)
            return parent.isCorrect();
        else
            return false;
    }

    @Override
    public String getAddress() {
        if (parent != null){
            if(name.indexOf('.') != -1 && (name.indexOf('.') == name.length()-1 || name.indexOf('.') < name.indexOf(' '))){
                return name + ", " + parent.getAddress();
            }
            else
                return this.getType().getNameForAddress() + name + ", " + parent.getAddress();
        }
        else{
            if(name.indexOf('.') != -1 && (name.indexOf('.') == name.length()-1 || name.indexOf('.') < name.indexOf(' '))){
                return name;
            }
            else
                return this.getType().getNameForAddress() + name;
        }
    }

    @Override
    public String toString() {
        return name + " (" + type +")";
    }
}
