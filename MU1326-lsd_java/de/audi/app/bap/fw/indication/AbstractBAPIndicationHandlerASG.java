/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.indication;

import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.indication.AbstractBAPIndicationHandler;
import de.audi.app.bap.fw.indication.IBAPIndicationHandlerASG;
import de.audi.atip.log.LogChannel;

public abstract class AbstractBAPIndicationHandlerASG
extends AbstractBAPIndicationHandler
implements IBAPIndicationHandlerASG {
    public AbstractBAPIndicationHandlerASG(AbstractBAPModuleASG abstractBAPModuleASG, LogChannel logChannel) {
        super(abstractBAPModuleASG, logChannel);
    }
}

