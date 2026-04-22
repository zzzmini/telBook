package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

<<<<<<< HEAD
//  프로젝트 시작할 때  DB연결을 구성
//  딱, 1번만 연결을 함
//  종료 시 연결해제
//  연결을 static으로 생성 : Singleton 패턴이라 한다.
public class DBConn {
    private static Connection dbConn;
    public static Connection getConnection(){
        if(dbConn == null){
            try{
=======
// 프로젝트 시작할 때 DB연결을 구성
// 딱, 1번만 연결을 함
// 종료 시 연결해제
// 연결을 static으로 생성 : Singleton 패턴이라 한다.
public class DBConn {
    // DB 연결정보
    private static Connection dbConn;

    public static Connection getConnection() {
        if (dbConn == null) {
            try {
>>>>>>> ebe58eed74b1936a1d0609f882f294e7674558c1
                String dbDriver = "com.mysql.cj.jdbc.Driver";
                String dbUrl = "jdbc:mysql://localhost:3306/teldb";
                String dbUser = "root";
                String dbPassword = "1111";
<<<<<<< HEAD
                //  드라이버 클래스를 메모리를 가져온다.
                Class.forName(dbDriver);
                //  연결을 생성
                dbConn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                //  연결 성공
                System.out.println("DB 연결 성공!!!");
            }catch (ClassNotFoundException e){
                System.out.println("드라이버가 없어요.. 실패");
                e.printStackTrace();
            }catch (SQLException e) {
=======
                // 드라이버 클래스를 메모리로 가져온다.
                Class.forName(dbDriver);
                // 연결을 생성
                dbConn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                // 연결 성공
                System.out.println("DB 연결 성공~~~");
            } catch (ClassNotFoundException e) {
                System.out.println("드라이버가 없어요.. 실패");
                e.printStackTrace();
            } catch (SQLException e) {
>>>>>>> ebe58eed74b1936a1d0609f882f294e7674558c1
                System.out.println("DB 연결 실패");
                e.printStackTrace();
            }
        }
        return dbConn;
    }
<<<<<<< HEAD
    //  DB 종료 시 처리
    public static void close(){
        if(dbConn != null){
            try{
                if(!dbConn.isClosed()) {
                    dbConn.close();
                }
            }catch (Exception e){
=======

    // DB 종료 시 처리
    public static void close() {
        if (dbConn != null) {
            try {
                if (!dbConn.isClosed()) {
                    dbConn.close();
                }
            } catch (Exception e) {
>>>>>>> ebe58eed74b1936a1d0609f882f294e7674558c1
                System.out.println(e.getMessage());
            }
            dbConn = null;
        }
    }
}
