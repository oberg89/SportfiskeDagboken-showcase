import { ApiClient } from "./api/client";
import { renderSessionForm } from "./features/sessionForm";
import "./styles.css";
renderSessionForm(document.querySelector<HTMLElement>("#app")!, new ApiClient());
