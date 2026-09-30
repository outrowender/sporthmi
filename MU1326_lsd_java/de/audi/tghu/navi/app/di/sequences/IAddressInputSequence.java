/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences;

import de.audi.tghu.command.CommandList;
import org.dsi.ifc.navigation.LIValueListElement;

public interface IAddressInputSequence {
    public static final String LOCATION_TO_TEST = "LocationToTest";

    public CommandList getStartCommandList();

    public CommandList getSelectListElementCommandList(LIValueListElement var1);

    public CommandList getSelectElementByIdentifierCommandList(String var1);
}

