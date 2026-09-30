/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.messaging;

import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.atip.interapp.IMessagingReadoutService;
import de.audi.atip.interapp.messaging.IMultipleMessageReadoutService;

public interface MessagingSDSHandler
extends ISDSApplication {
    public static final byte MSG_READOUT_OFF = 0;
    public static final byte MSG_READOUT_ON = 1;
    public static final byte MSG_READOUT_NEW = 2;
    public static final byte MSG_READOUT_MSG_LIST = 3;

    public void setMessagingReadoutService(IMessagingReadoutService var1);

    public IMessagingReadoutService getMessagingReadoutService();

    public void unsetMessagingReadoutService();

    public int getSelectedIndex();

    public void setMultipleMessageReadoutService(IMultipleMessageReadoutService var1);

    public IMultipleMessageReadoutService getMultipleMessageReadoutService();

    public void unsetMultipleMessageReadoutService();
}

