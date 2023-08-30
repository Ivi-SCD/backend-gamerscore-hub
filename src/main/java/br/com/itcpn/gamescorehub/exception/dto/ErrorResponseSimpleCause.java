package br.com.itcpn.gamescorehub.exception.dto;

import java.time.LocalDateTime;

public record ErrorResponseSimpleCause(int status, LocalDateTime instant, String message) {
}
