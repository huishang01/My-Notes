package LoginSystem;

public class User {
    private String username;
    private String password;
    private String id;
    private String phoneNum;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public User(String username, String password, String id, String phoneNum) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.phoneNum = phoneNum;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return phoneNum
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * 设置
     * @param phoneNum
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String toString() {
        return username + "\t" + password + "\t" + id + "\t" + phoneNum;
    }
}
