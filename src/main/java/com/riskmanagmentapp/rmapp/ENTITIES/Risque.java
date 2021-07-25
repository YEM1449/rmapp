package com.riskmanagmentapp.rmapp.ENTITIES;

import lombok.*;

import javax.persistence.*;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor@ToString
public class Risque {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String finalite;
    private String Mission;
    private String partiesConcernees;
    @Enumerated(EnumType.STRING)
    private Entite entite;
    @Enumerated(EnumType.STRING)
    private Domaine domaine;
    @Enumerated(EnumType.STRING)
    private Processus processus;
    private String intitule;
    private String description ;
    private String etatAvancement ;
    @Enumerated(EnumType.STRING)
    private SourceRisque sourceRisque;
    @Enumerated(EnumType.STRING)
    private TypeRisque typeRisque;
    @Enumerated(EnumType.STRING)
    private CategorisationRisque categorisationRisque;
    //Causes
    private String humaine;
    private  String organisationelle;
    private String materiel;
    private String autreCauses;
    //concequences
    private String notoriete;
    private String financier;
    private String performance;
    private String legalReglementaire;
    private String serviceClient;
    private String securite ;
    private String autreConsequences;
    //risque Brut
    private int echelleGravite;
    private int echelleProbabilite;
    private int criticiteBrut;
    private String classementBrut;
    //DMR
    private String dmr;
    private int cotationDM;
    //RisqueNET
    private int criticiteNet;
    private String classementNet;
    //Plan d'action
    private String action;
    private String planification;
    private String realisation;
    //PilotageRisque
    private String indicateurSurveillance;
    private String frequenceSurveillance;

    private String efficacite;
    private String commentaire;


    public int calculerCriticiteBrut(){
        int c ;
        c = echelleGravite*echelleProbabilite;
        setCriticiteBrut(c);
        return c;
    }

    public String definirClassement(){
        String c;
        int d = criticiteBrut;
        if (d<=2){ c="Risque Maitrisé";}
        else if (d<=4){c="Veille";}
        else if (d<=8){c= "Vigilance";}
        else {c="Danger";}
        setClassementBrut(c);
        return c;
    }
    public int calculerCriticiteNet(){
        int b = cotationDM * criticiteBrut;
        setCriticiteNet(b);
        return b;
    }

    public String definirClassementNet(){
        String c ;
        int d = criticiteNet;
        if (d<=6){ c="Risque Maitrisé";}
        else if (d<=16){c="Veille";}
        else if (d<=17){c= "Vigilance";}
        else {c="Danger";}
        setClassementNet(c);
        return c;
    }
}
