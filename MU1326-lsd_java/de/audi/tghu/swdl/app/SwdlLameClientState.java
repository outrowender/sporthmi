/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app;

import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.SwdlModels;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.swdlselection.LameClient;

public class SwdlLameClientState {
    private final SwdlEnv swdlEnv;
    private boolean lameClientNotification;
    private boolean lameClients;
    private String lameClientList;

    public SwdlLameClientState(SwdlEnv swdlEnv) {
        this.swdlEnv = swdlEnv;
        this.lameClientList = null;
        this.lameClients = false;
        this.lameClientNotification = false;
    }

    private final SwdlEnv getSwdlEnv() {
        return this.swdlEnv;
    }

    private final SwdlModels getSwdlModels() {
        return this.getSwdlEnv().getSwdlModels();
    }

    protected final IHMIServiceApp getHMIService() {
        return this.getSwdlEnv().getHMIService();
    }

    private final LogChannel getLogDSI() {
        return this.getSwdlEnv().getLogDSI();
    }

    private final LogChannel getLogHMI() {
        return this.getSwdlEnv().getLogHMI();
    }

    public boolean isLameClientNotification() {
        return this.lameClientNotification;
    }

    public void setLameClientNotification(boolean bl) {
        this.lameClientNotification = bl;
    }

    public String getLameClientList() {
        return this.lameClientList;
    }

    public void setLameClientList(String string) {
        this.lameClientList = string;
        if (this.getLameClientList() == null) {
            this.updateLameClients(false, "-");
        } else {
            this.updateLameClients(true, this.getLameClientList());
        }
    }

    public void updateLameClients(LameClient[] lameClientArray) {
        if (this.lameClientNotification) {
            if (null == lameClientArray || 0 == lameClientArray.length) {
                this.getLogDSI().log(1078071040, "[SwdlLameClientState] <- updateLameClients: no lame clients present! ");
                this.setLameClientList(null);
            } else {
                this.getLogDSI().log(1078071040, "[SwdlLameClientState] <- updateLameClients: still waiting for %1 clients ", (long)lameClientArray.length);
                Buffer buffer = new Buffer();
                for (int i2 = 0; i2 < lameClientArray.length; ++i2) {
                    if (i2 > 0) {
                        buffer.append('\n');
                    }
                    buffer.append(lameClientArray[i2].deviceId);
                    buffer.append('(');
                    buffer.append(lameClientArray[i2].mostId);
                    buffer.append(')');
                }
                this.setLameClientList(buffer.toString());
            }
        }
    }

    public void initWaitForLameClients() {
        this.getLogHMI().log(-2137614336, "[SwdlLameClientState] initWaitForLameClients()");
        String string = this.getLameClientList();
        if (string == null) {
            this.updateLameClients(false, "-");
        } else {
            this.updateLameClients(true, string);
        }
    }

    public boolean isLameClients() {
        return this.lameClients;
    }

    public void updateLameClients(boolean bl, String string) {
        this.getLogHMI().log(-2137614336, "[SwdlLameClientState] updateLameClients(%1)", bl);
        this.lameClients = bl;
        this.getSwdlModels().getLameClientsLabel().setText(string);
        this.getSwdlModels().getDevicesReadyChoice().setValue(bl ? 0 : 1);
    }
}

