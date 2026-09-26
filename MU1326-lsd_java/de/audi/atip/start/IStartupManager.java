/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.start;

import de.audi.atip.log.LogChannel;
import de.audi.atip.start.ILastmodeHandler;
import java.util.List;

public interface IStartupManager {
    default public boolean isRebootToDownload() {
    }

    default public void setNavEnabled(boolean bl) {
    }

    default public boolean isNavEnabled() {
    }

    default public void triggerNavAvailable() {
    }

    default public void triggerMapAvailable() {
    }

    default public void triggerTTSAvailable() {
    }

    default public void triggerNewScreenVisible() {
    }

    default public boolean waitForTTSAvailable() {
    }

    default public boolean waitForFirstScreen() {
    }

    default public boolean waitForKombiSync() {
    }

    default public void setRVCActive(boolean bl) {
    }

    default public void logStartupEvent(String string) {
    }

    default public void logStartupEvent(LogChannel logChannel, int n, String string) {
    }

    default public void logStartupEvent(LogChannel logChannel, int n, String string, Throwable throwable) {
    }

    default public void processHKsDuringStartup(boolean bl) {
    }

    default public void setMMIKombiLastmode(int n) {
    }

    default public void requestAppStart(int n) {
    }

    default public void requestAppStartByHMIKey(int n) {
    }

    default public void requestStartBundle(String string) {
    }

    default public void startSwDiag() {
    }

    default public boolean isStartupCompleted() {
    }

    default public boolean isSMRunning() {
    }

    default public void setFallBackScreenShown(boolean bl) {
    }

    default public void initDSI() {
    }

    default public void initSystem() {
    }

    default public void initHMI() {
    }

    default public void initModelBanks() {
    }

    default public void showFirstScreen() {
    }

    default public void postStartup() {
    }

    default public ILastmodeHandler getLastmodeHandler() {
    }

    default public void addInitialEvents(List list) {
    }

    default public void resourcesReady(int n) {
    }
}

