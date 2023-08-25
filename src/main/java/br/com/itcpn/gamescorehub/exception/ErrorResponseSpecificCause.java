package br.com.itcpn.gamescorehub.exception;

import java.time.LocalDateTime;

public record ErrorResponseSpecificCause(int status, LocalDateTime timestamp, String error, String specificCause) {
}
