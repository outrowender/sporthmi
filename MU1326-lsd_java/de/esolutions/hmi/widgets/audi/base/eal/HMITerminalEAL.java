/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.hmi.HMITerminal;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;

public interface HMITerminalEAL
extends HMITerminal {
    default public EALManager getEALManager() {
    }

    default public StringUtility getStringUtility(IWrappedFont iWrappedFont) {
    }
}

