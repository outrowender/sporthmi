.version 50 0 
.class public super [194] 
.super [196] 
.field [197] [198] 
.field private static [199] [200] 

.method private [202] : [203] 
    .attribute [201] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     new [37] 
L8:     dup 
L9:     sipush 500 
L12:    invokespecial [34] 
L15:    putfield [38] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public static synchronized [204] : [205] 
    .attribute [201] .code stack 2 locals 0 
L0:     getstatic [3] 
L3:     ifnonnull L24 
L6:     new [39] 
L9:     dup 
L10:    invokespecial [36] 
L13:    putstatic [35] 
L16:    getstatic [5] 
L19:    ldc [6] 
L21:    invokevirtual [19] 
L24:    getstatic [3] 
L27:    areturn 
L28:    
    .end code 
.end method 

.method public [206] : [207] 
    .attribute [201] .code stack 2 locals 1 
L0:     aload_1 
L1:     instanceof [7] 
L4:     ifeq L20 
L7:     aload_1 
L8:     checkcast [7] 
L11:    astore_3 
L12:    aload_3 
L13:    aload_2 
L14:    invokeinterface [40] 0 
L19:    areturn 
L20:    iconst_1 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [208] : [209] 
    .attribute [201] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [18] 
L4:     iload_1 
L5:     invokevirtual [20] 
L8:     checkcast [8] 
L11:    astore_2 
L12:    getstatic [5] 
L15:    invokevirtual [21] 
L18:    ifne L30 
L21:    getstatic [9] 
L24:    invokevirtual [21] 
L27:    ifeq L57 
L30:    aload_2 
L31:    instanceof [7] 
L34:    ifeq L43 
L37:    getstatic [5] 
L40:    goto L46 
L43:    getstatic [9] 
L46:    astore_3 
L47:    aload_3 
L48:    ldc [6] 
L50:    ldc [10] 
L52:    aload_2 
L53:    invokevirtual [22] 
L56:    pop 
L57:    aload_2 
L58:    areturn 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [210] : [211] 
    .attribute [201] .code stack 4 locals 3 
L0:     aload_1 
L1:     invokevirtual [23] 
L4:     astore_2 
L5:     aload_2 
L6:     ifnonnull L11 
L9:     aconst_null 
L10:    areturn 
L11:    aload_0 
L12:    getfield [18] 
L15:    aload_2 
L16:    invokevirtual [24] 
L19:    invokevirtual [20] 
L22:    checkcast [8] 
L25:    astore_3 
L26:    getstatic [5] 
L29:    invokevirtual [21] 
L32:    ifne L44 
L35:    getstatic [9] 
L38:    invokevirtual [21] 
L41:    ifeq L73 
L44:    aload_3 
L45:    instanceof [7] 
L48:    ifeq L57 
L51:    getstatic [5] 
L54:    goto L60 
L57:    getstatic [9] 
L60:    astore 4 
L62:    aload 4 
L64:    ldc [6] 
L66:    ldc [10] 
L68:    aload_3 
L69:    invokevirtual [22] 
L72:    pop 
L73:    aload_3 
L74:    areturn 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [212] : [213] 
    .attribute [201] .code stack 2 locals 2 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     aconst_null 
L5:     areturn 
L6:     aload_1 
L7:     invokeinterface [41] 0 
L12:    astore_2 
L13:    aload_2 
L14:    ifnonnull L19 
L17:    aconst_null 
L18:    areturn 
L19:    aload_0 
L20:    aload_2 
L21:    invokevirtual [25] 
L24:    invokevirtual [26] 
L27:    astore_3 
L28:    aload_3 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [214] : [215] 
    .attribute [201] .code stack 1 locals 0 
L0:     aload_1 
L1:     instanceof [7] 
L4:     ifeq L19 
L7:     aload_1 
L8:     checkcast [7] 
L11:    invokeinterface [42] 0 
L16:    goto L20 
L19:    aconst_null 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [216] : [217] 
    .attribute [201] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     iload_1 
L5:     invokevirtual [20] 
L8:     ifnull L15 
L11:    iconst_1 
L12:    goto L16 
L15:    iconst_0 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [218] : [219] 
    .attribute [201] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     aload_1 
L5:     invokevirtual [23] 
L8:     invokevirtual [24] 
L11:    invokevirtual [20] 
L14:    ifnull L21 
L17:    iconst_1 
L18:    goto L22 
L21:    iconst_0 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [220] : [221] 
    .attribute [201] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     aload_1 
