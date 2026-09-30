/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.app.customer.uota.AbstractPkgListRow;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;
import de.audi.tghu.swdl.app.customer.uota.GenericPkgRow;
import de.audi.tghu.swdl.app.customer.uota.SysProposalPkgRow;
import de.audi.tghu.swdl.app.customer.uota.UotaPkgInfoWrapper;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.dsi.ifc.uota.PackageInfo;

class PkgNode {
    private final BaseUpdateOverTheAirController uotaController;
    static final int ROOT_LEVEL = 0;
    static final int PACKAGE_LEVEL = 1;
    static final int COUNTRY_LEVEL = 2;
    static final int MAX_DEPTH = 2;
    static final char NAME_VERSION_SEPARATOR = '\n';
    static final int DISABLED = 0;
    static final int ENABLED = 1;
    static final int NOT_TOGGLED = -1;
    private UotaPkgInfoWrapper[] pkgInfo = null;
    private PkgNode parent = null;
    private Map childNodes = null;
    private final int level;
    private int index = -1;
    private int regionISOCode = -1;
    private long rowId = -1L;
    private final String name;
    private final String displayName;
    private final String version;
    private long nodeSize = 0L;
    private long requiredPackagesSize = 0L;
    private boolean isSizeCalculated = false;
    private int toggling = -1;
    private boolean isPPOI = false;
    private boolean isSystemPackage = false;
    private boolean isBusinessPackage = false;
    private int priority = 0;
    private final String packageID;
    private volatile boolean isCancelled = false;
    private volatile boolean hasSelectedChildren = false;

    PkgNode(BaseUpdateOverTheAirController baseUpdateOverTheAirController, int n, String string, String string2, String string3, String string4, PkgNode pkgNode) {
        this.uotaController = baseUpdateOverTheAirController;
        if (n > 2 || 0 >= n) {
            throw new IllegalArgumentException(new StringBuffer().append("InvalidLevel-").append(n).toString());
        }
        PkgNode pkgNode2 = this.getUotaController().getHierarchyRoot();
        if (null == string || null == pkgNode || null == pkgNode2) {
            throw new IllegalArgumentException("NameParentOrRootMissing");
        }
        this.level = n;
        this.name = string;
        this.displayName = string2;
        this.version = string3;
        this.parent = pkgNode;
        this.rowId = pkgNode2.getRowId();
        this.packageID = string4;
    }

    PkgNode(BaseUpdateOverTheAirController baseUpdateOverTheAirController, PackageInfo[] packageInfoArray, int[] nArray) {
        this.uotaController = baseUpdateOverTheAirController;
        if (null == packageInfoArray || null == nArray) {
            throw new IllegalArgumentException("MissingPackagesOrSelectionInfo");
        }
        if (packageInfoArray.length != nArray.length) {
            throw new IllegalArgumentException("PkgInfoSelectionMismatch");
        }
        this.normalizePackageHierarchyToFlatList(packageInfoArray);
        this.pkgInfo = UotaPkgInfoWrapper.toArray(packageInfoArray, nArray, baseUpdateOverTheAirController.isPackageSizeHidden(), this.getLogUota());
        if (null == this.pkgInfo) {
            this.isCancelled = true;
        }
        this.level = 0;
        this.displayName = "RootNode";
        this.version = "RootNode";
        this.name = "RootNode";
        this.parent = null;
        this.packageID = "";
    }

    private void normalizePackageHierarchyToFlatList(PackageInfo[] packageInfoArray) {
        if (null != packageInfoArray) {
            this.getLogUota().log(10000000, "[PkgNode].normalizePackageHierarchyToFlatList()");
            for (int i2 = 0; i2 < packageInfoArray.length; ++i2) {
                packageInfoArray[i2].hierarchyInfo = this.reduceHierarchyToFlatList(packageInfoArray[i2].hierarchyInfo);
            }
        }
    }

    private String[] reduceHierarchyToFlatList(String[] stringArray) {
        if (stringArray.length > 2) {
            if (this.getLogUota().isDebug()) {
                this.getLogUota().log(100000000, "[PkgNode].reduceHierarchyToFlatList(): %1", (Object)stringArray[stringArray.length - 1]);
            }
            String[] stringArray2 = new String[]{stringArray[0], stringArray[stringArray.length - 1]};
            return stringArray2;
        }
        return stringArray;
    }

