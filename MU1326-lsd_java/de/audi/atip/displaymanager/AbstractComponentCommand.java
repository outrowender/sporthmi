/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.displaymanager;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

public abstract class AbstractComponentCommand
extends Command {
    public AbstractComponentCommand(LogChannel logChannel, String string) {
        super(logChannel, string);
    }

    public void startComponentResult(int n, int n2, int n3, int n4) {
    }

    public void stopComponentResult(int n, int n2, int n3, int n4) {
    }

    public void setCroppingResult(int n) {
    }

    public void error() {
    }
}

