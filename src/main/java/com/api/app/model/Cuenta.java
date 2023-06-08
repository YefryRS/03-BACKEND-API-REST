package com.api.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "cuentas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cuenta extends RepresentationModel<Cuenta> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 20,nullable = false,unique = true)
    private String numeroDeCuenta;
    private double monto;

}
