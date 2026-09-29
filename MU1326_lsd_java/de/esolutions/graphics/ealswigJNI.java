/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics;

import de.esolutions.graphics.eal.CAbstractEventListener;
import de.esolutions.graphics.eal.CCacheLRU;
import de.esolutions.graphics.eal.CMatrix4x4f;
import de.esolutions.graphics.eal.CMergeInfo;
import de.esolutions.graphics.eal.CQuaternion;
import de.esolutions.graphics.eal.FlagEvent;
import de.esolutions.graphics.eal.FlagFontStyle;
import de.esolutions.graphics.eal.FlagImage;
import de.esolutions.graphics.eal.FlagMerge;
import de.esolutions.graphics.eal.FlagPrint;
import de.esolutions.graphics.eal.FlagTexture;
import de.esolutions.graphics.eal.ICacheCallback;
import de.esolutions.graphics.eal.IEvent;
import de.esolutions.graphics.eal.IEventFontGroup;
import de.esolutions.graphics.eal.IEventImage;
import de.esolutions.graphics.eal.IEventImageSave;
import de.esolutions.graphics.eal.IEventListener;
import de.esolutions.graphics.eal.IEventMerge;
import de.esolutions.graphics.eal.IInputListener;
import de.esolutions.graphics.eal.Mat3f;
import de.esolutions.graphics.eal.Mat4f;
import de.esolutions.graphics.eal.Vec2f;
import de.esolutions.graphics.eal.Vec3f;
import de.esolutions.graphics.eal.Vec4f;
import de.esolutions.graphics.eal.Version;
import de.esolutions.graphics.eal.api.IAnimation;
import de.esolutions.graphics.eal.api.IAnimationClip;
import de.esolutions.graphics.eal.api.IAnimationPlayer;
import de.esolutions.graphics.eal.api.IContext;
import de.esolutions.graphics.eal.api.IFont;
import de.esolutions.graphics.eal.api.IFontGroup;
import de.esolutions.graphics.eal.api.IFontGroupAsync;
import de.esolutions.graphics.eal.api.IFontGroupFontHandle;
import de.esolutions.graphics.eal.api.IFontList;
import de.esolutions.graphics.eal.api.IINodeImage;
import de.esolutions.graphics.eal.api.IINodeText;
import de.esolutions.graphics.eal.api.IImage;
import de.esolutions.graphics.eal.api.IImageAsync;
import de.esolutions.graphics.eal.api.IManager;
import de.esolutions.graphics.eal.api.IMaterial;
import de.esolutions.graphics.eal.api.IMeshData;
import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode2DHud;
import de.esolutions.graphics.eal.api.INode2DImage;
import de.esolutions.graphics.eal.api.INode2DLink;
import de.esolutions.graphics.eal.api.INode2DManaged;
import de.esolutions.graphics.eal.api.INode2DPartial;
import de.esolutions.graphics.eal.api.INode2DText;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.graphics.eal.api.INode3DCamera;
import de.esolutions.graphics.eal.api.INode3DImage;
import de.esolutions.graphics.eal.api.INode3DMesh;
import de.esolutions.graphics.eal.api.INode3DQuickDraw;
import de.esolutions.graphics.eal.api.INode3DScene;
import de.esolutions.graphics.eal.api.INode3DText;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.eal.api.IProperty;
import de.esolutions.graphics.eal.api.IRenderer;
import de.esolutions.graphics.eal.api.IRendererAnnotation;
import de.esolutions.graphics.eal.api.ITemplateNode2D;
import de.esolutions.graphics.eal.api.ITemplateNode3D;
import de.esolutions.graphics.eal.api.ITextLayout;
import de.esolutions.graphics.eal.api.ITextLayoutResult;
import de.esolutions.graphics.eal.api.ITextLayoutSection;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.eal.api.ITextureAtlas;
import de.esolutions.graphics.eal.api.ITextureShared;
import de.esolutions.graphics.eal.api.ITimeLineSequence;
import de.esolutions.graphics.eal.colorRGBAf;
import de.esolutions.graphics.eal.displaySize_t;
import de.esolutions.graphics.eal.ealMouseState_t;
import de.esolutions.graphics.eal.ealSize_t;
import de.esolutions.graphics.eal.glyphInformation_t;
import de.esolutions.graphics.eal.glyph_t;
import de.esolutions.graphics.eal.utility.CFrameInformation;
import de.esolutions.graphics.eal.utility.CImageStorage;
import de.esolutions.graphics.eal.utility.CInterpolatorAccelerated;
import de.esolutions.graphics.eal.utility.CLerpD;
import de.esolutions.graphics.eal.utility.CLerpF;
import de.esolutions.graphics.eal.utility.CLinearInterpolatorD;
import de.esolutions.graphics.eal.utility.CLinearInterpolatorF;
import de.esolutions.graphics.eal.utility.COffscreenHelper;
import de.esolutions.graphics.eal.utility.IImageStorageListener;
import de.esolutions.graphics.eal.utility.IImageStorageListener$enType_t;
import de.esolutions.graphics.ipl.VectorD;
import de.esolutions.graphics.ipl.VectorF;
import java.math.BigInteger;
import java.nio.ByteBuffer;

public class ealswigJNI {
    public static final native int EAL_VERSION_get() {
    }

    public static final native long new_eal_Version() {
    }

    public static final native void delete_eal_Version(long l) {
    }

    public static final native void eal_Version_print() {
    }

    public static final native String eal_Version_verToString__SWIG_0() {
    }

    public static final native boolean eal_Version_isValid() {
    }

    public static final native int eal_Version_getVersion() {
    }

    public static final native String eal_Version_verToString__SWIG_1(int n) {
    }

    public static final native void eal_Version_setJava(boolean bl) {
    }

    public static final native boolean eal_Version_isJava() {
    }

    public static final native void eal_Version_registerBinding(int n) {
    }

    public static final native void eal_colorRGBAf_fRed_set(long l, colorRGBAf colorRGBAf2, float f2) {
    }

    public static final native float eal_colorRGBAf_fRed_get(long l, colorRGBAf colorRGBAf2) {
    }

    public static final native void eal_colorRGBAf_fGreen_set(long l, colorRGBAf colorRGBAf2, float f2) {
    }

    public static final native float eal_colorRGBAf_fGreen_get(long l, colorRGBAf colorRGBAf2) {
    }

    public static final native void eal_colorRGBAf_fBlue_set(long l, colorRGBAf colorRGBAf2, float f2) {
    }

    public static final native float eal_colorRGBAf_fBlue_get(long l, colorRGBAf colorRGBAf2) {
    }

    public static final native void eal_colorRGBAf_fAlpha_set(long l, colorRGBAf colorRGBAf2, float f2) {
    }

    public static final native float eal_colorRGBAf_fAlpha_get(long l, colorRGBAf colorRGBAf2) {
    }

    public static final native long new_eal_colorRGBAf__SWIG_0() {
    }

    public static final native long new_eal_colorRGBAf__SWIG_1(float f2, float f3, float f4, float f5) {
    }

    public static final native void delete_eal_colorRGBAf(long l) {
    }

    public static final native int eal_MEMORYTYPE_NONE_get() {
    }

    public static final native int eal_MEMORYTYPE_RAM_get() {
    }

    public static final native int eal_MEMORYTYPE_GPU_get() {
    }

    public static final native int eal_MEMORYTYPE_RAM_GPU_get() {
    }

    public static final native int eal_EVENTTYPE_MERGE_LOADED_get() {
    }

    public static final native int eal_EVENTTYPE_MERGE_MERGED_get() {
    }

    public static final native int eal_EVENTTYPE_IMAGE_get() {
    }

    public static final native int eal_EVENTTYPE_IMAGE_SAVE_get() {
    }

    public static final native int eal_EVENTTYPE_FONTGROUP_get() {
    }

    public static final native int eal_EVENTTYPE_SAVE_get() {
    }

    public static final native int eal_IMAGE_OPTIONS_MASK_FORMAT_get() {
    }

    public static final native int eal_IMAGE_OPTIONS_FORMAT_RGBA_8888_get() {
    }

    public static final native int eal_IMAGE_OPTIONS_FORMAT_RGB_888_get() {
    }

    public static final native int eal_IMAGE_OPTIONS_FORMAT_RGB_565_get() {
    }

    public static final native int eal_IMAGE_OPTIONS_FORMAT_L_8_get() {
    }

    public static final native int eal_IMAGE_OPTIONS_FORMAT_A_8_get() {
    }

    public static final native int eal_IMAGE_OPTIONS_FORMAT_LA_88_get() {
    }

    public static final native int eal_IMAGE_OPTIONS_FORMAT_AUTO_get() {
    }

    public static final native int eal_IMAGE_OPTIONS_FORMAT_INVALID_get() {
    }

    public static final native int eal_TEX_OPTIONS_MASK_MEMORY_get() {
    }

    public static final native int eal_TEX_OPTIONS_MASK_FILTER_get() {
    }

    public static final native int eal_TEX_OPTIONS_MASK_WRAP_get() {
    }

    public static final native int eal_TEX_OPTIONS_MASK_COMPRESSION_get() {
    }

    public static final native int eal_TEX_OPTIONS_MASK_FORMAT_get() {
    }

    public static final native int eal_TEX_OPTIONS_MASK_EXT_get() {
    }

    public static final native int eal_TEX_OPTIONS_MEMORY_GPU_get() {
    }

    public static final native int eal_TEX_OPTIONS_MEMORY_RAM_get() {
    }

    public static final native int eal_TEX_OPTIONS_FILTER_POINT_get() {
    }

    public static final native int eal_TEX_OPTIONS_FILTER_BILINEAR_get() {
    }

    public static final native int eal_TEX_OPTIONS_FILTER_TRILINAR_get() {
    }

    public static final native int eal_TEX_OPTIONS_FILTER_MIMAP_get() {
    }

    public static final native int eal_TEX_OPTIONS_WRAP_REPEAT_get() {
    }

    public static final native int eal_TEX_OPTIONS_WRAP_CLAMP_get() {
    }

    public static final native int eal_TEX_OPTIONS_COMPRESSION_NONE_get() {
    }

    public static final native int eal_TEX_OPTIONS_COMPRESSION_ETC_get() {
    }

    public static final native int eal_TEX_OPTIONS_COMPRESSION_DXT3_RGBA_get() {
    }

    public static final native int eal_TEX_OPTIONS_COMPRESSION_DXT5_RGBA_get() {
    }

    public static final native int eal_TEX_OPTIONS_FORMAT_RGBA_8888_get() {
    }

    public static final native int eal_TEX_OPTIONS_FORMAT_RGB_888_get() {
    }

    public static final native int eal_TEX_OPTIONS_FORMAT_RGB_565_get() {
    }

    public static final native int eal_TEX_OPTIONS_FORMAT_L_8_get() {
    }

    public static final native int eal_TEX_OPTIONS_FORMAT_A_8_get() {
    }

    public static final native int eal_TEX_OPTIONS_FORMAT_LA_88_get() {
    }

    public static final native int eal_TEX_OPTIONS_FORMAT_INVALID_get() {
    }

    public static final native int eal_TEX_OPTIONS_EXT_CLEAR_BLACK_get() {
    }

    public static final native int eal_TEX_OPTIONS_EXT_NO_ATLAS_get() {
    }

    public static final native int eal_TEX_OPTIONS_EXT_EXTERNAL_OES_get() {
    }

    public static final native int eal_TEX_OPTION_INVALID_get() {
    }

    public static final native void eal_displaySize_t_uiWidth_set(long l, displaySize_t displaySize_t2, long l2) {
    }

    public static final native long eal_displaySize_t_uiWidth_get(long l, displaySize_t displaySize_t2) {
    }

    public static final native void eal_displaySize_t_uiHeight_set(long l, displaySize_t displaySize_t2, long l2) {
    }

    public static final native long eal_displaySize_t_uiHeight_get(long l, displaySize_t displaySize_t2) {
    }

    public static final native long new_eal_displaySize_t() {
    }

    public static final native void delete_eal_displaySize_t(long l) {
    }

    public static final native int eal_EAL_PRINT_OPTION_NONE_get() {
    }

    public static final native int eal_EAL_PRINT_OPTION_MODE_VISIBLE_get() {
    }

    public static final native int eal_EAL_PRINT_OPTION_MODE_LAYER_ONLY_get() {
    }

    public static final native int eal_EAL_PRINT_OPTION_MODE_EXT_get() {
    }

    public static final native int eal_EAL_PRINT_OPTION_MODE_PR_get() {
    }

    public static final native int eal_EAL_PRINT_OPTION_OUTPUT_STDOUT_get() {
    }

    public static final native int eal_EAL_PRINT_OPTION_OUTPUT_TRACE_get() {
    }

    public static final native int eal_EAL_PRINT_OPTION_TYPE_PLAIN_get() {
    }

    public static final native int eal_EAL_PRINT_OPTION_TYPE_JSON_get() {
    }

    public static final native int eal_EAL_PRINT_OPTION_TYPE_XML_get() {
    }

    public static final native int eal_EAL_PRINT_FLAG_PROPERTIES_get() {
    }

    public static final native int eal_EAL_PRINT_OPTION_MASK_MODE_get() {
    }

    public static final native int eal_EAL_PRINT_OPTION_MASK_OUTPUT_get() {
    }

    public static final native int eal_EAL_PRINT_OPTION_MASK_TYPE_get() {
    }

    public static final native int eal_EAL_MERGE_FLAG_NONE_get() {
    }

    public static final native int eal_EAL_MERGE_FLAG_FORCE_get() {
    }

    public static final native int eal_EAL_MERGE_FLAG_LOADING_HINT_PRELOAD_get() {
    }

    public static final native int eal_EAL_MERGE_FLAG_LOADING_HINT_MAP_get() {
    }

    public static final native int eal_EAL_MERGE_FLAG_LOADING_MASK_get() {
    }

    public static final native void eal_glyphInformation_t_uiTotalGlyphs_set(long l, glyphInformation_t glyphInformation_t2, long l2) {
    }

    public static final native long eal_glyphInformation_t_uiTotalGlyphs_get(long l, glyphInformation_t glyphInformation_t2) {
    }

    public static final native void eal_glyphInformation_t_uiAvailableGlyphs_set(long l, glyphInformation_t glyphInformation_t2, long l2) {
    }

    public static final native long eal_glyphInformation_t_uiAvailableGlyphs_get(long l, glyphInformation_t glyphInformation_t2) {
    }

    public static final native long new_eal_glyphInformation_t() {
    }

    public static final native void delete_eal_glyphInformation_t(long l) {
    }

    public static final native int EAL_FONT_MAX_WIDTH_get() {
    }

    public static final native void eal_ealSize_t_width_set(long l, ealSize_t ealSize_t2, long l2) {
    }

    public static final native long eal_ealSize_t_width_get(long l, ealSize_t ealSize_t2) {
    }

    public static final native void eal_ealSize_t_height_set(long l, ealSize_t ealSize_t2, long l2) {
    }

    public static final native long eal_ealSize_t_height_get(long l, ealSize_t ealSize_t2) {
    }

    public static final native long new_eal_ealSize_t() {
    }

    public static final native void delete_eal_ealSize_t(long l) {
    }

    public static final native void eal_glyph_t_width_set(long l, glyph_t glyph_t2, long l2) {
    }

    public static final native long eal_glyph_t_width_get(long l, glyph_t glyph_t2) {
    }

    public static final native void eal_glyph_t_height_set(long l, glyph_t glyph_t2, long l2) {
    }

    public static final native long eal_glyph_t_height_get(long l, glyph_t glyph_t2) {
    }

    public static final native void eal_glyph_t_x_set(long l, glyph_t glyph_t2, float f2) {
    }

    public static final native float eal_glyph_t_x_get(long l, glyph_t glyph_t2) {
    }

    public static final native void eal_glyph_t_y_set(long l, glyph_t glyph_t2, float f2) {
    }

    public static final native float eal_glyph_t_y_get(long l, glyph_t glyph_t2) {
    }

    public static final native void eal_glyph_t_caretX_set(long l, glyph_t glyph_t2, float f2) {
    }

    public static final native float eal_glyph_t_caretX_get(long l, glyph_t glyph_t2) {
    }

    public static final native void eal_glyph_t_isRightToLeft_set(long l, glyph_t glyph_t2, boolean bl) {
    }

    public static final native boolean eal_glyph_t_isRightToLeft_get(long l, glyph_t glyph_t2) {
    }

    public static final native long new_eal_glyph_t() {
    }

    public static final native void delete_eal_glyph_t(long l) {
    }

    public static final native void delete_eal_Defaults(long l) {
    }

    public static final native long eal_Defaults_getFlagsImage() {
    }

    public static final native long eal_Defaults_getFlagsTexture() {
    }

    public static final native long new_eal_FlagImage__SWIG_0() {
    }

    public static final native long new_eal_FlagImage__SWIG_1(int n) {
    }

    public static final native long new_eal_FlagImage__SWIG_2(long l) {
    }

    public static final native long eal_FlagImage_getFlagValue(long l, FlagImage flagImage) {
    }

    public static final native void eal_FlagImage_setFlag(long l, FlagImage flagImage, int n) {
    }

    public static final native boolean eal_FlagImage_isFlag(long l, FlagImage flagImage, int n) {
    }

    public static final native void eal_FlagImage_reset(long l, FlagImage flagImage) {
    }

    public static final native void eal_FlagImage_resetPos(long l, FlagImage flagImage, long l2) {
    }

    public static final native void eal_FlagImage_unsetFlag(long l, FlagImage flagImage, int n) {
    }

    public static final native void eal_FlagImage_setFlagValue(long l, FlagImage flagImage, long l2) {
    }

    public static final native long eal_FlagImage_getHexValueAtPos(long l, FlagImage flagImage, long l2) {
    }

    public static final native long eal_FlagImage_extractPosition(long l, FlagImage flagImage, long l2) {
    }

