package br.com.itcpn.gamescorehub.exception.user;

public class UserWithEmailOrNicknameAlreadyExistsException extends RuntimeException {

    public UserWithEmailOrNicknameAlreadyExistsException(String message) {
        super(message);
    }
}
