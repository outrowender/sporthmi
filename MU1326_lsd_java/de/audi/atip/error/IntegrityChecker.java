/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.error;

import de.audi.atip.base.IFrameworkAccess;
import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class IntegrityChecker {
    private final IFrameworkAccess fw;

    public IntegrityChecker(IFrameworkAccess iFrameworkAccess) {
        this.fw = iFrameworkAccess;
    }

    public String[] getTargetIntegrityInfo() {
        ArrayList arrayList = new ArrayList();
        try {
            if ("".equals(this.fw.getVersionInfo().getDiagChecksum())) {
                System.out.println("HMI-IntegrityChecker: ZIP started, do not check the integrity");
            } else {
                String string;
                String string2;
                String string3;
                String string4 = this.fw.getVersionInfo().getDiagChecksum();
                if (!string4.equals(string3 = this.getFileContent("checksum_diag_jar.md5"))) {
                    this.print("diag.jar MD5 differs from builtin MD5, update your diag.jar !!!");
                    arrayList.add("diag.jar wrong version!");
                }
                if (!(string2 = this.fw.getVersionInfo().getLangDataChecksum()).equals(string = this.getFileContent("checksum_lang_data.md5"))) {
                    this.print("lang_data.zip MD5 differs from builtin MD5, update your lang_data.zip!");
                    arrayList.add("lang_data.zip wrong version!");
                }
            }
        }
        catch (Exception exception) {
            System.out.println(new StringBuffer().append("HMI-IntegrityChecker[ERROR]: ").append(exception.getMessage()).toString());
        }
        return (String[])arrayList.toArray(new String[arrayList.size()]);
    }

    private void print(String string) {
        System.out.println("[ERROR] ######## HMI integrity check fails ###########");
        System.out.println(new StringBuffer().append("HMI-IntegrityChecker[ERROR]: ").append(string).toString());
    }

    private ClassLoader getResourceClassLoader() {
        return super.getClass().getClassLoader() != null ? super.getClass().getClassLoader() : ClassLoader.getSystemClassLoader();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private String getFileContent(String string) {
        String string2 = "";
        InputStream inputStream = null;
        FilterInputStream filterInputStream = null;
        try {
            inputStream = this.getResourceClassLoader().getResourceAsStream(string);
            filterInputStream = new DataInputStream(inputStream);
            if (filterInputStream.available() == 32) {
                byte[] byArray = new byte[32];
                ((DataInputStream)filterInputStream).readFully(byArray);
                string2 = new String(byArray);
            }
        }
        catch (Exception exception) {
            System.out.println(new StringBuffer().append("HMI-IntegrityChecker[ERROR]: ").append(string).append(" is not in the class path or does not contain md5 file!").toString());
        }
        finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (filterInputStream != null) {
                    filterInputStream.close();
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return string2;
    }
}

