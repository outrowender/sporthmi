/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import java.util.HashMap;

final class IGridCell$4
extends HashMap {
    private static final long serialVersionUID;

    IGridCell$4() {
        this.put("normal", new Integer(0));
        this.put("highlighted", new Integer(1));
        this.put("hidden", new Integer(2));
        this.put("none", new Integer(3));
    }
}

