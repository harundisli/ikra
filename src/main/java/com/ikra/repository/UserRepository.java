package com.ikra.repository;

import com.ikra.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;


@RestResource(exported=false)
public interface UserRepository  extends PagingAndSortingRepository<User, Long> {
    User findByName(String userName);
    User findByEmail(String email);
}
