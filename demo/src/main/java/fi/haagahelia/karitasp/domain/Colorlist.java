package fi.haagahelia.karitasp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Colorlist {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private int nr;
    private String name;
    private int stock;
   
    
    @ManyToOne
    @JoinColumn(name = "Categoryid")
    private Category category;
    


    public Colorlist() {}

	public Colorlist(int nr, String name , int stock  , Category category) {
		super();
		this.nr = nr;
		this.name = name;
		this.stock = stock;
		this.category = category;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null)
			return "Colorlist [id=" + id + ", Number=" + nr + ", Name=" + name + ", Stock=" + stock  + " category =" + this.getCategory() + "]";
		else
			return "Colorlist [id=" + id + ", Number=" + nr + ", Name=" + name + ", Stock=" + stock + "]";
			
	}

}
