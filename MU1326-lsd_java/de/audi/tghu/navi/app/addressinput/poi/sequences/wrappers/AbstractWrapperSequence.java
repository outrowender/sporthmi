/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.IPoiCategoriesOrResultsModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.IPoiInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.routeguidance.ILocationHandler;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public abstract class AbstractWrapperSequence
implements IPoiInputSequence {
    protected IPoiInputSequence currentInputSequence;
    protected final IDetailsScreen detailsScreen;

    public AbstractWrapperSequence(IDetailsScreen iDetailsScreen) {
        this.detailsScreen = iDetailsScreen;
    }

    @Override
    public boolean hasActiveSubSequence() {
        if (this.currentInputSequence != null) {
            return this.currentInputSequence.hasActiveSubSequence();
        }
        return false;
    }

    @Override
    public void startCategoriesOrResultsSequence(IPoiCategoriesOrResultsModelAccess iPoiCategoriesOrResultsModelAccess, int n) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.startCategoriesOrResultsSequence(iPoiCategoriesOrResultsModelAccess, n);
        }
    }

    @Override
    public void startCategories(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.startCategories(iPoiSpellerModelAccess);
        }
    }

    @Override
    public void startResultsSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, int n) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.startResultsSequence(iPoiSpellerModelAccess, n);
        }
    }

    @Override
    public void startSubstringSearch(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.startSubstringSearch(iPoiSpellerModelAccess);
        }
    }

    @Override
    public void startBrands(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.startBrands(iPoiSpellerModelAccess);
        }
    }

    @Override
    public void startGuidance(IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.startGuidance(iStartGuidanceToDestinationSequence);
        }
    }

    @Override
    public void startGuidance(ILocationHandler iLocationHandler, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.startGuidance(iLocationHandler, iStartGuidanceToDestinationSequence);
        }
    }

    @Override
    public void startGuidanceToSingleDestination(IRouteManager iRouteManager) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.startGuidanceToSingleDestination(iRouteManager);
        }
    }

    @Override
    public void retrieveNavLocation(GuiModelAccessDetailsNavi guiModelAccessDetailsNavi) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.retrieveNavLocation(guiModelAccessDetailsNavi);
        }
    }

    @Override
    public void updatePoiSubstringSearchStatus(ValueListStatus valueListStatus) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.updatePoiSubstringSearchStatus(valueListStatus);
        }
    }

    @Override
    public void requestNextResultListWindow(int n, int n2, int n3) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.requestNextResultListWindow(n, n2, n3);
        }
    }

    @Override
    public void requestNextResultListWindow(int n) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.requestNextResultListWindow(n);
        }
    }

    @Override
    public void requestPreviousResultListWindow(int n) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.requestPreviousResultListWindow(n);
        }
    }

    @Override
    public void unrequestItems(int n, int n2) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.unrequestItems(n, n2);
        }
    }

    @Override
    public void setInput(String string) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.setInput(string);
        }
    }

    @Override
    public void selectListElement(LIValueListElement lIValueListElement) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.selectListElement(lIValueListElement);
        }
    }

    @Override
    public void startParentChild(IPoiSpellerModelAccess iPoiSpellerModelAccess, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.startParentChild(iPoiSpellerModelAccess, iStartGuidanceToDestinationSequence);
        }
    }

    @Override
    public void showLocationInPreviewMap(IPreviewMap iPreviewMap, LIValueListElement lIValueListElement) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.showLocationInPreviewMap(iPreviewMap, lIValueListElement);
        }
    }

    @Override
    public void startDetailsForSelectedElement(IPreviewMap iPreviewMap, GuiModelAccessDetailsNavi guiModelAccessDetailsNavi) {
        if (this.currentInputSequence != null) {
            this.currentInputSequence.startDetailsForSelectedElement(iPreviewMap, guiModelAccessDetailsNavi);
        }
    }

    @Override
    public void restore() {
        if (this.currentInputSequence != null) {
            if (!this.currentInputSequence.hasActiveSubSequence()) {
                this.currentInputSequence.restore();
                if (this.restoreCurrent() != null) {
                    CommandList commandList = this.restoreCurrent();
                    commandList.execute("AbstractWrapperSequence#restore");
                }
            } else {
                this.currentInputSequence.restore();
            }
        }
    }

    @Override
    public CommandList createRestoreCommandList() {
        return null;
    }

    protected abstract CommandList restoreCurrent() {
    }
}

