/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.BundleInfo;
import de.dreisoft.lsd.BundleRegistry;
import de.dreisoft.lsd.LSDLogService;
import de.dreisoft.lsd.ServiceRegistry;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.ResourceBundle;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

public class LSD {
    public static final boolean DEBUG = false;
    public static final boolean DEBUG_AUDIT = false;
    private static final String PROP_BUNDLES = "lsd.bundles";
    private static final String RESOURCE_FILE = "resources/bundles";

    private static ClassLoader getResourceClassLoader(Object object) {
        return object.getClass().getClassLoader() != null ? object.getClass().getClassLoader() : ClassLoader.getSystemClassLoader();
    }

    private static Throwable getRootCause(Throwable throwable) {
        if (throwable instanceof BundleException) {
            Throwable throwable2 = ((BundleException)throwable).getNestedException();
            if (throwable2 == null) {
                return throwable;
            }
            return LSD.getRootCause(throwable2);
        }
        if (throwable instanceof InvocationTargetException) {
            Throwable throwable3 = ((InvocationTargetException)throwable).getTargetException();
            if (throwable3 == null) {
                return throwable;
            }
            return LSD.getRootCause(throwable3);
        }
        return throwable;
    }

    public static void initBundleRegistry(BundleRegistry bundleRegistry) throws BundleException {
        Object object;
        String string = System.getProperty(PROP_BUNDLES);
        if (string != null) {
            object = new File(string);
            try {
                System.out.println("[LSD] Using " + string);
                bundleRegistry.load((File)object);
                return;
            }
            catch (Exception exception) {
                System.out.println("[LSD] Reading " + string + " failed!");
                exception.printStackTrace();
            }
        }
        object = ResourceBundle.getBundle(RESOURCE_FILE, Locale.GERMANY, LSD.getResourceClassLoader(bundleRegistry));
        bundleRegistry.load((ResourceBundle)object);
    }

    public static void main(String[] stringArray) {
        try {
            ServiceRegistry.getInstance();
            BundleRegistry bundleRegistry = BundleRegistry.getInstance();
            LSD.initBundleRegistry(bundleRegistry);
            Bundle[] bundleArray = bundleRegistry.getAutostartBundles();
            for (int i2 = 0; i2 < bundleArray.length; ++i2) {
                Bundle bundle = bundleArray[i2];
                try {
                    if (bundle != null) {
                        bundle.start();
                        continue;
                    }
                    LSDLogService.getInstance().log(1, "An Autostart-Bundle can't be found!");
                    continue;
                }
                catch (BundleException bundleException) {
                    StringBuffer stringBuffer = new StringBuffer(64);
                    stringBuffer.append("unable to start bundle ");
                    stringBuffer.append(" '").append(((BundleInfo)bundle).getBundleName()).append("' ");
                    LSDLogService.getInstance().log(1, stringBuffer.toString(), bundleException.getNestedException());
                }
            }
        }
        catch (Exception exception) {
            System.err.println(exception.getMessage());
            LSD.getRootCause(exception).printStackTrace();
        }
    }
}

