package Senai.Almoxarifado.Services;

import Senai.Almoxarifado.Dtos.EpisDto;
import Senai.Almoxarifado.Entities.EpisEntity;
import Senai.Almoxarifado.Repositories.EpiRepositoy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpiService {

    private final EpiRepositoy repository;

    public EpiService(EpiRepositoy repository) {
        this.repository = repository;
    }

    public EpisDto cadastrar(EpisDto dto) {
        validar(dto);
        EpisEntity entity = converterDtoParaEntity(dto);
        return converterEntityParaDto(repository.save(entity));
    }

    public List<EpisDto> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::converterEntityParaDto)
                .collect(Collectors.toList());
    }

    public EpisDto buscarPorId(Long id) {
        EpisEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("EPI não encontrado."));

        return converterEntityParaDto(entity);
    }

    public EpisDto atualizar(Long id, EpisDto dto) {
        validar(dto);

        EpisEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("EPI não encontrado."));

        entity.setNome(dto.getNome());
        entity.setQuantidade(dto.getQuantidade());
        entity.setTamanho(dto.getTamanho());
        entity.setLocalizacao(dto.getLocalizacao());

        return converterEntityParaDto(repository.save(entity));
    }

    public void excluir(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("EPI não encontrado."));

        repository.deleteById(id);
    }

    private void validar(EpisDto dto) {
        if (dto == null || dto.getNome() == null || dto.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome do EPI é obrigatório.");
        }
    }

    private EpisEntity converterDtoParaEntity(EpisDto dto) {
        EpisEntity entity = new EpisEntity();

        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setQuantidade(dto.getQuantidade());
        entity.setTamanho(dto.getTamanho());
        entity.setLocalizacao(dto.getLocalizacao());

        return entity;
    }

    private EpisDto converterEntityParaDto(EpisEntity entity) {
        EpisDto dto = new EpisDto();

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setQuantidade(entity.getQuantidade());
        dto.setTamanho(entity.getTamanho());
        dto.setLocalizacao(entity.getLocalizacao());

        return dto;
    }
}