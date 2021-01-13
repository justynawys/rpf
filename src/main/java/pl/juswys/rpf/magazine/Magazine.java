package pl.juswys.rpf.magazine;

import lombok.Getter;
import lombok.Setter;
import pl.juswys.rpf.cabinets.details.colors.Colors;
import pl.juswys.rpf.cabinets.details.typeBord.TypeBord;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Getter
@Setter
@Table(name = "magazine")
public class Magazine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(1)
    private int quantity;
    @Min(1)
    private int length;
    @Min(1)
    private int width;

    @OneToOne
    private Colors colors;

    @OneToOne
    private TypeBord typeBord;


}
