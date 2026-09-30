/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.naming;

import de.esolutions.fw.comm.agent.naming.INameService;
import de.esolutions.fw.util.config.fw.SystemConfig;

public class ConfigNameService
implements INameService {
    private SystemConfig config;

    public ConfigNameService(SystemConfig systemConfig) {
        this.config = systemConfig;
    }

    public short getMyID() {
        return (short)this.config.getMyProcId();
    }

    public String getMyProcName() {
        return this.config.getMyProcName();
    }

    public String getMyNodeName() {
        return this.config.getMyNodeName();
    }

    public String mapIDToName(short s) {
        return this.config.mapProcId(s);
    }

    public Short mapNameToID(String string) {
        return new Short(this.config.mapIdProc(string).shortValue());
    }

    public String[] getNodeNames() {
        return this.config.getAllNodeNames();
    }
}

