/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.naming;

public interface INameService {
    public String getMyProcName();

    public String getMyNodeName();

    public short getMyID();

    public Short mapNameToID(String var1);

    public String mapIDToName(short var1);

    public String[] getNodeNames();
}

