package br.com.itcpn.gamescorehub.exception.token;

public class TokenErrorInvalidOrExpiredException extends TokenErrorException {
    public TokenErrorInvalidOrExpiredException(String invalidOrExpiredTokenJwt) {
        super(invalidOrExpiredTokenJwt);
    }
}