L5:     invokeinterface [41] 0 
L10:    invokevirtual [25] 
L13:    invokevirtual [20] 
L16:    ifnull L23 
L19:    iconst_1 
L20:    goto L24 
L23:    iconst_0 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [222] : [223] 
    .attribute [201] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnull L13 
L4:     aload_1 
L5:     invokeinterface [41] 0 
L10:    ifnonnull L15 
L13:    aconst_null 
L14:    areturn 
L15:    aconst_null 
L16:    astore_2 
L17:    aload_1 
L18:    invokeinterface [41] 0 
L23:    invokevirtual [25] 
L26:    istore_3 
L27:    aload_0 
L28:    iload_3 
L29:    invokevirtual [27] 
L32:    ifeq L44 
L35:    aload_0 
L36:    iload_3 
L37:    invokevirtual [26] 
L40:    astore_2 
L41:    goto L55 
L44:    aload_0 
L45:    getfield [18] 
L48:    iload_3 
L49:    aload_1 
L50:    invokevirtual [28] 
L53:    aload_1 
L54:    astore_2 
L55:    aload_2 
L56:    areturn 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [224] : [225] 
    .attribute [201] .code stack 4 locals 2 
L0:     aload_1 
L1:     ifnull L22 
L4:     aload_1 
L5:     invokeinterface [43] 0 
L10:    ifnull L22 
L13:    aload_1 
L14:    invokeinterface [41] 0 
L19:    ifnonnull L23 
L22:    return 
L23:    aload_1 
L24:    invokeinterface [41] 0 
L29:    astore_2 
L30:    aconst_null 
L31:    astore_3 
L32:    getstatic [5] 
L35:    invokevirtual [21] 
L38:    ifne L50 
L41:    getstatic [9] 
L44:    invokevirtual [21] 
L47:    ifeq L67 
L50:    aload_1 
L51:    instanceof [7] 
L54:    ifeq L63 
L57:    getstatic [5] 
L60:    goto L66 
L63:    getstatic [9] 
L66:    astore_3 
L67:    aload_3 
L68:    ifnull L101 
L71:    aload_0 
L72:    aload_1 
L73:    invokevirtual [29] 
L76:    ifne L91 
L79:    aload_3 
L80:    ldc [6] 
L82:    ldc [11] 
L84:    invokevirtual [30] 
L87:    pop 
L88:    goto L101 
L91:    aload_3 
L92:    ldc [6] 
L94:    ldc [12] 
L96:    aload_1 
L97:    invokevirtual [22] 
L100:   pop 
L101:   aload_2 
L102:   instanceof [8] 
L105:   ifne L119 
L108:   aload_0 
L109:   getfield [18] 
L112:   aload_2 
L113:   invokevirtual [25] 
L116:   invokevirtual [31] 
L119:   return 
L120:   
    .end code 
.end method 

.method public [226] : [227] 
    .attribute [201] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     invokevirtual [32] 
L7:     aconst_null 
L8:     putstatic [35] 
L11:    return 
L12:    
    .end code 
.end method 

.method static [228] : [229] 
    .attribute [201] .code stack 1 locals 0 
