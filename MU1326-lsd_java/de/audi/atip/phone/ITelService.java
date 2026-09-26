/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.phone;

import de.audi.atip.interapp.phone.ITelCallSession;
import de.audi.atip.phone.ITelServiceListener;
import org.dsi.ifc.global.ResourceLocator;

public interface ITelService {
    default public void dialNumber(String string, ITelServiceListener iTelServiceListener, boolean bl) {
    }

    default public void dialNumberFromADBEntry(String string, String string2, short s, short s2, long l, ResourceLocator resourceLocator, int n, int n2, ITelServiceListener iTelServiceListener, boolean bl) {
    }

    default public void prepareDialing(String string, ITelServiceListener iTelServiceListener) {
    }

    default public void prepareDialing(String string, String string2, short s, short s2, long l, ResourceLocator resourceLocator, int n, int n2, ITelServiceListener iTelServiceListener) {
    }

    default public void dialNumber(ITelCallSession iTelCallSession, boolean bl) {
    }
}

