/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.memory;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.ifc.ISimpleTuner;
import de.esolutions.fw.util.commons.Buffer;

public class EmptyMemoryRow
extends AbstractMemoryRow {
    public EmptyMemoryRow(int n) {
        super(n, 8);
        this.setText(0, "");
        this.setText(1, "");
        this.setInteger(2, this.getBand());
        this.setInteger(3, 0);
        this.setInteger(4, 1);
        this.setText(5, "");
        this.setInteger(6, 0);
        this.setText(7, "");
        this.setText(8, "");
        this.setInteger(9, 0);
        this.setHMIResourceLocator(10, ISimpleTuner.EMPTY_RL);
    }

    protected EmptyMemoryRow(EmptyMemoryRow emptyMemoryRow) {
        super(emptyMemoryRow);
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("{EMPTY}");
        buffer.append(" comp:").append(this.getBand());
        buffer.append(' ').append(super.toString());
        return buffer.toString();
    }

    @Override
    public TunerObjectContainer getTOContainer() {
        return null;
    }

    public void setUserAction(boolean bl) {
        if (bl) {
            this.setInteger(4, 7);
        } else {
            this.setInteger(4, 1);
        }
    }

    @Override
    public EvoListRow copy() {
        return new EmptyMemoryRow(this);
    }
}

