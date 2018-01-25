package sorter.view;

import javax.swing.*;


import sorter.control.AlgorithmHandler;
import sorter.control.DataSet;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class is a widget that animates a sort algorithm, by showing
 * the integers as bars of a size corresponding to the size of the integer.
 * <p>
 * This class will have to be implemented by you!
 *
 * @author Filip Kingen Jägerud
 */
@SuppressWarnings("serial")
public class AnimationWidget extends JComponent /*implements Runnable */ {

    /**
     * A reference to the vector that is sorted, which is animated by this class
     */
    private DataSet vector;
    //final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    /**
     * The name of the algorithm
     */
    private String algorithmName;

    //private AnimationWidget animation2;
    //private static int i = 0;

    //private JFrame topFrame;


    // TODO Add more variables...


    /**
     * Creates an instance of AnimationWidget with
     * a given vector and an algorithm name
     * <p>
     * it will probably have to do more things!
     *
     * @param vector        the sortVector to draw
     * @param algorithmName the name of the algorithm
     */
    public AnimationWidget(DataSet vector,
                           String algorithmName) {
        this.vector = vector;
        this.algorithmName = algorithmName;
        setPreferredSize(new Dimension(700, 300));
        //animation2 = new AnimationWidget(vector,algorithmName);


        // TODO You will probably need to do some more stuff here
    }


    /**
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        //JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

        //topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        //topFrame.setTitle(algorithmName);
        //new Thread(animation2).start();
        g.setColor(Color.darkGray);
        this.setSize(new Dimension(getWidth(), getHeight()));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.WHITE);
        g.drawString(algorithmName, 10, 20);
        g.setColor(Color.lightGray);
        g.drawString("Jäger Äger", 150, 150);
        g.drawString("King Carl", 75, 75);

        //Målar ut en rektangel med höjd/bredd relativ till fönstret och antal
        for (int i = 0; i < vector.getSize(); i++) {
            g.fillRect(getWidth() * i / vector.getSize(), (((getHeight() - getHeight() * vector.get(i) / vector.getMax())) - 2),
                    (getWidth() / (vector.getSize()) - 1 + (2 * vector.getMax() / getWidth())),
                    getHeight() * vector.get(i) / vector.getMax() - 2);
        }
    }

    public void run() { //Målar om en färdig i ny färg med sleep
        this.getGraphics().setColor(Color.YELLOW); //TODO Filip: Osäker på this och funkar inte, får inte ändra?
        //new Thread(); något sådant?

        for (int i = 0; i < vector.getSize(); i++) {

            //Målar ut en rektangel med höjd/bredd relativ till fönstret och antal
            this.getGraphics().fillRect(getWidth() * i / vector.getSize(), (getHeight() - getHeight() * vector.get(i) / vector.getMax()) - 2,
                    getWidth() / vector.getSize() - 1 + 2 * vector.getMax() / getWidth(),
                    ((getHeight() * vector.get(i) / vector.getMax())) - 2);

            try {                                        //Snyggt men dålig lösning :(
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paintFinishedAlgorithm(Graphics g) {
        //Timer timer = new Timer(500,null);

        g.setColor(Color.YELLOW);

        //scheduledExecutorService.scheduleAtFixedRate(() -> {
        //int i =0;
        for (int i = 0; i < vector.getSize(); i++) {
            //while (i<vector.getSize()){
            //timer.start();

            //Målar ut en rektangel med höjd/bredd relativ till fönstret och antal
            g.fillRect(getWidth() * i / vector.getSize(), getHeight() - getHeight() * vector.get(i) / vector.getMax() - 2,
                    getWidth() / vector.getSize() - 1 + 2 * vector.getMax() / getWidth(),
                    getHeight() * vector.get(i) / vector.getMax() - 2);

            //timer.restart();
            //paintFinishedAlgorithm2();
            /*try {										//Snyggt men dålig lösning :(
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			/*scheduledExecutorService.scheduleWithFixedDelay(() -> {
				stupid(1);
			}, 0, 50, TimeUnit.MILLISECONDS);*/

        }

    }

    public void lightUpYourFuture(Graphics g, int i, int j) {

        g.setColor(Color.lightGray);
        for (int l = 0; l < vector.getSize(); l++) {
            g.fillRect(getWidth() * l / vector.getSize(), ((getHeight() - getHeight() * vector.get(l) / vector.getMax())) - 2,
                    (getWidth() / (vector.getSize()) - 1 + (2 * vector.getMax() / getWidth())),
                    (((getHeight()) * vector.get(l) / vector.getMax())) - 2);
        }
        g.setColor(Color.ORANGE);
        //Målar ut en rektangel med höjd/bredd relativ till fönstret och antal
        g.fillRect(getWidth() * i / vector.getSize(), getHeight() - getHeight() * vector.get(i) / vector.getMax() - 2,
                getWidth() / vector.getSize() - 1 + 2 * vector.getMax() / getWidth(),
                getHeight() * vector.get(i) / vector.getMax() - 2);
        g.setColor(Color.BLUE);
        g.fillRect(getWidth() * j / vector.getSize(), (getHeight() - getHeight() * vector.get(j) / vector.getMax()) - 2,
                getWidth() / vector.getSize() - 1 + 2 * vector.getMax() / getWidth(),
                getHeight() * vector.get(j) / vector.getMax() - 2);
    }

    public void lightUpYourPast(Graphics g, int i, int j) {

		/*g.setColor(Color.lightGray);
		for (int l = 0; l < vector.getSize(); l++) {
			g.fillRect(getWidth() * l / vector.getSize(), ((getHeight() - getHeight() * vector.get(l) / vector.getMax())),
					(getWidth() / (vector.getSize()) -1 + (2 * vector.getMax() / getWidth())),
					(((getHeight()) * vector.get(l) / vector.getMax())));
		}*/
        g.setColor(Color.RED);
        //Målar ut en rektangel med höjd/bredd relativ till fönstret och antal
        g.fillRect(getWidth() * i / vector.getSize(), getHeight() - getHeight() * vector.get(i) / vector.getMax() - 2,
                (getWidth() / (vector.getSize()) - 1 + 2 * vector.getMax() / getWidth()),
                getHeight() * vector.get(i) / vector.getMax() - 2);
        //g.setColor(Color.BL);
        g.fillRect(getWidth() * j / vector.getSize(), getHeight() - getHeight() * vector.get(j) / vector.getMax() - 2,
                getWidth() / vector.getSize() - 1 + 2 * vector.getMax() / getWidth(),
                getHeight() * vector.get(j) / vector.getMax() - 2);

        //TODO måla rött när cmd kallas, kalla på rödmedtoden då
    }

    public DataSet getVector() {
        return vector;
    }

    public void setDataSet(DataSet vector) {
        this.vector = vector;
    }

	/*public static int stupid (int x){
		i=i+x;
		return i;

	}
	*/


    // TODO Add more methods...

}
