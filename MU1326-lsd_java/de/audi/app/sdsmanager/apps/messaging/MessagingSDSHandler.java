/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.messaging;

import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.atip.interapp.IMessagingReadoutService;
import de.audi.atip.interapp.messaging.IMultipleMessageReadoutService;

public interface MessagingSDSHandler
extends ISDSApplication {
    public static final byte MSG_READOUT_OFF;
    public static final byte MSG_READOUT_ON;
    public static final byte MSG_READOUT_NEW;
    public static final byte MSG_READOUT_MSG_LIST;

    default public void setMessagingReadoutService(IMessagingReadoutService iMessagingReadoutService) {
    }

    default public IMessagingReadoutService getMessagingReadoutService() {
    }

    default public void unsetMessagingReadoutService() {
    }

    default public int getSelectedIndex() {
    }

    default public void setMultipleMessageReadoutService(IMultipleMessageReadoutService iMultipleMessageReadoutService) {
    }

    default public IMultipleMessageReadoutService getMultipleMessageReadoutService() {
    }

    default public void unsetMultipleMessageReadoutService() {
    }
}

