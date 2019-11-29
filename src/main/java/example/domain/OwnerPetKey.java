package example.domain;

import io.micronaut.core.annotation.Creator;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * A primary key for {@link OwnerPet}.
 */
@Embeddable
public class OwnerPetKey {

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
    public OwnerPetKey(final Owner owner, final Pet pet) {
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
