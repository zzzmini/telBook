import db.DBConn;
import exception.MyException;
import service.TelBookRepository;
import service.TelBookService;
import view.UserView;

import java.util.Scanner;

public class TelBookMain {
    public static void main(String[] args) {
        // 1. 의존성 객체 생성 및 연결
        TelBookRepository repository = new TelBookRepository();
        // Repository를 Service에 주입
        TelBookService telBookService = new TelBookService(repository);

        Scanner sc = new Scanner(System.in);
        // Service를 UserView에 주입
        UserView userView = new UserView(sc, telBookService);

        boolean isRunning = true;

        System.out.println("======= 전화번호부 관리 프로그램 =======");

        while (isRunning) {
            int input = 0;
            try {
                do {
                    System.out.println("\n1.입력 2.수정 3.삭제 4.전체출력 5.ID검색 6.종료");
                    System.out.print("▶ 메뉴 선택 : ");
                    input = sc.nextInt();
                } while (input < 1 || input > 6);

                switch (input) {
                    case 1:
                        userView.insert();
                        break;
                    case 2:
                        userView.update();
                        break;
                    case 3:
                        userView.delete();
                        break;
                    case 4:
                        userView.searchAll();
                        break;
                    case 5:
                        userView.searchOne();
                        break;
                    case 6:
                        System.out.println("프로그램을 종료합니다.");
                        isRunning = false;
                        break;
                }
            } catch (MyException e) {
                System.out.println("에러 발생: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("알 수 없는 오류가 발생했습니다. 다시 시도해주세요.");
                sc.nextLine(); // 잘못된 입력 버퍼 비우기
            }
        }

        // 프로그램 종료 시 자원 해제
        sc.close();
        DBConn.close();
    }
}