package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import Model.TransitModel;


public interface TransitRepository extends JpaRepository<TransitModel, Long>{

	Iterable <TransitModel> findByCabTypeAndStatus (String cab_type ,String status);
}
