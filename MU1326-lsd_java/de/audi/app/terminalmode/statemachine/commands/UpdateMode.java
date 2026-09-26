/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.TerminalModeUtils
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.TerminalModeUtils;
import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IResource;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractDSICommand;
import de.audi.tghu.command.CommandList;

public class UpdateMode
extends AbstractDSICommand {
    private static final String LOGCLASS;
    private final IAppState[] appStates;
    private final IResource[] resources;
    private final long messageId;
    private final IStateHandler stateHandler;
    private volatile boolean ignoreUpdate = false;

    public UpdateMode(IContext iContext, IDSISmartphoneManager iDSISmartphoneManager, IAppState[] iAppStateArray, IResource[] iResourceArray, long l, IStateHandler iStateHandler) {
        super(iContext.getLogger().main(), "UpdateMode", iContext, iDSISmartphoneManager);
        this.appStates = iAppStateArray;
        this.resources = iResourceArray;
        this.messageId = l;
        this.stateHandler = iStateHandler;
    }

    @Override
    public void execute() {
        if (this.ignoreUpdate) {
            this.logger.log(1078071040, "[%1.execute] Ignore update mode.", (Object)"UpdateMode");
            this.getCommandList().commandFinished();
            return;
        }
        this.logger.log(1078071040, "[%1.execute]", (Object)"UpdateMode");
        if (this.logger.isDebug()) {
            this.logger.log(-2137614336, "[%1.execute] %2 %3", (Object)"UpdateMode", (Object)TerminalModeUtils.logAppStates((IAppState[])this.appStates), (Object)TerminalModeUtils.logResources((IResource[])this.resources));
        }
        TMState tMState = this.stateHandler.getCurrentState();
        TMState tMState2 = this.stateHandler.getCurrentState();
        tMState2.updateCurrentAppState(this.appStates);
        tMState2.updateCurrentResourceState(this.resources);
        if (tMState.isAccessRestricted(Resource.SCREEN)) {
            tMState2.setOwnerForResource(Resource.SCREEN, ResourceOwner.MAINUNIT);
        }
        if (tMState.isAccessRestricted(Resource.AUDIO_MEDIA)) {
            tMState2.setOwnerForResource(Resource.AUDIO_MEDIA, ResourceOwner.MAINUNIT);
            tMState2.setOwnerForResource(Resource.AUDIO_PHONE, ResourceOwner.MAINUNIT);
            tMState2.setOwnerForResource(Resource.AUDIO_RINGTONE, ResourceOwner.MAINUNIT);
            tMState2.setOwnerForResource(Resource.AUDIO_SPEECH, ResourceOwner.MAINUNIT);
        }
        this.logger.log(1078071040, "[%1.execute] new state=%2", (Object)"UpdateMode", (Object)tMState2.toString());
        CommandList commandList = this.stateHandler.changeState(tMState2, IRequestor.DEVICE, this.messageId);
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }

    public void ignoreUpdateWithMsgId(long l) {
        this.ignoreUpdate = l == this.messageId;
        this.logger.log(1078071040, "[%1.ignoreUpdateWithMsgId] %2", (Object)"UpdateMode", (Object)String.valueOf(this.ignoreUpdate));
    }
}

