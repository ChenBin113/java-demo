package _13_stream;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Book {
    private String name;
    private int id;
    private int price;

    public static void main(String[] args) {
        Book book = new Book();
        book.setId(1).setName("红楼梦").setPrice(40);
        System.out.println(book);
    }
}
