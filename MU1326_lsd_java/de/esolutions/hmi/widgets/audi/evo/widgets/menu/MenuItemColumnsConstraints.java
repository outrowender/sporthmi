/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;

public class MenuItemColumnsConstraints
extends AxisConstraints {
    public int rightOptionsIconSpace = 0;

    public MenuItemColumnsConstraints(int n) {
        super(n);
    }

    public int getGap(int n) {
        int n2 = super.getGap(n);
        if (n == this.length) {
            n2 += this.rightOptionsIconSpace;
        }
        return n2;
    }

    protected String toStringGap(int n) {
        String string = super.toStringGap(n);
        if (n == this.length && this.rightOptionsIconSpace != 0) {
            Buffer buffer = new Buffer(string);
            if (buffer.length() > 0) {
                buffer.append(",");
            }
            buffer.append("+").append(this.rightOptionsIconSpace);
            return buffer.toString();
        }
        return string;
    }
}

