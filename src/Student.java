public class Student {
    private String id;
    private String name;
    private String dateOfBirth;
    private String joinedDate;

    public Student(String id, String name, String dateOfBirth, String joinedDate) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.joinedDate = joinedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }
}
