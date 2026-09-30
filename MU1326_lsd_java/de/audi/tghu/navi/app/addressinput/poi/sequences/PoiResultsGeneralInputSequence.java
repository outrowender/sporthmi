/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.ModelSelectListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LispSelectByCategoryUidCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelOnElementSelectedCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdateFullListWithWaitCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdatePoiListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSelectSelectionCriteriaSubstringCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.IPoiResults;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiDetailsSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParentChildInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.SubstringSearchHandler;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiBrandsFromSpellerStateWrapperSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiResultsFromSpellerStateWrapperSequence;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.CommandUtil;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.routeguidance.ILocationHandler;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiResultsGeneralInputSequence
extends AbstractPoiSequence
implements IPoiResults {
    protected final IVehicle vehicle;
    protected final PoiSearchArea searchArea;
    protected final LIValueListElement selectedCategElement;
    protected final SubstringSearchHandler substringSearchHandler;
    protected final boolean selectByUID;
    protected final int minimumInitialResults;
    private boolean spellerStateModifiedByMe;
    private LISpellerData preModificationSpellerState;

    public PoiResultsGeneralInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, LIValueListElement lIValueListElement, IVehicle iVehicle, boolean bl, IDetailsScreen iDetailsScreen) {
        this(iPoiSpellerModelAccess, iCommandListFactory, poiSearchArea, navigationEnv, lIValueListElement, iVehicle, bl, 1, iDetailsScreen);
    }

    public PoiResultsGeneralInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, LIValueListElement lIValueListElement, IVehicle iVehicle, boolean bl, int n, IDetailsScreen iDetailsScreen) {
        this(iPoiSpellerModelAccess, iCommandListFactory, poiSearchArea, navigationEnv, lIValueListElement, iVehicle, bl, n, new SubstringSearchHandler(navigationEnv, iPoiSpellerModelAccess), iDetailsScreen);
    }

    protected PoiResultsGeneralInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, LIValueListElement lIValueListElement, IVehicle iVehicle, boolean bl, int n, SubstringSearchHandler substringSearchHandler, IDetailsScreen iDetailsScreen) {
        super(iPoiSpellerModelAccess, iCommandListFactory, navigationEnv, iDetailsScreen);
        this.vehicle = iVehicle;
        this.searchArea = poiSearchArea;
        this.selectedCategElement = lIValueListElement;
        this.substringSearchHandler = substringSearchHandler;
        this.selectByUID = bl;
        this.minimumInitialResults = n;
    }

    public void start() {
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiResultsGeneralInputSequence( %2 )#start() - classElementIndex: %1 ", (Object)this.selectedCategElement, (Object)this.getStringId());
        CommandList commandList = this.createStartSequence();
        commandList.execute("PoiResultsGeneralInputSequence#start()");
    }

    public void restore() {
        if (!this.hasActiveSubSequence() && this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Restore to previous state.");
        }
        if (this.spellerStateModifiedByMe) {
            this.spellerStateModifiedByMe = false;
            if (this.hasActiveSubSequence() && this.currentInputSequence instanceof AbstractPoiSequence) {
                AbstractPoiSequence abstractPoiSequence = (AbstractPoiSequence)this.currentInputSequence;
                abstractPoiSequence.initialSpellerState = this.preModificationSpellerState;
            }
        }
        super.restore();
    }

    public void startGuidance(IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
        this.startGuidance(null, iStartGuidanceToDestinationSequence);
    }

    public void startGuidanceToSingleDestination(final IRouteManager iRouteManager) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startGuidanceToSingleDestination(iRouteManager);
            return;
        }
        if (this.selectedElement == null) {
            this.env.getLogChannel().log(10000000, "[PoiInput] PoiResultsGeneralInputSequence#startGuidanceToSingleDestination() - no element has been selected");
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiResultsGeneralInputSequence#startGuidanceToSingleDestination()");
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Element was selected");
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new NavCommand(){

            public void execute() {
                PoiResultsGeneralInputSequence.this.preModificationSpellerState = this.dsiResponseContainer.getSpellerState();
                PoiResultsGeneralInputSequence.this.spellerStateModifiedByMe = true;
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand(this.selectedElement.getListIndex()));
        if (this.modelAccess != null) {
            commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        }
        commandList.add(new NavCommand(){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (navLocation.isPositionValid()) {
                    this.getCommandList().commandFinishedWithPostSequence(iRouteManager.getStartRouteGuidanceToSingleDestinationSequence(navLocation));
                } else {
                    this.getCommandList().commandAborted("Position for element is not valid");
                }
            }
        });
        commandList.execute("PoiResultsGeneralInputSequence#startGuidanceToSingleDestination");
    }

    public void startGuidance(final ILocationHandler iLocationHandler, final IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startGuidance(iLocationHandler, iStartGuidanceToDestinationSequence);
            return;
        }
        if (this.selectedElement == null) {
            this.env.getLogChannel().log(10000000, "[PoiInput] PoiResultsGeneralInputSequence#startGuidance() - no element has been selected");
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiResultsGeneralInputSequence#startGuidance()");
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Element was selected");
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        SpellerContext spellerContext = new SpellerContext(73);
        commandList.add(new LIGetStateCommand(SpellerStack.getInstance(), spellerContext));
        commandList.add(new NavCommand(){

            public void execute() {
                PoiResultsGeneralInputSequence.this.preModificationSpellerState = this.dsiResponseContainer.getSpellerState();
                PoiResultsGeneralInputSequence.this.spellerStateModifiedByMe = true;
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand(this.selectedElement.getListIndex()));
        if (this.modelAccess != null) {
            commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        }
        commandList.add(new NavCommand(){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (navLocation.isPositionValid()) {
                    this.getCommandList().commandFinishedWithPostSequence(iStartGuidanceToDestinationSequence.getStartSequence(iLocationHandler, navLocation));
                } else {
                    this.getCommandList().commandAborted("Position for element is not valid");
                }
            }
        });
        commandList.execute("PoiResultsGeneralInputSequence#startGuidance");
    }

    public void startParentChild(final IPoiSpellerModelAccess iPoiSpellerModelAccess, final IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startParentChild(iPoiSpellerModelAccess, iStartGuidanceToDestinationSequence);
            return;
        }
        if (this.selectedElement == null) {
            this.env.getLogChannel().log(10000000, "[PoiInput]PoiResultsInputSequence#startParentChild() - no element has been selected");
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiResultsInputSequence#startParentChild() - element: %1", (Object)this.selectedElement);
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Element was selected");
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new NavCommand(){

            public void execute() {
                PoiResultsGeneralInputSequence.this.preModificationSpellerState = this.dsiResponseContainer.getSpellerState();
                PoiResultsGeneralInputSequence.this.spellerStateModifiedByMe = true;
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand(this.selectedElement.getListIndex()));
        if (iPoiSpellerModelAccess != null) {
            commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        }
        commandList.add(new NavCommand(){

            public void execute() {
                if (this.dsiResponseContainer.selectionCriterionAvailable(32774)) {
                    this.logger.log(10000000, "[PoiInput] PoiResultsInputSequence#startParentChild() - Starting parent child sequence");
                    PoiParentChildInputSequence poiParentChildInputSequence = new PoiParentChildInputSequence(iPoiSpellerModelAccess, PoiResultsGeneralInputSequence.this.commandListFactory, PoiResultsGeneralInputSequence.this.searchArea, this.env, PoiResultsGeneralInputSequence.this.vehicle, PoiResultsGeneralInputSequence.this.selectedElement.getListIndex(), PoiResultsGeneralInputSequence.this.detailsScreen);
                    PoiResultsGeneralInputSequence.this.currentInputSequence = poiParentChildInputSequence;
                    this.getCommandList().commandFinishedWithPostSequence(poiParentChildInputSequence.createStartSequence());
                    return;
                }
                this.logger.log(10000000, "[PoiInput] PoiResultsInputSequence#startGuidance() - Starting route guidance");
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (navLocation.isPositionValid()) {
                    this.getCommandList().commandFinishedWithPostSequence(iStartGuidanceToDestinationSequence.getStartSequence(navLocation));
                } else {
                    this.getCommandList().commandAborted("Position for element is not valid");
                }
            }
        });
        commandList.execute("PoiResultsInputSequence#startParentChild");
    }

    public void startBrands(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startBrands(iPoiSpellerModelAccess);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiResultsGeneralInputSequence#startBrands() - categoryListEl: %1", (Object)this.selectedCategElement);
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Restore to previous state.");
        }
        this.currentInputSequence = new PoiBrandsFromSpellerStateWrapperSequence(iPoiSpellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.selectedCategElement, this.initialSpellerState, this.vehicle, this.selectByUID, this.detailsScreen);
        this.currentInputSequence.start();
    }

    public void startSubstringSearch(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startSubstringSearch(iPoiSpellerModelAccess);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiResultsGeneralInputSequence#startSubstringSearch()");
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Restore to previous state.");
        }
        this.currentInputSequence = new PoiResultsFromSpellerStateWrapperSequence(iPoiSpellerModelAccess, this.commandListFactory, this.env, this.searchArea, this.selectedCategElement, this.initialSpellerState, this.vehicle, this.selectByUID, this.detailsScreen);
        this.currentInputSequence.start();
    }

    public void setInput(String string) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.setInput(string);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiResultsGeneralInputSequence#setInput( %1 )", (Object)string);
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Input was entered");
        }
        LIValueList lIValueList = new LIValueList();
        lIValueList.list = new LIValueListElement[0];
        this.env.getContainer().setLispValueListCount(0L);
        this.env.getContainer().setLispValueList(lIValueList);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        if (this.modelAccess != null) {
            commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        }
        commandList.add(new SetInputCommand(string));
        commandList.execute("PoiResultsGeneralInputSequence#setInput");
    }

    public void retrieveNavLocation(GuiModelAccessDetailsNavi guiModelAccessDetailsNavi) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.retrieveNavLocation(guiModelAccessDetailsNavi);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiResultsGeneralInputSequence#retrieveNavLocation()");
        if (this.selectedElement == null) {
            this.env.getLogChannel().log(10000000, "[PoiInput] PoiResultsGeneralInputSequence#startGuidance() - no element has been selected");
            return;
        }
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Element was selected");
        }
        PoiDetailsSequence poiDetailsSequence = new PoiDetailsSequence(this.commandListFactory, guiModelAccessDetailsNavi, this.selectedElement, this.detailsScreen);
        poiDetailsSequence.start();
    }

    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.updatePoiSubstringSearchStatus(valueListStatus);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] PoiResultsGeneralInputSequence#updatePoiSubstringSearchStatus(%1)", (Object)valueListStatus);
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.updatePoiSubstringSearchStatus(valueListStatus);
        }
    }

    public CommandList createStartSequence() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new NavCommand(){

            public void execute() {
                PoiResultsGeneralInputSequence.this.initialSpellerState = this.dsiResponseContainer.getSpellerState();
                this.getCommandList().commandFinished();
            }
        });
        if (this.modelAccess != null) {
            commandList.add(new NavCommand(){

                public void execute() {
                    PoiResultsGeneralInputSequence.this.modelAccess.onStart(PoiResultsGeneralInputSequence.this.getSpellerCountryLocation());
                    this.getCommandList().commandFinished();
                }
            });
        }
        commandList.add(new PoiSetSortOrderCommand(this.getSortOrder()));
        if (this.selectByUID) {
            commandList.add(new LispSelectByCategoryUidCommand(this.selectedCategElement.getPoiUniqueId()));
        } else {
            commandList.add(new LISPSelectListItemCommand(this.selectedCategElement.getListIndex()));
        }
        if (this.modelAccess != null) {
            commandList.add(new ModelOnElementSelectedCommand(this.modelAccess, this.selectedCategElement));
            commandList.add(new ModelUpdatePoiListCommand(this.modelAccess));
        }
        commandList.add(new NavCommand(){

            public void execute() {
                this.logger.log(10000000, "[PoiInput] PoiResultsGeneralInputSequence#createStartSequence#execute()");
                LIValueList lIValueList = this.dsiResponseContainer.getPOIValueList();
                if (lIValueList == null || lIValueList.getList() == null) {
                    this.logger.log(10000000, "[PoiInput] PoiResultsGeneralInputSequence#createStartSequence#execute() - poiValueList or poiValueList.getList is null.");
                    this.getCommandList().commandAborted("PoiValueList is empty.");
                    return;
                }
                int n = CommandUtil.getIndexForCriteria(16, lIValueList);
                if (n < 0) {
                    this.getCommandList().commandAborted("No matching selection criteria found.");
                    return;
                }
                CommandList commandList = PoiResultsGeneralInputSequence.this.commandListFactory.createCommandList();
                if (PoiResultsGeneralInputSequence.this.searchArea.getSearchContext() == 5) {
                    commandList.add(new PoiSelectSelectionCriteriaCommand(n));
                } else {
                    commandList.add(new PoiSelectSelectionCriteriaSubstringCommand(n, PoiResultsGeneralInputSequence.this.minimumInitialResults, PoiResultsGeneralInputSequence.this.substringSearchHandler));
                }
                commandList.add(new ModelUpdateFullListWithWaitCommand(PoiResultsGeneralInputSequence.this.modelAccess, PoiResultsGeneralInputSequence.this.commandListFactory, -1, 0, 1));
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }
        });
        return commandList;
    }

    protected int getSortOrder() {
        return 2;
    }

    protected String getStringId() {
        return "PoiResultsGeneralInputSequence";
    }

    private NavLocation getSpellerCountryLocation() {
        if (this.searchArea.getSearchContext() == 2 || this.searchArea.getSearchContext() == 3) {
            return this.searchArea.getLocation();
        }
        if (this.searchArea.getSearchContext() == 0 || this.searchArea.getSearchContext() == 1) {
            return this.vehicle.getVehicleCountryLocation();
        }
        if (this.searchArea.getSearchContext() == 4) {
            return this.searchArea.getLocation();
        }
        if (this.searchArea.getSearchContext() == 5) {
            return this.searchArea.getLocation();
        }
        return this.vehicle.getVehicleCountryLocation();
    }
}

