package com.example.demo.models;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Datasource {
	@Id
	private String name;
	@URL
	@NotBlank(message = "Datasource URL cannot be blank.")
	private String url;
}
