package br.edu.ifpr.vhs.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpr.vhs.entidades.VHS;
import br.edu.ifpr.vhs.repositorios.VHSRepository;

@Service
public class VHSService {
    
    @Autowired
    VHSRepository vhsRepository;
    
    public List<VHS> findAll() {
        return vhsRepository.findAll();
    }


}