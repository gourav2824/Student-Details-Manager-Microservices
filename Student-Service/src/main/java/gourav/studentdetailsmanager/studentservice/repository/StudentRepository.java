package gourav.studentdetailsmanager.studentservice.repository;

import gourav.studentdetailsmanager.studentservice.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
