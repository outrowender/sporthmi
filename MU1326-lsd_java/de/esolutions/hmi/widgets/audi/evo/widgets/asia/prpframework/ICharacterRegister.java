/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.ICharacterRegister$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.ICharacterRegister$2;

public interface ICharacterRegister {
    public static final ICharacterRegister BLACKLIST_ALLOWING_EVERYTHING = new ICharacterRegister$1();
    public static final ICharacterRegister WHITELIST_ALLOWING_EVERYTHING = new ICharacterRegister$2();

    default public int getSize() {
    }

    default public String getName() {
    }

    default public boolean contains(char c2) {
    }

    default public boolean containsIgnoreCase(char c2) {
    }
}

