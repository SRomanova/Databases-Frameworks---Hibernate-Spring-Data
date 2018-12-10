package org.softuni.ruk.domain.entity;

import org.softuni.ruk.domain.entity.base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "employees")
public class Employee extends BaseEntity {
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private LocalDate startedOn;
    private Branch branch;
    private List<Client> clients;

    public Employee() {
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "salary")
    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Column(name = "started_on")
    public LocalDate getStartedOn() {
        return this.startedOn;
    }

    public void setStartedOn(LocalDate startedOn) {
        this.startedOn = startedOn;
    }

    @ManyToOne(targetEntity = Branch.class)
    @JoinColumn(name = "branch_id", referencedColumnName = "id", nullable = false)
    public Branch getBranch() {
        return this.branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @OneToMany(targetEntity = Client.class)
    @JoinTable(
            name = "employees_clients",
            joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id")
    )
    public List<Client> getClients() {
        return this.clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}