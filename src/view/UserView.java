package view;

import exception.InputValidation;
import exception.MyException;
<<<<<<< HEAD
import service.TelBookService;
=======
>>>>>>> ebe58eed74b1936a1d0609f882f294e7674558c1

import java.util.Scanner;

public class UserView {
    private final Scanner scanner;
<<<<<<< HEAD
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
=======

    public UserView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void insert() throws MyException{
        // 검증 클래스 생성
        InputValidation validation = new InputValidation();
        // 입력자료 저장을 위한 변수 선언
        String name;
        int age;
        String phone;
        String address;

        // 이름, 나이, 전화번호, 주소
        System.out.println("== 전화번호 등록 ==");
        // 이름 옳바른 값이 들어올 때 까지 반복
        boolean nameOk = false;
        do {
            try {
                // 이름 : 무조건 한글만.. 중간공백 없이
                System.out.println("이름 : ");
>>>>>>> ebe58eed74b1936a1d0609f882f294e7674558c1
                name = scanner.next();
                validation.nameCheck(name);
                nameOk = true;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
<<<<<<< HEAD
        } while (!nameOk);

        // 2. 나이 입력 및 검증
        boolean ageOk = false;
        do {
            try {
                System.out.print("나이 : ");
=======
        } while (! nameOk);

        // 나이 : 0세 ~ 120세 사이값
        boolean ageOk = false;
        do {
            try {
                System.out.println("나이 : ");
>>>>>>> ebe58eed74b1936a1d0609f882f294e7674558c1
                age = scanner.nextInt();
                validation.ageCheck(age);
                ageOk = true;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
<<<<<<< HEAD
        } while (!ageOk);

        // 3. 주소 입력
        System.out.print("주소 : ");
        address = scanner.next();

        // 4. 전화번호 입력 및 검증
        boolean phoneOk = false;
        do {
            try {
                System.out.print("전화번호(010-XXXX-XXXX) : ");
=======
        } while (! ageOk);

        // 주소
        System.out.println("주소 : ");
        address = scanner.next();

        // 전화번호(010-XXXX-XXXX)
        boolean phoneOk = false;
        do {
            try {
                System.out.println("전화번호 : ");
>>>>>>> ebe58eed74b1936a1d0609f882f294e7674558c1
                phone = scanner.next();
                validation.phoneCheck(phone);
                phoneOk = true;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
<<<<<<< HEAD
        } while (!phoneOk);

        // 비즈니스 로직(서비스) 호출
        telBookService.insert(name, age, address, phone);
    }
}
=======
        } while (! phoneOk);
    }

    public void update() {
    }

    public void delete() {
    }

    public void searchAll() {
    }

    public void searchOne() {
    }
}
>>>>>>> ebe58eed74b1936a1d0609f882f294e7674558c1
