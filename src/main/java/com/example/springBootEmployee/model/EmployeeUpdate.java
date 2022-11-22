package com.example.springBootEmployee.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeUpdate {
    private Long employpeeId;
    private String firstName;
    private String lastName;

}
