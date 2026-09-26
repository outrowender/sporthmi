/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import java.util.Map;

public interface ISDSCommandListener {
    default public int[] getCommandIDs() {
    }

    default public Object performCommand(int n, Map map) {
    }
}

