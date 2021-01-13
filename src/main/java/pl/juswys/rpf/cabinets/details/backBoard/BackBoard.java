package pl.juswys.rpf.cabinets.details.backBoard;

import lombok.Getter;
import lombok.Setter;
import pl.juswys.rpf.cabinets.details.colors.Colors;
import pl.juswys.rpf.cabinets.details.typeBord.TypeBord;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "backBoard")
public class BackBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int width;
    private int length;

    @ManyToOne
    private TypeBord typeBord;

    @ManyToOne
    private Colors colors;

}
