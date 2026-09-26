/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import java.util.HashMap;

final class IGridCell$9
extends HashMap {
    private static final long serialVersionUID;

    IGridCell$9() {
        this.put("manual", new Integer(0));
        this.put("auto", new Integer(1));
        this.put("shrink", new Integer(0));
        this.put("grow", new Integer(1));
    }
}

