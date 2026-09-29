.version 50 0 
.class public super [223] 
.super [225] 
.field private final [226] [227] 
.field private final [228] [229] 
.field private [230] [231] 

.method public [233] : [234] 
    .attribute [232] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_3 
L3:     invokespecial [39] 
L6:     aload_0 
L7:     iconst_0 
L8:     putfield [43] 
L11:    aload_0 
L12:    iload 4 
L14:    putfield [44] 
L17:    aload_0 
L18:    aload_2 
L19:    putfield [45] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [232] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     iload 4 
L6:     invokespecial [40] 
L9:     aload_0 
L10:    iload 5 
L12:    putfield [43] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [237] : [238] 
    .attribute [232] .code stack 5 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     aload_0 
L4:     getfield [20] 
L7:     invokevirtual [21] 
L10:    aload_0 
L11:    getfield [18] 
L14:    invokevirtual [22] 
L17:    ifeq L22 
L20:    aconst_null 
L21:    areturn 
L22:    aload_0 
L23:    getfield [23] 
L26:    fconst_1 
L27:    fcmpg 
L28:    ifge L76 
L31:    aload_0 
L32:    getfield [24] 
L35:    aload_0 
L36:    getfield [20] 
L39:    aload_0 
L40:    getfield [25] 
L43:    iconst_0 
L44:    iaload 
L45:    i2f 
L46:    aload_0 
L47:    getfield [23] 
L50:    fmul 
L51:    invokestatic [2] 
L54:    aload_0 
L55:    getfield [25] 
L58:    iconst_1 
L59:    iaload 
L60:    i2f 
L61:    aload_0 
L62:    getfield [23] 
L65:    fmul 
L66:    invokestatic [2] 
L69:    invokevirtual [26] 
L72:    astore_1 
L73:    goto L88 
L76:    aload_0 
L77:    getfield [24] 
L80:    aload_0 
L81:    getfield [20] 
L84:    invokevirtual [27] 
L87:    astore_1 
L88:    aload_1 
L89:    ifnonnull L107 
L92:    getstatic [3] 
L95:    sipush 10000 
L98:    ldc [4] 
L100:   aload_0 
L101:   invokevirtual [28] 
L104:   pop 
L105:   aconst_null 
L106:   areturn 
L107:   aload_0 
L108:   getfield [20] 
L111:   invokevirtual [29] 
L114:   aload_0 
L115:   getfield [19] 
L118:   invokestatic [5] 
L121:   astore_2 
L122:   aload_0 
L123:   getfield [24] 
L126:   aload_1 
L127:   aload_2 
L128:   invokevirtual [30] 
L131:   astore_3 
L132:   aload_0 
L133:   getfield [24] 
L136:   aload_1 
L137:   invokevirtual [31] 
L140:   aload_3 
L141:   ifnonnull L159 
L144:   getstatic [3] 
L147:   sipush 10000 
L150:   ldc [6] 
L152:   aload_0 
L153:   invokevirtual [28] 
L156:   pop 
L157:   aconst_null 
L158:   areturn 
L159:   new [46] 
L162:   dup 
L163:   aload_3 
L164:   aload_0 
L165:   aload_0 
L166:   getfield [24] 
L169:   invokespecial [41] 
L172:   astore 4 
L174:   aload 4 
L176:   areturn 
L177:   nop 
L178:   nop 
L179:   nop 
L180:   
    .end code 
.end method 

.method public [239] : [240] 
    .attribute [232] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     invokevirtual [21] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [241] : [242] 
    .attribute [232] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [32] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [243] : [244] 
    .attribute [232] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [20] 
L5:     invokevirtual [21] 
L8:     invokevirtual [33] 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [232] .code stack 1 locals 0 
L0:     aconst_null 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [232] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     invokevirtual [34] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [249] : [250] 
    .attribute [232] .code stack 2 locals 1 
