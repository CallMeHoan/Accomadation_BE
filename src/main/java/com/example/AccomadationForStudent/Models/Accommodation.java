package com.example.AccomadationForStudent.Models;


import javax.persistence.*;

@Entity
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String Name;
    private String Description;
    private Integer Toilets;
    private boolean Wifi_Access;
    private Integer Floor;
    private Integer People;
    private Double Area;
    private String Address;
    private Double Price;
    private Integer Available;
    private Integer Rooms;
    private String Image_Url;

    public Accommodation() {
    }

    public Accommodation(Long id, String name, String description, Integer toilets, boolean wifi_Access, Integer floor, Integer people, Double area, String address, Double price, Integer available, Integer rooms, String image_Url) {
        Id = id;
        Name = name;
        Description = description;
        Toilets = toilets;
        Wifi_Access = wifi_Access;
        Floor = floor;
        People = people;
        Area = area;
        Address = address;
        Price = price;
        Available = available;
        Rooms = rooms;
        Image_Url = image_Url;
    }

    public Accommodation(String name, String description, Integer toilets, boolean wifi_Access, Integer floor, Integer people, Double area, String address, Double price, Integer available, Integer rooms, String image_Url) {
        Name = name;
        Description = description;
        Toilets = toilets;
        Wifi_Access = wifi_Access;
        Floor = floor;
        People = people;
        Area = area;
        Address = address;
        Price = price;
        Available = available;
        Rooms = rooms;
        Image_Url = image_Url;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Integer getToilets() {
        return Toilets;
    }

    public void setToilets(Integer toilets) {
        Toilets = toilets;
    }

    public boolean isWifi_Access() {
        return Wifi_Access;
    }

    public void setWifi_Access(boolean wifi_Access) {
        Wifi_Access = wifi_Access;
    }

    public Integer getFloor() {
        return Floor;
    }

    public void setFloor(Integer floor) {
        Floor = floor;
    }

    public Integer getPeople() {
        return People;
    }

    public void setPeople(Integer people) {
        People = people;
    }

    public Double getArea() {
        return Area;
    }

    public void setArea(Double area) {
        Area = area;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Integer getAvailable() {
        return Available;
    }

    public void setAvailable(Integer available) {
        Available = available;
    }

    public Integer getRooms() {
        return Rooms;
    }

    public void setRooms(Integer rooms) {
        Rooms = rooms;
    }

    public String getImage_Url() {
        return Image_Url;
    }

    public void setImage_Url(String image_Url) {
        Image_Url = image_Url;
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Toilets=" + Toilets +
                ", Wifi_Access=" + Wifi_Access +
                ", Floor=" + Floor +
                ", People=" + People +
                ", Area=" + Area +
                ", Address='" + Address + '\'' +
                ", Price=" + Price +
                ", Available=" + Available +
                ", Rooms=" + Rooms +
                ", Image_Url='" + Image_Url + '\'' +
                '}';
    }
}
