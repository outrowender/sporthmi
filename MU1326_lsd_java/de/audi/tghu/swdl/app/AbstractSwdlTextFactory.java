/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app;

import de.audi.tghu.swdl.app.SwdlEnv;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.swdlprogress.GeneralProgress;

public abstract class AbstractSwdlTextFactory {
    private static final String[] DIGIT = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
    private SwdlEnv swdlEnv;

    public final SwdlEnv getSwdlEnv() {
        return this.swdlEnv;
    }

    public final void setSwdlEnv(SwdlEnv swdlEnv) {
        this.swdlEnv = swdlEnv;
    }

    protected String getI18nText(int n) {
        return this.getSwdlEnv().getHMIService().getText(n);
    }

    protected void formatHex(Buffer buffer, int n) {
        int n2;
        int[] nArray = new int[8];
        int n3 = n;
        for (n2 = 0; n2 < 8; ++n2) {
            nArray[7 - n2] = n3 & 0xF;
            n3 >>= 4;
        }
        for (n2 = 0; n2 < 8; ++n2) {
            buffer.append(DIGIT[nArray[n2]]);
        }
    }

    protected String intToHex(int n) {
        Buffer buffer = new Buffer();
        buffer.append("0x");
        this.formatHex(buffer, n);
        return buffer.toString();
    }

    public abstract String getTextConstantInterruptDownload();

    public abstract String getTextConstantCustProgressUserInterrupt();

    public abstract String getTextConstantUnknown();

    public abstract String getTextConstantCustDevInfoManagerAlreadyOn();

    public abstract String getTextConstantCustDevInfoManagerUnsuccess();

    public abstract String getTextConstantCustDevInfoManagerSuccess();

    public abstract String getTextConstantCustNoDevice();

    public abstract String getLabelForAccessType(int var1, String var2);

    public abstract String getTextConstantDeviceInfo7();

    public abstract String getTextConstantDeviceInfo6();

    public abstract String getUpdateGeneralInformationText(boolean var1, String var2, String var3, boolean var4, String var5, int var6, int[] var7, boolean var8, int var9);

    public String getUpdateSignatureText(int[] nArray) {
        return "";
    }

    public abstract String getPopupTemplateText(int var1);

    public abstract String getFileErrorText(int var1);

    public abstract String getSubTitleText(int var1);

    public abstract String getTextConstantCustProgressPleaseInsert();

    public abstract String getTextConstantPopupMessage14();

    public abstract String getUpdateGeneralProgressText(GeneralProgress var1);

    public abstract String getUpdateLostDevicesText(String[] var1);

    public abstract String getUpdateStaticProgressDetailsWithProgressText(int var1, int var2, short var3, String var4);

    public abstract String getUpdateStaticProgressDetailsWithoutProgressText(int var1, int var2, short var3, String var4);

    public abstract String getTextConstantProgress3();

    public abstract String getTextConstantRetryDownload();

    public abstract String getSelectionErrorNoFittingText();

    public abstract String getSelectionErrorMoreThanOneText();

    public abstract String getSelectionErrorUpdateInconsistentText();

    public abstract String getSelectionErrorIncompDevicesText();

    public abstract String getTextConstantCustUotaUpdateUnavailable();

    public abstract String getTextConstantCustUotaAlreadyInstalled();

    public abstract String getTextConstantWaiting();

    public abstract String getTextConstantOK();

    public abstract String getTextConstantUnexpectedResultFromConsistencyCheck();

    public abstract String getTextConstantRequires();

    public abstract String getTextConstantEngSelectManagerAbort();

    public abstract String getTextConstantEngSelectManagerConfirmed();

    public abstract String getTextConstantEngSelectManagerFailed();

    public abstract String getTextConstantDeviceInfo1();

    public abstract String getDetailedSummaryText(int var1);

    public abstract String[] getDefaultFiles();

    public abstract String getLanguageErrorText();

    public abstract String getErrorText(int var1);

    public abstract String getErrorText9();

    public abstract String[] getUnusualEventData(int var1);

    public abstract String getDlProgressAsText(int var1);

    public abstract String getTextConstantDevicesReady();

    public abstract String getReleaseErrorTemplate(int var1);

    public abstract String getTextConstantUndefinedError();

    public abstract String getConsistencyMessage(int var1, String var2, int var3);

    public abstract String getMetainfoErrorTemplate(int var1);
}