    boolean isHierarchyBuilt() {
        PkgNode pkgNode = this;
        if (!this.isRoot()) {
            pkgNode = this.getUotaController().getHierarchyRoot();
        }
        return null != pkgNode && null != pkgNode.pkgInfo && 0 < pkgNode.pkgInfo.length ? pkgNode.childNodes != null && !pkgNode.childNodes.isEmpty() : true;
    }

    String getName() {
        return this.name;
    }

    String getDisplayName() {
        return this.displayName;
    }

    String getVersion() {
        return this.version;
    }

    Map getChildNodes() {
        return this.childNodes;
    }

    void setSelection(int[] nArray) {
        if (null == nArray) {
            this.getLogUota().log(10000, "[PkgNode].setSelection(): Null selection info!");
            return;
        }
        if (this.isRoot()) {
            UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray = this.pkgInfo;
            if (null == uotaPkgInfoWrapperArray) {
                this.getLogUota().log(10000, "[PkgNode].setSelection(): Null update packages!");
                return;
            }
            if (uotaPkgInfoWrapperArray.length != nArray.length) {
                this.getLogUota().log(10000, "[PkgNode].setSelection(): Array length mismatch packages=%1, selectionInfo=%2!", (long)uotaPkgInfoWrapperArray.length, (long)nArray.length);
                return;
            }
            for (int i2 = 0; i2 < uotaPkgInfoWrapperArray.length; ++i2) {
                uotaPkgInfoWrapperArray[i2].setSelectionStatus(nArray[i2]);
            }
        }
    }

    int getToggling() {
        return this.toggling;
    }

    PkgNode getParent() {
        return this.parent;
    }

    void setTogglingState() {
        if (!this.isLeaf()) {
            this.toggling = 1;
            Iterator iterator = this.childNodes.values().iterator();
            while (iterator.hasNext()) {
                PkgNode pkgNode = (PkgNode)iterator.next();
                if (pkgNode.isLeaf()) {
                    if ((pkgNode.getSelection() & 1) == 1 || !pkgNode.isSelectable()) continue;
                    this.toggling = 0;
                    continue;
                }
                pkgNode.setTogglingState();
                if (0 != pkgNode.getToggling()) continue;
                this.toggling = 0;
            }
        }
    }

    int[] getToggleList() {
        PkgNode pkgNode = this.getUotaController().getHierarchyRoot();
        if (null == pkgNode) {
            this.getLogUota().log(10000, "[PkgNode].getToggleList(): Missing root node!");
            return new int[0];
        }
        int[] nArray = new int[pkgNode.pkgInfo.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            nArray[i2] = pkgNode.pkgInfo[i2].getSelectionStatus() & 1;
        }
        if (1 == this.toggling) {
            this.setToggleStatus(0, nArray);
        } else {
            this.setToggleStatus(1, nArray);
        }
        return nArray;
    }

    void setToggleStatus(int n, int[] nArray) {
        if (this.isLeaf()) {
            return;
        }
        this.toggling = n;
        Iterator iterator = this.childNodes.values().iterator();
        while (iterator.hasNext()) {
            PkgNode pkgNode = (PkgNode)iterator.next();
            if (pkgNode.isLeaf()) {
                if (!pkgNode.isSelectable()) continue;
                nArray[pkgNode.index] = n;
                continue;
            }
            pkgNode.setToggleStatus(n, nArray);
        }
    }

