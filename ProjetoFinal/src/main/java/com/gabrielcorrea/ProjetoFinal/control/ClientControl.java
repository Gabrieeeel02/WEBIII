package com.gabrielcorrea.ProjetoFinal.control;


import com.gabrielcorrea.ProjetoFinal.model.ClientEntity;
import com.gabrielcorrea.ProjetoFinal.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

@RestController
@RequestMapping("/Clientes")
public class ClientControl {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public ResponseEntity<List<ClientEntity>> findAll(){
        return new ResponseEntity<List<ClientEntity>>(
                (List<ClientEntity>) this.clientRepository.findAll(),
                new HttpHeaders(), HttpStatus.OK); //Error 404
    }

    @GetMapping(path = "/{id}")

    public ResponseEntity<ClientEntity> findById(@PathVariable ("id") long id){
        if(this.clientRepository.findById(id).isPresent()){
            return new ResponseEntity<ClientEntity>(
                    this.clientRepository.findById(id).get(),
                    new HttpHeaders(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<ClientEntity>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientEntity> atualizar (@PathVariable("id") long id,
                                                   @RequestBody ClientEntity clientEntity) throws Exception{
        if(id == 0 || !this.clientRepository.existsById(id)){
            throw new Exception("Código não encontrado ou inesistente!");
        }
        return new ResponseEntity<ClientEntity>(
                this.clientRepository.save(clientEntity),
                new HttpHeaders(),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClientEntity> deletar (@PathVariable("id") long id){
        this.clientRepository.deleteById(id);
        return new ResponseEntity<ClientEntity>(new HttpHeaders(), HttpStatus.OK);
    }


}
