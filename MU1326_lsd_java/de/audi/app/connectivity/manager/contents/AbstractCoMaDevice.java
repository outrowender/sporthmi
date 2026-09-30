/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager.contents;

import de.audi.atip.hmi.model.PropertyListCell;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractCoMaDevice {
    public static final int TYPE_SIM = 0;
    public static final int TYPE_BLUE = 1;
    public static final int TYPE_WLAN = 2;
    public static final int TYPE_UPNP = 3;
    public static final int TYPE_RHMI = 4;
    public static final int TYPE_SMARTPHONE = 7;
    public static final int SERVICE_TELEPHONY_SLOT1 = 1;
    public static final int SERVICE_TELEPHONY_SLOT2 = 2;
    public static final int SERVICE_TELEPHONY = 3;
    public static final int SERVICE_DATA = 4;
    public static final int SERVICE_AUDI_CONNECT = 8;
    public static final int SERVICE_MEDIA = 16;
    public static final int SERVICE_OFFICE = 32;
    public static final int SERVICE_SMARTPHONE = 64;
    public static final int SERVICE_MEDIA_WLAN = 128;
    public static final int SERVICE_NONE = 0;
    public static final int SERVICE_ALL = 255;
    public static final int SMARTPHONE_INTEGRATIONTYPE_NONE = 0;
    public static final int SMARTPHONE_INTEGRATIONTYPE_APPLE = 1;
    public static final int SMARTPHONE_INTEGRATIONTYPE_ANDROID = 2;
    public static final int SMARTPHONE_INTEGRATIONTYPE_CARLIFE = 3;
    private final int type;
    private final int supportedServices;
    private int connectedServices;
    private int changeableServices;
    private final String identifier;
    private final String name;
    private final int smartPhoneIntegrationType;

    AbstractCoMaDevice(int n, int n2, int n3, int n4, String string, String string2, int n5) {
        this.type = n;
        this.supportedServices = n2;
        this.connectedServices = n3 & n2;
        this.changeableServices = n4 & n2;
        this.identifier = string;
        this.name = string2;
        this.smartPhoneIntegrationType = n5;
    }

    int getType() {
        return this.type;
    }

    int getsmartPhoneIntegrationType() {
        return this.smartPhoneIntegrationType;
    }

    boolean supports(int n) {
        return (this.supportedServices & n) != 0;
    }

    public boolean isConnected(int n) {
        return (this.connectedServices & n) != 0;
    }

    boolean isChangeable(int n) {
        return (this.changeableServices & n) != 0;
    }

    public String getAddress() {
        return this.identifier;
    }

    String getName() {
        return this.name;
    }

    abstract PropertyListCell getProperties();

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append(super.toString());
        buffer.append(" " + this.identifier + " connected: ");
        if (this.isConnected(1)) {
            buffer.append("VOICE(PRIMARY)");
        }
        if (this.isConnected(2)) {
            buffer.append("VOICE(ASSOCIATED)");
        }
        if (this.isConnected(4)) {
            buffer.append("&DATA");
        }
        if (this.isConnected(16)) {
            buffer.append("&MEDIA");
        }
        buffer.append(" all: " + this.connectedServices);
        return buffer.toString();
    }
}

