/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.dom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import org.apache.xerces.dom.SecuritySupport$1;
import org.apache.xerces.dom.SecuritySupport$2;
import org.apache.xerces.dom.SecuritySupport$3;
import org.apache.xerces.dom.SecuritySupport$4;
import org.apache.xerces.dom.SecuritySupport$5;
import org.apache.xerces.dom.SecuritySupport$6;
import org.apache.xerces.dom.SecuritySupport$7;
import org.apache.xerces.dom.SecuritySupport$8;

final class SecuritySupport {
    private static final SecuritySupport securitySupport = new SecuritySupport();

    static SecuritySupport getInstance() {
        return securitySupport;
    }

    ClassLoader getContextClassLoader() {
        return (ClassLoader)AccessController.doPrivileged(new SecuritySupport$1(this));
    }

    ClassLoader getSystemClassLoader() {
        return (ClassLoader)AccessController.doPrivileged(new SecuritySupport$2(this));
    }

    ClassLoader getParentClassLoader(ClassLoader classLoader) {
        return (ClassLoader)AccessController.doPrivileged(new SecuritySupport$3(this, classLoader));
    }

    String getSystemProperty(String string) {
        return (String)AccessController.doPrivileged(new SecuritySupport$4(this, string));
    }

    FileInputStream getFileInputStream(File file) {
        try {
            return (FileInputStream)AccessController.doPrivileged(new SecuritySupport$5(this, file));
        }
        catch (PrivilegedActionException privilegedActionException) {
            throw (FileNotFoundException)privilegedActionException.getException();
        }
    }

    InputStream getResourceAsStream(ClassLoader classLoader, String string) {
        return (InputStream)AccessController.doPrivileged(new SecuritySupport$6(this, classLoader, string));
    }

    boolean getFileExists(File file) {
        return (Boolean)AccessController.doPrivileged(new SecuritySupport$7(this, file));
    }

    long getLastModified(File file) {
        return (Long)AccessController.doPrivileged(new SecuritySupport$8(this, file));
    }

    private SecuritySupport() {
    }
}

