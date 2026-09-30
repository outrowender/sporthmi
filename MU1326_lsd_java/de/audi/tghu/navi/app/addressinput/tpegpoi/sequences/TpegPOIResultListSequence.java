/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.tpegpoi.sequences;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToAddressbookSequence;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.NewUnrequestItemsCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultScreenWithSpellerForRequestCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.tpegpoi.ITpegPOIResultListModelAccess;
import de.audi.tghu.navi.app.addressinput.tpegpoi.commands.TpegPoiSelectSelectionCriteriaCommand;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIBaseSequence;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.CommandUtil;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class TpegPOIResultListSequence
extends TpegPOIBaseSequence {
    private final ITpegPOIResultListModelAccess modelAccess;
    private final IStartGuidanceToDestinationSequence startGuidanceSequence;
    private final IPreviewMap previewMap;

    public TpegPOIResultListSequence(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, ITpegPOIResultListModelAccess iTpegPOIResultListModelAccess, SpellerStack spellerStack, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IPreviewMap iPreviewMap) {
        super(navigationEnv, iCommandListFactory, spellerStack);
        this.modelAccess = iTpegPOIResultListModelAccess;
        this.startGuidanceSequence = iStartGuidanceToDestinationSequence;
        this.previewMap = iPreviewMap;
    }

    public CommandList getResultListCommandList(final long l) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetStateCommand(this.spellerStack, new SpellerContext(110)));
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new PoiSetSortOrderCommand(0));
        commandList.add(new NavCommand("TpegPOIResultListSequence#getResultListCommandList update categorie label"){

            public void execute() {
                this.env.getLabelModel(402071).setText(this.env.getContainer().getLispValueList().list[(int)l].getData());
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new LISPSelectListItemCommand((int)l));
        commandList.add(new NavCommand(){

            public void execute() {
                CommandList commandList = TpegPOIResultListSequence.this.commandListFactory.createCommandList();
                LIValueList lIValueList = this.dsiResponseContainer.getPOIValueList();
                if (lIValueList == null || lIValueList.getList() == null) {
                    this.logger.log(10000000, "%1#getResultListCommandList#execute() - poiValueList or poiValueList.getList is null.", (Object)this.CLASS_NAME);
                    this.getCommandList().commandAborted("PoiValueList is empty.");
                }
                this.logger.log(10000000, "%1#getResultListCommandList#execute() - poiValueList: %2", (Object)this.CLASS_NAME, (Object)lIValueList);
                int n = CommandUtil.getIndexForCriteria(16, lIValueList);
                this.logger.log(10000000, "%1#getResultListCommandList#execute(): index for criteria: %2", (Object)this.CLASS_NAME, (long)n);
                if (n < 0) {
                    this.getCommandList().commandAborted("No matching selection criteria found.");
                }
                commandList.add(new TpegPoiSelectSelectionCriteriaCommand(n));
                commandList.add(new NewModelUpdateResultListCommand(TpegPOIResultListSequence.this.modelAccess));
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        });
        return commandList;
    }

    public void requestNextResultListWindow(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPRequestValueListByListIndexCommand(n, true));
        commandList.add(new NewModelUpdateResultScreenWithSpellerForRequestCommand(this.modelAccess, n2, n));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#requestNextResultListWindows").toString());
    }

    public void unrequestItems(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new NewUnrequestItemsCommand(n, n2, this.modelAccess));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#unrequestItems").toString());
    }

    public void preparePreviewMap(LIValueListElement lIValueListElement) {
        this.logChannel.log(10000000, "%1#preparePreviewMap - poiToDisplay: %2", (Object)this.CLASS_NAME, (Object)lIValueListElement);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        commandList.add(new NavCommand("Update preview map to focused POI"){

            public void execute() {
                if (TpegPOIResultListSequence.this.previewMap != null) {
                    TpegPOIResultListSequence.this.previewMap.setPreviewPOIsOnboardAroundCCP(new NavLocation[]{this.dsiResponseContainer.getSelectedLocation()}, 5, null, null);
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#preparePreviewMap").toString());
    }

    public void executeItemSelect(LIValueListElement lIValueListElement, final HomeAddressHandler homeAddressHandler) {
        this.logChannel.log(10000000, "%1#startGuidanceFromSelectedPOI - selectedPOI: %2", (Object)this.CLASS_NAME, (Object)lIValueListElement);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        commandList.add(new NavCommand("Start route guidance"){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
                if (navLocation.isPositionValid()) {
                    if (this.env.getInputModeManager().getInputMode() == 2) {
                        this.logger.log(10000000, "Selected location is valid, Saving location as home address.");
                        homeAddressHandler.onCreateEditHomeAddress(navLocation);
                        this.getCommandList().commandFinished();
                    } else if (this.env.getInputModeManager().getInputMode() == 1) {
                        this.logger.log(10000000, "Selected location is valid, saving location to contact.");
                        ReturnNavLocationToAddressbookSequence returnNavLocationToAddressbookSequence = new ReturnNavLocationToAddressbookSequence(TpegPOIResultListSequence.this.commandListFactory);
                        this.getCommandList().commandFinishedWithPostSequence(returnNavLocationToAddressbookSequence.getStartCommandListWithLocation(navLocation));
                    } else {
                        this.logger.log(10000000, "Selected location is valid, Route Guidance is starting");
                        this.getCommandList().commandFinishedWithPostSequence(TpegPOIResultListSequence.this.startGuidanceSequence.getStartSequence(navLocation));
                    }
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#startGuidanceFromSelectedPOI").toString());
    }
}

