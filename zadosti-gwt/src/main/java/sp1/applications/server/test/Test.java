/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sp1.applications.server.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import sp1.applications.server.service.GMZadostService;
import sp1.applications.shared.entity.GMZadost;

/**
 *
 * @author JakubPetr
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("D:\\Skola\\SP1\\App\\Server\\src\\main\\webapp\\WEB-INF\\dispatcher-servlet.xml");
        //new ClassPathXmlApplicationContext("/WEB-INF/dispatcher-servlet.xml");

        GMZadostService zadostService =
                (GMZadostService) ctx.getBean("GMZadostService");

        GMZadost zadost = new GMZadost();

        zadost.setJednaciCislo("987654321");
        zadost.setDatumDoruceni(null);
        zadost.setZmenaStavu(new Timestamp(new java.util.Date().getTime()));

        //zadostService.create(zadost);

        System.out.println("Zadost inserted!");

        zadost = zadostService.get(1);

        System.out.println("\nUser fetched by username!"
                + "\nId: " + zadost.getZadostId()
                + "\nJednací číslo: " + zadost.getJednaciCislo()
                + "\nVyřizuje osoba: " + zadost.getVyrizujeOsoba());


        List<GMZadost> zadosti = zadostService.filter("987654321", "", null, null);

        System.out.println("Count: " + zadosti.size()
                + "\nJednací číslo: " + zadosti.get(0).getJednaciCislo());

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
        Date lower = new Date( df.parse("01/05/2013").getTime() );
        Date upper = new Date( df.parse("10/05/2013").getTime() );
        
        List<GMZadost> zadosti2 = zadostService.filter("%234%", "", lower, upper);

        System.out.println("Count: " + zadosti2.size()
                + "\nJednací číslo: " + zadosti2.get(0).getJednaciCislo());
    }
}
