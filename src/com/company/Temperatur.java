package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class Temperatur {

    private LocalDate dato;
    private double temp;
    private int dage;
    private double tempSnit;

    public Temperatur() {
    }

    public Temperatur(LocalDate dato, double temp, int dage, double tempSnit) {
        this.dato = dato;
        this.temp = temp;
        this.dage = dage;
        this.tempSnit = tempSnit;
    }

    @Override
    public String toString() {
        return "Temperatur{" +
                "dato=" + dato +
                ", temp=" + temp +
                '}';
    }

    public void indlaesFraFil(Temperatur[] arr, File fil,Temperatur dage) throws FileNotFoundException {

        Scanner input = new Scanner(fil);

        int i = 0;
        while(input.hasNext()){
            arr[i].setDato(LocalDate.parse(input.next()));
            arr[i].setTemp(input.nextDouble());
            i++;
        }
        input.close();

        dage.setDage(i);
    }

    //Opg. 1:
    public void gnsTemp(Temperatur[] tempArr, Temperatur dage){

        double gnsTemp = 0.0;

        for (int i = 0; i < dage.getDage(); i++) {
            gnsTemp += tempArr[i].getTemp();
        }

        double tempSnit = gnsTemp / dage.getDage();

        dage.setTempSnit(tempSnit);
        System.out.format(" %.2f°C\n",tempSnit);
    }

    public void lavestTemp(Temperatur[] tempX1, Temperatur[] tempX2, Temperatur dage){

        double minTemp1 = 0.0;
        double minTemp2 = 0.0;

        for (int i = 0; i < dage.getDage(); i++) {
            minTemp1 += tempX1[i].getTemp();
            minTemp2 += tempX2[i].getTemp();
        }

        double minTemp = Math.min(minTemp1/dage.getDage(), minTemp2/dage.getDage());

        if (minTemp == minTemp1/dage.getDage()){
            System.out.print("Januar 2011\n");
        }else {
            System.out.print("Januar 2020\n");
        }
    }

    //Opg. 3:
    public void udsTempDage(Temperatur[] tempArr, Temperatur dage){

        int tempPlus = 0;
        int tempNul = 0;
        int tempMinus = 0;

        for (int i = 0; i < dage.getDage(); i++) {
            if (tempArr[i].getTemp() > 0){
                tempPlus++;
            }else if (tempArr[i].getTemp() == 0){
                tempNul++;
            }else {
                tempMinus++;
            }
        }

        System.out.format("Dage over 0°C: %d \nDage med 0°C: %d \nDage under 0°C: %d\n",tempPlus,tempNul,tempMinus);
    }

    //Opg. 4:
    public void udsHoejesteTemp(Temperatur[] Arr, Temperatur dage){

        double hoejTemp = 0.0;

        for (int i = 0; i < dage.getDage(); i++) {
            if (Arr[i].getTemp() > hoejTemp){
                hoejTemp = Arr[i].getTemp();
            }
        }
        System.out.printf("%.1f°C",hoejTemp);
    }

    public void udsLavesttemp(Temperatur[] tempArr, Temperatur dage){

        double lavestTemp = 0.0;

        for (int i = 0; i < dage.getDage(); i++) {
            if (tempArr[i].getTemp() < lavestTemp){
                lavestTemp = tempArr[i].getTemp();
            }
        }
        System.out.printf("%.1f°C",lavestTemp);
    }

    //Opg. 5:
    public void udsDatoOverGnstemp(Temperatur[] tempArr, Temperatur dage){

        for (int i = 0; i < dage.getDage(); i++) {
            if (tempArr[i].getTemp() > dage.getTempSnit()){
                System.out.printf("%-12s %.1f°C\n",tempArr[i].getDato(),tempArr[i].getTemp());
            }
        }
    }

    //Opg. 9:
    public void udsDato2020HoejEnd2011(Temperatur[] tempArr1, Temperatur[] tempArr2, Temperatur dage){

        for (int i = 0; i < dage.getDage(); i++) {
            if (tempArr1[i].getTemp() < tempArr2[i].getTemp()){
                System.out.printf("%-12s %.1f°C\n",tempArr2[i].getDato(),tempArr2[i].getTemp());
            }
        }
    }

    //Opg. 10:
    public void udsDato2020Temp(Temperatur[] tempArr, Temperatur dage){

        int temp1 = 4;
        int temp2 = 6;

        for (int i = 0; i < dage.getDage(); i++) {
            if (tempArr[i].getTemp() > temp1 && tempArr[i].getTemp() <= temp2){
                System.out.printf("%-12s %.1f°C\n",tempArr[i].getDato(),tempArr[i].getTemp());
            }
        }
    }

    //Opg 11:
    public void udsSortTemp2011(Temperatur[] tempArr, Temperatur dage){

        double tjekMindst;
        int tæl = 0;

        //Sortere temp fra mindst til størst
        for (int i = 0; i < tempArr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (tempArr[j].getTemp() > tempArr[i].getTemp()){
                    tjekMindst = tempArr[i].getTemp();
                    tempArr[i].temp = tempArr[j].getTemp();
                    tempArr[j].temp = tjekMindst;
                }
            }
        }

        //Printer sorteret temps til skærm
        for (int i = 0; i < dage.getDage(); i++) {
            System.out.printf("%-12s %.1f°C\n",tempArr[i].getDato(),tempArr[i].getTemp());
        }

        double median;
        if (tempArr.length % 2 == 0)
            median = tempArr[tempArr.length/2].getTemp();
        else
            median = (tempArr[tempArr.length/2].getTemp() + tempArr[(tempArr.length/2)-1].getTemp())/2;

        System.out.format("\nMedianen er: %.1f°C",median);
    }

    //Getters og setters
    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getDage() {
        return dage;
    }

    public void setDage(int dage) {
        this.dage = dage;
    }

    public double getTempSnit() {
        return tempSnit;
    }

    public void setTempSnit(double tempSnit) {
        this.tempSnit = tempSnit;
    }
}
