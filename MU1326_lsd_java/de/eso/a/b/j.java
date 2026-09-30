/*
 * Decompiled with CFR 0.152.
 */
package de.eso.a.b;

import de.eso.a.d.b;
import java.io.File;
import java.io.FilenameFilter;

public class j
implements FilenameFilter {
    private static final int a = 500;
    private int b = 0;
    private String c = "ics";
    private boolean d = false;

    public j(String string) {
        this.c = string;
    }

    public boolean accept(File file, String string) {
        if (this.b >= 500) {
            if (!this.d) {
                de.eso.a.d.b.d("more then 500*." + this.c + " files found in directory. Ignore the rest of files");
            }
            this.d = true;
            return false;
        }
        if (string.toLowerCase().endsWith(this.c)) {
            ++this.b;
            return true;
        }
        return false;
    }
}

