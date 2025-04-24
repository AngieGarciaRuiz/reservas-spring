package org.example.repaso01.repository;

import org.example.repaso01.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository  extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
}
