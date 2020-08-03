package model;

public class SearchModel {
    private String product;
    private String time;



    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public SearchModel(String product, String time) {
        this.product = product;
        this.time = time;
    }

    public SearchModel() {
    }





}
