/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.mer;

import de.audi.app.car.common.mer.AbstractMenuEntryFactory;
import de.audi.app.car.evo.mer.MenuEntryMMICombi;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import java.util.HashMap;

public class EvoMenuEntryFactory
extends AbstractMenuEntryFactory {
    public EvoMenuEntryFactory(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, HashMap hashMap) {
        super(iFrameworkAccess, logChannel, hashMap);
    }

    public MenuEntryMMICombi createMMICombiMenuEntry(int n, String string, int n2) {
        MenuEntryMMICombi menuEntryMMICombi = new MenuEntryMMICombi(n, string, this.getFrameworkAccess(), this.getLogChannel(), n2);
        this.getMenuEntries().put(new Integer(n), menuEntryMMICombi);
        return menuEntryMMICombi;
    }
}

