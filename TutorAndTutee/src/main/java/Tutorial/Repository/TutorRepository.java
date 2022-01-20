package Tutorial.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Tutorial.Models.Tutor;

@Repository
public interface TutorRepository extends CrudRepository<Tutor,Long>  {
    
}
