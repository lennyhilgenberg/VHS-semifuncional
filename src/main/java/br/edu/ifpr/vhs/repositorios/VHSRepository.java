package br.edu.ifpr.vhs.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpr.vhs.entidades.VHS;

@Repository
public interface VHSRepository extends JpaRepository<VHS, Long> {}