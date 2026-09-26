/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.swdiag;

import java.util.Collection;

public interface IDiagnosisCommandCollection {
    public static final String ERROR_FUNCTION_NOT_CODED;
    public static final String ERROR_UNKNOWN_COMMAND;
    public static final String ERROR_NONE;

    default public Collection getDiagnosisCommands() {
    }
}

