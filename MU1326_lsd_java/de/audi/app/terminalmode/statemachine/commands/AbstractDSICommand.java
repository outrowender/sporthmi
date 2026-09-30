/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.Preconditions;

public abstract class AbstractDSICommand
extends AbstractCommand {
    protected final IDSISmartphoneManager dsiSmartphoneManager;

    public AbstractDSICommand(LogChannel logChannel, String string, IContext iContext, IDSISmartphoneManager iDSISmartphoneManager) {
        super(logChannel, string, iContext);
        this.dsiSmartphoneManager = Preconditions.checkNotNull(iDSISmartphoneManager);
    }
}

