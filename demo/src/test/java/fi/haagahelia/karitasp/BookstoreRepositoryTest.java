package fi.haagahelia.karitasp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.karitasp.domain.Category;
import fi.haagahelia.karitasp.domain.Colorlist;
import fi.haagahelia.karitasp.domain.colorRepository;
@RunWith(SpringRunner.class)
@DataJpaTest
public class BookstoreRepositoryTest {

	 @Autowired
	    private colorRepository repository;

	    @Test
	    public void findByLastnameShouldReturnStudent() {
	        List<Colorlist> colors = repository.findByName("Ferrari Red");
	        
	        assertThat(colors).hasSize(1);
	        assertThat(colors.get(0).getNr()).isEqualTo(01);
	    }
	    
	    @Test
	    public void createNewStudent() {
	    	Colorlist colors = new Colorlist(01, "Ferrari Red" , 2 , new Category("CG"));
	    
	    	repository.save(colors);
	    	assertThat(colors.getId()).isNotNull();
	    }    

	}
