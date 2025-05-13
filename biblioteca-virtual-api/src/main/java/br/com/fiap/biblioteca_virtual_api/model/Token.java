package br.com.fiap.biblioteca_virtual_api.model;

public record Token(
    String token, 
    String type,
    String email
) {}
