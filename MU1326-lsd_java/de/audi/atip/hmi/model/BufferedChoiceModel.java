/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.BufferedAbstractModel;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;

public class BufferedChoiceModel
extends BufferedAbstractModel
implements ChoiceModelGUI,
ChoiceModelApp {
    private ChoiceModel choiceModel = (ChoiceModel)super.getMainModel();

    public BufferedChoiceModel(int n) {
        super(new ChoiceModel(n), new ChoiceModel(n));
    }

    public BufferedChoiceModel(int n, int n2) {
        super(new ChoiceModel(n, n2), new ChoiceModel(n, n2));
    }

    @Override
    public void setChoiceListener(ChoiceListener choiceListener) {
        this.choiceModel.setChoiceListener(choiceListener);
    }

    @Override
    public void setButtonListener(ButtonListener buttonListener) {
        throw new IllegalArgumentException("Not allowd to register ButtonListener to BufferedChoiceModel!");
    }

    @Override
    public void setPressed(boolean bl) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean getPressed() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forceUpdate(boolean bl) {
        this.getCurrent().forceUpdate(bl);
    }

    @Override
    public void setValue(int n) {
        this.getCurrent().setValue(n);
    }

    @Override
    public int getValue() {
        return this.choiceModel.getValue();
    }

    @Override
    public void endTransaction() {
        super.endTransaction();
        this.choiceModel.fireModelUpdateEvent(16);
    }

    @Override
    public void itemSelected(int n, int n2) {
        this.getCurrent().itemSelected(n, n2);
    }

    @Override
    public void itemFocused(int n, int n2) {
        this.getCurrent().itemFocused(n, n2);
    }

    @Override
    public void keyPressed(int n, int n2) {
        this.choiceModel.keyPressed(n, n2);
    }

    @Override
    public void keyReleased(int n, int n2) {
        this.choiceModel.keyReleased(n, n2);
    }

    @Override
    public void keyTyped(int n, int n2) {
        this.choiceModel.keyTyped(n, n2);
    }

    @Override
    public void keyLongTyped(int n, int n2) {
    }

    private ChoiceModel getCurrent() {
        return (ChoiceModel)super.getActiveModel();
    }

    public void joyN(int n) {
    }

    public void joyNW(int n) {
    }

    public void joyW(int n) {
    }

    public void joySW(int n) {
    }

    public void joyS(int n) {
    }

    public void joySE(int n) {
    }

    public void joyE(int n) {
    }

    public void joyNE(int n) {
    }

    public void joyIdle(int n) {
    }
}

