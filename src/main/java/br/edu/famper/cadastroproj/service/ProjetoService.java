package br.edu.famper.cadastroproj.service;

import br.edu.famper.cadastroproj.model.Projeto;
import br.edu.famper.cadastroproj.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public Projeto salvar(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public List<Projeto> findAll(){
        return (List<Projeto>) projetoRepository.findAll();
    }

    public Optional<Projeto> findById(Long id){
        return projetoRepository.findById(id);
    }

    public Projeto update(Projeto projeto) {
        Projeto salvo = projetoRepository.findById(projeto.getCodigo()).
                orElseThrow(() ->
                        new RuntimeException("Projeto não encontrado!")
                );
        salvo.setNome(projeto.getNome());
        salvo.setDescricao(projeto.getDescricao());
        salvo.setDataInicio(projeto.getDataInicio());
        salvo.setDataFim(projeto.getDataFim());
        return projetoRepository.save(salvo);
    }

    public void deleteById(Long id){
        projetoRepository.deleteById(id);
    }
}
