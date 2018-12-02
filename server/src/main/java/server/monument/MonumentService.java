package server.monument;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonumentService {

    private final MonumentRepository monumentRepository;

    public MonumentService(MonumentRepository monumentRepository) {
        this.monumentRepository = monumentRepository;
    }

    public MonumentEntity getMonument(Integer monumentId){
        if(!monumentRepository.exists(monumentId)){
            throw new IllegalArgumentException("Zabytek nie istnieje");
        }
        return monumentRepository.findOne(monumentId);
    }

    public List<MonumentEntity> getAllMonuments(){
        return monumentRepository.findAll();
    }

    public List<MonumentEntity> getMonumentsByKind(String kind){
        return monumentRepository.findMonumentEntitiesByKind(kind);
    }

    public void addMonument(MonumentEntity monument){
        if(!monument.validate()){
            throw new IllegalArgumentException("Podano nieprawidowe dane");
        }
        monumentRepository.save(monument);
    }

    public void updateMonument(Integer monumentId, MonumentEntity monument){
        if(!monumentRepository.exists(monumentId)){
            throw new IllegalArgumentException("Zabytek nie istnieje!");
        }
        if(!monument.validate()){
            throw new IllegalArgumentException("Podano nieprawidowe dane");
        }
        MonumentEntity dbMonument = monumentRepository.findOne(monumentId);
        dbMonument.setCoordinate(monument.getCoordinate());
        dbMonument.setCost(monument.getCost());
        dbMonument.setDescription(monument.getDescription());
        dbMonument.setKind(monument.getKind());
        dbMonument.setName(monument.getName());
        dbMonument.setOpeningHours(monument.getOpeningHours());
        monumentRepository.save(dbMonument);
    }

    public void deleteMonument(Integer monumentId){
        if(!monumentRepository.exists(monumentId)){
            throw new IllegalArgumentException("Zabytek nie istnieje!");
        }
        monumentRepository.delete(monumentId);
    }
}
