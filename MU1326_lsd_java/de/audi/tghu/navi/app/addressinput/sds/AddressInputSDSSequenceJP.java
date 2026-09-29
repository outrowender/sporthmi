/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.housenumber.HousenumberMatchspellerInputSequence;
import de.audi.tghu.navi.app.addressinput.housenumber.HousenumberMatchspellerInputSimpleSequence;
import de.audi.tghu.navi.app.addressinput.housenumber.HousenumberMatchspellerInputSimpleSequenceSdsJpKr;
import de.audi.tghu.navi.app.addressinput.sds.AddressInputSDSSequence;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputSDSSequenceJP
extends AddressInputSDSSequence {
    public AddressInputSDSSequenceJP(SpellerStack spellerStack, ICommandListFactory iCommandListFactory, CityHistory cityHistory, LogChannel logChannel, IPreviewMap iPreviewMap, IAddressInputForm iAddressInputForm, NavigationEnv navigationEnv) {
        super(spellerStack, iCommandListFactory, cityHistory, logChannel, iPreviewMap, iAddressInputForm, navigationEnv);
    }

    @Override
    public void setHouseNumber(IMatchspellerModelAccess iMatchspellerModelAccess, String string, String string2, NaviServiceListener naviServiceListener) {
        HousenumberMatchspellerInputSimpleSequence housenumberMatchspellerInputSimpleSequence = this.env.getContainer().selectionCriterionAvailable(154) ? new HousenumberMatchspellerInputSimpleSequenceSdsJpKr(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.previewMap, this.addressInputService) : new HousenumberMatchspellerInputSequence(iMatchspellerModelAccess, this.spellerStack, this.commandListFactory, this.previewMap, this.addressInputService);
        CommandList commandList = this.getSetSDSInputCommandList(housenumberMatchspellerInputSimpleSequence, string, string2, naviServiceListener);
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#setHouseNumber").toString());
    }
}

