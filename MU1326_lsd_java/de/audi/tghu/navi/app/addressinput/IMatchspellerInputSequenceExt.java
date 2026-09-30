/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequence;
import org.dsi.ifc.navigation.LIValueListElement;

public interface IMatchspellerInputSequenceExt
extends IMatchspellerInputSequence {
    public CommandList createStartCommandList(boolean var1);

    public CommandList getSelectListElementCommandList(LIValueListElement var1, boolean var2);

    public CommandList getSelectElementByIdentifierCommandList(String var1);
}

