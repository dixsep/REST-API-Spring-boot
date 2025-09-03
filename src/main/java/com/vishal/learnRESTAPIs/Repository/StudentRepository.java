package com.vishal.learnRESTAPIs.Repository;

import com.vishal.learnRESTAPIs.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // connects to student entity with id type Long
    // JpaRepository<Student, Long> : It has inbuilt methods, we can use all these methods
    // no need to write any boiler plate code.
    // create beans of diff types by external config or app config.

}
