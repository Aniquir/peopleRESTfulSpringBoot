package restful.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT p FROM Person p LEFT JOIN FETCH p.addresses")
    List<Person> findAllWithAddresses();

    @Query(value = "SELECT p FROM Person p LEFT JOIN FETCH p.addresses WHERE p.id = :id")
    Person findOneWithAddresses(@Param("id") Long id);
}
