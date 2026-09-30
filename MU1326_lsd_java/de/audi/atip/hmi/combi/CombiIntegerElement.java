/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.combi;

import de.audi.atip.hmi.combi.AbstractCombiElement;

public class CombiIntegerElement
extends AbstractCombiElement {
    public int value = -1;

    public final void setValue(int n) {
        if (this.value != n) {
            this.value = n;
            this.dirty = true;
        }
    }

    public final void copyTo(CombiIntegerElement combiIntegerElement) {
        super.copyTo(combiIntegerElement);
        combiIntegerElement.value = this.value;
    }

    public void reset() {
        this.setValue(-1);
        this.setMergingAllowed(true);
    }

    public String toString() {
        return "value: " + this.value;
    }
}

