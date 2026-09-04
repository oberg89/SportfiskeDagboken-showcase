package se.anglerlog.showcase.session;

import java.time.Instant;
import java.util.UUID;

public record SessionResponse(UUID id, String title, Instant startedAt, SessionStatus status) {
    // En separat response-DTO håller persistensmodellen och ägarinformationen utanför API-svaret.
    static SessionResponse from(FishingSession session) { return new SessionResponse(session.id(), session.title(), session.startedAt(), session.status()); }
}
