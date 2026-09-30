/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.media;

import de.esolutions.fw.comm.core.IEnum;

public interface eUsbCommunicationState
extends IEnum {
    public static final int USB_COMSTATE_OK = 0;
    public static final int USB_COMSTATE_ERROR = 1;
    public static final int USB_COMSTATE_NOT_AVALABLE = 255;
}

