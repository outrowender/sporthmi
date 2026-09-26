/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.error;

import de.audi.atip.error.ErrorManager;
import java.io.File;
import java.io.FilenameFilter;

class ErrorManager$1
implements FilenameFilter {
    private final /* synthetic */ ErrorManager this$0;

    ErrorManager$1(ErrorManager errorManager) {
        this.this$0 = errorManager;
    }

    @Override
    public boolean accept(File file, String string) {
        return ErrorManager.access$900(this.this$0, string);
    }
}

