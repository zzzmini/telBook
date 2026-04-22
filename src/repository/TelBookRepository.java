package repository;

import db.DBConn;
import dto.TelDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class TelBookRepository {
    public TelBookRepository(Connection connection) {
    }

    public int insertData(TelDto dto) {
        // 1. DB 연결
        Connection conn = DBConn.getConnection();
        PreparedStatement psmt = null;

        // 2. 쿼리 생성
        // 실행 결과를 담을 변수
        int result = 0;
        try {
            String sql = "INSERT INTO telbook (name, age, address, phone) VALUES (?,?,?,?)";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, dto.getName());
            psmt.setInt(2, dto.getAge());
            psmt.setString(3, dto.getAddress());
            psmt.setString(4, dto.getTelNumber());
            result = psmt.executeUpdate();
            psmt.close();
        } catch (Exception e) {
            System.out.println("INSERT 오류 : " + e.getMessage());
        }
        return result;
    }

    public List<TelDto> findAll() {
        List<TelDto> dtoList = new ArrayList<>();
        Connection conn = DBConn.getConnection();
        // 쿼리를 실행할 도구
        PreparedStatement psmt = null;
        // 검색 결과 레코드 셋을 담을 통
        ResultSet rs = null;
        try {
            // 쿼리 작성
            String sql = "SELECT * FROM telbook ORDER BY name";
            psmt = conn.prepareStatement(sql);
            // 실행 -> 결과는 rs 이 받는다.
            rs = psmt.executeQuery();
            // 받은 결과를 DTO List에 차곡차곡 담는다.
            //rs.next() : 다음 레코드가 있는가?
            while (rs.next()) {
                // 읽어온 레코드를 담을 빈 DTO를 생성한다.
                TelDto dto = new TelDto();
                dto.SetId(rs.getLong("id"));
                dto.setName(rs.getString("name"));
                dto.setAge(rs.getInt("age"));
                dto.setAddress(rs.getString("address"));
                dto.setTelNumber(rs.getString("phone"));
//                System.out.println(dto);
                dtoList.add(dto);
            }
            // psmt 닫아주는 작업
            psmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Find All Error : " + e.getMessage());
        }
        return dtoList;
    }

    public List<TelDto> findById(Long id) {
        List<TelDto> dtoList = new ArrayList<>();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Connection conn = DBConn.getConnection();
        String sql = "SELECT * FROM telbook WHERE id = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setLong(1, id);
            rs = psmt.executeQuery();
            // 리스트에 추가
            while (rs.next()) {
                TelDto dto = new TelDto();
                dto.SetId(rs.getLong("id"));
                dto.setName(rs.getString("name"));
                dto.setAge(rs.getInt("age"));
                dto.setAddress(rs.getString("address"));
                dto.setTelNumber(rs.getString("phone"));
                dtoList.add(dto);
            }
            // psmt 닫아주는 작업
            psmt.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("FindById Error : " + e.getMessage());
        }
        return dtoList;
    }

    public int deleteByID(int id) {
        // 1. DB 연결
        Connection conn = DBConn.getConnection();
        PreparedStatement psmt = null;

        // 2. 쿼리 생성
        // 실행 결과를 담을 변수
        int result = 0;
        try {
            String sql = "DELETE FROM telbook WHERE id = ?";
            psmt = conn.prepareStatement(sql);
            psmt.setLong(1, id);
            psmt.executeUpdate();
            psmt.close();
            result = 1;
        } catch (Exception e) {
            System.out.println("DELETE 오류 : " + e.getMessage());
        }
        return result;
    }

    public void update(TelDto updateData) {
        // 1. DB 연결
        Connection conn = DBConn.getConnection();
        PreparedStatement psmt = null;

        // 2. 쿼리 생성
        // 실행 결과를 담을 변수
        int result = 0;
        try {
            String sql = "UPDATE telbook ";
            sql = sql + " SET name = ?, " ;
            sql = sql + " age = ?, " ;
            sql = sql + " address = ?, " ;
            sql = sql + " phone = ? " ;
            sql = sql + " WHERE id = ? ";

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, updateData.getName());
            psmt.setInt(2, updateData.getAge());
            psmt.setString(3, updateData.getAddress());
            psmt.setString(4, updateData.getTelNumber());
            psmt.setLong(5, updateData.getId());
            psmt.executeUpdate();
            psmt.close();
        } catch (Exception e) {
            System.out.println("UPDATE 오류 : " + e.getMessage());
        }
    }
}

