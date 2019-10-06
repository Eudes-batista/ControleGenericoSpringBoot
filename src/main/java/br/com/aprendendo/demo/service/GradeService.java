package br.com.aprendendo.demo.service;

import br.com.aprendendo.demo.model.Grade;
import br.com.aprendendo.demo.model.GradePK;
import br.com.aprendendo.demo.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GradeService extends DefaultService<Grade,GradePK>{

    private final GradeRepository gradeRepository;
    
    @Autowired
    public GradeService(GradeRepository gradeRepository) {
        super(gradeRepository);
        this.gradeRepository = gradeRepository;
    }

    @Override
    public String[] getCamposASeremIgnoradosNaAlteracao() {
        return new String[]{"gradePK"};
    }

    @Override
    public Page<Grade> pesquisarConteudo(String pesquisa, Pageable pageable) {
        return this.gradeRepository.findByNomeIgnoreCaseContaining(pesquisa, pageable);
    }
    
}
