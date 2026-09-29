/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.redengineering.app;

import de.audi.atip.engineering.fsc.IFSCService;
import de.audi.atip.engineering.fsc.IFSCServiceListener;
import de.audi.tghu.redengineering.app.FSCViewer;

public class FSCService
implements IFSCService {
    private FSCViewer fscViewer;
    private IFSCServiceListener fscServiceListener;

    public FSCService(FSCViewer fSCViewer) {
        this.fscViewer = fSCViewer;
    }

    @Override
    public void startFSCImport(int n) {
        this.fscViewer.startFSCImport(n);
    }

    @Override
    public void setFscServiceListener(IFSCServiceListener iFSCServiceListener) {
        this.fscServiceListener = iFSCServiceListener;
    }

    void notifyImportFSCDone(int n) {
        if (this.fscServiceListener != null) {
            this.fscServiceListener.importFSCDone(n);
        }
    }

    @Override
    public void removeListener() {
        this.fscServiceListener = null;
    }
}