    public static final native long eal_FlagImage_getByMask(long l, FlagImage flagImage, long l2) {
    }

    public static final native boolean eal_FlagImage_equal__SWIG_0(long l, FlagImage flagImage, long l2) {
    }

    public static final native boolean eal_FlagImage_equal__SWIG_1(long l, FlagImage flagImage, int n) {
    }

    public static final native boolean eal_FlagImage_unequal__SWIG_0(long l, FlagImage flagImage, long l2) {
    }

    public static final native boolean eal_FlagImage_unequal__SWIG_1(long l, FlagImage flagImage, int n) {
    }

    public static final native boolean eal_FlagImage_contains__SWIG_0(long l, FlagImage flagImage, int n) {
    }

    public static final native boolean eal_FlagImage_contains__SWIG_1(long l, FlagImage flagImage, long l2, FlagImage flagImage2) {
    }

    public static final native void delete_eal_FlagImage(long l) {
    }

    public static final native long new_eal_FlagTexture__SWIG_0() {
    }

    public static final native long new_eal_FlagTexture__SWIG_1(int n) {
    }

    public static final native long new_eal_FlagTexture__SWIG_2(long l) {
    }

    public static final native long eal_FlagTexture_getFlagValue(long l, FlagTexture flagTexture) {
    }

    public static final native void eal_FlagTexture_setFlag(long l, FlagTexture flagTexture, int n) {
    }

    public static final native boolean eal_FlagTexture_isFlag(long l, FlagTexture flagTexture, int n) {
    }

    public static final native void eal_FlagTexture_reset(long l, FlagTexture flagTexture) {
    }

    public static final native void eal_FlagTexture_resetPos(long l, FlagTexture flagTexture, long l2) {
    }

    public static final native void eal_FlagTexture_unsetFlag(long l, FlagTexture flagTexture, int n) {
    }

    public static final native void eal_FlagTexture_setFlagValue(long l, FlagTexture flagTexture, long l2) {
    }

    public static final native long eal_FlagTexture_getHexValueAtPos(long l, FlagTexture flagTexture, long l2) {
    }

    public static final native long eal_FlagTexture_extractPosition(long l, FlagTexture flagTexture, long l2) {
    }

    public static final native long eal_FlagTexture_getByMask(long l, FlagTexture flagTexture, long l2) {
    }

    public static final native boolean eal_FlagTexture_equal__SWIG_0(long l, FlagTexture flagTexture, long l2) {
    }

    public static final native boolean eal_FlagTexture_equal__SWIG_1(long l, FlagTexture flagTexture, int n) {
    }

    public static final native boolean eal_FlagTexture_unequal__SWIG_0(long l, FlagTexture flagTexture, long l2) {
    }

    public static final native boolean eal_FlagTexture_unequal__SWIG_1(long l, FlagTexture flagTexture, int n) {
    }

    public static final native boolean eal_FlagTexture_contains__SWIG_0(long l, FlagTexture flagTexture, int n) {
    }

    public static final native boolean eal_FlagTexture_contains__SWIG_1(long l, FlagTexture flagTexture, long l2, FlagTexture flagTexture2) {
    }

    public static final native void delete_eal_FlagTexture(long l) {
    }

    public static final native long new_eal_FlagPrint__SWIG_0() {
    }

    public static final native long new_eal_FlagPrint__SWIG_1(int n) {
    }

    public static final native long new_eal_FlagPrint__SWIG_2(long l) {
    }

    public static final native long eal_FlagPrint_getFlagValue(long l, FlagPrint flagPrint) {
    }

    public static final native void eal_FlagPrint_setFlag(long l, FlagPrint flagPrint, int n) {
    }

    public static final native boolean eal_FlagPrint_isFlag(long l, FlagPrint flagPrint, int n) {
    }

    public static final native void eal_FlagPrint_reset(long l, FlagPrint flagPrint) {
    }

    public static final native void eal_FlagPrint_resetPos(long l, FlagPrint flagPrint, long l2) {
    }

    public static final native void eal_FlagPrint_unsetFlag(long l, FlagPrint flagPrint, int n) {
    }

    public static final native void eal_FlagPrint_setFlagValue(long l, FlagPrint flagPrint, long l2) {
    }

    public static final native long eal_FlagPrint_getHexValueAtPos(long l, FlagPrint flagPrint, long l2) {
    }

    public static final native long eal_FlagPrint_extractPosition(long l, FlagPrint flagPrint, long l2) {
    }

    public static final native long eal_FlagPrint_getByMask(long l, FlagPrint flagPrint, long l2) {
    }

    public static final native boolean eal_FlagPrint_equal__SWIG_0(long l, FlagPrint flagPrint, long l2) {
    }

    public static final native boolean eal_FlagPrint_equal__SWIG_1(long l, FlagPrint flagPrint, int n) {
    }

    public static final native boolean eal_FlagPrint_unequal__SWIG_0(long l, FlagPrint flagPrint, long l2) {
    }

    public static final native boolean eal_FlagPrint_unequal__SWIG_1(long l, FlagPrint flagPrint, int n) {
    }

    public static final native boolean eal_FlagPrint_contains__SWIG_0(long l, FlagPrint flagPrint, int n) {
    }

    public static final native boolean eal_FlagPrint_contains__SWIG_1(long l, FlagPrint flagPrint, long l2, FlagPrint flagPrint2) {
    }

    public static final native void delete_eal_FlagPrint(long l) {
    }

    public static final native long new_eal_FlagMerge__SWIG_0() {
    }

    public static final native long new_eal_FlagMerge__SWIG_1(int n) {
    }

    public static final native long new_eal_FlagMerge__SWIG_2(long l) {
    }

    public static final native long eal_FlagMerge_getFlagValue(long l, FlagMerge flagMerge) {
    }

    public static final native void eal_FlagMerge_setFlag(long l, FlagMerge flagMerge, int n) {
    }

    public static final native boolean eal_FlagMerge_isFlag(long l, FlagMerge flagMerge, int n) {
    }

    public static final native void eal_FlagMerge_reset(long l, FlagMerge flagMerge) {
    }

    public static final native void eal_FlagMerge_resetPos(long l, FlagMerge flagMerge, long l2) {
    }

    public static final native void eal_FlagMerge_unsetFlag(long l, FlagMerge flagMerge, int n) {
    }

    public static final native void eal_FlagMerge_setFlagValue(long l, FlagMerge flagMerge, long l2) {
    }

    public static final native long eal_FlagMerge_getHexValueAtPos(long l, FlagMerge flagMerge, long l2) {
    }

    public static final native long eal_FlagMerge_extractPosition(long l, FlagMerge flagMerge, long l2) {
    }

    public static final native long eal_FlagMerge_getByMask(long l, FlagMerge flagMerge, long l2) {
    }

    public static final native boolean eal_FlagMerge_equal__SWIG_0(long l, FlagMerge flagMerge, long l2) {
    }

    public static final native boolean eal_FlagMerge_equal__SWIG_1(long l, FlagMerge flagMerge, int n) {
    }

    public static final native boolean eal_FlagMerge_unequal__SWIG_0(long l, FlagMerge flagMerge, long l2) {
    }

    public static final native boolean eal_FlagMerge_unequal__SWIG_1(long l, FlagMerge flagMerge, int n) {
    }

    public static final native boolean eal_FlagMerge_contains__SWIG_0(long l, FlagMerge flagMerge, int n) {
    }

    public static final native boolean eal_FlagMerge_contains__SWIG_1(long l, FlagMerge flagMerge, long l2, FlagMerge flagMerge2) {
    }

    public static final native void delete_eal_FlagMerge(long l) {
    }

    public static final native long new_eal_FlagEvent__SWIG_0() {
    }

    public static final native long new_eal_FlagEvent__SWIG_1(int n) {
    }

    public static final native long new_eal_FlagEvent__SWIG_2(long l) {
    }

    public static final native long eal_FlagEvent_getFlagValue(long l, FlagEvent flagEvent) {
    }

    public static final native void eal_FlagEvent_setFlag(long l, FlagEvent flagEvent, int n) {
    }

    public static final native boolean eal_FlagEvent_isFlag(long l, FlagEvent flagEvent, int n) {
    }

    public static final native void eal_FlagEvent_reset(long l, FlagEvent flagEvent) {
    }

    public static final native void eal_FlagEvent_resetPos(long l, FlagEvent flagEvent, long l2) {
    }

    public static final native void eal_FlagEvent_unsetFlag(long l, FlagEvent flagEvent, int n) {
    }

    public static final native void eal_FlagEvent_setFlagValue(long l, FlagEvent flagEvent, long l2) {
    }

    public static final native long eal_FlagEvent_getHexValueAtPos(long l, FlagEvent flagEvent, long l2) {
    }

    public static final native long eal_FlagEvent_extractPosition(long l, FlagEvent flagEvent, long l2) {
    }

    public static final native long eal_FlagEvent_getByMask(long l, FlagEvent flagEvent, long l2) {
    }

    public static final native boolean eal_FlagEvent_equal__SWIG_0(long l, FlagEvent flagEvent, long l2) {
    }

    public static final native boolean eal_FlagEvent_equal__SWIG_1(long l, FlagEvent flagEvent, int n) {
    }

    public static final native boolean eal_FlagEvent_unequal__SWIG_0(long l, FlagEvent flagEvent, long l2) {
    }

    public static final native boolean eal_FlagEvent_unequal__SWIG_1(long l, FlagEvent flagEvent, int n) {
    }

    public static final native boolean eal_FlagEvent_contains__SWIG_0(long l, FlagEvent flagEvent, int n) {
    }

    public static final native boolean eal_FlagEvent_contains__SWIG_1(long l, FlagEvent flagEvent, long l2, FlagEvent flagEvent2) {
    }

    public static final native void delete_eal_FlagEvent(long l) {
    }

    public static final native long new_eal_Vec2f__SWIG_0() {
    }

    public static final native long new_eal_Vec2f__SWIG_1(float f2, float f3) {
    }

    public static final native long new_eal_Vec2f__SWIG_2(float f2) {
    }

    public static final native long new_eal_Vec2f__SWIG_3(long l, Vec2f vec2f) {
    }

    public static final native long new_eal_Vec2f__SWIG_4(long l, Vec3f vec3f) {
    }

    public static final native long new_eal_Vec2f__SWIG_5(long l, Vec3f vec3f, int n) {
    }

    public static final native float eal_Vec2f_X__SWIG_0(long l, Vec2f vec2f) {
    }

    public static final native float eal_Vec2f_Y__SWIG_0(long l, Vec2f vec2f) {
    }

    public static final native float eal_Vec2f_Length(long l, Vec2f vec2f) {
    }

    public static final native float eal_Vec2f_Length2(long l, Vec2f vec2f) {
    }

    public static final native long eal_Vec2f_Normalize(long l, Vec2f vec2f) {
    }

    public static final native float eal_Vec2f_GetEpsilon() {
    }

    public static final native void eal_Vec2f_SetEpsilon(float f2) {
    }

    public static final native void delete_eal_Vec2f(long l) {
    }

    public static final native long new_eal_Vec3f__SWIG_0() {
    }

    public static final native long new_eal_Vec3f__SWIG_1(float f2, float f3, float f4) {
    }

    public static final native long new_eal_Vec3f__SWIG_2(float f2) {
    }

    public static final native long new_eal_Vec3f__SWIG_3(long l, Vec3f vec3f) {
    }

    public static final native long new_eal_Vec3f__SWIG_4(long l, Vec2f vec2f) {
    }

    public static final native long new_eal_Vec3f__SWIG_5(long l, Vec2f vec2f, float f2) {
    }

    public static final native long new_eal_Vec3f__SWIG_6(long l, Vec4f vec4f) {
    }

    public static final native long new_eal_Vec3f__SWIG_7(long l, Vec4f vec4f, int n) {
    }

    public static final native float eal_Vec3f_X__SWIG_0(long l, Vec3f vec3f) {
    }

    public static final native float eal_Vec3f_Y__SWIG_0(long l, Vec3f vec3f) {
    }

    public static final native float eal_Vec3f_Z__SWIG_0(long l, Vec3f vec3f) {
    }

    public static final native float eal_Vec3f_Length(long l, Vec3f vec3f) {
    }

    public static final native float eal_Vec3f_Length2(long l, Vec3f vec3f) {
    }

    public static final native long eal_Vec3f_Normalize(long l, Vec3f vec3f) {
    }

    public static final native void eal_Vec3f_Cross(long l, Vec3f vec3f, long l2, Vec3f vec3f2, long l3, Vec3f vec3f3) {
    }

    public static final native void eal_Vec3f_Sub(long l, Vec3f vec3f, long l2, Vec3f vec3f2, long l3, Vec3f vec3f3) {
    }

    public static final native void eal_Vec3f_Add(long l, Vec3f vec3f, long l2, Vec3f vec3f2, long l3, Vec3f vec3f3) {
    }

    public static final native float eal_Vec3f_Dot(long l, Vec3f vec3f, long l2, Vec3f vec3f2) {
    }

    public static final native float eal_Vec3f_GetEpsilon() {
    }

    public static final native void eal_Vec3f_SetEpsilon(float f2) {
    }

    public static final native void delete_eal_Vec3f(long l) {
    }

    public static final native long new_eal_Vec4f__SWIG_0() {
    }

    public static final native long new_eal_Vec4f__SWIG_1(float f2, float f3, float f4, float f5) {
    }

    public static final native long new_eal_Vec4f__SWIG_2(float f2) {
    }

    public static final native long new_eal_Vec4f__SWIG_3(long l, Vec4f vec4f) {
    }

    public static final native long new_eal_Vec4f__SWIG_4(long l, Vec3f vec3f) {
    }

    public static final native long new_eal_Vec4f__SWIG_5(long l, Vec3f vec3f, float f2) {
    }

    public static final native float eal_Vec4f_X__SWIG_0(long l, Vec4f vec4f) {
    }

    public static final native float eal_Vec4f_Y__SWIG_0(long l, Vec4f vec4f) {
    }

    public static final native float eal_Vec4f_Z__SWIG_0(long l, Vec4f vec4f) {
    }

    public static final native float eal_Vec4f_W__SWIG_0(long l, Vec4f vec4f) {
    }

    public static final native float eal_Vec4f_Length(long l, Vec4f vec4f) {
    }

    public static final native float eal_Vec4f_Length2(long l, Vec4f vec4f) {
    }

    public static final native long eal_Vec4f_Normalize(long l, Vec4f vec4f) {
    }

    public static final native float eal_Vec4f_GetEpsilon(long l, Vec4f vec4f) {
    }

    public static final native void eal_Vec4f_SetEpsilon(long l, Vec4f vec4f, float f2) {
    }

    public static final native void delete_eal_Vec4f(long l) {
    }

    public static final native long new_eal_Mat4f__SWIG_0() {
    }

    public static final native long new_eal_Mat4f__SWIG_1(long l, Vec4f vec4f, long l2, Vec4f vec4f2, long l3, Vec4f vec4f3, long l4, Vec4f vec4f4) {
    }

    public static final native long new_eal_Mat4f__SWIG_2(float f2) {
    }

    public static final native long new_eal_Mat4f__SWIG_3(long l, Mat4f mat4f) {
    }

    public static final native long eal_Mat4f_Transpose(long l, Mat4f mat4f) {
    }

    public static final native long eal_Mat4f_Inverse(long l, Mat4f mat4f) {
    }

    public static final native long eal_Mat4f_GetIdentity() {
    }

    public static final native long eal_Mat4f_GetTransMat(long l, Vec3f vec3f) {
    }

    public static final native long eal_Mat4f_GetRotMat(long l, Vec3f vec3f, float f2) {
    }

    public static final native long eal_Mat4f_GetScaleMat(long l, Vec3f vec3f) {
    }

    public static final native long eal_Mat4f_GetPerspMat(float f2) {
    }

    public static final native long eal_Mat4f_GetRotationVecFromIntoTo(long l, Vec3f vec3f, long l2, Vec3f vec3f2) {
    }

    public static final native void delete_eal_Mat4f(long l) {
    }

    public static final native long new_eal_Mat3f__SWIG_0() {
    }

    public static final native long new_eal_Mat3f__SWIG_1(long l, Vec3f vec3f, long l2, Vec3f vec3f2, long l3, Vec3f vec3f3) {
    }

    public static final native long new_eal_Mat3f__SWIG_2(float f2) {
    }

    public static final native long new_eal_Mat3f__SWIG_3(long l, Mat3f mat3f) {
    }

    public static final native long eal_Mat3f_Transpose(long l, Mat3f mat3f) {
    }

    public static final native long eal_Mat3f_Inverse(long l, Mat3f mat3f) {
    }

    public static final native long eal_Mat3f_GetColumn(long l, Mat3f mat3f, int n) {
    }

    public static final native long eal_Mat3f_Mult(long l, Mat3f mat3f, long l2, Mat3f mat3f2) {
    }

    public static final native long eal_Mat3f_GetIdentity() {
    }

    public static final native long eal_Mat3f_GetTransMat(long l, Vec2f vec2f) {
    }

    public static final native long eal_Mat3f_GetRotMat(long l, Vec2f vec2f, float f2) {
    }

    public static final native long eal_Mat3f_GetScaleMat(long l, Vec2f vec2f) {
    }

    public static final native long eal_Mat3f_GetEigenvector(long l, Mat3f mat3f, float f2) {
    }

    public static final native void delete_eal_Mat3f(long l) {
    }

    public static final native void delete_eal_IEvent(long l) {
    }

    public static final native int eal_IEvent_getType(long l, IEvent iEvent) {
    }

    public static final native boolean eal_IEvent_notifyListener(long l, IEvent iEvent) {
    }

    public static final native boolean eal_IEvent_isDeleteable(long l, IEvent iEvent) {
    }

    public static final native boolean eal_IEvent_isError(long l, IEvent iEvent) {
    }

    public static final native long eal_IEvent_getId(long l, IEvent iEvent) {
    }

