package com.COC_Project.COC_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;


public class Test {
	public static void main(String[] args) {
		formGenerate();
	}
	
	public static void formGenerate() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:/Users/Public/Documents/coc_template/Test.docx");
			XWPFDocument document = new XWPFDocument(fis);
			
			PdfOptions options = PdfOptions.create();
			OutputStream outputStream = new FileOutputStream(new File("C:/Users/Public/Documents/coc_template/Test.pdf"));
			PdfConverter.getInstance().convert(document, outputStream, options);
	        document.close(); 
	        
	     
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        
		
		
	}
	
}
