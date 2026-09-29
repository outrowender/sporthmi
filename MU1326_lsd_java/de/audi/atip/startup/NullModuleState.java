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
    @Override
    public ComponentState getComponentState() {
        return null;
    }

    @Override
    public void enqueueStartBundles(List list, boolean bl) {
    }

    @Override
    public void enqueueStopBundles(List list, boolean bl) {
    }

    @Override
    public int getModuleId() {
        return -1;
    }

    @Override
    public void dump(PrintStream printStream) {
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void appendBundles(List list) {
    }
}

