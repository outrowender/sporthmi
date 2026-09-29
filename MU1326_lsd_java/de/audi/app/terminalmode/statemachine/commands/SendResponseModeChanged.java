/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.dsi.IAppState;
import de.audi.app.terminalmode.dsi.IResource;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractDSICommand;

public class SendResponseModeChanged
extends AbstractDSICommand {
    private static final String LOGCLASS;
    private final IAppState[] appState;
    private final IResource[] resources;
    private final long messageId;
    private final IStateHandler stateHandler;
    private volatile boolean ignoreUpdate = false;

    public SendResponseModeChanged(IContext iContext, IDSISmartphoneManager iDSISmartphoneManager, IAppState[] iAppStateArray, IResource[] iResourceArray, long l, IStateHandler iStateHandler) {
        super(iContext.getLogger().main(), new StringBuffer().append("SendResponseModeChanged(msgId=").append(l).append(")").toString(), iContext, iDSISmartphoneManager);
        this.stateHandler = iStateHandler;
        this.appState = iAppStateArray;
        this.resources = iResourceArray;
        this.messageId = l;
    }

    @Override
    public void execute() {
        if (this.ignoreUpdate) {
            this.logger.log(1078071040, "[%1.execute] Ignore update mode.", (Object)"SendResponseModeChanged");
            this.getCommandList().commandFinished();
            return;
        }
        TMState tMState = this.stateHandler.getCurrentState();
        tMState.updateCurrentAppState(this.appState);
        tMState.updateCurrentResourceState(this.resources);
        if (tMState.isAccessRestricted(Resource.SCREEN)) {
            tMState.setOwnerForResource(Resource.SCREEN, ResourceOwner.MAINUNIT);
        }
        if (tMState.isAccessRestricted(Resource.AUDIO_MEDIA)) {
            tMState.setOwnerForResource(Resource.AUDIO_MEDIA, ResourceOwner.MAINUNIT);
            tMState.setOwnerForResource(Resource.AUDIO_PHONE, ResourceOwner.MAINUNIT);
            tMState.setOwnerForResource(Resource.AUDIO_RINGTONE, ResourceOwner.MAINUNIT);
            tMState.setOwnerForResource(Resource.AUDIO_SPEECH, ResourceOwner.MAINUNIT);
        }
        if (tMState != null) {
            this.stateHandler.updateState(tMState);
        }
        this.dsiSmartphoneManager.responseUpdateMode(this.stateHandler.getCurrentState(), this.messageId);
        this.getCommandList().commandFinished();
    }

    public void ignoreUpdateWithMsgId(long l) {
        this.ignoreUpdate = l == this.messageId;
        this.logger.log(1078071040, "[%1.ignoreUpdateWithMsgId] %2", (Object)"SendResponseModeChanged", (Object)String.valueOf(this.ignoreUpdate));
    }
}

