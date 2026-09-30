/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.nospeller;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.IAddressInputModelAccess;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.commands.SetHistoryContextWithCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.nospeller.AddressInputMainScreenSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public class AddressInputMainScreenSequenceNAR
extends AddressInputMainScreenSequence {
    public AddressInputMainScreenSequenceNAR(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager, IAddressInputModelAccess iAddressInputModelAccess) {
        super(iCommandListFactory, navigationEnv, iStartGuidanceToDestinationSequence, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager, iAddressInputModelAccess);
    }

    public CommandList getStartCommandList(NavLocation navLocation, boolean bl) {
        this.setModelAccess(bl);
        CommandList commandList = this.commandListFactory.createCommandList();
        this.logChannel.log(10000000, "%2#start() - NavLocation is = %1", (Object)navLocation, (Object)this.CLASS_NAME);
        this.logChannel.log(10000000, "%2#start() - NavLocation is = %1", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)this.CLASS_NAME);
        if (navLocation != null && navLocation.country != null) {
            commandList.add(new LISetCurrentLDCommand(navLocation));
        } else {
            final NavLocation navLocation2 = this.inputManager.getInitialLocation();
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "%2#start() - initial Location is = %1", (Object)navLocation2, (Object)this.CLASS_NAME);
            }
            commandList.add(new NavCommand(){

                public void execute() {
                    this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand(navLocation2));
                }
            });
        }
        commandList.add(new SetHistoryContextWithCurrentLDCommand());
        commandList.add(new NavCommand(){

            public void execute() {
                AddressInputMainScreenSequenceNAR.this.inputManager.setBackupLocation(this.dsiResponseContainer.getLiCurrentLD());
                AddressInputMainScreenSequenceNAR.this.modelAccessToUse.onStart(this.dsiResponseContainer.getLiCurrentLD());
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccessToUse));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, 1, null, null));
        return commandList;
    }
}

