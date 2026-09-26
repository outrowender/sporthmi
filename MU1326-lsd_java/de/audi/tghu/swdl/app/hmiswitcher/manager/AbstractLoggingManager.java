/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.ILoggingManager;

public abstract class AbstractLoggingManager
extends AbstractManager
implements ILoggingManager {
    protected AbstractLoggingManager(SwdlEnv swdlEnv, AbstractPopupManager abstractPopupManager) {
        super(swdlEnv, abstractPopupManager);
    }
}

