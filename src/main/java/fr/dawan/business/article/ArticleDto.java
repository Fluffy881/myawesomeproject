package fr.dawan.business.article;

import fr.dawan.business.category.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private long id;
    private int version;
    private String title;
    private ArticleCategoryDto category;

}
