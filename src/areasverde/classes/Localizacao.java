package areasverde.classes;

public class Localizacao{
    private int idAreaV;
    private String latitude;
    private String longitude;

    @Override
    public String toString(){
        return "Latitude: " + latitude + " Longitude: " + longitude;
    }

    public Localizacao(int idAreV, String latitude, String longitude) {
        this.idAreaV = idAreaV;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getIdAreaV() {
        return idAreaV;
    } //GET ID
    public void setIdAreaV(int idAreaV) {
        this.idAreaV = idAreaV;
    } //SET ID

    public String getLatitude() {
        return latitude;
    } //GET LATITUDE
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    } //SET LATITUDE

    public String getLongitude() {
        return longitude;
    } //GET LONGITUDE
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    } //SET LONGITUDE
}
