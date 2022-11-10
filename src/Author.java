public class Author {
    private final String fullName;
    private String email;
    private final char gender;
    public Author(String fullName,String email,char gender){
        this.fullName=fullName;
        this.email=email;
        this.gender=gender;
    }
    public String getFullName(){
        return fullName;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    public char getGender(){
        return gender;
    }

    @Override
    public String toString() {
        return fullName ;
    }
}
