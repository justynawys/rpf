package pl.juswys.rpf.cabinets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabinetsRepository extends JpaRepository<Cabinets, Long> {
}
