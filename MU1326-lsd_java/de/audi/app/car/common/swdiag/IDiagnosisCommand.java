/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.swdiag;

public interface IDiagnosisCommand {
    default public String getCommandString() {
    }

    default public void parseParameters(String string) {
    }

    default public String run() {
    }
}

