package fr.dawan.business.category;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)// permet l utilisation de mock
class CategoryServiceImplTest {
    private CategoryServiceImpl service;
    @Mock // creeer une simulation de l objet a utiliser
    private CategoryMapper mapper;
    @Mock
    private CategoryRepository repository;

    @BeforeEach // s execute avant chaque test
    void setup(){
        service = new CategoryServiceImpl(repository,mapper);
    }

    @Test
    void findAllTest(){
        //arrange
        Pageable pageable = Pageable.unpaged();

        Category category1 = new Category("Actus", null);
        Category category2 = new Category("Divertissement", null);
        Page<Category> entities = new PageImpl<>(List.of(category1,category2)) ;

        CategoryDto categoryDto1 = new CategoryDto(01,0,category1.getName(),new ArrayList<>(),0);
        CategoryDto categoryDto2 = new CategoryDto(01,0,category2.getName(),new ArrayList<>(),0);
        List<CategoryDto> expected = List.of(categoryDto1,categoryDto2);

        Mockito.when(repository.findAll(pageable)).thenReturn(entities);
        Mockito.when(mapper.toDto(category1)).thenReturn(categoryDto1);
        Mockito.when(mapper.toDto(category2)).thenReturn(categoryDto2);
        // act

        Page<CategoryDto> result = service.findAll(pageable);
        //assert

        // verifie que les resultat dans la page content sont bien ceux attendus
        assertTrue(result.getContent().containsAll(expected));

    }

    @Test
    void passingTest() {assertTrue(true);
    }

}