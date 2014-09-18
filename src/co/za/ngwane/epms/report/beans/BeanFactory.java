package co.za.ngwane.epms.report.beans;

import  java.util.ArrayList;
import  java.util.GregorianCalendar;
import  java.util.List;

public class  BeanFactory {

    public  BeanFactory() {
    }

    public  List<ActorBean> getActorBeans() {
        List<ActorBean> actors = new  ArrayList<ActorBean>();

        ActorBean actor1 = new  ActorBean("Californication", "HANK MOODY",
                "DAVID DUCHOVNY", new  GregorianCalendar(1960, 8, 7).getTime());
        actors.add(actor1);

        ActorBean actor2 = new  ActorBean("Breaking Bad", "Walter White",
                "Bryan Cranston", new  GregorianCalendar(1956, 3, 7).getTime());
        actors.add(actor2);

        ActorBean actor3 = new  ActorBean("Californication",
                "KAREN VAN DER BEEK", "NATASCHA MCELHONE",
                new  GregorianCalendar(1969, 12, 14).getTime());
        actors.add(actor3);

        ActorBean actor4 = new  ActorBean("Breaking Bad", "Jesse Pinkman",
                "Aaron Paul", new  GregorianCalendar(1979, 8, 27).getTime());
        actors.add(actor4);

        ActorBean actor5 = new  ActorBean("Californication", "CHARLIE RUNKLE",
                "EVAN HANDLER", new  GregorianCalendar(1961, 1, 10).getTime());
        actors.add(actor5);

        return  actors;
    }
}
