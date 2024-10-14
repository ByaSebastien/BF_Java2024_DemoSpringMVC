package be.bstorm.bf_java_2024_demospringmvc.pl.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookForm {

    private String isbn;
    private String title;
}
