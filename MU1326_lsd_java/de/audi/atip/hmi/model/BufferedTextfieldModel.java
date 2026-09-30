/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.BufferedAbstractModel;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.TextfieldModel;
import de.audi.atip.hmi.modelaccess.TextfieldModelApp;
import de.audi.atip.hmi.modelaccess.TextfieldModelGUI;

public class BufferedTextfieldModel
extends BufferedAbstractModel
implements TextfieldModelApp,
TextfieldModelGUI {
    private TextfieldModel textfieldModel = (TextfieldModel)super.getMainModel();
    private int textsChanged;

    public BufferedTextfieldModel(int n) {
        super(new TextfieldModel(n), new TextfieldModel(n));
    }

    public BufferedTextfieldModel(int n, int n2) {
        super(new TextfieldModel(n, n2), new TextfieldModel(n, n2));
    }

    public void setButtonListener(ButtonListener buttonListener) {
        this.textfieldModel.setButtonListener(buttonListener);
    }

    public void setPressed(boolean bl) {
        throw new UnsupportedOperationException();
    }

    public boolean getPressed() {
        throw new UnsupportedOperationException();
    }

    public void setText1(String string) {
        this.getCurrent().setText1(string);
        if (this.isTransactionRunning()) {
            this.textsChanged |= 1;
        }
    }

    public String getText1() {
        return this.textfieldModel.getText1();
    }

    public void setText2(String string) {
        this.getCurrent().setText2(string);
        if (this.isTransactionRunning()) {
            this.textsChanged |= 2;
        }
    }

    public String getText2() {
        return this.textfieldModel.getText2();
    }

    public void setTexts(String string, String string2) {
        this.getCurrent().setTexts(string, string2);
        if (this.isTransactionRunning()) {
            this.textsChanged = 3;
        }
    }

    public void beginTransaction() {
        this.textsChanged = 0;
        super.beginTransaction();
    }

    public void endTransaction() {
        super.endTransaction();
        this.textfieldModel.fireModelUpdateEvent(1, this.textsChanged);
    }

    public void keyPressed(int n, int n2) {
        this.textfieldModel.keyPressed(n, n2);
    }

    public void keyReleased(int n, int n2) {
        this.textfieldModel.keyReleased(n, n2);
    }

    public void keyTyped(int n, int n2) {
        this.textfieldModel.keyTyped(n, n2);
    }

    public void keyLongTyped(int n, int n2) {
    }

    public int getBitmapRessourceID() {
        return this.textfieldModel.getBitmapRessourceID();
    }

    public void setBitmapResourceID(int n) {
        this.textfieldModel.setBitmapResourceID(n);
    }

    private TextfieldModel getCurrent() {
        return (TextfieldModel)super.getActiveModel();
    }
}