    public static final native boolean eal_IEvent_isMergeEvent(long l, IEvent iEvent) {
    }

    public static final native long eal_IEvent_toEventMerge(long l, IEvent iEvent) {
    }

    public static final native boolean eal_IEvent_isEventImage(long l, IEvent iEvent) {
    }

    public static final native long eal_IEvent_toEventImage(long l, IEvent iEvent) {
    }

    public static final native void delete_eal_IEventListener(long l) {
    }

    public static final native String eal_IEventListener_getName(long l, IEventListener iEventListener) {
    }

    public static final native void eal_IEventListener_process(long l, IEventListener iEventListener, long l2, IEvent iEvent) {
    }

    public static final native long eal_IEventListener_getTypes(long l, IEventListener iEventListener) {
    }

    public static final native boolean eal_IEventListener_attach(long l, IEventListener iEventListener, long l2, IManager iManager) {
    }

    public static final native boolean eal_IEventListener_detach(long l, IEventListener iEventListener) {
    }

    public static final native void delete_eal_IEventMerge(long l) {
    }

    public static final native String eal_IEventMerge_getFile(long l, IEventMerge iEventMerge) {
    }

    public static final native String eal_IEventMerge_getScreenMainPath(long l, IEventMerge iEventMerge) {
    }

    public static final native void eal_IEventMerge_setIndex(long l, IEventMerge iEventMerge, long l2) {
    }

    public static final native long eal_IEventMerge_getIndex(long l, IEventMerge iEventMerge) {
    }

    public static final native boolean eal_IEventMerge_isIndex(long l, IEventMerge iEventMerge) {
    }

    public static final native void delete_eal_IEventImage(long l) {
    }

    public static final native String eal_IEventImage_getFile(long l, IEventImage iEventImage) {
    }

    public static final native long eal_IEventImage_getImage(long l, IEventImage iEventImage) {
    }

    public static final native void delete_eal_IEventImageSave(long l) {
    }

    public static final native void delete_eal_IEventFontGroup(long l) {
    }

    public static final native long eal_IEventFontGroup_requestFontgroup(long l, IEventFontGroup iEventFontGroup) {
    }

    public static final native long new_eal_IInputListener(long l, IManager iManager) {
    }

    public static final native void delete_eal_IInputListener(long l) {
    }

    public static final native void eal_IInputListener_mouseEvent(long l, IInputListener iInputListener, int n, int n2, int n3) {
    }

    public static final native void eal_IInputListener_mouseEventSwigExplicitIInputListener(long l, IInputListener iInputListener, int n, int n2, int n3) {
    }

    public static final native void eal_IInputListener_director_connect(IInputListener iInputListener, long l, boolean bl, boolean bl2) {
    }

    public static final native void eal_IInputListener_change_ownership(IInputListener iInputListener, long l, boolean bl) {
    }

    public static final native long new_eal_CAbstractEventListener(long l, IManager iManager, long l2, FlagEvent flagEvent) {
    }

    public static final native void delete_eal_CAbstractEventListener(long l) {
    }

    public static final native String eal_CAbstractEventListener_getName(long l, CAbstractEventListener cAbstractEventListener) {
    }

    public static final native String eal_CAbstractEventListener_getNameSwigExplicitCAbstractEventListener(long l, CAbstractEventListener cAbstractEventListener) {
    }

    public static final native void eal_CAbstractEventListener_process(long l, CAbstractEventListener cAbstractEventListener, long l2, IEvent iEvent) {
    }

    public static final native void eal_CAbstractEventListener_processSwigExplicitCAbstractEventListener(long l, CAbstractEventListener cAbstractEventListener, long l2, IEvent iEvent) {
    }

    public static final native void eal_CAbstractEventListener_dispose(long l, CAbstractEventListener cAbstractEventListener) {
    }

    public static final native void eal_CAbstractEventListener_director_connect(CAbstractEventListener cAbstractEventListener, long l, boolean bl, boolean bl2) {
    }

    public static final native void eal_CAbstractEventListener_change_ownership(CAbstractEventListener cAbstractEventListener, long l, boolean bl) {
    }

    public static final native long new_eal_CMatrix4x4f() {
    }

    public static final native void delete_eal_CMatrix4x4f(long l) {
    }

    public static final native long eal_CMatrix4x4f_interpolate(long l, CMatrix4x4f cMatrix4x4f, long l2, CMatrix4x4f cMatrix4x4f2, float f2) {
    }

    public static final native long new_eal_CQuaternion__SWIG_0() {
    }

    public static final native long new_eal_CQuaternion__SWIG_1(long l, Vec3f vec3f, float f2) {
    }

    public static final native long new_eal_CQuaternion__SWIG_2(long l, Mat4f mat4f) {
    }

    public static final native void delete_eal_CQuaternion(long l) {
    }

    public static final native long eal_CQuaternion_createIdentity() {
    }

    public static final native void eal_CQuaternion_normalize(long l, CQuaternion cQuaternion) {
    }

    public static final native void eal_CQuaternion_inverse(long l, CQuaternion cQuaternion) {
    }

    public static final native long eal_CQuaternion_slerp(long l, CQuaternion cQuaternion, long l2, CQuaternion cQuaternion2, float f2) {
    }

    public static final native long eal_CQuaternion_toMatrix4x4(long l, CQuaternion cQuaternion) {
    }

    public static final native long eal_CQuaternion_toMatrix(long l, CQuaternion cQuaternion) {
    }

    public static final native long new_eal_CMergeInfo() {
    }

    public static final native void delete_eal_CMergeInfo(long l) {
    }

    public static final native long eal_CMergeInfo_getId(long l, CMergeInfo cMergeInfo) {
    }

    public static final native String eal_CMergeInfo_getPath(long l, CMergeInfo cMergeInfo) {
    }

    public static final native void eal_CMergeInfo_dispose(long l, CMergeInfo cMergeInfo) {
    }

    public static final native void delete_eal_CTimeProvider(long l) {
    }

    public static final native BigInteger eal_CTimeProvider_getTime() {
    }

    public static final native BigInteger eal_CTimeProvider_getDeltaTime() {
    }

    public static final native long new_eal_CTimeProvider() {
    }

    public static final native long new_eal_ICacheCallback() {
    }

    public static final native void delete_eal_ICacheCallback(long l) {
    }

    public static final native void eal_ICacheCallback_destroy(long l, ICacheCallback iCacheCallback, int n) {
    }

    public static final native void eal_ICacheCallback_destroySwigExplicitICacheCallback(long l, ICacheCallback iCacheCallback, int n) {
    }

    public static final native void eal_ICacheCallback_director_connect(ICacheCallback iCacheCallback, long l, boolean bl, boolean bl2) {
    }

    public static final native void eal_ICacheCallback_change_ownership(ICacheCallback iCacheCallback, long l, boolean bl) {
    }

    public static final native long new_eal_CCacheLRU__SWIG_0(long l, IProject iProject, int n, int n2) {
    }

    public static final native long new_eal_CCacheLRU__SWIG_1(long l, IProject iProject, int n, int n2) {
    }

    public static final native void delete_eal_CCacheLRU(long l) {
    }

    public static final native boolean eal_CCacheLRU_defineImage(long l, CCacheLRU cCacheLRU, int n, String string, long l2, FlagImage flagImage) {
    }

    public static final native boolean eal_CCacheLRU_defineTexture(long l, CCacheLRU cCacheLRU, int n, int n2, long l2, FlagTexture flagTexture) {
    }

    public static final native long eal_CCacheLRU_getImage(long l, CCacheLRU cCacheLRU, int n) {
    }

    public static final native long eal_CCacheLRU_getTexture(long l, CCacheLRU cCacheLRU, int n) {
    }

    public static final native boolean eal_CCacheLRU_returnObject(long l, CCacheLRU cCacheLRU, int n) {
    }

    public static final native void eal_CCacheLRU_dump(long l, CCacheLRU cCacheLRU) {
    }

    public static final native boolean eal_CCacheLRU_isIdentifier(long l, CCacheLRU cCacheLRU, int n) {
    }

    public static final native boolean eal_CCacheLRU_setCallback(long l, CCacheLRU cCacheLRU, long l2, ICacheCallback iCacheCallback) {
    }

    public static final native boolean eal_CCacheLRU_destroyIdentifier(long l, CCacheLRU cCacheLRU, int n) {
    }

    public static final native void delete_eal_api_IObject(long l) {
    }

    public static final native boolean eal_api_IObject_isDisposed(long l, IObject iObject) {
    }

    public static final native boolean eal_api_IObject_equals(long l, IObject iObject, long l2, IObject iObject2) {
    }

    public static final native boolean eal_api_IObject_isValid(long l, IObject iObject) {
    }

    public static final native void eal_api_IObject_dispose(long l, IObject iObject) {
    }

    public static final native void delete_eal_api_IAnimation(long l) {
    }

    public static final native boolean eal_api_IAnimation_setTargetPropertyBlendIntensity(long l, IAnimation iAnimation) {
    }

    public static final native boolean eal_api_IAnimation_isValid(long l, IAnimation iAnimation) {
    }

    public static final native void eal_api_IAnimation_dispose(long l, IAnimation iAnimation) {
    }

    public static final native boolean eal_api_IAnimation_getValue(long l, IAnimation iAnimation, long l2, float[] fArray) {
    }

    public static final native String eal_api_IAnimation_getName(long l, IAnimation iAnimation) {
    }

    public static final native void delete_eal_api_IAnimationClip(long l) {
    }

    public static final native boolean eal_api_IAnimationClip_setStartTime(long l, IAnimationClip iAnimationClip, float f2) {
    }

    public static final native boolean eal_api_IAnimationClip_setRepeat(long l, IAnimationClip iAnimationClip, int n) {
    }

    public static final native int eal_api_IAnimationClip_getUniqueId(long l, IAnimationClip iAnimationClip) {
    }

    public static final native float eal_api_IAnimationClip_getDuration(long l, IAnimationClip iAnimationClip) {
    }

    public static final native float eal_api_IAnimationClip_getStartTime(long l, IAnimationClip iAnimationClip) {
    }

    public static final native float eal_api_IAnimationClip_getEndTime(long l, IAnimationClip iAnimationClip) {
    }

    public static final native boolean eal_api_IAnimationClip_isValid(long l, IAnimationClip iAnimationClip) {
    }

    public static final native void eal_api_IAnimationClip_dispose(long l, IAnimationClip iAnimationClip) {
    }

    public static final native long eal_api_IAnimationClip_getSize(long l, IAnimationClip iAnimationClip) {
    }

    public static final native long eal_api_IAnimationClip_getAnimation(long l, IAnimationClip iAnimationClip, long l2) {
    }

    public static final native long new_eal_api_IAnimationPlayer(long l, IProject iProject) {
    }

    public static final native void delete_eal_api_IAnimationPlayer(long l) {
    }

    public static final native boolean eal_api_IAnimationPlayer_add__SWIG_0(long l, IAnimationPlayer iAnimationPlayer, long l2, IAnimationClip iAnimationClip) {
    }

    public static final native boolean eal_api_IAnimationPlayer_add__SWIG_1(long l, IAnimationPlayer iAnimationPlayer, long l2, ITimeLineSequence iTimeLineSequence) {
    }

    public static final native boolean eal_api_IAnimationPlayer_remove(long l, IAnimationPlayer iAnimationPlayer, long l2, IAnimationClip iAnimationClip) {
    }

    public static final native void eal_api_IAnimationPlayer_play(long l, IAnimationPlayer iAnimationPlayer) {
    }

    public static final native void eal_api_IAnimationPlayer_pause(long l, IAnimationPlayer iAnimationPlayer) {
    }

    public static final native boolean eal_api_IAnimationPlayer_isValid(long l, IAnimationPlayer iAnimationPlayer) {
    }

    public static final native void eal_api_IAnimationPlayer_dispose(long l, IAnimationPlayer iAnimationPlayer) {
    }

    public static final native int eal_api_ITimeLineSequence_RETURN_INVALID_get() {
    }

    public static final native void delete_eal_api_ITimeLineSequence(long l) {
    }

    public static final native boolean eal_api_ITimeLineSequence_isValid(long l, ITimeLineSequence iTimeLineSequence) {
    }

    public static final native boolean eal_api_ITimeLineSequence_setContext(long l, ITimeLineSequence iTimeLineSequence, long l2, long l3, INode iNode) {
    }

    public static final native boolean eal_api_ITimeLineSequence_setTarget__SWIG_0(long l, ITimeLineSequence iTimeLineSequence, long l2, long l3, ITimeLineSequence iTimeLineSequence2) {
    }

    public static final native boolean eal_api_ITimeLineSequence_setTarget__SWIG_1(long l, ITimeLineSequence iTimeLineSequence, long l2, long l3, IAnimationClip iAnimationClip) {
    }

    public static final native long eal_api_ITimeLineSequence_getTarget(long l, ITimeLineSequence iTimeLineSequence, long l2) {
    }

    public static final native int eal_api_ITimeLineSequence_cloneEntry(long l, ITimeLineSequence iTimeLineSequence, long l2) {
    }

    public static final native boolean eal_api_ITimeLineSequence_setInputProperty(long l, ITimeLineSequence iTimeLineSequence, long l2, long l3, INode iNode, long l4, IProperty iProperty) {
    }

    public static final native void eal_api_ITimeLineSequence_print(long l, ITimeLineSequence iTimeLineSequence) {
    }

    public static final native void eal_api_ITimeLineSequence_dispose(long l, ITimeLineSequence iTimeLineSequence) {
    }

    public static final native boolean eal_api_ITimeLineSequence_makeEntryDirty(long l, ITimeLineSequence iTimeLineSequence, long l2) {
    }

    public static final native void delete_eal_api_IContext(long l) {
    }

    public static final native boolean eal_api_IContext_setVSync(long l, IContext iContext, boolean bl) {
    }

    public static final native void eal_api_IContext_disableDepthBuffer(long l, IContext iContext) {
    }

    public static final native boolean eal_api_IContext_setWidth(long l, IContext iContext, long l2) {
    }

    public static final native boolean eal_api_IContext_setHeight(long l, IContext iContext, long l2) {
    }

    public static final native long eal_api_IContext_getScreenData(long l, IContext iContext) {
    }

    public static final native boolean eal_api_IContext_setDisplayId(long l, IContext iContext, long l2) {
    }

    public static final native long eal_api_IContext_getDisplayId(long l, IContext iContext) {
    }

    public static final native boolean eal_api_IContext_setAnnotation(long l, IContext iContext, boolean bl) {
    }

    public static final native boolean eal_api_IContext_isValid(long l, IContext iContext) {
    }

    public static final native boolean eal_api_IContext_getScreenResolution(long l, IContext iContext, long l2, displaySize_t displaySize_t2) {
    }

    public static final native void eal_api_IContext_dispose(long l, IContext iContext) {
    }

    public static final native void delete_eal_api_IFactory(long l) {
    }

    public static final native boolean eal_api_IFactory_dereference(long l, IObject iObject) {
    }

    public static final native boolean eal_api_IFactory_destroy__SWIG_0(long l, INode iNode, boolean bl) {
    }

    public static final native boolean eal_api_IFactory_destroy__SWIG_1(long l, INode iNode) {
    }

    public static final native boolean eal_api_IFactory_destroy__SWIG_2(long l, IProject iProject) {
    }

    public static final native long eal_api_IFactory_requestEventImage__SWIG_0(long l, IManager iManager, String string, long l2, FlagImage flagImage) {
    }

    public static final native long eal_api_IFactory_requestEventImage__SWIG_1(long l, IManager iManager, String string, long l2, FlagImage flagImage, long l3, long l4) {
    }

    public static final native long eal_api_IFactory_requestEventImageSave(long l, IImage iImage, String string, int n) {
    }

    public static final native long eal_api_IFactory_requestEventFontGroup(long l, IManager iManager) {
    }

    public static final native long new_eal_api_IManager() {
    }

    public static final native void delete_eal_api_IManager(long l) {
    }

    public static final native boolean eal_api_IManager_start(long l, IManager iManager) {
    }

    public static final native boolean eal_api_IManager_stop(long l, IManager iManager) {
    }

    public static final native long eal_api_IManager_getContext(long l, IManager iManager) {
    }

    public static final native long eal_api_IManager_load(long l, IManager iManager, String string) {
    }

    public static final native long eal_api_IManager_getDefaultProject(long l, IManager iManager) {
    }

    public static final native long eal_api_IManager_createDefaultProject(long l, IManager iManager) {
    }

    public static final native boolean eal_api_IManager_setDefaultProject(long l, IManager iManager, long l2, IProject iProject) {
    }

    public static final native boolean eal_api_IManager_destroyDefaultProject(long l, IManager iManager, long l2, IProject iProject) {
    }

    public static final native void eal_api_IManager_printMemoryStatus(long l, IManager iManager) {
    }

    public static final native long eal_api_IManager_getMemoryVRAM(long l, IManager iManager) {
    }

    public static final native long eal_api_IManager_getMemoryRAM(long l, IManager iManager) {
    }

    public static final native long eal_api_IManager_getMemoryRAMFree(long l, IManager iManager) {
    }

    public static final native boolean eal_api_IManager_setMemorySize(long l, IManager iManager, long l2) {
    }

    public static final native boolean eal_api_IManager_isValid(long l, IManager iManager) {
    }

    public static final native long eal_api_IManager_getRenderer(long l, IManager iManager) {
    }

    public static final native void eal_api_IManager_dispose(long l, IManager iManager) {
    }

    public static final native boolean eal_api_IManager_dumpFontCaches(long l, IManager iManager, String string) {
    }

    public static final native String eal_api_IManager_triggerDump() {
    }

    public static final native long eal_api_IManager_layout(long l, IManager iManager, long l2, ITextLayout iTextLayout, String string) {
    }

    public static final native boolean eal_api_IManager_layoutGetWidth(long l, IManager iManager, long l2, ITextLayoutResult iTextLayoutResult, int[] nArray, int n) {
    }

