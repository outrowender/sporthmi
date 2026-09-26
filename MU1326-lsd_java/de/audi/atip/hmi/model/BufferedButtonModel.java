/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.BufferedAbstractModel;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelGUI;

public class BufferedButtonModel
extends BufferedAbstractModel
implements ButtonModelGUI,
ButtonModelApp {
    private ButtonModel buttonModel = (ButtonModel)super.getMainModel();

    public BufferedButtonModel(int n) {
        super(new ButtonModel(n), new ButtonModel(n));
    }

    public BufferedButtonModel(int n, int n2) {
        super(new ButtonModel(n, n2), new ButtonModel(n, n2));
    }

    @Override
    public void setButtonListener(ButtonListener buttonListener) {
        this.buttonModel.setButtonListener(buttonListener);
    }

    @Override
    public void setPressed(boolean bl) {
        this.getCurrent().setPressed(bl);
    }

    @Override
    public boolean getPressed() {
        return this.buttonModel.getPressed();
    }

    @Override
    public void endTransaction() {
        super.endTransaction();
        this.buttonModel.fireModelUpdateEvent(1);
    }

    @Override
    public void keyPressed(int n, int n2) {
        this.buttonModel.keyPressed(n, n2);
    }

    @Override
    public void keyReleased(int n, int n2) {
        this.buttonModel.keyReleased(n, n2);
    }

    @Override
    public void keyTyped(int n, int n2) {
        this.buttonModel.keyTyped(n, n2);
    }

    @Override
    public void keyLongTyped(int n, int n2) {
    }

    private ButtonModel getCurrent() {
        return (ButtonModel)super.getActiveModel();
    }
}

