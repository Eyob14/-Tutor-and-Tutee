package Tutorial.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Tutorial.Models.Tutee;

@Repository
public interface TuteeRepository extends CrudRepository<Tutee,Long> {
    
}
