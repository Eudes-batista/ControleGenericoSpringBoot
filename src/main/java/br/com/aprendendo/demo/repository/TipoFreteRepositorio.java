/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aprendendo.demo.repository;

import br.com.aprendendo.demo.model.TipoFrete;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TipoFreteRepositorio extends JpaRepository<TipoFrete, Integer>{
    
    public Page<TipoFrete> findByNomeIgnoreCaseContaining(String nome,Pageable pageable);
    
}
