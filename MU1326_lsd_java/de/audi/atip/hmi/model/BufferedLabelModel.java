/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.BufferedAbstractModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelGUI;

public class BufferedLabelModel
extends BufferedAbstractModel
implements LabelModelGUI,
LabelModelApp {
    private LabelModel labelModel = (LabelModel)super.getMainModel();

    public BufferedLabelModel(int n) {
        super(new LabelModel(n), new LabelModel(n));
    }

    public void setText(String string) {
        this.getCurrent().setText(string);
    }

    public String getText() {
        return this.labelModel.getText();
    }

    public int getLength() {
        return this.labelModel.getLength();
    }

    public void endTransaction() {
        super.endTransaction();
        this.labelModel.fireModelUpdateEvent(1);
    }

    private LabelModel getCurrent() {
        return (LabelModel)super.getActiveModel();
    }
}

