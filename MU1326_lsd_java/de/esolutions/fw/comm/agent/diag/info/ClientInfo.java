/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag.info;

import de.esolutions.fw.comm.agent.diag.AbstractInfoBase;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import java.lang.reflect.Field;

public class ClientInfo
extends AbstractInfoBase {
    public final short peerId;
    public final int peerEpoch;
    public final String className;
    public final String connection;
    public final Boolean isIncoming;
    public final int stubs;
    public final int proxies;
    public final int errorCode;
    public final String errorString;
    public final long lastConnectTimeStamp;
    public final long lastDisconnectTimeStamp;
    public final int durationInternalMin;
    public final int durationInternalMax;
    public final int durationInternalAvg;
    public final int durationCallMin;
    public final int durationCallMax;
    public final int durationCallAvg;
    private static final int DEFAULT_ERROR_CODE = 0;
    private static final int DEFAULT_NUM_USER = 1;
    private static final int DEFAULT_PEER_EPOCH = 1;
    private static final String DEFAULT_CLASS_NAME = (class$de$esolutions$fw$comm$agent$client$ConnectionClientHandler == null ? (class$de$esolutions$fw$comm$agent$client$ConnectionClientHandler = ClientInfo.class$("de.esolutions.fw.comm.agent.client.ConnectionClientHandler")) : class$de$esolutions$fw$comm$agent$client$ConnectionClientHandler).getName();
    private static final Boolean DEFAULT_IS_INCOMING = new Boolean(false);
    static /* synthetic */ Class class$de$esolutions$fw$comm$agent$client$ConnectionClientHandler;

    public ClientInfo(short s, short s2, int n, String string, String string2, Boolean bl, int n2, int n3, int n4, String string3, long l, long l2, int[] nArray, int[] nArray2) {
        super(s);
        this.peerId = s2;
        this.peerEpoch = n;
        this.className = string;
        this.connection = string2;
        this.isIncoming = bl;
        this.stubs = n3;
        this.proxies = n2;
        this.errorCode = n4;
        this.errorString = string3;
        this.lastConnectTimeStamp = l;
        this.lastDisconnectTimeStamp = l2;
        if (nArray != null) {
            this.durationInternalMin = nArray[0];
            this.durationInternalMax = nArray[1];
            this.durationInternalAvg = nArray[2];
        } else {
            this.durationInternalMin = Integer.MAX_VALUE;
            this.durationInternalMax = 0;
            this.durationInternalAvg = 0;
        }
        if (nArray2 != null) {
            this.durationCallMin = nArray2[0];
            this.durationCallMax = nArray2[1];
            this.durationCallAvg = nArray2[2];
        } else {
            this.durationCallMin = Integer.MAX_VALUE;
            this.durationCallMax = 0;
            this.durationCallAvg = 0;
        }
    }

    public ServiceInstanceID getServiceInstanceID() {
        return null;
    }

    protected Object fieldValueToObject(Field field) throws IllegalArgumentException, IllegalAccessException {
        if (field == null) {
            return null;
        }
        String string = field.getName();
        if (string.equals("lastConnectTimeStamp")) {
            return this.convertTimeStampField(super.fieldValueToObject(field));
        }
        if (string.equals("lastDisconnectTimeStamp")) {
            return this.convertTimeStampField(super.fieldValueToObject(field));
        }
        if (string.equals("errorCode") && this.errorCode == 0 || string.equals("errorString") && this.errorCode == 0 || string.equals("proxies") && this.proxies == 1 || string.equals("stubs") && this.stubs == 1 || string.equals("isIncoming") && this.isIncoming == null || string.equals("isIncoming") && this.isIncoming.equals(DEFAULT_IS_INCOMING) || string.equals("peerEpoch") && this.peerEpoch == 1 || string.equals("className") && this.className.equals(DEFAULT_CLASS_NAME) || string.equals("durationInternalMin") && this.durationInternalMin == Integer.MAX_VALUE || string.equals("durationInternalMax") && this.durationInternalMin == Integer.MAX_VALUE || string.equals("durationInternalAvg") && this.durationInternalMin == Integer.MAX_VALUE || string.equals("durationCallMin") && this.durationCallMin == Integer.MAX_VALUE || string.equals("durationCallMax") && this.durationCallMin == Integer.MAX_VALUE || string.equals("durationCallAvg") && this.durationCallMin == Integer.MAX_VALUE) {
            return null;
        }
        return super.fieldValueToObject(field);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

