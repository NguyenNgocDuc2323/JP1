package Person;

public enum Gender {
    M("Male"),F("Female"),O("Other");
    private String gender;
    Gender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
