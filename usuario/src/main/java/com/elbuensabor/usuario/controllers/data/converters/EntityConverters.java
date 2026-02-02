package com.elbuensabor.usuario.controllers.data.converters;

import com.elbuensabor.usuario.controllers.data.entities.UsuarioEntityUI;
import com.elbuensabor.usuario.data.entities.db.UsuarioEntityDb;

public class EntityConverters {

    public static UsuarioEntityUI usuarioEntityDbToUI(UsuarioEntityDb usuarioEntityDb) {
        if (usuarioEntityDb == null) {
            return null;
        }

        UsuarioEntityUI usuarioEntityUI = new UsuarioEntityUI();
        usuarioEntityUI.setId(usuarioEntityDb.getId());
        usuarioEntityUI.setName(usuarioEntityDb.getNombreUsuario());
        usuarioEntityUI.setLastName(usuarioEntityDb.getApellidoUsuario());
        usuarioEntityUI.setEmail(usuarioEntityDb.getEmailUsuario());

        return usuarioEntityUI;
    }

    public static UsuarioEntityDb usuarioEntityUIToDb(UsuarioEntityUI usuarioEntityUI) {
        if (usuarioEntityUI == null) {
            return null;
        }

        UsuarioEntityDb usuarioEntityDb = new UsuarioEntityDb();
        usuarioEntityDb.setId(usuarioEntityUI.getId());
        usuarioEntityDb.setNombreUsuario(usuarioEntityUI.getName());
        usuarioEntityDb.setApellidoUsuario(usuarioEntityUI.getLastName());
        usuarioEntityDb.setEmailUsuario(usuarioEntityUI.getEmail());

        return usuarioEntityDb;
    }
}
