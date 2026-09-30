/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.ifc.ITunerGUIHandler;
import de.audi.tuner.ifc.listener.MessageListener;

public interface ITunerDABGUIHandler
extends ITunerGUIHandler {
    public void setSyncLinkState(DabReceptionStatus var1);

    public MessageListener getMessageListener();

    public TunerObjectContainer[] getStationListHierarchical();
}

