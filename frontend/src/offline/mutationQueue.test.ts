import { beforeEach, describe, expect, it } from "vitest";
import { acknowledge, enqueue, list } from "./mutationQueue";
describe("offline mutation queue", () => {
  beforeEach(() => localStorage.clear());
  // Om poster läggs in ur ordning ska replay ändå följa skapandetiden och bara kvitterat arbete försvinna.
  it("keeps mutations in creation order and removes acknowledged work", () => {
    enqueue({ id: "later", createdAt: "2026-01-01T10:01:00Z", payload: { title: "Later" } });
    enqueue({ id: "first", createdAt: "2026-01-01T10:00:00Z", payload: { title: "First" } });
    expect(list<{ title: string }>().map((item) => item.id)).toEqual(["first", "later"]);
    acknowledge("first"); expect(list<{ title: string }>().map((item) => item.id)).toEqual(["later"]);
  });
});
