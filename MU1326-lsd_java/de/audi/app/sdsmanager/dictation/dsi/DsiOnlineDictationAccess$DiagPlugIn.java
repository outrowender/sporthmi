/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.sds.dictation.DiagDsiOnlineDictation
 *  de.mib.swdiagnosis.sds.dictation.IDiagPlugIn
 */
package de.audi.app.sdsmanager.dictation.dsi;

import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationAccess;
import de.mib.swdiagnosis.sds.dictation.DiagDsiOnlineDictation;
import de.mib.swdiagnosis.sds.dictation.IDiagPlugIn;
import org.dsi.ifc.online.DSIOnlineDictation;

final class DsiOnlineDictationAccess$DiagPlugIn
implements IDiagPlugIn {
    private final /* synthetic */ DsiOnlineDictationAccess this$0;

    DsiOnlineDictationAccess$DiagPlugIn(DsiOnlineDictationAccess dsiOnlineDictationAccess) {
        this.this$0 = dsiOnlineDictationAccess;
    }

    public void cmdUseDiagDsiOnlineDictation(boolean bl) {
        DsiOnlineDictationAccess.access$400(this.this$0, (DSIOnlineDictation)new DiagDsiOnlineDictation(DsiOnlineDictationAccess.access$500(this.this$0), bl));
    }
}

