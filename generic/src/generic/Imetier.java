package generic;

import java.util.List;

public interface Imetier <T,U>{
	public T save(Produit p);
	public List<T> getAll();
	public T findOne(U id);
	public void update (T p);
	public void delete (U id);
}
