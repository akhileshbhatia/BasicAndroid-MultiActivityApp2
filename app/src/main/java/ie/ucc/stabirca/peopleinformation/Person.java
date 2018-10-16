package ie.ucc.stabirca.peopleinformation;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    private String phone;
    private String address;
    private String image;
    private String url;

    public Person(String name, String phone, String address, String image, String url) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
