package in.dhananjaygore.expensetrackerapi.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import in.dhananjaygore.expensetrackerapi.entity.Expense;

public interface ExpenseService {

	Page<Expense> getAllExpense(Pageable page);
	
	Expense getExpenseByID(Long id);
	
	void deleteExpenseById(Long id);

	Expense saveExpenseDetails(Expense expense);
	
	Expense updateExpenseDetails(Long id, Expense expense);
	
	List<Expense> readByCategory(String category, Pageable page);
	
	List<Expense> readByName(String name, Pageable page);
	
	List<Expense> readByDate(Date startDate, Date endDate, Pageable page);
}
