package pl.juswys.rpf.cabinets.details.fronts;

import lombok.Getter;
import lombok.Setter;
import pl.juswys.rpf.cabinets.details.fronts.optionsByFront.OptionsByFront;
import pl.juswys.rpf.cabinets.details.typeBord.TypeBord;
import pl.juswys.rpf.cabinets.details.colors.Colors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "fronts")
public class Fronts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int leftWidth;
    private int rightWidth;
    private int length;

    @ManyToOne
    private OptionsByFront options;


    @ManyToOne
    private TypeBord typeBord;

    @ManyToOne
    private Colors colors;

}