L0:     new [47] 
L3:     dup 
L4:     invokespecial [42] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [9] 
L11:    invokevirtual [35] 
L14:    pop 
L15:    aload_1 
L16:    aload_0 
L17:    invokevirtual [36] 
L20:    invokevirtual [37] 
L23:    pop 
L24:    aload_1 
L25:    ldc [10] 
L27:    invokevirtual [35] 
L30:    pop 
L31:    aload_1 
L32:    invokevirtual [38] 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public [251] : [252] 
    .attribute [232] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     invokevirtual [29] 
L7:     invokestatic [11] 
L10:    areturn 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [48] [49] 
.const [3] = Field [50] [51] 
.const [4] = String [52] 
.const [5] = Method [53] [54] 
.const [6] = String [55] 
.const [7] = Class [56] 
.const [8] = Class [57] 
.const [9] = String [58] 
.const [10] = String [59] 
.const [11] = Method [60] [61] 
.const [12] = Class [62] 
.const [13] = Class [63] 
.const [14] = Class [64] 
.const [15] = Class [65] 
.const [16] = Class [66] 
.const [17] = Class [67] 
.const [18] = Field [68] [69] 
.const [19] = Field [70] [71] 
.const [20] = Field [72] [73] 
.const [21] = Method [74] [75] 
.const [22] = Method [76] [77] 
.const [23] = Field [78] [79] 
.const [24] = Field [80] [81] 
.const [25] = Field [82] [83] 
.const [26] = Method [84] [85] 
.const [27] = Method [86] [87] 
.const [28] = Method [88] [89] 
.const [29] = Method [90] [91] 
.const [30] = Method [92] [93] 
.const [31] = Method [94] [95] 
.const [32] = Method [96] [97] 
.const [33] = Method [98] [99] 
.const [34] = Method [100] [101] 
.const [35] = Method [102] [103] 
.const [36] = Method [104] [105] 
.const [37] = Method [106] [107] 
.const [38] = Method [108] [109] 
.const [39] = Method [110] [111] 
.const [40] = Method [112] [113] 
.const [41] = Method [114] [115] 
.const [42] = Method [116] [117] 
.const [43] = Field [118] [119] 
.const [44] = Field [120] [121] 
.const [45] = Field [122] [123] 
.const [46] = Class [124] 
.const [47] = Class [125] 
.const [48] = Class [126] 
.const [49] = NameAndType [127] [128] 
.const [50] = Class [129] 
.const [51] = NameAndType [130] [131] 
.const [52] = Utf8 'TextureDescriptionHMIImage#createTexture could not load image for %1' 
.const [53] = Class [132] 
.const [54] = NameAndType [133] [134] 
.const [55] = Utf8 'TextureDescriptionHMIImage#createTexture could not create texture for %1' 
.const [56] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedTexture 
.const [57] = Utf8 java/lang/StringBuffer 
.const [58] = Utf8 'TextureDescriptionHMIImage [getCacheKey()=' 
.const [59] = Utf8 ']' 
.const [60] = Class [135] 
.const [61] = NameAndType [136] [137] 
.const [62] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionHMIImage 
.const [63] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [64] = Utf8 de/esolutions/hmi/widgets/audi/base/HMIImage 
.const [65] = Utf8 java/lang/Math 
.const [66] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [67] = Utf8 de/audi/atip/log/LogChannel 
.const [68] = Class [138] 
.const [69] = NameAndType [139] [140] 
.const [70] = Class [141] 
.const [71] = NameAndType [142] [143] 
.const [72] = Class [144] 
.const [73] = NameAndType [145] [146] 
.const [74] = Class [147] 
.const [75] = NameAndType [148] [149] 
.const [76] = Class [150] 
.const [77] = NameAndType [151] [152] 
.const [78] = Class [153] 
.const [79] = NameAndType [154] [155] 
.const [80] = Class [156] 
.const [81] = NameAndType [157] [158] 
.const [82] = Class [159] 
.const [83] = NameAndType [160] [161] 
.const [84] = Class [162] 
.const [85] = NameAndType [163] [164] 
.const [86] = Class [165] 
.const [87] = NameAndType [166] [167] 
.const [88] = Class [168] 
.const [89] = NameAndType [169] [170] 
.const [90] = Class [171] 
.const [91] = NameAndType [172] [173] 
.const [92] = Class [174] 
.const [93] = NameAndType [175] [176] 
.const [94] = Class [177] 
.const [95] = NameAndType [178] [179] 
.const [96] = Class [180] 
.const [97] = NameAndType [181] [182] 
.const [98] = Class [183] 
.const [99] = NameAndType [184] [185] 
.const [100] = Class [186] 
.const [101] = NameAndType [187] [188] 
.const [102] = Class [189] 
.const [103] = NameAndType [190] [191] 
.const [104] = Class [192] 
.const [105] = NameAndType [193] [194] 
.const [106] = Class [195] 
.const [107] = NameAndType [196] [197] 
.const [108] = Class [198] 
.const [109] = NameAndType [199] [200] 
.const [110] = Class [201] 
.const [111] = NameAndType [202] [203] 
.const [112] = Class [204] 
.const [113] = NameAndType [205] [206] 
.const [114] = Class [207] 
.const [115] = NameAndType [208] [209] 
.const [116] = Class [210] 
.const [117] = NameAndType [211] [212] 
.const [118] = Class [213] 
.const [119] = NameAndType [214] [215] 
.const [120] = Class [216] 
.const [121] = NameAndType [217] [218] 
.const [122] = Class [219] 
.const [123] = NameAndType [220] [221] 
.const [124] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedTexture 
.const [125] = Utf8 java/lang/StringBuffer 
.const [126] = Utf8 java/lang/Math 
.const [127] = Utf8 round 
.const [128] = Utf8 (F)I 
.const [129] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionHMIImage 
.const [130] = Utf8 logChannel3DEngine 
.const [131] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [132] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [133] = Utf8 getTextureFlags 
.const [134] = Utf8 (IZ)Lde/esolutions/graphics/eal/FlagTexture; 
.const [135] = Utf8 de/esolutions/hmi/widgets/audi/base/HMIImage 
.const [136] = Utf8 getNumBytesPerPixel 
.const [137] = Utf8 (I)I 
.const [138] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionHMIImage 
.const [139] = Utf8 useSizeCheck 
.const [140] = Utf8 Z 
.const [141] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionHMIImage 
.const [142] = Utf8 useEalAtlas 
.const [143] = Utf8 Z 
.const [144] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionHMIImage 
.const [145] = Utf8 image 
.const [146] = Utf8 Lde/esolutions/hmi/widgets/audi/base/HMIImage; 
.const [147] = Utf8 de/esolutions/hmi/widgets/audi/base/HMIImage 
.const [148] = Utf8 getPath 
.const [149] = Utf8 ()Ljava/lang/String; 
.const [150] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionHMIImage 
.const [151] = Utf8 checkSize 
.const [152] = Utf8 (Ljava/lang/String;Z)Z 
.const [153] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionHMIImage 
.const [154] = Utf8 scaling 
.const [155] = Utf8 F 
.const [156] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionHMIImage 
.const [157] = Utf8 ealManager 
.const [158] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/EALManager; 
.const [159] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionHMIImage 
.const [160] = Utf8 imgDimensions 
.const [161] = Utf8 [I 
.const [162] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [163] = Utf8 createEALImage 
.const [164] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/HMIImage;II)Lde/esolutions/graphics/eal/api/IImage; 
.const [165] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [166] = Utf8 createEALImage 
.const [167] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/HMIImage;)Lde/esolutions/graphics/eal/api/IImage; 
.const [168] = Utf8 de/audi/atip/log/LogChannel 
.const [169] = Utf8 log 
.const [170] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [171] = Utf8 de/esolutions/hmi/widgets/audi/base/HMIImage 
.const [172] = Utf8 getFormat 
.const [173] = Utf8 ()I 
.const [174] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [175] = Utf8 createTexture 
.const [176] = Utf8 (Lde/esolutions/graphics/eal/api/IImage;Lde/esolutions/graphics/eal/FlagTexture;)Lde/esolutions/graphics/eal/api/ITexture; 
.const [177] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/EALManager 
.const [178] = Utf8 destroy 
.const [179] = Utf8 (Lde/esolutions/graphics/eal/api/IObject;)V 
.const [180] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionHMIImage 
.const [181] = Utf8 getPath 
.const [182] = Utf8 ()Ljava/lang/String; 
.const [183] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionHMIImage 
.const [184] = Utf8 getUnscaledDimension 
.const [185] = Utf8 (Ljava/lang/String;)[I 
.const [186] = Utf8 de/esolutions/hmi/widgets/audi/base/HMIImage 
.const [187] = Utf8 getPreventRTLFlipFlag 
.const [188] = Utf8 ()Z 
.const [189] = Utf8 java/lang/StringBuffer 
.const [190] = Utf8 append 
.const [191] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [192] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionHMIImage 
.const [193] = Utf8 getCacheKey 
.const [194] = Utf8 ()Ljava/lang/Object; 
.const [195] = Utf8 java/lang/StringBuffer 
.const [196] = Utf8 append 
.const [197] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [198] = Utf8 java/lang/StringBuffer 
.const [199] = Utf8 toString 
.const [200] = Utf8 ()Ljava/lang/String; 
.const [201] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [202] = Utf8 <init> 
.const [203] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/EALManager;Lde/esolutions/hmi/widgets/audi/base/eal/ITextureCache;)V 
.const [204] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionHMIImage 
.const [205] = Utf8 <init> 
.const [206] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/EALManager;Lde/esolutions/hmi/widgets/audi/base/HMIImage;Lde/esolutions/hmi/widgets/audi/base/eal/ITextureCache;Z)V 
.const [207] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedTexture 
.const [208] = Utf8 <init> 
.const [209] = Utf8 (Lde/esolutions/graphics/eal/api/ITexture;Lde/esolutions/hmi/widgets/audi/base/eal/TextureDescription;Lde/esolutions/hmi/widgets/audi/base/eal/EALManager;)V 
.const [210] = Utf8 java/lang/StringBuffer 
.const [211] = Utf8 <init> 
.const [212] = Utf8 ()V 
.const [213] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionHMIImage 
.const [214] = Utf8 useSizeCheck 
.const [215] = Utf8 Z 
.const [216] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionHMIImage 
.const [217] = Utf8 useEalAtlas 
.const [218] = Utf8 Z 
.const [219] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionHMIImage 
.const [220] = Utf8 image 
.const [221] = Utf8 Lde/esolutions/hmi/widgets/audi/base/HMIImage; 
.const [222] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescriptionHMIImage 
.const [223] = Class [222] 
.const [224] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractTextureDescription 
.const [225] = Class [224] 
.const [226] = Utf8 useEalAtlas 
.const [227] = Utf8 Z 
.const [228] = Utf8 image 
.const [229] = Utf8 Lde/esolutions/hmi/widgets/audi/base/HMIImage; 
.const [230] = Utf8 useSizeCheck 
.const [231] = Utf8 Z 
.const [232] = Utf8 Code 
.const [233] = Utf8 <init> 
.const [234] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/EALManager;Lde/esolutions/hmi/widgets/audi/base/HMIImage;Lde/esolutions/hmi/widgets/audi/base/eal/ITextureCache;Z)V 
.const [235] = Utf8 <init> 
.const [236] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/EALManager;Lde/esolutions/hmi/widgets/audi/base/HMIImage;Lde/esolutions/hmi/widgets/audi/base/eal/ITextureCache;ZZ)V 
.const [237] = Utf8 createTexture 
.const [238] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture; 
.const [239] = Utf8 getPath 
.const [240] = Utf8 ()Ljava/lang/String; 
.const [241] = Utf8 getCacheKey 
.const [242] = Utf8 ()Ljava/lang/Object; 
.const [243] = Utf8 getUnscaledDimension 
.const [244] = Utf8 ()[I 
.const [245] = Utf8 getImageFlags 
.const [246] = Utf8 ()Lde/esolutions/graphics/eal/FlagImage; 
.const [247] = Utf8 preventRTLFlip 
.const [248] = Utf8 ()Z 
.const [249] = Utf8 toString 
.const [250] = Utf8 ()Ljava/lang/String; 
.const [251] = Utf8 getDepthsInByte 
.const [252] = Utf8 ()I 
.end class 
