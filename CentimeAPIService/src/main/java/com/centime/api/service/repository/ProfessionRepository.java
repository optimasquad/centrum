
package com.centime.api.service.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.centime.api.service.entity.Profession;

/**
 * @author jmahajan
 *
 */

@Repository
public interface ProfessionRepository extends CrudRepository<Profession, Long> {

	Optional<Profession> findById(final Long id);

	Set<Profession> findByParentid(final Long parentId);

}
