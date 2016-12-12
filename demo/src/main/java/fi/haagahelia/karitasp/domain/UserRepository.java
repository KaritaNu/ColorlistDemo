package fi.haagahelia.karitasp.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<user, Long>{
	user findByUsername(String username);

}