    void addPkg(int n) {
        PkgNode pkgNode = this.getUotaController().getHierarchyRoot();
        if (null == pkgNode) {
            this.getLogUota().log(10000, "[PkgNode].addPkg(%1): Missing root node - ignoring package", (long)n);
            return;
        }
        UotaPkgInfoWrapper uotaPkgInfoWrapper = pkgNode.pkgInfo[n];
        String[] stringArray = uotaPkgInfoWrapper.getUniqueNames();
        String[] stringArray2 = uotaPkgInfoWrapper.getDisplayVersions();
        this.getLogUota().log(100000000, "[PkgNode].addPkg(%1): level=%2, lastname=%3, pkgID=%4", (Object)Integer.toString(n), (Object)Integer.toString(this.level), (Object)uotaPkgInfoWrapper.getLastName(), (Object)uotaPkgInfoWrapper.getPkgId());
        if (null == stringArray) {
            this.getLogUota().log(10000, "[PkgNode].addPkg(%1): Missing hierarchy info - ignoring package", (Object)pkgNode.pkgInfo[n]);
            return;
        }
        if (this.level != stringArray.length && null != stringArray[this.level]) {
            PkgNode pkgNode2 = null;
            if (null == this.childNodes) {
                this.childNodes = new LinkedHashMap();
            }
            if (this.childNodes.containsKey(stringArray[this.level]) || this.childNodes.containsKey(uotaPkgInfoWrapper.getPkgId())) {
                pkgNode2 = (PkgNode)this.childNodes.get(stringArray[this.level]);
                if (null == pkgNode2) {
                    pkgNode2 = (PkgNode)this.childNodes.get(uotaPkgInfoWrapper.getPkgId());
                }
                if (this.level == 1 && !uotaPkgInfoWrapper.getPkgId().equals(pkgNode2.packageID)) {
                    pkgNode2 = this.createPkgNode(pkgNode, n, stringArray[this.level], stringArray2[0], uotaPkgInfoWrapper);
                }
            } else {
                pkgNode2 = this.createPkgNode(pkgNode, n, stringArray[this.level], stringArray2[0], uotaPkgInfoWrapper);
            }
            pkgNode2.addPkg(n);
        } else {
            this.index = n;
        }
    }

    private PkgNode createPkgNode(PkgNode pkgNode, int n, String string, String string2, UotaPkgInfoWrapper uotaPkgInfoWrapper) {
        this.getLogUota().log(100000000, "[PkgNode].createPkgNode(): create new PkgNode name=%1", (Object)string);
        PkgNode pkgNode2 = new PkgNode(this.uotaController, this.level + 1, string, pkgNode.pkgInfo[n].getDisplayName(this.level), string2, uotaPkgInfoWrapper.getPkgId(), this);
        pkgNode2.setIsPOI(pkgNode.pkgInfo[n].isPPOI());
        pkgNode2.setIsSystemPackage(pkgNode.pkgInfo[n].isSystemPackage());
        pkgNode2.setBusinessPackage(pkgNode.pkgInfo[n].isBusinessPackage());
        pkgNode2.setPriority(pkgNode.pkgInfo[n].getPriority());
        pkgNode2.setNodeSize(uotaPkgInfoWrapper.getSize());
        if (this.getUotaController().getSwdlEnv().isSortingUotaRegionByIsoCode() && uotaPkgInfoWrapper.getRegionISOCode() > 0) {
            pkgNode2.setRegionISOCode(uotaPkgInfoWrapper.getRegionISOCode());
        }
        String string3 = 1 == this.level ? uotaPkgInfoWrapper.getPkgId() : string;
        this.childNodes.put(string3, pkgNode2);
        if (!uotaPkgInfoWrapper.isHidden() && !uotaPkgInfoWrapper.isAutoSelected()) {
            this.getUotaController().mapPackageNode(uotaPkgInfoWrapper.getPkgId(), pkgNode2);
        }
        return pkgNode2;
    }

    long getRowId() {
        if (this.isRoot()) {
            return ++this.rowId;
        }
        return this.rowId;
    }

    int getIndex() {
        return this.index;
    }

    PkgNode getNode(long l) {
        if (!this.isRoot() && l == this.getRowId()) {
            return this;
        }
        if (!this.isLeaf()) {
            Iterator iterator = this.childNodes.values().iterator();
            while (iterator.hasNext()) {
                PkgNode pkgNode = ((PkgNode)iterator.next()).getNode(l);
                if (null == pkgNode) continue;
                return pkgNode;
            }
        }
        return null;
    }

