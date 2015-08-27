import info.gridworld.actor.Bug;

public class ZBug extends Bug {
        private int steps;
        private int sidelength;
        //the number of the bug's turn
        private int turnTime;
        public ZBug(int length) {
                steps = 0;
                sidelength = length;
                turnTime = 0;
        }

        public void act() {
                //a bug need to turn
                if (steps == sidelength) {
                        turnTime++;
                        steps = 0;
                }
                //turn 135 clockwise when the bug move enough steps
                if ((turnTime == 1 || turnTime == 2) && steps == 0) {
                        turn();
                        turn();
                        turn();
                }
                //turn 90 clockwise when the bug start to move or the second time to turn
                if (getDirection() == 0 && (turnTime == 0 || turnTime == 2)) {
                        turn();
                        turn();
                }
		//time that the bug should move,ohterwise stay still
                if (turnTime < 3 && canMove()) {
                        move();
                        steps++;
                }
        }
}


