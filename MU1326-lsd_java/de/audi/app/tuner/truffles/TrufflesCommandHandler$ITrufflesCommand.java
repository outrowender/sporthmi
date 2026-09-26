/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

public interface TrufflesCommandHandler$ITrufflesCommand {
    public static final int PRIO_INVALIDATE;
    public static final int PRIO_QUERY;

    default public int getPriority() {
    }

    default public void execute() {
    }
}

