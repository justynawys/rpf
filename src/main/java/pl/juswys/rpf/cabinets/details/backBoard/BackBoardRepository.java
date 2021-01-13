package pl.juswys.rpf.cabinets.details.backBoard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackBoardRepository extends JpaRepository<BackBoard, Long> {
}
