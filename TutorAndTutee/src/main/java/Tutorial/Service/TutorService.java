package Tutorial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tutorial.Models.Tutor;
import Tutorial.Repository.TutorRepository;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepo;

	public void addTutor(Tutor tutor) {
		tutorRepo.save(tutor);
	}

    
    
}
