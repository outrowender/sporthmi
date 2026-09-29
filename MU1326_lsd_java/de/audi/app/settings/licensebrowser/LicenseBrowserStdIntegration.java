/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.licensebrowser;

import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.licensebrowser.ILicenseBrowser;
import de.audi.atip.browser.IBrowserHandler;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LicenseBrowserStdIntegration
implements ILicenseBrowser {
    private String PATH_PREFIX = System.getProperty("license.path.prefix", "/extbin/apps/hmi/HMI/license/");
    private String FILE_NAME = System.getProperty("license.file.name", "license.txt");
    private LabelModelApp licenseLabel;
    private final LogChannel logChannel;
    private final SettingsEnv env;
    private final Buffer license;
    private String LINE_SEPARATOR = System.getProperty("line.separator", "\n");

    public LicenseBrowserStdIntegration(SettingsEnv settingsEnv) {
        this.env = settingsEnv;
        this.logChannel = this.env.getFw().getLogChannel("App.Settings.LB");
        this.licenseLabel = this.env.getLabelModel(432672768);
        if (this.licenseLabel == null) {
            this.logChannel.log(10000, "LicenseBrowserStdIntegration#init: LicenseListModel not found");
        }
        this.license = new Buffer(100);
    }

    @Override
    public void browserEntered() {
        if (this.license.length() == 0) {
            this.readLicense();
        }
    }

    @Override
    public void setBrowserHandler(IBrowserHandler iBrowserHandler) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void readLicense() {
        this.logChannel.log(-2137614336, "LicenseBrowserStdIntegration#readLicense: Reading license from %1.", (Object)new StringBuffer().append(this.PATH_PREFIX).append(this.FILE_NAME).toString());
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(new StringBuffer().append(this.PATH_PREFIX).append(this.FILE_NAME).toString())));
            String string = bufferedReader.readLine();
            while (string != null) {
                this.license.append(string).append(this.LINE_SEPARATOR).append(this.LINE_SEPARATOR);
                string = bufferedReader.readLine();
            }
        }
        catch (IOException iOException) {
            this.logChannel.log(10000, "LicenseBrowserStdIntegration#readLicense: IOException by reading license: %1", (Object)iOException.toString());
            this.license.clear();
            this.license.append("No license found");
        }
        finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
            catch (IOException iOException) {
                this.logChannel.log(10000, "LicenseBrowserStdIntegration#readLicense: IOException by closing buffered FileReader : %1", (Object)iOException.toString());
            }
        }
        if (this.licenseLabel != null) {
            this.licenseLabel.setText(this.license.toString());
        }
    }
}

