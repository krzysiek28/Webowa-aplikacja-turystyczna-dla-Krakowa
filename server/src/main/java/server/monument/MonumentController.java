package server.monument;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import server.monument.model.MonumentKind;

@Controller
@RequestMapping("/monuments")
public class MonumentController {

    private final MonumentService monumentService;

    public MonumentController(MonumentService monumentService) {
        this.monumentService = monumentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void getAllMonuments() {
        monumentService.getAllMonuments();
    }

    //usunac i zrobic filtry po stronie serwera w razie problemow.
    @RequestMapping(value = "/{kind}", method = RequestMethod.GET)
    public void getMonumentsByKind(@PathVariable MonumentKind kind) {
        monumentService.getMonumentsByKind(kind);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addMonument(@RequestBody MonumentEntity monument) {
        monumentService.addMonument(monument);
    }

    @RequestMapping(value = "/{monumentId}", method = RequestMethod.PUT)
    public void updateMonument(@RequestBody MonumentEntity monument, @PathVariable String monumentId) {
        monumentService.updateMonument(Integer.parseInt(monumentId), monument);
    }

    @RequestMapping(value = "/{monumentId}", method = RequestMethod.DELETE)
    public void deleteMonument(@PathVariable String monumentId) {
        monumentService.deleteMonument(Integer.parseInt(monumentId));
    }
}
