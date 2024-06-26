package com.COC_Project.COC_project.coc_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.COC_Project.COC_project.Model.COCDto;

@Repository
public interface COC_Repository extends JpaRepository<COCDto, Integer>{

}
