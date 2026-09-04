package se.anglerlog.showcase.session;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FishingSessionServiceTest {
    @Mock FishingSessionRepository repository;
    private final Clock clock = Clock.fixed(Instant.parse("2026-01-01T10:00:00Z"), ZoneOffset.UTC);
    @Test void startsAnActiveSessionForTheOwner() {
        FishingSessionService service = new FishingSessionService(repository, clock);
        when(repository.save(any(FishingSession.class))).thenAnswer(invocation -> invocation.getArgument(0));
        SessionResponse response = service.start("showcase-owner", new StartSessionRequest("Morning session"));
        assertThat(response.title()).isEqualTo("Morning session");
        assertThat(response.status()).isEqualTo(SessionStatus.ACTIVE);
        assertThat(response.startedAt()).isEqualTo(Instant.parse("2026-01-01T10:00:00Z"));
    }
}
