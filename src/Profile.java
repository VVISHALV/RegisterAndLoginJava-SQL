public class Profile {
    String Name;
    String Mobile;
    String MailId;
    String Password;

    Profile(){}
    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getMobile() {
        return this.Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getMailId() {
        return this.MailId;
    }

    public void setMailId(String MailId) {
        this.MailId = MailId;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Profile(String Name,String Mobile,String MailId,String Password){
        this.Name=Name;
        this.MailId=MailId;
        this.Mobile=Mobile;
        this.Password=Password;
    }

}
