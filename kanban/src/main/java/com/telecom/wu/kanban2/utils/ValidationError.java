package com.telecom.wu.kanban2.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ValidationError {
    private String field;
    private String message;
}
