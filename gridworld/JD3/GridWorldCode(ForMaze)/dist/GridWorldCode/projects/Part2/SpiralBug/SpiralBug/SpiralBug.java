import info.gridworld.actor.Bug;

public class SpiralBug extends Bug {
        private int steps;
        private int sidelength;
	
        public SpiralBug(int length) {
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
                        //turn two times to change 90 degree
                        turn();
                        turn();
                        steps = 0;
                        //we need to add the sidelength according to the picture
                        sidelength++;
                }
        }
}