    public static final native boolean eal_api_IManager_computeAvailableGlyphs(long l, IManager iManager, String string, long l2, ITextLayout iTextLayout, long l3, glyphInformation_t glyphInformation_t2) {
    }

    public static final native boolean eal_api_IManager_isMerged(long l, IManager iManager, long l2, IProject iProject, String string) {
    }

    public static final native boolean eal_api_IManager_execute__SWIG_0(long l, IManager iManager, long l2, IEventImage iEventImage) {
    }

    public static final native boolean eal_api_IManager_execute__SWIG_1(long l, IManager iManager, long l2, IEventImageSave iEventImageSave) {
    }

    public static final native boolean eal_api_IManager_execute__SWIG_2(long l, IManager iManager, long l2, IEventFontGroup iEventFontGroup) {
    }

    public static final native void eal_api_IManager_setObjectTracer(long l, IManager iManager, boolean bl) {
    }

    public static final native void eal_api_IManager_dumpObjects(long l, IManager iManager) {
    }

    public static final native void eal_api_IManager_dumpProfiling(long l, IManager iManager) {
    }

    public static final native void eal_api_IManager_dumpRegistry(long l, IManager iManager) {
    }

    public static final native void eal_api_IManager_dumpMemory(long l, IManager iManager) {
    }

    public static final native void eal_api_IManager_dumpResources(long l, IManager iManager) {
    }

    public static final native void eal_api_IManager_setRegistry(long l, IManager iManager, boolean bl) {
    }

    public static final native void eal_api_IManager_setObjectWarnLimit(long l, IManager iManager, long l2) {
    }

    public static final native boolean eal_api_IManager_setOpacityInvalidationInherit(long l, IManager iManager, boolean bl) {
    }

    public static final native boolean eal_api_IManager_setEventThreadNumber(long l, IManager iManager, long l2) {
    }

    public static final native boolean eal_api_IManager_setFontDpi(long l, IManager iManager, int n) {
    }

    public static final native int eal_api_IManager_getCurrentFontDpi(long l, IManager iManager) {
    }

    public static final native void delete_eal_api_IProject(long l) {
    }

    public static final native long eal_api_IProject_getScene(long l, IProject iProject, String string) {
    }

    public static final native long eal_api_IProject_getAnimationClip(long l, IProject iProject, String string) {
    }

    public static final native long eal_api_IProject_getAnimation(long l, IProject iProject, String string) {
    }

    public static final native long eal_api_IProject_getNode(long l, IProject iProject, String string) {
    }

    public static final native long eal_api_IProject_getNode2D(long l, IProject iProject, String string) {
    }

    public static final native long eal_api_IProject_getNode2DImage(long l, IProject iProject, String string) {
    }

    public static final native long eal_api_IProject_getNode3D(long l, IProject iProject, String string) {
    }

    public static final native long eal_api_IProject_getNode3DMesh(long l, IProject iProject, String string) {
    }

    public static final native long eal_api_IProject_getNode3DCamera(long l, IProject iProject, String string) {
    }

    public static final native long eal_api_IProject_getMaterial(long l, IProject iProject, String string) {
    }

    public static final native long eal_api_IProject_getNode2DLink(long l, IProject iProject, String string) {
    }

    public static final native long eal_api_IProject_getMeshData(long l, IProject iProject, String string) {
    }

    public static final native long eal_api_IProject_getTimeLineSequence(long l, IProject iProject, String string) {
    }

    public static final native long eal_api_IProject_getTemplateNode2D(long l, IProject iProject, String string) {
    }

    public static final native long eal_api_IProject_getTemplateNode3D(long l, IProject iProject, String string) {
    }

    public static final native long eal_api_IProject_getTexture(long l, IProject iProject, String string) {
    }

    public static final native boolean eal_api_IProject_merge__SWIG_0(long l, IProject iProject, int n, String string, long l2, CMergeInfo cMergeInfo, long l3, FlagMerge flagMerge) {
    }

    public static final native boolean eal_api_IProject_merge__SWIG_1(long l, IProject iProject, int n, String string, long l2, CMergeInfo cMergeInfo) {
    }

    public static final native boolean eal_api_IProject_merge__SWIG_2(long l, IProject iProject, int n, String string) {
    }

    public static final native boolean eal_api_IProject_isValid(long l, IProject iProject) {
    }

    public static final native boolean eal_api_IProject_setMainScene(long l, IProject iProject, long l2, INode3DScene iNode3DScene) {
    }

    public static final native boolean eal_api_IProject_setScreenMain(long l, IProject iProject, long l2, INode2D iNode2D) {
    }

    public static final native long eal_api_IProject_getScreenMain(long l, IProject iProject) {
    }

    public static final native boolean eal_api_IProject_isScreenMain(long l, IProject iProject) {
    }

    public static final native int eal_api_IProject_getTypeOfPath(long l, IProject iProject, String string) {
    }

    public static final native boolean eal_api_IProject_setRenderpass(long l, IProject iProject, String string, boolean bl) {
    }

    public static final native boolean eal_api_IProject_isNode(long l, IProject iProject, String string) {
    }

    public static final native boolean eal_api_IProject_isPrefab(long l, IProject iProject, String string) {
    }

    public static final native boolean eal_api_IProject_isAnimationClip(long l, IProject iProject, String string) {
    }

    public static final native long eal_api_IProject_getDefaultTimeLineSequence(long l, IProject iProject) {
    }

    public static final native void eal_api_IProject_dispose(long l, IProject iProject) {
    }

    public static final native boolean eal_api_IProject_registerNode(long l, IProject iProject, long l2, INode iNode, String string) {
    }

    public static final native void eal_api_IProject_list__SWIG_0(long l, IProject iProject, int n, boolean bl) {
    }

    public static final native void eal_api_IProject_list__SWIG_1(long l, IProject iProject, int n) {
    }

    public static final native boolean eal_api_IProject_list__SWIG_2(long l, IProject iProject, int n, String string) {
    }

    public static final native long new_eal_api_IImage__SWIG_0(long l, IManager iManager, String string) {
    }

    public static final native long new_eal_api_IImage__SWIG_1(long l, IManager iManager, String string, long l2, FlagImage flagImage) {
    }

    public static final native long new_eal_api_IImage__SWIG_2(long l, IManager iManager, String string, long l2, FlagImage flagImage, long l3, long l4) {
    }

    public static final native long new_eal_api_IImage__SWIG_3(long l, IManager iManager, ByteBuffer byteBuffer, long l2) {
    }

    public static final native long new_eal_api_IImage__SWIG_4(long l, IManager iManager, ByteBuffer byteBuffer, long l2, long l3) {
    }

    public static final native long new_eal_api_IImage__SWIG_5(long l, IManager iManager, ByteBuffer byteBuffer, long l2, long l3, long l4, FlagImage flagImage) {
    }

    public static final native void delete_eal_api_IImage(long l) {
    }

    public static final native ByteBuffer eal_api_IImage_getData(long l, IImage iImage) {
    }

    public static final native long eal_api_IImage_getSize(long l, IImage iImage) {
    }

    public static final native boolean eal_api_IImage_isValid(long l, IImage iImage) {
    }

    public static final native long eal_api_IImage_getWidth(long l, IImage iImage) {
    }

    public static final native long eal_api_IImage_getHeight(long l, IImage iImage) {
    }

    public static final native void eal_api_IImage_dispose(long l, IImage iImage) {
    }

    public static final native boolean eal_api_IImage_destroy(long l, IImage iImage) {
    }

    public static final native boolean eal_api_IImage_save(long l, IImage iImage, String string, int n) {
    }

    public static final native boolean eal_api_IImage_addText(long l, IImage iImage, long l2, IFont iFont, int n, String string) {
    }

    public static final native long eal_api_IImage_getImageInfo__SWIG_0(String string) {
    }

    public static final native long eal_api_IImage_getImageInfo__SWIG_1(ByteBuffer byteBuffer, long l) {
    }

    public static final native void delete_eal_api_IImageAsync(long l) {
    }

    public static final native long new_eal_api_IImageAsync__SWIG_0(ByteBuffer byteBuffer, long l) {
    }

    public static final native long new_eal_api_IImageAsync__SWIG_1(ByteBuffer byteBuffer, long l, long l2, long l3, long l4, FlagImage flagImage) {
    }

    public static final native boolean eal_api_IImageAsync_isValid(long l, IImageAsync iImageAsync) {
    }

    public static final native boolean eal_api_IImageAsync_destroy(long l, IImageAsync iImageAsync) {
    }

    public static final native long eal_api_IImageAsync_getWidth(long l, IImageAsync iImageAsync) {
    }

    public static final native long eal_api_IImageAsync_getHeight(long l, IImageAsync iImageAsync) {
    }

    public static final native void delete_eal_api_IMeshData(long l) {
    }

    public static final native boolean eal_api_IMeshData_morph(long l, IMeshData iMeshData, long l2, IMeshData iMeshData2, long l3, float f2) {
    }

    public static final native boolean eal_api_IMeshData_isValid(long l, IMeshData iMeshData) {
    }

    public static final native void eal_api_IMeshData_dispose(long l, IMeshData iMeshData) {
    }

    public static final native long new_eal_api_ITexture__SWIG_0(long l, IProject iProject, long l2, IImage iImage) {
    }

    public static final native long new_eal_api_ITexture__SWIG_1(long l, IProject iProject, long l2, IImage iImage, long l3, FlagTexture flagTexture) {
    }

    public static final native long new_eal_api_ITexture__SWIG_2(long l, IProject iProject, long l2, IImageAsync iImageAsync, long l3, FlagTexture flagTexture) {
    }

    public static final native void delete_eal_api_ITexture(long l) {
    }

    public static final native boolean eal_api_ITexture_isValid(long l, ITexture iTexture) {
    }

    public static final native void eal_api_ITexture_dispose(long l, ITexture iTexture) {
    }

    public static final native boolean eal_api_ITexture_destroy(long l, ITexture iTexture) {
    }

    public static final native long eal_api_ITexture_getWidth(long l, ITexture iTexture) {
    }

    public static final native long eal_api_ITexture_getHeight(long l, ITexture iTexture) {
    }

    public static final native boolean eal_api_ITexture_getData(long l, ITexture iTexture, ByteBuffer byteBuffer) {
    }

    public static final native boolean eal_api_ITexture_testIfReferenced(long l, ITexture iTexture) {
    }

    public static final native long eal_api_ITexture_getProperty(long l, ITexture iTexture, String string) {
    }

    public static final native long new_eal_api_ITextureShared(long l, IProject iProject, String string, long l2, long l3) {
    }

    public static final native void delete_eal_api_ITextureShared(long l) {
    }

    public static final native boolean eal_api_ITextureShared_updateFromDisplay(long l, ITextureShared iTextureShared, long l2) {
    }

    public static final native boolean eal_api_ITextureShared_updateFromDisplayable__SWIG_0(long l, ITextureShared iTextureShared, long l2) {
    }

    public static final native boolean eal_api_ITextureShared_updateFromDisplayable__SWIG_1(long l, ITextureShared iTextureShared, long l2, long l3, long l4, long l5, long l6) {
    }

    public static final native void eal_api_ITextureShared_dispose(long l, ITextureShared iTextureShared) {
    }

    public static final native boolean eal_api_ITextureShared_destroy(long l, ITextureShared iTextureShared) {
    }

    public static final native long new_eal_api_ITextureAtlas(long l, IProject iProject, String string) {
    }

    public static final native void delete_eal_api_ITextureAtlas(long l) {
    }

    public static final native long eal_api_ITextureAtlas_getTexture(long l, ITextureAtlas iTextureAtlas, long l2) {
    }

    public static final native boolean eal_api_ITextureAtlas_isValid(long l, ITextureAtlas iTextureAtlas) {
    }

    public static final native void eal_api_ITextureAtlas_dispose(long l, ITextureAtlas iTextureAtlas) {
    }

    public static final native boolean eal_api_ITextureAtlas_destroy(long l, ITextureAtlas iTextureAtlas) {
    }

    public static final native long new_eal_api_ITextureOffscreen__SWIG_0(long l, IProject iProject, String string, long l2, long l3) {
    }

    public static final native long new_eal_api_ITextureOffscreen__SWIG_1(long l, IProject iProject, String string, long l2, long l3, long l4, FlagTexture flagTexture) {
    }

    public static final native long new_eal_api_ITextureOffscreen__SWIG_2(long l, IProject iProject, String string, long l2, long l3, long l4, FlagTexture flagTexture, boolean bl) {
    }

    public static final native void delete_eal_api_ITextureOffscreen(long l) {
    }

    public static final native void delete_eal_api_IMaterial(long l) {
    }

    public static final native boolean eal_api_IMaterial_isValid(long l, IMaterial iMaterial) {
    }

    public static final native boolean eal_api_IMaterial_setTexture__SWIG_0(long l, IMaterial iMaterial, long l2, ITexture iTexture, String string) {
    }

    public static final native boolean eal_api_IMaterial_setTexture__SWIG_1(long l, IMaterial iMaterial, long l2, ITexture iTexture) {
    }

    public static final native long eal_api_IMaterial_getProperty(long l, IMaterial iMaterial, String string) {
    }

    public static final native void eal_api_IMaterial_dispose(long l, IMaterial iMaterial) {
    }

    public static final native boolean eal_api_IMaterial_setBlendMode(long l, IMaterial iMaterial, int n) {
    }

    public static final native void delete_eal_api_IProperty(long l) {
    }

    public static final native boolean eal_api_IProperty_set__SWIG_0(long l, IProperty iProperty, int n) {
    }

    public static final native boolean eal_api_IProperty_set__SWIG_1(long l, IProperty iProperty, float f2) {
    }

    public static final native boolean eal_api_IProperty_set__SWIG_2(long l, IProperty iProperty, boolean bl) {
    }

    public static final native boolean eal_api_IProperty_set__SWIG_3(long l, IProperty iProperty, String string) {
    }

    public static final native boolean eal_api_IProperty_set__SWIG_4(long l, IProperty iProperty, long l2, colorRGBAf colorRGBAf2) {
    }

    public static final native boolean eal_api_IProperty_setColor(long l, IProperty iProperty, long l2) {
    }

    public static final native boolean eal_api_IProperty_set__SWIG_5(long l, IProperty iProperty, long l2, ITexture iTexture) {
    }

    public static final native boolean eal_api_IProperty_set__SWIG_6(long l, IProperty iProperty, long l2, INode3D iNode3D) {
    }

    public static final native boolean eal_api_IProperty_set__SWIG_7(long l, IProperty iProperty, long l2, IMaterial iMaterial) {
    }

    public static final native boolean eal_api_IProperty_set__SWIG_8(long l, IProperty iProperty, long l2, Vec2f vec2f) {
    }

    public static final native boolean eal_api_IProperty_set__SWIG_9(long l, IProperty iProperty, long l2, Vec3f vec3f) {
    }

    public static final native boolean eal_api_IProperty_set__SWIG_10(long l, IProperty iProperty, long l2, Vec4f vec4f) {
    }

    public static final native boolean eal_api_IProperty_setDefault(long l, IProperty iProperty) {
    }

    public static final native int eal_api_IProperty_getInt(long l, IProperty iProperty) {
    }

    public static final native float eal_api_IProperty_getFloat(long l, IProperty iProperty) {
    }

    public static final native boolean eal_api_IProperty_getBool(long l, IProperty iProperty) {
    }

    public static final native String eal_api_IProperty_getString(long l, IProperty iProperty) {
    }

    public static final native long eal_api_IProperty_getColor(long l, IProperty iProperty) {
    }

    public static final native long eal_api_IProperty_getColorAsInt(long l, IProperty iProperty) {
    }

    public static final native long eal_api_IProperty_getVec2D(long l, IProperty iProperty) {
    }

    public static final native long eal_api_IProperty_getVec3D(long l, IProperty iProperty) {
    }

    public static final native long eal_api_IProperty_getVec4D(long l, IProperty iProperty) {
    }

    public static final native long eal_api_IProperty_getTexture(long l, IProperty iProperty) {
    }

    public static final native long eal_api_IProperty_getNode3D(long l, IProperty iProperty) {
    }

    public static final native long eal_api_IProperty_getMaterial(long l, IProperty iProperty) {
    }

    public static final native boolean eal_api_IProperty_isValid(long l, IProperty iProperty) {
    }

    public static final native int eal_api_IProperty_getType(long l, IProperty iProperty) {
    }

    public static final native void eal_api_IProperty_dispose(long l, IProperty iProperty) {
    }

    public static final native boolean eal_api_IProperty_remove(long l, IProperty iProperty) {
    }

    public static final native String eal_api_IProperty_getName(long l, IProperty iProperty) {
    }

    public static final native long eal_api_IProperty_getMatrix3x3(long l, IProperty iProperty) {
    }

    public static final native long eal_api_IProperty_getMatrix4x4(long l, IProperty iProperty) {
    }

    public static final native void delete_eal_api_IRenderer(long l) {
    }

    public static final native boolean eal_api_IRenderer_render__SWIG_0(long l, IRenderer iRenderer, long l2, INode2D iNode2D) {
    }

    public static final native boolean eal_api_IRenderer_render__SWIG_1(long l, IRenderer iRenderer, long l2, IProject iProject) {
    }

    public static final native boolean eal_api_IRenderer_isValid(long l, IRenderer iRenderer) {
    }

    public static final native boolean eal_api_IRenderer_setHud(long l, IRenderer iRenderer, boolean bl) {
    }

    public static final native boolean eal_api_IRenderer_setSleepMode(long l, IRenderer iRenderer, boolean bl) {
    }

    public static final native void eal_api_IRenderer_dispose(long l, IRenderer iRenderer) {
    }

    public static final native boolean eal_api_IRenderer_render__SWIG_2(long l, IRenderer iRenderer) {
    }

