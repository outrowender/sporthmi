/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sds;

import de.audi.app.media.sds.ISDSCommandListener;
import java.util.Map;

public interface ISDSCommandDistpacher {
    default public void addCommandListener(int n, ISDSCommandListener iSDSCommandListener) {
    }

    default public void removeCommandListener(int n, ISDSCommandListener iSDSCommandListener) {
    }

    default public Object notifyCommand(int n, int n2, Map map) {
    }
}

