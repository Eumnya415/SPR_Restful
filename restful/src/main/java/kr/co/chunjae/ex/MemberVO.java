package kr.co.chunjae.ex;

public class MemberVO {
    private String id;
    private String pwd;
    private String name;
    private String email;

    // 기본 메소드
    public MemberVO() { }

    // 회원의 속성 정보를 출력할 것이기 때문에 오버라이드
    @Override
    public String toString() {
        String info = id + "," + pwd + "," + name + "," + email;
        return info;
    }

    // 이하 각 속성에 대한 getter/setter


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
