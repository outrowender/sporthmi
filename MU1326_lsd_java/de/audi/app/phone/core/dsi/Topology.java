/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelTopology;
import de.audi.app.phone.core.dsi.TopologyArray;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Topology
implements ITelTopology {
    private static final int DO_NOT_USE = -1;
    private static final int SWITCH_IN_PROGRESS = -2;
    private static final int ROLE_PRIMARY = 65536;
    private static final int ROLE_ASSOCIATED = 131072;
    private static final int ROLE_DATA = 196608;
    public static final int USAGE_NONE = -1;
    private int dsiInstanceIdNad = -1;
    private int dsiInstanceIdHfp1 = -1;
    private int dsiInstanceIdHfp2 = -1;
    private static final TopologyArray initState = new TopologyArray(new int[]{-2, -2, -2});
    static final int[] PRIMARY_DATA_ASSOCIATED = new int[]{65536, 196608, 131072};
    static final int[] PRIMARY_ASSOCIATED_DATA = new int[]{65536, 131072, 196608};
    static final int[] ASSOCIATED_DATA_PRIMARY = new int[]{131072, 196608, 65536};
    static final int[] ASSOCIATED_PRIMARY_DATA = new int[]{131072, 65536, 196608};
    static final int[] DATA_ASSOCIATED_PRIMARY = new int[]{196608, 131072, 65536};
    static final int[] DATA_PRIMARY_ASSOCIATED = new int[]{196608, 65536, 131072};
    private static final int[] DEFAULT_ROLE_ASSIGNMENT = PRIMARY_ASSOCIATED_DATA;
    private static final Map topologyToRoleMap = new HashMap();
    private final TopologyArray topologyArray;
    private final LogChannel log;
    private final boolean secondPhoneFeatureSupported;

    private String getRoleAssignmentString(int[] nArray) {
        Buffer buffer = new Buffer();
        if (nArray != null) {
            buffer.append("[ROLE_PRIMARY]=");
            buffer.append(this.getMeDeviceName(nArray[0]));
            buffer.append(", ");
            buffer.append("[ROLE_ASSOCIATED]=");
            buffer.append(this.getMeDeviceName(nArray[1]));
            buffer.append(", ");
            buffer.append("[ROLE_DATAONLY]=");
            buffer.append(this.getMeDeviceName(nArray[2]));
        } else {
            buffer.append("Topology.getRoleAssignmentString(): roleAssignment==NULL");
        }
        return buffer.toString();
    }

    private static int getSlot2Instance(int n, int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (n != i2) continue;
            return nArray[i2];
        }
        return -1;
    }

    private static boolean isSlotValid(int n) {
        return n >= 0 && n <= 2;
    }

    private static boolean isInstanceValid(int n) {
        return n >= 0 && n <= 2;
    }

    private static boolean isInstanceInvalid(int n) {
        return !Topology.isInstanceValid(n);
    }

    private static int getNextValidReplacementInstanceId(int[] nArray) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new Integer(0));
        arrayList.add(new Integer(1));
        arrayList.add(new Integer(2));
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (!Topology.isInstanceValid(nArray[i2])) continue;
            arrayList.remove(new Integer(nArray[i2]));
        }
        return (Integer)arrayList.get(0);
    }

    private static void assignSlotValue(int[] nArray, int n, int n2, boolean bl) {
        if (Topology.isSlotValid(n) && Topology.isInstanceValid(n2)) {
            nArray[n] = n == 2 && n2 != 0 ? -1 : n2;
            if (!bl) {
                nArray[1] = -1;
            }
        }
    }

    private static int[] getSwitchedSlotTopology(int[] nArray, int n, int n2, boolean bl) {
        int[] nArray2 = PhoneUtils.cloneIntArray(nArray);
        if (n != n2 && Topology.isSlotValid(n) && Topology.isSlotValid(n2)) {
            int n3 = Topology.getSlot2Instance(n, nArray);
            int n4 = Topology.getSlot2Instance(n2, nArray);
            boolean bl2 = Topology.isInstanceValid(n3);
            boolean bl3 = Topology.isInstanceValid(n4);
            if (bl2 && bl3) {
                Topology.assignSlotValue(nArray2, n, n4, bl);
                Topology.assignSlotValue(nArray2, n2, n3, bl);
            } else if (bl2 || bl3) {
                if (Topology.isInstanceInvalid(n3)) {
                    n3 = Topology.getNextValidReplacementInstanceId(nArray);
                } else if (Topology.isInstanceInvalid(n4)) {
                    n4 = Topology.getNextValidReplacementInstanceId(nArray);
                }
                Topology.assignSlotValue(nArray2, n, n4, bl);
                Topology.assignSlotValue(nArray2, n2, n3, bl);
            }
        }
        return nArray2;
    }

    private static int[] getToggledTopology(int[] nArray, boolean bl) {
        return Topology.getSwitchedSlotTopology(nArray, 0, 1, bl);
    }

    public Topology(LogChannel logChannel, boolean bl, int[] nArray) {
        this.log = logChannel;
        this.secondPhoneFeatureSupported = bl;
        if (nArray == null) {
            logChannel.log(10000, "[Topology#Topology] %1", (Object)"topology is null!!");
            throw new IllegalArgumentException("topology is null!!");
        }
        this.topologyArray = new TopologyArray(nArray);
    }

    public int[] getTopology() {
        return PhoneUtils.cloneIntArray(this.topologyArray.getArray());
    }

    int[] getRoles() {
        if (topologyToRoleMap.containsKey(this.topologyArray)) {
            return PhoneUtils.cloneIntArray((int[])topologyToRoleMap.get(this.topologyArray));
        }
        this.log.log(100000, "[Topology#getRoles] no roles defined for topology %1", (Object)this.topologyArray);
        return PhoneUtils.cloneIntArray(DEFAULT_ROLE_ASSIGNMENT);
    }

    int[] getToggledArray() {
        return Topology.getToggledTopology(this.topologyArray.getArray(), this.secondPhoneFeatureSupported);
    }

    int[] getSwitchedSlotTopology(int n, int n2) {
        return Topology.getSwitchedSlotTopology(this.topologyArray.getArray(), n, n2, this.secondPhoneFeatureSupported);
    }

    public boolean isInitState() {
        return initState.equals(this.topologyArray);
    }

    void setInstanceUsage(int[] nArray) {
        int n = 0;
        if (nArray != null) {
            block5: for (int i2 = 0; i2 < nArray.length; ++i2) {
                switch (nArray[i2]) {
                    case 0: {
                        this.dsiInstanceIdNad = i2;
                        continue block5;
                    }
                    case 1: {
                        if (++n == 1) {
                            this.dsiInstanceIdHfp1 = i2;
                            continue block5;
                        }
                        if (n != 2) continue block5;
                        this.dsiInstanceIdHfp2 = i2;
                        continue block5;
                    }
                    case -1: {
                        continue block5;
                    }
                    default: {
                        this.log.log(100000, "[Topology#getRoles] Unknown DSI USAGE Constant: %1", (long)nArray[i2]);
                    }
                }
            }
        }
    }

    private String getMeDeviceName(int n) {
        String string = this.dsiInstanceIdNad != -1 && n == this.dsiInstanceIdNad ? "NAD" : (this.dsiInstanceIdHfp1 != -1 && n == this.dsiInstanceIdHfp1 ? "HFP1" : (this.dsiInstanceIdHfp2 != -1 && n == this.dsiInstanceIdHfp2 ? "HFP2" : (n == -1 ? "NotInUse" : (n == -2 ? "SwitchInProgress" : "Unknown device " + n))));
        return string;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("Topology: ");
        buffer.append(this.topologyArray);
        buffer.append(", ");
        buffer.append("Roles: ");
        buffer.append(this.getRoleAssignmentString(this.topologyArray.getArray()));
        return buffer.toString();
    }

    static {
        topologyToRoleMap.put(new TopologyArray(new int[]{0, 1, 2}), PRIMARY_ASSOCIATED_DATA);
        topologyToRoleMap.put(new TopologyArray(new int[]{0, 2, 1}), PRIMARY_DATA_ASSOCIATED);
        topologyToRoleMap.put(new TopologyArray(new int[]{1, 2, 0}), DATA_PRIMARY_ASSOCIATED);
        topologyToRoleMap.put(new TopologyArray(new int[]{1, 0, 2}), ASSOCIATED_PRIMARY_DATA);
        topologyToRoleMap.put(new TopologyArray(new int[]{2, 1, 0}), DATA_ASSOCIATED_PRIMARY);
        topologyToRoleMap.put(new TopologyArray(new int[]{2, 0, 1}), ASSOCIATED_DATA_PRIMARY);
        topologyToRoleMap.put(new TopologyArray(new int[]{-1, 0, 1}), ASSOCIATED_DATA_PRIMARY);
        topologyToRoleMap.put(new TopologyArray(new int[]{-1, 0, 2}), ASSOCIATED_PRIMARY_DATA);
        topologyToRoleMap.put(new TopologyArray(new int[]{-1, 1, 0}), DATA_ASSOCIATED_PRIMARY);
        topologyToRoleMap.put(new TopologyArray(new int[]{-1, 1, 2}), PRIMARY_ASSOCIATED_DATA);
        topologyToRoleMap.put(new TopologyArray(new int[]{-1, 2, 1}), PRIMARY_DATA_ASSOCIATED);
        topologyToRoleMap.put(new TopologyArray(new int[]{-1, 2, 0}), DATA_PRIMARY_ASSOCIATED);
        topologyToRoleMap.put(new TopologyArray(new int[]{0, -1, 1}), PRIMARY_DATA_ASSOCIATED);
        topologyToRoleMap.put(new TopologyArray(new int[]{0, -1, 2}), PRIMARY_ASSOCIATED_DATA);
        topologyToRoleMap.put(new TopologyArray(new int[]{1, -1, 0}), DATA_PRIMARY_ASSOCIATED);
        topologyToRoleMap.put(new TopologyArray(new int[]{1, -1, 2}), ASSOCIATED_PRIMARY_DATA);
        topologyToRoleMap.put(new TopologyArray(new int[]{2, -1, 1}), ASSOCIATED_DATA_PRIMARY);
        topologyToRoleMap.put(new TopologyArray(new int[]{2, -1, 0}), DATA_ASSOCIATED_PRIMARY);
        topologyToRoleMap.put(new TopologyArray(new int[]{0, 1, -1}), PRIMARY_ASSOCIATED_DATA);
        topologyToRoleMap.put(new TopologyArray(new int[]{0, 2, -1}), PRIMARY_DATA_ASSOCIATED);
        topologyToRoleMap.put(new TopologyArray(new int[]{1, 0, -1}), ASSOCIATED_PRIMARY_DATA);
        topologyToRoleMap.put(new TopologyArray(new int[]{1, 2, -1}), DATA_PRIMARY_ASSOCIATED);
        topologyToRoleMap.put(new TopologyArray(new int[]{2, 0, -1}), ASSOCIATED_DATA_PRIMARY);
        topologyToRoleMap.put(new TopologyArray(new int[]{2, 1, -1}), DATA_ASSOCIATED_PRIMARY);
        topologyToRoleMap.put(new TopologyArray(new int[]{0, -1, -1}), PRIMARY_ASSOCIATED_DATA);
        topologyToRoleMap.put(new TopologyArray(new int[]{1, -1, -1}), DATA_PRIMARY_ASSOCIATED);
        topologyToRoleMap.put(new TopologyArray(new int[]{2, -1, -1}), DATA_ASSOCIATED_PRIMARY);
        topologyToRoleMap.put(new TopologyArray(new int[]{-1, -1, 0}), DATA_PRIMARY_ASSOCIATED);
        topologyToRoleMap.put(new TopologyArray(new int[]{-1, -1, 1}), PRIMARY_DATA_ASSOCIATED);
        topologyToRoleMap.put(new TopologyArray(new int[]{-1, -1, 2}), PRIMARY_ASSOCIATED_DATA);
        topologyToRoleMap.put(new TopologyArray(new int[]{-1, 0, -1}), ASSOCIATED_DATA_PRIMARY);
        topologyToRoleMap.put(new TopologyArray(new int[]{-1, 1, -1}), DATA_ASSOCIATED_PRIMARY);
        topologyToRoleMap.put(new TopologyArray(new int[]{-1, 2, -1}), DATA_PRIMARY_ASSOCIATED);
    }
}

