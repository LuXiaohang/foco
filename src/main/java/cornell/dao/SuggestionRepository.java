package cornell.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuggestionRepository extends CrudRepository<Suggestion,Long> {
    List<Suggestion> findAll();
}