    public static final native boolean eal_api_IRenderer_record(long l, IRenderer iRenderer, boolean bl, String string, float f2, long l2) {
    }

    public static final native boolean eal_api_IRenderer_isRecording(long l, IRenderer iRenderer) {
    }

    public static final native long new_eal_api_IRendererAnnotation(long l, IRenderer iRenderer) {
    }

    public static final native void delete_eal_api_IRendererAnnotation(long l) {
    }

    public static final native boolean eal_api_IRendererAnnotation_setData__SWIG_0(long l, IRendererAnnotation iRendererAnnotation, short s, String string) {
    }

    public static final native boolean eal_api_IRendererAnnotation_setData__SWIG_1(long l, IRendererAnnotation iRendererAnnotation, short s, ByteBuffer byteBuffer, long l2) {
    }

    public static final native boolean eal_api_IRendererAnnotation_isValid(long l, IRendererAnnotation iRendererAnnotation) {
    }

    public static final native void eal_api_IRendererAnnotation_dispose(long l, IRendererAnnotation iRendererAnnotation) {
    }

    public static final native boolean eal_api_IRendererAnnotation_setErrorCorrection(long l, IRendererAnnotation iRendererAnnotation, boolean bl) {
    }

    public static final native void delete_eal_api_IINodeImage(long l) {
    }

    public static final native boolean eal_api_IINodeImage_setTexture(long l, IINodeImage iINodeImage, long l2, ITexture iTexture) {
    }

    public static final native boolean eal_api_IINodeImage_isValid(long l, IINodeImage iINodeImage) {
    }

    public static final native void eal_api_IINodeImage_dispose(long l, IINodeImage iINodeImage) {
    }

    public static final native boolean eal_api_IINodeImage_setModulateColor__SWIG_0(long l, IINodeImage iINodeImage, long l2, colorRGBAf colorRGBAf2) {
    }

    public static final native boolean eal_api_IINodeImage_setModulateColor__SWIG_1(long l, IINodeImage iINodeImage, long l2) {
    }

    public static final native boolean eal_api_IINodeImage_clipImage(long l, IINodeImage iINodeImage, float f2, float f3, float f4, float f5) {
    }

    public static final native void delete_eal_api_IINodeText(long l) {
    }

    public static final native boolean eal_api_IINodeText_setText__SWIG_0(long l, IINodeText iINodeText, long l2, IFont iFont, int n, String string) {
    }

    public static final native boolean eal_api_IINodeText_setText__SWIG_1(long l, IINodeText iINodeText, int n, String string) {
    }

    public static final native boolean eal_api_IINodeText_setText__SWIG_2(long l, IINodeText iINodeText, long l2, ITextLayout iTextLayout, String string) {
    }

    public static final native boolean eal_api_IINodeText_setText__SWIG_3(long l, IINodeText iINodeText, long l2, ITextLayoutResult iTextLayoutResult) {
    }

    public static final native boolean eal_api_IINodeText_setColor__SWIG_0(long l, IINodeText iINodeText, long l2, colorRGBAf colorRGBAf2) {
    }

    public static final native boolean eal_api_IINodeText_setColor__SWIG_1(long l, IINodeText iINodeText, long l2) {
    }

    public static final native long eal_api_IINodeText_getWidth(long l, IINodeText iINodeText) {
    }

    public static final native long eal_api_IINodeText_getHeight(long l, IINodeText iINodeText) {
    }

    public static final native long eal_api_IINodeText_getAscent(long l, IINodeText iINodeText) {
    }

    public static final native long eal_api_IINodeText_getDescent(long l, IINodeText iINodeText) {
    }

    public static final native boolean eal_api_IINodeText_isValid(long l, IINodeText iINodeText) {
    }

    public static final native void eal_api_IINodeText_dispose(long l, IINodeText iINodeText) {
    }

    public static final native boolean eal_api_IINodeText_setFading__SWIG_0(long l, IINodeText iINodeText, float f2, float f3) {
    }

    public static final native boolean eal_api_IINodeText_setFading__SWIG_1(long l, IINodeText iINodeText, float f2, float f3, boolean bl) {
    }

    public static final native void delete_eal_api_INode(long l) {
    }

    public static final native boolean eal_api_INode_clear(long l, INode iNode) {
    }

    public static final native boolean eal_api_INode_remove__SWIG_0(long l, INode iNode, long l2, INode iNode2) {
    }

    public static final native boolean eal_api_INode_remove__SWIG_1(long l, INode iNode, long l2) {
    }

    public static final native long eal_api_INode_getChildCount(long l, INode iNode) {
    }

    public static final native boolean eal_api_INode_hasChild(long l, INode iNode, long l2, INode iNode2) {
    }

    public static final native boolean eal_api_INode_setVisible(long l, INode iNode, boolean bl) {
    }

    public static final native boolean eal_api_INode_isVisible(long l, INode iNode) {
    }

    public static final native boolean eal_api_INode_isValid(long l, INode iNode) {
    }

    public static final native boolean eal_api_INode_isParent(long l, INode iNode) {
    }

    public static final native boolean eal_api_INode_hasProperty(long l, INode iNode, String string) {
    }

    public static final native long eal_api_INode_getProperty__SWIG_0(long l, INode iNode, String string) {
    }

    public static final native long eal_api_INode_getProperty__SWIG_1(long l, INode iNode, String string, int n) {
    }

    public static final native void eal_api_INode_print__SWIG_0(long l, INode iNode) {
    }

    public static final native void eal_api_INode_print__SWIG_1(long l, INode iNode, long l2, FlagPrint flagPrint) {
    }

    public static final native void eal_api_INode_printAllProperties(long l, INode iNode) {
    }

    public static final native boolean eal_api_INode_equals(long l, INode iNode, long l2, IObject iObject) {
    }

    public static final native String eal_api_INode_getName(long l, INode iNode) {
    }

    public static final native boolean eal_api_INode_setName(long l, INode iNode, String string) {
    }

    public static final native boolean eal_api_INode_copyProperty(long l, INode iNode, long l2, INode iNode2, long l3, IProperty iProperty) {
    }

    public static final native boolean eal_api_INode_setOpacity__SWIG_0(long l, INode iNode, float f2, boolean bl) {
    }

    public static final native boolean eal_api_INode_setOpacity__SWIG_1(long l, INode iNode, float f2) {
    }

    public static final native float eal_api_INode_getOpacity(long l, INode iNode) {
    }

    public static final native float eal_api_INode_getOpacityRecursive(long l, INode iNode) {
    }

    public static final native void eal_api_INode_dispose(long l, INode iNode) {
    }

    public static final native boolean eal_api_INode_invalidateObject(long l, INode iNode) {
    }

    public static final native boolean eal_api_INode_invalidateTree(long l, INode iNode) {
    }

    public static final native int eal_api_INode_getType(long l, INode iNode) {
    }

    public static final native long new_eal_api_INode2D__SWIG_0(long l, INode iNode) {
    }

    public static final native long new_eal_api_INode2D__SWIG_1(long l, IProject iProject, String string) {
    }

    public static final native void delete_eal_api_INode2D(long l) {
    }

    public static final native boolean eal_api_INode2D_scale__SWIG_0(long l, INode2D iNode2D, float f2) {
    }

    public static final native boolean eal_api_INode2D_scale__SWIG_1(long l, INode2D iNode2D, float f2, float f3) {
    }

    public static final native boolean eal_api_INode2D_setScale__SWIG_0(long l, INode2D iNode2D, float f2) {
    }

    public static final native boolean eal_api_INode2D_setScale__SWIG_1(long l, INode2D iNode2D, float f2, float f3) {
    }

    public static final native boolean eal_api_INode2D_translate(long l, INode2D iNode2D, float f2, float f3) {
    }

    public static final native boolean eal_api_INode2D_setTranslation(long l, INode2D iNode2D, float f2, float f3) {
    }

    public static final native long eal_api_INode2D_getTranslation(long l, INode2D iNode2D) {
    }

    public static final native boolean eal_api_INode2D_rotate(long l, INode2D iNode2D, float f2) {
    }

    public static final native boolean eal_api_INode2D_setRotation(long l, INode2D iNode2D, float f2) {
    }

    public static final native float eal_api_INode2D_getRotation(long l, INode2D iNode2D) {
    }

    public static final native long eal_api_INode2D_getParent(long l, INode2D iNode2D) {
    }

    public static final native long eal_api_INode2D_getChildAtIndex(long l, INode2D iNode2D, long l2) {
    }

    public static final native long eal_api_INode2D_getChildByIndex(long l, INode2D iNode2D, int n) {
    }

    public static final native long eal_api_INode2D_getChildByName(long l, INode2D iNode2D, String string) {
    }

    public static final native boolean eal_api_INode2D_add__SWIG_0(long l, INode2D iNode2D, long l2, INode2D iNode2D2) {
    }

    public static final native boolean eal_api_INode2D_add__SWIG_1(long l, INode2D iNode2D, long l2, INode2D iNode2D2, long l3) {
    }

    public static final native boolean eal_api_INode2D_addByIndex(long l, INode2D iNode2D, long l2, INode2D iNode2D2, int n) {
    }

    public static final native boolean eal_api_INode2D_resetTransformations(long l, INode2D iNode2D) {
    }

    public static final native boolean eal_api_INode2D_setTransformOrigin(long l, INode2D iNode2D, float f2, float f3) {
    }

    public static final native long eal_api_INode2D_getWidth(long l, INode2D iNode2D) {
    }

    public static final native long eal_api_INode2D_getHeight(long l, INode2D iNode2D) {
    }

    public static final native void eal_api_INode2D_dispose(long l, INode2D iNode2D) {
    }

    public static final native long eal_api_INode2D_enableOffscreen__SWIG_0(long l, INode2D iNode2D, long l2, long l3, long l4, FlagTexture flagTexture) {
    }

    public static final native boolean eal_api_INode2D_enableOffscreen__SWIG_1(long l, INode2D iNode2D, long l2, ITexture iTexture) {
    }

    public static final native boolean eal_api_INode2D_disableOffscreen(long l, INode2D iNode2D) {
    }

    public static final native boolean eal_api_INode2D_setPixelFormat(long l, INode2D iNode2D, int n) {
    }

    public static final native boolean eal_api_INode2D_setPartialRenderingDebug(long l, INode2D iNode2D, boolean bl) {
    }

    public static final native boolean eal_api_INode2D_move(long l, INode2D iNode2D, long l2, INode2D iNode2D2) {
    }

    public static final native long eal_api_INode2D_getTransformation(long l, INode2D iNode2D) {
    }

    public static final native boolean eal_api_INode2D_setTransformation(long l, INode2D iNode2D, long l2, Mat3f mat3f) {
    }

    public static final native long new_eal_api_INode2DHud(long l, IProject iProject, long l2, IFont iFont, int n, float f2, float f3) {
    }

    public static final native void delete_eal_api_INode2DHud(long l) {
    }

    public static final native void eal_api_INode2DHud_dispose(long l, INode2DHud iNode2DHud) {
    }

    public static final native long new_eal_api_INode2DImage__SWIG_0(long l, INode2D iNode2D) {
    }

    public static final native long new_eal_api_INode2DImage__SWIG_1(long l, IProject iProject, String string, boolean bl) {
    }

    public static final native long new_eal_api_INode2DImage__SWIG_2(long l, IProject iProject, String string, long l2, ITexture iTexture) {
    }

    public static final native long new_eal_api_INode2DImage__SWIG_3(long l, IProject iProject, String string, long l2, ITexture iTexture, boolean bl) {
    }

    public static final native void delete_eal_api_INode2DImage(long l) {
    }

    public static final native boolean eal_api_INode2DImage_setModulateColor__SWIG_0(long l, INode2DImage iNode2DImage, long l2, colorRGBAf colorRGBAf2) {
    }

    public static final native boolean eal_api_INode2DImage_setModulateColor__SWIG_1(long l, INode2DImage iNode2DImage, long l2) {
    }

    public static final native boolean eal_api_INode2DImage_setTexture(long l, INode2DImage iNode2DImage, long l2, ITexture iTexture) {
    }

    public static final native long eal_api_INode2DImage_getInterfaceImage(long l, INode2DImage iNode2DImage) {
    }

    public static final native long eal_api_INode2DImage_getWidth(long l, INode2DImage iNode2DImage) {
    }

    public static final native long eal_api_INode2DImage_getHeight(long l, INode2DImage iNode2DImage) {
    }

    public static final native void eal_api_INode2DImage_dispose(long l, INode2DImage iNode2DImage) {
    }

    public static final native boolean eal_api_INode2DImage_clipImage(long l, INode2DImage iNode2DImage, float f2, float f3, float f4, float f5) {
    }

    public static final native long new_eal_api_INode2DLink(long l, IProject iProject, String string) {
    }

    public static final native void delete_eal_api_INode2DLink(long l) {
    }

    public static final native boolean eal_api_INode2DLink_setScene__SWIG_0(long l, INode2DLink iNode2DLink, long l2, INode3DScene iNode3DScene) {
    }

    public static final native boolean eal_api_INode2DLink_setScene__SWIG_1(long l, INode2DLink iNode2DLink, long l2, INode3DScene iNode3DScene, boolean bl) {
    }

    public static final native boolean eal_api_INode2DLink_unsetScene(long l, INode2DLink iNode2DLink) {
    }

    public static final native void eal_api_INode2DLink_dispose(long l, INode2DLink iNode2DLink) {
    }

    public static final native long eal_api_INode2DLink_enablePortal(long l, INode2DLink iNode2DLink, float f2, float f3, float f4, float f5, long l2, FlagTexture flagTexture) {
    }

    public static final native boolean eal_api_INode2DLink_disablePortal(long l, INode2DLink iNode2DLink) {
    }

    public static final native long new_eal_api_INode2DManaged(long l, IProject iProject, String string) {
    }

    public static final native void delete_eal_api_INode2DManaged(long l) {
    }

    public static final native void eal_api_INode2DManaged_dispose(long l, INode2DManaged iNode2DManaged) {
    }

    public static final native boolean eal_api_INode2DManaged_addToScreen__SWIG_0(long l, INode2DManaged iNode2DManaged, long l2, INode2D iNode2D) {
    }

    public static final native boolean eal_api_INode2DManaged_addToScreen__SWIG_1(long l, INode2DManaged iNode2DManaged, long l2, INode2D iNode2D, int n) {
    }

    public static final native boolean eal_api_INode2DManaged_addOffscreen__SWIG_0(long l, INode2DManaged iNode2DManaged, long l2, INode2D iNode2D) {
    }

    public static final native boolean eal_api_INode2DManaged_addOffscreen__SWIG_1(long l, INode2DManaged iNode2DManaged, long l2, INode2D iNode2D, int n) {
    }

    public static final native boolean eal_api_INode2DManaged_addAuto__SWIG_0(long l, INode2DManaged iNode2DManaged, long l2, INode2D iNode2D) {
    }

    public static final native boolean eal_api_INode2DManaged_addAuto__SWIG_1(long l, INode2DManaged iNode2DManaged, long l2, INode2D iNode2D, int n) {
    }

    public static final native long eal_api_INode2DManaged_getFromScreenByName(long l, INode2DManaged iNode2DManaged, String string) {
    }

    public static final native long eal_api_INode2DManaged_getFromOffscreenByName(long l, INode2DManaged iNode2DManaged, String string) {
    }

    public static final native boolean eal_api_INode2DManaged_removeFromScreen(long l, INode2DManaged iNode2DManaged, long l2, INode2D iNode2D) {
    }

    public static final native boolean eal_api_INode2DManaged_setPartialRendering(long l, INode2DManaged iNode2DManaged, boolean bl) {
    }

    public static final native boolean eal_api_INode2DManaged_setHud(long l, INode2DManaged iNode2DManaged, boolean bl, long l2, IFont iFont, int n, float f2, float f3) {
    }

    public static final native boolean eal_api_INode2DManaged_refreshPartialRendering(long l, INode2DManaged iNode2DManaged) {
    }

    public static final native boolean eal_api_INode2DManaged_setPartialRenderingColorBuffer(long l, INode2DManaged iNode2DManaged, boolean bl) {
    }

    public static final native long new_eal_api_INode2DPartial(long l, IProject iProject, String string) {
    }

    public static final native void delete_eal_api_INode2DPartial(long l) {
    }

    public static final native void eal_api_INode2DPartial_dispose(long l, INode2DPartial iNode2DPartial) {
    }

    public static final native long new_eal_api_INode2DText__SWIG_0(long l, INode2D iNode2D) {
    }

    public static final native long new_eal_api_INode2DText__SWIG_1(long l, IProject iProject, String string, long l2, IFont iFont, int n, String string2) {
    }

    public static final native long new_eal_api_INode2DText__SWIG_2(long l, IProject iProject, String string, int n, String string2) {
    }

    public static final native long new_eal_api_INode2DText__SWIG_3(long l, IProject iProject, String string, long l2, ITextLayout iTextLayout, String string2) {
    }

    public static final native long new_eal_api_INode2DText__SWIG_4(long l, IProject iProject, String string, long l2, ITextLayoutResult iTextLayoutResult) {
    }

    public static final native long new_eal_api_INode2DText__SWIG_5(long l, IProject iProject, String string) {
    }

    public static final native void delete_eal_api_INode2DText(long l) {
    }

    public static final native boolean eal_api_INode2DText_setText__SWIG_0(long l, INode2DText iNode2DText, long l2, IFont iFont, int n, String string) {
    }

    public static final native boolean eal_api_INode2DText_setText__SWIG_1(long l, INode2DText iNode2DText, int n, String string) {
    }

    public static final native boolean eal_api_INode2DText_setText__SWIG_2(long l, INode2DText iNode2DText, long l2, ITextLayout iTextLayout, String string) {
    }

    public static final native boolean eal_api_INode2DText_setText__SWIG_3(long l, INode2DText iNode2DText, long l2, ITextLayoutResult iTextLayoutResult) {
    }

