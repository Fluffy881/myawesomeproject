package fr.dawan.business.article;

import fr.dawan.business.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ArticleService extends GenericService<ArticleDto> {
    Page<ArticleDto> findByTitle(String title, Pageable pageable);
    Page<ArticleDto> findByCategory_NameLike(String name, Pageable pageable);
}
