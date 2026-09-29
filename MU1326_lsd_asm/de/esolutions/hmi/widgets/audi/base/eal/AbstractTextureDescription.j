.version 50 0 
.class public super abstract [177] 
.super [179] 
.implements [181] 
.implements [183] 
.field protected final [184] [185] 
.field private final [186] [187] 
.field protected [188] [189] 
.field protected [190] [191] 

.method protected [193] : [194] 
    .attribute [192] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     aload_0 
L5:     fconst_1 
L6:     putfield [31] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [32] 
L14:    aload_0 
L15:    aload_2 
L16:    putfield [33] 
L19:    return 
L20:    
    .end code 
.end method 

.method public interface [195] : [196] 
    .attribute [192] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [197] : [198] 
    .attribute [192] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [18] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [199] : [200] 
    .attribute [192] .code stack 3 locals 1 
L0:     aload_0 
L1:     invokevirtual [19] 
L4:     astore_2 
L5:     aload_2 
L6:     ifnonnull L11 
L9:     aconst_null 
L10:    areturn 
L11:    aload_2 
L12:    aload_0 
L13:    aload_1 
L14:    invokeinterface [34] 0 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [201] : [202] 
    .attribute [192] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual [19] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnonnull L11 
L9:     iconst_0 
L10:    areturn 
L11:    aload_1 
L12:    aload_0 
L13:    invokeinterface [35] 0 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [192] .code stack 2 locals 3 
L0:     aload_1 
L1:     aload_0 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     areturn 
L7:     aload_1 
L8:     instanceof [2] 
L11:    ifne L16 
L14:    iconst_0 
L15:    areturn 
L16:    aload_1 
L17:    checkcast [2] 
L20:    astore_2 
L21:    aload_0 
L22:    invokespecial [29] 
L25:    aload_2 
L26:    invokespecial [29] 
L29:    if_acmpeq L34 
L32:    iconst_0 
L33:    areturn 
L34:    aload_0 
L35:    invokevirtual [20] 
L38:    astore_3 
L39:    aload_2 
L40:    invokevirtual [20] 
L43:    astore 4 
L45:    aload_3 
L46:    aload_0 
L47:    if_acmpeq L56 
L50:    aload 4 
L52:    aload_2 
L53:    if_acmpne L67 
L56:    aload_0 
L57:    aload_2 
L58:    if_acmpne L65 
L61:    iconst_1 
L62:    goto L66 
L65:    iconst_0 
L66:    areturn 
L67:    aload_0 
L68:    invokevirtual [20] 
L71:    aload_2 
L72:    invokevirtual [20] 
L75:    invokestatic [3] 
L78:    areturn 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [205] : [206] 
    .attribute [192] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual [20] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnull L14 
L9:     aload_1 
L10:    aload_0 
L11:    if_acmpne L19 
L14:    aload_0 
L15:    invokespecial [30] 
L18:    areturn 
L19:    aload_1 
L20:    invokevirtual [21] 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [207] : [208] 
    .attribute [192] .code stack 1 locals 0 
L0:     iconst_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [192] .code stack 1 locals 0 
L0:     iconst_4 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [211] : [212] 
    .attribute [192] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     ifnonnull L19 
L7:     aload_0 
L8:     aload_0 
L9:     getfield [16] 
L12:    aload_1 
L13:    invokevirtual [23] 
L16:    putfield [36] 
L19:    aload_0 
L20:    getfield [22] 
L23:    areturn 
L24:    
    .end code 
.end method 

.method protected [213] : [214] 
    .attribute [192] .code stack 4 locals 3 
L0:     iload_2 
L1:     ifeq L95 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [24] 
L9:     astore_3 
L10:    aload_3 
L11:    iconst_0 
L12:    iaload 
L13:    ifle L80 
L16:    aload_3 
L17:    iconst_1 
L18:    iaload 
L19:    ifle L80 
L22:    aload_0 
L23:    getfield [16] 
L26:    invokevirtual [25] 
L29:    i2f 
L30:    aload_3 
L31:    iconst_0 
L32:    iaload 
L33:    i2f 
L34:    fdiv 
L35:    fstore 4 
L37:    aload_0 
L38:    getfield [16] 
L41:    invokevirtual [26] 
L44:    i2f 
L45:    aload_3 
L46:    iconst_1 
L47:    iaload 
L48:    i2f 
L49:    fdiv 
L50:    fstore 5 
L52:    aload_0 
L53:    fload 4 
L55:    fload 5 
L57:    invokestatic [4] 
L60:    putfield [31] 
L63:    aload_0 
L64:    getfield [15] 
L67:    fconst_1 
L68:    fcmpl 
L69:    ifle L77 
L72:    aload_0 
L73:    fconst_1 
L74:    putfield [31] 
L77:    goto L95 
L80:    getstatic [5] 
L83:    sipush 10000 
L86:    ldc [6] 
L88:    aload_0 
L89:    invokevirtual [27] 
L92:    pop 
L93:    iconst_1 
L94:    areturn 
L95:    aload_0 
L96:    getfield [15] 
L99:    invokestatic [7] 
L102:   areturn 
L103:   nop 
L104:   
    .end code 
