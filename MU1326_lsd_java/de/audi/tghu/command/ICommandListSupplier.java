/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.command;

import de.audi.tghu.command.CommandList;

public interface ICommandListSupplier {
    default public boolean isApplicationOperable() {
    }

    default public boolean isDSIsAvailable(CommandList commandList) {
    }

    default public String getApplicationName(CommandList commandList) {
    }

    default public void showDebugPopup(CommandList commandList, String string, String string2) {
    }

    default public void handleException(Exception exception) {
    }
}

