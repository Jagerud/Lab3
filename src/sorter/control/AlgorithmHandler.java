package sorter.control;

import java.awt.*;
import java.util.concurrent.BrokenBarrierException;

import sorter.control.algorithms.SortAlgorithm;
import sorter.view.AnimationWidget;


/**
 * The AlgorithmHandler class handles the information that is necessary
 * for one instance of an algorithm: the widget for that algorithm,
 * the actual sorting algorithm and the vector that is being sorted.
 * <p>
 * This class implements runnable to allow it to be used in a thread
 * so that all algorithms can be synchronized
 * <p>
 * In this class you have to add calls to the widget when it has
 * to be updated.
 *
 * @author Sara Stymne
 */
public class AlgorithmHandler implements Runnable {

    /**
     * The actual algorithm
     */
    private SortAlgorithm algorithm;

    /**
     * The animation widget
     */
    private AnimationWidget widget;

    /**
     * The vector of integers that will be sorted
     */
    private DataSet sortVector;

    /**
     * The controller that makes sure that the algorithms are synchronized
     */
    private Algorithms algorithmMaster;

    /**
     * The status of all the algorithms
     */
    private AlgorithmStatus status;

    /**
     * The weight of a swap:
     * how many times more expensive a swap is than a comparison
     */
    private int swapWeight;

    /**
     * Creates a new instance of algorithmHandler with the specified algorithm,
     * widget and SortVector. It also sets a refernce to the current barrier.
     *
     * @param alg             the algorithm used
     * @param vec             the vector to be sorted
     * @param algorithmMaster the controller that syncronizes the threads
     * @param status          the status of all algorithms
     */
    public AlgorithmHandler(SortAlgorithm alg,
                            DataSet vec,
                            Algorithms algorithmMaster,
                            AlgorithmStatus status) {

        this.algorithmMaster = algorithmMaster;
        sortVector = vec;
        algorithm = alg;
        algorithm.setHandler(this);
        this.widget = new AnimationWidget(sortVector,
                algorithm.getAlgorithmName());
        this.status = status;
    }

    /**
     * Starts the sorting
     *
     * @see java.lang.Runnable#run()
     */
    public void run() {
        algorithm.run();
    }


    /**
     * called when the algorithm is finished,
     * changes color of finished algorithm
     * <p
     */
    public void finished() {
        if (getElementCount() == sortVector.getSize()) {

            widget.paintFinishedAlgorithm(widget.getGraphics());
        }
        status.increaseFinishedAlgs(); //kanske innan animation
        waitForOthers();
    }

    /**
     * Method that keeps noticing the barrier until all other
     * algorithms are finished.
     * This method is called when an algorithm is finished.
     */
    public void waitForOthers() {
        while (!status.animationFinished()) {
            oneStepDone();
        }
    }

    /**
     * Sets the vector that will be sorted
     * and repaints the widget
     * <p>
     *
     * @param vec the vector
     */
    public void setVector(DataSet vec) {
        sortVector = vec;
        widget.setDataSet(sortVector);
        widget.repaint();
    }

    /**
     * Gives the widget of the algorithm handler
     *
     * @return the current animation widget
     */
    public AnimationWidget getWidget() {
        return widget;
    }

    /**
     * Sets the weight of a swap
     * <p>
     * That is how much more expensive it is than a comparison
     *
     * @param swapWeight the new weight
     */
    public void setSwapWeight(int swapWeight) {
        this.swapWeight = swapWeight;
    }

    /**
     * Causes the barrier to wait for all other threads to finish a step
     */
    public void oneStepDone() {
        try {
            algorithmMaster.await();
        } catch (InterruptedException ex) {
            System.out.println("interrupted");
            return;
        } catch (BrokenBarrierException ex) {
            System.out.println("broken");
            return;
        }
    }

    /**
     * Tells the widget which two columns that has been swapped
     * and assures synchronisation.
     * <p>
     *
     * @param index1 the index of the first column
     * @param index2 the index of the second column
     */
    private void swapDone(int index1, int index2) {
        // TODO Add call to update widget
        widget.repaint();
        //oneStepDone is called swapWeight times, in order to 
        //allow a swap to be more expensive than a comparison
        for (int i = 0; i < swapWeight; ++i) {
            oneStepDone();
        }
    }

    /**
     * Swaps the values at the two indices in the vector,
     * and tells the handler that it has made a swap and
     * what two elements were swapped
     * Also paints the indexes swapped in different color.
     *
     * @param i the index of the first element
     * @param j the index of the first element
     */
    public void swap(int i, int j) {

        sortVector.swap(i, j);
        swapDone(i, j);
        widget.lightUpYourPast(widget.getGraphics(), i, j);
    }

    /**
     * Compares the values of the numbers at the two given indeces in the vector
     * and notifies the handler that a step has been done.
     * Also paints the indexes compared in different color.
     *
     * @param i the index of the first number to compare
     * @param j the index of the second number to compare
     * @return a negative value if the value at i is smalller
     * a positive value if the value at i is bigger
     * zero if the numbers at i and j are equal
     */
    public int cmp(int i, int j) {
        widget.lightUpYourFuture(widget.getGraphics(), i, j);
        oneStepDone();
        return sortVector.cmp(i, j);
    }


    /**
     * Gives the size of the current sort vector
     *
     * @return the size of the sort vector
     */
    public int getElementCount() {
        return sortVector.size();
    }
} 
