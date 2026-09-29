/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.commands;

import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractCommand;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;

public class PhoneCallCommand
extends AbstractCommand {
    public PhoneCallCommand(AbstractOperatorCall abstractOperatorCall, String string) {
        super(abstractOperatorCall, string);
    }

    @Override
    public void execute() {
    }

    @Override
    public long getTimeout() {
        return -1L;
    }
}

