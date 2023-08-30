package br.com.itcpn.gamescorehub.exception.dto;

import java.time.LocalDateTime;

public record ErrorResponse (int status, LocalDateTime timestamp, String error, String message, String field) {
}

