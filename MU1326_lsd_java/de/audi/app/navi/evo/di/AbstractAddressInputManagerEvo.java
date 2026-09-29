/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di;

import de.audi.app.navi.evo.di.AbstractAddressInputManagerEvo$1;
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
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.di.AbstractAddressInputManager;
import de.audi.tghu.navi.app.di.IAddressInputWorkFlowManager;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.SpellerStack$StackElement;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;

public abstract class AbstractAddressInputManagerEvo
extends AbstractAddressInputManager {
    public AbstractAddressInputManagerEvo(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IAddressInputWorkFlowManager iAddressInputWorkFlowManager, SpellerStack spellerStack, IPreviewMap iPreviewMap, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IVehicle iVehicle, LocationSerializer locationSerializer, IRouteManager iRouteManager, CityHistory cityHistory, NaviADBHandler naviADBHandler, INaviFavoriteHandler iNaviFavoriteHandler, AsyncNavLocationExtractor asyncNavLocationExtractor, ADBInterAppService aDBInterAppService, HomeAddressHandler homeAddressHandler, MapInterface mapInterface, AsyncNavLocationExtractor asyncNavLocationExtractor2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper, HomeAddressHandler homeAddressHandler2) {
        super(navigationEnv, iCommandListFactory, spellerStack, iAddressInputWorkFlowManager, iPreviewMap, iStartGuidanceToDestinationSequence, iVehicle, locationSerializer, iRouteManager, cityHistory, naviADBHandler, iNaviFavoriteHandler, asyncNavLocationExtractor, aDBInterAppService, homeAddressHandler, mapInterface, asyncNavLocationExtractor2, iAddressInputFormModelAccessHelper, homeAddressHandler2);
    }

    @Override
    public void destAddressInputHKReturn(int n, int n2, Command command, Command command2) {
        this.logChannel.log(-2137614336, "%1#addressInputHKReturn called with removeHandler=%2", (Object)this.CLASS_NAME, (long)n2);
        SpellerStack$StackElement spellerStack$StackElement = null;
        switch (n2) {
            default: 
        }
        spellerStack$StackElement = this.spellerStack.pop();
        if (spellerStack$StackElement != null) {
            this.logChannel.log(-2137614336, "%1#addressInputHKReturn element popped from speller stack=%2", (Object)this.CLASS_NAME, (Object)spellerStack$StackElement);
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new LIRestoreStateCommand(spellerStack$StackElement));
            commandList.add(new AbstractAddressInputManagerEvo$1(this, new StringBuffer().append(this.CLASS_NAME).append("#destAddressInputHKReturn - Show or Hide Preview Map").toString()));
            commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccessHelper));
            if (command != null) {
                commandList.add(command);
            }
            if (command2 != null) {
                commandList.setErrorCommand(command2);
            }
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#destAddressInputHKReturn").toString());
        } else {
            this.logChannel.log(-1601830656, "%1#destAddressInputHKReturn - popped element from SpellerStack but element is null!", (Object)this.CLASS_NAME);
        }
    }

    static /* synthetic */ IPreviewMap access$000(AbstractAddressInputManagerEvo abstractAddressInputManagerEvo) {
        return abstractAddressInputManagerEvo.previewMap;
    }

    static /* synthetic */ IPreviewMap access$100(AbstractAddressInputManagerEvo abstractAddressInputManagerEvo) {
        return abstractAddressInputManagerEvo.previewMap;
    }
}

