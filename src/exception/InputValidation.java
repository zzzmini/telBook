package exception;

import java.util.regex.Pattern;

public class InputValidation {
<<<<<<< HEAD
    //  이름 검증 : 한글만 허용(공백허용 안함)
    public void nameCheck(String name) throws MyException {
        //  정규표현식
        boolean check = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
        //  한글이 아닌 게 들어오면
        if(!check){
            throw new MyException("※ 이름은 한글로 입력해 주세요");
        }
    }
    //  나이 검증 : 0 ~ 120 사이 값이 들어와야 함.
    public void ageCheck(int age) throws  MyException{
        if(age < 0 || age > 120){
            throw new MyException("※ 나이는 0세부터 ~ 120세 까지 입니다.");
        }
    }
    //  전화번호 검증 - 형식 체크(010-XXXX-XXXX) 만 입력 가능
    //  "-"도 반드시 필요
    public void phoneCheck(String phone) throws  MyException{
        boolean check = Pattern.matches("(010)-(\\d{4})-(\\d{4})", phone);
        if(!check){
            throw new MyException("※ 전화번호 형식은 [010-XXXX-XXXX] 입니다.");
=======
    // 이름 검증 : 한글만 허용(공백허용 안함 - 김 형민 X)
    // 옳바른 예 : 김형민
    public void nameCheck(String name) throws MyException {
        // 정규표현식
        boolean check = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
        // 한글이 아닌 게 들어오면
        if (! check) {
            throw new MyException("※ 이름은 한글로 입력해 주세요");
        }
    }
    // 나이 검증 : 0 ~ 120 사이 값이 들어와야 함.
    public void ageCheck(int age) throws MyException {
        if (age < 0 || age > 120) {
            throw new MyException("※ 나이는 0세부터 120세까지 입니다.");
        }
    }
    // 전화번호 검증 - 형식 체크(010-XXXX-XXXX) 만 입력 가능
    // "-"도 반드시 필요
    public void phoneCheck(String phone) throws MyException {
        boolean check = Pattern.matches("(010)-(\\d{4})-(\\d{4})", phone);
        if (!check) {
            throw new MyException("※ 전화번호 형식은 [010-XXXX-XXXX]입니다.");
>>>>>>> ebe58eed74b1936a1d0609f882f294e7674558c1
        }
    }
}
