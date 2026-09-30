/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.TerminalModeUtils;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;

public class RequestAudioFocus
extends AbstractStateHandlerCommand {
    private static final String LOGCLASS = "RequestAudioFocus";

    public RequestAudioFocus(IContext iContext, IStateHandler iStateHandler) {
        super(iContext.getLogger().main(), LOGCLASS, iContext, iStateHandler);
    }

    public void execute() {
        this.logger.log(1000000, "[%1.execute]", (Object)LOGCLASS);
        this.context.getChoiceModel(4451).setValue(TerminalModeUtils.mapActiveSmartphoneTypeToEntertainmentAudioModelType(this.context.getSmartphoneDSIManager().getSmartphoneType()));
        if (this.context.getAudioManager().hasAudioFocus()) {
            this.logger.log(1000000, "[%1.execute] TM has audio focus already", (Object)LOGCLASS);
            this.stateHandler.setOwnerForResource(Resource.AUDIO_MEDIA, ResourceOwner.DEVICE);
            this.getCommandList().commandFinished();
        } else {
            this.context.getAudioManager().requestAudioFocus();
        }
    }

    public boolean updateAudioFocus(boolean bl) {
        this.logger.log(1000000, "[%1.updateAudioFocus]", (Object)LOGCLASS);
        this.stateHandler.setOwnerForResource(Resource.AUDIO_MEDIA, bl ? ResourceOwner.DEVICE : ResourceOwner.MAINUNIT);
        this.getCommandList().commandFinished();
        return true;
    }
}

