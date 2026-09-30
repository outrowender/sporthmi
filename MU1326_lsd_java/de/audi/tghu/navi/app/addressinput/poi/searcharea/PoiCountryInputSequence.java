/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.searcharea;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.country.CountryInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.IPoiSearchAreaModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiCountryInputSequence
extends CountryInputSequence {
    private final PoiSearchArea poiSearchArea;
    private final IPoiSearchAreaModelAccess searchMainModelAccess;

    public PoiCountryInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, IPoiSearchAreaModelAccess iPoiSearchAreaModelAccess, SpellerStack spellerStack, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, IAddressInputForm iAddressInputForm, IPreviewMap iPreviewMap, NavigationEnv navigationEnv) {
        super(iMatchspellerModelAccess, spellerStack, iCommandListFactory, iAddressInputForm, iPreviewMap, navigationEnv);
        this.poiSearchArea = poiSearchArea;
        this.searchMainModelAccess = iPoiSearchAreaModelAccess;
    }

    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement, boolean bl) {
        CommandList commandList = super.getSelectListElementCommandList(lIValueListElement, bl);
        commandList.add(new NavCommand(){

            public void execute() {
                PoiCountryInputSequence.this.poiSearchArea.setLocation(this.dsiResponseContainer.getLiCurrentLD());
                PoiCountryInputSequence.this.poiSearchArea.setSearchContext(5);
                PoiCountryInputSequence.this.searchMainModelAccess.onUpdateHistoryList();
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    public void selectListElement(LIValueListElement lIValueListElement, boolean bl) {
        this.getSelectListElementCommandList(lIValueListElement, bl).execute("PoiCountryInputSequence#selectListElement");
    }

    public void selectElementByIdentifier(String string) {
        CommandList commandList = super.getSelectElementByIdentifierCommandList(string);
        commandList.add(new NavCommand(){

            public void execute() {
                PoiCountryInputSequence.this.poiSearchArea.setLocation(this.dsiResponseContainer.getLiCurrentLD());
                PoiCountryInputSequence.this.poiSearchArea.setSearchContext(5);
                PoiCountryInputSequence.this.searchMainModelAccess.onUpdateHistoryList();
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("PoiCountryInputSequence#selectElementByIdentifier");
    }

    public void addCharacter(String string, int n, boolean bl) {
    }
}

