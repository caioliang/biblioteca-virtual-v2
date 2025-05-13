package br.com.fiap.biblioteca_virtual_api.model;

import java.time.LocalDate;

public record ReviewFilter (String drescription, LocalDate startData, LocalDate endDate ) {

}
