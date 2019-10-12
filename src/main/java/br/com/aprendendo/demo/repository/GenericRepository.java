package br.com.aprendendo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface GenericRepository<T,ID> extends JpaRepository<T, ID>{
    
}
