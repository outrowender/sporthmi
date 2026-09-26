/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.tghu.navi.app.INaviComponent;
import de.audi.tghu.navi.app.sds.ISDSStateEventsProvider;

public interface ISDSController
extends ISDSStateEventsProvider,
INaviComponent {
    default public void abortSDSSession(boolean bl) {
    }

    default public void notifyAbort() {
    }

    default public boolean isSDSActive() {
    }

    default public void itemSelected(int n, int n2) {
    }

    default public void keyTyped(int n) {
    }
}

