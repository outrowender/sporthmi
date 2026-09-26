/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.device.DeviceVariantsHandling;
import de.audi.app.terminalmode.device.DeviceVariantsHandling$1;
import de.audi.app.terminalmode.device.DeviceVariantsHandling$DefaultDeviceVariantsHandling$1;
import de.audi.app.terminalmode.device.IDeviceVariantsHandling;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.ReleaseAudioConnection;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;

class DeviceVariantsHandling$DefaultDeviceVariantsHandling
implements IDeviceVariantsHandling {
    private final /* synthetic */ DeviceVariantsHandling this$0;

    private DeviceVariantsHandling$DefaultDeviceVariantsHandling(DeviceVariantsHandling deviceVariantsHandling) {
        this.this$0 = deviceVariantsHandling;
    }

    @Override
    public CommandList cleanupAfterDeviceDisconnected(IContext iContext, IStateHandler iStateHandler, LogChannel logChannel, String string) {
        TMState tMState = iStateHandler.getCurrentState();
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
        CommandList commandList = iStateHandler.changeState(tMState, IRequestor.DEVICE_WHILE_DISCONNECTING, -1L);
        commandList.add(new ReleaseAudioConnection(TMAudioConnection.ANNOUNCEMENT, iContext));
        commandList.add(new ReleaseAudioConnection(TMAudioConnection.LOWERING, iContext));
        commandList.add(new ReleaseAudioConnection(TMAudioConnection.SPEECH_GUIDANCE, iContext));
        iContext.getChoiceModel(4552).setValue(0);
        tMState.setOwnerForResource(Resource.SCREEN, ResourceOwner.MAINUNIT);
        commandList.add(new DeviceVariantsHandling$DefaultDeviceVariantsHandling$1(this, logChannel, string, iContext, iStateHandler, tMState));
        return commandList;
    }

    @Override
    public void setDeviceVariantsHandler(IDeviceVariantsHandling iDeviceVariantsHandling) {
    }

    /* synthetic */ DeviceVariantsHandling$DefaultDeviceVariantsHandling(DeviceVariantsHandling deviceVariantsHandling, DeviceVariantsHandling$1 deviceVariantsHandling$1) {
        this(deviceVariantsHandling);
    }
}

