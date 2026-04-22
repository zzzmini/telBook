package view;

import exception.InputValidation;
import exception.MyException;
import service.TelBookService;

import java.util.Scanner;

public class UserView {
    private final Scanner scanner;
    private final TelBookService telBookService; // 서비스 객체를 필드로 추가

    // 생성자에서 Scanner와 Service를 모두 주입받음
    public UserView(Scanner scanner, TelBookService telBookService) {
        this.scanner = scanner;
        this.telBookService = telBookService;
    }

    public void insert() throws MyException {
        InputValidation validation = new InputValidation();

        String name = "";
        int age = 0;
        String phone = "";
        String address = "";

        System.out.println("\n== 전화번호 등록 ==");

        // 1. 이름 입력 및 검증
        boolean nameOk = false;
        do {
            try {
                System.out.print("이름 : ");
                name = scanner.next();
                validation.nameCheck(name);
                nameOk = true;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        } while (!nameOk);

        // 2. 나이 입력 및 검증
        boolean ageOk = false;
        do {
            try {
                System.out.print("나이 : ");
                age = scanner.nextInt();
                validation.ageCheck(age);
                ageOk = true;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        } while (!ageOk);

        // 3. 주소 입력
        System.out.print("주소 : ");
        address = scanner.next();

        // 4. 전화번호 입력 및 검증
        boolean phoneOk = false;
        do {
            try {
                System.out.print("전화번호(010-XXXX-XXXX) : ");
                phone = scanner.next();
                validation.phoneCheck(phone);
                phoneOk = true;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        } while (!phoneOk);

        // 비즈니스 로직(서비스) 호출
        telBookService.insert(name, age, address, phone);
    }
}