package com.jcb.erp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;

public class AutomatePDFFormFillingUtils {

	public static final String DEST = "E:/Project/TestingDirectory/target/destination/";
	public static final String SRC = "E:/Project/TestingDirectory/target/resources/htmls/index.html";

	public static void main(String[] args) throws IOException {

		createPDFfromHTMLsource(String.valueOf(automatePDFFormFilling(SRC)), DEST, SRC);
	}

	public static String automatePDFFormFilling(String src) throws IOException {

		Document document = Jsoup.parse(new File(src), "UTF-8", "http://example.com/");

		document.select("input[name$=uname]").attr("value", "M E G H N A D     S A H A");
		document.select("input[name$=password]").attr("value", "S A  H  A  1  2  3");

		// System.out.println(document.html());

		return document.html();
	}

	public static void createPDFfromHTMLsource(String htmlSource, String dest, String src) throws IOException {
		// IO
		File pdfDest = new File(DEST + "output.pdf");
		// pdfHTML specific code
		ConverterProperties converterProperties = new ConverterProperties();
		HtmlConverter.convertToPdf(htmlSource, new FileOutputStream(pdfDest), converterProperties);

		System.out.println("File has been created in the following directory : \n " + DEST + "output.pdf");
	}

}