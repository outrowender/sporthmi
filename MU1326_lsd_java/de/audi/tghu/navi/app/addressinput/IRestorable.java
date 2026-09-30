/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.tghu.command.CommandList;

public interface IRestorable {
    public void restore();

    public boolean hasActiveSubSequence();

    public CommandList createRestoreCommandList();
}

