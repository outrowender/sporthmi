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
import de.esolutions.graphics.ipl.VectorD;
import de.esolutions.graphics.ipl.VectorF;
import java.math.BigInteger;
import java.nio.ByteBuffer;

public class ealswigJNI {
    public static final native int EAL_VERSION_get();

    public static final native long new_eal_Version();

    public static final native void delete_eal_Version(long var0);

    public static final native void eal_Version_print();

    public static final native String eal_Version_verToString__SWIG_0();

    public static final native boolean eal_Version_isValid();

    public static final native int eal_Version_getVersion();

    public static final native String eal_Version_verToString__SWIG_1(int var0);

    public static final native void eal_Version_setJava(boolean var0);

    public static final native boolean eal_Version_isJava();

    public static final native void eal_Version_registerBinding(int var0);

    public static final native void eal_colorRGBAf_fRed_set(long var0, colorRGBAf var2, float var3);

    public static final native float eal_colorRGBAf_fRed_get(long var0, colorRGBAf var2);

    public static final native void eal_colorRGBAf_fGreen_set(long var0, colorRGBAf var2, float var3);

    public static final native float eal_colorRGBAf_fGreen_get(long var0, colorRGBAf var2);

    public static final native void eal_colorRGBAf_fBlue_set(long var0, colorRGBAf var2, float var3);

    public static final native float eal_colorRGBAf_fBlue_get(long var0, colorRGBAf var2);

    public static final native void eal_colorRGBAf_fAlpha_set(long var0, colorRGBAf var2, float var3);

    public static final native float eal_colorRGBAf_fAlpha_get(long var0, colorRGBAf var2);

    public static final native long new_eal_colorRGBAf__SWIG_0();

    public static final native long new_eal_colorRGBAf__SWIG_1(float var0, float var1, float var2, float var3);

    public static final native void delete_eal_colorRGBAf(long var0);

    public static final native int eal_MEMORYTYPE_NONE_get();

    public static final native int eal_MEMORYTYPE_RAM_get();

    public static final native int eal_MEMORYTYPE_GPU_get();

    public static final native int eal_MEMORYTYPE_RAM_GPU_get();

    public static final native int eal_EVENTTYPE_MERGE_LOADED_get();

    public static final native int eal_EVENTTYPE_MERGE_MERGED_get();

    public static final native int eal_EVENTTYPE_IMAGE_get();

    public static final native int eal_EVENTTYPE_IMAGE_SAVE_get();

    public static final native int eal_EVENTTYPE_FONTGROUP_get();

    public static final native int eal_EVENTTYPE_SAVE_get();

    public static final native int eal_IMAGE_OPTIONS_MASK_FORMAT_get();

    public static final native int eal_IMAGE_OPTIONS_FORMAT_RGBA_8888_get();

    public static final native int eal_IMAGE_OPTIONS_FORMAT_RGB_888_get();

    public static final native int eal_IMAGE_OPTIONS_FORMAT_RGB_565_get();

    public static final native int eal_IMAGE_OPTIONS_FORMAT_L_8_get();

    public static final native int eal_IMAGE_OPTIONS_FORMAT_A_8_get();

    public static final native int eal_IMAGE_OPTIONS_FORMAT_LA_88_get();

    public static final native int eal_IMAGE_OPTIONS_FORMAT_AUTO_get();

    public static final native int eal_IMAGE_OPTIONS_FORMAT_INVALID_get();

    public static final native int eal_TEX_OPTIONS_MASK_MEMORY_get();

    public static final native int eal_TEX_OPTIONS_MASK_FILTER_get();

    public static final native int eal_TEX_OPTIONS_MASK_WRAP_get();

    public static final native int eal_TEX_OPTIONS_MASK_COMPRESSION_get();

    public static final native int eal_TEX_OPTIONS_MASK_FORMAT_get();

    public static final native int eal_TEX_OPTIONS_MASK_EXT_get();

    public static final native int eal_TEX_OPTIONS_MEMORY_GPU_get();

    public static final native int eal_TEX_OPTIONS_MEMORY_RAM_get();

    public static final native int eal_TEX_OPTIONS_FILTER_POINT_get();

    public static final native int eal_TEX_OPTIONS_FILTER_BILINEAR_get();

    public static final native int eal_TEX_OPTIONS_FILTER_TRILINAR_get();

    public static final native int eal_TEX_OPTIONS_FILTER_MIMAP_get();

    public static final native int eal_TEX_OPTIONS_WRAP_REPEAT_get();

    public static final native int eal_TEX_OPTIONS_WRAP_CLAMP_get();

    public static final native int eal_TEX_OPTIONS_COMPRESSION_NONE_get();

    public static final native int eal_TEX_OPTIONS_COMPRESSION_ETC_get();

    public static final native int eal_TEX_OPTIONS_COMPRESSION_DXT3_RGBA_get();

    public static final native int eal_TEX_OPTIONS_COMPRESSION_DXT5_RGBA_get();

    public static final native int eal_TEX_OPTIONS_FORMAT_RGBA_8888_get();

    public static final native int eal_TEX_OPTIONS_FORMAT_RGB_888_get();

    public static final native int eal_TEX_OPTIONS_FORMAT_RGB_565_get();

    public static final native int eal_TEX_OPTIONS_FORMAT_L_8_get();

    public static final native int eal_TEX_OPTIONS_FORMAT_A_8_get();

    public static final native int eal_TEX_OPTIONS_FORMAT_LA_88_get();

    public static final native int eal_TEX_OPTIONS_FORMAT_INVALID_get();

    public static final native int eal_TEX_OPTIONS_EXT_CLEAR_BLACK_get();

    public static final native int eal_TEX_OPTIONS_EXT_NO_ATLAS_get();

    public static final native int eal_TEX_OPTIONS_EXT_EXTERNAL_OES_get();

    public static final native int eal_TEX_OPTION_INVALID_get();

    public static final native void eal_displaySize_t_uiWidth_set(long var0, displaySize_t var2, long var3);

    public static final native long eal_displaySize_t_uiWidth_get(long var0, displaySize_t var2);

    public static final native void eal_displaySize_t_uiHeight_set(long var0, displaySize_t var2, long var3);

    public static final native long eal_displaySize_t_uiHeight_get(long var0, displaySize_t var2);

    public static final native long new_eal_displaySize_t();

    public static final native void delete_eal_displaySize_t(long var0);

    public static final native int eal_EAL_PRINT_OPTION_NONE_get();

    public static final native int eal_EAL_PRINT_OPTION_MODE_VISIBLE_get();

    public static final native int eal_EAL_PRINT_OPTION_MODE_LAYER_ONLY_get();

    public static final native int eal_EAL_PRINT_OPTION_MODE_EXT_get();

    public static final native int eal_EAL_PRINT_OPTION_MODE_PR_get();

    public static final native int eal_EAL_PRINT_OPTION_OUTPUT_STDOUT_get();

    public static final native int eal_EAL_PRINT_OPTION_OUTPUT_TRACE_get();

    public static final native int eal_EAL_PRINT_OPTION_TYPE_PLAIN_get();

    public static final native int eal_EAL_PRINT_OPTION_TYPE_JSON_get();

    public static final native int eal_EAL_PRINT_OPTION_TYPE_XML_get();

    public static final native int eal_EAL_PRINT_FLAG_PROPERTIES_get();

    public static final native int eal_EAL_PRINT_OPTION_MASK_MODE_get();

    public static final native int eal_EAL_PRINT_OPTION_MASK_OUTPUT_get();

    public static final native int eal_EAL_PRINT_OPTION_MASK_TYPE_get();

    public static final native int eal_EAL_MERGE_FLAG_NONE_get();

    public static final native int eal_EAL_MERGE_FLAG_FORCE_get();

    public static final native int eal_EAL_MERGE_FLAG_LOADING_HINT_PRELOAD_get();

    public static final native int eal_EAL_MERGE_FLAG_LOADING_HINT_MAP_get();

    public static final native int eal_EAL_MERGE_FLAG_LOADING_MASK_get();

    public static final native void eal_glyphInformation_t_uiTotalGlyphs_set(long var0, glyphInformation_t var2, long var3);

    public static final native long eal_glyphInformation_t_uiTotalGlyphs_get(long var0, glyphInformation_t var2);

    public static final native void eal_glyphInformation_t_uiAvailableGlyphs_set(long var0, glyphInformation_t var2, long var3);

    public static final native long eal_glyphInformation_t_uiAvailableGlyphs_get(long var0, glyphInformation_t var2);

    public static final native long new_eal_glyphInformation_t();

    public static final native void delete_eal_glyphInformation_t(long var0);

    public static final native int EAL_FONT_MAX_WIDTH_get();

    public static final native void eal_ealSize_t_width_set(long var0, ealSize_t var2, long var3);

    public static final native long eal_ealSize_t_width_get(long var0, ealSize_t var2);

    public static final native void eal_ealSize_t_height_set(long var0, ealSize_t var2, long var3);

    public static final native long eal_ealSize_t_height_get(long var0, ealSize_t var2);

    public static final native long new_eal_ealSize_t();

    public static final native void delete_eal_ealSize_t(long var0);

    public static final native void eal_glyph_t_width_set(long var0, glyph_t var2, long var3);

    public static final native long eal_glyph_t_width_get(long var0, glyph_t var2);

    public static final native void eal_glyph_t_height_set(long var0, glyph_t var2, long var3);

    public static final native long eal_glyph_t_height_get(long var0, glyph_t var2);

    public static final native void eal_glyph_t_x_set(long var0, glyph_t var2, float var3);

    public static final native float eal_glyph_t_x_get(long var0, glyph_t var2);

    public static final native void eal_glyph_t_y_set(long var0, glyph_t var2, float var3);

    public static final native float eal_glyph_t_y_get(long var0, glyph_t var2);

    public static final native void eal_glyph_t_caretX_set(long var0, glyph_t var2, float var3);

    public static final native float eal_glyph_t_caretX_get(long var0, glyph_t var2);

    public static final native void eal_glyph_t_isRightToLeft_set(long var0, glyph_t var2, boolean var3);

    public static final native boolean eal_glyph_t_isRightToLeft_get(long var0, glyph_t var2);

    public static final native long new_eal_glyph_t();

    public static final native void delete_eal_glyph_t(long var0);

    public static final native void delete_eal_Defaults(long var0);

    public static final native long eal_Defaults_getFlagsImage();

    public static final native long eal_Defaults_getFlagsTexture();

    public static final native long new_eal_FlagImage__SWIG_0();

    public static final native long new_eal_FlagImage__SWIG_1(int var0);

    public static final native long new_eal_FlagImage__SWIG_2(long var0);

    public static final native long eal_FlagImage_getFlagValue(long var0, FlagImage var2);

    public static final native void eal_FlagImage_setFlag(long var0, FlagImage var2, int var3);

    public static final native boolean eal_FlagImage_isFlag(long var0, FlagImage var2, int var3);

    public static final native void eal_FlagImage_reset(long var0, FlagImage var2);

    public static final native void eal_FlagImage_resetPos(long var0, FlagImage var2, long var3);

    public static final native void eal_FlagImage_unsetFlag(long var0, FlagImage var2, int var3);

    public static final native void eal_FlagImage_setFlagValue(long var0, FlagImage var2, long var3);

    public static final native long eal_FlagImage_getHexValueAtPos(long var0, FlagImage var2, long var3);

    public static final native long eal_FlagImage_extractPosition(long var0, FlagImage var2, long var3);

    public static final native long eal_FlagImage_getByMask(long var0, FlagImage var2, long var3);

    public static final native boolean eal_FlagImage_equal__SWIG_0(long var0, FlagImage var2, long var3);

    public static final native boolean eal_FlagImage_equal__SWIG_1(long var0, FlagImage var2, int var3);

    public static final native boolean eal_FlagImage_unequal__SWIG_0(long var0, FlagImage var2, long var3);

    public static final native boolean eal_FlagImage_unequal__SWIG_1(long var0, FlagImage var2, int var3);

    public static final native boolean eal_FlagImage_contains__SWIG_0(long var0, FlagImage var2, int var3);

    public static final native boolean eal_FlagImage_contains__SWIG_1(long var0, FlagImage var2, long var3, FlagImage var5);

    public static final native void delete_eal_FlagImage(long var0);

    public static final native long new_eal_FlagTexture__SWIG_0();

    public static final native long new_eal_FlagTexture__SWIG_1(int var0);

    public static final native long new_eal_FlagTexture__SWIG_2(long var0);

    public static final native long eal_FlagTexture_getFlagValue(long var0, FlagTexture var2);

    public static final native void eal_FlagTexture_setFlag(long var0, FlagTexture var2, int var3);

    public static final native boolean eal_FlagTexture_isFlag(long var0, FlagTexture var2, int var3);

    public static final native void eal_FlagTexture_reset(long var0, FlagTexture var2);

    public static final native void eal_FlagTexture_resetPos(long var0, FlagTexture var2, long var3);

    public static final native void eal_FlagTexture_unsetFlag(long var0, FlagTexture var2, int var3);

    public static final native void eal_FlagTexture_setFlagValue(long var0, FlagTexture var2, long var3);

    public static final native long eal_FlagTexture_getHexValueAtPos(long var0, FlagTexture var2, long var3);

    public static final native long eal_FlagTexture_extractPosition(long var0, FlagTexture var2, long var3);

    public static final native long eal_FlagTexture_getByMask(long var0, FlagTexture var2, long var3);

    public static final native boolean eal_FlagTexture_equal__SWIG_0(long var0, FlagTexture var2, long var3);

    public static final native boolean eal_FlagTexture_equal__SWIG_1(long var0, FlagTexture var2, int var3);

    public static final native boolean eal_FlagTexture_unequal__SWIG_0(long var0, FlagTexture var2, long var3);

    public static final native boolean eal_FlagTexture_unequal__SWIG_1(long var0, FlagTexture var2, int var3);

    public static final native boolean eal_FlagTexture_contains__SWIG_0(long var0, FlagTexture var2, int var3);

    public static final native boolean eal_FlagTexture_contains__SWIG_1(long var0, FlagTexture var2, long var3, FlagTexture var5);

    public static final native void delete_eal_FlagTexture(long var0);

    public static final native long new_eal_FlagPrint__SWIG_0();

    public static final native long new_eal_FlagPrint__SWIG_1(int var0);

    public static final native long new_eal_FlagPrint__SWIG_2(long var0);

    public static final native long eal_FlagPrint_getFlagValue(long var0, FlagPrint var2);

    public static final native void eal_FlagPrint_setFlag(long var0, FlagPrint var2, int var3);

    public static final native boolean eal_FlagPrint_isFlag(long var0, FlagPrint var2, int var3);

    public static final native void eal_FlagPrint_reset(long var0, FlagPrint var2);

    public static final native void eal_FlagPrint_resetPos(long var0, FlagPrint var2, long var3);

    public static final native void eal_FlagPrint_unsetFlag(long var0, FlagPrint var2, int var3);

