package pl.juswys.rpf.cabinets;

import lombok.Getter;
import lombok.Setter;
import pl.juswys.rpf.cabinets.details.backBoard.BackBoard;
import pl.juswys.rpf.cabinets.details.sideBoard.SideBoard;
import pl.juswys.rpf.cabinets.details.fronts.Fronts;

import javax.persistence.*;
import javax.validation.constraints.Min;


@Entity
@Getter
@Setter
@Table(name = "cabinets")
public class Cabinets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(1)
    private int boxQuantity;
    @Min(1)
    private int height;
    @Min(1)
    private int width;
    @Min(1)
    private int depth;

    @OneToOne
    private SideBoard sideBoard;

    @OneToOne
    private BackBoard backBoard;

    @OneToOne
    private Fronts fronts;

}
