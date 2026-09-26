.version 50 0 
.class public super [205] 
.super [207] 
.implements [209] 
.field private final [210] [211] 
.field private [212] [213] 

.method protected [215] : [216] 
    .attribute [214] .code stack 7 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     iload 5 
L6:     aload 6 
L8:     iload 7 
L10:    invokespecial [36] 
L13:    aload_0 
L14:    aload 4 
L16:    invokeinterface [40] 0 
L21:    putfield [41] 
L24:    aload_0 
L25:    iconst_0 
L26:    putfield [42] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [214] .code stack 4 locals 2 
L0:     aload_1 
L1:     ifnonnull L7 
L4:     ldc [2] 
L6:     astore_1 
L7:     aload_0 
L8:     getfield [15] 
L11:    ifne L32 
L14:    aload_0 
L15:    invokevirtual [16] 
L18:    ifnull L32 
L21:    aload_0 
L22:    invokevirtual [16] 
L25:    aload_1 
L26:    invokevirtual [17] 
L29:    ifne L36 
L32:    iconst_1 
L33:    goto L37 
L36:    iconst_0 
L37:    istore_2 
L38:    iload_2 
L39:    ifeq L112 
L42:    aload_0 
L43:    aload_1 
L44:    invokespecial [37] 
L47:    aload_0 
L48:    invokespecial [38] 
L51:    aload_0 
L52:    getfield [14] 
L55:    aload_1 
L56:    invokevirtual [18] 
L59:    pop 
L60:    aload_0 
L61:    iconst_0 
L62:    putfield [42] 
L65:    aload_0 
L66:    invokevirtual [19] 
L69:    astore_3 
L70:    aload_1 
L71:    invokevirtual [20] 
L74:    ifle L94 
L77:    aload_0 
L78:    aload_3 
L79:    invokevirtual [21] 
L82:    l2f 
L83:    aload_3 
L84:    invokevirtual [22] 
L87:    l2f 
L88:    invokevirtual [23] 
L91:    goto L104 
L94:    aload_0 
L95:    fconst_0 
L96:    aload_3 
L97:    invokevirtual [22] 
L100:   l2f 
L101:   invokevirtual [23] 
L104:   aload_0 
L105:   aload_0 
L106:   getfield [24] 
L109:   invokevirtual [25] 
L112:   return 
L113:   nop 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method public interface [219] : [220] 
    .attribute [214] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [221] : [222] 
    .attribute [214] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     putfield [42] 
L5:     iload_1 
L6:     ifeq L17 
L9:     aload_0 
L10:    aload_0 
L11:    invokevirtual [16] 
L14:    invokevirtual [26] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [214] .code stack 8 locals 2 
L0:     iconst_2 
L1:     newarray int 
L3:     astore_2 
L4:     invokestatic [3] 
L7:     aload_0 
L8:     invokevirtual [27] 
L11:    aload_0 
L12:    invokevirtual [16] 
L15:    invokevirtual [28] 
L18:    astore_3 
L19:    aload_3 
L20:    lconst_0 
L21:    iload_1 
L22:    i2l 
L23:    invokevirtual [29] 
L26:    ifnull L69 
L29:    aload_2 
L30:    iconst_0 
L31:    aload_3 
L32:    lconst_0 
L33:    iload_1 
L34:    i2l 
L35:    invokevirtual [29] 
L38:    invokevirtual [30] 
L41:    f2i 
L42:    iastore 
L43:    aload_2 
L44:    iconst_1 
L45:    aload_3 
L46:    lconst_0 
L47:    iload_1 
L48:    i2l 
L49:    invokevirtual [29] 
L52:    invokevirtual [30] 
L55:    aload_3 
L56:    lconst_0 
L57:    iload_1 
L58:    i2l 
L59:    invokevirtual [29] 
L62:    invokevirtual [31] 
L65:    l2f 
L66:    fadd 
L67:    f2i 
L68:    iastore 
L69:    aload_3 
L70:    invokevirtual [32] 
L73:    pop 
L74:    aload_3 
L75:    invokevirtual [33] 
L78:    aload_2 
L79:    areturn 
L80:    
    .end code 
.end method 

.method public [225] : [226] 
    .attribute [214] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [39] 
