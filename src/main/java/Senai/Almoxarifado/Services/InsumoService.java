package Senai.Almoxarifado.Services;

import Senai.Almoxarifado.Dtos.InsumoDto;
import Senai.Almoxarifado.Entities.InsumoEntity;
import Senai.Almoxarifado.Repositories.InsumoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsumoService {

    private final InsumoRepository repository;

    public InsumoService(InsumoRepository repository) {
        this.repository = repository;
    }

    public InsumoDto cadastrar(InsumoDto dto) {
        validar(dto);
        InsumoEntity entity = converterDtoParaEntity(dto);
        return converterEntityParaDto(repository.save(entity));
    }

    public List<InsumoDto> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::converterEntityParaDto)
                .collect(Collectors.toList());
    }

    public InsumoDto buscarPorId(Long id) {
        InsumoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insumo não encontrado."));

        return converterEntityParaDto(entity);
    }

    public InsumoDto atualizar(Long id, InsumoDto dto) {
        validar(dto);

        InsumoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insumo não encontrado."));

        entity.setCodigo(dto.getCodigo());
        entity.setNome(dto.getNome());
        entity.setQuantidade(dto.getQuantidade());

        return converterEntityParaDto(repository.save(entity));
    }

    public void excluir(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insumo não encontrado."));

        repository.deleteById(id);
    }

    private void validar(InsumoDto dto) {
        if (dto == null || dto.getNome() == null || dto.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome do insumo é obrigatório.");
        }
    }

    private InsumoEntity converterDtoParaEntity(InsumoDto dto) {
        InsumoEntity entity = new InsumoEntity();

        entity.setCodigo(dto.getCodigo());
        entity.setNome(dto.getNome());
        entity.setQuantidade(dto.getQuantidade());

        return entity;
    }

    private InsumoDto converterEntityParaDto(InsumoEntity entity) {
        InsumoDto dto = new InsumoDto();

        dto.setCodigo(entity.getCodigo());
        dto.setNome(entity.getNome());
        dto.setQuantidade(entity.getQuantidade());

        return dto;
    }
}