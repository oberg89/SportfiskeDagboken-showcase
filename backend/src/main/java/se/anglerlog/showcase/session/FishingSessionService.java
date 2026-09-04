package se.anglerlog.showcase.session;

import java.time.Clock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FishingSessionService {
    private final FishingSessionRepository sessions;
    // En injicerad klocka gör tidsberoendet tydligt och ger deterministiska tester.
    private final Clock clock;
    public FishingSessionService(FishingSessionRepository sessions, Clock clock) { this.sessions = sessions; this.clock = clock; }
    // Transaktionsgränsen ligger i service-lagret där lagring och svarsmappning hör till samma flöde.
    @Transactional
    public SessionResponse start(String ownerId, StartSessionRequest request) {
        FishingSession session = FishingSession.start(ownerId, request.title().trim(), clock.instant());
        return SessionResponse.from(sessions.save(session));
    }
}
