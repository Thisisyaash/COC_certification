package com.COC_Project.COC_project.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
//import org.docx4j.Docx4J;
//import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.COC_Project.COC_project.Model.COCDto;
import com.COC_Project.COC_project.coc_repository.COC_Repository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CocServiceImpl implements COC_Service {
	
	
	@Autowired
	private COC_Repository coc_repository;

	@Value("${coc.template.path}")
	private String templatePath;
	
	@Value("${coc.template.path.dest}")
	private String destinationPath;

	@Value("${template.placeholder.keys}")
	private List<String> placeholder;

	@Override
	public boolean coc_generation(COCDto model) {
		FileInputStream fis;
		FileOutputStream fos;
		boolean result = false;
		try {
			
			model = saveFormData(model);
			
			log.info("templatePath : {}", templatePath);
			model.setDocType(".docx");
			fis = new FileInputStream(templatePath + "coc_template.docx");
			XWPFDocument document = new XWPFDocument(fis);
			fis.close();

			editingTemplate(document, model);
			String filename = destinationPath + "/" + model.getDescription()+"("+model.getId()+")" + model.getDocType();
			fos = new FileOutputStream(filename.replaceAll(" ", ""));
			document.write(fos);
			fos.close();
			//PdfOptions options = PdfOptions.create();
			//OutputStream outputStream = new FileOutputStream(new File(filename.replace(".docx", ".pdf")));
			//PdfConverter.getInstance().convert(document, outputStream, options);
			//document.close();
			//outputStream.close();
			
			/*boolean docToPdfConverter = docToPdfConverter(filename);
			
			if(docToPdfConverter) {
				if(new File(filename).delete()) {
					log.info("Doc file deleted successfully");
				}
			}*/
			
			

			result = true;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return result;
	}

	private void editingTemplate(XWPFDocument document, COCDto model) {
        // Format the current date as a string
        LocalDate currentDate = LocalDate.now();
        
		log.info("model : ,{}",model);
		for (XWPFParagraph paragraph : document.getParagraphs()) {
			for (XWPFRun run : paragraph.getRuns()) {
				String text = run.getText(0);
				log.info("key :{}",text);
				if (text != null && placeholder.contains(text)) {
					switch (text) {
					// $date_now$,$description$,,,,,,,,$finish$
					case "$local_date$":
						text = text.replace("$local_date$", currentDate.toString());
						run.setText(text, 0);
						log.info("date now: {}",text);
						break;
					case "$description$":
						text = text.replace("$description$", model.getDescription());
						run.setText(text, 0);
						log.info("description: {}",text);
						break;
					case "$part_no$":
						text = text.replace("$part_no$", Long.toString(model.getPartNo()));
						run.setText(text, 0);
						log.info("part no: {}",text);
						break;
					case "$po_no$":
						text = text.replace("$po_no$", Long.toString(model.getPoNo()));
						run.setText(text, 0);
						log.info("po_no: {}",text);
						break;

					case "$po_date$":
						text = text.replace("$po_date$", "" + model.getPoDate());
						run.setText(text, 0);
						log.info("po_date: {}",text);
						break;

					case "$invoice_no$":
						text = text.replace("$invoice_no$", Long.toString(model.getInvoiceNo()));
						run.setText(text, 0);
						log.info("invoice_no: {}",text);
						break;

					case "$invoice_date$":
						text = text.replace("$invoice_date$", "" + model.getInvoiceDate());
						run.setText(text, 0);
						log.info("invoice date: {}",text);
						break;

					case "$quantity$":
						text = text.replace("$quantity$", Long.toString(model.getQuantity()));
						run.setText(text, 0);
						log.info("quantity: {}",text);
						break;

					case "$material_kind$":
						text = text.replace("$material_kind$", model.getMaterialKind());
						run.setText(text, 0);
						log.info("material: {}",text);
						break;

					case "$finish$":
						text = text.replace("$finish$", model.getFinish());
						run.setText(text, 0);
						log.info("finsih: {}",text);
						break;

					}

				}

			}

		}
	}
	
	/*private boolean docToPdfConverter(String input) {
		boolean result = false;
		try {
            // Load DOCX file
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new File(input));

            // Convert DOCX to PDF
            Docx4J.toPDF(wordMLPackage, new FileOutputStream(input.replace(".docx", ".pdf")));

            System.out.println("PDF created successfully.");
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return result;
	}*/
	
	private COCDto saveFormData(COCDto model) {
		COCDto save = null;
		if (model!=null) {
			save = coc_repository.save(model);
		}
		return save;
	}

	@Override
	public void coc_bulk() {
		List<COCDto> all = coc_repository.findAll();
		for(COCDto model:all) {
			this.coc_generation(model);
		}
	}

	}
