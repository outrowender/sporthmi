/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.esolutions.fw.util.commons.Buffer;

public class RequestConstraintsChange
extends AbstractCommand {
    private static final String LOGCLASS;
    private final Resource resource;
    private final boolean restrictAccess;
    private final TMState tmState;

    public RequestConstraintsChange(IContext iContext, TMState tMState, Resource resource, boolean bl) {
        super(iContext.getLogger().main(), "RequestConstraintsChange", iContext);
        this.resource = resource;
        this.restrictAccess = bl;
        this.tmState = tMState;
        this.name = new Buffer().append("RequestConstraintsChange").append("(").append(bl ? "restrict " : "allow: ").append(resource.toString()).append(")").toString();
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"RequestConstraintsChange");
        this.context.getSmartphoneDSIManager().requestConstraintsChange(this.tmState, this.resource, this.restrictAccess);
        this.getCommandList().commandFinished();
    }
}

