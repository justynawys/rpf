package pl.juswys.rpf.project;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.juswys.rpf.cabinets.Cabinets;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "projects")
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @Column(length = 50)
    private String description;

    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;

    @OneToMany
    private List<Cabinets> cabinets;

}
