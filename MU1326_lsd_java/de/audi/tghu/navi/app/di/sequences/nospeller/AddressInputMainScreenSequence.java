/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.nospeller;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputModelAccess;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.commands.SetHistoryContextWithCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.commands.StoreCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.command.LIGetLocationDescriptionTransformCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.nospeller.IAddressInputNoSpellerSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputMainScreenSequence
implements IAddressInputNoSpellerSequence {
    private boolean firstTimeEntered = false;
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    protected final NavigationEnv env;
    protected final IStartGuidanceToDestinationSequence routeGuidanceSequence;
    protected final SpellerStack spellerStack;
    protected final ICommandListFactory commandListFactory;
    protected final LogChannel logChannel;
    protected final IAddressInputManager inputManager;
    protected final IPreviewMap previewMap;
    protected final IMatchspellerModelAccess standardModelAccess;
    protected final IAddressInputModelAccess onlineModelAccess;
    protected IAddressInputModelAccess modelAccessToUse;

    public AddressInputMainScreenSequence(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager, IAddressInputModelAccess iAddressInputModelAccess) {
        this.commandListFactory = iCommandListFactory;
        this.env = navigationEnv;
        this.routeGuidanceSequence = iStartGuidanceToDestinationSequence;
        this.spellerStack = spellerStack;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.inputManager = iAddressInputManager;
        this.previewMap = iPreviewMap;
        this.standardModelAccess = iMatchspellerModelAccess;
        this.onlineModelAccess = iAddressInputModelAccess;
        this.modelAccessToUse = this.standardModelAccess;
    }

    public IAddressInputModelAccess getModelAccess() {
        return this.modelAccessToUse;
    }

    public CommandList getStartCommandList() {
        return this.getStartCommandList(null);
    }

    public CommandList getStartCommandList(NavLocation navLocation) {
        return this.getStartCommandList(navLocation, false);
    }

    public CommandList getStartCommandList(NavLocation navLocation, boolean bl) {
        this.setModelAccess(bl);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new StoreCurrentLDCommand());
        this.logChannel.log(10000000, "%2#getStartCommandList() - NavLocation is = %1", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)this.CLASS_NAME);
        if (navLocation != null) {
            commandList.add(new LISetCurrentLDCommand(navLocation));
        } else {
            NavLocation navLocation2 = this.inputManager.getInitialLocation();
            this.logChannel.log(10000000, "%2#getStartCommandList() - NavLocation is null or empty. Using initial Location is = %1", (Object)LocationFormatter.formatLocationShort(navLocation2), (Object)this.CLASS_NAME);
            if (Util.isEmpty(navLocation2.country) && Util.isEmpty(navLocation2.countryAbbreviation)) {
                commandList.add(new LIGetLocationDescriptionTransformCommand(navLocation2));
                commandList.add(new NavCommand("Enqueue liSetCurrentLd with transformed location"){

                    public void execute() {
                        this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand(this.dsiResponseContainer.getTransformedLocation()));
                    }
                });
            } else {
                commandList.add(new LISetCurrentLDCommand(navLocation2));
            }
        }
        if (!Util.isHURegionAsia()) {
            commandList.add(new SetHistoryContextWithCurrentLDCommand());
        }
        commandList.add(new NavCommand(){

            public void execute() {
                AddressInputMainScreenSequence.this.inputManager.setBackupLocation(this.dsiResponseContainer.getLiCurrentLD());
                AddressInputMainScreenSequence.this.modelAccessToUse.onStart(this.dsiResponseContainer.getLiCurrentLD());
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccessToUse));
        commandList.add(new NavCommand("Set flag that NDF was entered for the first time"){

            public void execute() {
                AddressInputMainScreenSequence.this.firstTimeEntered = true;
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    public CommandList getStartRouteGuidanceCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append(" - Start route guidance").toString()){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                AddressInputMainScreenSequence.this.routeGuidanceSequence.start(navLocation);
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    public CommandList getStartCountryCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        return commandList;
    }

    public CommandList getStartCountryCommandList(char c2) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("directWritingChar", new Character(c2));
        return commandList;
    }

    public CommandList getStartLocationNameCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        return commandList;
    }

    public CommandList getStartCityZipCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        return commandList;
    }

    public CommandList getStartCityZipCommandList(char c2) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("directWritingChar", new Character(c2));
        return commandList;
    }

    public CommandList getStartStreetCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        return commandList;
    }

    public CommandList getStartStreetCommandList(char c2) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("directWritingChar", new Character(c2));
        return commandList;
    }

    public CommandList getStartHouseNumberCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        return commandList;
    }

    public CommandList getStartHouseNumberCommandList(char c2) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("directWritingChar", new Character(c2));
        return commandList;
    }

    public CommandList getStartJunctionCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        return commandList;
    }

    public CommandList getStartJunctionCommandList(char c2) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("directWritingChar", new Character(c2));
        return commandList;
    }

    public CommandList getStartPrefectureCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        return commandList;
    }

    public CommandList getStartPrefectureCommandList(char c2) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("directWritingChar", new Character(c2));
        return commandList;
    }

    public CommandList getStartFacilityCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        return commandList;
    }

    public CommandList getStartPlacenameCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        return commandList;
    }

    public CommandList getStartPlacenameCommandList(char c2) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("directWritingChar", new Character(c2));
        return commandList;
    }

    protected void setModelAccess(boolean bl) {
        this.logChannel.log(10000000, "%1#setModelAccess - useOnlineModelAccess=%2", (Object)this.CLASS_NAME, (Object)bl);
        if (bl) {
            if (this.onlineModelAccess == null) {
                this.logChannel.log(10000, "%1#setModelAccess - onlineModelAccess is NULL", (Object)this.CLASS_NAME);
            } else {
                this.modelAccessToUse = this.onlineModelAccess;
            }
        } else {
            this.modelAccessToUse = this.standardModelAccess;
        }
    }

    public synchronized boolean isNdfEnteredForTheFirstTime() {
        if (this.firstTimeEntered) {
            this.firstTimeEntered = false;
            return true;
        }
        return false;
    }

    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
        return this.commandListFactory.createCommandList();
    }

    public CommandList getSelectElementByIdentifierCommandList(String string) {
        return this.commandListFactory.createCommandList();
    }
}

