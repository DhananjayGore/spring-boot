package in.dhananjaygore.expensetrackerapi.repository;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.dhananjaygore.expensetrackerapi.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	//Select * from tbl_expenses where category=?
	Page<Expense> findByCategory(String category, Pageable page);
	
	
	//Select * from tbl_expense Where name like '%keyword%'
	Page<Expense> findByNameContaining(String keyword, Pageable page);
	
	//Select * from tbl_expense where date between 'startDate' AND 'endDate'
	Page<Expense> findByDateBetween(Date startDate, Date endDate, Pageable page);
}
