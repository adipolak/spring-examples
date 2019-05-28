package org.springframework.samples.petclinic.pet;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.transaction.annotation.Transactional;

/**
 * MyPetRepository
 * 
 * @param <Pet>
 */
public interface MyPetRepository extends Repository<Pet, Integer> {

    /**
     * Retrieve all <code>Pet</code>s from the data store.
     *
     * @return a <code>Collection</code> of <code>Pet</code>s
     */
    @Transactional(readOnly = true)
    Collection<Pet> findAll() throws DataAccessException;
}