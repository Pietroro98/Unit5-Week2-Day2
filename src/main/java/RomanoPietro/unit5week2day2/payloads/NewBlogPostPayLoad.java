package RomanoPietro.unit5week2day2.payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class NewBlogPostPayLoad {
    private String category;
    private String title;
    private String content;
    private int readingTime;
}
