/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd.dsi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

public class KbdScreenShotManager {
    private static final int MAX_SCREEN_SHOTS_PROD = 50;
    private static final int MAX_SCREEN_SHOTS_DEV = 200;
    private static final String SCREENSHOT_PROPERTY = "ErrorDumpDir";
    private static final String DEFAULT_SCREENSHOT_DIRECTORY = "/mnt/ota/system/logs";
    private static final String SCREEN_SHOT_NAME = "ScreenShot";
    private static final String SCREEN_SHOT_EXTENSION = ".png";
    private final SimpleDateFormat timestampFormatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
    private final IFrameworkAccess framework;
    private final LogChannel log;
    private final String screenShotDirectory;
    private final int maxScreenShots;

    public KbdScreenShotManager(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.log = iFrameworkAccess.getLogChannel("Fw.Kbd.ScreenShot");
        this.screenShotDirectory = System.getProperty(SCREENSHOT_PROPERTY, DEFAULT_SCREENSHOT_DIRECTORY);
        this.maxScreenShots = iFrameworkAccess.isPBuild() ? 50 : 200;
    }

    private IFrameworkAccess getFramework() {
        return this.framework;
    }

    public String doScreenShot() {
        this.log.log(1000000, "ScreenShotManager.doScreenShot()");
        try {
            String string = this.getScreenshotName();
            if (string != null) {
                this.log.log(1000000, "ScreenShotManager.doScreenShot: Take screenshot! (name=%1)", (Object)string);
                this.getFramework().getHMIService().takeScreenshot(0, string);
                return string;
            }
        }
        catch (Exception exception) {
            this.log.log(100000, "ScreenShotManager.doScreenShot: An exception occurred!", (Throwable)exception);
        }
        return null;
    }

    private String getScreenshotName() {
        String string = this.getScreenShotDirectory();
        if (string != null) {
            Buffer buffer = new Buffer(100);
            Date date = new Date(this.getFramework().getKombiTime());
            this.log.log(10000000, "ScreenShotManager.getScreenshotName: Retrieved date! (date=%1)", (Object)date);
            buffer.append(string);
            buffer.append(SCREEN_SHOT_NAME);
            buffer.append('_');
            buffer.append(this.timestampFormatter.format(date));
            buffer.append('_');
            buffer.append(this.getScreenName());
            buffer.append(SCREEN_SHOT_EXTENSION);
            return buffer.toString();
        }
        this.log.log(10000, "ScreenShotManager.getScreenshotName: No directory found! No screenshot will be created!");
        return null;
    }

    private String getScreenName() {
        String string = null;
        try {
            int n = this.framework.getHMIService().getRootWindow(0).getCurrentScreen().getID();
            Method method = Class.forName("de.audi.atip.diag.HMIDiagScreenNameMapping").getMethod("getScreenName", new Class[]{Integer.TYPE});
            string = (String)method.invoke(null, new Integer[]{new Integer(n)});
        }
        catch (Exception exception) {
            this.log.log(10000, "ScreenShotManager.getScreenName() ERROR");
        }
        return string;
    }

    private String getScreenShotDirectory() {
        this.cleanScreenShotDirectory(this.screenShotDirectory);
        return this.screenShotDirectory;
    }

    private void cleanScreenShotDirectory(String string) {
        int n = 0;
        new File(string).mkdirs();
        String[] stringArray = new File(string).list();
        if (stringArray != null) {
            ArrayList arrayList = new ArrayList(stringArray.length);
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (!this.isScreenShotFile(stringArray[i2])) continue;
                arrayList.add(stringArray[i2]);
                ++n;
            }
            Collections.sort(arrayList);
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                if (n < this.maxScreenShots) {
                    this.log.log(10000000, "ScreenShotManager.cleanScreenShotDirectory: The number of screenshots is smaller than the maximum (%2)! (count=%1)", (long)n, (long)this.maxScreenShots);
                    break;
                }
                String string2 = (String)iterator.next();
                this.log.log(1000000, "ScreenShotManager.cleanScreenShotDirectory: Remove old file! (file=%1, count=%2)", (Object)string2, (long)n);
                new File(string + "/" + string2).delete();
                --n;
            }
        }
    }

    private boolean isScreenShotFile(String string) {
        return string.startsWith(SCREEN_SHOT_NAME) && string.endsWith(SCREEN_SHOT_EXTENSION);
    }
}

