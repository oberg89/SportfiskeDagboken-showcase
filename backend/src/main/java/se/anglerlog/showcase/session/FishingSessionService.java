package se.anglerlog.showcase.session;

import java.time.Clock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FishingSessionService {
    private final FishingSessionRepository sessions;
    private final Clock clock;
    public FishingSessionService(FishingSessionRepository sessions, Clock clock) { this.sessions = sessions; this.clock = clock; }
    @Transactional
    public SessionResponse start(String ownerId, StartSessionRequest request) {
        FishingSession session = FishingSession.start(ownerId, request.title().trim(), clock.instant());
        return SessionResponse.from(sessions.save(session));
    }
}