    public static final native void eal_FlagPrint_setFlagValue(long var0, FlagPrint var2, long var3);

    public static final native long eal_FlagPrint_getHexValueAtPos(long var0, FlagPrint var2, long var3);

    public static final native long eal_FlagPrint_extractPosition(long var0, FlagPrint var2, long var3);

    public static final native long eal_FlagPrint_getByMask(long var0, FlagPrint var2, long var3);

    public static final native boolean eal_FlagPrint_equal__SWIG_0(long var0, FlagPrint var2, long var3);

    public static final native boolean eal_FlagPrint_equal__SWIG_1(long var0, FlagPrint var2, int var3);

    public static final native boolean eal_FlagPrint_unequal__SWIG_0(long var0, FlagPrint var2, long var3);

    public static final native boolean eal_FlagPrint_unequal__SWIG_1(long var0, FlagPrint var2, int var3);

    public static final native boolean eal_FlagPrint_contains__SWIG_0(long var0, FlagPrint var2, int var3);

    public static final native boolean eal_FlagPrint_contains__SWIG_1(long var0, FlagPrint var2, long var3, FlagPrint var5);

    public static final native void delete_eal_FlagPrint(long var0);

    public static final native long new_eal_FlagMerge__SWIG_0();

    public static final native long new_eal_FlagMerge__SWIG_1(int var0);

    public static final native long new_eal_FlagMerge__SWIG_2(long var0);

    public static final native long eal_FlagMerge_getFlagValue(long var0, FlagMerge var2);

    public static final native void eal_FlagMerge_setFlag(long var0, FlagMerge var2, int var3);

    public static final native boolean eal_FlagMerge_isFlag(long var0, FlagMerge var2, int var3);

    public static final native void eal_FlagMerge_reset(long var0, FlagMerge var2);

    public static final native void eal_FlagMerge_resetPos(long var0, FlagMerge var2, long var3);

    public static final native void eal_FlagMerge_unsetFlag(long var0, FlagMerge var2, int var3);

    public static final native void eal_FlagMerge_setFlagValue(long var0, FlagMerge var2, long var3);

    public static final native long eal_FlagMerge_getHexValueAtPos(long var0, FlagMerge var2, long var3);

    public static final native long eal_FlagMerge_extractPosition(long var0, FlagMerge var2, long var3);

    public static final native long eal_FlagMerge_getByMask(long var0, FlagMerge var2, long var3);

    public static final native boolean eal_FlagMerge_equal__SWIG_0(long var0, FlagMerge var2, long var3);

    public static final native boolean eal_FlagMerge_equal__SWIG_1(long var0, FlagMerge var2, int var3);

    public static final native boolean eal_FlagMerge_unequal__SWIG_0(long var0, FlagMerge var2, long var3);

    public static final native boolean eal_FlagMerge_unequal__SWIG_1(long var0, FlagMerge var2, int var3);

    public static final native boolean eal_FlagMerge_contains__SWIG_0(long var0, FlagMerge var2, int var3);

    public static final native boolean eal_FlagMerge_contains__SWIG_1(long var0, FlagMerge var2, long var3, FlagMerge var5);

    public static final native void delete_eal_FlagMerge(long var0);

    public static final native long new_eal_FlagEvent__SWIG_0();

    public static final native long new_eal_FlagEvent__SWIG_1(int var0);

    public static final native long new_eal_FlagEvent__SWIG_2(long var0);

    public static final native long eal_FlagEvent_getFlagValue(long var0, FlagEvent var2);

    public static final native void eal_FlagEvent_setFlag(long var0, FlagEvent var2, int var3);

    public static final native boolean eal_FlagEvent_isFlag(long var0, FlagEvent var2, int var3);

    public static final native void eal_FlagEvent_reset(long var0, FlagEvent var2);

    public static final native void eal_FlagEvent_resetPos(long var0, FlagEvent var2, long var3);

    public static final native void eal_FlagEvent_unsetFlag(long var0, FlagEvent var2, int var3);

    public static final native void eal_FlagEvent_setFlagValue(long var0, FlagEvent var2, long var3);

    public static final native long eal_FlagEvent_getHexValueAtPos(long var0, FlagEvent var2, long var3);

    public static final native long eal_FlagEvent_extractPosition(long var0, FlagEvent var2, long var3);

    public static final native long eal_FlagEvent_getByMask(long var0, FlagEvent var2, long var3);

    public static final native boolean eal_FlagEvent_equal__SWIG_0(long var0, FlagEvent var2, long var3);

    public static final native boolean eal_FlagEvent_equal__SWIG_1(long var0, FlagEvent var2, int var3);

    public static final native boolean eal_FlagEvent_unequal__SWIG_0(long var0, FlagEvent var2, long var3);

    public static final native boolean eal_FlagEvent_unequal__SWIG_1(long var0, FlagEvent var2, int var3);

    public static final native boolean eal_FlagEvent_contains__SWIG_0(long var0, FlagEvent var2, int var3);

    public static final native boolean eal_FlagEvent_contains__SWIG_1(long var0, FlagEvent var2, long var3, FlagEvent var5);

    public static final native void delete_eal_FlagEvent(long var0);

    public static final native long new_eal_Vec2f__SWIG_0();

    public static final native long new_eal_Vec2f__SWIG_1(float var0, float var1);

    public static final native long new_eal_Vec2f__SWIG_2(float var0);

    public static final native long new_eal_Vec2f__SWIG_3(long var0, Vec2f var2);

    public static final native long new_eal_Vec2f__SWIG_4(long var0, Vec3f var2);

    public static final native long new_eal_Vec2f__SWIG_5(long var0, Vec3f var2, int var3);

    public static final native float eal_Vec2f_X__SWIG_0(long var0, Vec2f var2);

    public static final native float eal_Vec2f_Y__SWIG_0(long var0, Vec2f var2);

    public static final native float eal_Vec2f_Length(long var0, Vec2f var2);

    public static final native float eal_Vec2f_Length2(long var0, Vec2f var2);

    public static final native long eal_Vec2f_Normalize(long var0, Vec2f var2);

    public static final native float eal_Vec2f_GetEpsilon();

    public static final native void eal_Vec2f_SetEpsilon(float var0);

    public static final native void delete_eal_Vec2f(long var0);

    public static final native long new_eal_Vec3f__SWIG_0();

    public static final native long new_eal_Vec3f__SWIG_1(float var0, float var1, float var2);

    public static final native long new_eal_Vec3f__SWIG_2(float var0);

    public static final native long new_eal_Vec3f__SWIG_3(long var0, Vec3f var2);

    public static final native long new_eal_Vec3f__SWIG_4(long var0, Vec2f var2);

    public static final native long new_eal_Vec3f__SWIG_5(long var0, Vec2f var2, float var3);

    public static final native long new_eal_Vec3f__SWIG_6(long var0, Vec4f var2);

    public static final native long new_eal_Vec3f__SWIG_7(long var0, Vec4f var2, int var3);

    public static final native float eal_Vec3f_X__SWIG_0(long var0, Vec3f var2);

    public static final native float eal_Vec3f_Y__SWIG_0(long var0, Vec3f var2);

    public static final native float eal_Vec3f_Z__SWIG_0(long var0, Vec3f var2);

    public static final native float eal_Vec3f_Length(long var0, Vec3f var2);

    public static final native float eal_Vec3f_Length2(long var0, Vec3f var2);

    public static final native long eal_Vec3f_Normalize(long var0, Vec3f var2);

    public static final native void eal_Vec3f_Cross(long var0, Vec3f var2, long var3, Vec3f var5, long var6, Vec3f var8);

    public static final native void eal_Vec3f_Sub(long var0, Vec3f var2, long var3, Vec3f var5, long var6, Vec3f var8);

    public static final native void eal_Vec3f_Add(long var0, Vec3f var2, long var3, Vec3f var5, long var6, Vec3f var8);

    public static final native float eal_Vec3f_Dot(long var0, Vec3f var2, long var3, Vec3f var5);

    public static final native float eal_Vec3f_GetEpsilon();

    public static final native void eal_Vec3f_SetEpsilon(float var0);

    public static final native void delete_eal_Vec3f(long var0);

    public static final native long new_eal_Vec4f__SWIG_0();

    public static final native long new_eal_Vec4f__SWIG_1(float var0, float var1, float var2, float var3);

    public static final native long new_eal_Vec4f__SWIG_2(float var0);

    public static final native long new_eal_Vec4f__SWIG_3(long var0, Vec4f var2);

    public static final native long new_eal_Vec4f__SWIG_4(long var0, Vec3f var2);

    public static final native long new_eal_Vec4f__SWIG_5(long var0, Vec3f var2, float var3);

    public static final native float eal_Vec4f_X__SWIG_0(long var0, Vec4f var2);

    public static final native float eal_Vec4f_Y__SWIG_0(long var0, Vec4f var2);

    public static final native float eal_Vec4f_Z__SWIG_0(long var0, Vec4f var2);

    public static final native float eal_Vec4f_W__SWIG_0(long var0, Vec4f var2);

    public static final native float eal_Vec4f_Length(long var0, Vec4f var2);

    public static final native float eal_Vec4f_Length2(long var0, Vec4f var2);

    public static final native long eal_Vec4f_Normalize(long var0, Vec4f var2);

    public static final native float eal_Vec4f_GetEpsilon(long var0, Vec4f var2);

    public static final native void eal_Vec4f_SetEpsilon(long var0, Vec4f var2, float var3);

    public static final native void delete_eal_Vec4f(long var0);

    public static final native long new_eal_Mat4f__SWIG_0();

    public static final native long new_eal_Mat4f__SWIG_1(long var0, Vec4f var2, long var3, Vec4f var5, long var6, Vec4f var8, long var9, Vec4f var11);

    public static final native long new_eal_Mat4f__SWIG_2(float var0);

    public static final native long new_eal_Mat4f__SWIG_3(long var0, Mat4f var2);

    public static final native long eal_Mat4f_Transpose(long var0, Mat4f var2);

    public static final native long eal_Mat4f_Inverse(long var0, Mat4f var2);

    public static final native long eal_Mat4f_GetIdentity();

    public static final native long eal_Mat4f_GetTransMat(long var0, Vec3f var2);

    public static final native long eal_Mat4f_GetRotMat(long var0, Vec3f var2, float var3);

    public static final native long eal_Mat4f_GetScaleMat(long var0, Vec3f var2);

    public static final native long eal_Mat4f_GetPerspMat(float var0);

    public static final native long eal_Mat4f_GetRotationVecFromIntoTo(long var0, Vec3f var2, long var3, Vec3f var5);

    public static final native void delete_eal_Mat4f(long var0);

    public static final native long new_eal_Mat3f__SWIG_0();

    public static final native long new_eal_Mat3f__SWIG_1(long var0, Vec3f var2, long var3, Vec3f var5, long var6, Vec3f var8);

    public static final native long new_eal_Mat3f__SWIG_2(float var0);

    public static final native long new_eal_Mat3f__SWIG_3(long var0, Mat3f var2);

    public static final native long eal_Mat3f_Transpose(long var0, Mat3f var2);

    public static final native long eal_Mat3f_Inverse(long var0, Mat3f var2);

    public static final native long eal_Mat3f_GetColumn(long var0, Mat3f var2, int var3);

    public static final native long eal_Mat3f_Mult(long var0, Mat3f var2, long var3, Mat3f var5);

    public static final native long eal_Mat3f_GetIdentity();

    public static final native long eal_Mat3f_GetTransMat(long var0, Vec2f var2);

    public static final native long eal_Mat3f_GetRotMat(long var0, Vec2f var2, float var3);

    public static final native long eal_Mat3f_GetScaleMat(long var0, Vec2f var2);

    public static final native long eal_Mat3f_GetEigenvector(long var0, Mat3f var2, float var3);

    public static final native void delete_eal_Mat3f(long var0);

    public static final native void delete_eal_IEvent(long var0);

    public static final native int eal_IEvent_getType(long var0, IEvent var2);

    public static final native boolean eal_IEvent_notifyListener(long var0, IEvent var2);

    public static final native boolean eal_IEvent_isDeleteable(long var0, IEvent var2);

    public static final native boolean eal_IEvent_isError(long var0, IEvent var2);

    public static final native long eal_IEvent_getId(long var0, IEvent var2);

    public static final native boolean eal_IEvent_isMergeEvent(long var0, IEvent var2);

    public static final native long eal_IEvent_toEventMerge(long var0, IEvent var2);

    public static final native boolean eal_IEvent_isEventImage(long var0, IEvent var2);

    public static final native long eal_IEvent_toEventImage(long var0, IEvent var2);

    public static final native void delete_eal_IEventListener(long var0);

    public static final native String eal_IEventListener_getName(long var0, IEventListener var2);

    public static final native void eal_IEventListener_process(long var0, IEventListener var2, long var3, IEvent var5);

    public static final native long eal_IEventListener_getTypes(long var0, IEventListener var2);

    public static final native boolean eal_IEventListener_attach(long var0, IEventListener var2, long var3, IManager var5);

    public static final native boolean eal_IEventListener_detach(long var0, IEventListener var2);

    public static final native void delete_eal_IEventMerge(long var0);

    public static final native String eal_IEventMerge_getFile(long var0, IEventMerge var2);

    public static final native String eal_IEventMerge_getScreenMainPath(long var0, IEventMerge var2);

    public static final native void eal_IEventMerge_setIndex(long var0, IEventMerge var2, long var3);

    public static final native long eal_IEventMerge_getIndex(long var0, IEventMerge var2);

    public static final native boolean eal_IEventMerge_isIndex(long var0, IEventMerge var2);

    public static final native void delete_eal_IEventImage(long var0);

    public static final native String eal_IEventImage_getFile(long var0, IEventImage var2);

    public static final native long eal_IEventImage_getImage(long var0, IEventImage var2);

    public static final native void delete_eal_IEventImageSave(long var0);

    public static final native void delete_eal_IEventFontGroup(long var0);

    public static final native long eal_IEventFontGroup_requestFontgroup(long var0, IEventFontGroup var2);

    public static final native long new_eal_IInputListener(long var0, IManager var2);

    public static final native void delete_eal_IInputListener(long var0);

    public static final native void eal_IInputListener_mouseEvent(long var0, IInputListener var2, int var3, int var4, int var5);

    public static final native void eal_IInputListener_mouseEventSwigExplicitIInputListener(long var0, IInputListener var2, int var3, int var4, int var5);

    public static final native void eal_IInputListener_director_connect(IInputListener var0, long var1, boolean var3, boolean var4);

    public static final native void eal_IInputListener_change_ownership(IInputListener var0, long var1, boolean var3);

    public static final native long new_eal_CAbstractEventListener(long var0, IManager var2, long var3, FlagEvent var5);

    public static final native void delete_eal_CAbstractEventListener(long var0);

    public static final native String eal_CAbstractEventListener_getName(long var0, CAbstractEventListener var2);

