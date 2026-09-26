/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.hmi.KbdService;
import de.audi.atip.statemachine.sds.TTSASR;

public interface SMServices {
    default public KbdService getKeyboardService() {
    }

    default public TTSASR getSDSService() {
    }

    default public void showPartialPopup(int n) {
    }

    default public void hidePartialPopup(int n) {
    }

    default public void enterJointUse(int n, int n2) {
    }

    default public void leaveJointUse(int n, int n2) {
    }

    default public int getJointUseCount() {
    }

    default public void setJumpBackPoint(int n) {
    }

    default public void addContext(long l) {
    }

    default public void removeContext(long l) {
    }

    default public void pushDrawerIDs(long l, long l2) {
    }

    default public void popDrawerIDs() {
    }

    default public void addScreenAnimation(int n) {
    }

    default public void setColor(int n) {
    }

    default public void setScreenMode(int n) {
    }
}

