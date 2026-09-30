/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToAddressbookSequence;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToPOIOnlineSearchSequence;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToRemoteHmiFromCurrentLDSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputListener;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.util.Util;

public abstract class AbstractAddressInputListener
implements IAddressInputListener {
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected final IPreviewMap previewMap;
    protected final ICommandListFactory commandListFactory;
    protected final IAddressInputManager inputManager;
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());

    public AbstractAddressInputListener(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.previewMap = iPreviewMap;
        this.commandListFactory = iCommandListFactory;
        this.inputManager = iAddressInputManager;
    }

    protected abstract void initListeners();

    protected void setSpellerStatusWaiting(int n) {
        this.logChannel.log(10000000, "%1#setSpellerStatusWaiting for model=%2", (Object)this.CLASS_NAME, (long)n);
        Util.setModelStatus(this.env.getMatchSpellerModel(n), 0);
    }

    protected void startReturnNavLocationToPoiOnline() {
        this.logChannel.log(10000000, "%1#startReturnNavLocationToPoiOnline", (Object)this.CLASS_NAME);
        ReturnNavLocationToPOIOnlineSearchSequence returnNavLocationToPOIOnlineSearchSequence = new ReturnNavLocationToPOIOnlineSearchSequence(this.commandListFactory);
        returnNavLocationToPOIOnlineSearchSequence.start();
    }

    protected void startReturnNavLocationToRemoteHmi() {
        this.logChannel.log(10000000, "%1#startReturnNavLocationToRemoteHmi", (Object)this.CLASS_NAME);
        ReturnNavLocationToRemoteHmiFromCurrentLDSequence returnNavLocationToRemoteHmiFromCurrentLDSequence = new ReturnNavLocationToRemoteHmiFromCurrentLDSequence(this.commandListFactory);
        returnNavLocationToRemoteHmiFromCurrentLDSequence.start();
    }

    protected void startReturnNavLocationToAddressHandlerSequence(final HomeAddressHandler homeAddressHandler) {
        this.logChannel.log(10000000, "%1#startReturnNavLocationToHomeAddressHandlerSequence", (Object)this.CLASS_NAME);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(){

            public void execute() {
                homeAddressHandler.onCreateEditHomeAddress(this.dsiResponseContainer.getLiCurrentLD());
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute(this.CLASS_NAME + "#startReturnNavLocationToHomeAddressHandlerSequence");
    }

    protected void startReturnNavLocationToAdressbookSequence() {
        this.logChannel.log(10000000, "%1#startReturnNavLocationToAdressbookSequence", (Object)this.CLASS_NAME);
        ReturnNavLocationToAddressbookSequence returnNavLocationToAddressbookSequence = new ReturnNavLocationToAddressbookSequence(this.commandListFactory);
        returnNavLocationToAddressbookSequence.startWithLiCurrentLd();
    }

    protected void clearSpellerModel(int n) {
        this.logChannel.log(10000000, "%1#clearSpellerModel for id=%2", (Object)this.CLASS_NAME, (long)n);
        this.env.getSpellerModel(n).clear();
    }
}

