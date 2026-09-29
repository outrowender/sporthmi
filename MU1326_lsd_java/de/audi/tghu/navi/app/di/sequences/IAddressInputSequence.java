/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences;

import de.audi.tghu.command.CommandList;
import org.dsi.ifc.navigation.LIValueListElement;

public interface IAddressInputSequence {
    public static final String LOCATION_TO_TEST;

    default public CommandList getStartCommandList() {
    }

    default public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
    }

    default public CommandList getSelectElementByIdentifierCommandList(String string) {
    }
}

