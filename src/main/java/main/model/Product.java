package main.model;

public class Product {

    private int id;
    private String name;
    private String description;
    private String createDate;
    private int placeStorage;
    private boolean reserved;

    public Product() {

    }

    public Product(int id, String name, String description, String createDate, int placeStorage, boolean reserved) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.placeStorage = placeStorage;
        this.reserved = reserved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getPlaceStorage() {
        return placeStorage;
    }

    public void setPlaceStorage(int placeStorage) {
        this.placeStorage = placeStorage;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
