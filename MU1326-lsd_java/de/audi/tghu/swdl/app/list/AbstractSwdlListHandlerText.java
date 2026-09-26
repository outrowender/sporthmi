/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.tghu.swdl.app.AbstractSwdlTextFactory;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.list.AbstractSwdlListHandler;

public abstract class AbstractSwdlListHandlerText
extends AbstractSwdlListHandler {
    private final AbstractSwdlTextFactory swdlTextFactory;

    public AbstractSwdlListHandlerText(SwdlEnv swdlEnv, ListModelApp listModelApp, int n, int n2) {
        super(swdlEnv, listModelApp, n, n2);
        this.swdlTextFactory = swdlEnv.getTextFactory();
    }

    protected final AbstractSwdlTextFactory getTextFactory() {
        return this.swdlTextFactory;
    }
}

