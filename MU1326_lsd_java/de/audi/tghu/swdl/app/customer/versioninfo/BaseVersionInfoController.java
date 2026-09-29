/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.versioninfo;

import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.SwdlModels;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BaseVersionInfoController
implements I18NTarget {
    static final String BB_INFO_FILE_PATH = System.getProperty("BoardbookInfoFilePath", "/mnt/boardbook/");
    static final String BB_INFO_FILE_NAME;
    private final LogChannel logMain;
    private final SwdlEnv swdlEnv;
    private final SwdlModels swdlModels;

    public BaseVersionInfoController(SwdlEnv swdlEnv) {
        this.swdlEnv = swdlEnv;
        this.swdlModels = swdlEnv.getSwdlModels();
        this.logMain = swdlEnv.getLogMain();
    }

    @Override
    public void setLanguage(Language language) {
        this.readVersionInfo(language.getLanguageCode());
    }

    public void readVersionInfo(String string) {
        this.getLogMain().log(1078071040, "[BaseVersionInfoController].readVersionInfo(): Reading version info for language: %1", (Object)string);
        this.readBoardBookVersionInfo(string);
        this.readPhoneDriverVersionInfo(string);
    }

    private void readPhoneDriverVersionInfo(String string) {
        String string2;
        byte[] byArray = this.getSwdlEnv().getStorageMgr().getByteArray(570543106, 100, null);
        String string3 = string2 = byArray == null ? "" : new String(byArray);
        if (string2 == null || "".equals(string2)) {
            string2 = this.getSwdlEnv().getStorageMgr().getString(570543106, 100, null);
        }
        this.getLogMain().log(1078071040, "[BaseVersionInfoController].readPhoneDriverVersionInfo(): Found phone driver version: %1", (Object)string2);
        LabelModelApp labelModelApp = this.getSwdlModels().getPhoneDriverVersionInfoLabelModel();
        labelModelApp.setText(string2);
        labelModelApp.setStatus(null == string2 ? 0 : 1);
    }

    private void readBoardBookVersionInfo(String string) {
        File file = new File(BB_INFO_FILE_PATH, "update.txt");
        LabelModelApp labelModelApp = this.getSwdlModels().getBoardBookVersionInfoLabelModel();
        if (!file.exists() || !file.canRead()) {
            this.getLogMain().log(1078071040, "[DefaultVersionInfoController].readVersionInfo(): boardbook not installed or cannot read info file");
            labelModelApp.setText(null);
            labelModelApp.setStatus(0);
            return;
        }
        Map map = this.parseInfoFile(file);
        if (null == map) {
            this.getLogMain().log(10000, "[DefaultVersionInfoController].readVersionInfo(): Failed to read boardbook info file");
            labelModelApp.setText(null);
            labelModelApp.setStatus(0);
            return;
        }
        String string2 = this.getDisplayVersion(map, string);
        if (null == string2) {
            this.getLogMain().log(10000, "[DefaultVersionInfoController].readVersionInfo(): Failed to find display version for language: %1", (Object)string);
            labelModelApp.setText(null);
            labelModelApp.setStatus(0);
            return;
        }
        this.getLogMain().log(1078071040, "[DefaultVersionInfoController].readVersionInfo(): Found boardbook version: %1", (Object)string2);
        labelModelApp.setText(string2);
        labelModelApp.setStatus(1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Map parseInfoFile(File file) {
        this.getLogMain().log(1078071040, "[DefaultVersionInfoController].parseInfoFile(%1) ", (Object)file);
        HashMap hashMap = new HashMap();
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream(file);
            if (239 != fileInputStream.read() || 187 != fileInputStream.read() || 191 != fileInputStream.read()) {
                fileInputStream.close();
                fileInputStream = new FileInputStream(file);
            }
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
            int n = 0;
            while (true) {
                String string = bufferedReader.readLine();
                ++n;
                if (string == null) {
                    break;
                }
                int n2 = string.indexOf(61);
                if (n2 > 0 && n2 < string.length() - 1) {
                    String string2 = string.substring(0, n2);
                    String string3 = string.substring(n2 + 1);
                    hashMap.put(string2, string3);
                    continue;
                }
                if (0 == string.length() || '#' != string.charAt(0)) continue;
                this.getLogMain().log(10000, "[DefaultVersionInfoController].parseInfoFile(%1) ignore invalid line %3: '%2'", (Object)file, (Object)string, (long)n);
            }
        }
        catch (IOException iOException) {
            this.getLogMain().log(-1601830656, "[DefaultVersionInfoController].parseInfoFile(%1) failed with IOException %2", (Object)file, (Throwable)iOException);
            hashMap = null;
        }
        finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            }
            catch (IOException iOException) {
                fileInputStream = null;
            }
        }
        return hashMap;
    }

    private String getDisplayVersion(Map map, String string) {
        String string2 = (String)map.get(new StringBuffer().append("version.").append(string).toString());
        if (null == string2) {
            string2 = (String)map.get("version.default");
        }
        return string2;
    }

    SwdlEnv getSwdlEnv() {
        return this.swdlEnv;
    }

    SwdlModels getSwdlModels() {
        return this.swdlModels;
    }

    LogChannel getLogMain() {
        return this.logMain;
    }
}

