package com.riskmanagmentapp.rmapp.SERVICES;

import com.riskmanagmentapp.rmapp.DAO.RisqueRepository;
import com.riskmanagmentapp.rmapp.ENTITIES.Risque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RisqueService {
    @Autowired
    private RisqueRepository risqueRepository;

    @RequestMapping(value ="/risques",method = RequestMethod.GET)
    public List<Risque> getRisque(){
        return risqueRepository.findAll();
    }

    @RequestMapping(value ="/risques/{id}",method=RequestMethod.GET)
    public Optional<Risque> getRisque(@PathVariable Long id){
        return risqueRepository.findById(id);
    }

    @RequestMapping(value ="/risques",method = RequestMethod.POST)
    public Risque save(@RequestBody Risque r){
        return risqueRepository.save(r);
    }

    @RequestMapping(value ="/risques/{id}",method=RequestMethod.GET)
    public void deleteRisque(@PathVariable Long id){
        risqueRepository.deleteById(id);
    }

    @RequestMapping(value ="/risques/{id}",method = RequestMethod.PUT)
    public Risque save(@PathVariable Long id,@RequestBody Risque r){
        r.setId(id);
        return risqueRepository.save(r);
    }

    @RequestMapping(value ="/chercherRisqueByEntite",method = RequestMethod.GET)
    public Page<Risque> rechercheEntite(
            @RequestParam(name="mc",defaultValue = "") String mc,
            @RequestParam(name="page",defaultValue = "0")int page,
            @RequestParam(name="size",defaultValue = "5") int size ) {
        return risqueRepository.rechercheEntite("%" + mc + "%", PageRequest.of(page, size));
    }
    @RequestMapping(value ="/chercherRisqueByDomaine",method = RequestMethod.GET)
    public Page<Risque> rechercheDomaine(
            @RequestParam(name="mc",defaultValue = "") String mc,
            @RequestParam(name="page",defaultValue = "0")int page,
            @RequestParam(name="size",defaultValue = "5") int size ) {
        return risqueRepository.rechercheDomaine("%" + mc + "%", PageRequest.of(page, size));
    }
    @RequestMapping(value ="/chercherRisqueByType",method = RequestMethod.GET)
    public Page<Risque> rechercheTypeRisque(
            @RequestParam(name="mc",defaultValue = "") String mc,
            @RequestParam(name="page",defaultValue = "0")int page,
            @RequestParam(name="size",defaultValue = "5") int size ) {
        return risqueRepository.rechercheType("%" + mc + "%", PageRequest.of(page, size));
    }

    @RequestMapping(value ="/chercherRisqueByCategorisation",method = RequestMethod.GET)
    public Page<Risque> rechercheCategorisation(
            @RequestParam(name="mc",defaultValue = "") String mc,
            @RequestParam(name="page",defaultValue = "0")int page,
            @RequestParam(name="size",defaultValue = "5") int size ) {
        return risqueRepository.rechercheCategorisation("%" + mc + "%", PageRequest.of(page, size));
    }

    @RequestMapping(value ="/chercherRisqueByIntitule",method = RequestMethod.GET)
    public Page<Risque> rechercheIntitule(
            @RequestParam(name="mc",defaultValue = "") String mc,
            @RequestParam(name="page",defaultValue = "0")int page,
            @RequestParam(name="size",defaultValue = "5") int size ) {
        return risqueRepository.rechercheIntitule("%" + mc + "%", PageRequest.of(page, size));
    }

    @RequestMapping(value ="/chercherRisqueBySource",method = RequestMethod.GET)
    public Page<Risque> rechercheSource(
            @RequestParam(name="mc",defaultValue = "") String mc,
            @RequestParam(name="page",defaultValue = "0")int page,
            @RequestParam(name="size",defaultValue = "5") int size ) {
        return risqueRepository.rechercheSource("%" + mc + "%", PageRequest.of(page, size));
    }

    @RequestMapping(value ="/chercherRisqueByProcess",method = RequestMethod.GET)
    public Page<Risque> rechercheProcess(
            @RequestParam(name="mc",defaultValue = "") String mc,
            @RequestParam(name="page",defaultValue = "0")int page,
            @RequestParam(name="size",defaultValue = "5") int size ) {
        return risqueRepository.rechercheProcessus("%" + mc + "%", PageRequest.of(page, size));
    }
    @RequestMapping(value ="/chercherRisqueByCriticiteNetSup",method = RequestMethod.GET)
    public Page<Risque> rechercheCriticiteNetSup(
            @RequestParam(name="mc",defaultValue = "") int mc,
            @RequestParam(name="page",defaultValue = "0")int page,
            @RequestParam(name="size",defaultValue = "5") int size ) {
        return risqueRepository.rechercheRisqueNetSup(mc, PageRequest.of(page, size));
    }
    @RequestMapping(value ="/chercherRisqueByCriticiteNetInf",method = RequestMethod.GET)
    public Page<Risque> rechercheCriticiteNetInf(
            @RequestParam(name="mc",defaultValue = "") int mc,
            @RequestParam(name="page",defaultValue = "0")int page,
            @RequestParam(name="size",defaultValue = "5") int size ) {
        return risqueRepository.rechercheRisqueNetSup(mc, PageRequest.of(page, size));
    }
    @RequestMapping(value ="/chercherRisqueByCriticiteNet",method = RequestMethod.GET)
    public Page<Risque> rechercheCriticiteNet(
            @RequestParam(name="mc",defaultValue = "") int mc,
            @RequestParam(name="page",defaultValue = "0")int page,
            @RequestParam(name="size",defaultValue = "5") int size ) {
        return risqueRepository.rechercheRisqueNetSup(mc, PageRequest.of(page, size));
    }
    @RequestMapping(value ="/chercherRisqueByClassement",method = RequestMethod.GET)
    public Page<Risque> rechercheClassement(
            @RequestParam(name="mc",defaultValue = "") String mc,
            @RequestParam(name="page",defaultValue = "0")int page,
            @RequestParam(name="size",defaultValue = "5") int size ) {
        return risqueRepository.rechercheClassementNet("%" + mc + "%", PageRequest.of(page, size));
    }
}
