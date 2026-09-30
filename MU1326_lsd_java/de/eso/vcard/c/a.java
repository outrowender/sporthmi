/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard.c;

import de.eso.a.b.f;
import java.io.File;

public class a
implements f {
    public void a(String string) {
        System.out.println("propertyName: " + string);
    }

    public void b(String string) {
        System.out.println("paramKey: " + string);
    }

    public void c(String string) {
        System.out.println("paramVal: " + string);
    }

    public void a(String string, int n) {
        System.out.println("value " + n + ": " + string);
    }

    public void d() {
        System.out.println("END of VCARD file");
    }

    public void b(byte[] byArray, int n) {
        int n2 = 0;
        if (byArray != null) {
            n2 = byArray.length;
        }
        System.out.println("binary value " + n + ": " + n2 + " bytes.");
    }

    public void e() {
        System.out.println("---------------------------endline---------------------------");
    }

    public void a(File file, int n) {
        System.out.println("Binary content in file: " + file);
    }

    public void a(byte[] byArray, int n) {
        System.out.println("Byte[] content");
    }

    public void d(String string) {
        System.out.println("propertyGroup: " + string);
    }

    public boolean g() {
        return false;
    }
}

