package se.anglerlog.showcase.session;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StartSessionRequest(@NotBlank @Size(max = 80) String title) { }
