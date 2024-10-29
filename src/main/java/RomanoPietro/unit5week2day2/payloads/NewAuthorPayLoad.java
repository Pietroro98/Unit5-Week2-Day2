package RomanoPietro.unit5week2day2.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class NewAuthorPayLoad {
    private String name;
    private String surname;
    private String email;
    private String dateOfBirth;
}
