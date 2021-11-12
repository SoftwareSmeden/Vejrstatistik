package com.company;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //Vejrstatistik

        //Opg. 1:
        Temperatur temp11 = new Temperatur();
        Temperatur temp20 = new Temperatur();
        Temperatur[] tempArr2011 = new Temperatur[31];
        Temperatur[] tempArr2020 = new Temperatur[31];

        for (int i = 0; i < tempArr2011.length; i++) {
            tempArr2011[i] = new Temperatur();
            tempArr2020[i] = new Temperatur();
        }

        File midTemp2011 = new File("Middeltemperatur 2011.txt");
        File midTemp2020 = new File("Middeltemperatur 2020.txt");

        temp11.indlaesFraFil(tempArr2011,midTemp2011,temp11);
        temp20.indlaesFraFil(tempArr2020,midTemp2020,temp20);
        System.out.println("Opg. 1:");
        System.out.print("Gennemsnitstemperaturen for Januar 2011:");
        temp11.gnsTemp(tempArr2011, temp11);
        System.out.print("Gennemsnitstemperaturen for Januar 2020:");
        temp20.gnsTemp(tempArr2020,temp20);
        System.out.print("Den måned med den laveste temperatur er: ");
        temp11.lavestTemp(tempArr2011,tempArr2020,temp11);

        //Opg. 2:
        File ned2011 = new File("Nedbør 2011.txt");
        File ned2020 = new File("Nedbør 2020.txt");

        Nedboer nedboer11 = new Nedboer();
        Nedboer nedboer20 = new Nedboer();
        Nedboer[] nedboer2011 = new Nedboer[31];
        Nedboer[] nedboer2020 = new Nedboer[31];

        for (int i = 0; i < nedboer2011.length; i++) {
            nedboer2011[i] = new Nedboer();
            nedboer2020[i] = new Nedboer();
        }

        nedboer11.indlaesFraFil(nedboer2011,ned2011,nedboer11);
        nedboer20.indlaesFraFil(nedboer2020,ned2020,nedboer20);
        System.out.println("\nOpg. 2:");
        System.out.print("Nedbørsmængde for Januar 2011: ");
        nedboer11.udsNedboersmaengde(nedboer2011,nedboer11);
        System.out.print("Nedbørsmængde for Januar 2020: ");
        nedboer20.udsNedboersmaengde(nedboer2020,nedboer20);
        System.out.print("Den måned med mest nedbør er: ");
        nedboer11.udsMestNedboer(nedboer2011,nedboer2020,nedboer11);

        //Opg. 3:
        System.out.println("\n\nOpg. 3:");
        System.out.println("Januar 2011:");
        temp11.udsTempDage(tempArr2011,temp11);
        System.out.println("\nJanuar 2020:");
        temp20.udsTempDage(tempArr2020,temp20);

        //Opg. 4:
        System.out.println("\nOpg. 4:");
        System.out.print("Januar 2011, højeste temperatur er: ");
        temp11.udsHoejesteTemp(tempArr2011,temp11);
        System.out.print("\nJanaur 2011, laveste temperatur er: ");
        temp11.udsLavesttemp(tempArr2011,temp11);
        System.out.print("\n\nJanuar 2020, højeste temperatur er: ");
        temp20.udsHoejesteTemp(tempArr2020,temp20);
        System.out.print("\nJanuar 2020, laveste temperatur er: ");
        temp20.udsLavesttemp(tempArr2020,temp20);

        //Opg. 5:
        System.out.println("\n\nOpg. 5:");
        System.out.print("Datoer i Januar 2011, der var over gennemsnitstemperaturen:");
        temp11.gnsTemp(tempArr2011,temp11);
        temp11.udsDatoOverGnstemp(tempArr2011,temp11);
        System.out.print("\nDatoer i Januar 2020, der var over gennemsnitstemperaturen:");
        temp11.gnsTemp(tempArr2020,temp20);
        temp11.udsDatoOverGnstemp(tempArr2020,temp20);

        //Opg. 6:
        System.out.println("\nOpg. 6:");
        System.out.println("Dage i Januar 2011 med nedbørmængde større end 0mm: ");
        nedboer11.udsDatoOver0mm(nedboer2011,nedboer11);
        System.out.println("\nDage i Januar 2020 med nedbørmængde større end 0mm: ");
        nedboer20.udsDatoOver0mm(nedboer2020,nedboer20);

        //Opg. 7:
        System.out.println("\nOpg. 7:");
        System.out.print("Datoer i Januar 2020, der var under gennemsnitsnedbøret: ");
        nedboer20.udsDatoUnderGns(nedboer2020,nedboer20);

        //Opg. 8:
        System.out.println("\nOpg. 8:");
        System.out.println("Stolpediagram for nedbørsmængde, Januar 2011: ");
        System.out.println("\n______________________________JANUAR 2011 - NEDBØRSMÆGNDE - STOLPEDIAGRAM________________________________");
        nedboer11.udsStolpeDiagram(nedboer2011);

        //Opg. 9:
        System.out.println("\n\nOpg. 9:");
        System.out.println("Dage i Januar 2020, der havde højere temperaturer end i 2011: ");
        temp20.udsDato2020HoejEnd2011(tempArr2011,tempArr2020,temp11);

        //Opg. 10:
        System.out.println("\nOpg. 10:");
        System.out.println("Dage i Janaur 2020, der var højere end 4°C og mindre eller lig med 6°C: ");
        temp20.udsDato2020Temp(tempArr2020,temp20);

        //Opg. 11:
        System.out.println("\nOpg. 11:");
        System.out.println("Temperaturer for Januar 2011 sorteret fra mindste til størst: ");
        temp11.udsSortTemp2011(tempArr2011,temp11);

        System.out.println("\nFÆRDIG!");
    }
}
