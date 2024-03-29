package fr.dawan.business.category;

import fr.dawan.business.article.ArticleCategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryArticleDto {
    private long id;
    private String title;

}
