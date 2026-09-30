/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateRestoreCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiCategoriesOrResultsModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.IPoiInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiDetailsSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.UnrequestItemsCommand;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.routeguidance.ILocationHandler;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public abstract class AbstractPoiSequence
implements IPoiInputSequence {
    protected final NavigationEnv env;
    protected final ICommandListFactory commandListFactory;
    protected final IPoiSpellerModelAccess modelAccess;
    protected LISpellerData initialSpellerState;
    protected IPoiInputSequence currentInputSequence;
    protected LIValueListElement selectedElement;
    protected final IDetailsScreen detailsScreen;

    public AbstractPoiSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IDetailsScreen iDetailsScreen) {
        this.modelAccess = iPoiSpellerModelAccess;
        this.commandListFactory = iCommandListFactory;
        this.env = navigationEnv;
        this.detailsScreen = iDetailsScreen;
    }

    public void startDetailsForSelectedElement(IPreviewMap iPreviewMap, GuiModelAccessDetailsNavi guiModelAccessDetailsNavi) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startDetailsForSelectedElement(iPreviewMap, guiModelAccessDetailsNavi);
            return;
        }
        new PoiDetailsSequence(this.commandListFactory, guiModelAccessDetailsNavi, this.selectedElement, this.detailsScreen).start();
    }

    public void startCategoriesOrResultsSequence(IPoiCategoriesOrResultsModelAccess iPoiCategoriesOrResultsModelAccess, int n) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startCategoriesOrResultsSequence(iPoiCategoriesOrResultsModelAccess, n);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#startCategoriesOrResultsSequence()", (Object)this.getStringId());
        throw new UnsupportedOperationException("Cannot start a Categories/Results Sequence from the current speller state.");
    }

    public void startCategories(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startCategories(iPoiSpellerModelAccess);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#startCategories()", (Object)this.getStringId());
        throw new UnsupportedOperationException("Cannot start a Categories Sequence from the current speller state.");
    }

    public void startResultsSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, int n) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startResultsSequence(iPoiSpellerModelAccess, n);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#startResultsSequence()", (Object)this.getStringId());
        throw new UnsupportedOperationException("Cannot start a Results Sequence from the current speller state.");
    }

    public void startSubstringSearch(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startSubstringSearch(iPoiSpellerModelAccess);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#startSubstringSearch()", (Object)this.getStringId());
        throw new UnsupportedOperationException("Cannot start a Substring Search Sequence from the current speller state.");
    }

    public void startBrands(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startBrands(iPoiSpellerModelAccess);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#startBrands()", (Object)this.getStringId());
        throw new UnsupportedOperationException("Cannot start brands sequence from the current speller state.");
    }

    public void startGuidance(IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
        this.startGuidance(null, iStartGuidanceToDestinationSequence);
    }

    public void startGuidance(ILocationHandler iLocationHandler, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startGuidance(iLocationHandler, iStartGuidanceToDestinationSequence);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#startGuidance()", (Object)this.getStringId());
        throw new UnsupportedOperationException("Cannot start guidance from the current speller state.");
    }

    public void startGuidanceToSingleDestination(IRouteManager iRouteManager) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startGuidanceToSingleDestination(iRouteManager);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#startGuidanceToSingleDestination()", (Object)this.getStringId());
        throw new UnsupportedOperationException("Cannot start guidance from the current speller state.");
    }

    public void startParentChild(IPoiSpellerModelAccess iPoiSpellerModelAccess, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startParentChild(iPoiSpellerModelAccess, iStartGuidanceToDestinationSequence);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#startParentChild()", (Object)this.getStringId());
        throw new UnsupportedOperationException("Cannot start parent child from the current speller state.");
    }

    public void retrieveNavLocation(GuiModelAccessDetailsNavi guiModelAccessDetailsNavi) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.retrieveNavLocation(guiModelAccessDetailsNavi);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#retrieveNavLocation()", (Object)this.getStringId());
        throw new UnsupportedOperationException("Cannot retrieve location from the current speller state.");
    }

    public void selectListElement(LIValueListElement lIValueListElement) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.selectListElement(lIValueListElement);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#selectListElement( %2 )", (Object)this.getStringId(), (Object)lIValueListElement);
        this.selectedElement = lIValueListElement;
    }

    public void requestNextResultListWindow(int n) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.requestNextResultListWindow(n);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#requestNextResultListWindow()", (Object)this.getStringId());
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPRequestValueListByListIndexCommand(n, true));
        if (this.modelAccess != null) {
            commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        }
        commandList.execute(this.getStringId() + "AbstractPoiSequence#requestNextResultListWindows");
    }

    public void requestNextResultListWindow(int n, int n2, int n3) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.requestNextResultListWindow(n, n2, n3);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#requestNextResultListWindow()", (Object)this.getStringId());
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPRequestValueListByListIndexCommand(n, true));
        if (this.modelAccess != null) {
            commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess, n3, n));
        }
        commandList.execute(this.getStringId() + "AbstractPoiSequence#requestNextResultListWindows");
    }

    public void requestPreviousResultListWindow(int n) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.requestPreviousResultListWindow(n);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#requestPreviousResultListWindow()", (Object)this.getStringId());
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPRequestValueListByListIndexCommand(n, false));
        if (this.modelAccess != null) {
            commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        }
        commandList.execute(this.getStringId() + "AbstractPoiSequence#requestPreviousResultListWindow");
    }

    public void setInput(String string) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.setInput(string);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#setInput()", (Object)this.getStringId());
        throw new UnsupportedOperationException("Cannot set input from the current speller state.");
    }

    public void unrequestItems(int n, int n2) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.unrequestItems(n, n2);
            return;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new UnrequestItemsCommand(n, n2, this.modelAccess));
        commandList.execute("AbstractPoiSequence#unrequestItems");
    }

    public void restore() {
        if (this.hasActiveSubSequence()) {
            boolean bl = this.currentInputSequence.hasActiveSubSequence();
            this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#restore() - has no children ", (Object)this.getStringId());
            this.currentInputSequence.restore();
            if (!bl) {
                this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#restore() - had no children ", (Object)this.getStringId());
                this.currentInputSequence = null;
            }
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#restore() ", (Object)this.getStringId());
        CommandList commandList = this.createRestoreToPreviousState();
        if (commandList == null) {
            return;
        }
        commandList.execute(this.getStringId() + "AbstractPoiSequence#restoreToPreviousState");
    }

    public CommandList createRestoreCommandList() {
        return null;
    }

    public boolean hasActiveSubSequence() {
        return this.currentInputSequence != null;
    }

    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.updatePoiSubstringSearchStatus(valueListStatus);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#updatePoiSubstringSearchStatus() - ignored", (Object)this.getStringId());
    }

    public void showLocationInPreviewMap(final IPreviewMap iPreviewMap, LIValueListElement lIValueListElement) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.showLocationInPreviewMap(iPreviewMap, lIValueListElement);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#showLocationInPreviewMap()", (Object)this.getStringId());
        if (iPreviewMap != null && lIValueListElement != null) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
            commandList.add(new NavCommand(){

                public void execute() {
                    iPreviewMap.setPreviewPOIsOnboard(new NavLocation[]{this.dsiResponseContainer.getSelectedLocation()}, 1, null, null);
                    this.getCommandList().commandFinished();
                }
            });
            commandList.execute("AbstractPoiSequence#showLocationInPreviewMap");
        }
    }

    public CommandList createRestoreToPreviousState() {
        if (this.initialSpellerState == null) {
            this.env.getLogChannel().log(100000, "[PoiInput] AbstractPoiSequence( %1 )#Invalid sequence state - spellerState is null.", (Object)this.getStringId());
            return null;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIRestoreStateCommand(this.initialSpellerState));
        if (this.modelAccess != null) {
            commandList.add(new ModelUpdateRestoreCommand(this.modelAccess));
        }
        return commandList;
    }

    protected abstract int getSortOrder();

    protected abstract String getStringId();
}