    boolean buildRows(boolean bl) {
        if (this.isLeaf()) {
            return false;
        }
        BaseListModelApp baseListModelApp = this.getUotaController().getListModelForLevel(this.level + 1);
        baseListModelApp.setStatus(0);
        baseListModelApp.removeAll();
        ArrayList arrayList = new ArrayList(60);
        Iterator iterator = this.childNodes.values().iterator();
        while (iterator.hasNext()) {
            AbstractPkgListRow abstractPkgListRow;
            PkgNode pkgNode = (PkgNode)iterator.next();
            if (bl || pkgNode.isSelected()) {
                pkgNode.setAllowedForSelection(true);
            } else {
                pkgNode.setAllowedForSelection(false);
            }
            if (null == (abstractPkgListRow = pkgNode.getRow())) continue;
            if (abstractPkgListRow.isPkgGroup()) {
                PkgNode pkgNode2 = abstractPkgListRow.getNode();
                if (2 == pkgNode2.level) {
                    Iterator iterator2 = pkgNode2.getChildNodes().values().iterator();
                    while (iterator2.hasNext()) {
                        PkgNode pkgNode3 = (PkgNode)iterator2.next();
                        pkgNode3.setAllowedForSelection(bl);
                        arrayList.add(pkgNode3.getRow());
                    }
                    continue;
                }
                arrayList.add(abstractPkgListRow);
                continue;
            }
            arrayList.add(abstractPkgListRow);
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList, new NameComparator());
        }
        iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            baseListModelApp.append((AbstractPkgListRow)iterator.next());
        }
        arrayList = null;
        baseListModelApp.setStatus(1);
        return baseListModelApp.getLength() > 0;
    }

    AbstractPkgListRow getRow() {
        if (this.isLeaf() && 8 == (this.getSelection() & 8)) {
            this.getLogUota().log(10000000, "[PkgNode].getRow(): Package %1 is hidden, no row was built", (Object)this.name);
            return null;
        }
        if (1 == this.level) {
            if (this.hasAllowedChildren(this)) {
                this.getLogUota().log(10000000, "[PkgNode].getRow(): build a generic row for the package %1 (PPOI=%2)", (Object)this.name, (Object)Boolean.toString(this.isPPOI()));
                return (AbstractPkgListRow)this.getUotaController().getGenericPackageRow(this);
            }
            this.getLogUota().log(10000000, "[PkgNode].getRow(): Package %1 has only children without license, no row was built", (Object)this.name);
            return null;
        }
        return (AbstractPkgListRow)this.getUotaController().getNaviDataPackageRow(this);
    }

    AbstractPkgListRow getSysProposalRow() {
        if (this.isLeaf() && 8 == (this.getSelection() & 8)) {
            this.getLogUota().log(10000000, "[PkgNode].getRow(): Package %1 is hidden, no row was built", (Object)this.name);
            return null;
        }
        return this.getUotaController().getSysProposalPackageRow(this);
    }

    private boolean hasAllowedChildren(PkgNode pkgNode) {
        if (pkgNode.isLeaf()) {
            return pkgNode.getPackageInfo().isLicenseAvailable();
        }
        Iterator iterator = pkgNode.childNodes.values().iterator();
        while (iterator.hasNext()) {
            if (!this.hasAllowedChildren((PkgNode)iterator.next())) continue;
            return true;
        }
        return false;
    }

    boolean hasNewPackages(PkgNode pkgNode) {
        return this.hasPackages(pkgNode, true);
    }

    private boolean hasPackages(PkgNode pkgNode, boolean bl) {
        if (pkgNode.isLeaf()) {
            return (!pkgNode.getPackageInfo().isUpToDate() || !bl) && !pkgNode.getPackageInfo().isHidden();
        }
        Iterator iterator = pkgNode.childNodes.values().iterator();
        while (iterator.hasNext()) {
            if (!this.hasPackages((PkgNode)iterator.next(), bl)) continue;
            return true;
        }
        return false;
    }

    boolean hasAnyPackages(PkgNode pkgNode) {
        return this.hasPackages(pkgNode, false);
    }

    void updateRow() {
        if (this.isRoot()) {
            return;
        }
        if (this.getUotaController().isUotaSelectionActive()) {
            if (1 == this.level && this.childNodes != null) {
                this.hasSelectedChildren = false;
                Iterator iterator = this.childNodes.values().iterator();
                while (iterator.hasNext()) {
                    if (!((PkgNode)iterator.next()).isSelected()) continue;
                    this.hasSelectedChildren = true;
                    break;
                }
            }
            this.updateModelRow(this.getUotaController().getListModelForLevel(this.level));
            if (2 == this.level) {
                this.updateModelRow(this.getUotaController().getSwdlModels().getSysProposalListModel());
            }
        } else {
            this.updateModelRow(this.getUotaController().getSwdlModels().getSysProposalListModel());
        }
    }

    private void updateModelRow(BaseListModelApp baseListModelApp) {
        AbstractPkgListRow abstractPkgListRow;
        int n = baseListModelApp.getIndexForUniqueID(this.rowId);
        if (0 <= n && null != (abstractPkgListRow = (AbstractPkgListRow)baseListModelApp.getRow(n))) {
            this.getLogUota().log(10000000, "[PkgNode].updateModelRow(): Updated row: %1, class=%2", (Object)abstractPkgListRow, (Object)abstractPkgListRow.getClass().getName());
            baseListModelApp.setRow(n, abstractPkgListRow);
        }
    }

    boolean toggleSelection(int[] nArray) {
        PkgNode pkgNode = this.getUotaController().getHierarchyRoot();
        if (null == pkgNode) {
            this.getLogUota().log(10000, "[PkgNode].toggleSelection(): Missing root node!");
            return false;
        }
        if (this.isLeaf()) {
            if (nArray[this.index] != this.getSelection()) {
                this.getLogUota().log(10000000, "[BaseUpdateOverTheAirController.PkgNode].toggleSelection(): Selection changed for leaf node, index: %1", (long)this.index);
                pkgNode.pkgInfo[this.index].setSelectionStatus(nArray[this.index]);
                this.updateRow();
                return true;
            }
            return false;
        }
        boolean bl = false;
        if (this.index >= 0 && nArray[this.index] != this.getSelection()) {
            this.getLogUota().log(10000000, "[BaseUpdateOverTheAirController.PkgNode].toggleSelection(): Selection changed for group node, index: %1", (long)this.index);
            pkgNode.pkgInfo[this.index].setSelectionStatus(nArray[this.index]);
        }
        Iterator iterator = this.childNodes.values().iterator();
        while (iterator.hasNext()) {
            if (!((PkgNode)iterator.next()).toggleSelection(nArray)) continue;
            bl = true;
        }
        if (bl) {
            this.updateRow();
            this.setTogglingState();
        }
        return bl;
    }

    void toggleRestriction(boolean bl) {
        PkgNode pkgNode = this.getUotaController().getHierarchyRoot();
        if (null == pkgNode) {
            this.getLogUota().log(10000, "[PkgNode].toggleRestriction(): Missing root node!");
        }
        if (this.isLeaf()) {
            if (!this.isSystemPackage && !this.isPPOI && bl == this.isAllowedForSelection() && !pkgNode.pkgInfo[this.index].isSelected() && pkgNode.pkgInfo[this.index].isRestrictionAllowed()) {
                this.getLogUota().log(10000000, "[BaseUpdateOverTheAirController.PkgNode].toggleRestriction(%2): Restriction changed for leaf node, index: %1", (Object)new Integer(this.index), (Object)new Boolean(bl));
                this.setAllowedForSelection(!bl);
                this.updateRow();
            }
        } else {
            Iterator iterator = this.childNodes.values().iterator();
            while (iterator.hasNext()) {
                ((PkgNode)iterator.next()).toggleRestriction(bl);
            }
        }
    }

    int getSelectedCount() {
        if (this.isLeaf()) {
            return (this.getSelection() & 1) == 0 ? 0 : 1;
        }
        int n = 0;
        Iterator iterator = this.childNodes.values().iterator();
        while (iterator.hasNext()) {
            n += ((PkgNode)iterator.next()).getSelectedCount();
        }
        return n;
    }

    boolean isSelectable() {
        return !this.isLeaf() || 0 == (this.getSelection() & 6);
    }

    boolean isTechnicalPackageAutoSelected(UotaPkgInfoWrapper uotaPkgInfoWrapper) {
        return 1 == (uotaPkgInfoWrapper.getSelectionStatus() & 1) && 1 == uotaPkgInfoWrapper.getType() && !uotaPkgInfoWrapper.isUpToDate();
    }

    boolean isSelected() {
        return this.isLeaf() && 1 == (this.getSelection() & 1);
    }

    boolean hasSelectedChildren() {
        return this.hasSelectedChildren;
    }

    int getSelection() {
        PkgNode pkgNode = this.getUotaController().getHierarchyRoot();
        if (null == pkgNode) {
            this.getLogUota().log(10000, "[PkgNode].getSelection(): Missing root node!");
            return -1;
        }
        if (this.isLeaf()) {
            return pkgNode.pkgInfo[this.index].getSelectionStatus();
        }
        return -1;
    }

    boolean displayAsSelected() {
        PkgNode pkgNode = this.getUotaController().getHierarchyRoot();
        if (null == pkgNode) {
            this.getLogUota().log(10000, "[PkgNode].displayAsSelected(): Missing root node!");
        } else if (this.isLeaf()) {
            return pkgNode.pkgInfo[this.index].displayAsSelected();
        }
        return false;
    }

    UotaPkgInfoWrapper getPackageInfo() {
        PkgNode pkgNode = this.getUotaController().getHierarchyRoot();
        if (null == pkgNode) {
            this.getLogUota().log(10000, "[PkgNode].getPackageInfo(): Missing root node!");
            return null;
        }
        if (this.index >= 0) {
            return pkgNode.pkgInfo[this.index];
        }
        return null;
    }

    String getAdditionalInfos() {
        PkgNode pkgNode = this.getUotaController().getHierarchyRoot();
        if (null == pkgNode) {
            this.getLogUota().log(10000, "[PkgNode].getAdditionalInfos(): Missing root node!");
            return "";
        }
        if (this.isLeaf()) {
            return pkgNode.pkgInfo[this.index].getAdditionalInfos();
        }
        return "";
    }

    UotaPkgInfoWrapper[] getAllPackageInfos() {
        PkgNode pkgNode = this;
        if (!pkgNode.isRoot()) {
            pkgNode = this.getUotaController().getHierarchyRoot();
        }
        if (null == pkgNode) {
            this.getLogUota().log(10000, "[PkgNode].getAllPackageInfos(): Missing root node!");
            return null;
        }
        return pkgNode.pkgInfo;
    }

    int getMaxCount() {
        if (this.isLeaf()) {
            if (this.isSelectable()) {
                return 1;
            }
            return 0;
        }
        int n = 0;
        Iterator iterator = this.childNodes.values().iterator();
        while (iterator.hasNext()) {
            n += ((PkgNode)iterator.next()).getMaxCount();
        }
        return n;
    }

    int getMaxBusinessCount() {
        if (this.isLeaf()) {
            if (!this.isBusinessPackage()) {
                return 0;
            }
            return this.isSelectable() ? 1 : 0;
        }
        int n = 0;
        Iterator iterator = this.childNodes.values().iterator();
        while (iterator.hasNext()) {
            n += ((PkgNode)iterator.next()).getMaxBusinessCount();
        }
        return n;
    }

    long getSize() {
        PkgNode pkgNode = this.getUotaController().getHierarchyRoot();
        if (null == pkgNode) {
            this.getLogUota().log(10000, "[PkgNode].getSize(): Missing root node!");
            return 0L;
        }
        if (this.isLeaf()) {
            if (this.isSelected()) {
                this.uotaController.addSelectedPackage(this.index);
            }
            return pkgNode.pkgInfo[this.index].getSize();
        }
        long l = 0L;
        this.requiredPackagesSize = 0L;
        Iterator iterator = this.childNodes.values().iterator();
        while (iterator.hasNext()) {
            PkgNode pkgNode2 = (PkgNode)iterator.next();
            if (pkgNode2.getSelectedCount() <= 0) continue;
            l += pkgNode2.getSize();
            if (this.isRoot() || this.index != -1 || pkgNode2.index < 0 || !this.isTechnicalPackageAutoSelected(pkgNode.pkgInfo[pkgNode2.index])) continue;
            this.requiredPackagesSize += pkgNode2.nodeSize;
        }
        this.isSizeCalculated = true;
        return l;
    }

    long getRequiredPackagesSize() {
        return this.requiredPackagesSize;
    }

    long calqulateRequiredPackagesSize() {
        PkgNode pkgNode = this.getUotaController().getHierarchyRoot();
        if (null == pkgNode) {
            this.getLogUota().log(10000, "[PkgNode].getRequiredPackagesSize(): Missing root node!");
            return 0L;
        }
        long l = this.getRequiredPackagesSize();
        if (!this.isLeaf()) {
            if (this.isSizeCalculated) {
                Iterator iterator = this.childNodes.values().iterator();
                while (iterator.hasNext()) {
                    PkgNode pkgNode2 = (PkgNode)iterator.next();
                    if (pkgNode2.getSelectedCount() <= 0) continue;
                    l += pkgNode2.calqulateRequiredPackagesSize();
                }
            } else {
                this.getLogUota().log(10000, "[PkgNode].getRequiredPackagesSize(): getSize() must be called before!");
            }
        }
        return l;
    }

    private void setNodeSize(long l) {
        this.nodeSize = l;
    }

    boolean isRoot() {
        return 0 == this.level;
    }

    boolean isLeaf() {
        return null == this.childNodes;
    }

    boolean isCancelled() {
        return this.isCancelled;
    }

    boolean isPPOI() {
        return this.isPPOI;
    }

    void setIsPOI(boolean bl) {
        this.isPPOI = bl;
    }

    boolean isBusinessPackage() {
        return this.isBusinessPackage;
    }

    void setBusinessPackage(boolean bl) {
        this.isBusinessPackage = bl;
    }

    boolean isSystemPackage() {
        return this.isSystemPackage;
    }

    void setIsSystemPackage(boolean bl) {
        this.isSystemPackage = bl;
    }

    int getPriority() {
        return this.priority;
    }

    void setPriority(int n) {
        this.priority = n;
        if (n > 2000) {
            this.priority = Integer.MAX_VALUE;
        }
    }

    int getRegionISOCode() {
        return this.regionISOCode;
    }

    void setRegionISOCode(int n) {
        this.regionISOCode = n;
    }

    boolean isAllowedForSelection() {
        if (this.index >= 0) {
            PkgNode pkgNode = this.getUotaController().getHierarchyRoot();
            if (null == pkgNode) {
                this.getLogUota().log(10000, "[PkgNode].isAllowedForSelection(): Missing root node!");
            }
            return pkgNode.pkgInfo[this.index].isAllowedForSelection();
        }
        return true;
    }

    void setAllowedForSelection(boolean bl) {
        if (this.index >= 0) {
            PkgNode pkgNode = this.getUotaController().getHierarchyRoot();
            if (null == pkgNode) {
                this.getLogUota().log(10000, "[PkgNode].setAllowedForSelection(%1): Missing root node!", bl);
            }
            pkgNode.pkgInfo[this.index].setAllowedForSelection(bl);
        }
    }

    boolean hidePackageSize() {
        PkgNode pkgNode = this.getUotaController().getHierarchyRoot();
        if (null == pkgNode) {
            this.getLogUota().log(10000, "[PkgNode].hidePackageSize(): Missing root node!");
        }
        return pkgNode.pkgInfo[this.index].hidePackageSize();
    }

    void dumpState() {
        if (!this.getLogUota().isDebug()) {
            return;
        }
        PkgNode pkgNode = this.getUotaController().getHierarchyRoot();
        if (null == pkgNode) {
            this.getLogUota().log(10000000, "Missing root node!");
            return;
        }
        Buffer buffer = new Buffer(512);
        switch (this.level) {
            case 2: {
                buffer.append("- - -");
                break;
            }
            case 1: {
                buffer.append("- -");
                break;
            }
            default: {
                buffer.append('-');
            }
        }
        buffer.append("[level=").append(this.level).append("][parentName=").append(this.isRoot() ? "null" : this.parent.getName()).append("][index=").append(this.index).append("][rowId=").append(this.rowId).append("][pkgId=").append(this.packageID).append("][name=").append(this.getName()).append("][displayName=").append(this.getDisplayName()).append("][version=").append(this.version).append("][maxCount=").append(this.getMaxCount()).append("][selectedCount=").append(this.getSelectedCount()).append("][toggling=").append(this.toggling).append(']');
        if (null != this.getPackageInfo()) {
            buffer.append(" pkgInfo: ").append(this.getPackageInfo());
        }
        this.getLogUota().log(10000000, "%1", (Object)buffer);
        if (!this.isLeaf()) {
            Iterator iterator = this.childNodes.values().iterator();
            while (iterator.hasNext()) {
                ((PkgNode)iterator.next()).dumpState();
            }
        }
    }

    BaseUpdateOverTheAirController getUotaController() {
        return this.uotaController;
    }

    private LogChannel getLogUota() {
        return this.getUotaController().getLogUota();
    }

    private class NameComparator
    implements Comparator {
        private NameComparator() {
        }

        public int compare(Object object, Object object2) {
            if (object instanceof SysProposalPkgRow) {
                if (object2 instanceof SysProposalPkgRow) {
                    int n = PkgNode.this.getUotaController().compareSysProposalPackages(object, object2);
                    if (n != Integer.MAX_VALUE) {
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
            if (((GenericPkgRow)object2).getNode().priority != ((GenericPkgRow)object).getNode().priority) {
                return new Integer(((GenericPkgRow)object2).getNode().priority).compareTo(new Integer(((GenericPkgRow)object).getNode().priority));
            }
            return ((GenericPkgRow)object).getNode().getVersion().compareTo(((GenericPkgRow)object2).getNode().getVersion());
        }
    }
}

