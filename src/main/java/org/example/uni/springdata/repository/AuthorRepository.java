package org.example.uni.springdata.repository;

import org.example.uni.springdata.entity.AuthorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
    public List<AuthorEntity> findAll();

    public Optional<AuthorEntity> findByName(String name);

    @Query("SELECT A FROM AuthorEntity AS A WHERE LOWER(A.name) LIKE LOWER(concat('%', concat(?1, '%')))")
    public List<AuthorEntity> findByNameContains(String name);

    public List<AuthorEntity> findByBooksTitle(String name);
}
