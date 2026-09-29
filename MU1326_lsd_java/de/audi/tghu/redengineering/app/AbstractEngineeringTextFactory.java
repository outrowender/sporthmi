/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.redengineering.app;

import de.audi.tghu.redengineering.app.EngineeringEnv;

public abstract class AbstractEngineeringTextFactory {
    private EngineeringEnv engineeringEnv;

    protected final EngineeringEnv getEngineeringEnv() {
        return this.engineeringEnv;
    }

    public final void setEngineeringEnv(EngineeringEnv engineeringEnv) {
        this.engineeringEnv = engineeringEnv;
    }

    protected String getI18nText(int n) {
        return this.getEngineeringEnv().getHMIService().getText(n);
    }

    abstract String getTextConstantDownload() {
    }

    abstract String getTextConstantHMIVersion() {
    }

    abstract String getTextConstantTextToolVersion() {
    }

    abstract String getTextConstantTextToolSDSVersion() {
    }

    abstract String getTextConstantOptionDrawerVersion() {
    }

    abstract String getTextConstantDsiIfcVersion() {
    }

    abstract String getTextConstantFrameworkVersion() {
    }

    abstract String getTextConstantKanziVersion() {
    }

    abstract String getTextConstantCode() {
    }

    abstract String getTextConstantVersion() {
    }

    abstract String getTextConstantState() {
    }

    abstract String getTextConstantVin() {
    }

    abstract String getTextConstantDate() {
    }

    abstract String getTextConstantPermissionGranted() {
    }

    abstract String getTextConstantIllegal() {
    }

    abstract String getTextConstantPermissionPermanentWithdrawn() {
    }

    abstract String getTextConstantPermissionTemporarilyWithdrawn() {
    }

    abstract String getTextConstantFSCSupported() {
    }

    abstract String getTextConstantFSCNotAvailable() {
    }

    abstract String getTextConstantFSCNotInstalled() {
    }

    abstract String getTextConstantFSCNoLoggingAvailable() {
    }

    abstract String getTextConstantFSCNoValidString() {
    }

    abstract String getTextConstantFSCStateLegal() {
    }

    abstract String getTextConstantFSCStateIllegal() {
    }

    abstract String getTextConstantFSCStateSupported() {
    }

    abstract String getTextConstantFSCStateTemp() {
    }

    abstract String getTextConstantFSCStatePerm() {
    }

    abstract String getTextConstantFSCStateNotInitialized() {
    }

    abstract String getTextComstantFSCImportFeatureFailed() {
    }

    abstract String getTextComstantFSCImportFeatureSuccessfull() {
    }

    abstract String getTextComstantFSCExportVersionFailed() {
    }

    abstract String getTextComstantFSCExportVersionSuccessfull() {
    }

    public abstract String getTextConstantExportFailed() {
    }

    public abstract String getTextConstantImportFailed() {
    }

    public abstract String getTextConstantFinishedSuccessfull() {
    }

    public abstract String getTextConstantUnzippingFailedImportFailed() {
    }

    public abstract String getTextConstantZippingFailedExportFailed() {
    }

    public abstract String getTextConstantDecryptionFailedInportFailed() {
    }

    public abstract String getTextConstantNoMediumUsbSdFoundExportFailed() {
    }

    public abstract String getTextConstantEncryptionFailedExportFailed() {
    }

    public abstract String getTextConstantExportFinishedSuccessfull() {
    }

    public abstract String getTextConstantCopyFailedExportFailed() {
    }

    public abstract String getTextConstantCopyFinishedSuccessfullEndOfImport() {
    }

    public abstract String getTextConstantCopyFailedImportFailed() {
    }

    public abstract String getTextConstantNoMediumUsbSdFoundImportNotPossible() {
    }

    public abstract String getTextConstantImportFinishedSuccessfull() {
    }
}

