import type { FishingSession, StartSessionCommand } from "../domain";
export class ApiClient {
  async startSession(command: StartSessionCommand): Promise<FishingSession> {
    const response = await fetch("/api/sessions", { method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify(command) });
    if (!response.ok) throw new Error("The session could not be saved.");
    return response.json() as Promise<FishingSession>;
  }
}
