/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.command.CommandList;
import org.dsi.ifc.global.NavLocation;

public interface AddSelectedDestinationAtIndexCommandListCreator {
    public CommandList createAddSelectedDestinationAtIndexCommandList(int var1, boolean var2);

    public void addAsStopOver(NavLocation var1, int var2, boolean var3, CommandList var4);

    public void addAsStopOver(NavLocation var1, int var2, boolean var3, boolean var4, CommandList var5);
}

