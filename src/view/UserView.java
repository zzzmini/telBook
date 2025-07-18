package view;

import dto.TelDto;
import exception.InputValidation;
import exception.MyException;
import service.TelBookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserView {
    private Scanner sc = new Scanner(System.in);
    private TelBookService telBookService = new TelBookService();
    private InputValidation validation = new InputValidation();

    public void insertView() {
        System.out.println("=== 전화번호 등록 ===");
        // 한글 이름 입력 처리 확인
        boolean nameOK = true;
        String name = "";
        while (nameOK) {
            try {
                System.out.println("이름을 입력하세요");
                name = sc.next();
                validation.nameCheck(name);
                nameOK = false;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean ageOk = true;
        int age = -1;
        while (ageOk) {
            try {
                System.out.println("나이를 입력하세요");
                age = sc.nextInt();
                validation.ageCheck(age);
                ageOk = false;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("주소를 입력하세요");
        String address = sc.next();

        boolean addressOk = true;
        String phone = "";
        while (addressOk) {
            try {
                System.out.println("전화번호를 입력하세요");
                phone = sc.next();
                validation.phoneCheck(phone);
                addressOk = false;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

        // 입력 받은 후 빈 TelDto에 넣는다.
        // id를 제외한 정보 입력(id는 자동생성)
        TelDto dto = new TelDto();
        dto.setName(name);
        dto.setAge(age);
        dto.setAddress(address);
        dto.setPhone(phone);

        // 서비스에 insert 요청하기
        int result = telBookService.insertData(dto);
        // result > 0 : insert 성공, result = 0 : 실패
        if (result > 0) {
            System.out.println("정상적으로 입력되었습니다.");
        } else {
            System.out.println("입력되지 않았습니다.");
        }
    }

    public void updateView() {
        System.out.println("=== 전화번호 수정 ===");
        System.out.println("수정할 ID를 입력하세요");
        int updateId = sc.nextInt();
        // 수정할 데이터를 가져온다.(TelDto)
        TelDto oldDto = telBookService.findById(updateId);
        if (oldDto == null) {
            System.out.println("찾는 데이터가 없어요");
        } else {
            // 수정작업 진행
            boolean yesOrNo = true;
            // 이름 수정 처리
            while (yesOrNo) {
                System.out.println("수정 전 : " + oldDto.getName());
                System.out.println("수정할까요(Y/N)?");
                String strYesOrNo = sc.next();
                if (strYesOrNo.toUpperCase().equals("Y")) {
                    System.out.println("수정할 이름 : ");
                    oldDto.setName(sc.next());
                    yesOrNo = false;
                } else {
                    yesOrNo = false;
                }
            }
            // 나이 수정 처리
            yesOrNo = true;
            while (yesOrNo) {
                System.out.println("수정 전 나이 : " + oldDto.getAge());
                System.out.println("수정할까요(Y/N)?");
                String strYesOrNo = sc.next();
                if (strYesOrNo.toUpperCase().equals("Y")) {
                    System.out.println("수정할 나이 : ");
                    oldDto.setAge(sc.nextInt());
                    yesOrNo = false;
                } else {
                    yesOrNo = false;
                }
            }
            // 주소 수정 처리
            yesOrNo = true;
            while (yesOrNo) {
                System.out.println("수정 전 주소 : " + oldDto.getAddress());
                System.out.println("수정할까요(Y/N)?");
                String strYesOrNo = sc.next();
                if (strYesOrNo.toUpperCase().equals("Y")) {
                    System.out.println("수정할 주소 : ");
                    oldDto.setAddress(sc.next());
                    yesOrNo = false;
                } else {
                    yesOrNo = false;
                }
            }
            // 전화번호 수정 처리
            yesOrNo = true;
            while (yesOrNo) {
                System.out.println("수정 전 전번 : " + oldDto.getPhone());
                System.out.println("수정할까요(Y/N)?");
                String strYesOrNo = sc.next();
                if (strYesOrNo.toUpperCase().equals("Y")) {
                    System.out.println("수정할 전번 : ");
                    oldDto.setPhone(sc.next());
                    yesOrNo = false;
                } else {
                    yesOrNo = false;
                }
            }
        }
        // 위에서 수정작업 완료
        int result = telBookService.UpdateData(oldDto);
        if (result > 0) {
            System.out.println("수정되었습니다.");
        } else {
            System.out.println("수정 실패");
        }
    }

    public void deleteView() {
        System.out.println("=== 전화번호 삭제 ===");
        System.out.println("삭제할 ID를 입력하세요");
        int deleteId = sc.nextInt();
        // 삭제 요청 후 결과를 int 타입으로 받기
        int result = telBookService.deleteData(deleteId);
        // result 값이 양수면 성공, 그렇지 않으면 실패
        if (result > 0) {
            System.out.println("정상적으로 삭제되었습니다.");
        } else {
            System.out.println("삭제되지 않았습니다.");
            System.out.println("관리자에게 문의하세요.");
        }
    }

    public void findAllView() {
        List<TelDto> dtoList = new ArrayList<>();
        System.out.println("=== 전화번호 목록 ===");
        // 서비스에 DB에서 리스트요청하기
        dtoList = telBookService.getListAll();
        // 출력
        dtoList.stream()
                .forEach(x -> System.out.println(x));
    }

    public void searchView() {
        System.out.println("=== 전화번호 검색 ===");
        System.out.println("이름으로 검색합니다.");
        System.out.println("이름 전체나 일부를 입력하세요");
        String keyword = sc.next();
        List<TelDto> dtoList = telBookService.searchList(keyword);
        if (dtoList.size() == 0) {
            System.out.println("찾는 데이터가 없습니다.");
        } else {
            dtoList.stream()
                    .forEach(x -> System.out.println(x));
        }
    }
}
