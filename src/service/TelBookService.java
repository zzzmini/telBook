package service;

import dto.TelDto;

public class TelBookService {
    private TelBookRepository repository; // static 제거 권장

    public TelBookService(TelBookRepository repository) {
        this.repository = repository;
    }

    // static을 제거하여 인스턴스 메서드로 변경 (UserView에서 호출 방식 변경 필요)
    public void insert(String name, int age, String address, String phone) {
        TelDto dto = new TelDto(0L, name, age, address, phone);
        int result = repository.insertData(dto); // 생성한 dto를 전달!

        if (result > 0) {
            System.out.println("정상적으로 저장되었습니다.");
        } else {
            System.out.println("저장에 실패했습니다.");
        }
    }
}