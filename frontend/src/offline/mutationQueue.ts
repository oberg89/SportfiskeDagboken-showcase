export type PendingMutation<T> = { id: string; createdAt: string; payload: T };
const key = "angler-log-showcase:pending-mutations";
function read<T>(): PendingMutation<T>[] { return JSON.parse(localStorage.getItem(key) ?? "[]") as PendingMutation<T>[]; }
function write<T>(items: PendingMutation<T>[]): void { localStorage.setItem(key, JSON.stringify(items)); }
export function enqueue<T>(mutation: PendingMutation<T>): void { write([...read<T>(), mutation].sort((a, b) => a.createdAt.localeCompare(b.createdAt))); }
export function list<T>(): PendingMutation<T>[] { return read<T>(); }
export function acknowledge(id: string): void { write(read<unknown>().filter((mutation) => mutation.id !== id)); }
