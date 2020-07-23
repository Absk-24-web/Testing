package SheetDownload;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
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

            writeHeaderLine(sheet);

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

    private void writeHeaderLine(XSSFSheet sheet) {

        Row headerRow = sheet.createRow(0);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Id");

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Date");

        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Player-1");

        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Player-1 Amount");

        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("Player-2");

        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("Player-2 Amount");

        headerCell = headerRow.createCell(6);
        headerCell.setCellValue("Match Amount");

        headerCell = headerRow.createCell(7);
        headerCell.setCellValue("Winner");
    }

    private void writeDataLines(ResultSet result, XSSFWorkbook workbook,
                                XSSFSheet sheet) throws SQLException {
        int rowCount = 1;

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