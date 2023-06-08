package com.api.app.controller;

import com.api.app.model.Cuenta;
import com.api.app.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    // El response Entity nos devuelve un entity
    @GetMapping
    public ResponseEntity<List<Cuenta>> getAllCuenta() {
        List<Cuenta> cuentas = cuentaService.listAll(); // Nos trae las cuentas de BBDD

        if(cuentas.isEmpty()) { // Si esta vacio retornar que no hay contenido
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(cuentas, HttpStatus.OK); // Si contiene algo, retorna un estatus Ok.
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> listarCuenta(@PathVariable Integer id) {
        try {
            Cuenta cuenta = cuentaService.get(id);
            return new ResponseEntity<>(cuenta,HttpStatus.OK);
        }catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<Cuenta> guardarCuenta(@RequestBody Cuenta cuenta) {
        Cuenta cuenta1 = cuentaService.save(cuenta);
        return new ResponseEntity<>(cuenta,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cuenta> actualizarCuenta(@RequestBody Cuenta cuenta) {
        Cuenta cuenta1 = cuentaService.save(cuenta);
        return new ResponseEntity<>(cuenta1,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCuenta(@PathVariable Integer id) {
        try {
            cuentaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }


}
