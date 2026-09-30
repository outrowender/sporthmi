/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.mer;

import de.audi.app.car.common.mer.MenuEntry;
import de.audi.app.car.evo.mer.CarEvoMenuEntryIDs;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import java.util.HashMap;

public class CarEvoMenuEntryStructureGenerated
implements CarEvoMenuEntryIDs {
    protected static void addStructure(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, HashMap hashMap) {
        MenuEntry menuEntry = (MenuEntry)hashMap.get(new Integer(600161));
        MenuEntry menuEntry2 = (MenuEntry)hashMap.get(new Integer(600162));
        MenuEntry menuEntry3 = (MenuEntry)hashMap.get(new Integer(600166));
        MenuEntry menuEntry4 = (MenuEntry)hashMap.get(new Integer(600164));
        MenuEntry menuEntry5 = (MenuEntry)hashMap.get(new Integer(600614));
        MenuEntry menuEntry6 = new MenuEntry(600162, "DRIVE_ASSIST_HUD", 600919, iFrameworkAccess, logChannel);
        hashMap.put(new Integer(600103), menuEntry6);
        menuEntry2.setChildren(new MenuEntry[]{menuEntry6});
    }

    protected static String getVersion() {
        return "0.0 alpha";
    }
}

