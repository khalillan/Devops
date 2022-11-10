package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.Dto.ReglementDto;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.services.IReglementService;

import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "Gestion des reglements")
@RequestMapping("/reglement")
@CrossOrigin("*")
public class ReglementRestController {

    @Autowired
    IReglementService reglementService;



    @PostMapping("/add-reglement")
    @ResponseBody
    public ReglementDto addReglement(@RequestBody ReglementDto reglementDto) {
        return reglementService.addReglement(reglementDto);
    }
    @GetMapping("/retrieve-all-reglements")
    @ResponseBody
    public List<ReglementDto> getReglement() {
        return reglementService.retrieveAllReglements();
    }


    @GetMapping("/retrieve-reglement/{reglement-id}")
    @ResponseBody
    public ReglementDto retrieveReglement(@PathVariable("reglement-id") Long reglementId) {
        return reglementService.retrieveReglement(reglementId);
    }

    @GetMapping("/retrieveReglementByFacture/{facture-id}")
    @ResponseBody
    public List<ReglementDto> retrieveReglementByFacture(@PathVariable("facture-id") Long factureId) {

        return reglementService.retrieveReglementByFacture(factureId);
    }


    @GetMapping(value = "/getChiffreAffaireEntreDeuxDate/{startDate}/{endDate}")
    public float getChiffreAffaireEntreDeuxDate(
            @PathVariable(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @PathVariable(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        try {
            return reglementService.getChiffreAffaireEntreDeuxDate(startDate, endDate);
        } catch (Exception e) {
            return 0;
        }
    }
}
