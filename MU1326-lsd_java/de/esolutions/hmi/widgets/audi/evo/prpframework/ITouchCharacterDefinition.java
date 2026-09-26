/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.ICharacterRegister;

public interface ITouchCharacterDefinition {
    default public ICharacterRegister getHWRSymbols(int n, int n2, int n3) {
    }

    default public ICharacterRegister getBlackList(int n, boolean bl) {
    }
}

