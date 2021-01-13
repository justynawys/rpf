package pl.juswys.rpf.cabinets.details.sideBoard;

import lombok.Getter;
import lombok.Setter;
import pl.juswys.rpf.cabinets.details.colors.Colors;
import pl.juswys.rpf.cabinets.details.typeBord.TypeBord;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "sideBoard")
public class SideBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    półka
    private int shelfQuantity;
    private int shelfWidth;
    private int shelfLength;

    //    bok
    private int sideWidth;
    private int sideLength;

//    dół wieniec

    private int bottomWidth;
    private int bottomLength;

    //    belka
    private int barWidth;
    private int barLength;

    @ManyToOne
    private TypeBord typeBord;

    @ManyToOne
    private Colors colors;

}
