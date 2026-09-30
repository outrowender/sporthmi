/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search.countryselection;

import de.audi.app.navi.evo.search.countryselection.CountrySelectionView;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.FillListByCompleteSpellerResultCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.audi.tghu.navi.app.search.AbstractCountrySelection;
import de.audi.tghu.navi.app.search.ICountrySelectionView;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.navigation.LIValueListElement;

public class CountrySelection
extends AbstractCountrySelection {
    protected LogChannel logChannel;
    private final NavigationEnv env;

    public CountrySelection(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IconHandler iconHandler) {
        super(navigationEnv, iCommandListFactory);
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getSearchLogChannel();
        this.countrySelectionView = new CountrySelectionView(navigationEnv.getBaseListModel(401879), navigationEnv, iconHandler);
    }

    public void loadCountriesFromNavigation() {
        final ICountrySelectionView iCountrySelectionView = this.countrySelectionView;
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetStateCommand(SpellerStack.getInstance(), new SpellerContext(-1)));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new FillListByCompleteSpellerResultCommand(this.env.getListModel(400417), 1, true, true, true));
        commandList.add(new NavCommand("CountrySelection#FillTheListViewWithCountries"){

            public void execute() {
                CountrySelection.this.logChannel.log(10000000, "CountrySelection#FillTheListViewWithCountries liValueList: %1", (Object)Converter.array2String((LIValueListElement[])this.getCommandList().get("countries")));
                iCountrySelectionView.updateCountriesList((LIValueListElement[])this.getCommandList().get("countries"));
                CountrySelection.this.loadPersistentState();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand("CountrySelection#loadCountries - restore locationDescription for SouthSide"){

            public void execute() {
                this.getCommandList().commandFinishedWithPostCommand(new LIRestoreStateCommand(SpellerStack.getInstance().pop().spellerData));
            }
        });
        commandList.add(new LISPCancelSpellerCommand());
        commandList.execute("CountrySelection#FillCountrySelectionListCommandList");
    }
}

