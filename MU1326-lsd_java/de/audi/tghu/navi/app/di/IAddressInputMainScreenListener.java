/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.di.IAddressInputListener;
import org.dsi.ifc.global.NavLocation;

public interface IAddressInputMainScreenListener
extends IAddressInputListener {
    default public CommandList getStartCommandList(NavLocation navLocation) {
    }

    default public CommandList getStartCommandListForOnline() {
    }

    default public CommandList getStartCommandListForOnline(NavLocation navLocation) {
    }

    default public void resetPreviousLocation() {
    }
}

