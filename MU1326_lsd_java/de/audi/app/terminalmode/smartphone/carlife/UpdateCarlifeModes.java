/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.TMRequestModeChangeCallback;
import de.audi.app.terminalmode.smartphone.carlife.ApplicationUpdate;
import de.audi.app.terminalmode.smartphone.carlife.ResourceUpdate;
import de.audi.app.terminalmode.smartphone.carlife.SendUpdateCarlifeResponse;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;
import de.audi.atip.utils.generics.GList;
import de.audi.tghu.command.CommandList;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class UpdateCarlifeModes
extends AbstractStateHandlerCommand {
    private static final String LOGCLASS = "UpdateCarlifeModes";
    private final GList<ResourceUpdate> resourceUpdates;
    private final GList<ApplicationUpdate> applicationUpdates;
    private final TMRequestModeChangeCallback tmRequestModeChangeCallback;

    public UpdateCarlifeModes(IContext iContext, GList<ResourceUpdate> gList, GList<ApplicationUpdate> gList2, IStateHandler iStateHandler, TMRequestModeChangeCallback tMRequestModeChangeCallback) {
        super(iContext.getLogger().main(), LOGCLASS, iContext, iStateHandler);
        this.resourceUpdates = gList;
        this.applicationUpdates = gList2;
        this.tmRequestModeChangeCallback = tMRequestModeChangeCallback;
    }

    @Override
    public void execute() {
        Object object;
        this.logger.log(1000000, "[%1.execute]", (Object)LOGCLASS);
        TMState tMState = this.stateHandler.getCurrentState();
        Object object2 = this.resourceUpdates.iterator();
        while (object2.hasNext()) {
            object = object2.next();
            tMState.setOwnerForResource(((ResourceUpdate)object).getResource(), ((ResourceUpdate)object).getOwner());
        }
        object2 = this.applicationUpdates.iterator();
        while (object2.hasNext()) {
            object = (ApplicationUpdate)object2.next();
            tMState.setOwnerForApplication(((ApplicationUpdate)object).getApplication(), ((ApplicationUpdate)object).getOwner());
        }
        this.logger.log(1000000, "[%1.execute] new state=%2", (Object)LOGCLASS, (Object)tMState.toString());
        object2 = this.stateHandler.changeState(tMState, IRequestor.DEVICE, -1L);
        ((CommandList)object2).add(new SendUpdateCarlifeResponse(this.context, this.stateHandler, tMState, this.tmRequestModeChangeCallback));
        this.getCommandList().commandFinishedWithPostSequence((CommandList)object2);
    }
}

