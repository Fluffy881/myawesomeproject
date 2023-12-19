package fr.dawan.business.generic;

import fr.dawan.business.article.Article;
import fr.dawan.business.article.ArticleRepository;
import fr.dawan.business.category.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@RequiredArgsConstructor
public abstract class GenericServiceImpl<E extends BaseEntity,
        R extends JpaRepository<E,Long>,
        D,
        M extends GenericMapper<E,D>
        > implements GenericService<E> {

    protected final R repository;
    @Override
    public Page<E> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<E> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public E saveOrUpadate(E entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<D> findDtoById(long id) {
        return repository.findById(id).map(mapper::toDto);
    }
}
