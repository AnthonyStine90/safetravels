package com.anthony.safetravels.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anthony.safetravels.models.Expense;
import com.anthony.safetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
  
  @Autowired ExpenseRepository expenseRepository;

  public List<Expense> allExpenses() {
    return expenseRepository.findAll();
  }

  public void createExpense(Expense expense) {
    expenseRepository.save(expense);
  }

  public Expense getOneExpense(Long id) {
    Optional<Expense> optionalExpense = expenseRepository.findById(id);
    return optionalExpense.orElse(null);
  }

  public void updateExpense(Expense expense) {
    expenseRepository.save(expense);
  }

  public void deleteExpense(Expense expense) {
    expenseRepository.delete(expense);
  }
}
