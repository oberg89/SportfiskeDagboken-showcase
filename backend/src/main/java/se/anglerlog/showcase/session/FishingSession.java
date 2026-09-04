package se.anglerlog.showcase.session;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Entity
public class FishingSession {
    @Id private UUID id;
    private String ownerId;
    private String title;
    private Instant startedAt;
    @Enumerated(EnumType.STRING) private SessionStatus status;
    // JPA behöver en parameterlös konstruktor, men domänobjekt skapas i övrigt via fabriksmetoden nedan.
    protected FishingSession() { }
    private FishingSession(UUID id, String ownerId, String title, Instant startedAt) {
        this.id = id; this.ownerId = ownerId; this.title = title; this.startedAt = startedAt; this.status = SessionStatus.ACTIVE;
    }
    // Fabriken samlar startregeln: en ny session får identitet direkt och börjar alltid som ACTIVE.
    public static FishingSession start(String ownerId, String title, Instant startedAt) { return new FishingSession(UUID.randomUUID(), ownerId, title, startedAt); }
    public UUID id() { return id; }
    public String title() { return title; }
    public Instant startedAt() { return startedAt; }
    public SessionStatus status() { return status; }
}
