
package com.centime.api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.centime.api.entity.Profession;

/**
 * @author jmahajan
 *
 */

@Repository
public interface ProfessionRepository extends CrudRepository<Profession, Long> {

	Optional<Profession> findById(final Long id);

}
