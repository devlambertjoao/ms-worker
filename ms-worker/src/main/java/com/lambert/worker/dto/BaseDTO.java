package com.lambert.worker.dto;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public abstract class BaseDTO {
	Long id;
	Date createdAt;
	Date updatedAt;
}
