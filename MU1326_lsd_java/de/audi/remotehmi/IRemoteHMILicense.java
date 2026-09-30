/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.DateTime;

public class IRemoteHMILicense {
    public int type;
    public String id;
    public int state;
    public DateTime activation;
    public DateTime expires;
    public String duration;
    public String serviceID;
    public boolean warn;
    public String name;
    public String description;
    public static final int ACTIVATED = 1;
    public static final int NOT_ACTIVATED = 2;
    public static final int NOT_LICENSED = 3;
    public static final int EXPIRED = 4;
    public static final int OFFERED = 5;
    public static final int ERROR = 6;
    public static final int REVOKED = 7;
    public static final int EXPIRING = 11;
    public static final int TYPE_REGULAR = 0;
    public static final int TYPE_TRAIL = 1;
    public static final int TYPE_DEALER = 2;

    public IRemoteHMILicense(String string, int n, DateTime dateTime, DateTime dateTime2, String string2, String string3, boolean bl, String string4, String string5, int n2) {
        this.id = string;
        this.state = n;
        this.activation = dateTime;
        this.expires = dateTime2;
        this.duration = string2;
        this.serviceID = string3;
        this.warn = bl;
        this.name = string4;
        this.description = string5;
        this.type = n2;
    }

    public int getType() {
        return this.type;
    }

    public String getId() {
        return this.id;
    }

    public int getState() {
        return this.state;
    }

    public String getServiceID() {
        return this.serviceID;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public DateTime getActivation() {
        return this.activation;
    }

    public DateTime getExpires() {
        return this.expires;
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("IRemoteHMILicense[ ");
        buffer.append("id:").append(this.id);
        buffer.append(", name:").append(this.name);
        buffer.append(", state:").append(this.state);
        buffer.append(", activation:").append(this.activation);
        buffer.append(", expires:").append(this.expires);
        buffer.append(", duration:").append(this.duration);
        buffer.append(", serviceID:").append(this.serviceID);
        buffer.append(", warn:").append(this.warn);
        buffer.append(", description:").append(this.description);
        buffer.append(", type:").append(this.type);
        buffer.append(" ]");
        return buffer.toString();
    }
}

