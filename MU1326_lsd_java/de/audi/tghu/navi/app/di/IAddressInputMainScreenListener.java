/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.di.IAddressInputListener;
import org.dsi.ifc.global.NavLocation;

public interface IAddressInputMainScreenListener
extends IAddressInputListener {
    public CommandList getStartCommandList(NavLocation var1);

    public CommandList getStartCommandListForOnline();

    public CommandList getStartCommandListForOnline(NavLocation var1);

    public void resetPreviousLocation();
}

