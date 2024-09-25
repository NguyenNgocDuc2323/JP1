package E3;

public enum Gender {
    M("Male"),F("Female");
    private String gender;
    Gender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
}
