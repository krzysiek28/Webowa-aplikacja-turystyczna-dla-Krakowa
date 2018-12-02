package server.marker;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkerService {

    private final MarkerRepository markerRepository;

    public MarkerService(MarkerRepository markerRepository) {
        this.markerRepository = markerRepository;
    }

    public List<MarkerEntity> getMarkersByUserId(Integer userId){
        return markerRepository.findAllByOwner(userId);
    }

    public List<MarkerEntity> getAllMarkers(){
        return markerRepository.findAll();
    }

    public void addMarker(MarkerEntity marker){
        if(!marker.validate()){
            throw new IllegalArgumentException("Podano nieprawidowe dane");
        }
        markerRepository.save(marker);
    }

    public void updateMarker(Integer markerId, MarkerEntity marker){
        if(!markerRepository.exists(markerId)){
            throw new IllegalArgumentException("Znacznik nie istnieje!");
        }
        if(!marker.validate()){
            throw new IllegalArgumentException("Podano nieprawidowe dane");
        }
        MarkerEntity dbMarker = markerRepository.findOne(markerId);
        dbMarker.setCoordinate(marker.getCoordinate());
        dbMarker.setDescription(marker.getDescription());
        dbMarker.setName(marker.getName());
        dbMarker.setType(marker.getType());
        dbMarker.setOwner(marker.getOwner());
        markerRepository.save(dbMarker);
    }

    public void deleteMarker(Integer markerId){
        if(!markerRepository.exists(markerId)){
            throw new IllegalArgumentException("Znacznik nie istnieje!");
        }
        markerRepository.delete(markerId);
    }
}
