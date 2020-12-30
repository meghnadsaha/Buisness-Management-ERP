package com.jcb.erp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;

public class PDFfromHTMLsource {

	public static final String SRC = "E:\\Project\\TestingDirectory\\target\\resources\\htmls\\";
	public static final String DEST = "E:\\Project\\TestingDirectory\\target\\destination\\";

	public static void createPDFfromHTMLsource(String dest, String src) throws IOException {
		
	}

	public static void main(String args[]) throws IOException {
		// IO
		File htmlSource = new File(SRC + "index.html");
		File pdfDest = new File(DEST + "output.pdf");
		// pdfHTML specific code
		ConverterProperties converterProperties = new ConverterProperties();
		HtmlConverter.convertToPdf(new FileInputStream(htmlSource), new FileOutputStream(pdfDest), converterProperties);

		System.out.println("File has been created in the following directory : \n " + DEST + "output.pdf");
	}
}
