/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import java.util.Map;

public interface ISDSCommandListener {
    public int[] getCommandIDs();

    public Object performCommand(int var1, Map var2);
}

