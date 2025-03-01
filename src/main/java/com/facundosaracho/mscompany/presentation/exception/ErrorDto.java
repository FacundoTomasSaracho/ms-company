package com.facundosaracho.mscompany.presentation.exception;

import io.swagger.v3.oas.annotations.media.Schema;

public record ErrorDto(@Schema(example = "500", description = "Http status code") Integer code,
                       @Schema(example = "INTERNAL_SERVER_ERROR", examples = "Http error message") String message) {
}