    public static final native boolean eal_api_INode2DText_setColor__SWIG_0(long l, INode2DText iNode2DText, long l2, colorRGBAf colorRGBAf2) {
    }

    public static final native boolean eal_api_INode2DText_setColor__SWIG_1(long l, INode2DText iNode2DText, long l2) {
    }

    public static final native long eal_api_INode2DText_getAscent(long l, INode2DText iNode2DText) {
    }

    public static final native long eal_api_INode2DText_getDescent(long l, INode2DText iNode2DText) {
    }

    public static final native long eal_api_INode2DText_getInterfaceText(long l, INode2DText iNode2DText) {
    }

    public static final native void eal_api_INode2DText_dispose(long l, INode2DText iNode2DText) {
    }

    public static final native long eal_api_INode2DText_getWidth(long l, INode2DText iNode2DText) {
    }

    public static final native long eal_api_INode2DText_getHeight(long l, INode2DText iNode2DText) {
    }

    public static final native boolean eal_api_INode2DText_setFading__SWIG_0(long l, INode2DText iNode2DText, float f2, float f3) {
    }

    public static final native boolean eal_api_INode2DText_setFading__SWIG_1(long l, INode2DText iNode2DText, float f2, float f3, boolean bl) {
    }

    public static final native boolean eal_api_INode2DText_setCurvature(long l, INode2DText iNode2DText, long l2, Vec2f vec2f, float f2, boolean bl) {
    }

    public static final native long new_eal_api_INode3D__SWIG_0(long l, INode iNode) {
    }

    public static final native long new_eal_api_INode3D__SWIG_1(long l, IManager iManager, String string) {
    }

    public static final native void delete_eal_api_INode3D(long l) {
    }

    public static final native boolean eal_api_INode3D_scale__SWIG_0(long l, INode3D iNode3D, float f2) {
    }

    public static final native boolean eal_api_INode3D_scale__SWIG_1(long l, INode3D iNode3D, float f2, float f3, float f4) {
    }

    public static final native boolean eal_api_INode3D_setScale__SWIG_0(long l, INode3D iNode3D, float f2) {
    }

    public static final native boolean eal_api_INode3D_setScale__SWIG_1(long l, INode3D iNode3D, float f2, float f3, float f4) {
    }

    public static final native boolean eal_api_INode3D_translate(long l, INode3D iNode3D, float f2, float f3, float f4) {
    }

    public static final native boolean eal_api_INode3D_setTranslation(long l, INode3D iNode3D, float f2, float f3, float f4) {
    }

    public static final native long eal_api_INode3D_getTranslation(long l, INode3D iNode3D) {
    }

    public static final native float eal_api_INode3D_getTranslationX(long l, INode3D iNode3D) {
    }

    public static final native float eal_api_INode3D_getTranslationY(long l, INode3D iNode3D) {
    }

    public static final native float eal_api_INode3D_getTranslationZ(long l, INode3D iNode3D) {
    }

    public static final native boolean eal_api_INode3D_rotate(long l, INode3D iNode3D, float f2, float f3, float f4, float f5) {
    }

    public static final native boolean eal_api_INode3D_rotateX(long l, INode3D iNode3D, float f2) {
    }

    public static final native boolean eal_api_INode3D_rotateY(long l, INode3D iNode3D, float f2) {
    }

    public static final native boolean eal_api_INode3D_rotateZ(long l, INode3D iNode3D, float f2) {
    }

    public static final native boolean eal_api_INode3D_setRotation(long l, INode3D iNode3D, float f2, float f3, float f4, float f5) {
    }

    public static final native boolean eal_api_INode3D_setRotationXYZ(long l, INode3D iNode3D, float f2, float f3, float f4) {
    }

    public static final native boolean eal_api_INode3D_add__SWIG_0(long l, INode3D iNode3D, long l2, INode3D iNode3D2) {
    }

    public static final native boolean eal_api_INode3D_add__SWIG_1(long l, INode3D iNode3D, long l2, INode3D iNode3D2, long l3) {
    }

    public static final native boolean eal_api_INode3D_addByIndex(long l, INode3D iNode3D, long l2, INode3D iNode3D2, int n) {
    }

    public static final native long eal_api_INode3D_getChildByIndex(long l, INode3D iNode3D, int n) {
    }

    public static final native long eal_api_INode3D_getScale(long l, INode3D iNode3D) {
    }

    public static final native float eal_api_INode3D_getScaleX(long l, INode3D iNode3D) {
    }

    public static final native float eal_api_INode3D_getScaleY(long l, INode3D iNode3D) {
    }

    public static final native float eal_api_INode3D_getScaleZ(long l, INode3D iNode3D) {
    }

    public static final native long eal_api_INode3D_getTransformation(long l, INode3D iNode3D) {
    }

    public static final native boolean eal_api_INode3D_setTransformation(long l, INode3D iNode3D, long l2, Mat4f mat4f) {
    }

    public static final native long eal_api_INode3D_getParent(long l, INode3D iNode3D) {
    }

    public static final native long eal_api_INode3D_getChildAtIndex(long l, INode3D iNode3D, long l2) {
    }

    public static final native long eal_api_INode3D_getChildByName(long l, INode3D iNode3D, String string) {
    }

    public static final native boolean eal_api_INode3D_clip(long l, INode3D iNode3D, float f2, float f3, float f4, float f5) {
    }

    public static final native boolean eal_api_INode3D_disableClip(long l, INode3D iNode3D) {
    }

    public static final native boolean eal_api_INode3D_setDepthTest(long l, INode3D iNode3D, boolean bl) {
    }

    public static final native boolean eal_api_INode3D_resetTransformations(long l, INode3D iNode3D) {
    }

    public static final native void eal_api_INode3D_dispose(long l, INode3D iNode3D) {
    }

    public static final native boolean eal_api_INode3D_move(long l, INode3D iNode3D, long l2, INode3D iNode3D2) {
    }

    public static final native long new_eal_api_INode3DCamera__SWIG_0(long l, IManager iManager, String string) {
    }

    public static final native long new_eal_api_INode3DCamera__SWIG_1(long l, INode3D iNode3D) {
    }

    public static final native void delete_eal_api_INode3DCamera(long l) {
    }

    public static final native float eal_api_INode3DCamera_getFar(long l, INode3DCamera iNode3DCamera) {
    }

    public static final native float eal_api_INode3DCamera_getNear(long l, INode3DCamera iNode3DCamera) {
    }

    public static final native float eal_api_INode3DCamera_getFov(long l, INode3DCamera iNode3DCamera) {
    }

    public static final native float eal_api_INode3DCamera_getPlaneHeight(long l, INode3DCamera iNode3DCamera) {
    }

    public static final native boolean eal_api_INode3DCamera_lookAt(long l, INode3DCamera iNode3DCamera, long l2, Vec3f vec3f, long l3, Vec3f vec3f2, long l4, Vec3f vec3f3) {
    }

    public static final native boolean eal_api_INode3DCamera_setAspectRatio(long l, INode3DCamera iNode3DCamera, float f2) {
    }

    public static final native boolean eal_api_INode3DCamera_setPerspective__SWIG_0(long l, INode3DCamera iNode3DCamera, float f2, float f3, float f4) {
    }

    public static final native boolean eal_api_INode3DCamera_setPerspective__SWIG_1(long l, INode3DCamera iNode3DCamera, float f2, float f3, float f4, int n) {
    }

    public static final native boolean eal_api_INode3DCamera_setOrthogonal(long l, INode3DCamera iNode3DCamera, float f2, float f3, float f4) {
    }

    public static final native int eal_api_INode3DCamera_getFovType(long l, INode3DCamera iNode3DCamera) {
    }

    public static final native void eal_api_INode3DCamera_dispose(long l, INode3DCamera iNode3DCamera) {
    }

    public static final native boolean eal_api_INode3DCamera_interpolate(long l, INode3DCamera iNode3DCamera, long l2, INode3DCamera iNode3DCamera2, long l3, INode3DCamera iNode3DCamera3, float f2) {
    }

    public static final native long new_eal_api_INode3DImage__SWIG_0(long l, INode3D iNode3D) {
    }

    public static final native long new_eal_api_INode3DImage__SWIG_1(long l, IProject iProject, String string) {
    }

    public static final native long new_eal_api_INode3DImage__SWIG_2(long l, IProject iProject, String string, long l2, ITexture iTexture) {
    }

    public static final native void delete_eal_api_INode3DImage(long l) {
    }

    public static final native boolean eal_api_INode3DImage_setTexture(long l, INode3DImage iNode3DImage, long l2, ITexture iTexture) {
    }

    public static final native long eal_api_INode3DImage_getWidth(long l, INode3DImage iNode3DImage) {
    }

    public static final native long eal_api_INode3DImage_getHeight(long l, INode3DImage iNode3DImage) {
    }

    public static final native long eal_api_INode3DImage_getInterfaceImage(long l, INode3DImage iNode3DImage) {
    }

    public static final native void eal_api_INode3DImage_dispose(long l, INode3DImage iNode3DImage) {
    }

    public static final native boolean eal_api_INode3DImage_setModulateColor__SWIG_0(long l, INode3DImage iNode3DImage, long l2, colorRGBAf colorRGBAf2) {
    }

    public static final native boolean eal_api_INode3DImage_setModulateColor__SWIG_1(long l, INode3DImage iNode3DImage, long l2) {
    }

    public static final native boolean eal_api_INode3DImage_setMaterial(long l, INode3DImage iNode3DImage, long l2, IMaterial iMaterial) {
    }

    public static final native boolean eal_api_INode3DImage_flipX(long l, INode3DImage iNode3DImage) {
    }

    public static final native boolean eal_api_INode3DImage_flipY(long l, INode3DImage iNode3DImage) {
    }

    public static final native boolean eal_api_INode3DImage_flipXY(long l, INode3DImage iNode3DImage) {
    }

    public static final native boolean eal_api_INode3DImage_clipImage(long l, INode3DImage iNode3DImage, float f2, float f3, float f4, float f5) {
    }

    public static final native void delete_eal_api_INode3DMesh(long l) {
    }

    public static final native long eal_api_INode3DMesh_getData(long l, INode3DMesh iNode3DMesh) {
    }

    public static final native boolean eal_api_INode3DMesh_setData(long l, INode3DMesh iNode3DMesh, long l2, IMeshData iMeshData) {
    }

    public static final native void eal_api_INode3DMesh_dispose(long l, INode3DMesh iNode3DMesh) {
    }

    public static final native long new_eal_api_INode3DQuickDraw__SWIG_0(long l, IProject iProject, String string, long l2, long l3) {
    }

    public static final native long new_eal_api_INode3DQuickDraw__SWIG_1(long l, IProject iProject, String string, long l2, long l3, boolean bl) {
    }

    public static final native long new_eal_api_INode3DQuickDraw__SWIG_2(long l, IProject iProject, String string, long l2, long l3, boolean bl, boolean bl2) {
    }

    public static final native long new_eal_api_INode3DQuickDraw__SWIG_3(long l, IProject iProject, String string, long l2, long l3, boolean bl, boolean bl2, int n) {
    }

    public static final native long new_eal_api_INode3DQuickDraw__SWIG_4(long l, IProject iProject, String string, long l2, long l3, boolean bl, boolean bl2, int n, boolean bl3) {
    }

    public static final native void delete_eal_api_INode3DQuickDraw(long l) {
    }

    public static final native void eal_api_INode3DQuickDraw_dispose(long l, INode3DQuickDraw iNode3DQuickDraw) {
    }

    public static final native boolean eal_api_INode3DQuickDraw_add(long l, INode3DQuickDraw iNode3DQuickDraw, long l2, Vec2f vec2f) {
    }

    public static final native boolean eal_api_INode3DQuickDraw_addSeparator(long l, INode3DQuickDraw iNode3DQuickDraw) {
    }

    public static final native boolean eal_api_INode3DQuickDraw_clearArea(long l, INode3DQuickDraw iNode3DQuickDraw) {
    }

    public static final native boolean eal_api_INode3DQuickDraw_setLineWidth(long l, INode3DQuickDraw iNode3DQuickDraw, float f2) {
    }

    public static final native boolean eal_api_INode3DQuickDraw_setColor__SWIG_0(long l, INode3DQuickDraw iNode3DQuickDraw, long l2) {
    }

    public static final native boolean eal_api_INode3DQuickDraw_setColor__SWIG_1(long l, INode3DQuickDraw iNode3DQuickDraw, long l2, colorRGBAf colorRGBAf2) {
    }

    public static final native boolean eal_api_INode3DQuickDraw_setPathTranslation(long l, INode3DQuickDraw iNode3DQuickDraw, float f2, float f3) {
    }

    public static final native boolean eal_api_INode3DQuickDraw_setPathScaling__SWIG_0(long l, INode3DQuickDraw iNode3DQuickDraw, float f2, float f3) {
    }

    public static final native boolean eal_api_INode3DQuickDraw_setPathScaling__SWIG_1(long l, INode3DQuickDraw iNode3DQuickDraw, float f2, float f3, boolean bl) {
    }

    public static final native boolean eal_api_INode3DQuickDraw_setPathRotation(long l, INode3DQuickDraw iNode3DQuickDraw, float f2) {
    }

    public static final native boolean eal_api_INode3DQuickDraw_setDebugBoundingVolume(long l, INode3DQuickDraw iNode3DQuickDraw, boolean bl) {
    }

    public static final native boolean eal_api_INode3DQuickDraw_setPathPivot(long l, INode3DQuickDraw iNode3DQuickDraw, float f2, float f3) {
    }

    public static final native long new_eal_api_INode3DScene(long l, IManager iManager, String string) {
    }

    public static final native void delete_eal_api_INode3DScene(long l) {
    }

    public static final native boolean eal_api_INode3DScene_add__SWIG_0(long l, INode3DScene iNode3DScene, long l2, INode3D iNode3D) {
    }

    public static final native boolean eal_api_INode3DScene_add__SWIG_1(long l, INode3DScene iNode3DScene, long l2, INode3DCamera iNode3DCamera) {
    }

    public static final native boolean eal_api_INode3DScene_add__SWIG_2(long l, INode3DScene iNode3DScene, long l2, INode3D iNode3D, long l3) {
    }

    public static final native boolean eal_api_INode3DScene_add__SWIG_3(long l, INode3DScene iNode3DScene, long l2, INode3DCamera iNode3DCamera, long l3) {
    }

    public static final native boolean eal_api_INode3DScene_addByIndex__SWIG_0(long l, INode3DScene iNode3DScene, long l2, INode3D iNode3D, int n) {
    }

    public static final native boolean eal_api_INode3DScene_addByIndex__SWIG_1(long l, INode3DScene iNode3DScene, long l2, INode3DCamera iNode3DCamera, int n) {
    }

    public static final native void eal_api_INode3DScene_dispose(long l, INode3DScene iNode3DScene) {
    }

    public static final native boolean eal_api_INode3DScene_setDefaultCamera(long l, INode3DScene iNode3DScene, long l2, INode3DCamera iNode3DCamera) {
    }

    public static final native boolean eal_api_INode3DScene_setColorClear(long l, INode3DScene iNode3DScene, boolean bl) {
    }

    public static final native boolean eal_api_INode3DScene_setClearColor(long l, INode3DScene iNode3DScene, long l2, colorRGBAf colorRGBAf2) {
    }

    public static final native boolean eal_api_INode3DScene_setDepthTest(long l, INode3DScene iNode3DScene, boolean bl) {
    }

    public static final native boolean eal_api_INode3DScene_setAnimationPlayer(long l, INode3DScene iNode3DScene, boolean bl) {
    }

    public static final native long new_eal_api_INode3DText__SWIG_0(long l, INode3D iNode3D) {
    }

    public static final native long new_eal_api_INode3DText__SWIG_1(long l, IProject iProject, String string, long l2, IFont iFont, int n, String string2) {
    }

    public static final native long new_eal_api_INode3DText__SWIG_2(long l, IProject iProject, String string, int n, String string2) {
    }

    public static final native long new_eal_api_INode3DText__SWIG_3(long l, IProject iProject, String string, long l2, ITextLayout iTextLayout, String string2) {
    }

    public static final native long new_eal_api_INode3DText__SWIG_4(long l, IProject iProject, String string, long l2, ITextLayoutResult iTextLayoutResult) {
    }

    public static final native long new_eal_api_INode3DText__SWIG_5(long l, IProject iProject, String string) {
    }

    public static final native void delete_eal_api_INode3DText(long l) {
    }

    public static final native long eal_api_INode3DText_getColor(long l, INode3DText iNode3DText) {
    }

    public static final native long eal_api_INode3DText_getHeight(long l, INode3DText iNode3DText) {
    }

    public static final native long eal_api_INode3DText_getWidth(long l, INode3DText iNode3DText) {
    }

    public static final native boolean eal_api_INode3DText_setColor__SWIG_0(long l, INode3DText iNode3DText, long l2) {
    }

    public static final native boolean eal_api_INode3DText_setColor__SWIG_1(long l, INode3DText iNode3DText, long l2, colorRGBAf colorRGBAf2) {
    }

    public static final native boolean eal_api_INode3DText_setText__SWIG_0(long l, INode3DText iNode3DText, long l2, IFont iFont, int n, String string) {
    }

    public static final native boolean eal_api_INode3DText_setText__SWIG_1(long l, INode3DText iNode3DText, int n, String string) {
    }

    public static final native boolean eal_api_INode3DText_setText__SWIG_2(long l, INode3DText iNode3DText, long l2, ITextLayout iTextLayout, String string) {
    }

    public static final native boolean eal_api_INode3DText_setText__SWIG_3(long l, INode3DText iNode3DText, long l2, ITextLayoutResult iTextLayoutResult) {
    }

    public static final native long eal_api_INode3DText_getInterfaceText(long l, INode3DText iNode3DText) {
    }

    public static final native void eal_api_INode3DText_dispose(long l, INode3DText iNode3DText) {
    }

