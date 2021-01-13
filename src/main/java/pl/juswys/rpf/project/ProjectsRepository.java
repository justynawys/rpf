package pl.juswys.rpf.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.juswys.rpf.cabinets.Cabinets;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Long> {
    public Projects findByCabinets(Cabinets cabinets);
}
