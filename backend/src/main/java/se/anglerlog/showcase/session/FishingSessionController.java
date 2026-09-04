package se.anglerlog.showcase.session;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sessions")
public class FishingSessionController {
    private final FishingSessionService service;
    public FishingSessionController(FishingSessionService service) { this.service = service; }
    // HTTP-lagret validerar inkommande DTO innan service-lagret får ta över flödet.
    @PostMapping
    public SessionResponse start(@RequestHeader("X-Showcase-Owner") String ownerId, @Valid @RequestBody StartSessionRequest request) {
        return service.start(ownerId, request);
    }
}
