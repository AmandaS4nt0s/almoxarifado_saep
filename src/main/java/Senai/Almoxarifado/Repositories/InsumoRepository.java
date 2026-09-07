package Senai.Almoxarifado.Repositories;

import Senai.Almoxarifado.Entities.InsumoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InsumoRepository extends JpaRepository<InsumoEntity, Long> {

    List<InsumoEntity> findAllByOrderByDescricaoAsc();
}
