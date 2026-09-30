/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.command.CommandList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.Route;

public interface IStartGuidanceManager {
    public void startGuidance(NavLocation var1, int var2, boolean var3, boolean var4);

    public void startGuidance();

    public void stopRouteGuidance();

    public void startRouteGuidanceToOffroadDestination(NavLocation var1, int var2);

    public void startRouteGuidanceToSingleDestination(NavLocation var1);

    public void startGuidanceWithAddedStopOver(NavLocation var1, int var2);

    public void startGuidanceWithReplacedDestination(NavLocation var1, int var2);

    public void calculateAlternativeRoutes();

    public void startGuidanceToCalculatedRoute(int var1);

    public void restartRouteGuidance(boolean var1);

    public void restartRouteGuidance(boolean var1, boolean var2);

    public void restartRouteGuidance(boolean var1, Route var2);

    public void insertAsStopOver(NavLocation var1, int var2, boolean var3);

    public boolean resumeRouteGuidance();

    public CommandList getStartGuidanceSequence();

    public CommandList getStartGuidanceSequence(boolean var1);

    public CommandList getStartGuidance(NavLocation var1, int var2, boolean var3, boolean var4);

    public CommandList getStopRouteGuidanceSequence();

    public CommandList getStartRouteGuidanceToOffroadDestinationSequence(NavLocation var1, int var2);

    public CommandList getStartRouteGuidanceToSingleDestinationSequence(NavLocation var1);

    public CommandList getStartGuidanceBySegmendIDSequence(NavSegmentID var1, boolean var2);

    public CommandList getStartGuidanceByRouteSequence(Route var1);

    public CommandList getStartRouteGuidanceToSingleDestinationSequence(NavLocation var1, boolean var2);

    public CommandList getStartRouteGuidanceToSingleDestinationSequenceFromKombi(NavLocation var1, boolean var2);

    public CommandList getStartGuidanceWithAddedStopOverSequence(NavLocation var1, int var2);

    public CommandList getStartGuidanceWithReplacedDestinationSequence(NavLocation var1, int var2);

    public CommandList getRestartRouteGuidanceCommandList(boolean var1);

    public CommandList getRestartRouteGuidanceCommandList(boolean var1, Route var2);

    public CommandList getRestartRouteGuidanceCommandList(boolean var1, boolean var2);

    public CommandList getInsertAsStopOverCommandList(NavLocation var1, int var2, boolean var3, boolean var4);

    public CommandList evaluateGuidanceStatus();
}

