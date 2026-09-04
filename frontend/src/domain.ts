export type SessionStatus = "ACTIVE" | "COMPLETED";
export type FishingSession = { id: string; title: string; startedAt: string; status: SessionStatus };
export type StartSessionCommand = { title: string };
