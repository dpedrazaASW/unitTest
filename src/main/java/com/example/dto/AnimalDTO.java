package com.example.dto;// DTO DATA TRANSFER OBJECT

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Validated
@EqualsAndHashCode
@ToString
public class AnimalDTO {
	
	@NotBlank(message = "El tipo no puede ser vacio")
	@Size(min=2, max=30)
	private String type;

	@NotBlank(message = "El color no puede ser vacio")
	private String color;
	
					//days/Month/year hour:minutes:seconds
	@JsonFormat(pattern="dd/MM/yyyy hh:mm", timezone="America/Bogota")
	private Date birth;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	

}