    public static final native String eal_CAbstractEventListener_getNameSwigExplicitCAbstractEventListener(long var0, CAbstractEventListener var2);

    public static final native void eal_CAbstractEventListener_process(long var0, CAbstractEventListener var2, long var3, IEvent var5);

    public static final native void eal_CAbstractEventListener_processSwigExplicitCAbstractEventListener(long var0, CAbstractEventListener var2, long var3, IEvent var5);

    public static final native void eal_CAbstractEventListener_dispose(long var0, CAbstractEventListener var2);

    public static final native void eal_CAbstractEventListener_director_connect(CAbstractEventListener var0, long var1, boolean var3, boolean var4);

    public static final native void eal_CAbstractEventListener_change_ownership(CAbstractEventListener var0, long var1, boolean var3);

    public static final native long new_eal_CMatrix4x4f();

    public static final native void delete_eal_CMatrix4x4f(long var0);

    public static final native long eal_CMatrix4x4f_interpolate(long var0, CMatrix4x4f var2, long var3, CMatrix4x4f var5, float var6);

    public static final native long new_eal_CQuaternion__SWIG_0();

    public static final native long new_eal_CQuaternion__SWIG_1(long var0, Vec3f var2, float var3);

    public static final native long new_eal_CQuaternion__SWIG_2(long var0, Mat4f var2);

    public static final native void delete_eal_CQuaternion(long var0);

    public static final native long eal_CQuaternion_createIdentity();

    public static final native void eal_CQuaternion_normalize(long var0, CQuaternion var2);

    public static final native void eal_CQuaternion_inverse(long var0, CQuaternion var2);

    public static final native long eal_CQuaternion_slerp(long var0, CQuaternion var2, long var3, CQuaternion var5, float var6);

    public static final native long eal_CQuaternion_toMatrix4x4(long var0, CQuaternion var2);

    public static final native long eal_CQuaternion_toMatrix(long var0, CQuaternion var2);

    public static final native long new_eal_CMergeInfo();

    public static final native void delete_eal_CMergeInfo(long var0);

    public static final native long eal_CMergeInfo_getId(long var0, CMergeInfo var2);

    public static final native String eal_CMergeInfo_getPath(long var0, CMergeInfo var2);

    public static final native void eal_CMergeInfo_dispose(long var0, CMergeInfo var2);

    public static final native void delete_eal_CTimeProvider(long var0);

    public static final native BigInteger eal_CTimeProvider_getTime();

    public static final native BigInteger eal_CTimeProvider_getDeltaTime();

    public static final native long new_eal_CTimeProvider();

    public static final native long new_eal_ICacheCallback();

    public static final native void delete_eal_ICacheCallback(long var0);

    public static final native void eal_ICacheCallback_destroy(long var0, ICacheCallback var2, int var3);

    public static final native void eal_ICacheCallback_destroySwigExplicitICacheCallback(long var0, ICacheCallback var2, int var3);

    public static final native void eal_ICacheCallback_director_connect(ICacheCallback var0, long var1, boolean var3, boolean var4);

    public static final native void eal_ICacheCallback_change_ownership(ICacheCallback var0, long var1, boolean var3);

    public static final native long new_eal_CCacheLRU__SWIG_0(long var0, IProject var2, int var3, int var4);

    public static final native long new_eal_CCacheLRU__SWIG_1(long var0, IProject var2, int var3, int var4);

    public static final native void delete_eal_CCacheLRU(long var0);

    public static final native boolean eal_CCacheLRU_defineImage(long var0, CCacheLRU var2, int var3, String var4, long var5, FlagImage var7);

    public static final native boolean eal_CCacheLRU_defineTexture(long var0, CCacheLRU var2, int var3, int var4, long var5, FlagTexture var7);

    public static final native long eal_CCacheLRU_getImage(long var0, CCacheLRU var2, int var3);

    public static final native long eal_CCacheLRU_getTexture(long var0, CCacheLRU var2, int var3);

    public static final native boolean eal_CCacheLRU_returnObject(long var0, CCacheLRU var2, int var3);

    public static final native void eal_CCacheLRU_dump(long var0, CCacheLRU var2);

    public static final native boolean eal_CCacheLRU_isIdentifier(long var0, CCacheLRU var2, int var3);

    public static final native boolean eal_CCacheLRU_setCallback(long var0, CCacheLRU var2, long var3, ICacheCallback var5);

    public static final native boolean eal_CCacheLRU_destroyIdentifier(long var0, CCacheLRU var2, int var3);

    public static final native void delete_eal_api_IObject(long var0);

    public static final native boolean eal_api_IObject_isDisposed(long var0, IObject var2);

    public static final native boolean eal_api_IObject_equals(long var0, IObject var2, long var3, IObject var5);

    public static final native boolean eal_api_IObject_isValid(long var0, IObject var2);

    public static final native void eal_api_IObject_dispose(long var0, IObject var2);

    public static final native void delete_eal_api_IAnimation(long var0);

    public static final native boolean eal_api_IAnimation_setTargetPropertyBlendIntensity(long var0, IAnimation var2);

    public static final native boolean eal_api_IAnimation_isValid(long var0, IAnimation var2);

    public static final native void eal_api_IAnimation_dispose(long var0, IAnimation var2);

    public static final native boolean eal_api_IAnimation_getValue(long var0, IAnimation var2, long var3, float[] var5);

    public static final native String eal_api_IAnimation_getName(long var0, IAnimation var2);

    public static final native void delete_eal_api_IAnimationClip(long var0);

    public static final native boolean eal_api_IAnimationClip_setStartTime(long var0, IAnimationClip var2, float var3);

    public static final native boolean eal_api_IAnimationClip_setRepeat(long var0, IAnimationClip var2, int var3);

    public static final native int eal_api_IAnimationClip_getUniqueId(long var0, IAnimationClip var2);

    public static final native float eal_api_IAnimationClip_getDuration(long var0, IAnimationClip var2);

    public static final native float eal_api_IAnimationClip_getStartTime(long var0, IAnimationClip var2);

    public static final native float eal_api_IAnimationClip_getEndTime(long var0, IAnimationClip var2);

    public static final native boolean eal_api_IAnimationClip_isValid(long var0, IAnimationClip var2);

    public static final native void eal_api_IAnimationClip_dispose(long var0, IAnimationClip var2);

    public static final native long eal_api_IAnimationClip_getSize(long var0, IAnimationClip var2);

    public static final native long eal_api_IAnimationClip_getAnimation(long var0, IAnimationClip var2, long var3);

    public static final native long new_eal_api_IAnimationPlayer(long var0, IProject var2);

    public static final native void delete_eal_api_IAnimationPlayer(long var0);

    public static final native boolean eal_api_IAnimationPlayer_add__SWIG_0(long var0, IAnimationPlayer var2, long var3, IAnimationClip var5);

    public static final native boolean eal_api_IAnimationPlayer_add__SWIG_1(long var0, IAnimationPlayer var2, long var3, ITimeLineSequence var5);

    public static final native boolean eal_api_IAnimationPlayer_remove(long var0, IAnimationPlayer var2, long var3, IAnimationClip var5);

    public static final native void eal_api_IAnimationPlayer_play(long var0, IAnimationPlayer var2);

    public static final native void eal_api_IAnimationPlayer_pause(long var0, IAnimationPlayer var2);

    public static final native boolean eal_api_IAnimationPlayer_isValid(long var0, IAnimationPlayer var2);

    public static final native void eal_api_IAnimationPlayer_dispose(long var0, IAnimationPlayer var2);

    public static final native int eal_api_ITimeLineSequence_RETURN_INVALID_get();

    public static final native void delete_eal_api_ITimeLineSequence(long var0);

    public static final native boolean eal_api_ITimeLineSequence_isValid(long var0, ITimeLineSequence var2);

    public static final native boolean eal_api_ITimeLineSequence_setContext(long var0, ITimeLineSequence var2, long var3, long var5, INode var7);

    public static final native boolean eal_api_ITimeLineSequence_setTarget__SWIG_0(long var0, ITimeLineSequence var2, long var3, long var5, ITimeLineSequence var7);

    public static final native boolean eal_api_ITimeLineSequence_setTarget__SWIG_1(long var0, ITimeLineSequence var2, long var3, long var5, IAnimationClip var7);

    public static final native long eal_api_ITimeLineSequence_getTarget(long var0, ITimeLineSequence var2, long var3);

    public static final native int eal_api_ITimeLineSequence_cloneEntry(long var0, ITimeLineSequence var2, long var3);

    public static final native boolean eal_api_ITimeLineSequence_setInputProperty(long var0, ITimeLineSequence var2, long var3, long var5, INode var7, long var8, IProperty var10);

    public static final native void eal_api_ITimeLineSequence_print(long var0, ITimeLineSequence var2);

    public static final native void eal_api_ITimeLineSequence_dispose(long var0, ITimeLineSequence var2);

    public static final native boolean eal_api_ITimeLineSequence_makeEntryDirty(long var0, ITimeLineSequence var2, long var3);

    public static final native void delete_eal_api_IContext(long var0);

    public static final native boolean eal_api_IContext_setVSync(long var0, IContext var2, boolean var3);

    public static final native void eal_api_IContext_disableDepthBuffer(long var0, IContext var2);

    public static final native boolean eal_api_IContext_setWidth(long var0, IContext var2, long var3);

    public static final native boolean eal_api_IContext_setHeight(long var0, IContext var2, long var3);

    public static final native long eal_api_IContext_getScreenData(long var0, IContext var2);

    public static final native boolean eal_api_IContext_setDisplayId(long var0, IContext var2, long var3);

    public static final native long eal_api_IContext_getDisplayId(long var0, IContext var2);

    public static final native boolean eal_api_IContext_setAnnotation(long var0, IContext var2, boolean var3);

    public static final native boolean eal_api_IContext_isValid(long var0, IContext var2);

    public static final native boolean eal_api_IContext_getScreenResolution(long var0, IContext var2, long var3, displaySize_t var5);

    public static final native void eal_api_IContext_dispose(long var0, IContext var2);

    public static final native void delete_eal_api_IFactory(long var0);

    public static final native boolean eal_api_IFactory_dereference(long var0, IObject var2);

    public static final native boolean eal_api_IFactory_destroy__SWIG_0(long var0, INode var2, boolean var3);

    public static final native boolean eal_api_IFactory_destroy__SWIG_1(long var0, INode var2);

    public static final native boolean eal_api_IFactory_destroy__SWIG_2(long var0, IProject var2);

    public static final native long eal_api_IFactory_requestEventImage__SWIG_0(long var0, IManager var2, String var3, long var4, FlagImage var6);

    public static final native long eal_api_IFactory_requestEventImage__SWIG_1(long var0, IManager var2, String var3, long var4, FlagImage var6, long var7, long var9);

    public static final native long eal_api_IFactory_requestEventImageSave(long var0, IImage var2, String var3, int var4);

    public static final native long eal_api_IFactory_requestEventFontGroup(long var0, IManager var2);

    public static final native long new_eal_api_IManager();

    public static final native void delete_eal_api_IManager(long var0);

    public static final native boolean eal_api_IManager_start(long var0, IManager var2);

    public static final native boolean eal_api_IManager_stop(long var0, IManager var2);

    public static final native long eal_api_IManager_getContext(long var0, IManager var2);

    public static final native long eal_api_IManager_load(long var0, IManager var2, String var3);

    public static final native long eal_api_IManager_getDefaultProject(long var0, IManager var2);

    public static final native long eal_api_IManager_createDefaultProject(long var0, IManager var2);

    public static final native boolean eal_api_IManager_setDefaultProject(long var0, IManager var2, long var3, IProject var5);

    public static final native boolean eal_api_IManager_destroyDefaultProject(long var0, IManager var2, long var3, IProject var5);

    public static final native void eal_api_IManager_printMemoryStatus(long var0, IManager var2);

    public static final native long eal_api_IManager_getMemoryVRAM(long var0, IManager var2);

    public static final native long eal_api_IManager_getMemoryRAM(long var0, IManager var2);

    public static final native long eal_api_IManager_getMemoryRAMFree(long var0, IManager var2);

    public static final native boolean eal_api_IManager_setMemorySize(long var0, IManager var2, long var3);

    public static final native boolean eal_api_IManager_isValid(long var0, IManager var2);

    public static final native long eal_api_IManager_getRenderer(long var0, IManager var2);

    public static final native void eal_api_IManager_dispose(long var0, IManager var2);

    public static final native boolean eal_api_IManager_dumpFontCaches(long var0, IManager var2, String var3);

    public static final native String eal_api_IManager_triggerDump();

    public static final native long eal_api_IManager_layout(long var0, IManager var2, long var3, ITextLayout var5, String var6);

    public static final native boolean eal_api_IManager_layoutGetWidth(long var0, IManager var2, long var3, ITextLayoutResult var5, int[] var6, int var7);

    public static final native boolean eal_api_IManager_computeAvailableGlyphs(long var0, IManager var2, String var3, long var4, ITextLayout var6, long var7, glyphInformation_t var9);

    public static final native boolean eal_api_IManager_isMerged(long var0, IManager var2, long var3, IProject var5, String var6);

    public static final native boolean eal_api_IManager_execute__SWIG_0(long var0, IManager var2, long var3, IEventImage var5);

    public static final native boolean eal_api_IManager_execute__SWIG_1(long var0, IManager var2, long var3, IEventImageSave var5);

    public static final native boolean eal_api_IManager_execute__SWIG_2(long var0, IManager var2, long var3, IEventFontGroup var5);

    public static final native void eal_api_IManager_setObjectTracer(long var0, IManager var2, boolean var3);

    public static final native void eal_api_IManager_dumpObjects(long var0, IManager var2);

    public static final native void eal_api_IManager_dumpProfiling(long var0, IManager var2);

    public static final native void eal_api_IManager_dumpRegistry(long var0, IManager var2);

    public static final native void eal_api_IManager_dumpMemory(long var0, IManager var2);

    public static final native void eal_api_IManager_dumpResources(long var0, IManager var2);

    public static final native void eal_api_IManager_setRegistry(long var0, IManager var2, boolean var3);

    public static final native void eal_api_IManager_setObjectWarnLimit(long var0, IManager var2, long var3);

    public static final native boolean eal_api_IManager_setOpacityInvalidationInherit(long var0, IManager var2, boolean var3);

    public static final native boolean eal_api_IManager_setEventThreadNumber(long var0, IManager var2, long var3);

    public static final native boolean eal_api_IManager_setFontDpi(long var0, IManager var2, int var3);

    public static final native int eal_api_IManager_getCurrentFontDpi(long var0, IManager var2);

    public static final native void delete_eal_api_IProject(long var0);

    public static final native long eal_api_IProject_getScene(long var0, IProject var2, String var3);

    public static final native long eal_api_IProject_getAnimationClip(long var0, IProject var2, String var3);

    public static final native long eal_api_IProject_getAnimation(long var0, IProject var2, String var3);

    public static final native long eal_api_IProject_getNode(long var0, IProject var2, String var3);

