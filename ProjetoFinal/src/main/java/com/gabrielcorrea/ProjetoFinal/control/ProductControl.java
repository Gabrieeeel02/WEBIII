package com.gabrielcorrea.ProjetoFinal.control;

import com.gabrielcorrea.ProjetoFinal.model.ProductEntity;
import com.gabrielcorrea.ProjetoFinal.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Produtos")
    public class ProductControl {

        @Autowired
        private ProductRepository productRepository;

        @GetMapping
        public ResponseEntity<List<ProductEntity>> findAll() {
            return new ResponseEntity<List<ProductEntity>>(
                    (List<ProductEntity>) this.productRepository.findAll(),
                    new HttpHeaders(), HttpStatus.OK); //Error 404
        }

        @GetMapping(path = "/{id}")

        public ResponseEntity<ProductEntity> findById(@PathVariable("id") long id) {
            if (this.productRepository.findById(id).isPresent()) {
                return new ResponseEntity<ProductEntity>(
                        this.productRepository.findById(id).get(),
                        new HttpHeaders(),
                        HttpStatus.OK);
            }
            return new ResponseEntity<ProductEntity>(HttpStatus.NOT_FOUND);
        }

        @PutMapping(value = "/{id}")
        public ResponseEntity<ProductEntity> atualizar(@PathVariable("id") long id,
                                                       @RequestBody ProductEntity productEntity) throws Exception {
            if (id == 0 || !this.productRepository.existsById(id)) {
                throw new Exception("Código não encontrado ou inesistente!");
            }
            return new ResponseEntity<ProductEntity>(
                    this.productRepository.save(productEntity),
                    new HttpHeaders(),
                    HttpStatus.OK);

        }

        @DeleteMapping(value = "/{id}")
        public ResponseEntity<ProductEntity> deletar(@PathVariable("id") long id) {
            this.productRepository.deleteById(id);
            return new ResponseEntity<ProductEntity>(new HttpHeaders(), HttpStatus.OK);
        }

    }
