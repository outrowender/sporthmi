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
    default public void start(NavLocation navLocation) {
    }

    default public void start(ILocationHandler iLocationHandler, NavLocation navLocation) {
    }

    default public void start(Route route) {
    }

    default public CommandList getStartSequence(Route route) {
    }

    default public void start(NavSegmentID navSegmentID) {
    }

    default public CommandList getStartSequence(NavSegmentID navSegmentID) {
    }

    default public void start(NavLocation navLocation, boolean bl) {
    }

    default public CommandList getStartSequence(NavLocation navLocation) {
    }

    default public CommandList getStartSequence(ILocationHandler iLocationHandler, NavLocation navLocation) {
    }

    default public CommandList getStartSequence(NavLocation navLocation, boolean bl) {
    }

    default public CommandList getStartSequenceForKombi(NavLocation navLocation, boolean bl) {
    }

    default public CommandList getStartSequence(ILocationHandler iLocationHandler, NavLocation navLocation, boolean bl, boolean bl2) {
    }

    default public CommandList getOffroadStartSequence(NavLocation navLocation, boolean bl, int n) {
    }

    default public void startOffroad(NavLocation navLocation, boolean bl, int n) {
    }
}