L0:     aconst_null 
L1:     putstatic [35] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [44] 
.const [3] = Field [45] [46] 
.const [4] = Class [47] 
.const [5] = Field [48] [49] 
.const [6] = Int -2137614336 
.const [7] = Class [50] 
.const [8] = Class [51] 
.const [9] = Field [52] [53] 
.const [10] = String [54] 
.const [11] = String [55] 
.const [12] = String [56] 
.const [13] = Class [57] 
.const [14] = Class [58] 
.const [15] = Class [59] 
.const [16] = Class [60] 
.const [17] = Class [61] 
.const [18] = Field [62] [63] 
.const [19] = Method [64] [65] 
.const [20] = Method [66] [67] 
.const [21] = Method [68] [69] 
.const [22] = Method [70] [71] 
.const [23] = Method [72] [73] 
.const [24] = Method [74] [75] 
.const [25] = Method [76] [77] 
.const [26] = Method [78] [79] 
.const [27] = Method [80] [81] 
.const [28] = Method [82] [83] 
.const [29] = Method [84] [85] 
.const [30] = Method [86] [87] 
.const [31] = Method [88] [89] 
.const [32] = Method [90] [91] 
.const [33] = Method [92] [93] 
.const [34] = Method [94] [95] 
.const [35] = Field [96] [97] 
.const [36] = Method [98] [99] 
.const [37] = Class [100] 
.const [38] = Field [101] [102] 
.const [39] = Class [103] 
.const [40] = InterfaceMethod [104] [105] 
.const [41] = InterfaceMethod [106] [107] 
.const [42] = InterfaceMethod [108] [109] 
.const [43] = InterfaceMethod [110] [111] 
.const [44] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [45] = Class [112] 
.const [46] = NameAndType [113] [114] 
.const [47] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/async/TextureDescriptionManager 
.const [48] = Class [115] 
.const [49] = NameAndType [116] [117] 
.const [50] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/async/ITexDescrAsyncStates 
.const [51] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescription 
.const [52] = Class [118] 
.const [53] = NameAndType [119] [120] 
.const [54] = Utf8 'TextureDescriptionManager#getCachedTextureDescription the cached reference is %1' 
.const [55] = Utf8 'TextureDescriptionManager#removeTextureDescription description is not cached.' 
.const [56] = Utf8 'TextureDescriptionManager#removeTextureDescription removing descr: %1' 
.const [57] = Utf8 java/lang/Object 
.const [58] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [59] = Utf8 de/audi/atip/log/LogChannel 
.const [60] = Utf8 de/esolutions/hmi/widgets/audi/base/HMIImage 
.const [61] = Utf8 java/lang/String 
.const [62] = Class [121] 
.const [63] = NameAndType [122] [123] 
.const [64] = Class [124] 
.const [65] = NameAndType [125] [126] 
.const [66] = Class [127] 
.const [67] = NameAndType [128] [129] 
.const [68] = Class [130] 
.const [69] = NameAndType [131] [132] 
.const [70] = Class [133] 
.const [71] = NameAndType [134] [135] 
.const [72] = Class [136] 
.const [73] = NameAndType [137] [138] 
.const [74] = Class [139] 
.const [75] = NameAndType [140] [141] 
.const [76] = Class [142] 
.const [77] = NameAndType [143] [144] 
.const [78] = Class [145] 
.const [79] = NameAndType [146] [147] 
.const [80] = Class [148] 
.const [81] = NameAndType [149] [150] 
.const [82] = Class [151] 
.const [83] = NameAndType [152] [153] 
.const [84] = Class [154] 
.const [85] = NameAndType [155] [156] 
.const [86] = Class [157] 
.const [87] = NameAndType [158] [159] 
.const [88] = Class [160] 
.const [89] = NameAndType [161] [162] 
.const [90] = Class [163] 
.const [91] = NameAndType [164] [165] 
.const [92] = Class [166] 
.const [93] = NameAndType [167] [168] 
.const [94] = Class [169] 
.const [95] = NameAndType [170] [171] 
.const [96] = Class [172] 
.const [97] = NameAndType [173] [174] 
.const [98] = Class [175] 
.const [99] = NameAndType [176] [177] 
.const [100] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [101] = Class [178] 
.const [102] = NameAndType [179] [180] 
.const [103] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/async/TextureDescriptionManager 
.const [104] = Class [181] 
.const [105] = NameAndType [182] [183] 
.const [106] = Class [184] 
.const [107] = NameAndType [185] [186] 
.const [108] = Class [187] 
.const [109] = NameAndType [188] [189] 
.const [110] = Class [190] 
.const [111] = NameAndType [191] [192] 
.const [112] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/async/TextureDescriptionManager 
.const [113] = Utf8 instance 
.const [114] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/async/TextureDescriptionManager; 
.const [115] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [116] = Utf8 logImageAsync 
.const [117] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [118] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [119] = Utf8 logImage 
.const [120] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [121] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/async/TextureDescriptionManager 
.const [122] = Utf8 hashTexDescrMap 
.const [123] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntObjectMap; 
.const [124] = Utf8 de/audi/atip/log/LogChannel 
.const [125] = Utf8 setLogThreshold 
.const [126] = Utf8 (I)V 
.const [127] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [128] = Utf8 get 
.const [129] = Utf8 (I)Ljava/lang/Object; 
.const [130] = Utf8 de/audi/atip/log/LogChannel 
.const [131] = Utf8 isDebug 
.const [132] = Utf8 ()Z 
.const [133] = Utf8 de/audi/atip/log/LogChannel 
.const [134] = Utf8 log 
.const [135] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [136] = Utf8 de/esolutions/hmi/widgets/audi/base/HMIImage 
.const [137] = Utf8 getPath 
.const [138] = Utf8 ()Ljava/lang/String; 
.const [139] = Utf8 java/lang/String 
.const [140] = Utf8 hashCode 
.const [141] = Utf8 ()I 
.const [142] = Utf8 java/lang/Object 
.const [143] = Utf8 hashCode 
.const [144] = Utf8 ()I 
.const [145] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/async/TextureDescriptionManager 
.const [146] = Utf8 getCachedTextureDescription 
.const [147] = Utf8 (I)Lde/esolutions/hmi/widgets/audi/base/eal/TextureDescription; 
.const [148] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/async/TextureDescriptionManager 
.const [149] = Utf8 hasTextureDescription 
.const [150] = Utf8 (I)Z 
.const [151] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [152] = Utf8 add 
.const [153] = Utf8 (ILjava/lang/Object;)V 
.const [154] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/async/TextureDescriptionManager 
.const [155] = Utf8 hasTextureDescription 
.const [156] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/TextureDescription;)Z 
.const [157] = Utf8 de/audi/atip/log/LogChannel 
.const [158] = Utf8 log 
.const [159] = Utf8 (ILjava/lang/String;)Z 
.const [160] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [161] = Utf8 remove 
.const [162] = Utf8 (I)V 
.const [163] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [164] = Utf8 clear 
.const [165] = Utf8 ()V 
.const [166] = Utf8 java/lang/Object 
.const [167] = Utf8 <init> 
.const [168] = Utf8 ()V 
.const [169] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [170] = Utf8 <init> 
.const [171] = Utf8 (I)V 
.const [172] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/async/TextureDescriptionManager 
.const [173] = Utf8 instance 
.const [174] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/async/TextureDescriptionManager; 
.const [175] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/async/TextureDescriptionManager 
.const [176] = Utf8 <init> 
.const [177] = Utf8 ()V 
.const [178] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/async/TextureDescriptionManager 
.const [179] = Utf8 hashTexDescrMap 
.const [180] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntObjectMap; 
.const [181] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/async/ITexDescrAsyncStates 
.const [182] = Utf8 removeReceiver 
.const [183] = Utf8 (Ljava/lang/Object;)Z 
.const [184] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescription 
.const [185] = Utf8 getCacheKey 
.const [186] = Utf8 ()Ljava/lang/Object; 
.const [187] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/async/ITexDescrAsyncStates 
.const [188] = Utf8 getIUpdatableReceiver 
.const [189] = Utf8 ()Ljava/util/Set; 
.const [190] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/TextureDescription 
.const [191] = Utf8 getCache 
.const [192] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/eal/ITextureCache; 
.const [193] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/async/TextureDescriptionManager 
.const [194] = Class [193] 
.const [195] = Utf8 java/lang/Object 
.const [196] = Class [195] 
.const [197] = Utf8 hashTexDescrMap 
.const [198] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntObjectMap; 
.const [199] = Utf8 instance 
.const [200] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/async/TextureDescriptionManager; 
.const [201] = Utf8 Code 
.const [202] = Utf8 <init> 
.const [203] = Utf8 ()V 
.const [204] = Utf8 getInstance 
.const [205] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/eal/async/TextureDescriptionManager; 
.const [206] = Utf8 cancelRequest 
.const [207] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/TextureDescription;Ljava/lang/Object;)Z 
.const [208] = Utf8 getCachedTextureDescription 
.const [209] = Utf8 (I)Lde/esolutions/hmi/widgets/audi/base/eal/TextureDescription; 
.const [210] = Utf8 getCachedTextureDescription 
.const [211] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/HMIImage;)Lde/esolutions/hmi/widgets/audi/base/eal/TextureDescription; 
.const [212] = Utf8 getCachedTextureDescription 
.const [213] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/TextureDescription;)Lde/esolutions/hmi/widgets/audi/base/eal/TextureDescription; 
.const [214] = Utf8 getReferences 
.const [215] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/TextureDescription;)Ljava/util/Set; 
.const [216] = Utf8 hasTextureDescription 
.const [217] = Utf8 (I)Z 
.const [218] = Utf8 hasTextureDescription 
.const [219] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/HMIImage;)Z 
.const [220] = Utf8 hasTextureDescription 
.const [221] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/TextureDescription;)Z 
.const [222] = Utf8 put 
.const [223] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/TextureDescription;)Lde/esolutions/hmi/widgets/audi/base/eal/TextureDescription; 
.const [224] = Utf8 removeTextureDescription 
.const [225] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/TextureDescription;)V 
.const [226] = Utf8 resetManager 
.const [227] = Utf8 ()V 
.const [228] = Utf8 <clinit> 
.const [229] = Utf8 ()V 
.end class 
