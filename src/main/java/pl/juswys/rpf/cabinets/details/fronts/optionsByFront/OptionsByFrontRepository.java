package pl.juswys.rpf.cabinets.details.fronts.optionsByFront;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionsByFrontRepository extends JpaRepository<OptionsByFront, Long> {
}
