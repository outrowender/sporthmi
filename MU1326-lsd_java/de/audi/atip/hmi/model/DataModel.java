/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.modelaccess.DataModelApp;
import de.audi.atip.hmi.modelaccess.DataModelGUI;

public class DataModel
extends AbstractModel
implements DataModelApp,
DataModelGUI {
    private Object data;

    public DataModel(int n) {
        super(n, 0);
    }

    public DataModel(int n, int n2) {
        super(n, n2);
    }

    @Override
    public int getModelType() {
        return 11;
    }

    @Override
    protected void copy(AbstractModel abstractModel) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void set(Object object) {
        this.data = object;
        this.fireModelUpdateEvent(1);
    }

    @Override
    public Object get() {
        return this.data;
    }

    @Override
    public boolean isEmpty() {
        return this.data == null;
    }

    @Override
    public void resetListener() {
    }
}

