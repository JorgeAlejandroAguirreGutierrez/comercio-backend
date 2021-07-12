package com.backend.comercio.datos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.backend.comercio.modelos.Sesion;
import com.backend.comercio.modelos.Usuario;
import com.backend.comercio.repositorios.IUsuarioRepository;

@Component
@Order(1)
@Profile({"dev","prod"})
public class UsuarioDatos implements ApplicationRunner {
	@Autowired
    private IUsuarioRepository rep;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<Usuario> ant=rep.findById((long) 1);
        if (!ant.isPresent()) {
            List<Usuario> usuarios = new ArrayList<>();
            usuarios.add(new Usuario("JORGE ALEJANDRO AGUIRRE GUTIERREZ", "1053847607", "admin123", new ArrayList<Sesion>()));
            usuarios.add(new Usuario("MARIO DELGADO", "0603467226", "admin123", new ArrayList<Sesion>()));
            
            rep.saveAll(usuarios);
        }
    }
}
