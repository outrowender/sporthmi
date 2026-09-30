/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.hmi.view.IVisualFeedback;
import de.esolutions.graphics.eal.api.IFontGroup;
import de.esolutions.graphics.eal.api.IImage;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode2DImage;
import de.esolutions.graphics.eal.api.INode2DText;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.eal.colorRGBAf;
import de.esolutions.hmi.widgets.audi.base.FontLoader;
import de.esolutions.hmi.widgets.audi.base.HMIImage;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import java.nio.ByteBuffer;

public class EALVisualFeedback
implements IVisualFeedback {
    private static final int VISUAL_FEEDBACK_FONT_SIZE = 25;
    private final EALManager ealManager;
    private final HMITerminalImpl terminal;
    private INode2D visualFeedbackNode;
    private INode2DText feedbackTextNode;
    private INode2DImage feedbackBkgNode;
    private ITexture texture = null;
    private IFontGroup feedbackFont;
    private boolean initialized = false;
    private int screenWidth;
    private int screenHeight;

    public EALVisualFeedback(EALManager eALManager, HMITerminalImpl hMITerminalImpl) {
        this.ealManager = eALManager;
        this.terminal = hMITerminalImpl;
        this.screenWidth = hMITerminalImpl.getLayout().getDistance(1);
        this.screenHeight = hMITerminalImpl.getLayout().getDistance(2);
    }

    public void showTextFeedback(String string) {
        if (this.init()) {
            this.showFeedbackText(string);
        }
    }

    public void showFullScreenFeedback() {
        if (this.init()) {
            this.showFullScreenOverlay();
        }
    }

    public void hideFeedback() {
        if (this.initialized) {
            this.feedbackBkgNode.setVisible(false);
            this.feedbackTextNode.setVisible(false);
            this.visualFeedbackNode.setVisible(false);
        }
    }

    private boolean init() {
        if (this.initialized) {
            return true;
        }
        INode2D iNode2D = this.ealManager.getVisualFeedbackNode();
        if (null != iNode2D && iNode2D.isValid() && this.createFeedbackNodes(iNode2D, -2139062144, -16711936)) {
            this.visualFeedbackNode = iNode2D;
            this.initialized = true;
            return true;
        }
        return false;
    }

    private boolean createFeedbackNodes(INode2D iNode2D, int n, int n2) {
        INode2DImage iNode2DImage = this.createNode2DImage("feedbackTxtPixel");
        if (null == iNode2DImage) {
            return false;
        }
        colorRGBAf colorRGBAf2 = new colorRGBAf(1.0f, 1.0f, 1.0f, 1.0f);
        colorRGBAf2.setFAlpha((float)(n >> 24 & 0xFF) / 255.0f);
        colorRGBAf2.setFRed((float)(n >> 16 & 0xFF) / 255.0f);
        colorRGBAf2.setFGreen((float)(n >> 8 & 0xFF) / 255.0f);
        colorRGBAf2.setFBlue((float)(n & 0xFF) / 255.0f);
        iNode2DImage.setModulateColor(colorRGBAf2);
        iNode2D.add(iNode2DImage);
        INode2DText iNode2DText = new INode2DText(this.ealManager.getProject(), "feedbackText");
        if (null == iNode2DText || !iNode2DText.isValid()) {
            this.ealManager.destroy(iNode2DImage);
            return false;
        }
        iNode2DText.setColor(EALManager.createColorCode(n2));
        iNode2DText.setTranslation(20.0f, this.screenHeight >> 1);
        IWrappedFont iWrappedFont = (IWrappedFont)this.terminal.getFontLoader().getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 25);
        this.feedbackFont = iWrappedFont.getFontGroup();
        iNode2D.add(iNode2DText);
        iNode2DImage.setVisible(false);
        iNode2DText.setVisible(false);
        this.feedbackBkgNode = iNode2DImage;
        this.feedbackTextNode = iNode2DText;
        return true;
    }

    private INode2DImage createNode2DImage(String string) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4);
        byteBuffer.put((byte)-1);
        byteBuffer.put((byte)-1);
        byteBuffer.put((byte)-1);
        byteBuffer.put((byte)-1);
        byteBuffer.rewind();
        HMIImage hMIImage = new HMIImage("ealVisualFeedback", 6);
        IImage iImage = this.ealManager.createEALImage(byteBuffer, hMIImage.getFormat(), 1, 1);
        if (null == iImage || !iImage.isValid()) {
            return null;
        }
        this.texture = this.ealManager.createEALTexture(iImage, hMIImage, false);
        if (null == this.texture || !this.texture.isValid()) {
            this.ealManager.destroy(iImage);
            return null;
        }
        INode2DImage iNode2DImage = this.ealManager.createImage2DTex(this.texture, string);
        if (null == iNode2DImage || !iNode2DImage.isValid()) {
            this.ealManager.destroy(iImage);
            this.ealManager.destroy(this.texture);
            return null;
        }
        iNode2DImage.setScale(this.screenWidth, this.screenHeight);
        iNode2DImage.setVisible(false);
        this.ealManager.destroy(iImage);
        return iNode2DImage;
    }

    private void showFullScreenOverlay() {
        this.feedbackBkgNode.setTranslation(0.0f, 0.0f);
        this.feedbackBkgNode.setScale(this.screenWidth, this.screenHeight);
        this.feedbackBkgNode.setVisible(true);
        this.feedbackTextNode.setVisible(false);
        this.visualFeedbackNode.setVisible(true);
    }

    private void showFeedbackText(String string) {
        this.feedbackFont.activate();
        this.feedbackTextNode.setText(25, string);
        long l = this.feedbackTextNode.getWidth();
        long l2 = this.feedbackTextNode.getHeight();
        this.feedbackBkgNode.setTranslation(10.0f, (long)this.screenHeight - l2 - 40L >> 1);
        this.feedbackBkgNode.setScale(l + 20L, l2 + 20L);
        this.feedbackBkgNode.setVisible(true);
        this.feedbackTextNode.setVisible(true);
        this.visualFeedbackNode.setVisible(true);
    }

    public void deinit() {
        if (this.initialized) {
            this.hideFeedback();
            this.ealManager.destroy(this.feedbackBkgNode);
            this.ealManager.destroy(this.feedbackTextNode);
            this.ealManager.destroy(this.visualFeedbackNode);
            this.ealManager.destroy(this.feedbackFont);
            this.ealManager.destroy(this.texture);
            this.feedbackBkgNode = null;
            this.feedbackTextNode = null;
            this.visualFeedbackNode = null;
            this.feedbackFont = null;
            this.texture = null;
            this.initialized = false;
        }
    }
}

