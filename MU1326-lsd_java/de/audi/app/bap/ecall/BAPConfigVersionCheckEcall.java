/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.ecall;

import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.config.BAPConfig;
import de.audi.app.bap.fw.config.BAPConfigChecker;
import de.audi.app.bap.fw.config.BAPVersion;
import de.audi.app.bap.fw.config.LSGVersion;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPConfigVersionCheck;
import de.vw.mib.bap.generated.ecall.serializer.BAP_Config_Status;

public class BAPConfigVersionCheckEcall
implements BAPConfigVersionCheck {
    private static final int SUPPORTED_LSG_CLASS;
    private static final int SUPPORTED_LSG_SUB_CLASS;
    private final BAPConfig supportedConfig = BAPConfig.getInstance(51, 0, BAPVersion.getInstance(3, 1), LSGVersion.getInstance(3, 5));
    private LogChannel logChannel;

    BAPConfigVersionCheckEcall(AbstractBAPModule abstractBAPModule) {
        this.logChannel = abstractBAPModule.getLogChannel();
    }

    @Override
    public boolean checkVersion(BAPEntity bAPEntity) {
        BAP_Config_Status bAP_Config_Status = (BAP_Config_Status)bAPEntity;
        BAPConfig bAPConfig = BAPConfig.getInstance(bAP_Config_Status.lsg_Class, bAP_Config_Status.lsg_SubClass, BAPVersion.getInstance(bAP_Config_Status.bap_VersionMajor, bAP_Config_Status.bap_VersionMinor), LSGVersion.getInstance(bAP_Config_Status.lsg_VersionMajor, bAP_Config_Status.lsg_VersionMinor));
        this.logChannel.log(1078071040, "[BAPConfigVersionCheckEcall#checkVersion] got version: %1", (Object)bAPConfig);
        return BAPConfigChecker.getInstance(this.supportedConfig).isConfigSupported(bAPConfig);
    }
}

