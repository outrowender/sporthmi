/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.command.CommandList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.Route;

public interface IStartGuidanceManager {
    default public void startGuidance(NavLocation navLocation, int n, boolean bl, boolean bl2) {
    }

    default public void startGuidance() {
    }

    default public void stopRouteGuidance() {
    }

    default public void startRouteGuidanceToOffroadDestination(NavLocation navLocation, int n) {
    }

    default public void startRouteGuidanceToSingleDestination(NavLocation navLocation) {
    }

    default public void startGuidanceWithAddedStopOver(NavLocation navLocation, int n) {
    }

    default public void startGuidanceWithReplacedDestination(NavLocation navLocation, int n) {
    }

    default public void calculateAlternativeRoutes() {
    }

    default public void startGuidanceToCalculatedRoute(int n) {
    }

    default public void restartRouteGuidance(boolean bl) {
    }

    default public void restartRouteGuidance(boolean bl, boolean bl2) {
    }

    default public void restartRouteGuidance(boolean bl, Route route) {
    }

    default public void insertAsStopOver(NavLocation navLocation, int n, boolean bl) {
    }

    default public boolean resumeRouteGuidance() {
    }

    default public CommandList getStartGuidanceSequence() {
    }

    default public CommandList getStartGuidanceSequence(boolean bl) {
    }

    default public CommandList getStartGuidance(NavLocation navLocation, int n, boolean bl, boolean bl2) {
    }

    default public CommandList getStopRouteGuidanceSequence() {
    }

    default public CommandList getStartRouteGuidanceToOffroadDestinationSequence(NavLocation navLocation, int n) {
    }

    default public CommandList getStartRouteGuidanceToSingleDestinationSequence(NavLocation navLocation) {
    }

    default public CommandList getStartGuidanceBySegmendIDSequence(NavSegmentID navSegmentID, boolean bl) {
    }

    default public CommandList getStartGuidanceByRouteSequence(Route route) {
    }

    default public CommandList getStartRouteGuidanceToSingleDestinationSequence(NavLocation navLocation, boolean bl) {
    }

    default public CommandList getStartRouteGuidanceToSingleDestinationSequenceFromKombi(NavLocation navLocation, boolean bl) {
    }

    default public CommandList getStartGuidanceWithAddedStopOverSequence(NavLocation navLocation, int n) {
    }

    default public CommandList getStartGuidanceWithReplacedDestinationSequence(NavLocation navLocation, int n) {
    }

    default public CommandList getRestartRouteGuidanceCommandList(boolean bl) {
    }

    default public CommandList getRestartRouteGuidanceCommandList(boolean bl, Route route) {
    }

    default public CommandList getRestartRouteGuidanceCommandList(boolean bl, boolean bl2) {
    }

    default public CommandList getInsertAsStopOverCommandList(NavLocation navLocation, int n, boolean bl, boolean bl2) {
    }

    default public CommandList evaluateGuidanceStatus() {
    }
}

