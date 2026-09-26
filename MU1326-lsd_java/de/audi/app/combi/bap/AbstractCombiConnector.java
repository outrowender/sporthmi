/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap;

import de.audi.app.bap.app.AbstractAppConnectorFSG;
import de.audi.app.bap.fw.AbstractBAPModuleFSG;

public abstract class AbstractCombiConnector
extends AbstractAppConnectorFSG {
    protected final AbstractBAPModuleFSG moduleFsg;

    public AbstractCombiConnector(AbstractBAPModuleFSG abstractBAPModuleFSG) {
        super(abstractBAPModuleFSG.getLogChannel(), abstractBAPModuleFSG.getFunctionRegistration());
        this.moduleFsg = abstractBAPModuleFSG;
    }
}

