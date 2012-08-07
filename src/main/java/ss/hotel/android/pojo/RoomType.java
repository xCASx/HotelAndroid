package ss.hotel.android.pojo;


public class RoomType  {

    private Long id;

    private String name;

    private String RoomsView;

    private int numberOfPlaces;

    private int numberOfRooms;

    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRoomsView() {
        return RoomsView;
    }

    public void setRoomsView(String RoomsView) {
        this.RoomsView = RoomsView;
    }


}
