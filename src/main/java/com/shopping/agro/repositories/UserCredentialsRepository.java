package com.shopping.agro.repositories;

import com.shopping.agro.entities.UserCredentials;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepository extends CrudRepository<UserCredentials, Long> {
}
