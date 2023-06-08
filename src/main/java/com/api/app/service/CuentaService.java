package com.api.app.service;

import com.api.app.model.Cuenta;
import com.api.app.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    // Create y Update
    public Cuenta save(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    // Read
    public List<Cuenta> listAll() {
        return cuentaRepository.findAll();
    }
    public Cuenta get(Integer id) {
        return cuentaRepository.findById(id).get();
    }

    // Delete
    public void delete(int id) {
        cuentaRepository.deleteById(id);
    }

}
