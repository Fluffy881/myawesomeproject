package fr.dawan.business.article;

import fr.dawan.business.generic.GenericServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl extends GenericServiceImpl<Article,ArticleRepository, ArticleDto, ArticleMapper> implements ArticleService{
    public ArticleServiceImpl(ArticleRepository repository) {
        super(repository);
    }

    @Override
    public Page<Article> findByTitle(String title, Pageable pageable) {
        return repository.findByTitleLike("%" + title + "%",pageable);
    }

    @Override
    public Page<Article> findByCategory_NameLike(String name, Pageable pageable) {
        return repository.findByCategory_NameLike("%" + name + "%",pageable);
    }


}
