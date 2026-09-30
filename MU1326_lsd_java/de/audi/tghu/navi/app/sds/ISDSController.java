/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.tghu.navi.app.INaviComponent;
import de.audi.tghu.navi.app.sds.ISDSStateEventsProvider;

public interface ISDSController
extends ISDSStateEventsProvider,
INaviComponent {
    public void abortSDSSession(boolean var1);

    public void notifyAbort();

    public boolean isSDSActive();

    public void itemSelected(int var1, int var2);

    public void keyTyped(int var1);
}

