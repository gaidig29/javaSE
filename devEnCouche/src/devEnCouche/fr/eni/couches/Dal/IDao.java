package devEnCouche.fr.eni.couches.Dal;

import java.util.List;

public interface IDao <T,U> {
	public T save(T t);
	public List<T> getAll();
	public T findOne(U id);
	public void update (T p);
	public void delete (U id);


}
