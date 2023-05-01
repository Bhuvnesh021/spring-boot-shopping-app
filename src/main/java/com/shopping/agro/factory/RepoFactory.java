package com.shopping.agro.factory;

import com.shopping.agro.entities.User;
import com.shopping.agro.exceptions.UnknownRepositoryException;
import com.shopping.agro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class RepoFactory {
    private static RepoFactory repoFactory = new RepoFactory();
    private RepoFactory(){

    }

    public static RepoFactory getInstance() {
        return repoFactory;
    }
    @Autowired
    private UserRepository userRepository;
    public CrudRepository<?, Long> getRepository(Object type) throws UnknownRepositoryException {
        if(type instanceof User){
            return userRepository;
        }
        throw new UnknownRepositoryException("Invalid repository type found");
    }
}
