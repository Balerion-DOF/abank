package com.example.Abank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/konto")
public class KontoController {

    private final DepositService depositService;
    private final KontoRepository kontoRepository;
    private final WyplataService wyplataService;
    public KontoController(KontoRepository kontoRepository, DepositService depositService,WyplataService wyplataService){
        //Dependecy Injection //Wstrzykiwanie zależności
        this.kontoRepository=kontoRepository;
        this.depositService = depositService;
        this.wyplataService=wyplataService;
    }
    @GetMapping("/getAll")
    public List<Konto> getAll(){
        new ResponseStatusException(HttpStatus.NOT_FOUND,"Nie można dojśc do strony");
        return kontoRepository.findAll();
    }

    @PostMapping("/dodajK")
    public Konto addKonto(@RequestBody Konto konto){
        new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Nie można użyć tego polecenia");
        return kontoRepository.save(konto);
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
    public Konto edytuj_saldo (@RequestBody Konto konto2,@PathVariable Long id) {
        Konto konto = kontoRepository.findById(id).orElseThrow();
        konto.setSaldo(konto2.getSaldo());
        new ResponseStatusException(HttpStatus.NOT_FOUND, "Nieznaleziono konta o id: " + id);
        return kontoRepository.save(konto);
    }

    @PostMapping("/depozyt")
            public ResponseEntity<Double> deposit (@RequestParam double balance,@RequestParam double amount){
       double newbalance= depositService.deposit(balance,amount);
       return ResponseEntity.ok(newbalance);
    }
    @PostMapping("/wyplata")
    public ResponseEntity<Double>wyplata (@RequestParam double balance,@RequestParam double amount){
        double newbalance= wyplataService.wyplata(balance,amount);
        return ResponseEntity.ok(newbalance);
    }

}
