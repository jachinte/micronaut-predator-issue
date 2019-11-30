package example.repositories;

import example.domain.OwnerPet;
import example.domain.OwnerPetKey;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface OwnerPetRepository extends CrudRepository<OwnerPet, OwnerPetKey> {
}