    public static final native long eal_api_IProject_getNode2D(long var0, IProject var2, String var3);

    public static final native long eal_api_IProject_getNode2DImage(long var0, IProject var2, String var3);

    public static final native long eal_api_IProject_getNode3D(long var0, IProject var2, String var3);

    public static final native long eal_api_IProject_getNode3DMesh(long var0, IProject var2, String var3);

    public static final native long eal_api_IProject_getNode3DCamera(long var0, IProject var2, String var3);

    public static final native long eal_api_IProject_getMaterial(long var0, IProject var2, String var3);

    public static final native long eal_api_IProject_getNode2DLink(long var0, IProject var2, String var3);

    public static final native long eal_api_IProject_getMeshData(long var0, IProject var2, String var3);

    public static final native long eal_api_IProject_getTimeLineSequence(long var0, IProject var2, String var3);

    public static final native long eal_api_IProject_getTemplateNode2D(long var0, IProject var2, String var3);

    public static final native long eal_api_IProject_getTemplateNode3D(long var0, IProject var2, String var3);

    public static final native long eal_api_IProject_getTexture(long var0, IProject var2, String var3);

    public static final native boolean eal_api_IProject_merge__SWIG_0(long var0, IProject var2, int var3, String var4, long var5, CMergeInfo var7, long var8, FlagMerge var10);

    public static final native boolean eal_api_IProject_merge__SWIG_1(long var0, IProject var2, int var3, String var4, long var5, CMergeInfo var7);

    public static final native boolean eal_api_IProject_merge__SWIG_2(long var0, IProject var2, int var3, String var4);

    public static final native boolean eal_api_IProject_isValid(long var0, IProject var2);

    public static final native boolean eal_api_IProject_setMainScene(long var0, IProject var2, long var3, INode3DScene var5);

    public static final native boolean eal_api_IProject_setScreenMain(long var0, IProject var2, long var3, INode2D var5);

    public static final native long eal_api_IProject_getScreenMain(long var0, IProject var2);

    public static final native boolean eal_api_IProject_isScreenMain(long var0, IProject var2);

    public static final native int eal_api_IProject_getTypeOfPath(long var0, IProject var2, String var3);

    public static final native boolean eal_api_IProject_setRenderpass(long var0, IProject var2, String var3, boolean var4);

    public static final native boolean eal_api_IProject_isNode(long var0, IProject var2, String var3);

    public static final native boolean eal_api_IProject_isPrefab(long var0, IProject var2, String var3);

    public static final native boolean eal_api_IProject_isAnimationClip(long var0, IProject var2, String var3);

    public static final native long eal_api_IProject_getDefaultTimeLineSequence(long var0, IProject var2);

    public static final native void eal_api_IProject_dispose(long var0, IProject var2);

    public static final native boolean eal_api_IProject_registerNode(long var0, IProject var2, long var3, INode var5, String var6);

    public static final native void eal_api_IProject_list__SWIG_0(long var0, IProject var2, int var3, boolean var4);

    public static final native void eal_api_IProject_list__SWIG_1(long var0, IProject var2, int var3);

    public static final native boolean eal_api_IProject_list__SWIG_2(long var0, IProject var2, int var3, String var4);

    public static final native long new_eal_api_IImage__SWIG_0(long var0, IManager var2, String var3);

    public static final native long new_eal_api_IImage__SWIG_1(long var0, IManager var2, String var3, long var4, FlagImage var6);

    public static final native long new_eal_api_IImage__SWIG_2(long var0, IManager var2, String var3, long var4, FlagImage var6, long var7, long var9);

    public static final native long new_eal_api_IImage__SWIG_3(long var0, IManager var2, ByteBuffer var3, long var4);

    public static final native long new_eal_api_IImage__SWIG_4(long var0, IManager var2, ByteBuffer var3, long var4, long var6);

    public static final native long new_eal_api_IImage__SWIG_5(long var0, IManager var2, ByteBuffer var3, long var4, long var6, long var8, FlagImage var10);

    public static final native void delete_eal_api_IImage(long var0);

    public static final native ByteBuffer eal_api_IImage_getData(long var0, IImage var2);

    public static final native long eal_api_IImage_getSize(long var0, IImage var2);

    public static final native boolean eal_api_IImage_isValid(long var0, IImage var2);

    public static final native long eal_api_IImage_getWidth(long var0, IImage var2);

    public static final native long eal_api_IImage_getHeight(long var0, IImage var2);

    public static final native void eal_api_IImage_dispose(long var0, IImage var2);

    public static final native boolean eal_api_IImage_destroy(long var0, IImage var2);

    public static final native boolean eal_api_IImage_save(long var0, IImage var2, String var3, int var4);

    public static final native boolean eal_api_IImage_addText(long var0, IImage var2, long var3, IFont var5, int var6, String var7);

    public static final native long eal_api_IImage_getImageInfo__SWIG_0(String var0);

    public static final native long eal_api_IImage_getImageInfo__SWIG_1(ByteBuffer var0, long var1);

    public static final native void delete_eal_api_IImageAsync(long var0);

    public static final native long new_eal_api_IImageAsync__SWIG_0(ByteBuffer var0, long var1);

    public static final native long new_eal_api_IImageAsync__SWIG_1(ByteBuffer var0, long var1, long var3, long var5, long var7, FlagImage var9);

    public static final native boolean eal_api_IImageAsync_isValid(long var0, IImageAsync var2);

    public static final native boolean eal_api_IImageAsync_destroy(long var0, IImageAsync var2);

    public static final native long eal_api_IImageAsync_getWidth(long var0, IImageAsync var2);

    public static final native long eal_api_IImageAsync_getHeight(long var0, IImageAsync var2);

    public static final native void delete_eal_api_IMeshData(long var0);

    public static final native boolean eal_api_IMeshData_morph(long var0, IMeshData var2, long var3, IMeshData var5, long var6, float var8);

    public static final native boolean eal_api_IMeshData_isValid(long var0, IMeshData var2);

    public static final native void eal_api_IMeshData_dispose(long var0, IMeshData var2);

    public static final native long new_eal_api_ITexture__SWIG_0(long var0, IProject var2, long var3, IImage var5);

    public static final native long new_eal_api_ITexture__SWIG_1(long var0, IProject var2, long var3, IImage var5, long var6, FlagTexture var8);

    public static final native long new_eal_api_ITexture__SWIG_2(long var0, IProject var2, long var3, IImageAsync var5, long var6, FlagTexture var8);

    public static final native void delete_eal_api_ITexture(long var0);

    public static final native boolean eal_api_ITexture_isValid(long var0, ITexture var2);

    public static final native void eal_api_ITexture_dispose(long var0, ITexture var2);

    public static final native boolean eal_api_ITexture_destroy(long var0, ITexture var2);

    public static final native long eal_api_ITexture_getWidth(long var0, ITexture var2);

    public static final native long eal_api_ITexture_getHeight(long var0, ITexture var2);

    public static final native boolean eal_api_ITexture_getData(long var0, ITexture var2, ByteBuffer var3);

    public static final native boolean eal_api_ITexture_testIfReferenced(long var0, ITexture var2);

    public static final native long eal_api_ITexture_getProperty(long var0, ITexture var2, String var3);

    public static final native long new_eal_api_ITextureShared(long var0, IProject var2, String var3, long var4, long var6);

    public static final native void delete_eal_api_ITextureShared(long var0);

    public static final native boolean eal_api_ITextureShared_updateFromDisplay(long var0, ITextureShared var2, long var3);

    public static final native boolean eal_api_ITextureShared_updateFromDisplayable__SWIG_0(long var0, ITextureShared var2, long var3);

    public static final native boolean eal_api_ITextureShared_updateFromDisplayable__SWIG_1(long var0, ITextureShared var2, long var3, long var5, long var7, long var9, long var11);

    public static final native void eal_api_ITextureShared_dispose(long var0, ITextureShared var2);

    public static final native boolean eal_api_ITextureShared_destroy(long var0, ITextureShared var2);

    public static final native long new_eal_api_ITextureAtlas(long var0, IProject var2, String var3);

    public static final native void delete_eal_api_ITextureAtlas(long var0);

    public static final native long eal_api_ITextureAtlas_getTexture(long var0, ITextureAtlas var2, long var3);

    public static final native boolean eal_api_ITextureAtlas_isValid(long var0, ITextureAtlas var2);

    public static final native void eal_api_ITextureAtlas_dispose(long var0, ITextureAtlas var2);

    public static final native boolean eal_api_ITextureAtlas_destroy(long var0, ITextureAtlas var2);

    public static final native long new_eal_api_ITextureOffscreen__SWIG_0(long var0, IProject var2, String var3, long var4, long var6);

    public static final native long new_eal_api_ITextureOffscreen__SWIG_1(long var0, IProject var2, String var3, long var4, long var6, long var8, FlagTexture var10);

    public static final native long new_eal_api_ITextureOffscreen__SWIG_2(long var0, IProject var2, String var3, long var4, long var6, long var8, FlagTexture var10, boolean var11);

    public static final native void delete_eal_api_ITextureOffscreen(long var0);

    public static final native void delete_eal_api_IMaterial(long var0);

    public static final native boolean eal_api_IMaterial_isValid(long var0, IMaterial var2);

    public static final native boolean eal_api_IMaterial_setTexture__SWIG_0(long var0, IMaterial var2, long var3, ITexture var5, String var6);

    public static final native boolean eal_api_IMaterial_setTexture__SWIG_1(long var0, IMaterial var2, long var3, ITexture var5);

    public static final native long eal_api_IMaterial_getProperty(long var0, IMaterial var2, String var3);

    public static final native void eal_api_IMaterial_dispose(long var0, IMaterial var2);

    public static final native boolean eal_api_IMaterial_setBlendMode(long var0, IMaterial var2, int var3);

    public static final native void delete_eal_api_IProperty(long var0);

    public static final native boolean eal_api_IProperty_set__SWIG_0(long var0, IProperty var2, int var3);

    public static final native boolean eal_api_IProperty_set__SWIG_1(long var0, IProperty var2, float var3);

    public static final native boolean eal_api_IProperty_set__SWIG_2(long var0, IProperty var2, boolean var3);

    public static final native boolean eal_api_IProperty_set__SWIG_3(long var0, IProperty var2, String var3);

    public static final native boolean eal_api_IProperty_set__SWIG_4(long var0, IProperty var2, long var3, colorRGBAf var5);

    public static final native boolean eal_api_IProperty_setColor(long var0, IProperty var2, long var3);

    public static final native boolean eal_api_IProperty_set__SWIG_5(long var0, IProperty var2, long var3, ITexture var5);

    public static final native boolean eal_api_IProperty_set__SWIG_6(long var0, IProperty var2, long var3, INode3D var5);

    public static final native boolean eal_api_IProperty_set__SWIG_7(long var0, IProperty var2, long var3, IMaterial var5);

    public static final native boolean eal_api_IProperty_set__SWIG_8(long var0, IProperty var2, long var3, Vec2f var5);

    public static final native boolean eal_api_IProperty_set__SWIG_9(long var0, IProperty var2, long var3, Vec3f var5);

    public static final native boolean eal_api_IProperty_set__SWIG_10(long var0, IProperty var2, long var3, Vec4f var5);

    public static final native boolean eal_api_IProperty_setDefault(long var0, IProperty var2);

    public static final native int eal_api_IProperty_getInt(long var0, IProperty var2);

    public static final native float eal_api_IProperty_getFloat(long var0, IProperty var2);

    public static final native boolean eal_api_IProperty_getBool(long var0, IProperty var2);

    public static final native String eal_api_IProperty_getString(long var0, IProperty var2);

    public static final native long eal_api_IProperty_getColor(long var0, IProperty var2);

    public static final native long eal_api_IProperty_getColorAsInt(long var0, IProperty var2);

    public static final native long eal_api_IProperty_getVec2D(long var0, IProperty var2);

    public static final native long eal_api_IProperty_getVec3D(long var0, IProperty var2);

    public static final native long eal_api_IProperty_getVec4D(long var0, IProperty var2);

    public static final native long eal_api_IProperty_getTexture(long var0, IProperty var2);

    public static final native long eal_api_IProperty_getNode3D(long var0, IProperty var2);

    public static final native long eal_api_IProperty_getMaterial(long var0, IProperty var2);

    public static final native boolean eal_api_IProperty_isValid(long var0, IProperty var2);

    public static final native int eal_api_IProperty_getType(long var0, IProperty var2);

    public static final native void eal_api_IProperty_dispose(long var0, IProperty var2);

    public static final native boolean eal_api_IProperty_remove(long var0, IProperty var2);

    public static final native String eal_api_IProperty_getName(long var0, IProperty var2);

    public static final native long eal_api_IProperty_getMatrix3x3(long var0, IProperty var2);

    public static final native long eal_api_IProperty_getMatrix4x4(long var0, IProperty var2);

    public static final native void delete_eal_api_IRenderer(long var0);

    public static final native boolean eal_api_IRenderer_render__SWIG_0(long var0, IRenderer var2, long var3, INode2D var5);

    public static final native boolean eal_api_IRenderer_render__SWIG_1(long var0, IRenderer var2, long var3, IProject var5);

    public static final native boolean eal_api_IRenderer_isValid(long var0, IRenderer var2);

    public static final native boolean eal_api_IRenderer_setHud(long var0, IRenderer var2, boolean var3);

    public static final native boolean eal_api_IRenderer_setSleepMode(long var0, IRenderer var2, boolean var3);

    public static final native void eal_api_IRenderer_dispose(long var0, IRenderer var2);

    public static final native boolean eal_api_IRenderer_render__SWIG_2(long var0, IRenderer var2);

    public static final native boolean eal_api_IRenderer_record(long var0, IRenderer var2, boolean var3, String var4, float var5, long var6);

    public static final native boolean eal_api_IRenderer_isRecording(long var0, IRenderer var2);

    public static final native long new_eal_api_IRendererAnnotation(long var0, IRenderer var2);

    public static final native void delete_eal_api_IRendererAnnotation(long var0);

    public static final native boolean eal_api_IRendererAnnotation_setData__SWIG_0(long var0, IRendererAnnotation var2, short var3, String var4);

    public static final native boolean eal_api_IRendererAnnotation_setData__SWIG_1(long var0, IRendererAnnotation var2, short var3, ByteBuffer var4, long var5);

    public static final native boolean eal_api_IRendererAnnotation_isValid(long var0, IRendererAnnotation var2);

    public static final native void eal_api_IRendererAnnotation_dispose(long var0, IRendererAnnotation var2);

    public static final native boolean eal_api_IRendererAnnotation_setErrorCorrection(long var0, IRendererAnnotation var2, boolean var3);

    public static final native void delete_eal_api_IINodeImage(long var0);

    public static final native boolean eal_api_IINodeImage_setTexture(long var0, IINodeImage var2, long var3, ITexture var5);

    public static final native boolean eal_api_IINodeImage_isValid(long var0, IINodeImage var2);

