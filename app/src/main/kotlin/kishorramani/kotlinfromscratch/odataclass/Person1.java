package kishorramani.kotlinfromscratch.odataclass;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Objects;

public class Person1 {
    private String id;
    private String name;
    private String country;

    public Person1(String id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person1 person1 = (Person1) obj;
        return Objects.equals(id, person1.id) && Objects.equals(name, person1.name) && Objects.equals(country, person1.country);
    }

    @NonNull
    @Override
    public String toString() {
        return "person{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", country='" + country + '\'' + '}';
    }
}
