package com.elbuensabor.usuario.logic.usercases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elbuensabor.usuario.controllers.data.converters.EntityConverters;
import com.elbuensabor.usuario.controllers.data.entities.UsuarioEntityUI;
import com.elbuensabor.usuario.data.entities.db.UsuarioEntityDb;
import com.elbuensabor.usuario.data.repository.UsuarioRepository;
import com.elbuensabor.usuario.logic.validators.Result;

@Service
public class RegisterUsuarioUserCase {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Result<UsuarioEntityUI> execute(
            String nombre,
            String apellido,
            String email,
            String password) {

        Result<UsuarioEntityUI> result;

        try {
            var usuarioBuilder = UsuarioEntityDb.builder()
                    .nombreUsuario(nombre)
                    .apellidoUsuario(apellido)
                    .emailUsuario(email)
                    .passwordUsuario(password);

            var usuario = usuarioBuilder.build();
            var usuarioSaved = usuarioRepository.save(usuario);
            result = Result.success(
                    EntityConverters.usuarioEntityDbToUI(usuarioSaved));

        } catch (Exception e) {
            result = Result.failure(e);
        }

        return result;
    }

}
