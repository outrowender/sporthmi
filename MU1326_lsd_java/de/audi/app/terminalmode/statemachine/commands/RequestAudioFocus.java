/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.TerminalModeUtils
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.TerminalModeUtils;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;

public class RequestAudioFocus
extends AbstractStateHandlerCommand {
    private static final String LOGCLASS;

    public RequestAudioFocus(IContext iContext, IStateHandler iStateHandler) {
        super(iContext.getLogger().main(), "RequestAudioFocus", iContext, iStateHandler);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"RequestAudioFocus");
        this.context.getChoiceModel(4451).setValue(TerminalModeUtils.mapActiveSmartphoneTypeToEntertainmentAudioModelType((SmartphoneManager$SmartphoneType)this.context.getSmartphoneDSIManager().getSmartphoneType()));
        if (this.context.getAudioManager().hasAudioFocus()) {
            this.logger.log(1078071040, "[%1.execute] TM has audio focus already", (Object)"RequestAudioFocus");
            this.stateHandler.setOwnerForResource(Resource.AUDIO_MEDIA, ResourceOwner.DEVICE);
            this.getCommandList().commandFinished();
        } else {
            this.context.getAudioManager().requestAudioFocus();
        }
    }

    @Override
    public boolean updateAudioFocus(boolean bl) {
        this.logger.log(1078071040, "[%1.updateAudioFocus]", (Object)"RequestAudioFocus");
        this.stateHandler.setOwnerForResource(Resource.AUDIO_MEDIA, bl ? ResourceOwner.DEVICE : ResourceOwner.MAINUNIT);
        this.getCommandList().commandFinished();
        return true;
    }
}

