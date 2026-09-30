/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.swdiag;

import java.util.Collection;

public interface IDiagnosisCommandCollection {
    public static final String ERROR_FUNCTION_NOT_CODED = "component is null. Check coding under Keys -> SysApp -> getCarMenuFlags";
    public static final String ERROR_UNKNOWN_COMMAND = "unknown command ";
    public static final String ERROR_NONE = "";

    public Collection getDiagnosisCommands();
}

