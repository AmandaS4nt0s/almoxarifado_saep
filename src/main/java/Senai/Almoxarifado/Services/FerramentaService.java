package Senai.Almoxarifado.Services;

import Senai.Almoxarifado.Dtos.FerramentaDto;
import Senai.Almoxarifado.Entities.FerramentaEntity;
import Senai.Almoxarifado.Repositories.FerramentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FerramentaService {

    private final FerramentaRepository repository;

    public FerramentaService(FerramentaRepository repository) {
        this.repository = repository;
    }

    public FerramentaDto cadastrar(FerramentaDto dto) {
        validar(dto);
        FerramentaEntity entity = converterDtoParaEntity(dto);
        return converterEntityParaDto(repository.save(entity));
    }

    public List<FerramentaDto> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::converterEntityParaDto)
                .collect(Collectors.toList());
    }

    public FerramentaDto buscarPorId(Long id) {
        FerramentaEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ferramenta não encontrada."));

        return converterEntityParaDto(entity);
    }

    public FerramentaDto atualizar(Long id, FerramentaDto dto) {
        validar(dto);

        FerramentaEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ferramenta não encontrada."));

        entity.setPatrimonio(dto.getPatrimonio());
        entity.setNome(dto.getNome());
        entity.setMarca(dto.getMarca());
        entity.setQuantidade(dto.getQuantidade());
        entity.setLocalizacao(dto.getLocalizacao());

        return converterEntityParaDto(repository.save(entity));
    }

    public void excluir(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ferramenta não encontrada."));

        repository.deleteById(id);
    }

    private void validar(FerramentaDto dto) {
        if (dto == null || dto.getNome() == null || dto.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome da ferramenta é obrigatório.");
        }
    }

    private FerramentaEntity converterDtoParaEntity(FerramentaDto dto) {
        FerramentaEntity entity = new FerramentaEntity();

        entity.setPatrimonio(dto.getPatrimonio());
        entity.setNome(dto.getNome());
        entity.setMarca(dto.getMarca());
        entity.setQuantidade(dto.getQuantidade());
        entity.setLocalizacao(dto.getLocalizacao());

        return entity;
    }

    private FerramentaDto converterEntityParaDto(FerramentaEntity entity) {
        FerramentaDto dto = new FerramentaDto();

        dto.setPatrimonio(entity.getPatrimonio());
        dto.setNome(entity.getNome());
        dto.setMarca(entity.getMarca());
        dto.setQuantidade(entity.getQuantidade());
        dto.setLocalizacao(entity.getLocalizacao());

        return dto;
    }
}