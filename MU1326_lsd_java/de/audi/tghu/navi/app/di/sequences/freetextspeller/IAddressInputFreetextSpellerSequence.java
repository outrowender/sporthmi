/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.freetextspeller;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.di.sequences.IAddressInputSequence;

public interface IAddressInputFreetextSpellerSequence
extends IAddressInputSequence {
    public CommandList getStartCommandList(String var1);
}

