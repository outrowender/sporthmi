/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.syscall;

import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.syscall.ISystemCall;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.app.sdsmanager.syscall.SystemCallParameter;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SystemCall
implements ISystemCall {
    private final int id;
    private final ISystemCallParameter[] parameters;
    private static final Set SYSCALLS_EXPECTING_NO_RESPONSE = SystemCall.createNoResponseSet();

    private static Set createNoResponseSet() {
        HashSet hashSet = new HashSet();
        hashSet.add(new Integer(70004));
        hashSet.add(new Integer(70002));
        hashSet.add(new Integer(77004));
        hashSet.add(new Integer(75007));
        hashSet.add(new Integer(75000));
        hashSet.add(new Integer(70005));
        hashSet.add(new Integer(20016));
        hashSet.add(new Integer(40032));
        hashSet.add(new Integer(40042));
        hashSet.add(new Integer(40064));
        hashSet.add(new Integer(40010));
        hashSet.add(new Integer(40011));
        hashSet.add(new Integer(40026));
        hashSet.add(new Integer(40103));
        hashSet.add(new Integer(40105));
        hashSet.add(new Integer(10006));
        hashSet.add(new Integer(30010));
        hashSet.add(new Integer(1002));
        hashSet.add(new Integer(1007));
        hashSet.add(new Integer(1045));
        hashSet.add(new Integer(1063));
        hashSet.add(new Integer(1010));
        hashSet.add(new Integer(1012));
        hashSet.add(new Integer(1013));
        hashSet.add(new Integer(1014));
        hashSet.add(new Integer(1015));
        hashSet.add(new Integer(1058));
        hashSet.add(new Integer(1048));
        hashSet.add(new Integer(1017));
        hashSet.add(new Integer(1019));
        hashSet.add(new Integer(1021));
        hashSet.add(new Integer(1034));
        hashSet.add(new Integer(1041));
        hashSet.add(new Integer(1046));
        hashSet.add(new Integer(1051));
        hashSet.add(new Integer(1052));
        hashSet.add(new Integer(1059));
        hashSet.add(new Integer(1064));
        hashSet.add(new Integer(40108));
        hashSet.add(new Integer(40111));
        return Collections.unmodifiableSet(hashSet);
    }

    public SystemCall(int n) {
        this.id = n;
        this.parameters = new ISystemCallParameter[0];
    }

    public SystemCall(int n, int n2) {
        this.id = n;
        this.parameters = new ISystemCallParameter[]{new SystemCallParameter(new Integer(n2))};
    }

    public SystemCall(int n, boolean bl) {
        this.id = n;
        this.parameters = new ISystemCallParameter[]{new SystemCallParameter(bl)};
    }

    public SystemCall(int n, String string) {
        this.id = n;
        this.parameters = new ISystemCallParameter[]{new SystemCallParameter(string)};
    }

    public SystemCall(int n, int n2, int n3) {
        this.id = n;
        this.parameters = new ISystemCallParameter[]{new SystemCallParameter(new Integer(n2)), new SystemCallParameter(new Integer(n3))};
    }

    public SystemCall(int n, int n2, boolean bl) {
        this.id = n;
        this.parameters = new ISystemCallParameter[]{new SystemCallParameter(new Integer(n2)), new SystemCallParameter(bl)};
    }

    public SystemCall(int n, boolean bl, int n2) {
        this.id = n;
        this.parameters = new ISystemCallParameter[]{new SystemCallParameter(bl), new SystemCallParameter(new Integer(n2))};
    }

    SystemCall(int n, boolean bl, boolean bl2) {
        this.id = n;
        this.parameters = new ISystemCallParameter[]{new SystemCallParameter(bl), new SystemCallParameter(bl2)};
    }

    public SystemCall(int n, boolean bl, int n2, int n3) {
        this.id = n;
        this.parameters = new ISystemCallParameter[]{new SystemCallParameter(bl), new SystemCallParameter(new Integer(n2)), new SystemCallParameter(new Integer(n3))};
    }

    public SystemCall(int n, int n2, int n3, int n4) {
        this.id = n;
        this.parameters = new ISystemCallParameter[]{new SystemCallParameter(new Integer(n2)), new SystemCallParameter(new Integer(n3)), new SystemCallParameter(new Integer(n4))};
    }

    public SystemCall(int n, String string, int n2) {
        this.id = n;
        this.parameters = new ISystemCallParameter[]{new SystemCallParameter(new String(string)), new SystemCallParameter(new Integer(n2))};
    }

    public int getId() {
        return this.id;
    }

    public ISystemCallParameter[] getParameters() {
        return this.parameters;
    }

    public String getName() {
        return SDSManagerBaseActivator.getSystemCallNames().getName(this.id);
    }

    public boolean requiresResponse() {
        return SystemCall.requiresResponse(this.id);
    }

    public static boolean requiresResponse(int n) {
        return !SYSCALLS_EXPECTING_NO_RESPONSE.contains(new Integer(n));
    }

    public String toString() {
        return new Buffer(this.getName()).append(" ").append(SDSUtils.toString((Object[])this.parameters, false)).toString();
    }
}

