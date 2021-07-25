package com.riskmanagmentapp.rmapp.DAO;

import com.riskmanagmentapp.rmapp.ENTITIES.Risque;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RisqueRepository extends JpaRepository<Risque,Long> {
    @Query("Select r from Risque r where r.entite = :x")
    public Page<Risque> rechercheEntite(@Param("x")String mc , Pageable pageable);

    @Query("Select r from Risque r where r.categorisationRisque = :x")
    public Page<Risque> rechercheCategorisation(@Param("x")String mc , Pageable pageable);

    @Query("Select r from Risque r where r.domaine = :x")
    public Page<Risque> rechercheDomaine(@Param("x")String mc , Pageable pageable);

    @Query("Select r from Risque r where r.processus = :x")
    public Page<Risque> rechercheProcessus(@Param("x")String mc , Pageable pageable);

    @Query("Select r from Risque r where r.sourceRisque = :x")
    public Page<Risque> rechercheSource(@Param("x")String mc , Pageable pageable);

    @Query("Select r from Risque r where r.typeRisque = :x")
    public Page<Risque> rechercheType(@Param("x")String mc , Pageable pageable);

    @Query("Select r from Risque r where r.intitule like :x")
    public Page<Risque> rechercheIntitule(@Param("x")String mc , Pageable pageable);

    @Query("Select r from Risque r where r.criticiteNet >= :x")
    public Page<Risque> rechercheRisqueNetSup(@Param("x")int mc , Pageable pageable);

    @Query("Select r from Risque r where r.criticiteNet <= :x")
    public Page<Risque> rechercheRisqueNetInf(@Param("x")int mc , Pageable pageable);

    @Query("Select r from Risque r where r.criticiteNet = :x")
    public Page<Risque> rechercheRisqueNet(@Param("x")int mc , Pageable pageable);

    @Query("Select r from Risque r where r.classementNet like :x")
    public Page<Risque> rechercheClassementNet(@Param("x")String mc , Pageable pageable);
}
