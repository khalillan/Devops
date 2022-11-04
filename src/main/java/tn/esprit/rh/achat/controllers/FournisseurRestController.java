package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;
import tn.esprit.rh.achat.DTO.FournisseurDto;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.services.IFournisseurService;

import java.util.List;


@RestController
@Api(tags = "Gestion des fournisseurss")
@RequestMapping("/fournisseur")
public class FournisseurRestController {

	@Autowired
	IFournisseurService fournisseurService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/retrieve-all-fournisseurs")
	@ResponseBody
	public List<Fournisseur> getFournisseurs() {
		return fournisseurService.retrieveAllFournisseurs();
	}

	@GetMapping("/retrieve-fournisseur/{fournisseur-id}")
	@ResponseBody
	public Fournisseur retrieveFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
		return fournisseurService.retrieveFournisseur(fournisseurId);
	}

	// http://localhost:8089/SpringMVC/fournisseur/add-fournisseur
	@PostMapping("/add-fournisseur")
	@ResponseBody
	public ResponseEntity<FournisseurDto> addFournisseur(@RequestBody FournisseurDto f) {
		Fournisseur fournisseurRequest = modelMapper.map(f, Fournisseur.class);
		Fournisseur fournisseur = fournisseurService.addFournisseur(fournisseurRequest);
		FournisseurDto fournisseurDto = modelMapper.map(fournisseur, FournisseurDto.class);
		return new ResponseEntity<FournisseurDto>(fournisseurDto, HttpStatus.CREATED);
	}

	@DeleteMapping("/remove-fournisseur/{fournisseur-id}")
	@ResponseBody
	public void removeFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
		fournisseurService.deleteFournisseur(fournisseurId);
	}

	@PutMapping("/modify-fournisseur")
	@ResponseBody
	public ResponseEntity<FournisseurDto> modifyFournisseur(@RequestBody FournisseurDto fournisseurDto) {
		Fournisseur fournisseurRequest = modelMapper.map(fournisseurDto, Fournisseur.class);

		Fournisseur fournisseur = fournisseurService.updateFournisseur(fournisseurRequest);
		FournisseurDto fournisseurResponse = modelMapper.map(fournisseur , FournisseurDto.class);
		return  ResponseEntity.ok().body(fournisseurResponse);
	}

		@PutMapping(value = "/assignSecteurActiviteToFournisseur/{idSecteurActivite}/{idFournisseur}")
		public void assignProduitToStock(@PathVariable("idSecteurActivite") Long idSecteurActivite, @PathVariable("idFournisseur") Long idFournisseur) {
			fournisseurService.assignSecteurActiviteToFournisseur(idSecteurActivite, idFournisseur);
		}

}
