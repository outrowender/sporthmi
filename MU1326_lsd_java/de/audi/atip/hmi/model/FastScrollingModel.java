/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.FastScrollingListener;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.modelaccess.FastScrollingModelApp;
import de.audi.atip.hmi.modelaccess.FastScrollingModelGUI;

public class FastScrollingModel
extends RangeModel
implements FastScrollingModelApp,
FastScrollingModelGUI {
    public static final int FAST_SCROLLING_LIMIT = 20;

    public FastScrollingModel(int n) {
        super(n);
    }

    public FastScrollingModel(int n, int n2) {
        super(n, n2);
    }

    public int getModelType() {
        return 14;
    }

    public void setFastScrollingListener(FastScrollingListener fastScrollingListener) {
        this.setButtonListener(fastScrollingListener);
    }

    public void setValueHit(int n, int n2) {
        this.lc.log(10000000, "(%1) FastScrollingModel.setValueHit( %2 ) ", (long)this.id, (long)n);
        try {
            ((FastScrollingListener)this.buttonListener).valueHit(this.id, n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void setValue(int n) {
        super.updateData(n);
    }
}

