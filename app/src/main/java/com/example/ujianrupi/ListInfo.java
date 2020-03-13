package com.example.ujianrupi;

import java.io.Serializable;

public class ListInfo implements Serializable {
    private String NumberInvoice, DateOrder, NameOrder, TimeRespon;


    public ListInfo(String numberInvoice, String dateOrder, String nameOrder, String timeRespon) {
        NumberInvoice = numberInvoice;
        DateOrder = dateOrder;
        NameOrder = nameOrder;
        TimeRespon = timeRespon;

    }





    public String getNumberInvoice() {
        return NumberInvoice;
    }

    public void setNumberInvoice(String numberInvoice) {
        NumberInvoice = numberInvoice;
    }

    public String getDateOrder() {
        return DateOrder;
    }

    public void setDateOrder(String dateOrder) {
        DateOrder = dateOrder;
    }

    public String getNameOrder() {
        return NameOrder;
    }

    public void setNameOrder(String nameOrder) {
        NameOrder = nameOrder;
    }

    public String getTimeRespon() {
        return TimeRespon;
    }

    public void setTimeRespon(String timeRespon) {
        TimeRespon = timeRespon;
    }

}

