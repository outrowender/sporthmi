/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.ICharacterRegister;

public interface ITouchCharacterDefinition {
    public ICharacterRegister getHWRSymbols(int var1, int var2, int var3);

    public ICharacterRegister getBlackList(int var1, boolean var2);
}

