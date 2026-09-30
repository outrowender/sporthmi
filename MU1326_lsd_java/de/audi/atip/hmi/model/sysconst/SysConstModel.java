/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.sysconst;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.modelaccess.sysconst.SysConstModelApp;
import de.esolutions.fw.util.commons.Buffer;

public class SysConstModel
extends AbstractModel
implements SysConstModelApp {
    private volatile int value;

    public SysConstModel(int n) {
        this(n, 0);
    }

    public SysConstModel(int n, int n2) {
        super(n, n2);
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int n) {
        this.value = n;
    }

    public boolean isEmpty() {
        return false;
    }

    public int getModelType() {
        return 24;
    }

    public void resetListener() {
    }

    public String dumpContent() {
        Buffer buffer = new Buffer(100);
        buffer.append(super.dumpContent());
        buffer.append("\nvalue: ");
        buffer.append(this.value);
        return buffer.toString();
    }
}

