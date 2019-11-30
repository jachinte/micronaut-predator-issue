package example.domain;

import io.micronaut.core.annotation.Creator;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(
    name = "owners_pets",
    schema = "myschema",
    catalog = "mycatalog"
)
public class OwnerPet {

    /**
     * The primary key.
     */
    @EmbeddedId
    private OwnerPetKey id;

    @Creator
    public OwnerPet(final OwnerPetKey id) {
        this.id = id;
    }

    public OwnerPetKey getId() {
        return this.id;
    }

    public void setId(final OwnerPetKey id) {
        this.id = id;
    }

}