.end method 

.method public interface [215] : [216] 
    .attribute [192] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [37] 
.const [3] = Method [38] [39] 
.const [4] = Method [40] [41] 
.const [5] = Field [42] [43] 
.const [6] = String [44] 
.const [7] = Method [45] [46] 
.const [8] = Class [47] 
.const [9] = Class [48] 
.const [10] = Class [49] 
.const [11] = Class [50] 
.const [12] = Class [51] 
.const [13] = Class [52] 
.const [14] = Class [53] 
.const [15] = Field [54] [55] 
.const [16] = Field [56] [57] 
.const [17] = Field [58] [59] 
.const [18] = Method [60] [61] 
.const [19] = Method [62] [63] 
.const [20] = Method [64] [65] 
.const [21] = Method [66] [67] 
.const [22] = Field [68] [69] 
.const [23] = Method [70] [71] 
.const [24] = Method [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Method [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Field [86] [87] 
.const [32] = Field [88] [89] 
.const [33] = Field [90] [91] 
.const [34] = InterfaceMethod [92] [93] 
.const [35] = InterfaceMethod [94] [95] 
.const [36] = Field [96] [97] 
.const [37] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [38] = Class [98] 
.const [39] = NameAndType [99] [100] 
.const [40] = Class [101] 
.const [41] = NameAndType [102] [103] 
.const [42] = Class [104] 
.const [43] = NameAndType [105] [106] 
.const [44] = Utf8 'AbstractTextureDescription#checkSize(String,bool) incorrect scaling for image %1' 
.const [45] = Class [107] 
.const [46] = NameAndType [108] [109] 
.const [47] = Utf8 java/lang/Object 
.const [48] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [49] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/ITextureCache 
.const [50] = Utf8 de/audi/atip/util/Util 
.const [51] = Utf8 java/lang/Math 
.const [52] = Utf8 de/audi/atip/log/LogChannel 
.const [53] = Utf8 java/lang/Float 
.const [54] = Class [110] 
.const [55] = NameAndType [111] [112] 
.const [56] = Class [113] 
.const [57] = NameAndType [114] [115] 
.const [58] = Class [116] 
.const [59] = NameAndType [117] [118] 
.const [60] = Class [119] 
.const [61] = NameAndType [120] [121] 
.const [62] = Class [122] 
.const [63] = NameAndType [123] [124] 
.const [64] = Class [125] 
.const [65] = NameAndType [126] [127] 
.const [66] = Class [128] 
.const [67] = NameAndType [129] [130] 
.const [68] = Class [131] 
.const [69] = NameAndType [132] [133] 
.const [70] = Class [134] 
.const [71] = NameAndType [135] [136] 
.const [72] = Class [137] 
.const [73] = NameAndType [138] [139] 
.const [74] = Class [140] 
.const [75] = NameAndType [141] [142] 
.const [76] = Class [143] 
.const [77] = NameAndType [144] [145] 
.const [78] = Class [146] 
.const [79] = NameAndType [147] [148] 
.const [80] = Class [149] 
.const [81] = NameAndType [150] [151] 
.const [82] = Class [152] 
.const [83] = NameAndType [153] [154] 
.const [84] = Class [155] 
.const [85] = NameAndType [156] [157] 
.const [86] = Class [158] 
.const [87] = NameAndType [159] [160] 
.const [88] = Class [161] 
.const [89] = NameAndType [162] [163] 
.const [90] = Class [164] 
.const [91] = NameAndType [165] [166] 
.const [92] = Class [167] 
.const [93] = NameAndType [168] [169] 
.const [94] = Class [170] 
.const [95] = NameAndType [171] [172] 
.const [96] = Class [173] 
.const [97] = NameAndType [174] [175] 
.const [98] = Utf8 de/audi/atip/util/Util 
.const [99] = Utf8 equals 
.const [100] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [101] = Utf8 java/lang/Math 
.const [102] = Utf8 min 
.const [103] = Utf8 (FF)F 
.const [104] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [105] = Utf8 logChannel3DEngine 
.const [106] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [107] = Utf8 java/lang/Float 
.const [108] = Utf8 isNaN 
.const [109] = Utf8 (F)Z 
.const [110] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [111] = Utf8 scaling 
.const [112] = Utf8 F 
.const [113] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [114] = Utf8 ealManager 
.const [115] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/EALManager; 
.const [116] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [117] = Utf8 cache 
.const [118] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/ITextureCache; 
.const [119] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [120] = Utf8 getTexture 
.const [121] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/TextureDescription;Ljava/lang/Object;)Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture; 
.const [122] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [123] = Utf8 getCache 
.const [124] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/eal/ITextureCache; 
.const [125] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [126] = Utf8 getCacheKey 
.const [127] = Utf8 ()Ljava/lang/Object; 
.const [128] = Utf8 java/lang/Object 
.const [129] = Utf8 hashCode 
.const [130] = Utf8 ()I 
.const [131] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [132] = Utf8 imgDimensions 
.const [133] = Utf8 [I 
.const [134] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [135] = Utf8 getImageHeaderInformation 
.const [136] = Utf8 (Ljava/lang/String;)[I 
.const [137] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [138] = Utf8 getUnscaledDimension 
.const [139] = Utf8 (Ljava/lang/String;)[I 
.const [140] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [141] = Utf8 getScreenWidth 
.const [142] = Utf8 ()I 
.const [143] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [144] = Utf8 getScreenHeight 
.const [145] = Utf8 ()I 
.const [146] = Utf8 de/audi/atip/log/LogChannel 
.const [147] = Utf8 log 
.const [148] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [149] = Utf8 java/lang/Object 
.const [150] = Utf8 <init> 
.const [151] = Utf8 ()V 
.const [152] = Utf8 java/lang/Object 
.const [153] = Utf8 getClass 
.const [154] = Utf8 ()Ljava/lang/Class; 
.const [155] = Utf8 java/lang/Object 
.const [156] = Utf8 hashCode 
.const [157] = Utf8 ()I 
.const [158] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [159] = Utf8 scaling 
.const [160] = Utf8 F 
.const [161] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [162] = Utf8 ealManager 
.const [163] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/EALManager; 
.const [164] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [165] = Utf8 cache 
.const [166] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/ITextureCache; 
.const [167] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/ITextureCache 
.const [168] = Utf8 getCachedTexture 
.const [169] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/TextureDescription;Ljava/lang/Object;)Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture; 
.const [170] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/ITextureCache 
.const [171] = Utf8 isTextureCached 
.const [172] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/TextureDescription;)Z 
.const [173] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [174] = Utf8 imgDimensions 
.const [175] = Utf8 [I 
.const [176] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [177] = Class [176] 
.const [178] = Utf8 java/lang/Object 
.const [179] = Class [178] 
.const [180] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescription 
.const [181] = Class [180] 
.const [182] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [183] = Class [182] 
.const [184] = Utf8 ealManager 
.const [185] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/EALManager; 
.const [186] = Utf8 cache 
.const [187] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/ITextureCache; 
.const [188] = Utf8 imgDimensions 
.const [189] = Utf8 [I 
.const [190] = Utf8 scaling 
.const [191] = Utf8 F 
.const [192] = Utf8 Code 
.const [193] = Utf8 <init> 
.const [194] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/EALManager;Lde/esolutions/hmi/widgets/audi/base/eal/ITextureCache;)V 
.const [195] = Utf8 getCache 
.const [196] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/eal/ITextureCache; 
.const [197] = Utf8 getTexture 
.const [198] = Utf8 (Ljava/lang/Object;)Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture; 
.const [199] = Utf8 getCachedTexture 
.const [200] = Utf8 (Ljava/lang/Object;)Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture; 
.const [201] = Utf8 isTextureCached 
.const [202] = Utf8 ()Z 
.const [203] = Utf8 equals 
.const [204] = Utf8 (Ljava/lang/Object;)Z 
.const [205] = Utf8 hashCode 
.const [206] = Utf8 ()I 
.const [207] = Utf8 preventRTLFlip 
.const [208] = Utf8 ()Z 
.const [209] = Utf8 getDepthsInByte 
.const [210] = Utf8 ()I 
.const [211] = Utf8 getUnscaledDimension 
.const [212] = Utf8 (Ljava/lang/String;)[I 
.const [213] = Utf8 checkSize 
.const [214] = Utf8 (Ljava/lang/String;Z)Z 
.const [215] = Utf8 getScaleFactor 
.const [216] = Utf8 ()F 
.end class 
