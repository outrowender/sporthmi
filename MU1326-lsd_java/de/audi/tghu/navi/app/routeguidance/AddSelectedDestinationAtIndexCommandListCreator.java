/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.command.CommandList;
import org.dsi.ifc.global.NavLocation;

public interface AddSelectedDestinationAtIndexCommandListCreator {
    default public CommandList createAddSelectedDestinationAtIndexCommandList(int n, boolean bl) {
    }

    default public void addAsStopOver(NavLocation navLocation, int n, boolean bl, CommandList commandList) {
    }

    default public void addAsStopOver(NavLocation navLocation, int n, boolean bl, boolean bl2, CommandList commandList) {
    }
}

