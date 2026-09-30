/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.tghu.command.CommandList;

public interface ICommandListSupplier {
    public boolean isApplicationOperable();

    public boolean isDSIsAvailable(CommandList var1);

    public String getApplicationName(CommandList var1);

    public void showDebugPopup(CommandList var1, String var2, String var3);

    public void handleException(Exception var1);
}

