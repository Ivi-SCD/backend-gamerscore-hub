package br.com.itcpn.gamescorehub.exception.token;

public class TokenErrorException extends RuntimeException {
    public TokenErrorException(String error) {
        super(error);
    }
}
