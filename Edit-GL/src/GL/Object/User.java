package GL.Object;

import GL.Enum.Position;

import java.util.UUID;

public class User {
    String firstName,lastName,id,pass;
    Position position;
    UUID userUuid;

    //====================== Setter Section ========================//

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }
    //====================== Getter Section ========================//

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public Position getPosition() {
        return position;
    }

    public UUID getUserUuid() {
        return userUuid;
    }
    //====================== Constructor Section ========================//

    public User() {

    }

    public User(String firstName, String lastName, String id, String pass, Position position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.pass = pass;
        this.position = position;
    }

    public User(String firstName, String lastName, String id, String pass, Position position, UUID userUuid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.pass = pass;
        this.position = position;
        this.userUuid = userUuid;
    }
}