    public static final native void eal_api_IINodeImage_dispose(long var0, IINodeImage var2);

    public static final native boolean eal_api_IINodeImage_setModulateColor__SWIG_0(long var0, IINodeImage var2, long var3, colorRGBAf var5);

    public static final native boolean eal_api_IINodeImage_setModulateColor__SWIG_1(long var0, IINodeImage var2, long var3);

    public static final native boolean eal_api_IINodeImage_clipImage(long var0, IINodeImage var2, float var3, float var4, float var5, float var6);

    public static final native void delete_eal_api_IINodeText(long var0);

    public static final native boolean eal_api_IINodeText_setText__SWIG_0(long var0, IINodeText var2, long var3, IFont var5, int var6, String var7);

    public static final native boolean eal_api_IINodeText_setText__SWIG_1(long var0, IINodeText var2, int var3, String var4);

    public static final native boolean eal_api_IINodeText_setText__SWIG_2(long var0, IINodeText var2, long var3, ITextLayout var5, String var6);

    public static final native boolean eal_api_IINodeText_setText__SWIG_3(long var0, IINodeText var2, long var3, ITextLayoutResult var5);

    public static final native boolean eal_api_IINodeText_setColor__SWIG_0(long var0, IINodeText var2, long var3, colorRGBAf var5);

    public static final native boolean eal_api_IINodeText_setColor__SWIG_1(long var0, IINodeText var2, long var3);

    public static final native long eal_api_IINodeText_getWidth(long var0, IINodeText var2);

    public static final native long eal_api_IINodeText_getHeight(long var0, IINodeText var2);

    public static final native long eal_api_IINodeText_getAscent(long var0, IINodeText var2);

    public static final native long eal_api_IINodeText_getDescent(long var0, IINodeText var2);

    public static final native boolean eal_api_IINodeText_isValid(long var0, IINodeText var2);

    public static final native void eal_api_IINodeText_dispose(long var0, IINodeText var2);

    public static final native boolean eal_api_IINodeText_setFading__SWIG_0(long var0, IINodeText var2, float var3, float var4);

    public static final native boolean eal_api_IINodeText_setFading__SWIG_1(long var0, IINodeText var2, float var3, float var4, boolean var5);

    public static final native void delete_eal_api_INode(long var0);

    public static final native boolean eal_api_INode_clear(long var0, INode var2);

    public static final native boolean eal_api_INode_remove__SWIG_0(long var0, INode var2, long var3, INode var5);

    public static final native boolean eal_api_INode_remove__SWIG_1(long var0, INode var2, long var3);

    public static final native long eal_api_INode_getChildCount(long var0, INode var2);

    public static final native boolean eal_api_INode_hasChild(long var0, INode var2, long var3, INode var5);

    public static final native boolean eal_api_INode_setVisible(long var0, INode var2, boolean var3);

    public static final native boolean eal_api_INode_isVisible(long var0, INode var2);

    public static final native boolean eal_api_INode_isValid(long var0, INode var2);

    public static final native boolean eal_api_INode_isParent(long var0, INode var2);

    public static final native boolean eal_api_INode_hasProperty(long var0, INode var2, String var3);

    public static final native long eal_api_INode_getProperty__SWIG_0(long var0, INode var2, String var3);

    public static final native long eal_api_INode_getProperty__SWIG_1(long var0, INode var2, String var3, int var4);

    public static final native void eal_api_INode_print__SWIG_0(long var0, INode var2);

    public static final native void eal_api_INode_print__SWIG_1(long var0, INode var2, long var3, FlagPrint var5);

    public static final native void eal_api_INode_printAllProperties(long var0, INode var2);

    public static final native boolean eal_api_INode_equals(long var0, INode var2, long var3, IObject var5);

    public static final native String eal_api_INode_getName(long var0, INode var2);

    public static final native boolean eal_api_INode_setName(long var0, INode var2, String var3);

    public static final native boolean eal_api_INode_copyProperty(long var0, INode var2, long var3, INode var5, long var6, IProperty var8);

    public static final native boolean eal_api_INode_setOpacity__SWIG_0(long var0, INode var2, float var3, boolean var4);

    public static final native boolean eal_api_INode_setOpacity__SWIG_1(long var0, INode var2, float var3);

    public static final native float eal_api_INode_getOpacity(long var0, INode var2);

    public static final native float eal_api_INode_getOpacityRecursive(long var0, INode var2);

    public static final native void eal_api_INode_dispose(long var0, INode var2);

    public static final native boolean eal_api_INode_invalidateObject(long var0, INode var2);

    public static final native boolean eal_api_INode_invalidateTree(long var0, INode var2);

    public static final native int eal_api_INode_getType(long var0, INode var2);

    public static final native long new_eal_api_INode2D__SWIG_0(long var0, INode var2);

    public static final native long new_eal_api_INode2D__SWIG_1(long var0, IProject var2, String var3);

    public static final native void delete_eal_api_INode2D(long var0);

    public static final native boolean eal_api_INode2D_scale__SWIG_0(long var0, INode2D var2, float var3);

    public static final native boolean eal_api_INode2D_scale__SWIG_1(long var0, INode2D var2, float var3, float var4);

    public static final native boolean eal_api_INode2D_setScale__SWIG_0(long var0, INode2D var2, float var3);

    public static final native boolean eal_api_INode2D_setScale__SWIG_1(long var0, INode2D var2, float var3, float var4);

    public static final native boolean eal_api_INode2D_translate(long var0, INode2D var2, float var3, float var4);

    public static final native boolean eal_api_INode2D_setTranslation(long var0, INode2D var2, float var3, float var4);

    public static final native long eal_api_INode2D_getTranslation(long var0, INode2D var2);

    public static final native boolean eal_api_INode2D_rotate(long var0, INode2D var2, float var3);

    public static final native boolean eal_api_INode2D_setRotation(long var0, INode2D var2, float var3);

    public static final native float eal_api_INode2D_getRotation(long var0, INode2D var2);

    public static final native long eal_api_INode2D_getParent(long var0, INode2D var2);

    public static final native long eal_api_INode2D_getChildAtIndex(long var0, INode2D var2, long var3);

    public static final native long eal_api_INode2D_getChildByIndex(long var0, INode2D var2, int var3);

    public static final native long eal_api_INode2D_getChildByName(long var0, INode2D var2, String var3);

    public static final native boolean eal_api_INode2D_add__SWIG_0(long var0, INode2D var2, long var3, INode2D var5);

    public static final native boolean eal_api_INode2D_add__SWIG_1(long var0, INode2D var2, long var3, INode2D var5, long var6);

    public static final native boolean eal_api_INode2D_addByIndex(long var0, INode2D var2, long var3, INode2D var5, int var6);

    public static final native boolean eal_api_INode2D_resetTransformations(long var0, INode2D var2);

    public static final native boolean eal_api_INode2D_setTransformOrigin(long var0, INode2D var2, float var3, float var4);

    public static final native long eal_api_INode2D_getWidth(long var0, INode2D var2);

    public static final native long eal_api_INode2D_getHeight(long var0, INode2D var2);

    public static final native void eal_api_INode2D_dispose(long var0, INode2D var2);

    public static final native long eal_api_INode2D_enableOffscreen__SWIG_0(long var0, INode2D var2, long var3, long var5, long var7, FlagTexture var9);

    public static final native boolean eal_api_INode2D_enableOffscreen__SWIG_1(long var0, INode2D var2, long var3, ITexture var5);

    public static final native boolean eal_api_INode2D_disableOffscreen(long var0, INode2D var2);

    public static final native boolean eal_api_INode2D_setPixelFormat(long var0, INode2D var2, int var3);

    public static final native boolean eal_api_INode2D_setPartialRenderingDebug(long var0, INode2D var2, boolean var3);

    public static final native boolean eal_api_INode2D_move(long var0, INode2D var2, long var3, INode2D var5);

    public static final native long eal_api_INode2D_getTransformation(long var0, INode2D var2);

    public static final native boolean eal_api_INode2D_setTransformation(long var0, INode2D var2, long var3, Mat3f var5);

    public static final native long new_eal_api_INode2DHud(long var0, IProject var2, long var3, IFont var5, int var6, float var7, float var8);

    public static final native void delete_eal_api_INode2DHud(long var0);

    public static final native void eal_api_INode2DHud_dispose(long var0, INode2DHud var2);

    public static final native long new_eal_api_INode2DImage__SWIG_0(long var0, INode2D var2);

    public static final native long new_eal_api_INode2DImage__SWIG_1(long var0, IProject var2, String var3, boolean var4);

    public static final native long new_eal_api_INode2DImage__SWIG_2(long var0, IProject var2, String var3, long var4, ITexture var6);

    public static final native long new_eal_api_INode2DImage__SWIG_3(long var0, IProject var2, String var3, long var4, ITexture var6, boolean var7);

    public static final native void delete_eal_api_INode2DImage(long var0);

    public static final native boolean eal_api_INode2DImage_setModulateColor__SWIG_0(long var0, INode2DImage var2, long var3, colorRGBAf var5);

    public static final native boolean eal_api_INode2DImage_setModulateColor__SWIG_1(long var0, INode2DImage var2, long var3);

    public static final native boolean eal_api_INode2DImage_setTexture(long var0, INode2DImage var2, long var3, ITexture var5);

    public static final native long eal_api_INode2DImage_getInterfaceImage(long var0, INode2DImage var2);

    public static final native long eal_api_INode2DImage_getWidth(long var0, INode2DImage var2);

    public static final native long eal_api_INode2DImage_getHeight(long var0, INode2DImage var2);

    public static final native void eal_api_INode2DImage_dispose(long var0, INode2DImage var2);

    public static final native boolean eal_api_INode2DImage_clipImage(long var0, INode2DImage var2, float var3, float var4, float var5, float var6);

    public static final native long new_eal_api_INode2DLink(long var0, IProject var2, String var3);

    public static final native void delete_eal_api_INode2DLink(long var0);

    public static final native boolean eal_api_INode2DLink_setScene__SWIG_0(long var0, INode2DLink var2, long var3, INode3DScene var5);

    public static final native boolean eal_api_INode2DLink_setScene__SWIG_1(long var0, INode2DLink var2, long var3, INode3DScene var5, boolean var6);

    public static final native boolean eal_api_INode2DLink_unsetScene(long var0, INode2DLink var2);

    public static final native void eal_api_INode2DLink_dispose(long var0, INode2DLink var2);

    public static final native long eal_api_INode2DLink_enablePortal(long var0, INode2DLink var2, float var3, float var4, float var5, float var6, long var7, FlagTexture var9);

    public static final native boolean eal_api_INode2DLink_disablePortal(long var0, INode2DLink var2);

    public static final native long new_eal_api_INode2DManaged(long var0, IProject var2, String var3);

    public static final native void delete_eal_api_INode2DManaged(long var0);

    public static final native void eal_api_INode2DManaged_dispose(long var0, INode2DManaged var2);

    public static final native boolean eal_api_INode2DManaged_addToScreen__SWIG_0(long var0, INode2DManaged var2, long var3, INode2D var5);

    public static final native boolean eal_api_INode2DManaged_addToScreen__SWIG_1(long var0, INode2DManaged var2, long var3, INode2D var5, int var6);

    public static final native boolean eal_api_INode2DManaged_addOffscreen__SWIG_0(long var0, INode2DManaged var2, long var3, INode2D var5);

    public static final native boolean eal_api_INode2DManaged_addOffscreen__SWIG_1(long var0, INode2DManaged var2, long var3, INode2D var5, int var6);

    public static final native boolean eal_api_INode2DManaged_addAuto__SWIG_0(long var0, INode2DManaged var2, long var3, INode2D var5);

    public static final native boolean eal_api_INode2DManaged_addAuto__SWIG_1(long var0, INode2DManaged var2, long var3, INode2D var5, int var6);

    public static final native long eal_api_INode2DManaged_getFromScreenByName(long var0, INode2DManaged var2, String var3);

    public static final native long eal_api_INode2DManaged_getFromOffscreenByName(long var0, INode2DManaged var2, String var3);

    public static final native boolean eal_api_INode2DManaged_removeFromScreen(long var0, INode2DManaged var2, long var3, INode2D var5);

    public static final native boolean eal_api_INode2DManaged_setPartialRendering(long var0, INode2DManaged var2, boolean var3);

    public static final native boolean eal_api_INode2DManaged_setHud(long var0, INode2DManaged var2, boolean var3, long var4, IFont var6, int var7, float var8, float var9);

    public static final native boolean eal_api_INode2DManaged_refreshPartialRendering(long var0, INode2DManaged var2);

    public static final native boolean eal_api_INode2DManaged_setPartialRenderingColorBuffer(long var0, INode2DManaged var2, boolean var3);

    public static final native long new_eal_api_INode2DPartial(long var0, IProject var2, String var3);

    public static final native void delete_eal_api_INode2DPartial(long var0);

    public static final native void eal_api_INode2DPartial_dispose(long var0, INode2DPartial var2);

    public static final native long new_eal_api_INode2DText__SWIG_0(long var0, INode2D var2);

    public static final native long new_eal_api_INode2DText__SWIG_1(long var0, IProject var2, String var3, long var4, IFont var6, int var7, String var8);

    public static final native long new_eal_api_INode2DText__SWIG_2(long var0, IProject var2, String var3, int var4, String var5);

    public static final native long new_eal_api_INode2DText__SWIG_3(long var0, IProject var2, String var3, long var4, ITextLayout var6, String var7);

    public static final native long new_eal_api_INode2DText__SWIG_4(long var0, IProject var2, String var3, long var4, ITextLayoutResult var6);

    public static final native long new_eal_api_INode2DText__SWIG_5(long var0, IProject var2, String var3);

    public static final native void delete_eal_api_INode2DText(long var0);

    public static final native boolean eal_api_INode2DText_setText__SWIG_0(long var0, INode2DText var2, long var3, IFont var5, int var6, String var7);

    public static final native boolean eal_api_INode2DText_setText__SWIG_1(long var0, INode2DText var2, int var3, String var4);

    public static final native boolean eal_api_INode2DText_setText__SWIG_2(long var0, INode2DText var2, long var3, ITextLayout var5, String var6);

    public static final native boolean eal_api_INode2DText_setText__SWIG_3(long var0, INode2DText var2, long var3, ITextLayoutResult var5);

    public static final native boolean eal_api_INode2DText_setColor__SWIG_0(long var0, INode2DText var2, long var3, colorRGBAf var5);

    public static final native boolean eal_api_INode2DText_setColor__SWIG_1(long var0, INode2DText var2, long var3);

    public static final native long eal_api_INode2DText_getAscent(long var0, INode2DText var2);

    public static final native long eal_api_INode2DText_getDescent(long var0, INode2DText var2);

    public static final native long eal_api_INode2DText_getInterfaceText(long var0, INode2DText var2);

    public static final native void eal_api_INode2DText_dispose(long var0, INode2DText var2);

