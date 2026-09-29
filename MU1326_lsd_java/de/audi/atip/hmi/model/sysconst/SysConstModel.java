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

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public void setValue(int n) {
        this.value = n;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getModelType() {
        return 24;
    }

    @Override
    public void resetListener() {
    }

    @Override
    public String dumpContent() {
        Buffer buffer = new Buffer(100);
        buffer.append(super.dumpContent());
        buffer.append("\nvalue: ");
        buffer.append(this.value);
        return buffer.toString();
    }
}

