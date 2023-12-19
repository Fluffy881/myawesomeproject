package fr.dawan.business.generic;

import fr.dawan.business.article.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GenericService<E extends BaseEntity,D> {
    Page<E> findAll(Pageable pageable);// tous les enregistrement avec pagination
    Optional<E> findById(long id);
    Optional<D> findById(long id);
    E saveOrUpadate(E entity);
    void deleteById(long id);

}
