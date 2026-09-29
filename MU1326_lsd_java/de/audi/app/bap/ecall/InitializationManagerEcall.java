/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.ecall;

import de.audi.app.bap.IPowerState;
import de.audi.app.bap.dsi.bap.IDSIBAPController;
import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG;
import de.audi.app.bap.fw.config.BAPConfig;
import de.audi.app.bap.fw.config.BAPVersion;
import de.audi.app.bap.fw.config.LSGVersion;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.ecall.serializer.BAP_Config_Reset;
import de.vw.mib.bap.generated.ecall.serializer.BAP_Config_Status;
import de.vw.mib.bap.requests.StatusProperty;

public class InitializationManagerEcall
extends AbstractBAPModuleInitializationManagerASG {
    private static final int SUPPORTED_LSG_CLASS;
    private static final int SUPPORTED_LSG_SUB_CLASS;
    private final BAPConfig supportedConfig = BAPConfig.getInstance(51, 0, BAPVersion.getInstance(3, 1), LSGVersion.getInstance(3, 5));

    public InitializationManagerEcall(AbstractBAPModuleASG abstractBAPModuleASG, IDSIBAPController iDSIBAPController, IPowerState iPowerState) {
        super(abstractBAPModuleASG, iDSIBAPController, iPowerState);
    }

    @Override
    protected BAPConfig bapConfigFromResetSerializer(BAPEntity bAPEntity) {
        BAP_Config_Reset bAP_Config_Reset = (BAP_Config_Reset)bAPEntity;
        int n = bAP_Config_Reset.lsg_Class;
        int n2 = bAP_Config_Reset.lsg_SubClass;
        BAPVersion bAPVersion = BAPVersion.getInstance(bAP_Config_Reset.bap_VersionMajor, bAP_Config_Reset.bap_VersionMinor);
        LSGVersion lSGVersion = LSGVersion.getInstance(bAP_Config_Reset.lsg_VersionMajor, bAP_Config_Reset.lsg_VersionMinor);
        return BAPConfig.getInstance(n, n2, bAPVersion, lSGVersion);
    }

    @Override
    protected BAPConfig bapConfigFromStatusSerializer(StatusProperty statusProperty) {
        BAP_Config_Status bAP_Config_Status = (BAP_Config_Status)statusProperty;
        int n = bAP_Config_Status.lsg_Class;
        int n2 = bAP_Config_Status.lsg_SubClass;
        BAPVersion bAPVersion = BAPVersion.getInstance(bAP_Config_Status.bap_VersionMajor, bAP_Config_Status.bap_VersionMinor);
        LSGVersion lSGVersion = LSGVersion.getInstance(bAP_Config_Status.lsg_VersionMajor, bAP_Config_Status.lsg_VersionMinor);
        return BAPConfig.getInstance(n, n2, bAPVersion, lSGVersion);
    }

    @Override
    protected boolean isBapConfigSupported(BAPConfig bAPConfig) {
        return this.supportedConfig.isCompatibleWith(bAPConfig);
    }

    @Override
    public void appStateChanged(String string, int n) {
        this.logChannel.log(1078071040, "[InitializationManagerEcall#appStateChanged] appName=%1, value=%2", (Object)string, (long)n);
        if ("AppBapEcall".equals(string)) {
            this.processAppStateChanged(n);
        }
    }

    @Override
    public String appStatesToString() {
        Buffer buffer = new Buffer();
        buffer.append("appStateECall = ");
        buffer.append(this.getAppState());
        buffer.append('\n');
        return buffer.toString();
    }

    @Override
    public void updateOperationState() {
    }
}

