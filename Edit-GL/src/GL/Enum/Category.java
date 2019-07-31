package GL.Enum;

public enum Category {
    Animal("A1"),
    History("H1"),
    Novel("N1"),
    Comic("C1"),
    Computer("C2");

    private String code;
    Category(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
