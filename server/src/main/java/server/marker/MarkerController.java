package server.marker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/marker")
public class MarkerController {

    private final MarkerService markerService;

    public MarkerController(MarkerService markerService) {
        this.markerService = markerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<MarkerEntity> getAllMarkers(){
        return markerService.getAllMarkers();
    }

    @RequestMapping(value = "/owner/{ownerId}", method = RequestMethod.GET)
    public List<MarkerEntity> getAllMarkersByOwner(@PathVariable String ownerId, @RequestHeader("Authorization") String token){
        return markerService.getMarkersByUserId(Integer.parseInt(ownerId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addMonument(@RequestBody MarkerEntity marker, @RequestHeader("Authorization") String token) {
        markerService.addMarker(marker);
    }

    @RequestMapping(value = "/{markerId}", method = RequestMethod.PUT)
    public void updateMonument(@RequestBody MarkerEntity marker, @PathVariable String markerId, @RequestHeader("Authorization") String token) {
        markerService.updateMarker(Integer.parseInt(markerId), marker);
    }

    @RequestMapping(value = "/{markerId}", method = RequestMethod.DELETE)
    public void deleteMonument(@PathVariable String markerId, @RequestHeader("Authorization") String token) {
        markerService.deleteMarker(Integer.parseInt(markerId));
    }
}
