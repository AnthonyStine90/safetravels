package com.anthony.safetravels.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "expenses")
public class Expense {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(min = 1, message = "must have a name")
  private String name;

  @NotNull
  @Size(min = 1, message = "must have a vendor name")
  private String vendor;

  @NotNull
  @Min(value = 1, message = "must have a value")
  private Integer amount;

  @NotNull
  @Size(min = 1, message = "must have a description")
  private String description;

  public Expense() {
  }

  public Expense(Long id, String name, String vendor, int amount, String description) {
    this.id = id;
    this.name = name;
    this.vendor = vendor;
    this.amount = amount;
    this.description = description;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getVendor() {
    return this.vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  public Integer getAmount() {
    return this.amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
