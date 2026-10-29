package com.example.Abank;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/konto")
public class KontoController {
    private final KontoRepository kontoRepository;
    public KontoController(KontoRepository kontoRepository){
        this.kontoRepository=kontoRepository;
    }
    @GetMapping("/getAll")
    public List<Konto> getAll(){
        return kontoRepository.findAll();
        new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,"Nie można dojśc do strony");
    }

    @PostMapping("/dodajK")
    public Konto addKonto(@RequestBody Konto konto){
        return kontoRepository.save(konto);
        new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Nie można użyć tego polecenia");
    }
    @GetMapping("/getById/{id}")
    public Konto getKonto(@PathVariable Long id) {
        return kontoRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Nieznaleziono konta o id: "+id));
    }
    @DeleteMapping("/deletek/{id}")
    public void deleteBook(@PathVariable Long id){
        kontoRepository.deleteById(id);
        new ResponseStatusException(HttpStatus.NOT_FOUND,"Nieznaleziono konta o id: "+id);
   }
    @PutMapping("/edytujSaldo/{id}")
    public Konto edytuj_saldo (@RequestBody Konto konto2,@PathVariable Long id){
    Konto konto=kontoRepository.findById(id).orElseThrow();
    konto.setSaldo(konto2.getSaldo());
    return kontoRepository.save(konto);
    new ResponseStatusException(HttpStatus.NOT_FOUND,"Nieznaleziono konta o id: "+id);
   }
}
