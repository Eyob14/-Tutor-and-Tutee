package Tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Tutorial.mainClasses.TuteeProfile;

public interface TuteeProfileRepository extends JpaRepository<TuteeProfile, Long> {
    @Query(value = "select * from tutee_profile t where id = :id", nativeQuery = true)
    TuteeProfile searchfor(@Param("id") Long id );
}
