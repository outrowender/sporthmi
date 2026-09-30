/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelGUI;
import de.esolutions.fw.util.commons.Buffer;

public class LabelModel
extends AbstractModel
implements LabelModelGUI,
LabelModelApp {
    private String text;

    public LabelModel(int n) {
        super(n, 0);
    }

    public String dumpContent() {
        Buffer buffer = new Buffer(100);
        buffer.append(super.dumpContent());
        buffer.append("\ntext: ");
        buffer.append('\"');
        buffer.append(this.text);
        buffer.append('\"');
        return buffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isEmpty() {
        Object object = this.mutex;
        synchronized (object) {
            return this.text == null || this.text.length() == 0;
        }
    }

    public int getModelType() {
        return 3;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void copy(AbstractModel abstractModel) {
        try {
            Object object = this.mutex;
            synchronized (object) {
                LabelModel labelModel = (LabelModel)abstractModel;
                this.text = labelModel.text;
                super.copy(labelModel);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "(%2) LabelModel.copy( %1 ) failed! ", (Object)abstractModel, (long)this.id);
            this.lc.log(10000, "ERROR: ", (Throwable)exception);
        }
    }

    public String getText() {
        return this.text;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getLength() {
        Object object = this.mutex;
        synchronized (object) {
            return this.text != null ? this.text.length() : 0;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void setText(String string) {
        Object object = this.mutex;
        synchronized (object) {
            this.text = string;
            this.stateChanged();
        }
        this.fireModelUpdateEvent(1);
    }

    public void resetListener() {
    }
}

