/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.redengineering.app;

import de.audi.tghu.redengineering.app.AbstractEngineeringTextFactory;

public class EngineeringTextFactoryEvo
extends AbstractEngineeringTextFactory {
    private static final String TEXT_CONSTANT_SWDL_HMIVERSION;
    private static final String TEXT_CONSTANT_SWDL_TEXTTOOLVERSION;
    private static final String TEXT_CONSTANT_ENG_TEXTTOOLVERSIONSDS;
    private static final String TEXT_CONSTANT_ENG_OPTIONDRAWERVERSION;
    private static final String TEXT_CONSTANT_SWDL_DSIIFCVERSION;
    private static final String TEXT_CONSTANT_SWDL_FRAMWORKVERSION;
    private static final String TEXT_CONSTANT_SWDL_KANZIVERSION;
    private static final String TEXT_CONSTANT_SWDL_CODE;
    private static final String TEXT_CONSTANT_SWDL_VERSION;
    private static final String TEXT_CONSTANT_SWDL_STATE;
    private static final String TEXT_CONSTANT_SWDL_VIN;
    private static final String TEXT_CONSTANT_SWDL_DATE;
    private static final String TEXT_CONSTANT_ENG_FSC_SUPPORTED;
    private static final String TEXT_CONSTANT_ENG_FSC_NOT_AVAILABLE;
    private static final String TEXT_CONSTANT_ENG_FSC_NO_LOGGUING_AVAILABLE;
    private static final String TEXT_CONSTANT_ENG_FSC_NOT_INSTALLED;
    private static final String TEXT_CONSTANT_ENG_FSC_NO_VALID_STRING;
    private static final String TEXT_CONSTANT_ENG_FSC_STATE_LEGAL;
    private static final String TEXT_CONSTANT_ENG_FSC_STATE_ILLEGAL;
    private static final String TEXT_CONSTANT_ENG_FSC_STATE_SUPPORTED;
    private static final String TEXT_CONSTANT_ENG_FSC_STATE_TEMP;
    private static final String TEXT_CONSTANT_ENG_FSC_STATE_PERM;
    private static final String TEXT_CONSTANT_ENG_FSC_STATE_NOT_INITIALIZED;

    private String getTextConstant(int n, String string) {
        String string2 = this.getI18nText(n);
        if (string2 == null || string2.length() == 0) {
            string2 = string;
        }
        return string2;
    }

    @Override
    String getTextConstantDownload() {
        return this.getTextConstant(-1594550016, "Download");
    }

    @Override
    String getTextConstantHMIVersion() {
        return this.getTextConstant(-1359668992, "HMI: ");
    }

    @Override
    String getTextConstantTextToolVersion() {
        return this.getTextConstant(150345984, "TextTool: ");
    }

    @Override
    String getTextConstantTextToolSDSVersion() {
        return this.getTextConstant(1893143296, "TextToolSDS: ");
    }

    @Override
    String getTextConstantOptionDrawerVersion() {
        return this.getTextConstant(1909920512, "OptionDrawer: ");
    }

    @Override
    String getTextConstantDsiIfcVersion() {
        return this.getTextConstant(-1577772800, "DSI: ");
    }

    @Override
    String getTextConstantFrameworkVersion() {
        return this.getTextConstant(-1376446208, "FW: ");
    }

    @Override
    String getTextConstantKanziVersion() {
        return this.getTextConstant(402004224, "Kanzi: ");
    }

    @Override
    String getTextConstantCode() {
        return this.getTextConstant(1643452672, "Code:");
    }

    @Override
    String getTextConstantVersion() {
        return this.getTextConstant(217454848, "Version:");
    }

    @Override
    String getTextConstantState() {
        return this.getTextConstant(133568768, "Status:");
    }

    @Override
    String getTextConstantVin() {
        return this.getTextConstant(234232064, "VIN:");
    }

    @Override
    String getTextConstantDate() {
        return this.getTextConstant(2079660288, "Datum:");
    }

    @Override
    String getTextConstantPermissionGranted() {
        return this.getTextConstant(-957015808, "Permission granted");
    }

    @Override
    String getTextConstantIllegal() {
        return this.getTextConstant(-1326114560, "Illegal");
    }

    @Override
    String getTextConstantPermissionPermanentWithdrawn() {
        return this.getTextConstant(-940238592, "Permission permanent withdrawn");
    }

    @Override
    String getTextConstantPermissionTemporarilyWithdrawn() {
        return this.getTextConstant(-923461376, "Permission temporarily withdrawn");
    }

    @Override
    public String getTextConstantExportFailed() {
        return this.getTextConstant(-1527441152, "export failed");
    }

    @Override
    public String getTextConstantImportFailed() {
        return this.getTextConstant(-1309337344, "import failed");
    }

    @Override
    public String getTextConstantFinishedSuccessfull() {
        return this.getTextConstant(-1292560128, "import finished successfull");
    }

    @Override
    public String getTextConstantUnzippingFailedImportFailed() {
        return this.getTextConstant(200677632, "unzipping failed  --> import failed");
    }

    @Override
    public String getTextConstantZippingFailedExportFailed() {
        return this.getTextConstant(267786496, "unzipping failed  --> export failed");
    }

    @Override
    public String getTextConstantDecryptionFailedInportFailed() {
        return this.getTextConstant(2096437504, "decryption failed --> import failed");
    }

    @Override
    public String getTextConstantNoMediumUsbSdFoundExportFailed() {
        return this.getI18nText(-1007347456);
    }

    @Override
    public String getTextConstantEncryptionFailedExportFailed() {
        return this.getI18nText(-1560995584);
    }

    @Override
    public String getTextConstantExportFinishedSuccessfull() {
        return this.getI18nText(-1510663936);
    }

    @Override
    public String getTextConstantCopyFailedExportFailed() {
        return this.getI18nText(1861556480);
    }

    @Override
    public String getTextConstantCopyFinishedSuccessfullEndOfImport() {
        return this.getI18nText(1895110912);
    }

    @Override
    public String getTextConstantCopyFailedImportFailed() {
        return this.getI18nText(1878333696);
    }

    @Override
    public String getTextConstantNoMediumUsbSdFoundImportNotPossible() {
        return this.getI18nText(-990570240);
    }

    @Override
    public String getTextConstantImportFinishedSuccessfull() {
        return this.getI18nText(-1292560128);
    }

    @Override
    String getTextConstantFSCSupported() {
        return this.getTextConstant(1607930624, "Supported, but not on this main unit");
    }

    @Override
    String getTextConstantFSCNotAvailable() {
        return this.getTextConstant(1658262272, "No function enabling codes available");
    }

    @Override
    String getTextConstantFSCNotInstalled() {
        return this.getTextConstant(1675039488, "No Function Enabling Codes installed.");
    }

    @Override
    String getTextConstantFSCNoLoggingAvailable() {
        return this.getTextConstant(1624707840, "No logging information available");
    }

    @Override
    String getTextConstantFSCNoValidString() {
        return this.getTextConstant(1641485056, "No valid string");
    }

    @Override
    String getTextConstantFSCStateLegal() {
        return "legal";
    }

    @Override
    String getTextConstantFSCStateIllegal() {
        return "illegal";
    }

    @Override
    String getTextConstantFSCStateSupported() {
        return "supported";
    }

    @Override
    String getTextConstantFSCStateTemp() {
        return "temp";
    }

    @Override
    String getTextConstantFSCStatePerm() {
        return "perm";
    }

    @Override
    String getTextConstantFSCStateNotInitialized() {
        return "not initialized";
    }

    @Override
    String getTextComstantFSCImportFeatureFailed() {
        return this.getI18nText(1574376192);
    }

    @Override
    String getTextComstantFSCImportFeatureSuccessfull() {
        return this.getI18nText(1591153408);
    }

    @Override
    String getTextComstantFSCExportVersionFailed() {
        return this.getI18nText(1540821760);
    }

    @Override
    String getTextComstantFSCExportVersionSuccessfull() {
        return this.getI18nText(1557598976);
    }
}

