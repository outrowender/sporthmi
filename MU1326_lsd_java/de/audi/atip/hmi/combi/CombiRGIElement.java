/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.combi;

import de.audi.atip.hmi.combi.AbstractCombiElement;
import de.esolutions.fw.util.commons.Buffer;

public class CombiRGIElement
extends AbstractCombiElement {
    public short[] rgiStream;

    public final void copyTo(CombiRGIElement combiRGIElement) {
        super.copyTo(combiRGIElement);
        if (this.rgiStream != null) {
            combiRGIElement.rgiStream = new short[this.rgiStream.length];
            System.arraycopy((Object)this.rgiStream, 0, (Object)combiRGIElement.rgiStream, 0, this.rgiStream.length);
        } else {
            combiRGIElement.rgiStream = null;
        }
    }

    @Override
    public void reset() {
        this.rgiStream = null;
        this.dirty = true;
        this.setMergingAllowed(true);
    }

    public String toString() {
        Buffer buffer = new Buffer("stream: [");
        if (this.rgiStream != null) {
            for (int i2 = 0; i2 < this.rgiStream.length; ++i2) {
                buffer.append(this.rgiStream[i2]).append(' ');
            }
        }
        buffer.append(']');
        return buffer.toString();
    }
}

