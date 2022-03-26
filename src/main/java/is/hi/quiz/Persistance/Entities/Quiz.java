package is.hi.quiz.Persistance.Entities;

import javax.persistence.Column;
import java.util.List;
import java.util.Timer;
// Todo implement with category entity and questions
public class Quiz {
    long ID;
    @Column(name="category")
    Category category;
    //Timer timer;
    @Column(name="noOfPlayers")
    int noOfPlayers;
    @Column(name="loggedInUser")
    String loggedInUser;

    public Quiz(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
    // List category has a list of questions.
    public Quiz(Category category,  int noOfPlayers) {
        this.category = category;
      //  this.timer = timer;
        this.noOfPlayers = noOfPlayers;
    }

    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getNoOfPlayers() {
        return noOfPlayers;
    }

    public void setNoOfPlayers(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
    }
}
