package excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Array;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

import common.Score;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;


public class ExcelPrinter {

	private XSSFWorkbook workbook;
	private String fileName;
	private Scanner sc;

	
	public void setFileName(String _fileName) {
		fileName = _fileName;
	}

	public ExcelPrinter(Scanner _sc) throws IOException {
		workbook = new XSSFWorkbook();
		sc = _sc;
	}

	public XSSFWorkbook getWorkbook() {
		return workbook;
	}

	public String getFileName() {
		String _fileName = null;

		while(_fileName == null) {
			//prompt for filename
			System.out.println("Enter filename or 'q' to quit: ");
			_fileName = sc.nextLine();
			//check if user wants to quit
			if (_fileName.equals("q")) {
				return null;
			}
			//add .xlsx if not there
			if (!_fileName.endsWith(".xlsx")) {
				_fileName += ".xlsx";
			}
			//check if file exists and prompt for overwrite
			File file = new File(_fileName);
			if (file.exists()) {
				System.out.println("File exists, overwrite? (y/n)");
				String answer = sc.nextLine();
				if (answer.equals("n")) {
					_fileName = null;
				}else{
					//delete file
					file.delete();

					try {
						file.createNewFile();
					} catch (IOException e) {
						_fileName = null;
					}


				}
			}
			//create file if it doesn't exist
			if (!file.exists()) {
				try{
					file.createNewFile();
				}catch(IOException e){
					System.out.println("Cannot create file "+_fileName+", enter new filename: ");
					_fileName = null;
				}
			}
			file.setWritable(true);
		}
		//scanner.close();

		fileName = _fileName;
		return _fileName;
	}

	public void writeResults(List<Score> results) {
		//get filename
		String fileName = getFileName();
		if (fileName == null) {
			return;
		}
		//create workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		//define data as an array of objects
		HashMap<String, Score[]> data = new HashMap<String, Score[]>();
		//add header row

		//System.out.println("Competitor\tDiscipline\tResult");
		for (Score score : results) {
			//System.out.println(score.getCompetitorName() + "\t" + score.getDiscipline() + "\t" + score.getResult());
			//handle multiple results for same competitor
			if (data.containsKey(score.getCompetitorName())) {
				//get existing data
				Score[] existingData = data.get(score.getCompetitorName());
				//create new array with length + 1
				Score[] newData = new Score[existingData.length + 1];
				//copy existing data to new array
				for (int i = 0; i < existingData.length; i++) {
					newData[i] = existingData[i];
				}
				//add new data to new array
				newData[existingData.length] = score;
				//add new array to hashmap
				data.put(score.getCompetitorName(), newData);
			} else {
				//add data to hasmap
				data.put(score.getCompetitorName(), new Score[]{score});
			}
		
		}
		HashMap<String, Double> totals = new HashMap<String, Double>();
		//add data to workbook
		for(String competitorName : data.keySet()) {
			addCompetitor(competitorName, data.get(competitorName));
		}

		//write a totals sheet, put it first
		XSSFSheet sheet = workbook.createSheet("Totals");
		int rowCount = 0;
		//create header row from results keys
		Row row = sheet.createRow(rowCount);
		rowCount++;
		int columnCount = 0;
		for (Object field : new String[]{"Competitor", "Total score"}) {
			Cell cell = row.createCell(columnCount);
			columnCount++;
			cell.setCellValue((String) field);
		}
		//add totals
		for(String competitorName : data.keySet()) {
			double totalScore = 0;
			for (Score score : data.get(competitorName)) {
				totalScore += score.getResult();
			}
			totals.put(competitorName, totalScore);
		}




		//write workbook to file
		try {
			write();
		} catch (IOException e) {
			System.out.println("Error writing to file");
			//prompt for a new filename
			writeResults(results);
		}
	}

	private Cell _setCellValue(Cell cell, Object value) {
		if (value instanceof String) {
			cell.setCellValue((String) value);
			
		} else if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
			
		} else if (value instanceof Double) {
			cell.setCellValue((Double) value);
			
		}
		return cell;
	}


	public double addCompetitor(String name, Score[] results) {

		//check if sheet exists, if so delete it
		if (workbook.getSheet(name) != null) {
			workbook.removeSheetAt(workbook.getSheetIndex(name));
		}
	
		//new sheet for each competitor
		XSSFSheet sheet = workbook.createSheet(name);

		int rowCount = 0;
		//create header row from results keys
		Row row = sheet.createRow(rowCount);
		rowCount++;
		int columnCount = 0;
		for (Object field : new String[]{"Discipline", "Result"}) {
			Cell cell = row.createCell(columnCount);
			columnCount++;
			cell.setCellValue((String) field);
		}

		//add results
		double totalScore = 0;
		for (Score score : results) {
			String discipline = score.getDiscipline();
			double result = score.getResult();

			row = sheet.createRow(rowCount);
			rowCount++;
			Cell cell = row.createCell(0);
			cell.setCellValue(discipline);
			cell = row.createCell(1);
			cell.setCellValue(result);
			totalScore += result;
		}

		//TODO: add total score
		row = sheet.createRow(rowCount);
		rowCount++;
		Cell cell = row.createCell(0);
		cell.setCellValue("Total score");
		cell = row.createCell(1);
		cell.setCellValue(totalScore);

		return totalScore;
	}


	public void add(Object[][] data, String sheetName) {

		XSSFSheet sheet = workbook.createSheet(sheetName);

		int rowCount = 0;

		for (Object[] aBook : data) {
			Row row = sheet.createRow(rowCount);
			rowCount++;
			int columnCount = 0;

			for (Object field : aBook) {
				Cell cell = row.createCell(columnCount);
				columnCount++;
				
				if (field instanceof String) {
					cell.setCellValue((String) field);
					
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
					
				} else if (field instanceof Double) {
					cell.setCellValue((Double) field);
					
				}
			}
		}
	}

	public void write() throws IOException {
		FileOutputStream out = new FileOutputStream(fileName);
		workbook.write(out);
		//workbook.close();
		System.out.println("File saved to "+fileName);
	}

}