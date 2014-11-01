package domen;

import domen.Projekat;
import domen.Zaposleni;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-04T22:01:02")
@StaticMetamodel(Ucesce.class)
public class Ucesce_ { 

    public static volatile SingularAttribute<Ucesce, Integer> idUcesca;
    public static volatile SingularAttribute<Ucesce, Zaposleni> idZaposlenog;
    public static volatile SingularAttribute<Ucesce, String> zaduzenja;
    public static volatile SingularAttribute<Ucesce, Projekat> idProjekta;

}