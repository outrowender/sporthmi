/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.fuelwarning;

import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.fuelwarning.FuelWarningModelAccess;
import de.audi.app.navi.evo.addressinput.poi.fuelwarning.FuelWarningScreens;
import de.audi.app.navi.evo.addressinput.poi.fuelwarning.FuelWarningSequenceModelAccess;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.PoiFuelWarningService;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.PoiFuelWarningSetup;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.popup.IPopupHandler;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class FuelWarningHMIListener
implements BaseListModelListener,
ChoiceListener,
ButtonListener,
IPopupHandler {
    private final NavigationEnv env;
    private final PoiFuelWarningService poiFuelWarningService;
    private final FuelWarningModelAccess fuelWarningModelAccess;
    private final IconHandler iconHandler;
    private final IStartGuidanceToDestinationSequence startGuidanceSequence;
    private static final int RESULTS_NO_RG = 20;
    private static final int RESULT_NO_RESULTS = 0;
    private final IVehicle vehicle;
    private final IRouteManager routeManager;
    private final IPreviewMap previewMapInterface;
    private final ICommandListFactory commandListFactory;
    private final LogChannel logChannel;

    public FuelWarningHMIListener(NavigationEnv navigationEnv, PoiFuelWarningService poiFuelWarningService, PoiFuelWarningSetup poiFuelWarningSetup, FuelWarningModelAccess fuelWarningModelAccess, IconHandler iconHandler, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IRouteManager iRouteManager, IVehicle iVehicle, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory) {
        this.env = navigationEnv;
        this.poiFuelWarningService = poiFuelWarningService;
        this.fuelWarningModelAccess = fuelWarningModelAccess;
        this.iconHandler = iconHandler;
        this.startGuidanceSequence = iStartGuidanceToDestinationSequence;
        this.routeManager = iRouteManager;
        this.vehicle = iVehicle;
        this.previewMapInterface = iPreviewMap;
        this.commandListFactory = iCommandListFactory;
        this.logChannel = navigationEnv.getPOILogChannel();
        this.init();
    }

    private void init() {
        this.env.getChoiceModel(400370).setChoiceListener(this);
        this.env.getButtonModel(400369).setButtonListener(this);
        this.env.getButtonModel(400368).setButtonListener(this);
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "FuelWarningHMIListener#itemSelected. modelId: %1, col: %2, itemID: %3", (long)n, (long)n3, (long)n2);
        if (n == 400370) {
            this.poiFuelWarningService.toggleFuelWarningSelection();
            this.poiFuelWarningService.checkPendingEvents();
        }
        this.logChannel.log(10000000, "FuelWarningHMIListener#itemSelected - fire model event");
        this.env.fireModelEvent(n, n4);
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(10000000, "FuelWarningHMIListener#keyTyped. modelId: %1, keyID: %2, terminalID: %3", (long)n, (long)n2, (long)n3);
        if (n == 400369) {
            int n4;
            int n5;
            this.env.getChoiceModel(170).setValue(0);
            this.fuelWarningModelAccess.setIgnoreCloseTimer(true);
            this.env.getChoiceModel(400639).setValue(0);
            this.poiFuelWarningService.finish();
            boolean bl = this.env.getContainer().isRgActive();
            if (bl) {
                n5 = 0;
                n4 = 20;
            } else {
                n5 = 20;
                n4 = 0;
            }
            this.logChannel.log(10000000, "FuelWarningHMIListener#keyTyped. rgActive: %3, maxResultsVicinity: %1, maxResultsAlongRoute: %2", (long)n5, (long)n4, bl);
            FuelWarningSequenceModelAccess fuelWarningSequenceModelAccess = FuelWarningScreens.createFuelWarningModelAccess(this.env, this, this.iconHandler, FuelWarningScreens.getVicinityListModel(), n5, this.routeManager, this.vehicle);
            FuelWarningSequenceModelAccess fuelWarningSequenceModelAccess2 = FuelWarningScreens.createFuelWarningModelAccess(this.env, this, this.iconHandler, FuelWarningScreens.getAlongRouteListModel(), n4, this.routeManager, this.vehicle);
            FuelWarningSequenceModelAccess fuelWarningSequenceModelAccess3 = FuelWarningScreens.createFuelWarningModelAccess(this.env, this, this.iconHandler, FuelWarningScreens.getVicinityListModel(), n4, this.routeManager, this.vehicle);
            this.fuelWarningModelAccess.onStartSequence(bl);
            this.poiFuelWarningService.preparePetrolStationSearch(fuelWarningSequenceModelAccess, fuelWarningSequenceModelAccess2, n5, n4, fuelWarningSequenceModelAccess3);
        } else if (n == 400368) {
            this.fuelWarningModelAccess.setIgnoreCloseTimer(true);
            this.fuelWarningModelAccess.hidePopUp();
        }
        this.env.fireModelEvent(n, n3);
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void fuelFeatureEntered() {
        this.fuelWarningModelAccess.setFuelWarningActive(true);
    }

    public void fuelFeatureLeft() {
        this.poiFuelWarningService.finish();
        this.fuelWarningModelAccess.setFuelWarningActive(false);
    }

    public void popupVisible(int n, int n2) {
        this.fuelWarningModelAccess.popupVisible(n, n2);
    }

    public void popupHidden(int n, int n2) {
        this.fuelWarningModelAccess.popupHidden(n, n2);
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "FuelWarningHMIListener#itemSelected. row: %1, model: %2, index: %3", (Object)evoListRow, (long)n, (long)n2);
        if (n == FuelWarningScreens.getAlongRouteListModel()) {
            LIValueListElement lIValueListElement = FuelWarningScreens.getFuelWarningListSelectedElement(evoListRow);
            this.poiFuelWarningService.startGuidance(lIValueListElement, this.startGuidanceSequence, false);
        } else if (n == FuelWarningScreens.getVicinityListModel()) {
            LIValueListElement lIValueListElement = FuelWarningScreens.getFuelWarningListSelectedElement(evoListRow);
            this.poiFuelWarningService.startGuidance(lIValueListElement, this.startGuidanceSequence, true);
        } else {
            this.logChannel.log(10000000, "FuelWarningHMIListener#itemSelected. not found");
        }
        this.logChannel.log(10000000, "FuelWarningHMIListener#itemSelected - fire model event");
        this.env.fireModelEvent(n, n4);
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "FuelWarningHMIListener#itemFocused. row: %1, model: %2, index: %3", (Object)evoListRow, (long)n, (long)n2);
        LIValueListElement lIValueListElement = PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n);
        if (lIValueListElement != null && this.previewMapInterface != null) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
            commandList.add(new NavCommand(){

                public void execute() {
                    FuelWarningHMIListener.this.previewMapInterface.setPreviewPOIsOnboardAroundCCP(new NavLocation[]{this.dsiResponseContainer.getSelectedLocation()}, 2, null, null);
                    this.getCommandList().commandFinished();
                }
            });
            commandList.execute("FuelWarningHMIListener - show location in previewMap");
            this.env.getChoiceModel(401057).setValue(1);
        }
        if (n == FuelWarningScreens.getAlongRouteListModel()) {
            this.env.getChoiceModel(400639).setValue(2);
        } else if (n == FuelWarningScreens.getVicinityListModel()) {
            this.env.getChoiceModel(400639).setValue(1);
        }
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }
}

