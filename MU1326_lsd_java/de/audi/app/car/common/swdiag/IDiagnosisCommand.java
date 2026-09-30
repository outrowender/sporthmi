/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.swdiag;

import de.audi.app.car.common.swdiag.InvalidCommandParameterException;

public interface IDiagnosisCommand {
    public String getCommandString();

    public void parseParameters(String var1) throws InvalidCommandParameterException;

    public String run();
}

