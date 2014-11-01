package domen;

import domen.Korisnik;
import domen.Sastanak;
import domen.Ucesce;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-04T22:01:01")
@StaticMetamodel(Projekat.class)
public class Projekat_ { 

    public static volatile SingularAttribute<Projekat, String> nazivProjekta;
    public static volatile ListAttribute<Projekat, Ucesce> ucesceCollection;
    public static volatile SingularAttribute<Projekat, Date> datumPocetka;
    public static volatile SingularAttribute<Projekat, String> opisProjekta;
    public static volatile CollectionAttribute<Projekat, Sastanak> sastanakCollection;
    public static volatile SingularAttribute<Projekat, Korisnik> korisnikID;
    public static volatile SingularAttribute<Projekat, Date> datumRealizacije;
    public static volatile SingularAttribute<Projekat, Boolean> aktuelan;
    public static volatile SingularAttribute<Projekat, BigDecimal> finansijskaSredstva;
    public static volatile SingularAttribute<Projekat, Integer> idProjekta;

}