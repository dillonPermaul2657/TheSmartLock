package ca.thedjkm.it.smartlock.ui.Review;

public class ReviewData {

        private String name;
        private String email;



    public ReviewData(){}
    public ReviewData(String name, String email)
    {
        this.name = name;
        this.email = email;
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
