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
import de.audi.tghu.navi.app.addressinput.poi.commands.ModelUpdatePoiListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.IPoiResults;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiDetailsSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence$3;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence$4;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence$5;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence$6;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence$7;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence$8;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence$9;
import de.audi.tghu.navi.app.addressinput.poi.sequences.SubstringSearchHandler;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiBrandsFromSpellerStateWrapperSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiResultsFromSpellerStateWrapperSequence;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
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

    @Override
    public void start() {
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiResultsGeneralInputSequence( %2 )#start() - classElementIndex: %1 ", (Object)this.selectedCategElement, (Object)this.getStringId());
        CommandList commandList = this.createStartSequence();
        commandList.execute("PoiResultsGeneralInputSequence#start()");
    }

    @Override
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

    @Override
    public void startGuidance(IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
        this.startGuidance(null, iStartGuidanceToDestinationSequence);
    }

    @Override
    public void startGuidanceToSingleDestination(IRouteManager iRouteManager) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startGuidanceToSingleDestination(iRouteManager);
            return;
        }
        if (this.selectedElement == null) {
            this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiResultsGeneralInputSequence#startGuidanceToSingleDestination() - no element has been selected");
            return;
        }
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiResultsGeneralInputSequence#startGuidanceToSingleDestination()");
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Element was selected");
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new PoiResultsGeneralInputSequence$1(this));
        commandList.add(new de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand(this.selectedElement.getListIndex()));
        if (this.modelAccess != null) {
            commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        }
        commandList.add(new PoiResultsGeneralInputSequence$2(this, iRouteManager));
        commandList.execute("PoiResultsGeneralInputSequence#startGuidanceToSingleDestination");
    }

    @Override
    public void startGuidance(ILocationHandler iLocationHandler, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startGuidance(iLocationHandler, iStartGuidanceToDestinationSequence);
            return;
        }
        if (this.selectedElement == null) {
            this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiResultsGeneralInputSequence#startGuidance() - no element has been selected");
            return;
        }
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiResultsGeneralInputSequence#startGuidance()");
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Element was selected");
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        SpellerContext spellerContext = new SpellerContext(73);
        commandList.add(new LIGetStateCommand(SpellerStack.getInstance(), spellerContext));
        commandList.add(new PoiResultsGeneralInputSequence$3(this));
        commandList.add(new de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand(this.selectedElement.getListIndex()));
        if (this.modelAccess != null) {
            commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        }
        commandList.add(new PoiResultsGeneralInputSequence$4(this, iStartGuidanceToDestinationSequence, iLocationHandler));
        commandList.execute("PoiResultsGeneralInputSequence#startGuidance");
    }

    @Override
    public void startParentChild(IPoiSpellerModelAccess iPoiSpellerModelAccess, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startParentChild(iPoiSpellerModelAccess, iStartGuidanceToDestinationSequence);
            return;
        }
        if (this.selectedElement == null) {
            this.env.getLogChannel().log(-2137614336, "[PoiInput]PoiResultsInputSequence#startParentChild() - no element has been selected");
            return;
        }
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiResultsInputSequence#startParentChild() - element: %1", (Object)this.selectedElement);
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Element was selected");
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new PoiResultsGeneralInputSequence$5(this));
        commandList.add(new de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand(this.selectedElement.getListIndex()));
        if (iPoiSpellerModelAccess != null) {
            commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        }
        commandList.add(new PoiResultsGeneralInputSequence$6(this, iPoiSpellerModelAccess, iStartGuidanceToDestinationSequence));
        commandList.execute("PoiResultsInputSequence#startParentChild");
    }

    @Override
    public void startBrands(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startBrands(iPoiSpellerModelAccess);
            return;
        }
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiResultsGeneralInputSequence#startBrands() - categoryListEl: %1", (Object)this.selectedCategElement);
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Restore to previous state.");
        }
        this.currentInputSequence = new PoiBrandsFromSpellerStateWrapperSequence(iPoiSpellerModelAccess, this.commandListFactory, this.searchArea, this.env, this.selectedCategElement, this.initialSpellerState, this.vehicle, this.selectByUID, this.detailsScreen);
        this.currentInputSequence.start();
    }

    @Override
    public void startSubstringSearch(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startSubstringSearch(iPoiSpellerModelAccess);
            return;
        }
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiResultsGeneralInputSequence#startSubstringSearch()");
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Restore to previous state.");
        }
        this.currentInputSequence = new PoiResultsFromSpellerStateWrapperSequence(iPoiSpellerModelAccess, this.commandListFactory, this.env, this.searchArea, this.selectedCategElement, this.initialSpellerState, this.vehicle, this.selectByUID, this.detailsScreen);
        this.currentInputSequence.start();
    }

    @Override
    public void setInput(String string) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.setInput(string);
            return;
        }
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiResultsGeneralInputSequence#setInput( %1 )", (Object)string);
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

    @Override
    public void retrieveNavLocation(GuiModelAccessDetailsNavi guiModelAccessDetailsNavi) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.retrieveNavLocation(guiModelAccessDetailsNavi);
            return;
        }
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiResultsGeneralInputSequence#retrieveNavLocation()");
        if (this.selectedElement == null) {
            this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiResultsGeneralInputSequence#startGuidance() - no element has been selected");
            return;
        }
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.stopSearch("Element was selected");
        }
        PoiDetailsSequence poiDetailsSequence = new PoiDetailsSequence(this.commandListFactory, guiModelAccessDetailsNavi, this.selectedElement, this.detailsScreen);
        poiDetailsSequence.start();
    }

    @Override
    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.updatePoiSubstringSearchStatus(valueListStatus);
            return;
        }
        this.env.getLogChannel().log(-2137614336, "[PoiInput] PoiResultsGeneralInputSequence#updatePoiSubstringSearchStatus(%1)", (Object)valueListStatus);
        if (this.substringSearchHandler != null) {
            this.substringSearchHandler.updatePoiSubstringSearchStatus(valueListStatus);
        }
    }

    public CommandList createStartSequence() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetStateCommand());
        commandList.add(new PoiResultsGeneralInputSequence$7(this));
        if (this.modelAccess != null) {
            commandList.add(new PoiResultsGeneralInputSequence$8(this));
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
        commandList.add(new PoiResultsGeneralInputSequence$9(this));
        return commandList;
    }

    @Override
    protected int getSortOrder() {
        return 2;
    }

    @Override
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

    static /* synthetic */ LISpellerData access$002(PoiResultsGeneralInputSequence poiResultsGeneralInputSequence, LISpellerData lISpellerData) {
        poiResultsGeneralInputSequence.preModificationSpellerState = lISpellerData;
        return poiResultsGeneralInputSequence.preModificationSpellerState;
    }

    static /* synthetic */ boolean access$102(PoiResultsGeneralInputSequence poiResultsGeneralInputSequence, boolean bl) {
        poiResultsGeneralInputSequence.spellerStateModifiedByMe = bl;
        return poiResultsGeneralInputSequence.spellerStateModifiedByMe;
    }

    static /* synthetic */ NavLocation access$200(PoiResultsGeneralInputSequence poiResultsGeneralInputSequence) {
        return poiResultsGeneralInputSequence.getSpellerCountryLocation();
    }
}

