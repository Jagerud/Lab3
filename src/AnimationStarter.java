
import sorter.control.algorithms.*;
import sorter.view.Animator;
import sorter.view.AnimationWidget;


import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * The class that is used to start the animator.
 *
 * The algorithms that are to be shown have to be added here.
 * 
 * @author Sara Stymne
 *
 */
public class AnimationStarter {
	
    /**
     * The animator used in the application
     */
	private static Animator animator;
	
	/**
	 * Main program for the animator. 
	 * The algorithms that are to be shown are added here.
	 * 
	 * @param args not used
	 */
	public static void main(String args[]) {

		//final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		//executorService.scheduleAtFixedRate(AnimationWidget::paintFinishedAlgorithm2, 0, 1, TimeUnit.SECONDS);

		//Creates a new animator that places all algorithm
		//widgets on top of each other
		animator = new Animator();
		//AnimationWidget aW = new AnimationWidget(,"snopp");
		
		//The constructor of Animator can also be called
		//with two int arguments to change the grid-configuration of
		//the algorithms, for instance:
		//new Animator(2,2) 
		//to place the algorithms in a 2*2 grid.
		
		      
		//Adds algorithms to the system
		//animator.addAlgorithm(new BubbleSortAlgorithm());
		animator.addAlgorithm(new ImprovedBubbleSortAlgorithm());
		animator.addAlgorithm(new InsertionSortAlgorithm());
		animator.addAlgorithm(new Temp());
		animator.addAlgorithm(new ShellSort());
		//Add more algorithms here in the same way as for bubble sort
		
        
		//Must be called to show the main frame.
	    //Schedule a job for the event-dispatching thread:
        //showing the animator GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	animator.showFrame();


            }
        });

		    
	}

}
