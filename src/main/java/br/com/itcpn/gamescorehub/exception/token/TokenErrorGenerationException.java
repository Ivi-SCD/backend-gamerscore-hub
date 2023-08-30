package br.com.itcpn.gamescorehub.exception.token;

public class TokenErrorGenerationException extends TokenErrorException {
    public TokenErrorGenerationException(String errorWhileGeneratingToken) {
        super(errorWhileGeneratingToken);
    }
}
