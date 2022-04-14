package com.pris.cinema.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotBlank(message = "Please enter role")
    protected String role;

    @JsonManagedReference
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
    protected List<User> users = new LinkedList<>();
}
