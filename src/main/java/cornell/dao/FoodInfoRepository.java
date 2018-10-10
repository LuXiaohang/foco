package cornell.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface FoodInfoRepository extends CrudRepository<FoodInfo,Long> {
    List<FoodInfo> findAllByTimeBetweenOrderByTimeDesc(Timestamp start,Timestamp end);
    List<FoodInfo> findAllById(Long id);
}
