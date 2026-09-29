/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.tghu.command.CommandList;

public interface IRestorable {
    default public void restore() {
    }

    default public boolean hasActiveSubSequence() {
    }

    default public CommandList createRestoreCommandList() {
    }
}

