/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.eni;

import de.audi.app.bap.IPowerState;
import de.audi.app.bap.dsi.bap.IDSIBAPController;
import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG;
import de.audi.app.bap.fw.config.BAPConfig;
import de.audi.app.bap.fw.config.BAPVersion;
import de.audi.app.bap.fw.config.LSGVersion;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.eni.serializer.BAP_Config_Reset;
import de.vw.mib.bap.generated.eni.serializer.BAP_Config_Status;
import de.vw.mib.bap.requests.StatusProperty;

public class InitializationManagerENI
extends AbstractBAPModuleInitializationManagerASG {
    private static final int SUPPORTED_LSG_CLASS = 55;
    private static final int SUPPORTED_LSG_SUB_CLASS = 0;
    private final BAPConfig supportedConfig = BAPConfig.getInstance(55, 0, BAPVersion.getInstance(3, 0), LSGVersion.getInstance(3, 3));
    private LogChannel logChannel;

    public InitializationManagerENI(AbstractBAPModuleASG abstractBAPModuleASG, IDSIBAPController iDSIBAPController, IPowerState iPowerState) {
        super(abstractBAPModuleASG, iDSIBAPController, iPowerState);
        this.logChannel = abstractBAPModuleASG.getLogChannel();
    }

    protected BAPConfig bapConfigFromResetSerializer(BAPEntity bAPEntity) {
        BAP_Config_Reset bAP_Config_Reset = (BAP_Config_Reset)bAPEntity;
        int n = bAP_Config_Reset.lsg_Class;
        int n2 = bAP_Config_Reset.lsg_Sub_Class;
        BAPVersion bAPVersion = BAPVersion.getInstance(bAP_Config_Reset.bap_Version_major, bAP_Config_Reset.bap_Version_minor);
        LSGVersion lSGVersion = LSGVersion.getInstance(bAP_Config_Reset.lsg_Version_major, bAP_Config_Reset.lsg_Version_minor);
        return BAPConfig.getInstance(n, n2, bAPVersion, lSGVersion);
    }

    protected BAPConfig bapConfigFromStatusSerializer(StatusProperty statusProperty) {
        BAP_Config_Status bAP_Config_Status = (BAP_Config_Status)statusProperty;
        int n = bAP_Config_Status.lsg_Class;
        int n2 = bAP_Config_Status.lsg_Sub_Class;
        BAPVersion bAPVersion = BAPVersion.getInstance(bAP_Config_Status.bap_Version_major, bAP_Config_Status.bap_Version_minor);
        LSGVersion lSGVersion = LSGVersion.getInstance(bAP_Config_Status.lsg_Version_major, bAP_Config_Status.lsg_Version_minor);
        return BAPConfig.getInstance(n, n2, bAPVersion, lSGVersion);
    }

    public void appStateChanged(String string, int n) {
        this.logChannel.log(1000000, "[InitializationManagerENI#appStateChanged] appName=%1, value=%2", (Object)string, (long)n);
        if ("AppBapENI".equals(string)) {
            this.processAppStateChanged(n);
        }
    }

    protected boolean isBapConfigSupported(BAPConfig bAPConfig) {
        return this.supportedConfig.isCompatibleWith(bAPConfig);
    }

    public String appStatesToString() {
        Buffer buffer = new Buffer();
        buffer.append("appStateENI = ");
        buffer.append(this.getAppState());
        buffer.append('\n');
        return buffer.toString();
    }

    public void updateOperationState() {
    }
}

