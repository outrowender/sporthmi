/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.asia;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.asia.AbstractMatchspellerInputSequenceAsia;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;

public class VillageAndStreetInputSequence
extends AbstractMatchspellerInputSequenceAsia {
    public VillageAndStreetInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, SpellerStack spellerStack, ICommandListFactory iCommandListFactory, IAddressInputForm iAddressInputForm, IPreviewMap iPreviewMap) {
        super(iMatchspellerModelAccess, spellerStack, iCommandListFactory, iAddressInputForm, iPreviewMap);
    }

    @Override
    protected NavCommand getStartSpellerCommand() {
        return new LIStartSpellerCommand(151, false, false, false);
    }
}

