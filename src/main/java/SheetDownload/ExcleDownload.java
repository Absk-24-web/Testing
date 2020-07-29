package SheetDownload;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class ExcleDownload {

    public static void main(String[] args) {
        new ExcleDownload().export();
    }

    public void export() {
        String jdbcURL = "jdbc:mysql://localhost:3306/ludo";
        String username = "root";
        String password = "lipi123";

        String excelFilePath = "C:\\Users\\df-dev16\\Desktop\\Tables.xlsx";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT * FROM winner";

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Today's Table");

            writeHeaderLine(sheet, workbook);

            writeDataLines(result, workbook, sheet);

            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
//            workbook.close();

            statement.close();

        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
//            JOptionPane.showMessageDialog(this, "Please close the previous use file");
            System.out.println("File IO error:");
            e.printStackTrace();
        }
    }

    private void writeHeaderLine(XSSFSheet sheet, XSSFWorkbook workbook) {

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        Font font = workbook.createFont();
        font.setColor(IndexedColors.ROYAL_BLUE.getIndex());
        font.setFontHeightInPoints((short)20);
        font.setBoldweight((short)5);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFont(font);

        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,7));
        titleCell.setCellValue("Winners");
        titleCell.setCellStyle(style);

        Row headerRow = sheet.createRow(1);
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setAlignment(CellStyle.ALIGN_CENTER);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellStyle(headerCellStyle);
        headerCell.setCellValue("Id");

        headerCell = headerRow.createCell(1);
        headerCell.setCellStyle(headerCellStyle);
        headerCell.setCellValue("Date");

        headerCell = headerRow.createCell(2);
        headerCell.setCellStyle(headerCellStyle);
        headerCell.setCellValue("Player-1");

        headerCell = headerRow.createCell(3);
        headerCell.setCellStyle(headerCellStyle);
        headerCell.setCellValue("Player-1 Amount");

        headerCell = headerRow.createCell(4);
        headerCell.setCellStyle(headerCellStyle);
        headerCell.setCellValue("Player-2");

        headerCell = headerRow.createCell(5);
        headerCell.setCellStyle(headerCellStyle);
        headerCell.setCellValue("Player-2 Amount");

        headerCell = headerRow.createCell(6);
        headerCell.setCellStyle(headerCellStyle);
        headerCell.setCellValue("Match Amount");

        headerCell = headerRow.createCell(7);
        headerCell.setCellStyle(headerCellStyle);
        headerCell.setCellValue("Winner");
    }

    private void writeDataLines(ResultSet result, XSSFWorkbook workbook,
                                XSSFSheet sheet) throws SQLException {
        int rowCount = 2;

        while (result.next()) {
            String id = result.getString("id");
            Timestamp date = result.getTimestamp("date");
            String player1 = result.getString("player1");
            String player1Amount = result.getString("player1_amount");
            String player2 = result.getString("player2");
            String player2Amount = result.getString("player2_amount");
            String matchAmount = result.getString("match_amount");
            String winner = result.getString("winner");


            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(id);

            cell = row.createCell(columnCount++);

            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper creationHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dd-MM-yyyy HH:mm:ss"));
            cell.setCellStyle(cellStyle);

            cell.setCellValue(date);

            cell = row.createCell(columnCount++);
            cell.setCellValue(player1);

            cell = row.createCell(columnCount++);
            cell.setCellValue(player1Amount);

            cell = row.createCell(columnCount++);
            cell.setCellValue(player2);

            cell = row.createCell(columnCount++);
            cell.setCellValue(player2Amount);

            cell = row.createCell(columnCount++);
            cell.setCellValue(matchAmount);

            cell = row.createCell(columnCount);
            cell.setCellValue(winner);

        }
    }

}