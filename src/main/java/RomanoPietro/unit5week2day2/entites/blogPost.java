package RomanoPietro.unit5week2day2.entites;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class blogPost {
    private int id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private int readingTime;

    public blogPost(String category, String title, String content, int readingTime) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.readingTime = readingTime;
    }
}