L4:     aload_0 
L5:     getfield [34] 
L8:     aload_0 
L9:     getfield [14] 
L12:    invokevirtual [35] 
L15:    return 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [43] 
.const [3] = Method [44] [45] 
.const [4] = Class [46] 
.const [5] = Class [47] 
.const [6] = Class [48] 
.const [7] = Class [49] 
.const [8] = Class [50] 
.const [9] = Class [51] 
.const [10] = Class [52] 
.const [11] = Class [53] 
.const [12] = Class [54] 
.const [13] = Class [55] 
.const [14] = Field [56] [57] 
.const [15] = Field [58] [59] 
.const [16] = Method [60] [61] 
.const [17] = Method [62] [63] 
.const [18] = Method [64] [65] 
.const [19] = Method [66] [67] 
.const [20] = Method [68] [69] 
.const [21] = Method [70] [71] 
.const [22] = Method [72] [73] 
.const [23] = Method [74] [75] 
.const [24] = Field [76] [77] 
.const [25] = Method [78] [79] 
.const [26] = Method [80] [81] 
.const [27] = Method [82] [83] 
.const [28] = Method [84] [85] 
.const [29] = Method [86] [87] 
.const [30] = Method [88] [89] 
.const [31] = Method [90] [91] 
.const [32] = Method [92] [93] 
.const [33] = Method [94] [95] 
.const [34] = Field [96] [97] 
.const [35] = Method [98] [99] 
.const [36] = Method [100] [101] 
.const [37] = Method [102] [103] 
.const [38] = Method [104] [105] 
.const [39] = Method [106] [107] 
.const [40] = InterfaceMethod [108] [109] 
.const [41] = Field [110] [111] 
.const [42] = Field [112] [113] 
.const [43] = Utf8 '' 
.const [44] = Class [114] 
.const [45] = NameAndType [115] [116] 
.const [46] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DTextMultiSection 
.const [47] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [48] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedFont 
.const [49] = Utf8 java/lang/String 
.const [50] = Utf8 de/esolutions/graphics/eal/api/INode3DText 
.const [51] = Utf8 de/esolutions/graphics/eal/api/IINodeText 
.const [52] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [53] = Utf8 de/esolutions/graphics/eal/api/IManager 
.const [54] = Utf8 de/esolutions/graphics/eal/api/ITextLayoutResult 
.const [55] = Utf8 de/esolutions/graphics/eal/glyph_t 
.const [56] = Class [117] 
.const [57] = NameAndType [118] [119] 
.const [58] = Class [120] 
.const [59] = NameAndType [121] [122] 
.const [60] = Class [123] 
.const [61] = NameAndType [124] [125] 
.const [62] = Class [126] 
.const [63] = NameAndType [127] [128] 
.const [64] = Class [129] 
.const [65] = NameAndType [130] [131] 
.const [66] = Class [132] 
.const [67] = NameAndType [133] [134] 
.const [68] = Class [135] 
.const [69] = NameAndType [136] [137] 
.const [70] = Class [138] 
.const [71] = NameAndType [139] [140] 
.const [72] = Class [141] 
.const [73] = NameAndType [142] [143] 
.const [74] = Class [144] 
.const [75] = NameAndType [145] [146] 
.const [76] = Class [147] 
.const [77] = NameAndType [148] [149] 
.const [78] = Class [150] 
.const [79] = NameAndType [151] [152] 
.const [80] = Class [153] 
.const [81] = NameAndType [154] [155] 
.const [82] = Class [156] 
.const [83] = NameAndType [157] [158] 
.const [84] = Class [159] 
.const [85] = NameAndType [160] [161] 
.const [86] = Class [162] 
.const [87] = NameAndType [163] [164] 
.const [88] = Class [165] 
.const [89] = NameAndType [166] [167] 
.const [90] = Class [168] 
.const [91] = NameAndType [169] [170] 
.const [92] = Class [171] 
.const [93] = NameAndType [172] [173] 
.const [94] = Class [174] 
.const [95] = NameAndType [175] [176] 
.const [96] = Class [177] 
.const [97] = NameAndType [178] [179] 
.const [98] = Class [180] 
.const [99] = NameAndType [181] [182] 
.const [100] = Class [183] 
.const [101] = NameAndType [184] [185] 
.const [102] = Class [186] 
.const [103] = NameAndType [187] [188] 
.const [104] = Class [189] 
.const [105] = NameAndType [190] [191] 
.const [106] = Class [192] 
.const [107] = NameAndType [193] [194] 
.const [108] = Class [195] 
.const [109] = NameAndType [196] [197] 
.const [110] = Class [198] 
.const [111] = NameAndType [199] [200] 
.const [112] = Class [201] 
.const [113] = NameAndType [202] [203] 
.const [114] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [115] = Utf8 getManager 
.const [116] = Utf8 ()Lde/esolutions/graphics/eal/api/IManager; 
.const [117] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DTextMultiSection 
.const [118] = Utf8 layout 
.const [119] = Utf8 Lde/esolutions/graphics/eal/api/ITextLayout; 
.const [120] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DTextMultiSection 
.const [121] = Utf8 layoutChanged 
.const [122] = Utf8 Z 
.const [123] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DTextMultiSection 
.const [124] = Utf8 getText 
.const [125] = Utf8 ()Ljava/lang/String; 
.const [126] = Utf8 java/lang/String 
.const [127] = Utf8 equals 
.const [128] = Utf8 (Ljava/lang/Object;)Z 
.const [129] = Utf8 de/esolutions/graphics/eal/api/INode3DText 
.const [130] = Utf8 setText 
.const [131] = Utf8 (Lde/esolutions/graphics/eal/api/ITextLayout;Ljava/lang/String;)Z 
.const [132] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DTextMultiSection 
.const [133] = Utf8 getInterfaceText 
.const [134] = Utf8 ()Lde/esolutions/graphics/eal/api/IINodeText; 
.const [135] = Utf8 java/lang/String 
.const [136] = Utf8 length 
.const [137] = Utf8 ()I 
.const [138] = Utf8 de/esolutions/graphics/eal/api/IINodeText 
.const [139] = Utf8 getWidth 
.const [140] = Utf8 ()J 
.const [141] = Utf8 de/esolutions/graphics/eal/api/IINodeText 
.const [142] = Utf8 getHeight 
.const [143] = Utf8 ()J 
.const [144] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DTextMultiSection 
.const [145] = Utf8 setSize 
.const [146] = Utf8 (FF)V 
.const [147] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DTextMultiSection 
.const [148] = Utf8 visible 
.const [149] = Utf8 Z 
.const [150] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DTextMultiSection 
.const [151] = Utf8 setVisible 
.const [152] = Utf8 (Z)V 
.const [153] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DTextMultiSection 
.const [154] = Utf8 setText 
.const [155] = Utf8 (Ljava/lang/String;)V 
.const [156] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DTextMultiSection 
.const [157] = Utf8 getLayout 
.const [158] = Utf8 ()Lde/esolutions/graphics/eal/api/ITextLayout; 
.const [159] = Utf8 de/esolutions/graphics/eal/api/IManager 
.const [160] = Utf8 layout 
.const [161] = Utf8 (Lde/esolutions/graphics/eal/api/ITextLayout;Ljava/lang/String;)Lde/esolutions/graphics/eal/api/ITextLayoutResult; 
.const [162] = Utf8 de/esolutions/graphics/eal/api/ITextLayoutResult 
.const [163] = Utf8 getGlyphOfLine 
.const [164] = Utf8 (JJ)Lde/esolutions/graphics/eal/glyph_t; 
.const [165] = Utf8 de/esolutions/graphics/eal/glyph_t 
.const [166] = Utf8 getX 
.const [167] = Utf8 ()F 
.const [168] = Utf8 de/esolutions/graphics/eal/glyph_t 
.const [169] = Utf8 getWidth 
.const [170] = Utf8 ()J 
.const [171] = Utf8 de/esolutions/graphics/eal/api/ITextLayoutResult 
.const [172] = Utf8 destroy 
.const [173] = Utf8 ()Z 
.const [174] = Utf8 de/esolutions/graphics/eal/api/ITextLayoutResult 
.const [175] = Utf8 dispose 
.const [176] = Utf8 ()V 
.const [177] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DTextMultiSection 
.const [178] = Utf8 ealManager 
.const [179] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/EALManager; 
.const [180] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [181] = Utf8 destroy 
.const [182] = Utf8 (Lde/esolutions/graphics/eal/api/IObject;)V 
.const [183] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [184] = Utf8 <init> 
.const [185] = Utf8 (Lde/esolutions/graphics/eal/api/INode3DText;Lde/esolutions/graphics/eal/api/IINodeText;Ljava/lang/String;ILde/esolutions/hmi/widgets/audi/base/eal/EALManager;Z)V 
.const [186] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [187] = Utf8 storeText 
.const [188] = Utf8 (Ljava/lang/String;)V 
.const [189] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [190] = Utf8 getTextNode 
.const [191] = Utf8 ()Lde/esolutions/graphics/eal/api/INode3DText; 
.const [192] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [193] = Utf8 dispose 
.const [194] = Utf8 ()V 
.const [195] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedFont 
.const [196] = Utf8 createLayout 
.const [197] = Utf8 ()Lde/esolutions/graphics/eal/api/ITextLayout; 
.const [198] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DTextMultiSection 
.const [199] = Utf8 layout 
.const [200] = Utf8 Lde/esolutions/graphics/eal/api/ITextLayout; 
.const [201] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DTextMultiSection 
.const [202] = Utf8 layoutChanged 
.const [203] = Utf8 Z 
.const [204] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DTextMultiSection 
.const [205] = Class [204] 
.const [206] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [207] = Class [206] 
.const [208] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3DTextMultiSection 
.const [209] = Class [208] 
.const [210] = Utf8 layout 
.const [211] = Utf8 Lde/esolutions/graphics/eal/api/ITextLayout; 
.const [212] = Utf8 layoutChanged 
.const [213] = Utf8 Z 
.const [214] = Utf8 Code 
.const [215] = Utf8 <init> 
.const [216] = Utf8 (Lde/esolutions/graphics/eal/api/INode3DText;Lde/esolutions/graphics/eal/api/IINodeText;Ljava/lang/String;Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedFont;ILde/esolutions/hmi/widgets/audi/base/eal/EALManager;Z)V 
.const [217] = Utf8 setText 
.const [218] = Utf8 (Ljava/lang/String;)V 
.const [219] = Utf8 getLayout 
.const [220] = Utf8 ()Lde/esolutions/graphics/eal/api/ITextLayout; 
.const [221] = Utf8 notifyLayoutChanged 
.const [222] = Utf8 (Z)V 
.const [223] = Utf8 getOnScreenCharPosition 
.const [224] = Utf8 (I)[I 
.const [225] = Utf8 dispose 
.const [226] = Utf8 ()V 
.end class 
