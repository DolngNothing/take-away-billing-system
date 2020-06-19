package model;

public class Result {
    StringBuffer resultString;
    Integer totalPrice;
    Integer cutPrice;

    public Result(StringBuffer resultString, Integer totalPrice, Integer cutPrice) {
        this.resultString = resultString;
        this.totalPrice = totalPrice;
        this.cutPrice = cutPrice;
    }

    public Result() {
    }

    public StringBuffer getResultString() {
        return resultString;
    }

    public void setResultString(StringBuffer resultString) {
        this.resultString = resultString;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getCutPrice() {
        return cutPrice;
    }

    public void setCutPrice(Integer cutPrice) {
        this.cutPrice = cutPrice;
    }
}
