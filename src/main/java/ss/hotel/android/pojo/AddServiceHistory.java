
package ss.hotel.android.pojo;

import java.io.Serializable;
import java.util.Date;


public class AddServiceHistory implements Serializable{
    private Long id;

    private AddService addService;

    private HotelOrder order;

    private double amount;

    private Date operationDate;

    private Boolean ClientPaid;

    private User user;


    public HotelOrder getOrder(){
    	return order;
    }

    public void setOrder(HotelOrder ho){
    	this.order = ho;
    }

    public AddService getAddService() {
        return addService;
    }

    public void setAddService(AddService addService) {
        this.addService = addService;
    }

    public Boolean isClientPaid() {
        return ClientPaid;
    }

    public void setClientPaid(Boolean ClientPaid) {
        this.ClientPaid = ClientPaid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOpperationDate() {
        return operationDate;
    }

    public void setOpperationDate(Date opperationDate) {
        this.operationDate = opperationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
