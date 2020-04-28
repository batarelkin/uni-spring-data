package org.example.uni.springdata.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.uni.springdata.entity.AuthorEntity;
import org.example.uni.springdata.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authors;

    @Override
    public AuthorEntity get(long id) {
        return this.authors.findById(1L).orElse(null);
    }

    @Override
    public Optional<AuthorEntity> find(String name) {
        return this.authors.findByName(name);
    }

    @Override
    public List<AuthorEntity> findByName(String name) {
        return this.authors.findByNameContains(name);
    }

    @Override
    public List<AuthorEntity> findByBookName(String name) {
        return this.authors.findByBooksTitle(name);
    }

    @Override
    public List<AuthorEntity> all() {
        return authors.findAll();
    }

    @Override
    public AuthorEntity create(String name, String description) {
        AuthorEntity author = new AuthorEntity();
        author.setName(name);
        author.setDescription(description);
        return this.authors.save(author);
    }

}
