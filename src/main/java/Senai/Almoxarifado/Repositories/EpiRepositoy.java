package Senai.Almoxarifado.Repositories;

import Senai.Almoxarifado.Entities.EpisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpiRepositoy extends JpaRepository<EpisEntity, Long> {

    List<EpisEntity> findAllByOrderByDescricaoAsc();

}
