package com.example.Abank;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/dodajK")
    public Konto addKonto(@RequestBody Konto konto){
        return kontoRepository.save(konto);
    }
    @GetMapping("/getById/{id}")
    public Konto getKonto(@PathVariable Long id) {
        return kontoRepository.getReferenceById(id);
    }
    @DeleteMapping("/deletek/{id}")
    public void deleteBook(@PathVariable Long id){
        kontoRepository.deleteById(id);
   }
    @PutMapping("/edytujSaldo/{id}")
    public Konto edytuj_saldo (@RequestBody Konto konto2,@PathVariable Long id){
    Konto konto=kontoRepository.findById(id).orElseThrow();
    konto.setSaldo(konto2.getSaldo());
    return kontoRepository.save(konto);
   }
}
