/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.dom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import org.apache.xerces.dom.ObjectFactory$ConfigurationError;
import org.apache.xerces.dom.SecuritySupport;

final class ObjectFactory {
    private static final String DEFAULT_PROPERTIES_FILENAME;
    private static final boolean DEBUG;
    private static final int DEFAULT_LINE_LENGTH;
    private static Properties fXercesProperties;
    private static long fLastModified;
    static /* synthetic */ Class class$org$apache$xerces$dom$ObjectFactory;

    ObjectFactory() {
    }

    static Object createObject(String string, String string2) {
        return ObjectFactory.createObject(string, null, string2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static Object createObject(String string, String string2, String string3) {
        Object object;
        String string4;
        SecuritySupport securitySupport = SecuritySupport.getInstance();
        ClassLoader classLoader = ObjectFactory.findClassLoader();
        try {
            string4 = securitySupport.getSystemProperty(string);
            if (string4 != null) {
                return ObjectFactory.newInstance(string4, classLoader, true);
            }
        }
        catch (SecurityException securityException) {
            // empty catch block
        }
        string4 = null;
        if (string2 == null) {
            Object object2;
            object = null;
            boolean bl = false;
            try {
                object2 = securitySupport.getSystemProperty("java.home");
                string2 = new StringBuffer().append((String)object2).append(File.separator).append("lib").append(File.separator).append("xerces.properties").toString();
                object = new File(string2);
                bl = securitySupport.getFileExists((File)object);
            }
            catch (SecurityException securityException) {
                fLastModified = -1L;
                fXercesProperties = null;
            }
            object2 = class$org$apache$xerces$dom$ObjectFactory == null ? (class$org$apache$xerces$dom$ObjectFactory = ObjectFactory.class$("org.apache.xerces.dom.ObjectFactory")) : class$org$apache$xerces$dom$ObjectFactory;
            synchronized (object2) {
                boolean bl2 = false;
                FileInputStream fileInputStream = null;
                try {
                    if (fLastModified >= 0L) {
                        if (bl && fLastModified < (fLastModified = securitySupport.getLastModified((File)object))) {
                            bl2 = true;
                        } else if (!bl) {
                            fLastModified = -1L;
                            fXercesProperties = null;
                        }
                    } else if (bl) {
                        bl2 = true;
                        fLastModified = securitySupport.getLastModified((File)object);
                    }
                    if (bl2) {
                        fXercesProperties = new Properties();
                        fileInputStream = securitySupport.getFileInputStream((File)object);
                        fXercesProperties.load(fileInputStream);
                    }
                }
                catch (Exception exception) {
                    fXercesProperties = null;
                    fLastModified = -1L;
                }
                finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        }
                        catch (IOException iOException) {}
                    }
                }
            }
            if (fXercesProperties != null) {
                string4 = fXercesProperties.getProperty(string);
            }
        } else {
            object = null;
            try {
                object = securitySupport.getFileInputStream(new File(string2));
                Properties properties = new Properties();
                properties.load((InputStream)object);
                string4 = properties.getProperty(string);
            }
            catch (Exception exception) {
            }
            finally {
                if (object != null) {
                    try {
                        ((FileInputStream)object).close();
                    }
                    catch (IOException iOException) {}
                }
            }
        }
        if (string4 != null) {
            return ObjectFactory.newInstance(string4, classLoader, true);
        }
        object = ObjectFactory.findJarServiceProvider(string);
        if (object != null) {
            return object;
        }
        if (string3 == null) {
            throw new ObjectFactory$ConfigurationError(new StringBuffer().append("Provider for ").append(string).append(" cannot be found").toString(), null);
        }
        return ObjectFactory.newInstance(string3, classLoader, true);
    }

    private static void debugPrintln(String string) {
    }

    static ClassLoader findClassLoader() {
        ClassLoader classLoader;
        SecuritySupport securitySupport = SecuritySupport.getInstance();
        ClassLoader classLoader2 = securitySupport.getContextClassLoader();
        ClassLoader classLoader3 = classLoader = securitySupport.getSystemClassLoader();
        while (true) {
            if (classLoader2 == classLoader3) {
                ClassLoader classLoader4 = (class$org$apache$xerces$dom$ObjectFactory == null ? (class$org$apache$xerces$dom$ObjectFactory = ObjectFactory.class$("org.apache.xerces.dom.ObjectFactory")) : class$org$apache$xerces$dom$ObjectFactory).getClassLoader();
                classLoader3 = classLoader;
                while (true) {
                    if (classLoader4 == classLoader3) {
                        return classLoader;
                    }
                    if (classLoader3 == null) break;
                    classLoader3 = securitySupport.getParentClassLoader(classLoader3);
                }
                return classLoader4;
            }
            if (classLoader3 == null) break;
            classLoader3 = securitySupport.getParentClassLoader(classLoader3);
        }
        return classLoader2;
    }

    static Object newInstance(String string, ClassLoader classLoader, boolean bl) {
        try {
            Class clazz = ObjectFactory.findProviderClass(string, classLoader, bl);
            Object object = clazz.newInstance();
            return object;
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new ObjectFactory$ConfigurationError(new StringBuffer().append("Provider ").append(string).append(" not found").toString(), classNotFoundException);
        }
        catch (Exception exception) {
            throw new ObjectFactory$ConfigurationError(new StringBuffer().append("Provider ").append(string).append(" could not be instantiated: ").append(exception).toString(), exception);
        }
    }

    static Class findProviderClass(String string, ClassLoader classLoader, boolean bl) {
        Class clazz;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            int n = string.lastIndexOf(".");
            String string2 = string;
            if (n != -1) {
                string2 = string.substring(0, n);
            }
            securityManager.checkPackageAccess(string2);
        }
        if (classLoader == null) {
            clazz = Class.forName(string);
        } else {
            try {
                clazz = classLoader.loadClass(string);
            }
            catch (ClassNotFoundException classNotFoundException) {
                if (bl) {
                    ClassLoader classLoader2 = (class$org$apache$xerces$dom$ObjectFactory == null ? (class$org$apache$xerces$dom$ObjectFactory = ObjectFactory.class$("org.apache.xerces.dom.ObjectFactory")) : class$org$apache$xerces$dom$ObjectFactory).getClassLoader();
                    if (classLoader2 == null) {
                        clazz = Class.forName(string);
                    }
                    if (classLoader != classLoader2) {
                        classLoader = classLoader2;
                        clazz = classLoader.loadClass(string);
                    }
                    throw classNotFoundException;
                }
                throw classNotFoundException;
            }
        }
        return clazz;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static Object findJarServiceProvider(String string) {
        Object object;
        SecuritySupport securitySupport = SecuritySupport.getInstance();
        String string2 = new StringBuffer().append("META-INF/services/").append(string).toString();
        InputStream inputStream = null;
        ClassLoader classLoader = ObjectFactory.findClassLoader();
        inputStream = securitySupport.getResourceAsStream(classLoader, string2);
        if (inputStream == null && classLoader != (object = (class$org$apache$xerces$dom$ObjectFactory == null ? (class$org$apache$xerces$dom$ObjectFactory = ObjectFactory.class$("org.apache.xerces.dom.ObjectFactory")) : class$org$apache$xerces$dom$ObjectFactory).getClassLoader())) {
            classLoader = object;
            inputStream = securitySupport.getResourceAsStream(classLoader, string2);
        }
        if (inputStream == null) {
            return null;
        }
        try {
            object = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 80);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object = new BufferedReader(new InputStreamReader(inputStream), 80);
        }
        String string3 = null;
        try {
            string3 = ((BufferedReader)object).readLine();
        }
        catch (IOException iOException) {
            Object var8_10 = null;
            return var8_10;
        }
        finally {
            try {
                ((BufferedReader)object).close();
            }
            catch (IOException iOException) {}
        }
        if (string3 != null && !"".equals(string3)) {
            return ObjectFactory.newInstance(string3, classLoader, false);
        }
        return null;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        fXercesProperties = null;
        fLastModified = -1L;
    }
}

