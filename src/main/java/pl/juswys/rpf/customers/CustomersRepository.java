package pl.juswys.rpf.customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.juswys.rpf.project.Projects;

import java.util.List;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {

    public Customers findByProjects(Projects projects);

    @Query("SELECT c.projects FROM Customers c where c.id = ?1")
    public List<Projects> findProjects(Long id);

}
