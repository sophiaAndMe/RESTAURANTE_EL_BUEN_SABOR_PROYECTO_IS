package com.elbuensabor.usuario.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elbuensabor.usuario.data.entities.db.UsuarioEntityDb;

public interface UsuarioRepository extends JpaRepository<UsuarioEntityDb, Integer> {

        

}
