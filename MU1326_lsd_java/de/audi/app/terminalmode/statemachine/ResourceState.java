/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.util.Enum;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class ResourceState
extends Enum<ResourceState> {
    public static final ResourceState NORMAL = new ResourceState(0, "NORMAL");
    public static final ResourceState RESTICTED = new ResourceState(1, "RESTICTED");
    public static final ResourceState PAUSED = new ResourceState(2, "PAUSED");
    public static final ResourceState PAUSED_BY_MUTE = new ResourceState(3, "PAUSED_BY_MUTE");

    protected ResourceState(int n, String string) {
        super(n, string);
    }
}

