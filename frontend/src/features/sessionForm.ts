import type { ApiClient } from "../api/client";
export function renderSessionForm(target: HTMLElement, client: ApiClient): void {
  target.innerHTML = `<section><h1>Start a fishing session</h1><form><label>Session title <input name="title" maxlength="80" required /></label><button>Start</button></form><p aria-live="polite"></p></section>`;
  const form = target.querySelector("form")!; const message = target.querySelector("p")!;
  form.addEventListener("submit", async (event) => { event.preventDefault(); const title = new FormData(form).get("title")?.toString().trim() ?? "";
    try { const session = await client.startSession({ title }); message.textContent = `Session started: ${session.title}`; }
    catch { message.textContent = "Unable to save now. A complete product would queue this mutation for recovery."; }
  });
}
