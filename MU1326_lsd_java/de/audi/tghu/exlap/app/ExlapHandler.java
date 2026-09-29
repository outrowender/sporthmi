/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.app;

import de.audi.tghu.exlap.ExlapStatusHandler;
import de.audi.tghu.exlap.app.ExlapExlapServiceImpl;
import org.dsi.ifc.exlap.DSIExlap;
import org.dsi.ifc.exlap.DSIExlapListener;
import org.dsi.ifc.has.DSIHAS;
import org.dsi.ifc.has.DSIHASListener;

public interface ExlapHandler
extends DSIHASListener,
DSIExlapListener,
ExlapStatusHandler {
    default public void init(DSIHAS dSIHAS, DSIExlap dSIExlap, ExlapExlapServiceImpl exlapExlapServiceImpl) {
    }

    default public void deinit() {
    }
}

