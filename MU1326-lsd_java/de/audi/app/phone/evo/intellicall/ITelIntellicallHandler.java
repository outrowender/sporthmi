/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.telephoneng.CallStackEntry;

public interface ITelIntellicallHandler {
    default public void callAccepted() {
    }

    default public void callDialed() {
    }

    default public void eCallDialed() {
    }

    default public void conferenceEstablished() {
    }

    default public void dtmfEntrySelected() {
    }

    default public void dialNumber(String string, int n) {
    }

    default public void dialNumber(String string, int n, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void dialNumberFromDBEntry(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2, int n3) {
    }

    default public void dialNumberFromDBEntry(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2, int n3, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void dialNumberFromCallStackEntry(CallStackEntry callStackEntry, int n) {
    }

    default public void dialNumberFromCallStackEntry(CallStackEntry callStackEntry, int n, ITelDSIResponseListener iTelDSIResponseListener) {
    }

    default public void dialNumberFromADBEntry(AdbEntry adbEntry, int n, int n2) {
    }

    default public void dialNumberFromADBEntry(AdbEntry adbEntry, int n, int n2, ITelDSIResponseListener iTelDSIResponseListener) {
    }
}

