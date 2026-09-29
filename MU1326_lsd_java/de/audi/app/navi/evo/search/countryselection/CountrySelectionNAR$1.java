/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search.countryselection;

import de.audi.app.navi.evo.search.countryselection.CountrySelectionNAR;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.search.ICountrySelectionView;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.navigation.LIValueListElement;

class CountrySelectionNAR$1
extends NavCommand {
    private final /* synthetic */ ICountrySelectionView val$view;
    private final /* synthetic */ CountrySelectionNAR this$0;

    CountrySelectionNAR$1(CountrySelectionNAR countrySelectionNAR, String string, ICountrySelectionView iCountrySelectionView) {
        this.this$0 = countrySelectionNAR;
        this.val$view = iCountrySelectionView;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.logChannel.log(-2137614336, "CountrySelection#FillTheListViewWithCountries liValueList: %1", (Object)Converter.array2String((LIValueListElement[])this.getCommandList().get("countries")));
        this.val$view.updateCountriesList((LIValueListElement[])this.getCommandList().get("countries"));
        this.this$0.loadPersistentState();
        this.getCommandList().commandFinished();
    }
}

