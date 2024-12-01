package com.j2e.test;

import com.j2e.metier.Compte;
import com.j2e.metier.IMetierBanque;
import com.j2e.metier.IMetierBanqueImpl;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        new Application().start();
    }

    private void start() {
        System.out.println("Starting Application .....");
        IMetierBanque metier=new IMetierBanqueImpl();
        Scanner clavier=new Scanner(System.in);
        System.out.print("Code:");
        Long code=clavier.nextLong();
        System.out.print("Solde:");
        double solde=clavier.nextDouble();
        metier.addCompte(new Compte(code,solde));
        while (true){
            try {
                System.out.println("=========================================");
                System.out.println(metier.getCompte(code).toString());
                System.out.print("Type Opération:");
                String type=clavier.next();
                if(type.equals("q"))
                    break;
                System.out.print("Montant:");
                double montant=clavier.nextDouble();
                if(type.toLowerCase().equals("v"))
                    metier.verser(code,montant);
                else if(type.toLowerCase().equals("r"))
                    metier.retirer(code,montant);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
