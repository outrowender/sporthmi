/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.IPoiWorkFlowManager;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequence;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public abstract class CorePoiManager
implements IPoiManager {
    public static final int ENTER_FOLLOW_UP_SCREEN_NOT_ALLOWED = 0;
    public static final int ENTER_FOLLOW_UP_SCREEN_ALLOWED = 1;
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    protected final IconHandler iconHandler;
    protected final IRouteManager routeManager;
    protected final ICommandListFactory commandListFactory;
    protected final PoiSearchArea poiSearchArea;
    protected final IVehicle vehicle;
    protected final IPreviewMap previewMapInterface;
    protected final SpellerStack spellerStack;
    protected final IStartGuidanceToDestinationSequence startGuidanceToDestinationSequence;
    protected final IPoiWorkFlowManager poiWorkFlowManager;
    private boolean rgStartedByUser = false;
    protected final PoiSearchAreaSequence poiSearchAreaSequence;
    protected final INavigationInputModeManager inputModeManager;
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());

    public CorePoiManager(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteManager iRouteManager, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, IVehicle iVehicle, IPreviewMap iPreviewMap, SpellerStack spellerStack, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IPoiWorkFlowManager iPoiWorkFlowManager, PoiSearchAreaSequence poiSearchAreaSequence) {
        this.env = navigationEnv;
        this.iconHandler = iconHandler;
        this.routeManager = iRouteManager;
        this.commandListFactory = iCommandListFactory;
        this.poiSearchArea = poiSearchArea;
        this.vehicle = iVehicle;
        this.previewMapInterface = iPreviewMap;
        this.spellerStack = spellerStack;
        this.startGuidanceToDestinationSequence = iStartGuidanceToDestinationSequence;
        this.poiWorkFlowManager = iPoiWorkFlowManager;
        this.poiSearchAreaSequence = poiSearchAreaSequence;
        this.inputModeManager = navigationEnv.getInputModeManager();
        this.logChannel = navigationEnv.getPOILogChannel();
    }

    public synchronized void updateRgActive(boolean bl) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "%1#updateRgActive rgActive=%2", (Object)this.CLASS_NAME, (Object)bl);
        }
        if (!bl) {
            this.cancelAlongRouteSearch(false);
        }
    }

    public void executePoiSelectionEvent(CommandList commandList, int n) {
        this.handlePoiSelectionEvent(commandList, n).execute(new StringBuffer().append(this.CLASS_NAME).append("#executePoiSelectionEvent() - eventId=").append(n).toString());
    }

    public CommandList handlePoiSelectionEvent(CommandList commandList, int n) {
        return this.poiWorkFlowManager.handleWorkFlow(commandList, n, this.poiSearchArea, this.env);
    }

    public synchronized void cancelAlongRouteSearch(final boolean bl) {
        this.logChannel.log(10000000, "%1#cancelAlongRouteSearch - rgStartedByUser=%2, isSdsActive=%3", (Object)this.CLASS_NAME, (Object)Boolean.toString(this.rgStartedByUser), (Object)Boolean.toString(this.inputModeManager.isSdsActive()));
        if (!this.rgStartedByUser && !this.inputModeManager.isSdsActive()) {
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new NavCommand(){

                public void execute() {
                    int n = CorePoiManager.this.poiSearchArea.getSearchContext();
                    CorePoiManager.this.logChannel.log(10000000, "%1#cancelAlongRouteSearch - search area context: %2", (Object)this.CLASS_NAME, (long)n);
                    if (CorePoiManager.this.checkIfLeavingOfPoiScreensIsNeeded(n, bl)) {
                        CorePoiManager.this.logChannel.log(10000000, "%1#cancelAlongRouteSearch - canceling poi screens", (Object)this.CLASS_NAME);
                        CommandList commandList = CorePoiManager.this.commandListFactory.createCommandList();
                        commandList.add(new LISPCancelSpellerCommand());
                        commandList.add(new NavCommand("Leave POI Screens"){

                            public void execute() {
                                CorePoiManager.this.leavePoiScreens();
                                (this).CorePoiManager.this.poiSearchAreaSequence.updateSearchArea(0, null);
                                this.getCommandList().commandFinished();
                            }
                        });
                        this.getCommandList().commandFinishedWithPostSequence(commandList);
                    } else {
                        CorePoiManager.this.logChannel.log(10000000, "%1#cancelAlongRouteSearch - nothing to do because of search area", (Object)this.CLASS_NAME);
                        this.getCommandList().commandFinished();
                    }
                }
            });
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#cancelAlongRouteSearch").toString());
        } else if (this.inputModeManager.isSdsActive()) {
            this.logChannel.log(1000000, "%1#cancelAlongRouteSearch - SDS is active but currently no handling is implemented.", (Object)this.CLASS_NAME);
        }
        this.setRouteGuidanceStartedByUser(false);
    }

    private void leavePoiScreens() {
        this.logChannel.log(10000000, "%1#leavePoiScreens - toggle mediator: %2", (Object)this.CLASS_NAME, 400602L);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(400602);
        if (choiceModelApp != null) {
            int n = choiceModelApp.getValue();
            int n2 = n == 0 ? 1 : 0;
            choiceModelApp.setValue(n2);
        }
        ChoiceModelApp choiceModelApp2 = this.env.getChoiceModel(402716);
        choiceModelApp2.setValue(0);
    }

    public void enterPoiScreens() {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(402716);
        choiceModelApp.setValue(1);
    }

    private boolean checkIfLeavingOfPoiScreensIsNeeded(int n, boolean bl) {
        return n == 1 || (n == 3 || n == 2) && !bl;
    }

    public synchronized void setRouteGuidanceStartedByUser(boolean bl) {
        this.logChannel.log(10000000, "%1#setRouteGuidanceStartedByUser - oldValue=%2, newValue=%3", (Object)this.CLASS_NAME, (Object)Boolean.toString(this.rgStartedByUser), (Object)Boolean.toString(bl));
        this.rgStartedByUser = bl;
    }

    public void showPoiDetailScreen(NavLocation navLocation) {
    }

    public void resetPoiSearchArea() {
        this.poiSearchArea.setSearchContext(0);
    }
}

