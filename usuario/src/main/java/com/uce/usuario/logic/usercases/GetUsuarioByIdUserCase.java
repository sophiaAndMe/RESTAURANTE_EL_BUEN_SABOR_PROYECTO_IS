package com.uce.usuario.logic.usercases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.usuario.controllers.data.converters.EntityConverters;
import com.uce.usuario.controllers.data.entities.UsuarioEntityUI;
import com.uce.usuario.data.repository.UsuarioRepository;
import com.uce.usuario.logic.validators.Result;

@Service
public class GetUsuarioByIdUserCase {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Result<UsuarioEntityUI> execute(Integer id) {
        try {
            var usuarioOptional = usuarioRepository.findById(id);
            if (usuarioOptional.isPresent()) {
                return Result.success(EntityConverters.usuarioEntityDbToUI(usuarioOptional.get()));
            } else {
                return Result.failure(new Exception("Usuario con ID " + id + " no encontrado"));
            }
        } catch (Exception e) {
            return Result.failure(e);
        }
    }

}
