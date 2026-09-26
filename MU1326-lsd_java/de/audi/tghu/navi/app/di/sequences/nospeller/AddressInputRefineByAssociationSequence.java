/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.nospeller;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.nospeller.AbstractAddressInputNoSpellerSequence;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputRefineByAssociationSequence
extends AbstractAddressInputNoSpellerSequence {
    public AddressInputRefineByAssociationSequence(int n, IAddressInputManager iAddressInputManager, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack) {
        super(n, iAddressInputManager, iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack);
    }
}

