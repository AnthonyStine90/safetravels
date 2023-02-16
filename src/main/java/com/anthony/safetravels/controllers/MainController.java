package com.anthony.safetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anthony.safetravels.models.Expense;
import com.anthony.safetravels.services.ExpenseService;

@Controller
public class MainController {

  @Autowired
  ExpenseService expenseService;

  // loads index page
  @RequestMapping("/")
  public String index() {
    return "index.jsp";
  }

  // loades expenses page with expense list and create form
  @RequestMapping("/expenses")
  public String showExpenses(@ModelAttribute("expense") Expense expense, Model model) {

    List<Expense> expenses = expenseService.allExpenses();
    model.addAttribute("expenses", expenses);

    return "expenses.jsp";
  }

  // ***** create new expense *****
  @PostMapping("/newexpense")
  public String newExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
    if (result.hasErrors()) {
      return "expenses.jsp";
    } else {
      expenseService.createExpense(expense);

    }

    return "redirect:/expenses";
  }

  // ***** render one expense by id ******
  @RequestMapping("/expenses/{id}")
  public String getOneExpense(@PathVariable("id") Long id, Model model) {
    Expense expense = expenseService.getOneExpense(id);
    model.addAttribute("expense", expense);
    return "showone.jsp";
  }

  // ***** edit route render and edit method *****

  @GetMapping("/expenses/edit/{id}")
  public String edit(@PathVariable("id") Long id, Model model) {
    Expense expense = expenseService.getOneExpense(id);
    model.addAttribute("expense", expense);
    return "edit.jsp";
  }

  @PutMapping("/update/{id}")
  public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
    if(result.hasErrors()){
      return "edit.jsp";
    } else {

      expenseService.updateExpense(expense);
      return "redirect:/expenses";
    }
  }

  // ***** delete expense ******
  @DeleteMapping("/delete/{id}")
  public String deleteExpense(@PathVariable("id") Long id) {
    Expense expense = expenseService.getOneExpense(id);
    expenseService.deleteExpense(expense);
    return "redirect:/expenses";
  }
}
