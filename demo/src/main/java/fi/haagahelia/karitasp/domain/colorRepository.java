package fi.haagahelia.karitasp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface colorRepository extends CrudRepository<Colorlist, Long> {
	
	List<Colorlist> findByName(String name);


}
