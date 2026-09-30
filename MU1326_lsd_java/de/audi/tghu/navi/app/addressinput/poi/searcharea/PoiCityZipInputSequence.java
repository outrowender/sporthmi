/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.searcharea;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequence;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.city.CityZipInputSequence;
import de.audi.tghu.navi.app.addressinput.commands.AddCityToHistoryCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelSelectListElementCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.IPoiSearchAreaModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiCityZipInputSequence
implements IMatchspellerInputSequence {
    private final PoiSearchArea searchArea;
    private final CommandList restartPoiMainScreen;
    private final IPoiSearchAreaModelAccess searchMainModelAccess;
    private final ICommandListFactory commandListFactory;
    private final CityZipInputSequence cityInputSequence;
    private final CityHistory cityHistory;
    private final IMatchspellerModelAccess modelAccess;

    public PoiCityZipInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, IPoiSearchAreaModelAccess iPoiSearchAreaModelAccess, SpellerStack spellerStack, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, CityHistory cityHistory, CommandList commandList, IPreviewMap iPreviewMap, IAddressInputForm iAddressInputForm) {
        this.commandListFactory = iCommandListFactory;
        this.searchArea = poiSearchArea;
        this.restartPoiMainScreen = commandList;
        this.searchMainModelAccess = iPoiSearchAreaModelAccess;
        this.modelAccess = iMatchspellerModelAccess;
        this.cityHistory = cityHistory;
        this.cityInputSequence = new CityZipInputSequence(iMatchspellerModelAccess, spellerStack, iCommandListFactory, cityHistory, iPreviewMap, iAddressInputForm);
    }

    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new NavCommand(){

            public void execute() {
                PoiCityZipInputSequence.this.searchArea.setSearchContext(4);
                PoiCityZipInputSequence.this.searchArea.setLocation(this.dsiResponseContainer.getLiCurrentLD());
                PoiCityZipInputSequence.this.searchMainModelAccess.onUpdateSearchArea(PoiCityZipInputSequence.this.searchArea);
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new AddCityToHistoryCommand(this.cityHistory));
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(this.restartPoiMainScreen);
        return commandList;
    }

    public void selectListElement(LIValueListElement lIValueListElement, boolean bl) {
        this.getSelectListElementCommandList(lIValueListElement, bl).execute("PoiCityZipInputSequence#selectListElement");
    }

    public void start(boolean bl) {
        this.cityInputSequence.start(bl);
    }

    public void requestNextResultListWindow(int n, int n2) {
        this.cityInputSequence.requestNextResultListWindow(n, n2);
    }

    public void requestPreviousResultListWindow(int n) {
        this.cityInputSequence.requestPreviousResultListWindow(n);
    }

    public void addCharacter(String string) {
        this.cityInputSequence.addCharacter(string);
    }

    public void undoCharacter() {
        this.cityInputSequence.undoCharacter();
    }

    public void deleteAllCharacters() {
        this.cityInputSequence.deleteAllCharacters();
    }

    public void restore() {
        this.cityInputSequence.restore();
    }

    public CommandList createRestoreCommandList() {
        return this.cityInputSequence.createRestoreCommandList();
    }

    public boolean hasActiveSubSequence() {
        return this.cityInputSequence.hasActiveSubSequence();
    }

    public void showLocationInPreviewMap(IPreviewMap iPreviewMap, LIValueListElement lIValueListElement) {
        this.cityInputSequence.showLocationInPreviewMap(iPreviewMap, lIValueListElement);
    }

    public void selectElementByIdentifier(String string) {
        this.cityInputSequence.selectElementByIdentifier(string);
    }

    public void unrequestItems(int n, int n2) {
        this.cityInputSequence.unrequestItems(n, n2);
    }

    public void addCharacter(String string, int n, boolean bl) {
    }
}

