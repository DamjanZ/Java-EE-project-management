package domen;

import domen.Projekat;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-04T22:01:02")
@StaticMetamodel(Sastanak.class)
public class Sastanak_ { 

    public static volatile SingularAttribute<Sastanak, Date> datumSastanka;
    public static volatile SingularAttribute<Sastanak, String> prostorija;
    public static volatile SingularAttribute<Sastanak, String> temaSastanka;
    public static volatile SingularAttribute<Sastanak, Integer> idSastanka;
    public static volatile SingularAttribute<Sastanak, Projekat> idProjekta;
    public static volatile SingularAttribute<Sastanak, String> izvestaj;

}