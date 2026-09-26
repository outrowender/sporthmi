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
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiCountryInputSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiCountryInputSequence$2;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
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

    @Override
    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement, boolean bl) {
        CommandList commandList = super.getSelectListElementCommandList(lIValueListElement, bl);
        commandList.add(new PoiCountryInputSequence$1(this));
        return commandList;
    }

    @Override
    public void selectListElement(LIValueListElement lIValueListElement, boolean bl) {
        this.getSelectListElementCommandList(lIValueListElement, bl).execute("PoiCountryInputSequence#selectListElement");
    }

    @Override
    public void selectElementByIdentifier(String string) {
        CommandList commandList = super.getSelectElementByIdentifierCommandList(string);
        commandList.add(new PoiCountryInputSequence$2(this));
        commandList.execute("PoiCountryInputSequence#selectElementByIdentifier");
    }

    @Override
    public void addCharacter(String string, int n, boolean bl) {
    }

    static /* synthetic */ PoiSearchArea access$000(PoiCountryInputSequence poiCountryInputSequence) {
        return poiCountryInputSequence.poiSearchArea;
    }

    static /* synthetic */ IPoiSearchAreaModelAccess access$100(PoiCountryInputSequence poiCountryInputSequence) {
        return poiCountryInputSequence.searchMainModelAccess;
    }
}

