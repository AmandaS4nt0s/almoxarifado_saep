package Senai.Almoxarifado.Services;
import Senai.Almoxarifado.Dtos.EpisDto;
import Senai.Almoxarifado.Dtos.FerramentaDto;
import Senai.Almoxarifado.Dtos.InsumoDto;
import Senai.Almoxarifado.Entities.EpisEntity;
import Senai.Almoxarifado.Entities.FerramentaEntity;
import Senai.Almoxarifado.Entities.InsumoEntity;
import Senai.Almoxarifado.Repositories.EpiRepositoy;
import Senai.Almoxarifado.Repositories.FerramentaRepository;
import Senai.Almoxarifado.Repositories.InsumoRepository;
import org.springframework.stereotype.Service;

@Service
public class RecursoService {

    private final EpiRepositoy epiRepositoy;
    private final InsumoRepository insumoRepository;
    private final FerramentaRepository ferramentaRepository;

    public RecursoService(EpiRepositoy epiRepositoy, InsumoRepository insumoRepository, FerramentaRepository ferramentaRepository) {
        this.epiRepositoy = epiRepositoy;
        this.insumoRepository = insumoRepository;
        this.ferramentaRepository = ferramentaRepository;
    }

    public void CadastrarRecurso(EpisDto episDto, InsumoDto insumoDto, FerramentaDto ferramentaDto) {
        validarEpi(episDto);
        validarFerramenta(ferramentaDto);
        validarInsumo(insumoDto);
        epiRepositoy.save(converterEpiDtoParaEpiEntity(episDto));
        ferramentaRepository.save(converterFerramentaDtoParaFerramentaEntity(ferramentaDto));
        insumoRepository.save(converterInsumoDtoParaInsumoEntity(insumoDto));

    }

//------EPIS-----//

    private void validarEpi(EpisDto episDto) {
        if (episDto.)
    }

    private EpisEntity converterEpiDtoParaEpiEntity(EpisDto episDto) {

        EpisEntity epi = new EpisEntity();

        epi.setId(episDto.getId());
        epi.setNome(episDto.getNome());
        epi.setQuantidade(episDto.getQuantidade());
        epi.setTamanho(episDto.getTamanho());
        epi.setLocalizacao(episDto.getLocalizacao());

        return epi;
    }

    private EpisDto converterEpiEntityParaEpiDto(EpisEntity epi) {

        EpisDto episDto = new EpisDto();

        episDto.setId(epi.getId());
        episDto.setNome(epi.getNome());
        episDto.setQuantidade(epi.getQuantidade());
        episDto.setTamanho(epi.getTamanho());
        episDto.setLocalizacao(epi.getLocalizacao());

        return episDto;
    }

//------FERRAMENTA-----//

    private FerramentaEntity converterFerramentaDtoParaFerramentaEntity(FerramentaDto ferramentaDto) {

        FerramentaEntity ferramenta = new FerramentaEntity();

        ferramenta.setPatrimonio(ferramentaDto.getPatrimonio());
        ferramenta.setNome(ferramentaDto.getNome());
        ferramenta.setMarca(ferramentaDto.getMarca());
        ferramenta.setQuantidade(ferramentaDto.getQuantidade());
        ferramenta.setLocalizacao(ferramentaDto.getLocalizacao());

        return ferramenta;
    }

    private FerramentaDto converterFerramentaEntityParaFerramentaDto(FerramentaEntity ferramenta) {

        FerramentaDto ferramentaDto = new FerramentaDto();

        ferramentaDto.setPatrimonio(ferramenta.getPatrimonio());
        ferramentaDto.setNome(ferramenta.getNome());
        ferramentaDto.setMarca(ferramenta.getMarca());
        ferramentaDto.setQuantidade(ferramenta.getQuantidade());
        ferramentaDto.setLocalizacao(ferramenta.getLocalizacao());

        return ferramentaDto;
    }

//------INSUMO-----//

    private InsumoEntity converterInsumoDtoParaInsumoEntity(InsumoDto insumoDto) {

        InsumoEntity insumo = new InsumoEntity();

        insumo.setCodigo(insumoDto.getCodigo());
        insumo.setNome(insumoDto.getNome());
        insumo.setQuantidade(insumoDto.getQuantidade());

        return insumo;
    }

    private InsumoDto converterInsumoEntityParaInsumoDto(InsumoEntity insumo) {

        InsumoDto insumoDto = new InsumoDto();

        insumoDto.setCodigo(insumo.getCodigo());
        insumoDto.setNome(insumo.getNome());
        insumoDto.setQuantidade(insumo.getQuantidade());

        return insumoDto;
    }


}
