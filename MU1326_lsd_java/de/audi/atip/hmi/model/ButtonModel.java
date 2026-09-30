/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelGUI;
import de.esolutions.fw.util.commons.Buffer;

public class ButtonModel
extends AbstractModel
implements ButtonModelGUI,
ButtonModelApp {
    private volatile boolean pressed;
    protected volatile ButtonListener buttonListener = DUMMY_LISTENER;

    public ButtonModel(int n) {
        super(n, 0);
    }

    public ButtonModel(int n, int n2) {
        super(n, n2);
    }

    public void resetListener() {
        this.buttonListener = DUMMY_LISTENER;
    }

    public String dumpContent() {
        Buffer buffer = new Buffer(200);
        buffer.append(super.dumpContent());
        buffer.append("\nPressed: ");
        buffer.append(this.pressed);
        buffer.append("\nButtonListener: ");
        buffer.append(this.buttonListener);
        return buffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void copy(AbstractModel abstractModel) {
        try {
            Object object = this.mutex;
            synchronized (object) {
                ButtonModel buttonModel = (ButtonModel)abstractModel;
                this.pressed = buttonModel.pressed;
                super.copy(buttonModel);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "(%2) ButtonModel.copy( %1 ) failed! ", (Object)abstractModel, (long)this.id);
            this.lc.log(10000, "ERROR: ", (Throwable)exception);
        }
    }

    public int getModelType() {
        return 1;
    }

    public boolean isEmpty() {
        return false;
    }

    public void setButtonListener(ButtonListener buttonListener) {
        this.buttonListener = buttonListener != null ? buttonListener : DUMMY_LISTENER;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setPressed(boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.pressed != bl) {
                this.pressed = bl;
                this.stateChanged();
            }
        }
        this.fireModelUpdateEvent(1);
    }

    public boolean getPressed() {
        return this.pressed;
    }

    public void keyPressed(int n, int n2) {
        try {
            this.buttonListener.keyPressed(this.id, n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void keyReleased(int n, int n2) {
        try {
            this.buttonListener.keyReleased(this.id, n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void keyTyped(int n, int n2) {
        try {
            this.buttonListener.keyTyped(this.id, n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void keyLongTyped(int n, int n2) {
        try {
            this.buttonListener.keyLongTyped(this.id, n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }
}

