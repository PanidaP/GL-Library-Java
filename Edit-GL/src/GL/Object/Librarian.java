package GL.Object;

import GL.Enum.Position;
import GL.Object.User;

public class Librarian extends User {
    public Librarian(){

    }

    public Librarian(String firstName, String lastName, String id, String pass, Position position) {
        super(firstName, lastName, id, pass, position);
    }
}
