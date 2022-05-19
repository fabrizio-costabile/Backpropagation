package com.github.fabrizio_costabile.backpropagation.data;

import java.util.ArrayList;

/**
 * Collection of {@link Data} for training and/or testing purposes
 *
 * @author Fabrizio Costabile
 */
public class DataSet extends ArrayList<Data> {

    /**
     * Constructs a new data set
     */
    public DataSet() {
        super();
    }

    /**
     * Add data to this data set
     *
     * @param data the data to add
     */
    public void addData(Data data) {
        add(data);
    }

}
