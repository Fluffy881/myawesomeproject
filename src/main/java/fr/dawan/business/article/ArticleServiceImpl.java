package fr.dawan.business.article;

import fr.dawan.business.generic.GenericServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j // creer directement un logger pour la classe
public class ArticleServiceImpl extends GenericServiceImpl<Article, ArticleRepository,ArticleDto, ArticleMapper> implements ArticleService {


    public ArticleServiceImpl(ArticleRepository repository, ArticleMapper mapper) {
        super(repository, mapper);
        newCodeWithSmell();
    }

    @Override
    public Page<ArticleDto> findByTitle(String title, Pageable pageable) {
        return repository.findByTitleLike("%" + title + "%", pageable).map(mapper::toDto);
    }

    @Override
    public Page<ArticleDto> findByCategory_NameLike(String name, Pageable pageable) {
        return repository.findByCategory_NameLike("%" + name + "%", pageable).map(mapper::toDto);
    }

    private void newCodeWithSmell(){
        log.info("this stinks!");
    }
}
