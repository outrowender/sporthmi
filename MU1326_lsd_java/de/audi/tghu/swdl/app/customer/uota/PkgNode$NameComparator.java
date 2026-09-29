/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.tghu.swdl.app.customer.uota.GenericPkgRow;
import de.audi.tghu.swdl.app.customer.uota.PkgNode;
import de.audi.tghu.swdl.app.customer.uota.PkgNode$1;
import de.audi.tghu.swdl.app.customer.uota.SysProposalPkgRow;
import java.util.Comparator;

class PkgNode$NameComparator
implements Comparator {
    private final /* synthetic */ PkgNode this$0;

    private PkgNode$NameComparator(PkgNode pkgNode) {
        this.this$0 = pkgNode;
    }

    @Override
    public int compare(Object object, Object object2) {
        if (object instanceof SysProposalPkgRow) {
            if (object2 instanceof SysProposalPkgRow) {
                int n = this.this$0.getUotaController().compareSysProposalPackages(object, object2);
                if (n != -129) {
                    return n;
                }
                if (((SysProposalPkgRow)object).getNode().getRegionISOCode() > 0 && ((SysProposalPkgRow)object2).getNode().getRegionISOCode() > 0) {
                    return ((SysProposalPkgRow)object).getNode().getRegionISOCode() - ((SysProposalPkgRow)object2).getNode().getRegionISOCode();
                }
                return ((SysProposalPkgRow)object).getNode().getDisplayName().compareTo(((SysProposalPkgRow)object2).getNode().getDisplayName());
            }
            return -1;
        }
        if (object2 instanceof SysProposalPkgRow) {
            return 1;
        }
        if (((GenericPkgRow)object).getNode().isPPOI() && !((GenericPkgRow)object2).getNode().isPPOI()) {
            return -1;
        }
        if (((GenericPkgRow)object2).getNode().isPPOI() && !((GenericPkgRow)object).getNode().isPPOI()) {
            return 1;
        }
        if (PkgNode.access$100(((GenericPkgRow)object2).getNode()) != PkgNode.access$100(((GenericPkgRow)object).getNode())) {
            return new Integer(PkgNode.access$100(((GenericPkgRow)object2).getNode())).compareTo(new Integer(PkgNode.access$100(((GenericPkgRow)object).getNode())));
        }
        return ((GenericPkgRow)object).getNode().getVersion().compareTo(((GenericPkgRow)object2).getNode().getVersion());
    }

    /* synthetic */ PkgNode$NameComparator(PkgNode pkgNode, PkgNode$1 pkgNode$1) {
        this(pkgNode);
    }
}

