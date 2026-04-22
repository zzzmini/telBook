package service;

import db.DBConn;
import dto.TelDto;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TelBookRepository {
    public int insertData(TelDto dto) { // void -> int로 변경
        Connection conn = DBConn.getConnection();
        PreparedStatement psmt = null;
        int result = 0;
        try {
            String sql = "INSERT INTO telbook (name, age, address, phone) VALUES(?,?,?,?)";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, dto.getName());
            psmt.setInt(2, dto.getAge());
            psmt.setString(3, dto.getAddress());
            psmt.setString(4, dto.getTelNumber());
            result = psmt.executeUpdate(); // 실행 결과(영향받은 행의 수) 저장
        } catch (Exception e) {
            System.out.println("INSERT 오류 : " + e.getMessage());
        } finally {
            // DB 자원 반납 로직 추가 권장 (psmt.close() 등)
        }
        return result; // 결과 반환
    }
    // 기존의 public int insertData() { return 0; } 은 삭제하세요.
}
