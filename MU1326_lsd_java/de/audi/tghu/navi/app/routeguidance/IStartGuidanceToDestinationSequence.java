/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.routeguidance.ILocationHandler;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.Route;

public interface IStartGuidanceToDestinationSequence {
    public void start(NavLocation var1);

    public void start(ILocationHandler var1, NavLocation var2);

    public void start(Route var1);

    public CommandList getStartSequence(Route var1);

    public void start(NavSegmentID var1);

    public CommandList getStartSequence(NavSegmentID var1);

    public void start(NavLocation var1, boolean var2);

    public CommandList getStartSequence(NavLocation var1);

    public CommandList getStartSequence(ILocationHandler var1, NavLocation var2);

    public CommandList getStartSequence(NavLocation var1, boolean var2);

    public CommandList getStartSequenceForKombi(NavLocation var1, boolean var2);

    public CommandList getStartSequence(ILocationHandler var1, NavLocation var2, boolean var3, boolean var4);

    public CommandList getOffroadStartSequence(NavLocation var1, boolean var2, int var3);

    public void startOffroad(NavLocation var1, boolean var2, int var3);
}

