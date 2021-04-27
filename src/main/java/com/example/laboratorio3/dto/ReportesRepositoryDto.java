package com.example.laboratorio3.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public interface ReportesRepositoryDto {
    String getFirst_name();
    String getLast_name();
    Date getHire_date();
    Date getEnd_date();
    String getJob_title();

}