    public static final native long eal_api_INode2DText_getWidth(long var0, INode2DText var2);

    public static final native long eal_api_INode2DText_getHeight(long var0, INode2DText var2);

    public static final native boolean eal_api_INode2DText_setFading__SWIG_0(long var0, INode2DText var2, float var3, float var4);

    public static final native boolean eal_api_INode2DText_setFading__SWIG_1(long var0, INode2DText var2, float var3, float var4, boolean var5);

    public static final native boolean eal_api_INode2DText_setCurvature(long var0, INode2DText var2, long var3, Vec2f var5, float var6, boolean var7);

    public static final native long new_eal_api_INode3D__SWIG_0(long var0, INode var2);

    public static final native long new_eal_api_INode3D__SWIG_1(long var0, IManager var2, String var3);

    public static final native void delete_eal_api_INode3D(long var0);

    public static final native boolean eal_api_INode3D_scale__SWIG_0(long var0, INode3D var2, float var3);

    public static final native boolean eal_api_INode3D_scale__SWIG_1(long var0, INode3D var2, float var3, float var4, float var5);

    public static final native boolean eal_api_INode3D_setScale__SWIG_0(long var0, INode3D var2, float var3);

    public static final native boolean eal_api_INode3D_setScale__SWIG_1(long var0, INode3D var2, float var3, float var4, float var5);

    public static final native boolean eal_api_INode3D_translate(long var0, INode3D var2, float var3, float var4, float var5);

    public static final native boolean eal_api_INode3D_setTranslation(long var0, INode3D var2, float var3, float var4, float var5);

    public static final native long eal_api_INode3D_getTranslation(long var0, INode3D var2);

    public static final native float eal_api_INode3D_getTranslationX(long var0, INode3D var2);

    public static final native float eal_api_INode3D_getTranslationY(long var0, INode3D var2);

    public static final native float eal_api_INode3D_getTranslationZ(long var0, INode3D var2);

    public static final native boolean eal_api_INode3D_rotate(long var0, INode3D var2, float var3, float var4, float var5, float var6);

    public static final native boolean eal_api_INode3D_rotateX(long var0, INode3D var2, float var3);

    public static final native boolean eal_api_INode3D_rotateY(long var0, INode3D var2, float var3);

    public static final native boolean eal_api_INode3D_rotateZ(long var0, INode3D var2, float var3);

    public static final native boolean eal_api_INode3D_setRotation(long var0, INode3D var2, float var3, float var4, float var5, float var6);

    public static final native boolean eal_api_INode3D_setRotationXYZ(long var0, INode3D var2, float var3, float var4, float var5);

    public static final native boolean eal_api_INode3D_add__SWIG_0(long var0, INode3D var2, long var3, INode3D var5);

    public static final native boolean eal_api_INode3D_add__SWIG_1(long var0, INode3D var2, long var3, INode3D var5, long var6);

    public static final native boolean eal_api_INode3D_addByIndex(long var0, INode3D var2, long var3, INode3D var5, int var6);

    public static final native long eal_api_INode3D_getChildByIndex(long var0, INode3D var2, int var3);

    public static final native long eal_api_INode3D_getScale(long var0, INode3D var2);

    public static final native float eal_api_INode3D_getScaleX(long var0, INode3D var2);

    public static final native float eal_api_INode3D_getScaleY(long var0, INode3D var2);

    public static final native float eal_api_INode3D_getScaleZ(long var0, INode3D var2);

    public static final native long eal_api_INode3D_getTransformation(long var0, INode3D var2);

    public static final native boolean eal_api_INode3D_setTransformation(long var0, INode3D var2, long var3, Mat4f var5);

    public static final native long eal_api_INode3D_getParent(long var0, INode3D var2);

    public static final native long eal_api_INode3D_getChildAtIndex(long var0, INode3D var2, long var3);

    public static final native long eal_api_INode3D_getChildByName(long var0, INode3D var2, String var3);

    public static final native boolean eal_api_INode3D_clip(long var0, INode3D var2, float var3, float var4, float var5, float var6);

    public static final native boolean eal_api_INode3D_disableClip(long var0, INode3D var2);

    public static final native boolean eal_api_INode3D_setDepthTest(long var0, INode3D var2, boolean var3);

    public static final native boolean eal_api_INode3D_resetTransformations(long var0, INode3D var2);

    public static final native void eal_api_INode3D_dispose(long var0, INode3D var2);

    public static final native boolean eal_api_INode3D_move(long var0, INode3D var2, long var3, INode3D var5);

    public static final native long new_eal_api_INode3DCamera__SWIG_0(long var0, IManager var2, String var3);

    public static final native long new_eal_api_INode3DCamera__SWIG_1(long var0, INode3D var2);

    public static final native void delete_eal_api_INode3DCamera(long var0);

    public static final native float eal_api_INode3DCamera_getFar(long var0, INode3DCamera var2);

    public static final native float eal_api_INode3DCamera_getNear(long var0, INode3DCamera var2);

    public static final native float eal_api_INode3DCamera_getFov(long var0, INode3DCamera var2);

    public static final native float eal_api_INode3DCamera_getPlaneHeight(long var0, INode3DCamera var2);

    public static final native boolean eal_api_INode3DCamera_lookAt(long var0, INode3DCamera var2, long var3, Vec3f var5, long var6, Vec3f var8, long var9, Vec3f var11);

    public static final native boolean eal_api_INode3DCamera_setAspectRatio(long var0, INode3DCamera var2, float var3);

    public static final native boolean eal_api_INode3DCamera_setPerspective__SWIG_0(long var0, INode3DCamera var2, float var3, float var4, float var5);

    public static final native boolean eal_api_INode3DCamera_setPerspective__SWIG_1(long var0, INode3DCamera var2, float var3, float var4, float var5, int var6);

    public static final native boolean eal_api_INode3DCamera_setOrthogonal(long var0, INode3DCamera var2, float var3, float var4, float var5);

    public static final native int eal_api_INode3DCamera_getFovType(long var0, INode3DCamera var2);

    public static final native void eal_api_INode3DCamera_dispose(long var0, INode3DCamera var2);

    public static final native boolean eal_api_INode3DCamera_interpolate(long var0, INode3DCamera var2, long var3, INode3DCamera var5, long var6, INode3DCamera var8, float var9);

    public static final native long new_eal_api_INode3DImage__SWIG_0(long var0, INode3D var2);

    public static final native long new_eal_api_INode3DImage__SWIG_1(long var0, IProject var2, String var3);

    public static final native long new_eal_api_INode3DImage__SWIG_2(long var0, IProject var2, String var3, long var4, ITexture var6);

    public static final native void delete_eal_api_INode3DImage(long var0);

    public static final native boolean eal_api_INode3DImage_setTexture(long var0, INode3DImage var2, long var3, ITexture var5);

    public static final native long eal_api_INode3DImage_getWidth(long var0, INode3DImage var2);

    public static final native long eal_api_INode3DImage_getHeight(long var0, INode3DImage var2);

    public static final native long eal_api_INode3DImage_getInterfaceImage(long var0, INode3DImage var2);

    public static final native void eal_api_INode3DImage_dispose(long var0, INode3DImage var2);

    public static final native boolean eal_api_INode3DImage_setModulateColor__SWIG_0(long var0, INode3DImage var2, long var3, colorRGBAf var5);

    public static final native boolean eal_api_INode3DImage_setModulateColor__SWIG_1(long var0, INode3DImage var2, long var3);

    public static final native boolean eal_api_INode3DImage_setMaterial(long var0, INode3DImage var2, long var3, IMaterial var5);

    public static final native boolean eal_api_INode3DImage_flipX(long var0, INode3DImage var2);

    public static final native boolean eal_api_INode3DImage_flipY(long var0, INode3DImage var2);

    public static final native boolean eal_api_INode3DImage_flipXY(long var0, INode3DImage var2);

    public static final native boolean eal_api_INode3DImage_clipImage(long var0, INode3DImage var2, float var3, float var4, float var5, float var6);

    public static final native void delete_eal_api_INode3DMesh(long var0);

    public static final native long eal_api_INode3DMesh_getData(long var0, INode3DMesh var2);

    public static final native boolean eal_api_INode3DMesh_setData(long var0, INode3DMesh var2, long var3, IMeshData var5);

    public static final native void eal_api_INode3DMesh_dispose(long var0, INode3DMesh var2);

    public static final native long new_eal_api_INode3DQuickDraw__SWIG_0(long var0, IProject var2, String var3, long var4, long var6);

    public static final native long new_eal_api_INode3DQuickDraw__SWIG_1(long var0, IProject var2, String var3, long var4, long var6, boolean var8);

    public static final native long new_eal_api_INode3DQuickDraw__SWIG_2(long var0, IProject var2, String var3, long var4, long var6, boolean var8, boolean var9);

    public static final native long new_eal_api_INode3DQuickDraw__SWIG_3(long var0, IProject var2, String var3, long var4, long var6, boolean var8, boolean var9, int var10);

    public static final native long new_eal_api_INode3DQuickDraw__SWIG_4(long var0, IProject var2, String var3, long var4, long var6, boolean var8, boolean var9, int var10, boolean var11);

    public static final native void delete_eal_api_INode3DQuickDraw(long var0);

    public static final native void eal_api_INode3DQuickDraw_dispose(long var0, INode3DQuickDraw var2);

    public static final native boolean eal_api_INode3DQuickDraw_add(long var0, INode3DQuickDraw var2, long var3, Vec2f var5);

    public static final native boolean eal_api_INode3DQuickDraw_addSeparator(long var0, INode3DQuickDraw var2);

    public static final native boolean eal_api_INode3DQuickDraw_clearArea(long var0, INode3DQuickDraw var2);

    public static final native boolean eal_api_INode3DQuickDraw_setLineWidth(long var0, INode3DQuickDraw var2, float var3);

    public static final native boolean eal_api_INode3DQuickDraw_setColor__SWIG_0(long var0, INode3DQuickDraw var2, long var3);

    public static final native boolean eal_api_INode3DQuickDraw_setColor__SWIG_1(long var0, INode3DQuickDraw var2, long var3, colorRGBAf var5);

    public static final native boolean eal_api_INode3DQuickDraw_setPathTranslation(long var0, INode3DQuickDraw var2, float var3, float var4);

    public static final native boolean eal_api_INode3DQuickDraw_setPathScaling__SWIG_0(long var0, INode3DQuickDraw var2, float var3, float var4);

    public static final native boolean eal_api_INode3DQuickDraw_setPathScaling__SWIG_1(long var0, INode3DQuickDraw var2, float var3, float var4, boolean var5);

    public static final native boolean eal_api_INode3DQuickDraw_setPathRotation(long var0, INode3DQuickDraw var2, float var3);

    public static final native boolean eal_api_INode3DQuickDraw_setDebugBoundingVolume(long var0, INode3DQuickDraw var2, boolean var3);

    public static final native boolean eal_api_INode3DQuickDraw_setPathPivot(long var0, INode3DQuickDraw var2, float var3, float var4);

    public static final native long new_eal_api_INode3DScene(long var0, IManager var2, String var3);

    public static final native void delete_eal_api_INode3DScene(long var0);

    public static final native boolean eal_api_INode3DScene_add__SWIG_0(long var0, INode3DScene var2, long var3, INode3D var5);

    public static final native boolean eal_api_INode3DScene_add__SWIG_1(long var0, INode3DScene var2, long var3, INode3DCamera var5);

    public static final native boolean eal_api_INode3DScene_add__SWIG_2(long var0, INode3DScene var2, long var3, INode3D var5, long var6);

    public static final native boolean eal_api_INode3DScene_add__SWIG_3(long var0, INode3DScene var2, long var3, INode3DCamera var5, long var6);

    public static final native boolean eal_api_INode3DScene_addByIndex__SWIG_0(long var0, INode3DScene var2, long var3, INode3D var5, int var6);

    public static final native boolean eal_api_INode3DScene_addByIndex__SWIG_1(long var0, INode3DScene var2, long var3, INode3DCamera var5, int var6);

    public static final native void eal_api_INode3DScene_dispose(long var0, INode3DScene var2);

    public static final native boolean eal_api_INode3DScene_setDefaultCamera(long var0, INode3DScene var2, long var3, INode3DCamera var5);

    public static final native boolean eal_api_INode3DScene_setColorClear(long var0, INode3DScene var2, boolean var3);

    public static final native boolean eal_api_INode3DScene_setClearColor(long var0, INode3DScene var2, long var3, colorRGBAf var5);

    public static final native boolean eal_api_INode3DScene_setDepthTest(long var0, INode3DScene var2, boolean var3);

    public static final native boolean eal_api_INode3DScene_setAnimationPlayer(long var0, INode3DScene var2, boolean var3);

    public static final native long new_eal_api_INode3DText__SWIG_0(long var0, INode3D var2);

    public static final native long new_eal_api_INode3DText__SWIG_1(long var0, IProject var2, String var3, long var4, IFont var6, int var7, String var8);

    public static final native long new_eal_api_INode3DText__SWIG_2(long var0, IProject var2, String var3, int var4, String var5);

    public static final native long new_eal_api_INode3DText__SWIG_3(long var0, IProject var2, String var3, long var4, ITextLayout var6, String var7);

    public static final native long new_eal_api_INode3DText__SWIG_4(long var0, IProject var2, String var3, long var4, ITextLayoutResult var6);

    public static final native long new_eal_api_INode3DText__SWIG_5(long var0, IProject var2, String var3);

    public static final native void delete_eal_api_INode3DText(long var0);

    public static final native long eal_api_INode3DText_getColor(long var0, INode3DText var2);

    public static final native long eal_api_INode3DText_getHeight(long var0, INode3DText var2);

    public static final native long eal_api_INode3DText_getWidth(long var0, INode3DText var2);

    public static final native boolean eal_api_INode3DText_setColor__SWIG_0(long var0, INode3DText var2, long var3);

    public static final native boolean eal_api_INode3DText_setColor__SWIG_1(long var0, INode3DText var2, long var3, colorRGBAf var5);

    public static final native boolean eal_api_INode3DText_setText__SWIG_0(long var0, INode3DText var2, long var3, IFont var5, int var6, String var7);

    public static final native boolean eal_api_INode3DText_setText__SWIG_1(long var0, INode3DText var2, int var3, String var4);

    public static final native boolean eal_api_INode3DText_setText__SWIG_2(long var0, INode3DText var2, long var3, ITextLayout var5, String var6);

    public static final native boolean eal_api_INode3DText_setText__SWIG_3(long var0, INode3DText var2, long var3, ITextLayoutResult var5);

    public static final native long eal_api_INode3DText_getInterfaceText(long var0, INode3DText var2);

    public static final native void eal_api_INode3DText_dispose(long var0, INode3DText var2);

    public static final native long eal_api_INode3DText_getAscent(long var0, INode3DText var2);

    public static final native long eal_api_INode3DText_getDescent(long var0, INode3DText var2);

