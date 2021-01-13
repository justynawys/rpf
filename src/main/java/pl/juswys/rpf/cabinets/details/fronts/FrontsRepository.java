package pl.juswys.rpf.cabinets.details.fronts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrontsRepository extends JpaRepository<Fronts, Long> {
}
