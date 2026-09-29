/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search.countryselection;

import de.audi.app.navi.evo.search.countryselection.CountrySelection$1;
import de.audi.app.navi.evo.search.countryselection.CountrySelection$2;
import de.audi.app.navi.evo.search.countryselection.CountrySelectionView;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.FillListByCompleteSpellerResultCommand;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.search.AbstractCountrySelection;
import de.audi.tghu.navi.app.search.ICountrySelectionView;

public class CountrySelection
extends AbstractCountrySelection {
    protected LogChannel logChannel;
    private final NavigationEnv env;

    public CountrySelection(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IconHandler iconHandler) {
        super(navigationEnv, iCommandListFactory);
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getSearchLogChannel();
        this.countrySelectionView = new CountrySelectionView(navigationEnv.getBaseListModel(-685701632), navigationEnv, iconHandler);
    }

    @Override
    public void loadCountriesFromNavigation() {
        ICountrySelectionView iCountrySelectionView = this.countrySelectionView;
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetStateCommand(SpellerStack.getInstance(), new SpellerContext(-1)));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new FillListByCompleteSpellerResultCommand(this.env.getListModel(555484672), 1, true, true, true));
        commandList.add(new CountrySelection$1(this, "CountrySelection#FillTheListViewWithCountries", iCountrySelectionView));
        commandList.add(new CountrySelection$2(this, "CountrySelection#loadCountries - restore locationDescription for SouthSide"));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.execute("CountrySelection#FillCountrySelectionListCommandList");
    }
}

