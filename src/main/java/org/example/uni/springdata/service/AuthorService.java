package org.example.uni.springdata.service;

import org.example.uni.springdata.entity.AuthorEntity;

import java.util.List;
import java.util.Optional;

/**
 * Сервис работы с авторами
 */
public interface AuthorService {

    /**
     * Получение автора по идентификатору
     *
     * @param id идентификатор
     * @return найденный автор или null, если автор по такому идентификатору не найден
     */
    AuthorEntity get(long id);

    /**
     * Получение автора по идентификатору
     *
     * @param name имя
     * @return найденный автор или null, если автор по такому идентификатору не найден
     */
    Optional<AuthorEntity> find(String name);

    /**
     * Поиск авторов по строке
     *
     * @param name имя
     * @return список найденных авторов
     */
    List<AuthorEntity> findByName(String name);

    /**
     * Поиск авторов по названию книги
     *
     * @param name название книги
     * @return список найденных авторов
     */
    List<AuthorEntity> findByBookName(String name);

    /**
     * Получает список всех авторов
     *
     * @return список авторов
     */
    List<AuthorEntity> all();

    /**
     * Создаёт нового автора
     *
     * @param name имя автора
     * @param description описание
     * @return созданного автора
     */
    AuthorEntity create(String name, String description);

}
