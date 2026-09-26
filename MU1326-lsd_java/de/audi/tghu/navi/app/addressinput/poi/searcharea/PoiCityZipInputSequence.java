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
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiCityZipInputSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
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

    @Override
    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new PoiCityZipInputSequence$1(this));
        commandList.add(new AddCityToHistoryCommand(this.cityHistory));
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(this.restartPoiMainScreen);
        return commandList;
    }

    @Override
    public void selectListElement(LIValueListElement lIValueListElement, boolean bl) {
        this.getSelectListElementCommandList(lIValueListElement, bl).execute("PoiCityZipInputSequence#selectListElement");
    }

    @Override
    public void start(boolean bl) {
        this.cityInputSequence.start(bl);
    }

    @Override
    public void requestNextResultListWindow(int n, int n2) {
        this.cityInputSequence.requestNextResultListWindow(n, n2);
    }

    @Override
    public void requestPreviousResultListWindow(int n) {
        this.cityInputSequence.requestPreviousResultListWindow(n);
    }

    @Override
    public void addCharacter(String string) {
        this.cityInputSequence.addCharacter(string);
    }

    @Override
    public void undoCharacter() {
        this.cityInputSequence.undoCharacter();
    }

    @Override
    public void deleteAllCharacters() {
        this.cityInputSequence.deleteAllCharacters();
    }

    @Override
    public void restore() {
        this.cityInputSequence.restore();
    }

    @Override
    public CommandList createRestoreCommandList() {
        return this.cityInputSequence.createRestoreCommandList();
    }

    @Override
    public boolean hasActiveSubSequence() {
        return this.cityInputSequence.hasActiveSubSequence();
    }

    @Override
    public void showLocationInPreviewMap(IPreviewMap iPreviewMap, LIValueListElement lIValueListElement) {
        this.cityInputSequence.showLocationInPreviewMap(iPreviewMap, lIValueListElement);
    }

    @Override
    public void selectElementByIdentifier(String string) {
        this.cityInputSequence.selectElementByIdentifier(string);
    }

    @Override
    public void unrequestItems(int n, int n2) {
        this.cityInputSequence.unrequestItems(n, n2);
    }

    @Override
    public void addCharacter(String string, int n, boolean bl) {
    }

    static /* synthetic */ PoiSearchArea access$000(PoiCityZipInputSequence poiCityZipInputSequence) {
        return poiCityZipInputSequence.searchArea;
    }

    static /* synthetic */ IPoiSearchAreaModelAccess access$100(PoiCityZipInputSequence poiCityZipInputSequence) {
        return poiCityZipInputSequence.searchMainModelAccess;
    }
}

