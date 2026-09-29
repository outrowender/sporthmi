/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.indication;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.indication.AbstractBAPIndicationHandler;
import de.audi.app.bap.fw.indication.IBAPIndicationHandlerFSG;
import de.audi.atip.log.LogChannel;

public abstract class AbstractBAPIndicationHandlerFSG
extends AbstractBAPIndicationHandler
implements IBAPIndicationHandlerFSG {
    public AbstractBAPIndicationHandlerFSG(AbstractBAPModuleFSG abstractBAPModuleFSG, LogChannel logChannel) {
        super(abstractBAPModuleFSG, logChannel);
    }
}

