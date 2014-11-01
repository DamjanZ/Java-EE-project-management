package domen;

import domen.Mesto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-04T22:01:01")
@StaticMetamodel(Zaposleni.class)
public class Zaposleni_ { 

    public static volatile SingularAttribute<Zaposleni, Date> datumZaposlenja;
    public static volatile SingularAttribute<Zaposleni, Mesto> ptt;
    public static volatile SingularAttribute<Zaposleni, String> pozicija;
    public static volatile SingularAttribute<Zaposleni, String> prezime;
    public static volatile SingularAttribute<Zaposleni, Integer> idZaposlenog;
    public static volatile SingularAttribute<Zaposleni, String> pol;
    public static volatile SingularAttribute<Zaposleni, String> brojUlice;
    public static volatile SingularAttribute<Zaposleni, Date> datumRodjenja;
    public static volatile SingularAttribute<Zaposleni, String> ime;
    public static volatile SingularAttribute<Zaposleni, String> telefon;
    public static volatile SingularAttribute<Zaposleni, Boolean> zaposlen;
    public static volatile SingularAttribute<Zaposleni, String> ulica;

}