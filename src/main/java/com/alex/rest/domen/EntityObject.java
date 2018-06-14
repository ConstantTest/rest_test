package com.alex.rest.domen;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public abstract class EntityObject <I extends Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private I id;

    @Version
    private long version;

    public I getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityObject<?> that = (EntityObject<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
