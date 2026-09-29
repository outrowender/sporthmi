/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequence;
import org.dsi.ifc.navigation.LIValueListElement;

public interface IMatchspellerInputSequenceExt
extends IMatchspellerInputSequence {
    default public CommandList createStartCommandList(boolean bl) {
    }

    @Override
    default public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement, boolean bl) {
    }

    default public CommandList getSelectElementByIdentifierCommandList(String string) {
    }
}