    public static final native long eal_api_INode3DText_getAscent(long l, INode3DText iNode3DText) {
    }

    public static final native long eal_api_INode3DText_getDescent(long l, INode3DText iNode3DText) {
    }

    public static final native boolean eal_api_INode3DText_setModulateColor(long l, INode3DText iNode3DText, long l2, colorRGBAf colorRGBAf2) {
    }

    public static final native boolean eal_api_INode3DText_setFading__SWIG_0(long l, INode3DText iNode3DText, float f2, float f3) {
    }

    public static final native boolean eal_api_INode3DText_setFading__SWIG_1(long l, INode3DText iNode3DText, float f2, float f3, boolean bl) {
    }

    public static final native boolean eal_api_INode3DText_setCurvature(long l, INode3DText iNode3DText, long l2, Vec2f vec2f, float f2, boolean bl) {
    }

    public static final native void delete_eal_api_ITemplateNode2D(long l) {
    }

    public static final native boolean eal_api_ITemplateNode2D_isValid(long l, ITemplateNode2D iTemplateNode2D) {
    }

    public static final native void eal_api_ITemplateNode2D_dispose(long l, ITemplateNode2D iTemplateNode2D) {
    }

    public static final native long eal_api_ITemplateNode2D_getRoot(long l, ITemplateNode2D iTemplateNode2D) {
    }

    public static final native long eal_api_ITemplateNode2D_instantiate(long l, ITemplateNode2D iTemplateNode2D, long l2, IProject iProject, String string) {
    }

    public static final native void delete_eal_api_ITemplateNode3D(long l) {
    }

    public static final native boolean eal_api_ITemplateNode3D_isValid(long l, ITemplateNode3D iTemplateNode3D) {
    }

    public static final native void eal_api_ITemplateNode3D_dispose(long l, ITemplateNode3D iTemplateNode3D) {
    }

    public static final native long eal_api_ITemplateNode3D_getRoot(long l, ITemplateNode3D iTemplateNode3D) {
    }

    public static final native long eal_api_ITemplateNode3D_instantiate(long l, ITemplateNode3D iTemplateNode3D, long l2, IProject iProject, String string) {
    }

    public static final native long new_eal_api_IFont(long l, IManager iManager, String string) {
    }

    public static final native void delete_eal_api_IFont(long l) {
    }

    public static final native String eal_api_IFont_getName(long l, IFont iFont) {
    }

    public static final native int eal_api_IFont_getAscent(long l, IFont iFont, long l2) {
    }

    public static final native int eal_api_IFont_getDescent(long l, IFont iFont, long l2) {
    }

    public static final native int eal_api_IFont_getMaximumHeight(long l, IFont iFont, long l2) {
    }

    public static final native boolean eal_api_IFont_isValid(long l, IFont iFont) {
    }

    public static final native void eal_api_IFont_dispose(long l, IFont iFont) {
    }

    public static final native boolean eal_api_IFont_destroy(long l, IFont iFont, long l2, IManager iManager) {
    }

    public static final native void eal_api_IFont_copy(long l, IFont iFont, long l2, IFont iFont2) {
    }

    public static final native boolean eal_api_IFont_overwriteNotDefGlyph(long l, IFont iFont, long l2) {
    }

    public static final native long new_eal_api_IFontList() {
    }

    public static final native void delete_eal_api_IFontList(long l) {
    }

    public static final native void eal_api_IFontList_add(long l, IFontList iFontList, String string) {
    }

    public static final native void delete_eal_api_IFontGroupFontHandle(long l) {
    }

    public static final native boolean eal_api_IFontGroupFontHandle_isValid(long l, IFontGroupFontHandle iFontGroupFontHandle) {
    }

    public static final native void eal_api_IFontGroupFontHandle_dispose(long l, IFontGroupFontHandle iFontGroupFontHandle) {
    }

    public static final native long new_eal_api_IFontGroup__SWIG_0(long l, IManager iManager) {
    }

    public static final native long new_eal_api_IFontGroup__SWIG_1(long l, IManager iManager, int n) {
    }

    public static final native long new_eal_api_IFontGroup__SWIG_2(long l, IManager iManager, long l2, IFontList iFontList, String string, short s) {
    }

    public static final native long new_eal_api_IFontGroup__SWIG_3(long l, IManager iManager, long l2, IFontList iFontList, String string, short s, int n) {
    }

    public static final native void delete_eal_api_IFontGroup(long l) {
    }

    public static final native void eal_api_IFontGroup_dispose(long l, IFontGroup iFontGroup) {
    }

    public static final native boolean eal_api_IFontGroup_isValid(long l, IFontGroup iFontGroup) {
    }

    public static final native boolean eal_api_IFontGroup_destroy(long l, IFontGroup iFontGroup) {
    }

    public static final native long eal_api_IFontGroup_addFont__SWIG_0(long l, IFontGroup iFontGroup, String string) {
    }

    public static final native long eal_api_IFontGroup_addFont__SWIG_1(long l, IFontGroup iFontGroup, String string, long l2) {
    }

    public static final native boolean eal_api_IFontGroup_addUnicodeRange(long l, IFontGroup iFontGroup, long l2, long l3, long l4) {
    }

    public static final native boolean eal_api_IFontGroup_linkUnicodeRanges(long l, IFontGroup iFontGroup, String string) {
    }

    public static final native boolean eal_api_IFontGroup_linkDefaultFont(long l, IFontGroup iFontGroup, long l2, IFontGroupFontHandle iFontGroupFontHandle) {
    }

    public static final native boolean eal_api_IFontGroup_activate(long l, IFontGroup iFontGroup) {
    }

    public static final native boolean eal_api_IFontGroup_overwriteNotDefGlyph(long l, IFontGroup iFontGroup, long l2) {
    }

    public static final native int eal_api_IFontGroup_getAscent(long l, IFontGroup iFontGroup, long l2) {
    }

    public static final native int eal_api_IFontGroup_getDescent(long l, IFontGroup iFontGroup, long l2) {
    }

    public static final native boolean eal_api_IFontGroup_setSize(long l, IFontGroup iFontGroup, long l2) {
    }

    public static final native void delete_eal_api_IFontGroupAsync(long l) {
    }

    public static final native boolean eal_api_IFontGroupAsync_addFont(long l, IFontGroupAsync iFontGroupAsync, String string) {
    }

    public static final native boolean eal_api_IFontGroupAsync_linkUnicodeRanges(long l, IFontGroupAsync iFontGroupAsync, String string) {
    }

    public static final native long eal_api_IFontGroupAsync_takeOwnership(long l, IFontGroupAsync iFontGroupAsync, long l2, IManager iManager) {
    }

    public static final native int eal_api_ITextLayoutSection_STYLE_REGULAR_get() {
    }

    public static final native int eal_api_ITextLayoutSection_STYLE_BOLD_get() {
    }

    public static final native int eal_api_ITextLayoutSection_STYLE_ITALIC_get() {
    }

    public static final native int eal_api_ITextLayoutSection_STYLE_BOLD_ITALIC_get() {
    }

    public static final native int eal_api_ITextLayoutSection_STYLE_UNDERLINE_get() {
    }

    public static final native int eal_api_ITextLayoutSection_STYLE_OVERLINE_get() {
    }

    public static final native int eal_api_ITextLayoutSection_STYLE_STRIKEOUT_get() {
    }

    public static final native int eal_api_ITextLayoutSection_HINTING_OFF_get() {
    }

    public static final native void delete_eal_api_ITextLayoutSection(long l) {
    }

    public static final native boolean eal_api_ITextLayoutSection_isValid(long l, ITextLayoutSection iTextLayoutSection) {
    }

    public static final native boolean eal_api_ITextLayoutSection_setBasic__SWIG_0(long l, ITextLayoutSection iTextLayoutSection, long l2, IFont iFont, int n) {
    }

    public static final native boolean eal_api_ITextLayoutSection_setBasic__SWIG_1(long l, ITextLayoutSection iTextLayoutSection, long l2, IFont iFont, int n, long l3) {
    }

    public static final native boolean eal_api_ITextLayoutSection_setBasicFontGroup(long l, ITextLayoutSection iTextLayoutSection, int n, long l2) {
    }

    public static final native boolean eal_api_ITextLayoutSection_setAlignment(long l, ITextLayoutSection iTextLayoutSection, int n) {
    }

    public static final native boolean eal_api_ITextLayoutSection_setStartEndIndex(long l, ITextLayoutSection iTextLayoutSection, long l2, long l3) {
    }

    public static final native boolean eal_api_ITextLayoutSection_setLineGap(long l, ITextLayoutSection iTextLayoutSection, int n) {
    }

    public static final native boolean eal_api_ITextLayoutSection_setFont__SWIG_0(long l, ITextLayoutSection iTextLayoutSection, long l2, IFont iFont, int n, long l3, FlagFontStyle flagFontStyle) {
    }

    public static final native boolean eal_api_ITextLayoutSection_setFont__SWIG_1(long l, ITextLayoutSection iTextLayoutSection, long l2, IFont iFont, int n) {
    }

    public static final native boolean eal_api_ITextLayoutSection_setLineExtender(long l, ITextLayoutSection iTextLayoutSection, int n) {
    }

    public static final native void eal_api_ITextLayoutSection_dispose(long l, ITextLayoutSection iTextLayoutSection) {
    }

    public static final native boolean eal_api_ITextLayoutSection_setColor__SWIG_0(long l, ITextLayoutSection iTextLayoutSection, long l2, colorRGBAf colorRGBAf2) {
    }

    public static final native boolean eal_api_ITextLayoutSection_setColor__SWIG_1(long l, ITextLayoutSection iTextLayoutSection, int n) {
    }

    public static final native boolean eal_api_ITextLayoutSection_setStyle(long l, ITextLayoutSection iTextLayoutSection, long l2, FlagFontStyle flagFontStyle) {
    }

    public static final native boolean eal_api_ITextLayoutSection_setHinting(long l, ITextLayoutSection iTextLayoutSection, int n) {
    }

    public static final native long new_eal_FlagFontStyle__SWIG_0() {
    }

    public static final native long new_eal_FlagFontStyle__SWIG_1(int n) {
    }

    public static final native long new_eal_FlagFontStyle__SWIG_2(long l) {
    }

    public static final native long eal_FlagFontStyle_getFlagValue(long l, FlagFontStyle flagFontStyle) {
    }

    public static final native void eal_FlagFontStyle_setFlag(long l, FlagFontStyle flagFontStyle, int n) {
    }

    public static final native boolean eal_FlagFontStyle_isFlag(long l, FlagFontStyle flagFontStyle, int n) {
    }

    public static final native void eal_FlagFontStyle_reset(long l, FlagFontStyle flagFontStyle) {
    }

    public static final native void eal_FlagFontStyle_resetPos(long l, FlagFontStyle flagFontStyle, long l2) {
    }

    public static final native void eal_FlagFontStyle_unsetFlag(long l, FlagFontStyle flagFontStyle, int n) {
    }

    public static final native void eal_FlagFontStyle_setFlagValue(long l, FlagFontStyle flagFontStyle, long l2) {
    }

    public static final native long eal_FlagFontStyle_getHexValueAtPos(long l, FlagFontStyle flagFontStyle, long l2) {
    }

    public static final native long eal_FlagFontStyle_extractPosition(long l, FlagFontStyle flagFontStyle, long l2) {
    }

    public static final native long eal_FlagFontStyle_getByMask(long l, FlagFontStyle flagFontStyle, long l2) {
    }

    public static final native boolean eal_FlagFontStyle_equal__SWIG_0(long l, FlagFontStyle flagFontStyle, long l2) {
    }

    public static final native boolean eal_FlagFontStyle_equal__SWIG_1(long l, FlagFontStyle flagFontStyle, int n) {
    }

    public static final native boolean eal_FlagFontStyle_unequal__SWIG_0(long l, FlagFontStyle flagFontStyle, long l2) {
    }

    public static final native boolean eal_FlagFontStyle_unequal__SWIG_1(long l, FlagFontStyle flagFontStyle, int n) {
    }

    public static final native boolean eal_FlagFontStyle_contains__SWIG_0(long l, FlagFontStyle flagFontStyle, int n) {
    }

    public static final native boolean eal_FlagFontStyle_contains__SWIG_1(long l, FlagFontStyle flagFontStyle, long l2, FlagFontStyle flagFontStyle2) {
    }

    public static final native void delete_eal_FlagFontStyle(long l) {
    }

    public static final native long new_eal_api_ITextLayout__SWIG_0() {
    }

    public static final native long new_eal_api_ITextLayout__SWIG_1(long l, IFont iFont, int n) {
    }

    public static final native long new_eal_api_ITextLayout__SWIG_2(int n) {
    }

    public static final native void delete_eal_api_ITextLayout(long l) {
    }

    public static final native boolean eal_api_ITextLayout_isValid(long l, ITextLayout iTextLayout) {
    }

    public static final native void eal_api_ITextLayout_setTruncation(long l, ITextLayout iTextLayout, boolean bl) {
    }

    public static final native void eal_api_ITextLayout_setMaximumSize(long l, ITextLayout iTextLayout, long l2, long l3) {
    }

    public static final native void eal_api_ITextLayout_setMaximumLineCount(long l, ITextLayout iTextLayout, long l2) {
    }

    public static final native boolean eal_api_ITextLayout_setTextLayoutSectionNum(long l, ITextLayout iTextLayout, long l2) {
    }

    public static final native long eal_api_ITextLayout_getLayoutSection(long l, ITextLayout iTextLayout, long l2) {
    }

    public static final native void eal_api_ITextLayout_print(long l, ITextLayout iTextLayout) {
    }

    public static final native boolean eal_api_ITextLayout_destroy(long l, ITextLayout iTextLayout) {
    }

    public static final native void eal_api_ITextLayout_dispose(long l, ITextLayout iTextLayout) {
    }

    public static final native boolean eal_api_ITextLayout_setPreformattedText(long l, ITextLayout iTextLayout, boolean bl) {
    }

    public static final native boolean eal_api_ITextLayout_setKerning(long l, ITextLayout iTextLayout, int n) {
    }

    public static final native void delete_eal_api_ITextLayoutResult(long l) {
    }

    public static final native boolean eal_api_ITextLayoutResult_isValid(long l, ITextLayoutResult iTextLayoutResult) {
    }

    public static final native long eal_api_ITextLayoutResult_getWidth(long l, ITextLayoutResult iTextLayoutResult) {
    }

    public static final native long eal_api_ITextLayoutResult_getHeight(long l, ITextLayoutResult iTextLayoutResult) {
    }

    public static final native long eal_api_ITextLayoutResult_getLineWidth(long l, ITextLayoutResult iTextLayoutResult, long l2) {
    }

    public static final native long eal_api_ITextLayoutResult_getLineHeight(long l, ITextLayoutResult iTextLayoutResult, long l2) {
    }

    public static final native long eal_api_ITextLayoutResult_getAscent(long l, ITextLayoutResult iTextLayoutResult, long l2) {
    }

    public static final native long eal_api_ITextLayoutResult_getDescent(long l, ITextLayoutResult iTextLayoutResult, long l2) {
    }

    public static final native long eal_api_ITextLayoutResult_getLineLeft(long l, ITextLayoutResult iTextLayoutResult, long l2) {
    }

    public static final native boolean eal_api_ITextLayoutResult_destroy(long l, ITextLayoutResult iTextLayoutResult) {
    }

    public static final native long eal_api_ITextLayoutResult_getLineCount(long l, ITextLayoutResult iTextLayoutResult) {
    }

    public static final native void eal_api_ITextLayoutResult_dispose(long l, ITextLayoutResult iTextLayoutResult) {
    }

    public static final native long eal_api_ITextLayoutResult_getGlyphCount__SWIG_0(long l, ITextLayoutResult iTextLayoutResult) {
    }

    public static final native long eal_api_ITextLayoutResult_getGlyphCount__SWIG_1(long l, ITextLayoutResult iTextLayoutResult, long l2) {
    }

    public static final native long eal_api_ITextLayoutResult_getLastGlyphOfLine(long l, ITextLayoutResult iTextLayoutResult, long l2) {
    }

    public static final native long eal_api_ITextLayoutResult_getGlyphOfLine(long l, ITextLayoutResult iTextLayoutResult, long l2, long l3) {
    }

    public static final native boolean eal_api_ITextLayoutResult_isTruncated(long l, ITextLayoutResult iTextLayoutResult) {
    }

    public static final native int eal_api_ITextLayoutResult_getCursorPosition(long l, ITextLayoutResult iTextLayoutResult, long l2, long l3) {
    }

    public static final native long getINodeByPath(long l, IProject iProject, String string) {
    }

    public static final native boolean setVisible(long l, IProject iProject, String string, boolean bl) {
    }

    public static final native boolean setTexture(long l, IProject iProject, String string, String string2) {
    }

    public static final native boolean createPixelPerfect(long l, INode3DCamera iNode3DCamera, long l2, long l3) {
    }

    public static final native long RGBAtoRGBAf(long l) {
    }

    public static final native long ARGBtoRGBAf(long l) {
    }

    public static final native long toRGBAUint32(long l, colorRGBAf colorRGBAf2) {
    }

    public static final native long toARGBUint32(long l, colorRGBAf colorRGBAf2) {
    }

    public static final native long new_eal_utility_CFrameInformation(long l, IRenderer iRenderer) {
    }

    public static final native void delete_eal_utility_CFrameInformation(long l) {
    }

    public static final native void eal_utility_CFrameInformation_dispose(long l, CFrameInformation cFrameInformation) {
    }

    public static final native long eal_utility_CFrameInformation_getFPS(long l, CFrameInformation cFrameInformation) {
    }

    public static final native int eal_utility_IImageStorageListener_IDENT_NONE_get() {
    }

    public static final native long new_eal_utility_IImageStorageListener() {
    }

    public static final native void delete_eal_utility_IImageStorageListener(long l) {
    }

