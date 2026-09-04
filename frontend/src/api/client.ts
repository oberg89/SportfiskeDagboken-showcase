import type { FishingSession, StartSessionCommand } from "../domain";
export class ApiClient {
  async startSession(command: StartSessionCommand): Promise<FishingSession> {
    // `fetch` kapslas in bakom en API-gräns så att UI-koden inte behöver känna till transportdetaljer.
    const response = await fetch("/api/sessions", { method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify(command) });
    if (!response.ok) throw new Error("The session could not be saved.");
    return response.json() as Promise<FishingSession>;
  }
}
