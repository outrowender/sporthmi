/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.AbstractAddressInputManager;
import de.audi.tghu.navi.app.di.IAddressInputWorkFlowManager;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public abstract class AbstractAddressInputManagerEvo
extends AbstractAddressInputManager {
    public AbstractAddressInputManagerEvo(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IAddressInputWorkFlowManager iAddressInputWorkFlowManager, SpellerStack spellerStack, IPreviewMap iPreviewMap, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IVehicle iVehicle, LocationSerializer locationSerializer, IRouteManager iRouteManager, CityHistory cityHistory, NaviADBHandler naviADBHandler, INaviFavoriteHandler iNaviFavoriteHandler, AsyncNavLocationExtractor asyncNavLocationExtractor, ADBInterAppService aDBInterAppService, HomeAddressHandler homeAddressHandler, MapInterface mapInterface, AsyncNavLocationExtractor asyncNavLocationExtractor2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper, HomeAddressHandler homeAddressHandler2) {
        super(navigationEnv, iCommandListFactory, spellerStack, iAddressInputWorkFlowManager, iPreviewMap, iStartGuidanceToDestinationSequence, iVehicle, locationSerializer, iRouteManager, cityHistory, naviADBHandler, iNaviFavoriteHandler, asyncNavLocationExtractor, aDBInterAppService, homeAddressHandler, mapInterface, asyncNavLocationExtractor2, iAddressInputFormModelAccessHelper, homeAddressHandler2);
    }

    public void destAddressInputHKReturn(int n, int n2, Command command, Command command2) {
        this.logChannel.log(10000000, "%1#addressInputHKReturn called with removeHandler=%2", (Object)this.CLASS_NAME, (long)n2);
        SpellerStack.StackElement stackElement = null;
        switch (n2) {
            default: 
        }
        stackElement = this.spellerStack.pop();
        if (stackElement != null) {
            this.logChannel.log(10000000, "%1#addressInputHKReturn element popped from speller stack=%2", (Object)this.CLASS_NAME, (Object)stackElement);
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new LIRestoreStateCommand(stackElement));
            commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append("#destAddressInputHKReturn - Show or Hide Preview Map").toString()){

                public void execute() {
                    NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                    if (!Util.isEmpty(navLocation.town)) {
                        boolean bl = true;
                        if (!Util.isEmpty(navLocation.street)) {
                            bl = false;
                        }
                        this.getCommandList().commandFinishedWithPostCommand(new CmdNaviPreviewMapUpdate(AbstractAddressInputManagerEvo.this.previewMap, bl, 1, null, null));
                    } else {
                        AbstractAddressInputManagerEvo.this.previewMap.hidePreviewMap();
                        this.getCommandList().commandFinished();
                    }
                }
            });
            commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccessHelper));
            if (command != null) {
                commandList.add(command);
            }
            if (command2 != null) {
                commandList.setErrorCommand(command2);
            }
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#destAddressInputHKReturn").toString());
        } else {
            this.logChannel.log(100000, "%1#destAddressInputHKReturn - popped element from SpellerStack but element is null!", (Object)this.CLASS_NAME);
        }
    }
}

