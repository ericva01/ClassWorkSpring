package org.example.classwork.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Students {
    private Integer id;
    private String fullName;
    private Double score;
    private String gender;
}