    public static final native boolean eal_api_INode3DText_setModulateColor(long var0, INode3DText var2, long var3, colorRGBAf var5);

    public static final native boolean eal_api_INode3DText_setFading__SWIG_0(long var0, INode3DText var2, float var3, float var4);

    public static final native boolean eal_api_INode3DText_setFading__SWIG_1(long var0, INode3DText var2, float var3, float var4, boolean var5);

    public static final native boolean eal_api_INode3DText_setCurvature(long var0, INode3DText var2, long var3, Vec2f var5, float var6, boolean var7);

    public static final native void delete_eal_api_ITemplateNode2D(long var0);

    public static final native boolean eal_api_ITemplateNode2D_isValid(long var0, ITemplateNode2D var2);

    public static final native void eal_api_ITemplateNode2D_dispose(long var0, ITemplateNode2D var2);

    public static final native long eal_api_ITemplateNode2D_getRoot(long var0, ITemplateNode2D var2);

    public static final native long eal_api_ITemplateNode2D_instantiate(long var0, ITemplateNode2D var2, long var3, IProject var5, String var6);

    public static final native void delete_eal_api_ITemplateNode3D(long var0);

    public static final native boolean eal_api_ITemplateNode3D_isValid(long var0, ITemplateNode3D var2);

    public static final native void eal_api_ITemplateNode3D_dispose(long var0, ITemplateNode3D var2);

    public static final native long eal_api_ITemplateNode3D_getRoot(long var0, ITemplateNode3D var2);

    public static final native long eal_api_ITemplateNode3D_instantiate(long var0, ITemplateNode3D var2, long var3, IProject var5, String var6);

    public static final native long new_eal_api_IFont(long var0, IManager var2, String var3);

    public static final native void delete_eal_api_IFont(long var0);

    public static final native String eal_api_IFont_getName(long var0, IFont var2);

    public static final native int eal_api_IFont_getAscent(long var0, IFont var2, long var3);

    public static final native int eal_api_IFont_getDescent(long var0, IFont var2, long var3);

    public static final native int eal_api_IFont_getMaximumHeight(long var0, IFont var2, long var3);

    public static final native boolean eal_api_IFont_isValid(long var0, IFont var2);

    public static final native void eal_api_IFont_dispose(long var0, IFont var2);

    public static final native boolean eal_api_IFont_destroy(long var0, IFont var2, long var3, IManager var5);

    public static final native void eal_api_IFont_copy(long var0, IFont var2, long var3, IFont var5);

    public static final native boolean eal_api_IFont_overwriteNotDefGlyph(long var0, IFont var2, long var3);

    public static final native long new_eal_api_IFontList();

    public static final native void delete_eal_api_IFontList(long var0);

    public static final native void eal_api_IFontList_add(long var0, IFontList var2, String var3);

    public static final native void delete_eal_api_IFontGroupFontHandle(long var0);

    public static final native boolean eal_api_IFontGroupFontHandle_isValid(long var0, IFontGroupFontHandle var2);

    public static final native void eal_api_IFontGroupFontHandle_dispose(long var0, IFontGroupFontHandle var2);

    public static final native long new_eal_api_IFontGroup__SWIG_0(long var0, IManager var2);

    public static final native long new_eal_api_IFontGroup__SWIG_1(long var0, IManager var2, int var3);

    public static final native long new_eal_api_IFontGroup__SWIG_2(long var0, IManager var2, long var3, IFontList var5, String var6, short var7);

    public static final native long new_eal_api_IFontGroup__SWIG_3(long var0, IManager var2, long var3, IFontList var5, String var6, short var7, int var8);

    public static final native void delete_eal_api_IFontGroup(long var0);

    public static final native void eal_api_IFontGroup_dispose(long var0, IFontGroup var2);

    public static final native boolean eal_api_IFontGroup_isValid(long var0, IFontGroup var2);

    public static final native boolean eal_api_IFontGroup_destroy(long var0, IFontGroup var2);

    public static final native long eal_api_IFontGroup_addFont__SWIG_0(long var0, IFontGroup var2, String var3);

    public static final native long eal_api_IFontGroup_addFont__SWIG_1(long var0, IFontGroup var2, String var3, long var4);

    public static final native boolean eal_api_IFontGroup_addUnicodeRange(long var0, IFontGroup var2, long var3, long var5, long var7);

    public static final native boolean eal_api_IFontGroup_linkUnicodeRanges(long var0, IFontGroup var2, String var3);

    public static final native boolean eal_api_IFontGroup_linkDefaultFont(long var0, IFontGroup var2, long var3, IFontGroupFontHandle var5);

    public static final native boolean eal_api_IFontGroup_activate(long var0, IFontGroup var2);

    public static final native boolean eal_api_IFontGroup_overwriteNotDefGlyph(long var0, IFontGroup var2, long var3);

    public static final native int eal_api_IFontGroup_getAscent(long var0, IFontGroup var2, long var3);

    public static final native int eal_api_IFontGroup_getDescent(long var0, IFontGroup var2, long var3);

    public static final native boolean eal_api_IFontGroup_setSize(long var0, IFontGroup var2, long var3);

    public static final native void delete_eal_api_IFontGroupAsync(long var0);

    public static final native boolean eal_api_IFontGroupAsync_addFont(long var0, IFontGroupAsync var2, String var3);

    public static final native boolean eal_api_IFontGroupAsync_linkUnicodeRanges(long var0, IFontGroupAsync var2, String var3);

    public static final native long eal_api_IFontGroupAsync_takeOwnership(long var0, IFontGroupAsync var2, long var3, IManager var5);

    public static final native int eal_api_ITextLayoutSection_STYLE_REGULAR_get();

    public static final native int eal_api_ITextLayoutSection_STYLE_BOLD_get();

    public static final native int eal_api_ITextLayoutSection_STYLE_ITALIC_get();

    public static final native int eal_api_ITextLayoutSection_STYLE_BOLD_ITALIC_get();

    public static final native int eal_api_ITextLayoutSection_STYLE_UNDERLINE_get();

    public static final native int eal_api_ITextLayoutSection_STYLE_OVERLINE_get();

    public static final native int eal_api_ITextLayoutSection_STYLE_STRIKEOUT_get();

    public static final native int eal_api_ITextLayoutSection_HINTING_OFF_get();

    public static final native void delete_eal_api_ITextLayoutSection(long var0);

    public static final native boolean eal_api_ITextLayoutSection_isValid(long var0, ITextLayoutSection var2);

    public static final native boolean eal_api_ITextLayoutSection_setBasic__SWIG_0(long var0, ITextLayoutSection var2, long var3, IFont var5, int var6);

    public static final native boolean eal_api_ITextLayoutSection_setBasic__SWIG_1(long var0, ITextLayoutSection var2, long var3, IFont var5, int var6, long var7);

    public static final native boolean eal_api_ITextLayoutSection_setBasicFontGroup(long var0, ITextLayoutSection var2, int var3, long var4);

    public static final native boolean eal_api_ITextLayoutSection_setAlignment(long var0, ITextLayoutSection var2, int var3);

    public static final native boolean eal_api_ITextLayoutSection_setStartEndIndex(long var0, ITextLayoutSection var2, long var3, long var5);

    public static final native boolean eal_api_ITextLayoutSection_setLineGap(long var0, ITextLayoutSection var2, int var3);

    public static final native boolean eal_api_ITextLayoutSection_setFont__SWIG_0(long var0, ITextLayoutSection var2, long var3, IFont var5, int var6, long var7, FlagFontStyle var9);

    public static final native boolean eal_api_ITextLayoutSection_setFont__SWIG_1(long var0, ITextLayoutSection var2, long var3, IFont var5, int var6);

    public static final native boolean eal_api_ITextLayoutSection_setLineExtender(long var0, ITextLayoutSection var2, int var3);

    public static final native void eal_api_ITextLayoutSection_dispose(long var0, ITextLayoutSection var2);

    public static final native boolean eal_api_ITextLayoutSection_setColor__SWIG_0(long var0, ITextLayoutSection var2, long var3, colorRGBAf var5);

    public static final native boolean eal_api_ITextLayoutSection_setColor__SWIG_1(long var0, ITextLayoutSection var2, int var3);

    public static final native boolean eal_api_ITextLayoutSection_setStyle(long var0, ITextLayoutSection var2, long var3, FlagFontStyle var5);

    public static final native boolean eal_api_ITextLayoutSection_setHinting(long var0, ITextLayoutSection var2, int var3);

    public static final native long new_eal_FlagFontStyle__SWIG_0();

    public static final native long new_eal_FlagFontStyle__SWIG_1(int var0);

    public static final native long new_eal_FlagFontStyle__SWIG_2(long var0);

    public static final native long eal_FlagFontStyle_getFlagValue(long var0, FlagFontStyle var2);

    public static final native void eal_FlagFontStyle_setFlag(long var0, FlagFontStyle var2, int var3);

    public static final native boolean eal_FlagFontStyle_isFlag(long var0, FlagFontStyle var2, int var3);

    public static final native void eal_FlagFontStyle_reset(long var0, FlagFontStyle var2);

    public static final native void eal_FlagFontStyle_resetPos(long var0, FlagFontStyle var2, long var3);

    public static final native void eal_FlagFontStyle_unsetFlag(long var0, FlagFontStyle var2, int var3);

    public static final native void eal_FlagFontStyle_setFlagValue(long var0, FlagFontStyle var2, long var3);

    public static final native long eal_FlagFontStyle_getHexValueAtPos(long var0, FlagFontStyle var2, long var3);

    public static final native long eal_FlagFontStyle_extractPosition(long var0, FlagFontStyle var2, long var3);

    public static final native long eal_FlagFontStyle_getByMask(long var0, FlagFontStyle var2, long var3);

    public static final native boolean eal_FlagFontStyle_equal__SWIG_0(long var0, FlagFontStyle var2, long var3);

    public static final native boolean eal_FlagFontStyle_equal__SWIG_1(long var0, FlagFontStyle var2, int var3);

    public static final native boolean eal_FlagFontStyle_unequal__SWIG_0(long var0, FlagFontStyle var2, long var3);

    public static final native boolean eal_FlagFontStyle_unequal__SWIG_1(long var0, FlagFontStyle var2, int var3);

    public static final native boolean eal_FlagFontStyle_contains__SWIG_0(long var0, FlagFontStyle var2, int var3);

    public static final native boolean eal_FlagFontStyle_contains__SWIG_1(long var0, FlagFontStyle var2, long var3, FlagFontStyle var5);

    public static final native void delete_eal_FlagFontStyle(long var0);

    public static final native long new_eal_api_ITextLayout__SWIG_0();

    public static final native long new_eal_api_ITextLayout__SWIG_1(long var0, IFont var2, int var3);

    public static final native long new_eal_api_ITextLayout__SWIG_2(int var0);

    public static final native void delete_eal_api_ITextLayout(long var0);

    public static final native boolean eal_api_ITextLayout_isValid(long var0, ITextLayout var2);

    public static final native void eal_api_ITextLayout_setTruncation(long var0, ITextLayout var2, boolean var3);

    public static final native void eal_api_ITextLayout_setMaximumSize(long var0, ITextLayout var2, long var3, long var5);

    public static final native void eal_api_ITextLayout_setMaximumLineCount(long var0, ITextLayout var2, long var3);

    public static final native boolean eal_api_ITextLayout_setTextLayoutSectionNum(long var0, ITextLayout var2, long var3);

    public static final native long eal_api_ITextLayout_getLayoutSection(long var0, ITextLayout var2, long var3);

    public static final native void eal_api_ITextLayout_print(long var0, ITextLayout var2);

    public static final native boolean eal_api_ITextLayout_destroy(long var0, ITextLayout var2);

    public static final native void eal_api_ITextLayout_dispose(long var0, ITextLayout var2);

    public static final native boolean eal_api_ITextLayout_setPreformattedText(long var0, ITextLayout var2, boolean var3);

    public static final native boolean eal_api_ITextLayout_setKerning(long var0, ITextLayout var2, int var3);

    public static final native void delete_eal_api_ITextLayoutResult(long var0);

    public static final native boolean eal_api_ITextLayoutResult_isValid(long var0, ITextLayoutResult var2);

    public static final native long eal_api_ITextLayoutResult_getWidth(long var0, ITextLayoutResult var2);

    public static final native long eal_api_ITextLayoutResult_getHeight(long var0, ITextLayoutResult var2);

    public static final native long eal_api_ITextLayoutResult_getLineWidth(long var0, ITextLayoutResult var2, long var3);

    public static final native long eal_api_ITextLayoutResult_getLineHeight(long var0, ITextLayoutResult var2, long var3);

    public static final native long eal_api_ITextLayoutResult_getAscent(long var0, ITextLayoutResult var2, long var3);

    public static final native long eal_api_ITextLayoutResult_getDescent(long var0, ITextLayoutResult var2, long var3);

    public static final native long eal_api_ITextLayoutResult_getLineLeft(long var0, ITextLayoutResult var2, long var3);

    public static final native boolean eal_api_ITextLayoutResult_destroy(long var0, ITextLayoutResult var2);

    public static final native long eal_api_ITextLayoutResult_getLineCount(long var0, ITextLayoutResult var2);

    public static final native void eal_api_ITextLayoutResult_dispose(long var0, ITextLayoutResult var2);

    public static final native long eal_api_ITextLayoutResult_getGlyphCount__SWIG_0(long var0, ITextLayoutResult var2);

    public static final native long eal_api_ITextLayoutResult_getGlyphCount__SWIG_1(long var0, ITextLayoutResult var2, long var3);

    public static final native long eal_api_ITextLayoutResult_getLastGlyphOfLine(long var0, ITextLayoutResult var2, long var3);

    public static final native long eal_api_ITextLayoutResult_getGlyphOfLine(long var0, ITextLayoutResult var2, long var3, long var5);

    public static final native boolean eal_api_ITextLayoutResult_isTruncated(long var0, ITextLayoutResult var2);

    public static final native int eal_api_ITextLayoutResult_getCursorPosition(long var0, ITextLayoutResult var2, long var3, long var5);

    public static final native long getINodeByPath(long var0, IProject var2, String var3);

    public static final native boolean setVisible(long var0, IProject var2, String var3, boolean var4);

    public static final native boolean setTexture(long var0, IProject var2, String var3, String var4);

    public static final native boolean createPixelPerfect(long var0, INode3DCamera var2, long var3, long var5);

    public static final native long RGBAtoRGBAf(long var0);

    public static final native long ARGBtoRGBAf(long var0);

    public static final native long toRGBAUint32(long var0, colorRGBAf var2);

    public static final native long toARGBUint32(long var0, colorRGBAf var2);

    public static final native long new_eal_utility_CFrameInformation(long var0, IRenderer var2);

    public static final native void delete_eal_utility_CFrameInformation(long var0);

    public static final native void eal_utility_CFrameInformation_dispose(long var0, CFrameInformation var2);

