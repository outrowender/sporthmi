/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.property;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.property.PropertyModelApp;
import de.audi.atip.hmi.model.property.PropertyModelGui;
import de.esolutions.fw.util.commons.Buffer;

public class PropertyModel
extends AbstractModel
implements PropertyModelApp,
PropertyModelGui {
    private static final int[] EMPTY_ARRAY = new int[0];
    private volatile int category = -1;
    private volatile int[] properties = EMPTY_ARRAY;

    public PropertyModel(int n) {
        super(n);
    }

    @Override
    public int getCategory() {
        return this.category;
    }

    @Override
    public void setProperties(int n, int[] nArray) {
        this.category = n;
        this.properties = nArray != null ? nArray : EMPTY_ARRAY;
        this.fireModelUpdateEvent(1, n);
    }

    @Override
    public int[] getProperties() {
        return this.properties;
    }

    @Override
    public boolean isEmpty() {
        return this.properties.length == 0;
    }

    @Override
    public int getModelType() {
        return 30;
    }

    @Override
    public void resetListener() {
    }

    @Override
    public String dumpContent() {
        Buffer buffer = new Buffer(100);
        buffer.append(super.dumpContent());
        buffer.append("\ncategory: ");
        buffer.append(this.category);
        int[] nArray = this.properties;
        if (nArray == null || nArray.length == 0) {
            buffer.append("\nNo properties set!");
        } else {
            buffer.append("\nproperties:");
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                buffer.append("\n[").append(i2).append("] ").append(nArray[i2]);
            }
        }
        return buffer.toString();
    }
}

