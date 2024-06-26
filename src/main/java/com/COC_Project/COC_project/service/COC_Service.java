package com.COC_Project.COC_project.service;

import com.COC_Project.COC_project.Model.COCDto;

public interface COC_Service {
	
	public boolean coc_generation(COCDto model);
	public void coc_bulk();

}
