
package ss.hotel.android.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class HotelOrder{
    private Long id;

    private User user;

    private Set<AddServiceHistory> addServiceHistory = new HashSet<AddServiceHistory>();

    private RoomType roomType;

    private int number;

    private Date DateIn;

    private Date DateOut;

    public Date getDateIn() {
        return DateIn;
    }

    public void setDateIn(Date DateIn) {
        this.DateIn = DateIn;
    }

    public Date getDateOut() {
        return DateOut;
    }

    public void setDateOut(Date DateOut) {
        this.DateOut = DateOut;
    }

    public Set<AddServiceHistory> getAddServiceHistory() {
        return addServiceHistory;
    }

    public void setAddServiceHistory(Set<AddServiceHistory> addServiceHistory) {
        this.addServiceHistory = addServiceHistory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

}
