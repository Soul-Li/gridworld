import info.gridworld.actor.Bug;

public class CircleBug extends Bug {
    private int steps;
    private int sidelength;

    //constructor
    public CircleBug(int length) {        
        steps = 0;
        sidelength = length;       
    }

    public void act() {
        if (steps < sidelength && canMove()) {
            move();
            steps++;
        }
        else
        {
            //just one turn is oks
            turn();
            //restart to move                      
            steps = 0;
        }
    }
}
