package be.intecbrussel;

import java.io.Serializable;
import java.util.Objects;

public class Lion implements Serializable {

    private String name;
    private boolean edible;

    public Lion(String name, boolean edible) {
        this.name = name;
        this.edible = edible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEdible() {
        return edible;
    }

    public void setEdible(boolean edible) {
        this.edible = edible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lion)) return false;
        Lion lion = (Lion) o;
        return edible == lion.edible && Objects.equals(name, lion.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, edible);
    }

    @Override
    public String toString() {
        return "Lion{" +
                "name='" + name + '\'' +
                ", edible=" + edible +
                '}';
    }
}
