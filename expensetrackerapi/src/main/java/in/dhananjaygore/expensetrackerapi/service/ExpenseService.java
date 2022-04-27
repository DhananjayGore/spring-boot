package in.dhananjaygore.expensetrackerapi.service;

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
}
