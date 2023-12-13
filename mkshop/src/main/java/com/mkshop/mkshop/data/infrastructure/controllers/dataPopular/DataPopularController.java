package com.mkshop.mkshop.data.infrastructure.controllers.dataPopular;

import com.mkshop.mkshop.data.infrastructure.services.DataPopularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataPopularController {
    @Autowired
    private DataPopularService dataPopularService;

    @PostMapping("/populate-db")
    public ResponseEntity<String> populateDatabase() {
        this.dataPopularService.populateDatabaseWithSampleData();
        return ResponseEntity.ok("Dados de exemplo adicionados com sucesso!");
    }
}
