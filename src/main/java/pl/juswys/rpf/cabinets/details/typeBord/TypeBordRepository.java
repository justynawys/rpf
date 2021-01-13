package pl.juswys.rpf.cabinets.details.typeBord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeBordRepository extends JpaRepository<TypeBord, Long> {
}
