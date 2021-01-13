package pl.juswys.rpf.cabinets.details.sideBoard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SideBoardRepository extends JpaRepository<SideBoard, Long> {
}
