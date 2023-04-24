package pro.sky.testjunit.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        if (!name.isEmpty() && !name.isBlank()) {
            this.name = name;
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
