package edu.jsu.mcis;

import java.awt.event.*;
import javax.swing.*;

import edu.jsu.mcis.TicTacToeModel.Mark;

public class TicTacToeController implements ActionListener {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */

    public TicTacToeController(final int width) {

        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView(this, width);

    }

    public String getMarkAsString (int row, int col) {
        return (model.getMark(row, col).toString());
    }

    public TicTacToeView getView() {
        return view;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String evnt = event.toString();
        evnt = evnt.substring (evnt.length() - 2);
        int inp = Integer.parseInt(evnt);
        int a = inp/10;
        int b = inp%10;
        model.makeMark(a, b);
        view.updateSquares();
        if (!model.getResult().equals(TicTacToeModel.Result.NONE)){
            view.showResult(model.getResult().toString());
            view.disableSquares();
        }
    }
}