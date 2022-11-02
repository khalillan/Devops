package tn.esprit.rh.achat;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@Slf4j
public class SpringTest {

    @Mock
    FournisseurRepository fournisseurRepository;

    @InjectMocks
    FournisseurServiceImpl fournisseurService;



}
