package in.dhananjaygore.expensetrackerapi.repository;

import org.springframework.stereotype.Repository;
import in.dhananjaygore.expensetrackerapi.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
