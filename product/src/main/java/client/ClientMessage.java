package client;


import static java.lang.System.out;

public enum ClientMessage {
    HELP("""
            규칙
            - 공백으로 구분을 합니다.
            
            아래 명령어를 지원 합니다. 
            - check (상품교환여부 확인)
            - cleim (상품교환)
            - help (사용법 안내)
            - exit (나가기)
            
            입력 예시)
            check PRODU_001 PRODU_012 PRODU_003
            HELP
            claim KOREAA PRODU_001 PRODU_003 PRODU_005
            """),
    BEING_EXCHANGE("지원 가능"),
    NONE_EXCHANGE("지원 안함"),
    SUCCESS_EXCHANGE("교환 성공"),
    FAIL_EXCHANGE("교환 실패");

    private final String name;

    ClientMessage(String name) {
        this.name=name;
    }
    public void print(){
        out.print(name);
    }
}
