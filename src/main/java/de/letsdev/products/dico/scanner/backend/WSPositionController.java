package de.letsdev.products.dico.scanner.backend;

import de.letsdev.products.dico.scanner.backend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WSPositionController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(
            value = "/position/{device_id}",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public ResponseEntity<APIResponse> position(@PathVariable("device_id") String device_id, @RequestBody Position position) {
        // business logic
        locationService.savePosition(device_id, position);
        return new ResponseEntity<>(new APIResponse("success", false), HttpStatus.ACCEPTED);
    }

}