    public static final native void eal_utility_IImageStorageListener_process(long l, IImageStorageListener iImageStorageListener, int n, long l2) {
    }

    public static final native void eal_utility_IImageStorageListener_processSwigExplicitIImageStorageListener(long l, IImageStorageListener iImageStorageListener, int n, long l2) {
    }

    public static final native void eal_utility_IImageStorageListener_director_connect(IImageStorageListener iImageStorageListener, long l, boolean bl, boolean bl2) {
    }

    public static final native void eal_utility_IImageStorageListener_change_ownership(IImageStorageListener iImageStorageListener, long l, boolean bl) {
    }

    public static final native long new_eal_utility_CImageStorage(long l, IManager iManager, long l2, IImageStorageListener iImageStorageListener) {
    }

    public static final native void delete_eal_utility_CImageStorage(long l) {
    }

    public static final native boolean eal_utility_CImageStorage_add__SWIG_0(long l, CImageStorage cImageStorage, long l2, String string, long l3, FlagImage flagImage) {
    }

    public static final native boolean eal_utility_CImageStorage_add__SWIG_1(long l, CImageStorage cImageStorage, long l2, String string, long l3, FlagImage flagImage, long l4, long l5) {
    }

    public static final native long eal_utility_CImageStorage_get(long l, CImageStorage cImageStorage, long l2) {
    }

    public static final native boolean eal_utility_CImageStorage_flush(long l, CImageStorage cImageStorage) {
    }

    public static final native boolean eal_utility_CImageStorage_clear(long l, CImageStorage cImageStorage) {
    }

    public static final native boolean eal_utility_CImageStorage_destroy(long l, CImageStorage cImageStorage) {
    }

    public static final native boolean eal_utility_CImageStorage_remove(long l, CImageStorage cImageStorage, long l2) {
    }

    public static final native long new_eal_utility_CInterpolatorAccelerated__SWIG_0() {
    }

    public static final native long new_eal_utility_CInterpolatorAccelerated__SWIG_1(float f2, float f3, float f4, float f5, float f6, float f7) {
    }

    public static final native void delete_eal_utility_CInterpolatorAccelerated(long l) {
    }

    public static final native float eal_utility_CInterpolatorAccelerated_evaluate(long l, CInterpolatorAccelerated cInterpolatorAccelerated) {
    }

    public static final native boolean eal_utility_CInterpolatorAccelerated_isFinished(long l, CInterpolatorAccelerated cInterpolatorAccelerated) {
    }

    public static final native void eal_utility_CInterpolatorAccelerated_start(long l, CInterpolatorAccelerated cInterpolatorAccelerated) {
    }

    public static final native void eal_utility_CInterpolatorAccelerated_setStart(long l, CInterpolatorAccelerated cInterpolatorAccelerated, float f2) {
    }

    public static final native void eal_utility_CInterpolatorAccelerated_setEnd(long l, CInterpolatorAccelerated cInterpolatorAccelerated, float f2) {
    }

    public static final native float eal_utility_CInterpolatorAccelerated_getStart(long l, CInterpolatorAccelerated cInterpolatorAccelerated) {
    }

    public static final native float eal_utility_CInterpolatorAccelerated_getEnd(long l, CInterpolatorAccelerated cInterpolatorAccelerated) {
    }

    public static final native float eal_utility_CInterpolatorAccelerated_getLowerBound(long l, CInterpolatorAccelerated cInterpolatorAccelerated) {
    }

    public static final native float eal_utility_CInterpolatorAccelerated_getUpperBound(long l, CInterpolatorAccelerated cInterpolatorAccelerated) {
    }

    public static final native void eal_utility_CInterpolatorAccelerated_setLowerBound(long l, CInterpolatorAccelerated cInterpolatorAccelerated, float f2) {
    }

    public static final native void eal_utility_CInterpolatorAccelerated_setUpperBound(long l, CInterpolatorAccelerated cInterpolatorAccelerated, float f2) {
    }

    public static final native void eal_utility_CInterpolatorAccelerated_setAccelerationMax(long l, CInterpolatorAccelerated cInterpolatorAccelerated, float f2) {
    }

    public static final native void eal_utility_CInterpolatorAccelerated_setSpeedMax(long l, CInterpolatorAccelerated cInterpolatorAccelerated, float f2) {
    }

    public static final native float eal_utility_CInterpolatorAccelerated_getAccelerationMax(long l, CInterpolatorAccelerated cInterpolatorAccelerated) {
    }

    public static final native float eal_utility_CInterpolatorAccelerated_getSpeedMax(long l, CInterpolatorAccelerated cInterpolatorAccelerated) {
    }

    public static final native long new_eal_utility_CLerpF__SWIG_0() {
    }

    public static final native long new_eal_utility_CLerpF__SWIG_1(float f2, float f3, long l) {
    }

    public static final native void delete_eal_utility_CLerpF(long l) {
    }

    public static final native void eal_utility_CLerpF_start(long l, CLerpF cLerpF) {
    }

    public static final native float eal_utility_CLerpF_evaluate(long l, CLerpF cLerpF) {
    }

    public static final native boolean eal_utility_CLerpF_isFinished(long l, CLerpF cLerpF) {
    }

    public static final native void eal_utility_CLerpF_setStart(long l, CLerpF cLerpF, float f2) {
    }

    public static final native void eal_utility_CLerpF_setEnd(long l, CLerpF cLerpF, float f2) {
    }

    public static final native void eal_utility_CLerpF_setStartEnd(long l, CLerpF cLerpF, float f2, float f3) {
    }

    public static final native void eal_utility_CLerpF_setDuration(long l, CLerpF cLerpF, long l2) {
    }

    public static final native float eal_utility_CLerpF_getStart(long l, CLerpF cLerpF) {
    }

    public static final native float eal_utility_CLerpF_getEnd(long l, CLerpF cLerpF) {
    }

    public static final native long eal_utility_CLerpF_getDuration(long l, CLerpF cLerpF) {
    }

    public static final native void eal_utility_CLerpF_invert(long l, CLerpF cLerpF) {
    }

    public static final native long new_eal_utility_CLerpD__SWIG_0() {
    }

    public static final native long new_eal_utility_CLerpD__SWIG_1(double d2, double d3, long l) {
    }

    public static final native void delete_eal_utility_CLerpD(long l) {
    }

    public static final native void eal_utility_CLerpD_start(long l, CLerpD cLerpD) {
    }

    public static final native double eal_utility_CLerpD_evaluate(long l, CLerpD cLerpD) {
    }

    public static final native boolean eal_utility_CLerpD_isFinished(long l, CLerpD cLerpD) {
    }

    public static final native void eal_utility_CLerpD_setStart(long l, CLerpD cLerpD, double d2) {
    }

    public static final native void eal_utility_CLerpD_setEnd(long l, CLerpD cLerpD, double d2) {
    }

    public static final native void eal_utility_CLerpD_setStartEnd(long l, CLerpD cLerpD, double d2, double d3) {
    }

    public static final native void eal_utility_CLerpD_setDuration(long l, CLerpD cLerpD, long l2) {
    }

    public static final native double eal_utility_CLerpD_getStart(long l, CLerpD cLerpD) {
    }

    public static final native double eal_utility_CLerpD_getEnd(long l, CLerpD cLerpD) {
    }

    public static final native long eal_utility_CLerpD_getDuration(long l, CLerpD cLerpD) {
    }

    public static final native void eal_utility_CLerpD_invert(long l, CLerpD cLerpD) {
    }

    public static final native long new_ipl_VectorF__SWIG_0() {
    }

    public static final native long new_ipl_VectorF__SWIG_1(long l) {
    }

    public static final native long ipl_VectorF_size(long l, VectorF vectorF) {
    }

    public static final native long ipl_VectorF_capacity(long l, VectorF vectorF) {
    }

    public static final native void ipl_VectorF_reserve(long l, VectorF vectorF, long l2) {
    }

    public static final native boolean ipl_VectorF_isEmpty(long l, VectorF vectorF) {
    }

    public static final native void ipl_VectorF_clear(long l, VectorF vectorF) {
    }

    public static final native void ipl_VectorF_add(long l, VectorF vectorF, float f2) {
    }

    public static final native void delete_ipl_VectorF(long l) {
    }

    public static final native long new_ipl_VectorD__SWIG_0() {
    }

    public static final native long new_ipl_VectorD__SWIG_1(long l) {
    }

    public static final native long ipl_VectorD_size(long l, VectorD vectorD) {
    }

    public static final native long ipl_VectorD_capacity(long l, VectorD vectorD) {
    }

    public static final native void ipl_VectorD_reserve(long l, VectorD vectorD, long l2) {
    }

    public static final native boolean ipl_VectorD_isEmpty(long l, VectorD vectorD) {
    }

    public static final native void ipl_VectorD_clear(long l, VectorD vectorD) {
    }

    public static final native void ipl_VectorD_add(long l, VectorD vectorD, double d2) {
    }

    public static final native void delete_ipl_VectorD(long l) {
    }

    public static final native long new_eal_utility_CLinearInterpolatorF__SWIG_0() {
    }

    public static final native long new_eal_utility_CLinearInterpolatorF__SWIG_1(long l, VectorF vectorF, long l2) {
    }

    public static final native float eal_utility_CLinearInterpolatorF_evaluate(long l, CLinearInterpolatorF cLinearInterpolatorF) {
    }

    public static final native boolean eal_utility_CLinearInterpolatorF_isFinished(long l, CLinearInterpolatorF cLinearInterpolatorF) {
    }

    public static final native void eal_utility_CLinearInterpolatorF_setKnots(long l, CLinearInterpolatorF cLinearInterpolatorF, long l2, VectorF vectorF) {
    }

    public static final native void eal_utility_CLinearInterpolatorF_setAnimationTime(long l, CLinearInterpolatorF cLinearInterpolatorF, long l2) {
    }

    public static final native void delete_eal_utility_CLinearInterpolatorF(long l) {
    }

    public static final native long new_eal_utility_CLinearInterpolatorD__SWIG_0() {
    }

    public static final native long new_eal_utility_CLinearInterpolatorD__SWIG_1(long l, VectorD vectorD, long l2) {
    }

    public static final native double eal_utility_CLinearInterpolatorD_evaluate(long l, CLinearInterpolatorD cLinearInterpolatorD) {
    }

    public static final native boolean eal_utility_CLinearInterpolatorD_isFinished(long l, CLinearInterpolatorD cLinearInterpolatorD) {
    }

    public static final native void eal_utility_CLinearInterpolatorD_setKnots(long l, CLinearInterpolatorD cLinearInterpolatorD, long l2, VectorD vectorD) {
    }

    public static final native void eal_utility_CLinearInterpolatorD_setAnimationTime(long l, CLinearInterpolatorD cLinearInterpolatorD, long l2) {
    }

    public static final native void delete_eal_utility_CLinearInterpolatorD(long l) {
    }

    public static final native long new_eal_utility_COffscreenHelper(long l, IProject iProject, long l2, INode2DManaged iNode2DManaged) {
    }

    public static final native void delete_eal_utility_COffscreenHelper(long l) {
    }

    public static final native void eal_utility_COffscreenHelper_dispose(long l, COffscreenHelper cOffscreenHelper) {
    }

    public static final native long eal_utility_COffscreenHelper_enableOffscreen__SWIG_0(long l, COffscreenHelper cOffscreenHelper, long l2, INode2D iNode2D, long l3, long l4, long l5, FlagTexture flagTexture, int n) {
    }

    public static final native long eal_utility_COffscreenHelper_enableOffscreen__SWIG_1(long l, COffscreenHelper cOffscreenHelper, long l2, INode2D iNode2D, long l3, long l4, long l5, FlagTexture flagTexture, int n, boolean bl) {
    }

    public static final native boolean eal_utility_COffscreenHelper_enableOffscreen__SWIG_2(long l, COffscreenHelper cOffscreenHelper, long l2, INode2D iNode2D, long l3, ITexture iTexture, int n) {
    }

    public static final native boolean eal_utility_COffscreenHelper_enableOffscreen__SWIG_3(long l, COffscreenHelper cOffscreenHelper, long l2, INode2D iNode2D, long l3, ITexture iTexture, int n, boolean bl) {
    }

    public static final native boolean eal_utility_COffscreenHelper_disableOffscreen(long l, COffscreenHelper cOffscreenHelper, long l2, INode2D iNode2D) {
    }

    public static final native long eal_IEventMerge_SWIGUpcast(long l) {
    }

    public static final native long eal_IEventImage_SWIGUpcast(long l) {
    }

    public static final native long eal_IEventImageSave_SWIGUpcast(long l) {
    }

    public static final native long eal_IEventFontGroup_SWIGUpcast(long l) {
    }

    public static final native long eal_CAbstractEventListener_SWIGUpcast(long l) {
    }

    public static final native long eal_api_IAnimation_SWIGUpcast(long l) {
    }

    public static final native long eal_api_IAnimationClip_SWIGUpcast(long l) {
    }

    public static final native long eal_api_IAnimationPlayer_SWIGUpcast(long l) {
    }

    public static final native long eal_api_ITimeLineSequence_SWIGUpcast(long l) {
    }

    public static final native long eal_api_IContext_SWIGUpcast(long l) {
    }

    public static final native long eal_api_IManager_SWIGUpcast(long l) {
    }

    public static final native long eal_api_IProject_SWIGUpcast(long l) {
    }

    public static final native long eal_api_IImage_SWIGUpcast(long l) {
    }

    public static final native long eal_api_IMeshData_SWIGUpcast(long l) {
    }

    public static final native long eal_api_ITexture_SWIGUpcast(long l) {
    }

    public static final native long eal_api_ITextureShared_SWIGUpcast(long l) {
    }

    public static final native long eal_api_ITextureAtlas_SWIGUpcast(long l) {
    }

    public static final native long eal_api_ITextureOffscreen_SWIGUpcast(long l) {
    }

    public static final native long eal_api_IMaterial_SWIGUpcast(long l) {
    }

    public static final native long eal_api_IProperty_SWIGUpcast(long l) {
    }

    public static final native long eal_api_IRenderer_SWIGUpcast(long l) {
    }

    public static final native long eal_api_IRendererAnnotation_SWIGUpcast(long l) {
    }

    public static final native long eal_api_IINodeImage_SWIGUpcast(long l) {
    }

    public static final native long eal_api_IINodeText_SWIGUpcast(long l) {
    }

    public static final native long eal_api_INode_SWIGUpcast(long l) {
    }

    public static final native long eal_api_INode2D_SWIGUpcast(long l) {
    }

    public static final native long eal_api_INode2DHud_SWIGUpcast(long l) {
    }

    public static final native long eal_api_INode2DImage_SWIGUpcast(long l) {
    }

    public static final native long eal_api_INode2DLink_SWIGUpcast(long l) {
    }

    public static final native long eal_api_INode2DManaged_SWIGUpcast(long l) {
    }

    public static final native long eal_api_INode2DPartial_SWIGUpcast(long l) {
    }

    public static final native long eal_api_INode2DText_SWIGUpcast(long l) {
    }

    public static final native long eal_api_INode3D_SWIGUpcast(long l) {
    }

    public static final native long eal_api_INode3DCamera_SWIGUpcast(long l) {
    }

    public static final native long eal_api_INode3DImage_SWIGUpcast(long l) {
    }

    public static final native long eal_api_INode3DMesh_SWIGUpcast(long l) {
    }

    public static final native long eal_api_INode3DQuickDraw_SWIGUpcast(long l) {
    }

    public static final native long eal_api_INode3DScene_SWIGUpcast(long l) {
    }

    public static final native long eal_api_INode3DText_SWIGUpcast(long l) {
    }

    public static final native long eal_api_ITemplateNode2D_SWIGUpcast(long l) {
    }

    public static final native long eal_api_ITemplateNode3D_SWIGUpcast(long l) {
    }

    public static final native long eal_api_IFont_SWIGUpcast(long l) {
    }

    public static final native long eal_api_IFontGroupFontHandle_SWIGUpcast(long l) {
    }

    public static final native long eal_api_IFontGroup_SWIGUpcast(long l) {
    }

    public static final native long eal_api_ITextLayoutSection_SWIGUpcast(long l) {
    }

    public static final native long eal_api_ITextLayout_SWIGUpcast(long l) {
    }

    public static final native long eal_api_ITextLayoutResult_SWIGUpcast(long l) {
    }

    public static void eal_SwigDirector_eal_IInputListener_mouseEvent(IInputListener iInputListener, int n, int n2, int n3) {
        iInputListener.mouseEvent(ealMouseState_t.swigToEnum(n), n2, n3);
    }

    public static String eal_SwigDirector_eal_CAbstractEventListener_getName(CAbstractEventListener cAbstractEventListener) {
        return cAbstractEventListener.getName();
    }

    public static void eal_SwigDirector_eal_CAbstractEventListener_process(CAbstractEventListener cAbstractEventListener, long l) {
        cAbstractEventListener.process(new IEvent(l, false));
    }

    public static void eal_SwigDirector_eal_ICacheCallback_destroy(ICacheCallback iCacheCallback, int n) {
        iCacheCallback.destroy(n);
    }

    public static void eal_utility_SwigDirector_eal_utility_IImageStorageListener_process(IImageStorageListener iImageStorageListener, int n, long l) {
        iImageStorageListener.process(IImageStorageListener$enType_t.swigToEnum(n), l);
    }

    private static final native void swig_module_init() {
    }

    static {
        try {
            Version.setJava(true);
            Version.registerBinding(637927680);
            Version.print();
            if (!Version.isValid()) {
                int n = Version.getVersion();
                int n2 = 637927680;
                System.err.println(new StringBuffer().append("EAL - Version mismatch: ").append(Version.verToString()).append("(").append(n).append(") != ").append(Version.verToString(n2)).append("(").append(n2).append(")").toString());
                System.exit(1);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            System.exit(1);
        }
        ealswigJNI.swig_module_init();
    }
}

