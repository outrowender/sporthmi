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
    default public void setSyncLinkState(DabReceptionStatus dabReceptionStatus) {
    }

    default public MessageListener getMessageListener() {
    }

    default public TunerObjectContainer[] getStationListHierarchical() {
    }
}

