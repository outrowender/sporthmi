/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.device.IDeviceVariantsHandling;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;
import de.audi.app.terminalmode.statemachine.commands.ReleaseAudioConnection;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;

public class PGen2DeviceVariantsHandler
implements IDeviceVariantsHandling,
ITerminalModeComponent {
    private final IContext context;
    static /* synthetic */ Class class$de$audi$app$terminalmode$device$IDeviceVariantsHandling;

    public PGen2DeviceVariantsHandler(IContext iContext) {
        this.context = iContext;
    }

    public void init() {
        IDeviceVariantsHandling iDeviceVariantsHandling = (IDeviceVariantsHandling)this.context.get(class$de$audi$app$terminalmode$device$IDeviceVariantsHandling == null ? (class$de$audi$app$terminalmode$device$IDeviceVariantsHandling = PGen2DeviceVariantsHandler.class$("de.audi.app.terminalmode.device.IDeviceVariantsHandling")) : class$de$audi$app$terminalmode$device$IDeviceVariantsHandling);
        if (null != iDeviceVariantsHandling) {
            iDeviceVariantsHandling.setDeviceVariantsHandler(this);
        }
    }

    public void deinit() {
    }

    public CommandList cleanupAfterDeviceDisconnected(IContext iContext, IStateHandler iStateHandler, LogChannel logChannel, String string) {
        final TMState tMState = iStateHandler.getCurrentState();
        tMState.setOwnerForResource(Resource.AUDIO_MEDIA, ResourceOwner.MAINUNIT);
        tMState.setOwnerForResource(Resource.AUDIO_PHONE, ResourceOwner.MAINUNIT);
        tMState.setOwnerForResource(Resource.AUDIO_SPEECH, ResourceOwner.MAINUNIT);
        tMState.setOwnerForResource(Resource.AUDIO_RINGTONE, ResourceOwner.MAINUNIT);
        tMState.setOwnerForResource(Resource.NOTIFICATION, ResourceOwner.DEVICE);
        tMState.setOwnerForResource(Resource.AUDIO_GUIDANCE, ResourceOwner.MAINUNIT);
        if (tMState.isAppOwnerDevice(Application.NAVI)) {
            tMState.setOwnerForApplication(Application.NAVI, ApplicationOwner.NOBODY);
        }
        if (tMState.isAppOwnerDevice(Application.PHONE)) {
            tMState.setOwnerForApplication(Application.PHONE, ApplicationOwner.NOBODY);
        }
        if (tMState.isAppOwnerDevice(Application.SPEECH)) {
            tMState.setOwnerForApplication(Application.SPEECH, ApplicationOwner.NOBODY);
        }
        tMState.setOwnerForResource(Resource.SCREEN, ResourceOwner.MAINUNIT);
        CommandList commandList = iStateHandler.changeState(tMState, IRequestor.DEVICE, -1L);
        commandList.add(new ReleaseAudioConnection(TMAudioConnection.ANNOUNCEMENT, iContext));
        commandList.add(new ReleaseAudioConnection(TMAudioConnection.LOWERING, iContext));
        commandList.add(new ReleaseAudioConnection(TMAudioConnection.SPEECH_GUIDANCE, iContext));
        iContext.getChoiceModel(4552).setValue(0);
        commandList.add(new AbstractStateHandlerCommand(logChannel, string, iContext, iStateHandler){

            public void execute() {
                this.stateHandler.updateState(tMState);
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    public void setDeviceVariantsHandler(IDeviceVariantsHandling iDeviceVariantsHandling) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

