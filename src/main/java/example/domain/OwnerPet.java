package example.domain;

import io.micronaut.core.annotation.Creator;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
    private InnerOwnerPetKey id;

    @Creator
    public OwnerPet(final InnerOwnerPetKey id) {
        this.id = id;
    }

    public InnerOwnerPetKey getId() {
        return this.id;
    }

    public void setId(final InnerOwnerPetKey id) {
        this.id = id;
    }

    @Embeddable
    public class InnerOwnerPetKey {

        /**
         * The user.
         */
        @Column(name = "user_id")
        @ManyToOne(optional = false)
        private @NotNull Owner owner;

        /**
         * The role.
         */
        @Column(name = "role_name")
        @ManyToOne(optional = false)
        private @NotNull Pet pet;

        @Creator
        public InnerOwnerPetKey(final Owner owner, final Pet pet) {
            this.owner = owner;
            this.pet = pet;
        }

        public Owner getOwner() {
            return this.owner;
        }

        public void setOwner(final Owner owner) {
            this.owner = owner;
        }

        public Pet getPet() {
            return this.pet;
        }

        public void setPet(final Pet pet) {
            this.pet = pet;
        }
    }

}
