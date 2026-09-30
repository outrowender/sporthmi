/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard.b;

import de.eso.a.b.a;
import de.eso.a.b.e;
import de.eso.a.b.f;
import de.eso.a.d.b;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class g
extends a {
    private BufferedOutputStream C = null;
    private File D = null;
    private static File E = new File("/organizerdisk/vcard");
    private static boolean F = false;

    public g(File file, f f2) {
        this.o = file;
        this.p = new FileInputStream(this.o);
        this.r = new e(f2);
    }

    public g(InputStream inputStream, f f2) {
        this.o = null;
        this.p = inputStream;
        this.r = new e(f2);
    }

    public static void a(File file) {
        E = file;
    }

    public static void a(boolean bl) {
        F = bl;
    }

    public static boolean e() {
        return F;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void a(int n) {
        if (this.C != null) {
            try {
                this.C.flush();
                this.C.close();
                if (this.w) {
                    de.eso.a.d.b.c("Deleting binary file " + this.D);
                    if (!this.D.delete()) {
                        de.eso.a.d.b.d("Error deleting the binary file " + this.D);
                    }
                    this.D = null;
                } else if (this.D != null) {
                    de.eso.a.d.b.c("Closed file " + this.D);
                    this.r.a(this.D, n);
                } else {
                    de.eso.a.d.b.d("Binary file was null!");
                }
            }
            catch (IOException iOException) {
                de.eso.a.d.b.d("Error reading binary file " + this.D);
            }
            finally {
                this.C = null;
                this.D = null;
            }
        }
    }

    private void b(byte by) {
        if (this.C == null && !this.w) {
            try {
                boolean bl;
                if (!E.exists() && !(bl = E.mkdirs())) {
                    de.eso.a.d.b.d("Could not access binary temp dir " + E.getAbsolutePath());
                    this.w = true;
                    return;
                }
                String string = ".bin";
                if ("PHOTO".equalsIgnoreCase(this.x)) {
                    string = ".jpg";
                }
                this.w = false;
                this.v = 0L;
                String string2 = this.o == null ? "rfc_file" : this.o.getName();
                this.D = File.createTempFile("vcard_" + string2 + "_" + this.x, string, E);
                this.C = new BufferedOutputStream(new FileOutputStream(this.D));
                de.eso.a.d.b.c("Writing binary content to :" + this.D.getAbsolutePath());
            }
            catch (Exception exception) {
                de.eso.a.d.b.d("Error opening temp file for binary rfc content: " + exception.getMessage());
                this.w = true;
            }
        }
        if (this.C != null) {
            if (this.w) {
                return;
            }
            if (this.v > de.eso.a.b.a.d()) {
                de.eso.a.d.b.d("Writing to binary file exceeded quota of " + de.eso.a.b.a.d() + " bytes. Deleting partly written file.");
                this.w = true;
            }
            try {
                this.C.write(by);
                ++this.v;
            }
            catch (IOException iOException) {
                de.eso.a.d.b.d("Error writing binary content to temp file");
            }
        }
    }

    public final void a(byte by) {
        this.z = true;
        if ("PHOTO".equalsIgnoreCase(this.x)) {
            this.b(by);
        } else {
            this.q.a(by);
        }
    }

    public void b(String string) {
        this.B = this.r.g();
        if (this.B) {
            return;
        }
        if ("BEGIN".equalsIgnoreCase(string)) {
            this.A = true;
            ++this.y;
        } else if ("END".equalsIgnoreCase(string)) {
            if (this.y == 0) {
                this.c();
                this.B = this.r.g();
                if (this.B) {
                    return;
                }
            }
            --this.y;
        }
    }
}

