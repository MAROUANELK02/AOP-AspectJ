package com.j2e.metier;

public interface IMetierBanque {
    void addCompte(Compte cp);
    void verser(Long code,double mt);
    void retirer(Long code,double mt);
    Compte getCompte(Long code);
}
