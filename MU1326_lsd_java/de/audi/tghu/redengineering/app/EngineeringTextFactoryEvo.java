/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.redengineering.app;

import de.audi.tghu.redengineering.app.AbstractEngineeringTextFactory;

public class EngineeringTextFactoryEvo
extends AbstractEngineeringTextFactory {
    private static final String TEXT_CONSTANT_SWDL_HMIVERSION = "HMI: ";
    private static final String TEXT_CONSTANT_SWDL_TEXTTOOLVERSION = "TextTool: ";
    private static final String TEXT_CONSTANT_ENG_TEXTTOOLVERSIONSDS = "TextToolSDS: ";
    private static final String TEXT_CONSTANT_ENG_OPTIONDRAWERVERSION = "OptionDrawer: ";
    private static final String TEXT_CONSTANT_SWDL_DSIIFCVERSION = "DSI: ";
    private static final String TEXT_CONSTANT_SWDL_FRAMWORKVERSION = "FW: ";
    private static final String TEXT_CONSTANT_SWDL_KANZIVERSION = "Kanzi: ";
    private static final String TEXT_CONSTANT_SWDL_CODE = "Code:";
    private static final String TEXT_CONSTANT_SWDL_VERSION = "Version:";
    private static final String TEXT_CONSTANT_SWDL_STATE = "Status:";
    private static final String TEXT_CONSTANT_SWDL_VIN = "VIN:";
    private static final String TEXT_CONSTANT_SWDL_DATE = "Datum:";
    private static final String TEXT_CONSTANT_ENG_FSC_SUPPORTED = "Supported, but not on this main unit";
    private static final String TEXT_CONSTANT_ENG_FSC_NOT_AVAILABLE = "No function enabling codes available";
    private static final String TEXT_CONSTANT_ENG_FSC_NO_LOGGUING_AVAILABLE = "No logging information available";
    private static final String TEXT_CONSTANT_ENG_FSC_NOT_INSTALLED = "No Function Enabling Codes installed.";
    private static final String TEXT_CONSTANT_ENG_FSC_NO_VALID_STRING = "No valid string";
    private static final String TEXT_CONSTANT_ENG_FSC_STATE_LEGAL = "legal";
    private static final String TEXT_CONSTANT_ENG_FSC_STATE_ILLEGAL = "illegal";
    private static final String TEXT_CONSTANT_ENG_FSC_STATE_SUPPORTED = "supported";
    private static final String TEXT_CONSTANT_ENG_FSC_STATE_TEMP = "temp";
    private static final String TEXT_CONSTANT_ENG_FSC_STATE_PERM = "perm";
    private static final String TEXT_CONSTANT_ENG_FSC_STATE_NOT_INITIALIZED = "not initialized";

    private String getTextConstant(int n, String string) {
        String string2 = this.getI18nText(n);
        if (string2 == null || string2.length() == 0) {
            string2 = string;
        }
        return string2;
    }

    String getTextConstantDownload() {
        return this.getTextConstant(1701280, "Download");
    }

    String getTextConstantHMIVersion() {
        return this.getTextConstant(1701294, TEXT_CONSTANT_SWDL_HMIVERSION);
    }

    String getTextConstantTextToolVersion() {
        return this.getTextConstant(1701384, TEXT_CONSTANT_SWDL_TEXTTOOLVERSION);
    }

    String getTextConstantTextToolSDSVersion() {
        return this.getTextConstant(1300336, TEXT_CONSTANT_ENG_TEXTTOOLVERSIONSDS);
    }

    String getTextConstantOptionDrawerVersion() {
        return this.getTextConstant(1300337, TEXT_CONSTANT_ENG_OPTIONDRAWERVERSION);
    }

    String getTextConstantDsiIfcVersion() {
        return this.getTextConstant(1701281, TEXT_CONSTANT_SWDL_DSIIFCVERSION);
    }

    String getTextConstantFrameworkVersion() {
        return this.getTextConstant(1701293, TEXT_CONSTANT_SWDL_FRAMWORKVERSION);
    }

    String getTextConstantKanziVersion() {
        return this.getTextConstant(1701399, TEXT_CONSTANT_SWDL_KANZIVERSION);
    }

    String getTextConstantCode() {
        return this.getTextConstant(1701217, TEXT_CONSTANT_SWDL_CODE);
    }

    String getTextConstantVersion() {
        return this.getTextConstant(1701388, TEXT_CONSTANT_SWDL_VERSION);
    }

    String getTextConstantState() {
        return this.getTextConstant(1701383, TEXT_CONSTANT_SWDL_STATE);
    }

    String getTextConstantVin() {
        return this.getTextConstant(1701389, TEXT_CONSTANT_SWDL_VIN);
    }

    String getTextConstantDate() {
        return this.getTextConstant(1701243, TEXT_CONSTANT_SWDL_DATE);
    }

    String getTextConstantPermissionGranted() {
        return this.getTextConstant(1701318, "Permission granted");
    }

    String getTextConstantIllegal() {
        return this.getTextConstant(1701296, "Illegal");
    }

    String getTextConstantPermissionPermanentWithdrawn() {
        return this.getTextConstant(1701319, "Permission permanent withdrawn");
    }

    String getTextConstantPermissionTemporarilyWithdrawn() {
        return this.getTextConstant(1701320, "Permission temporarily withdrawn");
    }

    public String getTextConstantExportFailed() {
        return this.getTextConstant(1701284, "export failed");
    }

    public String getTextConstantImportFailed() {
        return this.getTextConstant(1701297, "import failed");
    }

    public String getTextConstantFinishedSuccessfull() {
        return this.getTextConstant(1701298, "import finished successfull");
    }

    public String getTextConstantUnzippingFailedImportFailed() {
        return this.getTextConstant(1701387, "unzipping failed  --> import failed");
    }

    public String getTextConstantZippingFailedExportFailed() {
        return this.getTextConstant(1701391, "unzipping failed  --> export failed");
    }

    public String getTextConstantDecryptionFailedInportFailed() {
        return this.getTextConstant(1701244, "decryption failed --> import failed");
    }

    public String getTextConstantNoMediumUsbSdFoundExportFailed() {
        return this.getI18nText(1701315);
    }

    public String getTextConstantEncryptionFailedExportFailed() {
        return this.getI18nText(1701282);
    }

    public String getTextConstantExportFinishedSuccessfull() {
        return this.getI18nText(1701285);
    }

    public String getTextConstantCopyFailedExportFailed() {
        return this.getI18nText(1701230);
    }

    public String getTextConstantCopyFinishedSuccessfullEndOfImport() {
        return this.getI18nText(1701232);
    }

    public String getTextConstantCopyFailedImportFailed() {
        return this.getI18nText(1701231);
    }

    public String getTextConstantNoMediumUsbSdFoundImportNotPossible() {
        return this.getI18nText(1701316);
    }

    public String getTextConstantImportFinishedSuccessfull() {
        return this.getI18nText(1701298);
    }

    String getTextConstantFSCSupported() {
        return this.getTextConstant(1300319, TEXT_CONSTANT_ENG_FSC_SUPPORTED);
    }

    String getTextConstantFSCNotAvailable() {
        return this.getTextConstant(1300322, TEXT_CONSTANT_ENG_FSC_NOT_AVAILABLE);
    }

    String getTextConstantFSCNotInstalled() {
        return this.getTextConstant(1300323, TEXT_CONSTANT_ENG_FSC_NOT_INSTALLED);
    }

    String getTextConstantFSCNoLoggingAvailable() {
        return this.getTextConstant(1300320, TEXT_CONSTANT_ENG_FSC_NO_LOGGUING_AVAILABLE);
    }

    String getTextConstantFSCNoValidString() {
        return this.getTextConstant(1300321, TEXT_CONSTANT_ENG_FSC_NO_VALID_STRING);
    }

    String getTextConstantFSCStateLegal() {
        return TEXT_CONSTANT_ENG_FSC_STATE_LEGAL;
    }

    String getTextConstantFSCStateIllegal() {
        return TEXT_CONSTANT_ENG_FSC_STATE_ILLEGAL;
    }

    String getTextConstantFSCStateSupported() {
        return TEXT_CONSTANT_ENG_FSC_STATE_SUPPORTED;
    }

    String getTextConstantFSCStateTemp() {
        return TEXT_CONSTANT_ENG_FSC_STATE_TEMP;
    }

    String getTextConstantFSCStatePerm() {
        return TEXT_CONSTANT_ENG_FSC_STATE_PERM;
    }

    String getTextConstantFSCStateNotInitialized() {
        return TEXT_CONSTANT_ENG_FSC_STATE_NOT_INITIALIZED;
    }

    String getTextComstantFSCImportFeatureFailed() {
        return this.getI18nText(1300317);
    }

    String getTextComstantFSCImportFeatureSuccessfull() {
        return this.getI18nText(1300318);
    }

    String getTextComstantFSCExportVersionFailed() {
        return this.getI18nText(1300315);
    }

    String getTextComstantFSCExportVersionSuccessfull() {
        return this.getI18nText(1300316);
    }
}

