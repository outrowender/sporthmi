/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import java.util.HashMap;

final class IGridCell$2
extends HashMap {
    private static final long serialVersionUID;

    IGridCell$2() {
        this.put("gigantic", new Integer(0));
        this.put("huge", new Integer(1));
        this.put("big", new Integer(2));
        this.put("medium", new Integer(3));
        this.put("small", new Integer(4));
        this.put("tiny", new Integer(5));
        this.put("veryTiny", new Integer(6));
        this.put("mediaTitleNormal", new Integer(7));
        this.put("mediaTitleBold", new Integer(8));
        this.put("mediaEntry", new Integer(9));
    }
}

