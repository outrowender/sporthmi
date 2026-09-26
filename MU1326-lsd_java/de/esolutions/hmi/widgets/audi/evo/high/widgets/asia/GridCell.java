/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets.asia;

import de.audi.atip.util.StringUtilities;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.asia.ConversionWidgetRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.asia.IImageNodeCreator;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController$ICandidateItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController$MultiCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionLineController$ConversionLineButtonType;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionLineController$IButtonItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class GridCell {
    protected final IWrappedNode3D cellNode;
    protected final IWrappedNode3DText candidateTextNode;
    protected final IWrappedNode3DImage separatorNodeVertical;
    protected final IWrappedNode3DImage separatorNodeHorizontal;
    protected IWrappedNode3DImage currentButtonImageNode;
    private Map buttonImageCache;
    private final IImageNodeCreator imageCreator;
    private AbstractConversionWidgetController$ICandidateItem currentCandidateItem;

    protected GridCell(IWrappedNode3D iWrappedNode3D, IWrappedNode3DText iWrappedNode3DText, IImageNodeCreator iImageNodeCreator, IWrappedNode3DImage iWrappedNode3DImage, IWrappedNode3DImage iWrappedNode3DImage2) {
        this.cellNode = iWrappedNode3D;
        this.candidateTextNode = iWrappedNode3DText;
        this.currentButtonImageNode = (IWrappedNode3DImage)ConversionWidgetRenderer.NULL_NODE;
        this.buttonImageCache = new HashMap();
        this.separatorNodeVertical = iWrappedNode3DImage != null ? iWrappedNode3DImage : (IWrappedNode3DImage)ConversionWidgetRenderer.NULL_NODE;
        this.separatorNodeHorizontal = iWrappedNode3DImage2 != null ? iWrappedNode3DImage2 : (IWrappedNode3DImage)ConversionWidgetRenderer.NULL_NODE;
        this.imageCreator = iImageNodeCreator;
        this.setCandidateItem(null);
    }

    public int getCurrentCandidateId() {
        if (this.currentCandidateItem == null) {
            return -1;
        }
        return this.currentCandidateItem.getId();
    }

    public AbstractConversionWidgetController$ICandidateItem getCurrentCandidate() {
        return this.currentCandidateItem;
    }

    public void setCandidateItem(AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem) {
        this.currentCandidateItem = abstractConversionWidgetController$ICandidateItem;
        this.currentButtonImageNode.setVisible(false);
        if (abstractConversionWidgetController$ICandidateItem == null) {
            this.candidateTextNode.setText("", this.candidateTextNode.getFont());
        } else if (abstractConversionWidgetController$ICandidateItem instanceof ConversionLineController$IButtonItem) {
            this.candidateTextNode.setText("", this.candidateTextNode.getFont());
            this.currentButtonImageNode = this.createOrGetButtonImage((ConversionLineController$IButtonItem)abstractConversionWidgetController$ICandidateItem);
            this.centerImage(this.currentButtonImageNode);
            this.currentButtonImageNode.setVisible(true);
        } else {
            AbstractConversionWidgetController$MultiCharItem abstractConversionWidgetController$MultiCharItem = (AbstractConversionWidgetController$MultiCharItem)abstractConversionWidgetController$ICandidateItem;
            if (GridCell.isTextAbbreviated(abstractConversionWidgetController$MultiCharItem)) {
                this.candidateTextNode.setText(abstractConversionWidgetController$MultiCharItem.getAbbreviatedCharacters(), this.candidateTextNode.getFont());
            } else {
                this.candidateTextNode.setText(abstractConversionWidgetController$MultiCharItem.getChars(), this.candidateTextNode.getFont());
            }
            this.centerText();
        }
    }

    private IWrappedNode3DImage createOrGetButtonImage(ConversionLineController$IButtonItem conversionLineController$IButtonItem) {
        ConversionLineController$ConversionLineButtonType conversionLineController$ConversionLineButtonType = conversionLineController$IButtonItem.getButtonType();
        if (!this.buttonImageCache.containsKey(conversionLineController$ConversionLineButtonType)) {
            IWrappedNode3DImage iWrappedNode3DImage = this.imageCreator.createButtonImageNodeById(this.cellNode, conversionLineController$IButtonItem);
            this.buttonImageCache.put(conversionLineController$ConversionLineButtonType, iWrappedNode3DImage);
        }
        return (IWrappedNode3DImage)this.buttonImageCache.get(conversionLineController$ConversionLineButtonType);
    }

    private static boolean isTextAbbreviated(AbstractConversionWidgetController$MultiCharItem abstractConversionWidgetController$MultiCharItem) {
        return !StringUtilities.isNullOrEmpty(abstractConversionWidgetController$MultiCharItem.getAbbreviatedCharacters());
    }

    protected void setSize(float f2, float f3) {
        this.cellNode.setSize(f2, f3);
        this.centerText();
        this.centerImage(this.currentButtonImageNode);
    }

    public void setPosition(float f2, float f3) {
        this.cellNode.setPosition(f2, f3, 0.0f);
    }

    private void centerText() {
        int n = (int)((this.cellNode.getHeight() + (float)EALManager.getFontHeightUppercase(this.candidateTextNode.getFont())) / 2.0f);
        int n2 = 0;
        if (this.currentCandidateItem instanceof AbstractConversionWidgetController$MultiCharItem) {
            n2 = (int)((this.cellNode.getWidth() - ((AbstractConversionWidgetController$MultiCharItem)this.currentCandidateItem).getWidth()) / 2.0f);
        }
        this.candidateTextNode.setPosition(n2, n, 0.0f);
    }

    private void centerImage(IWrappedNode3DImage iWrappedNode3DImage) {
        int n = (int)((this.cellNode.getWidth() - iWrappedNode3DImage.getWidth()) / 2.0f);
        int n2 = (int)((this.cellNode.getHeight() - iWrappedNode3DImage.getHeight()) / 2.0f);
        iWrappedNode3DImage.setPosition(n, n2, 0.0f);
    }

    protected void destroy(EALManager eALManager) {
        eALManager.destroy(this.separatorNodeVertical);
        eALManager.destroy(this.separatorNodeHorizontal);
        eALManager.destroy(this.currentButtonImageNode);
        eALManager.destroy(this.candidateTextNode);
        eALManager.destroy(this.cellNode);
        Iterator iterator = this.buttonImageCache.keySet().iterator();
        while (iterator.hasNext()) {
            Object object = this.buttonImageCache.remove(iterator.next());
            eALManager.destroy((IWrappedNode3DImage)object);
        }
    }

    public void setVisible(boolean bl) {
        this.cellNode.setVisible(bl);
    }

    public void setCandidateColor(int n) {
        this.candidateTextNode.setColor(n);
        this.currentButtonImageNode.setModulateColor(n);
    }

    public String toString() {
        return new StringBuffer().append("GridCell [cellNode=").append(this.cellNode).append(", candidateTextNode=").append(this.candidateTextNode).append(", separatorNodeVertical=").append(this.separatorNodeVertical).append(", separatorNodeHorizontal=").append(this.separatorNodeHorizontal).append(", currentCandidateItem=").append(this.currentCandidateItem).append(", hasImage=").append(this.currentButtonImageNode != null).append("]").toString();
    }
}

