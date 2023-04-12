package pro.sky.testjunit.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String login;
    private String email;

    public User(String login, String email) {
        if (!login.isEmpty() && !login.isBlank()) {
            this.login = login;
        } else {
            throw new IllegalArgumentException();
        }
        if (email.contains("@") && email.contains(".")
                && email.indexOf("@") < email.lastIndexOf(".")
                && email.indexOf("@") > 0
                && email.charAt(email.indexOf("@") + 1) != '.') { //потому что точка не может идти сразу после "@"
            this.email = email;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
