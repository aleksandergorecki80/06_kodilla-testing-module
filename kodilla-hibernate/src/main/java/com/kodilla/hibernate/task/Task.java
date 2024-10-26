package com.kodilla.hibernate.task;

import com.kodilla.hibernate.tasklist.TaskList;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name="TASKS")
public class Task {
  private int id;
  private String description;
  private Date created;
  private int duration;
  private TaskFinancialDetails taskFinancialDetails;
  private TaskList taskList;

  public Task() {
  }

  public Task(String description, int duration) {
    this.description = description;
    this.created = new Date();
    this.duration = duration;
  }

  @Id
  @NotNull
  @GeneratedValue
  @Column(name="ID", unique=true)
  public int getId() {
    return id;
  }

  @Column(name = "DESCRIPTION")
  public String getDescription() {
    return description;
  }

  @NotNull
  @Column(name = "CREATED")
  public Date getCreated() {
    return created;
  }

  @Column(name = "DURATION")
  public int getDuration() {
    return duration;
  }

  private void setId(final int id) {
    this.id = id;
  }

  private void setDescription(final String description) {
    this.description = description;
  }

  private void setDuration(final int duration) {
    this.duration = duration;
  }

  private void setCreated(final Date created) {
    this.created = created;
  }

  @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
  @JoinColumn(name = "TASKS_FINANCIALS_ID")
  public TaskFinancialDetails getTaskFinancialDetails() {
    return taskFinancialDetails;
  }

  public void setTaskFinancialDetails(TaskFinancialDetails taskFinancialDetails) {
    this.taskFinancialDetails = taskFinancialDetails;
  }

  @ManyToOne
  @JoinColumn(name = "TASKLIST_ID")
  public TaskList getTaskList() {
    return taskList;
  }

  public void setTaskList(TaskList taskList) {
    this.taskList = taskList;
  }
}