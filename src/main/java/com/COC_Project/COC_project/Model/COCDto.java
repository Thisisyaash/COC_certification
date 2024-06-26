package com.COC_Project.COC_project.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "coc_table")
public class COCDto {
	
	@Id
	@SequenceGenerator(allocationSize = 1,name = "COC_Sequence",sequenceName = "COC_Sequence")
	@GeneratedValue(generator = "COC_Sequence",strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String description;
	private long partNo;
	private long poNo;
	private Date poDate;
	private long invoiceNo;
	private Date invoiceDate;
	private long quantity;
	private String materialKind;
	private String finish;
	private String docType;

}
