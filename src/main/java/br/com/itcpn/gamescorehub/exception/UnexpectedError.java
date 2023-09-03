package br.com.itcpn.gamescorehub.exception;

public class UnexpectedError extends RuntimeException {
    public UnexpectedError(String unexpectedError) {
        super(unexpectedError);
    }
}
