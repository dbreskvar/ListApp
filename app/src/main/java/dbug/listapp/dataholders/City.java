package dbug.listapp.dataholders;

/**
 * Created by davidbreskvar on 15/12/15.
 */
public class City {

    String name, details, code;
    int imageID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = String.format("(%s)", code);
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getFullName() {
        return String.format("%s %s", this.name, this.code);
    }
}
