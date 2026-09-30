/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.details.GuiModelAccessDetailsEvo;
import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSForm;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.sds.LIStripLocationCommand;
import de.audi.tghu.navi.app.guidance.Vehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class AddressInputSDSFormNAR
extends AddressInputSDSForm {
    public AddressInputSDSFormNAR(IAddressInputForm iAddressInputForm, LogChannel logChannel, ICommandListFactory iCommandListFactory, SpellerStack spellerStack, CityHistory cityHistory, NavigationEnv navigationEnv, IPreviewMap iPreviewMap, GuiModelAccessDetailsEvo guiModelAccessDetailsEvo, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(iAddressInputForm, logChannel, iCommandListFactory, spellerStack, cityHistory, navigationEnv, iPreviewMap, guiModelAccessDetailsEvo, iAddressInputFormModelAccessHelper);
    }

    protected void startDestinationInput(int n, NaviServiceListener naviServiceListener, boolean bl) {
        this.logChannel.log(10000000, "AddressInputSDSFormNAR#startDestinationInput( %1 )", (long)n);
        NavLocation navLocation = this.getInitialLocation(n);
        if (navLocation == null) {
            navLocation = new NavLocation();
        }
        this.logChannel.log(10000000, "AddressInputSDSFormNAR#startDestinationInput() - initLocation = %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.inputModeManager.setInputMode(0, this.env);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIStripLocationCommand(navLocation, this.getDSIDestType(n)));
        commandList.add(new NavCommand(){

            public void execute() {
                NavLocation navLocation = (NavLocation)this.getCommandList().get("STRIPPED_LOCATION");
                AddressInputSDSFormNAR.this.logChannel.log(10000000, "AddressInputSDSFormNAR#startDestinationInput() - strippedLocation = %1", (Object)LocationFormatter.formatLocationShort(navLocation));
                this.getCommandList().commandFinishedWithPostSequence(AddressInputSDSFormNAR.this.addressInputService.getStartAddressInputCommandList(navLocation, 30016));
            }
        });
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseStartDestinationInput((byte)0);
            }
        });
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseStartDestinationInput((byte)1);
            }
        });
        commandList.execute("AddressInputSDSFormNAR#startDestinationInput()");
    }

    protected int getDSIDestType(int n) {
        switch (n) {
            case 0: {
                return 16;
            }
            case 7: {
                return 16;
            }
        }
        return super.getDSIDestType(n);
    }

    protected boolean speechCountryNeedsSync() {
        NavLocation navLocation;
        NavLocation navLocation2 = this.addressInputService.getBackupLocation();
        return !Util.checkIfCountryAbbreviationIsEqual(navLocation2, navLocation = this.env.getContainer().getLiCurrentLD());
    }

    protected NavLocation getSynchronisationLocation() {
        NavLocation navLocation = this.addressInputService.getBackupLocation();
        return navLocation == null || Util.isEmpty(navLocation.countryAbbreviation) ? Vehicle.getInstance().getVehicleLocationDescription() : navLocation;
    }
}

