package ChangeJdbcToHibernate.MODEL.repository;

import ChangeJdbcToHibernate.MODEL.entity.Outcomes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutcomesRepository extends JpaRepository<Outcomes, Long> {
}
