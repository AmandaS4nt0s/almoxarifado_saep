package Senai.Almoxarifado.Repositories;

import Senai.Almoxarifado.Entities.FerramentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FerramentaRepository extends JpaRepository<FerramentaEntity, Long> {

    List<FerramentaEntity> findAllByOrderByDescricaoAsc();
}
