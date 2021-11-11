package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class Nedboer {

    private LocalDate dato;
    private int dage;
    private double nedboer;

    public Nedboer() {
    }

    public Nedboer(LocalDate dato, int dage, double nedboer) {
        this.dato = dato;
        this.dage = dage;
        this.nedboer = nedboer;
    }

    public void indlaesFraFil(Nedboer[] nedArr, File fil, Nedboer dage) throws FileNotFoundException {

        Scanner input = new Scanner(fil);

        int i = 0;
        while(input.hasNext()){
            nedArr[i].setDato(LocalDate.parse(input.next()));
            nedArr[i].setNedboer(input.nextDouble());
            i++;
        }
        input.close();

        dage.setDage(i);
    }

    //Opg. 2:
    public void udsNedboersmaengde(Nedboer[] nedArr, Nedboer dage){

        double nedMaengde = 0.0;

        for (int i = 0; i < dage.getDage(); i++) {
            nedMaengde += nedArr[i].getNedboer();
        }

        System.out.format("%.1fmm\n",nedMaengde);
    }

    public void udsMestNedboer(Nedboer[] nedArr1, Nedboer[] nedArr2, Nedboer dage){

        double ned1 = 0.0;
        double ned2 = 0.0;

        for (int i = 0; i < dage.getDage(); i++) {
            ned1 += nedArr1[i].getNedboer();
            ned2 += nedArr2[i].getNedboer();
        }

        double maxNed = Math.max(ned1,ned2);

        if (ned1 == maxNed){
            System.out.print("Januar 2011");
        }else {
            System.out.print("Januar 2020");
        }
    }

    //Opg. 6:
    public void udsDatoOver0mm(Nedboer[] nedArr, Nedboer dage){

        for (int i = 0; i < dage.getDage(); i++) {

            if (nedArr[i].getNedboer() > 0){
                System.out.printf("%-12s %.1fmm\n",nedArr[i].getDato(),nedArr[i].getNedboer());
            }
        }
    }

    //Opg. 7:
    public void udsDatoUnderGns(Nedboer[] nedArr, Nedboer dage){

        double gnsNed = 0.0;

        for (int i = 0; i < dage.getDage(); i++) {
            gnsNed += nedArr[i].getNedboer();
        }

        double nedSnit = gnsNed / dage.getDage();
        System.out.format("%.1fmm\n",nedSnit);

        for (int i = 0; i < dage.getDage(); i++) {

            if (nedArr[i].getNedboer() < nedSnit){
                System.out.printf("%-12s %.1fmm\n",nedArr[i].getDato(), nedArr[i].getNedboer());
            }
        }
    }

    //Opg. 8: IKKE FÆRDIG
    public void udsStolpeDiagram(Nedboer[] nedArr){
        System.out.println("MANGLER");
    }

    //Getter og setters
    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public int getDage() {
        return dage;
    }

    public void setDage(int dage) {
        this.dage = dage;
    }

    public double getNedboer() {
        return nedboer;
    }

    public void setNedboer(double nedboer) {
        this.nedboer = nedboer;
    }
}
