/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.BundleInfo;
import de.dreisoft.lsd.LSDLogService;
import de.dreisoft.lsd.ServiceDelegator;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

public final class BundleRegistry {
    private static final String KEY_ACTIVATOR = "Bundle.Activator.";
    private static final String KEY_NAME = "Bundle.Name.";
    private String autostartBundleIds;
    private String autostartBundleNames;
    private BundleInfo[] bundles;

    private BundleRegistry() {
    }

    static BundleRegistry getInstance() {
        return SingletonHolder.INSTANCE;
    }

    protected void load(ResourceBundle resourceBundle) throws BundleException {
        if (resourceBundle == null) {
            throw new IllegalArgumentException("ResourceBundle is null!");
        }
        Enumeration enumeration = resourceBundle.getKeys();
        Properties properties = new Properties();
        while (enumeration.hasMoreElements()) {
            String string = (String)enumeration.nextElement();
            String string2 = resourceBundle.getString(string);
            properties.setProperty(string, string2);
        }
        this.bundles = this.loadByPropertiesInternal(properties);
    }

    protected void load(File file) throws BundleException {
        BufferedInputStream bufferedInputStream = null;
        try {
            Properties properties = new Properties();
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 10240);
            properties.load(bufferedInputStream);
            this.bundles = this.loadByPropertiesInternal(properties);
        }
        catch (IOException iOException) {
            throw new BundleException(iOException.toString(), iOException);
        }
        finally {
            try {
                bufferedInputStream.close();
            }
            catch (IOException iOException) {
                throw new BundleException(iOException.toString(), iOException);
            }
        }
    }

    protected void load(Properties properties) throws BundleException {
        this.bundles = this.loadByPropertiesInternal(properties);
    }

    private void initServiceDelegator(String string) {
        if (string != null) {
            ServiceDelegator.initConfigurator(string);
        }
    }

    private BundleInfo[] loadByPropertiesInternal(Properties properties) throws BundleException {
        String string = properties.getProperty("MAX.BUNDLE.ID");
        if (string == null) {
            ArrayList arrayList = new ArrayList(150);
            Enumeration enumeration = properties.keys();
            while (enumeration.hasMoreElements()) {
                String string2 = (String)enumeration.nextElement();
                if ("de.audi.tghu.serviceDelegateConfigurator".equals(string2)) {
                    this.initServiceDelegator(properties.getProperty("de.audi.tghu.serviceDelegateConfigurator"));
                    continue;
                }
                if (this.autostartBundleNames == null && "Bundle.Startup.Autostart".equals(string2)) {
                    this.autostartBundleNames = this.getValue(properties, "Bundle.Startup.Autostart");
                    continue;
                }
                BundleInfo bundleInfo = new BundleInfo(arrayList.size(), string2, this.getValue(properties, string2));
                arrayList.add(bundleInfo);
            }
            return (BundleInfo[])arrayList.toArray(new BundleInfo[arrayList.size()]);
        }
        this.autostartBundleIds = this.getValue(properties, "Bundle.Startup.Autostart");
        this.initServiceDelegator(properties.getProperty("de.audi.tghu.serviceDelegateConfigurator"));
        int n = Integer.parseInt(string);
        ArrayList arrayList = new ArrayList(n + 1);
        for (int i2 = 0; i2 <= n; ++i2) {
            try {
                BundleInfo bundleInfo = new BundleInfo(i2, this.getValue(properties, new StringBuffer().append(KEY_NAME).append(i2).toString()), this.getValue(properties, new StringBuffer().append(KEY_ACTIVATOR).append(i2).toString()));
                arrayList.add(bundleInfo);
                continue;
            }
            catch (BundleException bundleException) {
                System.err.println(new StringBuffer().append(bundleException.getMessage()).append(" Please update bundles.properties!").toString());
            }
        }
        Object[] objectArray = new BundleInfo[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    private String getValue(Properties properties, String string) throws BundleException {
        String string2 = properties.getProperty(string);
        if (string2 == null) {
            throw new BundleException(new StringBuffer().append("Key \"").append(string).append("\" not found in bundles.properties!").toString());
        }
        return string2;
    }

    protected Bundle[] getBundles() {
        return this.bundles;
    }

    protected Bundle getBundle(String string) {
        if (string == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.bundles.length; ++i2) {
            BundleInfo bundleInfo = this.bundles[i2];
            String string2 = bundleInfo.getBundleName();
            if (!string.equals(string2)) continue;
            return bundleInfo;
        }
        return null;
    }

    protected Bundle getBundle(int n) {
        for (int i2 = 0; i2 < this.bundles.length; ++i2) {
            BundleInfo bundleInfo = this.bundles[i2];
            if (bundleInfo.getBundleId() != (long)n) continue;
            return bundleInfo;
        }
        LSDLogService.getInstance().log(1, new StringBuffer().append("Bundle ").append(n).append(" not defined in properties file!").toString());
        return null;
    }

    protected Bundle[] getAutostartBundles() throws BundleException {
        if (this.autostartBundleIds != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(this.autostartBundleIds, ",");
            Bundle[] bundleArray = new Bundle[stringTokenizer.countTokens()];
            if (bundleArray.length == 0) {
                throw new BundleException("At least the StartupBundles has to be specified with Bundle.Startup.Autostart!");
            }
            for (int i2 = 0; i2 < bundleArray.length; ++i2) {
                bundleArray[i2] = this.getBundle(Integer.parseInt(stringTokenizer.nextToken()));
            }
            return bundleArray;
        }
        if (this.autostartBundleNames != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(this.autostartBundleNames, ",");
            ArrayList arrayList = new ArrayList(10);
            while (stringTokenizer.hasMoreElements()) {
                arrayList.add(this.getBundle((String)stringTokenizer.nextElement()));
            }
            return (Bundle[])arrayList.toArray(new Bundle[arrayList.size()]);
        }
        throw new BundleException("At least the StartupBundles has to be specified with Bundle.Startup.Autostart!");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < this.bundles.length; ++i2) {
            stringBuffer.append(this.bundles[i2].toString());
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }

    private static class SingletonHolder {
        static final BundleRegistry INSTANCE = new BundleRegistry();

        private SingletonHolder() {
        }
    }
}

