package ca.thedjkm.it.smartlock.ui.Review;
//Kamaljit Mahal N01377647 Section B
//Dillon Permaul N01372657 Section B
//Janpreet Singh N01361405 Section B
//Meet Gajjar N01391319 Section B

public class ReviewData {

        private String name;
        private String email;
        private String phone;
        private String feedback;



    public ReviewData(){}
    public ReviewData(String name, String email, String phone, String feedback )
    {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.feedback = feedback;
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

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

}
