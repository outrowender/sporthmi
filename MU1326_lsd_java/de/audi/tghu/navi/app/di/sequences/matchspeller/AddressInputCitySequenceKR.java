/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCitySequenceJP;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputCitySequenceKR
extends AddressInputCitySequenceJP {
    public AddressInputCitySequenceKR(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager, CityHistory cityHistory) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager, cityHistory);
    }

    protected int getStripLocationType() {
        return 23;
    }

    public void requestNextResultListWindow(int n, int n2) {
        this.logChannel.log(10000000, "%1#requestNextResultListWindow(), anchorIndex = %2, requestID = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        int n3 = 0;
        String string = this.env.getContainer().getLispCurrentInput();
        if (this.cityHistory != null && this.cityHistory.getMatchingLastCities(string) != null) {
            n3 = this.cityHistory.getMatchingLastCities(string).size();
        }
        commandList.add(new LISPRequestValueListByListIndexCommand(n - n3, true));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess, n2, n));
        commandList.execute(this.CLASS_NAME + "#requestNextResultListWindows");
    }
}

