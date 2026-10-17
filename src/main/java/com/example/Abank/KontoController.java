package com.example.Abank;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/konto")
public class KontoController {
    private final KontoRepository kontoRepository;
    public KontoController(KontoRepository kontoRepository){
        this.kontoRepository=kontoRepository;
    }
    @GetMapping("/getAll")
    public List<Konto> getAllKonto(){
        return kontoRepository.findAll();
    }
}