/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.indication;

import de.audi.app.bap.fw.indication.IBAPIndicationHandlerArrayFSG;
import de.audi.app.bap.fw.indication.IBAPIndicationHandlerMethodFSG;
import de.audi.app.bap.fw.indication.IBAPIndicationHandlerPropertyFSG;
import de.audi.app.bap.fw.indication.IBAPIndicationListener;

public interface IBAPIndicationHandlerFSG
extends IBAPIndicationListener,
IBAPIndicationHandlerArrayFSG,
IBAPIndicationHandlerMethodFSG,
IBAPIndicationHandlerPropertyFSG {
}

