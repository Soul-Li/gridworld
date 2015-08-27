import info.gridworld.actor.Bug;

public class DancingBug extends Bug {
        private int move[] = new int[100];
        private int steps;
        private int sidelength;
        //produce random number for bug's move
        public DancingBug(int[] tempmove) {
                System.arraycopy(tempmove,0,move,0,20);
                steps = 0;
                sidelength = tempmove.length;
        }

        public void act() {
                int temp = move[steps];
                //change direction
                while (temp > 0) {
                        temp--;
                        turn();
		}
                if (canMove()) {
                    move();
                }
                steps++;
                //restart a new loop
                if (steps == sidelength) {
                    steps = 0;
                }
        }
}
