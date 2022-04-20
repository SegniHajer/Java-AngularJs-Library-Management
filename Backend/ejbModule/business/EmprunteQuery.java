package business;

import java.util.List;

import metier.entities.EmprunteLink;

public interface EmprunteQuery {
	/**
	 * 
	 * @param emprunte
	 * @return
	 */
	public EmprunteLink addEmprunte(EmprunteLink emprunte);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public EmprunteLink getEmprunte(Long id);
	/**
	 * 
	 * @return
	 */

	public List<EmprunteLink> getAllEmpruntes();
}
