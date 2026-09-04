export type PendingMutation<T> = { id: string; createdAt: string; payload: T };
const key = "angler-log-showcase:pending-mutations";
function read<T>(): PendingMutation<T>[] { return JSON.parse(localStorage.getItem(key) ?? "[]") as PendingMutation<T>[]; }
function write<T>(items: PendingMutation<T>[]): void { localStorage.setItem(key, JSON.stringify(items)); }
// Ändringen sparas lokalt först, så den ligger kvar som pending även om nätet försvinner.
// Tidsordningen ger ett förutsägbart replay-flöde när klienten senare kan försöka igen.
export function enqueue<T>(mutation: PendingMutation<T>): void { write([...read<T>(), mutation].sort((a, b) => a.createdAt.localeCompare(b.createdAt))); }
export function list<T>(): PendingMutation<T>[] { return read<T>(); }
// En post tas bort först när klienten kvitterar den; fram till dess kan samma id användas vid retry.
export function acknowledge(id: string): void { write(read<unknown>().filter((mutation) => mutation.id !== id)); }
