/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.dsi;

import de.audi.atip.util.StringUtilities;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.dsi.AbstractSwdlDSIHandler;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IDeviceInfoManager;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfo;
import org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener;

public class SwdlDSIHandlerDeviceInfo
extends AbstractSwdlDSIHandler
implements DSISwdlDeviceInfoListener {
    protected IDeviceInfoManager deviceInfoManager = null;
    private boolean summaryNotification = false;
    private int accessType = 0;

    SwdlDSIHandlerDeviceInfo(SwdlEnv swdlEnv) {
        super("SwdlDSIHandlerDeviceInfo", swdlEnv);
    }

    private DSISwdlDeviceInfo getDSISwdlDeviceInfo() {
        return (DSISwdlDeviceInfo)this.getDSI();
    }

    public void getSelectionManager(IDeviceInfoManager iDeviceInfoManager) {
        this.deviceInfoManager = iDeviceInfoManager;
    }

    String[] getDefaultFiles() {
        return this.getTextFactory().getDefaultFiles();
    }

    public void doSetDeviceSelection(int n, int n2) {
        this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] -> doSetDeviceSelection( %1, %2 )", (long)n, (long)n2);
        this.getDSISwdlDeviceInfo().setDeviceSelection(n, n2);
    }

    public void doSetAccessType(int n) {
        this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] -> setAccessType( %1 )", (long)n);
        this.accessType = n;
        this.getDSISwdlDeviceInfo().setAccessType(n);
    }

    public int getAccessType() {
        return this.accessType;
    }

    public void doGetDevices() {
        this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] -> getDevices()");
        this.getDSISwdlDeviceInfo().getDevices();
    }

    public void getDevices(String[] stringArray, int[] nArray) {
        try {
            if (stringArray == null) {
                stringArray = EMPTY_STRING_ARRAY;
            }
            if (nArray == null) {
                nArray = EMPTY_INT_ARRAY;
            }
            this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- getDevices() ");
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] Device: %1 %2 ", (Object)stringArray[i2], (long)nArray[i2]);
            }
            this.deviceInfoManager.updateDeviceList(stringArray, nArray, true);
        }
        catch (Exception exception) {
            this.dsiCallbackError("getDevices", exception);
        }
    }

    public void doGetFileInfoPath(int n) {
        this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] -> doGetFileInfoPath()");
        this.getDSISwdlDeviceInfo().getInfoFilePath(n);
    }

    public void getInfoFilePath(int n, String string, String string2) {
        try {
            if (this.deviceInfoManager.getCurrentDeviceId() == n) {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- getInfoFilePath( %1, %2 ) ", (Object)string, (Object)string2);
                this.deviceInfoManager.updateInfoFilePath(string, string2);
            } else {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- getInfoFilePath: ignored due to not requested deviceIndex and moduleIndex.");
            }
        }
        catch (Exception exception) {
            this.dsiCallbackError("getInfoFilePath", exception);
        }
    }

    public void doGetModules(int n) {
        this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] -> getModules()");
        this.getDSISwdlDeviceInfo().getModules(n);
    }

    public void getModules(int n, String[] stringArray, int[] nArray, short[] sArray) {
        try {
            if (this.deviceInfoManager.getCurrentDeviceId() == n) {
                if (stringArray == null) {
                    stringArray = EMPTY_STRING_ARRAY;
                }
                if (nArray == null) {
                    nArray = EMPTY_INT_ARRAY;
                }
                if (sArray == null) {
                    sArray = EMPTY_SHORT_ARRAY;
                }
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- getModules() ");
                this.deviceInfoManager.updateModuleList(stringArray, nArray, sArray);
            } else {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- getModules: ignored due to wrong deviceIndex.");
            }
        }
        catch (Exception exception) {
            this.dsiCallbackError("getModules", exception);
        }
    }

    public void queryIsDataModule(int n, int n2) {
        this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] -> isDataModule( %1, %2 )", (long)n, (long)n2);
        this.getDSISwdlDeviceInfo().isDataModule(n, n2);
    }

    public void isDataModule(int n, int n2, boolean bl) {
        try {
            if (this.deviceInfoManager.getCurrentDeviceId() == n && this.deviceInfoManager.getCurrentModuleId() == n2) {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- SwdlDeviceInfo.isDataModule( %1 ) ", (Object)bl);
                this.deviceInfoManager.setIsDataModule(bl);
                if (bl) {
                    this.deviceInfoManager.updateFileList(EMPTY_STRING_ARRAY);
                    this.doGetFileNames(n, n2);
                } else {
                    this.deviceInfoManager.updateFileList(this.getDefaultFiles());
                }
                this.deviceInfoManager.doGetFileInfos();
            } else {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- isDataModule: ignored due to wrong deviceIndex and moduleIndex.");
            }
        }
        catch (Exception exception) {
            this.dsiCallbackError("isDataModule", exception);
        }
    }

    public void queryIsNoExclusiveBoloUpdate(int n, int n2) {
        this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] -> isNoExclusiveBoloUpdate( %1, %2 )", (long)n, (long)n2);
        this.getDSISwdlDeviceInfo().isNoExclusiveBoloUpdate(n, n2);
    }

    public void isNoExclusiveBoloUpdate(int n, int n2, boolean bl) {
        try {
            if (this.deviceInfoManager.getCurrentDeviceId() == n && this.deviceInfoManager.getCurrentModuleId() == n2) {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- SwdlDeviceInfo.isNoExclusiveBoloUpdate( %1 ) ", (Object)bl);
                this.deviceInfoManager.setIsNoExclusiveBoloUpdate(bl);
            } else {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- isNoExclusiveBoloUpdate: ignored due to wrong deviceIndex and moduleIndex.");
            }
        }
        catch (Exception exception) {
            this.dsiCallbackError("isNoExclusiveBoloUpdate", exception);
        }
    }

    public void doGetVersions(int n, int n2) {
        this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] -> getVersions( %1, %2 )", (long)n, (long)n2);
        this.getDSISwdlDeviceInfo().getVersions(n, n2);
    }

    public void getVersions(int n, int n2, long[] lArray) {
        try {
            if (this.deviceInfoManager.getCurrentDeviceId() == n && this.deviceInfoManager.getCurrentModuleId() == n2) {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- SwdlDeviceInfo.getVersions() ");
                if (lArray == null) {
                    lArray = EMPTY_LONG_ARRAY;
                }
                for (int i2 = 0; i2 < lArray.length; ++i2) {
                    this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] Version: %1 ", lArray[i2]);
                }
                this.deviceInfoManager.setVersions(lArray);
            } else {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- getVersions: ignored due to wrong deviceIndex and moduleIndex.");
            }
        }
        catch (Exception exception) {
            this.dsiCallbackError("getVersions", exception);
        }
    }

    public void doGetTargetVersions(int n, int n2) {
        this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] -> getTargetVersions( %1, %2 )", (long)n, (long)n2);
        this.getDSISwdlDeviceInfo().getTargetVersions(n, n2);
    }

    public void getTargetVersions(int n, int n2, long[] lArray) {
        try {
            if (this.deviceInfoManager.getCurrentDeviceId() == n && this.deviceInfoManager.getCurrentModuleId() == n2) {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- SwdlDeviceInfo.getTargetVersions() ");
                if (lArray == null) {
                    lArray = EMPTY_LONG_ARRAY;
                }
                for (int i2 = 0; i2 < lArray.length; ++i2) {
                    this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] TargetVersion: %1 ", lArray[i2]);
                }
                this.deviceInfoManager.setTargetVersions(lArray);
            } else {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- getTargetVersions: ignored due to wrong deviceIndex and moduleIndex.");
            }
        }
        catch (Exception exception) {
            this.dsiCallbackError("getTargetVersions", exception);
        }
    }

    public void doGetAdditionalInfo(int n, int n2) {
        this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] -> getAdditionalInfo( %1, %2 )", (long)n, (long)n2);
        this.getDSISwdlDeviceInfo().getAdditionalInfo(n, n2);
    }

    public void getAdditionalInfo(int n, int n2, int[] nArray) {
        try {
            if (this.deviceInfoManager.getCurrentDeviceId() == n && this.deviceInfoManager.getCurrentModuleId() == n2) {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- getAdditionalInfo( %1 ) ", (Object)nArray);
                if (nArray == null) {
                    nArray = EMPTY_INT_ARRAY;
                }
                this.deviceInfoManager.setAdditionalInfo(nArray);
            } else {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- getAdditionalInfo: ignored due to wrong deviceIndex and moduleIndex.");
            }
        }
        catch (Exception exception) {
            this.dsiCallbackError("getAdditionalInfo", exception);
        }
    }

    void doGetFileNames(int n, int n2) {
        this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] -> getFileNames( %1, %2 )", (long)n, (long)n2);
        this.getDSISwdlDeviceInfo().getFileNames(n, n2);
    }

    public void getFileNames(int n, int n2, String[] stringArray) {
        try {
            if (this.deviceInfoManager.getCurrentDeviceId() == n && this.deviceInfoManager.getCurrentModuleId() == n2) {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- getFileNames() ");
                if (stringArray == null) {
                    stringArray = EMPTY_STRING_ARRAY;
                }
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] FileName: %1 ", (Object)stringArray[i2]);
                }
                this.deviceInfoManager.updateFileList(stringArray);
            } else {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- getFileNames: ignored due to wrong deviceIndex and moduleIndex.");
            }
        }
        catch (Exception exception) {
            this.dsiCallbackError("getFileNames", exception);
        }
    }

    public void doToggleSelection(int n, int n2, short s) {
        this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] -> toggleSelection( %1, %2, %3)", (Object)new Integer(n), (Object)new Integer(n2), (long)s);
        this.getDSISwdlDeviceInfo().toggleSelection(n, n2, s);
    }

    public void doGetFileDetails(int n, int n2, short s) {
        this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] -> getFileDetails( %1, %2, %3)", (Object)new Integer(n), (Object)new Integer(n2), (long)s);
        this.getDSISwdlDeviceInfo().getFileDetails(n, n2, s);
    }

    private String getDetailelSummaryText(int n) {
        return this.getTextFactory().getDetailedSummaryText(n);
    }

    public void getFileDetails(int n, int n2, int n3, long l, long l2, long l3, boolean bl, boolean bl2, String string, String string2) {
        try {
            if (this.deviceInfoManager.getCurrentDeviceId() == n && this.deviceInfoManager.getCurrentModuleId() == n2) {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- getFileDetails() ");
                Buffer buffer = new Buffer();
                StringUtilities.formatMessage(buffer, this.getDetailelSummaryText(n3), new String[]{SwdlEnv.formatVersion(l), SwdlEnv.formatVersion(l3), SwdlEnv.formatVersion(l2), bl ? "true" : "false"});
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] %1", (Object)buffer);
                this.deviceInfoManager.updateFileDetails(buffer.toString());
            } else {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- getInfoFilePath: ignored due to wrong deviceIndex and moduleIndex.");
            }
        }
        catch (Exception exception) {
            this.dsiCallbackError("getFileDetails", exception);
        }
    }

    public void doGetErrors(int n) {
        this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] -> getErrors( %1 )", (long)n);
        this.getDSISwdlDeviceInfo().getErrors(n);
    }

    private String getErrorText(int n) {
        return this.getTextFactory().getErrorText(n);
    }

    public void getErrors(int n, int[] nArray, short[] sArray) {
        try {
            if (this.deviceInfoManager.getCurrentDeviceId() == n) {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- getErrors( %1, %2 ) ", (Object)nArray, (Object)sArray);
                if (nArray == null) {
                    nArray = EMPTY_INT_ARRAY;
                }
                if (sArray == null) {
                    sArray = EMPTY_SHORT_ARRAY;
                }
                Buffer buffer = new Buffer();
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    String string = this.getErrorText(nArray[i2]);
                    if (string == null) continue;
                    if (i2 > 0) {
                        buffer.append('\n');
                    }
                    buffer.append(i2 + 1).append(") ");
                    StringUtilities.formatMessage(buffer, string, new String[]{Short.toString(sArray[i2])});
                }
                if (buffer.length() == 0) {
                    buffer.append(this.getTextFactory().getErrorText9());
                }
                this.deviceInfoManager.updateErrors(buffer.toString());
            } else {
                this.getLogDSI().log(10000000, "[SwdlDSIHandlerDeviceInfo] <- getErrors(%1): ignored due to wrong deviceIndex.", (long)n);
            }
        }
        catch (Exception exception) {
            this.dsiCallbackError("getErrors", exception);
        }
    }

    public void startSummaryChangedNotification() {
        this.setNotification(new int[]{1});
        this.summaryNotification = true;
    }

    public void stopSummaryChangedNotification() {
        this.clearNotification(new int[]{1});
        this.summaryNotification = false;
    }

    public void updateSummaryChanged(String string, int n) {
        if (n == 1) {
            try {
                this.getLogDSI().log(1000000, "[SwdlDSIHandlerDeviceInfo] <- SwdlSelection.updateSummaryChanged: %1", (Object)string);
                if (this.summaryNotification) {
                    this.deviceInfoManager.updateSummary(string);
                }
            }
            catch (Exception exception) {
                this.dsiCallbackError("updateSummaryChanged", exception);
            }
        } else {
            this.getLogDSI().log(1000000, "[SwdlDSIHandlerDeviceInfo] Invalid SwdlDeviceInfo.updateSummaryChanged: %1 ", (Object)string);
        }
    }

    public void asyncException(int n, String string, int n2) {
        this.getLogDSI().log(10000, "[SwdlDSIHandlerDeviceInfo] AsyncException( errorCode: %2, errorMsg: %1, requestType: %3 ) ocurred! ", (Object)string, (Object)new Integer(n), (long)n2);
    }

    public void getNumberOfPopups(int n) {
    }

    public void getPopup(int n, int n2, String string, int n3, int n4, int n5, String string2) {
    }

    public void getLanguages(int n, String[] stringArray, short s, short s2, short s3) {
    }
}

