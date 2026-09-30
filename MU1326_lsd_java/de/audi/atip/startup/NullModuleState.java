/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.ComponentState;
import de.audi.atip.startup.GUIDEModuleState;
import java.io.PrintStream;
import java.util.List;

public class NullModuleState
extends GUIDEModuleState {
    public ComponentState getComponentState() {
        return null;
    }

    public void enqueueStartBundles(List list, boolean bl) {
    }

    public void enqueueStopBundles(List list, boolean bl) {
    }

    public int getModuleId() {
        return -1;
    }

    public void dump(PrintStream printStream) {
    }

    public boolean isActive() {
        return true;
    }

    public void appendBundles(List list) {
    }
}

