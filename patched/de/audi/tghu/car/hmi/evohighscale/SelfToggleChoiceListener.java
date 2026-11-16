/*
 * Minimal ChoiceListener that makes a checkbox self-toggle.
 *
 * A ChoiceModel does NOT change its own value on itemSelected(); it only notifies
 * its listener. For a standalone checkbox that has no backing application logic,
 * this listener simply writes the selected value back into the model, so the
 * checkbox visibly ticks/unticks when the user clicks it.
 */
package de.audi.tghu.car.hmi.evohighscale;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.ChoiceModel;

public class SelfToggleChoiceListener implements ChoiceListener {

    private final ChoiceModel model;

    public SelfToggleChoiceListener(ChoiceModel model) {
        this.model = model;
    }

    public void itemSelected(int id, int value, int column, int terminal) {
        this.model.setValue(value);
    }

    public void itemFocused(int id, int value, int column, int terminal) {
    }

    public void keyPressed(int id, int code, int terminal) {
    }

    public void keyReleased(int id, int code, int terminal) {
    }

    public void keyTyped(int id, int code, int terminal) {
    }

    public void keyLongTyped(int id, int code, int terminal) {
    }
}
