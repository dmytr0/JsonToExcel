package xyz.dimonick.JsonToXls.POJO;

import java.util.Date;
import java.util.List;

public class Visitor {
    private long id;
    private String firstName;
    private String lastName;
    private String macAddress;
    private String gender;
    private Date dateOfBirth;
    private String email;
    private String phone;
    private String country;
    private String city;
    private String deviceType;
    private String os;
    private String vkID;
    private String facebookID;
    private String comment;
    private List<String> images;
    private List<String> occupation;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getVkID() {
        return vkID;
    }

    public void setVkID(String vkID) {
        this.vkID = vkID;
    }

    public String getFacebookID() {
        return facebookID;
    }

    public void setFacebookID(String facebookID) {
        this.facebookID = facebookID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getOccupation() {
        return occupation;
    }

    public void setOccupation(List<String> occupation) {
        this.occupation = occupation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "firstName='" + firstName + '\'' + "\n" +
                ", lastName='" + lastName + '\'' + "\n" +
                ", macAddress='" + macAddress + '\'' + "\n" +
                ", gender='" + gender + '\'' + "\n" +
                ", dateOfBirth=" + dateOfBirth + "\n" +
                ", email='" + email + '\'' + "\n" +
                ", phone='" + phone + '\'' + "\n" +
                ", country='" + country + '\'' + "\n" +
                ", city='" + city + '\'' + "\n" +
                ", deviceType='" + deviceType + '\'' + "\n" +
                ", os='" + os + '\'' + "\n" +
                ", vkID='" + vkID + '\'' + "\n" +
                ", facebookID='" + facebookID + '\'' + "\n" +
                ", comment='" + comment + '\'' + "\n" +
                ", images=" + images + "\n" +
                ", occupation=" + occupation + "\n" +
                '}';
    }
}
