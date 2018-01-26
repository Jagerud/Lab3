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
 *
 * @author Filip Kingen Jägerud
 */
@SuppressWarnings("serial")
public class AnimationWidget extends JComponent /*implements Runnable */ {

    /**
     * A reference to the vector that is sorted, which is animated by this class
     */
    private DataSet vector;

    /**
     * The name of the algorithm
     */
    private String algorithmName;

    /**
     * Creates an instance of AnimationWidget with
     * a given vector and an algorithm name
     * Sets preferred size of window
     *
     * @param vector        the sortVector to draw
     * @param algorithmName the name of the algorithm
     */
    public AnimationWidget(DataSet vector,
                           String algorithmName) {
        this.vector = vector;
        this.algorithmName = algorithmName;
        setPreferredSize(new Dimension(700, 300));

    }


    /**
     * Paints the window with rectangles relative
     * in size to the size of the window.
     *
     * @param g, graphics
     */
    @Override
    public void paintComponent(Graphics g) {
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

    /**
     * Paints all rectangles in the finished algorithm in different color
     *
     * @param g, graphics
     */
    public void paintFinishedAlgorithm(Graphics g) {

        g.setColor(Color.YELLOW);

        for (int i = 0; i < vector.getSize(); i++) {

            //Målar ut en rektangel med höjd/bredd relativ till fönstret och antal
            g.fillRect(getWidth() * i / vector.getSize(), getHeight() - getHeight() * vector.get(i) / vector.getMax() - 2,
                    getWidth() / vector.getSize() - 1 + 2 * vector.getMax() / getWidth(),
                    getHeight() * vector.get(i) / vector.getMax() - 2);
        }

    }

    /**
     * Paints the indexes that are being compared in different colors
     *
     * @param g, graphics
     * @param i, index to be painted
     * @param j, index to be painted
     */
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

    /**
     * Paints the rectangles that where swapped in different color.
     *
     * @param g, graphics
     * @param i, index to be painted
     * @param j, index to be painted
     */
    public void lightUpYourPast(Graphics g, int i, int j) {
        g.setColor(Color.RED);
        //Målar ut en rektangel med höjd/bredd relativ till fönstret och antal
        g.fillRect(getWidth() * i / vector.getSize(), getHeight() - getHeight() * vector.get(i) / vector.getMax() - 2,
                (getWidth() / (vector.getSize()) - 1 + 2 * vector.getMax() / getWidth()),
                getHeight() * vector.get(i) / vector.getMax() - 2);

        g.fillRect(getWidth() * j / vector.getSize(), getHeight() - getHeight() * vector.get(j) / vector.getMax() - 2,
                getWidth() / vector.getSize() - 1 + 2 * vector.getMax() / getWidth(),
                getHeight() * vector.get(j) / vector.getMax() - 2);
    }

    /**
     * Returns the vector
     *
     * @return, vector
     */
    public DataSet getVector() {
        return vector;
    }

    /**
     * Sets the vector
     *
     * @param vector
     */
    public void setDataSet(DataSet vector) {
        this.vector = vector;
    }


}
