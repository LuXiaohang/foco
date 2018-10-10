package cornell.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface FoodCommentRepository extends CrudRepository<FoodComment,Long> {
    List<FoodComment> findAllByFoodIdOrderByTimeDesc(Long id);
}