    public static final native long eal_utility_CFrameInformation_getFPS(long var0, CFrameInformation var2);

    public static final native int eal_utility_IImageStorageListener_IDENT_NONE_get();

    public static final native long new_eal_utility_IImageStorageListener();

    public static final native void delete_eal_utility_IImageStorageListener(long var0);

    public static final native void eal_utility_IImageStorageListener_process(long var0, IImageStorageListener var2, int var3, long var4);

    public static final native void eal_utility_IImageStorageListener_processSwigExplicitIImageStorageListener(long var0, IImageStorageListener var2, int var3, long var4);

    public static final native void eal_utility_IImageStorageListener_director_connect(IImageStorageListener var0, long var1, boolean var3, boolean var4);

    public static final native void eal_utility_IImageStorageListener_change_ownership(IImageStorageListener var0, long var1, boolean var3);

    public static final native long new_eal_utility_CImageStorage(long var0, IManager var2, long var3, IImageStorageListener var5);

    public static final native void delete_eal_utility_CImageStorage(long var0);

    public static final native boolean eal_utility_CImageStorage_add__SWIG_0(long var0, CImageStorage var2, long var3, String var5, long var6, FlagImage var8);

    public static final native boolean eal_utility_CImageStorage_add__SWIG_1(long var0, CImageStorage var2, long var3, String var5, long var6, FlagImage var8, long var9, long var11);

    public static final native long eal_utility_CImageStorage_get(long var0, CImageStorage var2, long var3);

    public static final native boolean eal_utility_CImageStorage_flush(long var0, CImageStorage var2);

    public static final native boolean eal_utility_CImageStorage_clear(long var0, CImageStorage var2);

    public static final native boolean eal_utility_CImageStorage_destroy(long var0, CImageStorage var2);

    public static final native boolean eal_utility_CImageStorage_remove(long var0, CImageStorage var2, long var3);

    public static final native long new_eal_utility_CInterpolatorAccelerated__SWIG_0();

    public static final native long new_eal_utility_CInterpolatorAccelerated__SWIG_1(float var0, float var1, float var2, float var3, float var4, float var5);

    public static final native void delete_eal_utility_CInterpolatorAccelerated(long var0);

    public static final native float eal_utility_CInterpolatorAccelerated_evaluate(long var0, CInterpolatorAccelerated var2);

    public static final native boolean eal_utility_CInterpolatorAccelerated_isFinished(long var0, CInterpolatorAccelerated var2);

    public static final native void eal_utility_CInterpolatorAccelerated_start(long var0, CInterpolatorAccelerated var2);

    public static final native void eal_utility_CInterpolatorAccelerated_setStart(long var0, CInterpolatorAccelerated var2, float var3);

    public static final native void eal_utility_CInterpolatorAccelerated_setEnd(long var0, CInterpolatorAccelerated var2, float var3);

    public static final native float eal_utility_CInterpolatorAccelerated_getStart(long var0, CInterpolatorAccelerated var2);

    public static final native float eal_utility_CInterpolatorAccelerated_getEnd(long var0, CInterpolatorAccelerated var2);

    public static final native float eal_utility_CInterpolatorAccelerated_getLowerBound(long var0, CInterpolatorAccelerated var2);

    public static final native float eal_utility_CInterpolatorAccelerated_getUpperBound(long var0, CInterpolatorAccelerated var2);

    public static final native void eal_utility_CInterpolatorAccelerated_setLowerBound(long var0, CInterpolatorAccelerated var2, float var3);

    public static final native void eal_utility_CInterpolatorAccelerated_setUpperBound(long var0, CInterpolatorAccelerated var2, float var3);

    public static final native void eal_utility_CInterpolatorAccelerated_setAccelerationMax(long var0, CInterpolatorAccelerated var2, float var3);

    public static final native void eal_utility_CInterpolatorAccelerated_setSpeedMax(long var0, CInterpolatorAccelerated var2, float var3);

    public static final native float eal_utility_CInterpolatorAccelerated_getAccelerationMax(long var0, CInterpolatorAccelerated var2);

    public static final native float eal_utility_CInterpolatorAccelerated_getSpeedMax(long var0, CInterpolatorAccelerated var2);

    public static final native long new_eal_utility_CLerpF__SWIG_0();

    public static final native long new_eal_utility_CLerpF__SWIG_1(float var0, float var1, long var2);

    public static final native void delete_eal_utility_CLerpF(long var0);

    public static final native void eal_utility_CLerpF_start(long var0, CLerpF var2);

    public static final native float eal_utility_CLerpF_evaluate(long var0, CLerpF var2);

    public static final native boolean eal_utility_CLerpF_isFinished(long var0, CLerpF var2);

    public static final native void eal_utility_CLerpF_setStart(long var0, CLerpF var2, float var3);

    public static final native void eal_utility_CLerpF_setEnd(long var0, CLerpF var2, float var3);

    public static final native void eal_utility_CLerpF_setStartEnd(long var0, CLerpF var2, float var3, float var4);

    public static final native void eal_utility_CLerpF_setDuration(long var0, CLerpF var2, long var3);

    public static final native float eal_utility_CLerpF_getStart(long var0, CLerpF var2);

    public static final native float eal_utility_CLerpF_getEnd(long var0, CLerpF var2);

    public static final native long eal_utility_CLerpF_getDuration(long var0, CLerpF var2);

    public static final native void eal_utility_CLerpF_invert(long var0, CLerpF var2);

    public static final native long new_eal_utility_CLerpD__SWIG_0();

    public static final native long new_eal_utility_CLerpD__SWIG_1(double var0, double var2, long var4);

    public static final native void delete_eal_utility_CLerpD(long var0);

    public static final native void eal_utility_CLerpD_start(long var0, CLerpD var2);

    public static final native double eal_utility_CLerpD_evaluate(long var0, CLerpD var2);

    public static final native boolean eal_utility_CLerpD_isFinished(long var0, CLerpD var2);

    public static final native void eal_utility_CLerpD_setStart(long var0, CLerpD var2, double var3);

    public static final native void eal_utility_CLerpD_setEnd(long var0, CLerpD var2, double var3);

    public static final native void eal_utility_CLerpD_setStartEnd(long var0, CLerpD var2, double var3, double var5);

    public static final native void eal_utility_CLerpD_setDuration(long var0, CLerpD var2, long var3);

    public static final native double eal_utility_CLerpD_getStart(long var0, CLerpD var2);

    public static final native double eal_utility_CLerpD_getEnd(long var0, CLerpD var2);

    public static final native long eal_utility_CLerpD_getDuration(long var0, CLerpD var2);

    public static final native void eal_utility_CLerpD_invert(long var0, CLerpD var2);

    public static final native long new_ipl_VectorF__SWIG_0();

    public static final native long new_ipl_VectorF__SWIG_1(long var0);

    public static final native long ipl_VectorF_size(long var0, VectorF var2);

    public static final native long ipl_VectorF_capacity(long var0, VectorF var2);

    public static final native void ipl_VectorF_reserve(long var0, VectorF var2, long var3);

    public static final native boolean ipl_VectorF_isEmpty(long var0, VectorF var2);

    public static final native void ipl_VectorF_clear(long var0, VectorF var2);

    public static final native void ipl_VectorF_add(long var0, VectorF var2, float var3);

    public static final native void delete_ipl_VectorF(long var0);

    public static final native long new_ipl_VectorD__SWIG_0();

    public static final native long new_ipl_VectorD__SWIG_1(long var0);

    public static final native long ipl_VectorD_size(long var0, VectorD var2);

    public static final native long ipl_VectorD_capacity(long var0, VectorD var2);

    public static final native void ipl_VectorD_reserve(long var0, VectorD var2, long var3);

    public static final native boolean ipl_VectorD_isEmpty(long var0, VectorD var2);

    public static final native void ipl_VectorD_clear(long var0, VectorD var2);

    public static final native void ipl_VectorD_add(long var0, VectorD var2, double var3);

    public static final native void delete_ipl_VectorD(long var0);

    public static final native long new_eal_utility_CLinearInterpolatorF__SWIG_0();

    public static final native long new_eal_utility_CLinearInterpolatorF__SWIG_1(long var0, VectorF var2, long var3);

    public static final native float eal_utility_CLinearInterpolatorF_evaluate(long var0, CLinearInterpolatorF var2);

    public static final native boolean eal_utility_CLinearInterpolatorF_isFinished(long var0, CLinearInterpolatorF var2);

    public static final native void eal_utility_CLinearInterpolatorF_setKnots(long var0, CLinearInterpolatorF var2, long var3, VectorF var5);

    public static final native void eal_utility_CLinearInterpolatorF_setAnimationTime(long var0, CLinearInterpolatorF var2, long var3);

    public static final native void delete_eal_utility_CLinearInterpolatorF(long var0);

    public static final native long new_eal_utility_CLinearInterpolatorD__SWIG_0();

    public static final native long new_eal_utility_CLinearInterpolatorD__SWIG_1(long var0, VectorD var2, long var3);

    public static final native double eal_utility_CLinearInterpolatorD_evaluate(long var0, CLinearInterpolatorD var2);

    public static final native boolean eal_utility_CLinearInterpolatorD_isFinished(long var0, CLinearInterpolatorD var2);

    public static final native void eal_utility_CLinearInterpolatorD_setKnots(long var0, CLinearInterpolatorD var2, long var3, VectorD var5);

    public static final native void eal_utility_CLinearInterpolatorD_setAnimationTime(long var0, CLinearInterpolatorD var2, long var3);

    public static final native void delete_eal_utility_CLinearInterpolatorD(long var0);

    public static final native long new_eal_utility_COffscreenHelper(long var0, IProject var2, long var3, INode2DManaged var5);

    public static final native void delete_eal_utility_COffscreenHelper(long var0);

    public static final native void eal_utility_COffscreenHelper_dispose(long var0, COffscreenHelper var2);

    public static final native long eal_utility_COffscreenHelper_enableOffscreen__SWIG_0(long var0, COffscreenHelper var2, long var3, INode2D var5, long var6, long var8, long var10, FlagTexture var12, int var13);

    public static final native long eal_utility_COffscreenHelper_enableOffscreen__SWIG_1(long var0, COffscreenHelper var2, long var3, INode2D var5, long var6, long var8, long var10, FlagTexture var12, int var13, boolean var14);

    public static final native boolean eal_utility_COffscreenHelper_enableOffscreen__SWIG_2(long var0, COffscreenHelper var2, long var3, INode2D var5, long var6, ITexture var8, int var9);

    public static final native boolean eal_utility_COffscreenHelper_enableOffscreen__SWIG_3(long var0, COffscreenHelper var2, long var3, INode2D var5, long var6, ITexture var8, int var9, boolean var10);

    public static final native boolean eal_utility_COffscreenHelper_disableOffscreen(long var0, COffscreenHelper var2, long var3, INode2D var5);

    public static final native long eal_IEventMerge_SWIGUpcast(long var0);

    public static final native long eal_IEventImage_SWIGUpcast(long var0);

    public static final native long eal_IEventImageSave_SWIGUpcast(long var0);

    public static final native long eal_IEventFontGroup_SWIGUpcast(long var0);

    public static final native long eal_CAbstractEventListener_SWIGUpcast(long var0);

    public static final native long eal_api_IAnimation_SWIGUpcast(long var0);

    public static final native long eal_api_IAnimationClip_SWIGUpcast(long var0);

    public static final native long eal_api_IAnimationPlayer_SWIGUpcast(long var0);

    public static final native long eal_api_ITimeLineSequence_SWIGUpcast(long var0);

    public static final native long eal_api_IContext_SWIGUpcast(long var0);

    public static final native long eal_api_IManager_SWIGUpcast(long var0);

    public static final native long eal_api_IProject_SWIGUpcast(long var0);

    public static final native long eal_api_IImage_SWIGUpcast(long var0);

    public static final native long eal_api_IMeshData_SWIGUpcast(long var0);

    public static final native long eal_api_ITexture_SWIGUpcast(long var0);

    public static final native long eal_api_ITextureShared_SWIGUpcast(long var0);

    public static final native long eal_api_ITextureAtlas_SWIGUpcast(long var0);

    public static final native long eal_api_ITextureOffscreen_SWIGUpcast(long var0);

    public static final native long eal_api_IMaterial_SWIGUpcast(long var0);

    public static final native long eal_api_IProperty_SWIGUpcast(long var0);

    public static final native long eal_api_IRenderer_SWIGUpcast(long var0);

    public static final native long eal_api_IRendererAnnotation_SWIGUpcast(long var0);

    public static final native long eal_api_IINodeImage_SWIGUpcast(long var0);

    public static final native long eal_api_IINodeText_SWIGUpcast(long var0);

    public static final native long eal_api_INode_SWIGUpcast(long var0);

    public static final native long eal_api_INode2D_SWIGUpcast(long var0);

    public static final native long eal_api_INode2DHud_SWIGUpcast(long var0);

    public static final native long eal_api_INode2DImage_SWIGUpcast(long var0);

    public static final native long eal_api_INode2DLink_SWIGUpcast(long var0);

    public static final native long eal_api_INode2DManaged_SWIGUpcast(long var0);

    public static final native long eal_api_INode2DPartial_SWIGUpcast(long var0);

    public static final native long eal_api_INode2DText_SWIGUpcast(long var0);

    public static final native long eal_api_INode3D_SWIGUpcast(long var0);

    public static final native long eal_api_INode3DCamera_SWIGUpcast(long var0);

    public static final native long eal_api_INode3DImage_SWIGUpcast(long var0);

    public static final native long eal_api_INode3DMesh_SWIGUpcast(long var0);

    public static final native long eal_api_INode3DQuickDraw_SWIGUpcast(long var0);

    public static final native long eal_api_INode3DScene_SWIGUpcast(long var0);

    public static final native long eal_api_INode3DText_SWIGUpcast(long var0);

    public static final native long eal_api_ITemplateNode2D_SWIGUpcast(long var0);

    public static final native long eal_api_ITemplateNode3D_SWIGUpcast(long var0);

    public static final native long eal_api_IFont_SWIGUpcast(long var0);

    public static final native long eal_api_IFontGroupFontHandle_SWIGUpcast(long var0);

    public static final native long eal_api_IFontGroup_SWIGUpcast(long var0);

    public static final native long eal_api_ITextLayoutSection_SWIGUpcast(long var0);

    public static final native long eal_api_ITextLayout_SWIGUpcast(long var0);

    public static final native long eal_api_ITextLayoutResult_SWIGUpcast(long var0);

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
        iImageStorageListener.process(IImageStorageListener.enType_t.swigToEnum(n), l);
    }

    private static final native void swig_module_init();

    static {
        try {
            Version.setJava(true);
            Version.registerBinding(67110);
            Version.print();
            if (!Version.isValid()) {
                int n = Version.getVersion();
                int n2 = 67110;
                System.err.println("EAL - Version mismatch: " + Version.verToString() + "(" + n + ") != " + Version.verToString(n2) + "(" + n2 + ")");
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

