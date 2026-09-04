package se.anglerlog.showcase.session;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishingSessionRepository extends JpaRepository<FishingSession, UUID> { }
