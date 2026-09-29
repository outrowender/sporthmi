.version 50 0 
.class super [206] 
.super [208] 
.field private final [209] [210] 
.field private [211] [212] 
.field private [213] [214] 

.method private [216] : [217] 
    .attribute [215] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [36] 
L4:     aload_0 
L5:     new [41] 
L8:     dup 
L9:     invokespecial [37] 
L12:    putfield [40] 
L15:    aload_0 
L16:    aload_1 
L17:    putfield [42] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [218] : [219] 
    .attribute [215] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     invokevirtual [20] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method private [220] : [221] 
    .attribute [215] .code stack 6 locals 3 
L0:     aload_0 
L1:     getfield [18] 
L4:     invokevirtual [20] 
L7:     ifgt L41 
L10:    getstatic [3] 
L13:    sipush 10000 
L16:    ldc [4] 
L18:    aload_1 
L19:    invokevirtual [21] 
L22:    pop 
L23:    getstatic [3] 
L26:    sipush 10000 
L29:    ldc [5] 
L31:    aload_0 
L32:    getfield [19] 
L35:    invokevirtual [21] 
L38:    pop 
L39:    iconst_0 
L40:    areturn 
L41:    aload_0 
L42:    invokespecial [38] 
L45:    ifne L171 
L48:    aload_0 
L49:    getfield [18] 
L52:    invokevirtual [20] 
L55:    istore_2 
L56:    aload_0 
L57:    getfield [18] 
L60:    invokevirtual [22] 
L63:    astore_3 
L64:    aload_3 
L65:    invokeinterface [43] 0 
L70:    ifeq L125 
L73:    aload_3 
L74:    invokeinterface [44] 0 
L79:    astore 4 
L81:    aload 4 
L83:    aload_1 
L84:    invokevirtual [23] 
L87:    ifeq L122 
L90:    aload_3 
L91:    invokeinterface [45] 0 
L96:    getstatic [3] 
L99:    ldc [6] 
L101:   ldc [7] 
L103:   aload_0 
L104:   getfield [19] 
L107:   aload_0 
L108:   getfield [18] 
L111:   invokevirtual [20] 
L114:   i2l 
L115:   invokevirtual [24] 
L118:   pop 
L119:   goto L125 
L122:   goto L64 
L125:   iload_2 
L126:   aload_0 
L127:   getfield [18] 
L130:   invokevirtual [20] 
L133:   if_icmpne L171 
L136:   getstatic [3] 
L139:   sipush 10000 
L142:   ldc [8] 
L144:   aload_1 
L145:   invokevirtual [21] 
L148:   pop 
L149:   getstatic [3] 
L152:   sipush 10000 
L155:   ldc [9] 
L157:   aload_0 
L158:   getfield [18] 
L161:   invokevirtual [20] 
L164:   i2l 
L165:   invokevirtual [25] 
L168:   pop 
L169:   iconst_0 
L170:   areturn 
L171:   iconst_1 
L172:   areturn 
L173:   nop 
L174:   nop 
L175:   nop 
L176:   
    .end code 
.end method 

.method private [222] : [223] 
    .attribute [215] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     ifeq L21 
L7:     aload_0 
L8:     getfield [18] 
L11:    invokevirtual [20] 
L14:    ifgt L21 
L17:    iconst_1 
L18:    goto L22 
L21:    iconst_0 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method private [224] : [225] 
    .attribute [215] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     invokevirtual [26] 
L7:     ifne L28 
L10:    aload_0 
L11:    aload_0 
L12:    getfield [18] 
L15:    invokevirtual [27] 
L18:    invokevirtual [23] 
L21:    ifeq L28 
L24:    iconst_1 
L25:    goto L29 
L28:    iconst_0 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [226] : [227] 
    .attribute [215] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     invokevirtual [20] 
L7:     bipush 50 
L9:     if_icmple L47 
L12:    getstatic [3] 
L15:    sipush 10000 
L18:    ldc [10] 
L20:    aload_0 
L21:    getfield [19] 
L24:    aload_1 
L25:    invokevirtual [28] 
L28:    aload_0 
L29:    getfield [18] 
L32:    invokevirtual [29] 
L35:    aload_0 
L36:    getfield [18] 
L39:    aload_0 
L40:    invokevirtual [30] 
L43:    pop 
L44:    goto L86 
L47:    aload_0 
L48:    invokespecial [38] 
L51:    ifne L86 
L54:    aload_0 
L55:    getfield [18] 
L58:    aload_1 
L59:    invokevirtual [30] 
L62:    pop 
L63:    getstatic [3] 
L66:    ldc [6] 
L68:    ldc [11] 
L70:    aload_0 
L71:    getfield [19] 
L74:    aload_0 
L75:    getfield [18] 
L78:    invokevirtual [20] 
L81:    i2l 
L82:    invokevirtual [24] 
L85:    pop 
L86:    aload_0 
L87:    getfield [19] 
L90:    areturn 
L91:    nop 
L92:    
    .end code 
.end method 

.method public interface [228] : [229] 
    .attribute [215] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [230] : [231] 
    .attribute [215] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [35] 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [232] : [233] 
    .attribute [215] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [34] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method synthetic [234] : [235] 
    .attribute [215] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [33] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [236] : [237] 
    .attribute [215] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [32] 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [238] : [239] 
    .attribute [215] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [240] : [241] 
    .attribute [215] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [242] : [243] 
    .attribute [215] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     dup_x1 
L3:     putfield [39] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [46] 
.const [3] = Field [47] [48] 
.const [4] = String [49] 
.const [5] = String [50] 
.const [6] = Int -2137614336 
.const [7] = String [51] 
.const [8] = String [52] 
.const [9] = String [53] 
.const [10] = String [54] 
.const [11] = String [55] 
.const [12] = Class [56] 
.const [13] = Class [57] 
.const [14] = Class [58] 
.const [15] = Class [59] 
.const [16] = Class [60] 
.const [17] = Field [61] [62] 
.const [18] = Field [63] [64] 
.const [19] = Field [65] [66] 
.const [20] = Method [67] [68] 
.const [21] = Method [69] [70] 
.const [22] = Method [71] [72] 
.const [23] = Method [73] [74] 
.const [24] = Method [75] [76] 
.const [25] = Method [77] [78] 
.const [26] = Method [79] [80] 
.const [27] = Method [81] [82] 
.const [28] = Method [83] [84] 
.const [29] = Method [85] [86] 
.const [30] = Method [87] [88] 
.const [31] = Method [89] [90] 
.const [32] = Method [91] [92] 
.const [33] = Method [93] [94] 
.const [34] = Method [95] [96] 
.const [35] = Method [97] [98] 
.const [36] = Method [99] [100] 
.const [37] = Method [101] [102] 
.const [38] = Method [103] [104] 
.const [39] = Field [105] [106] 
.const [40] = Field [107] [108] 
.const [41] = Class [109] 
.const [42] = Field [110] [111] 
.const [43] = InterfaceMethod [112] [113] 
.const [44] = InterfaceMethod [114] [115] 
.const [45] = InterfaceMethod [116] [117] 
.const [46] = Utf8 java/util/LinkedList 
.const [47] = Class [118] 
.const [48] = NameAndType [119] [120] 
.const [49] = Utf8 'LRUTextureCache#CacheEntry#decrementReferences no references, reference=%1' 
.const [50] = Utf8 'LRUTextureCache#CacheEntry#decrementReferences no references, texture=%1' 
.const [51] = Utf8 'LRUTextureCache#CacheEntry#decrementReferences decrementing reference counter of %1 to %2' 
.const [52] = Utf8 'LRUTextureCache#CacheEntry#decrementReferences decrementing failed. No existing Reference for %1' 
.const [53] = Utf8 'LRUTextureCache#CacheEntry#decrementReferences remaining reference counts: %1' 
.const [54] = Utf8 'LRUTextureCache#CacheEntry#incrementReferences buffer full. %1 is marked as stored permanently in RAM. Object cause: %2' 
.const [55] = Utf8 'LRUTextureCache#CacheEntry#incrementReferences incrementing reference counter of %1 to %2' 
.const [56] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry 
.const [57] = Utf8 java/lang/Object 
.const [58] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [59] = Utf8 de/audi/atip/log/LogChannel 
.const [60] = Utf8 java/util/Iterator 
.const [61] = Class [121] 
.const [62] = NameAndType [122] [123] 
.const [63] = Class [124] 
.const [64] = NameAndType [125] [126] 
.const [65] = Class [127] 
.const [66] = NameAndType [128] [129] 
.const [67] = Class [130] 
.const [68] = NameAndType [131] [132] 
.const [69] = Class [133] 
.const [70] = NameAndType [134] [135] 
.const [71] = Class [136] 
.const [72] = NameAndType [137] [138] 
.const [73] = Class [139] 
.const [74] = NameAndType [140] [141] 
.const [75] = Class [142] 
.const [76] = NameAndType [143] [144] 
.const [77] = Class [145] 
.const [78] = NameAndType [146] [147] 
.const [79] = Class [148] 
.const [80] = NameAndType [149] [150] 
.const [81] = Class [151] 
.const [82] = NameAndType [152] [153] 
.const [83] = Class [154] 
.const [84] = NameAndType [155] [156] 
.const [85] = Class [157] 
.const [86] = NameAndType [158] [159] 
.const [87] = Class [160] 
.const [88] = NameAndType [161] [162] 
.const [89] = Class [163] 
.const [90] = NameAndType [164] [165] 
.const [91] = Class [166] 
.const [92] = NameAndType [167] [168] 
.const [93] = Class [169] 
.const [94] = NameAndType [170] [171] 
.const [95] = Class [172] 
.const [96] = NameAndType [173] [174] 
.const [97] = Class [175] 
.const [98] = NameAndType [176] [177] 
.const [99] = Class [178] 
.const [100] = NameAndType [179] [180] 
.const [101] = Class [181] 
.const [102] = NameAndType [182] [183] 
.const [103] = Class [184] 
.const [104] = NameAndType [185] [186] 
.const [105] = Class [187] 
.const [106] = NameAndType [188] [189] 
.const [107] = Class [190] 
.const [108] = NameAndType [191] [192] 
.const [109] = Utf8 java/util/LinkedList 
.const [110] = Class [193] 
.const [111] = NameAndType [194] [195] 
.const [112] = Class [196] 
.const [113] = NameAndType [197] [198] 
.const [114] = Class [199] 
.const [115] = NameAndType [200] [201] 
.const [116] = Class [202] 
.const [117] = NameAndType [203] [204] 
.const [118] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [119] = Utf8 logChannel3DEngineCache 
.const [120] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [121] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry 
.const [122] = Utf8 deleted 
.const [123] = Utf8 Z 
.const [124] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry 
.const [125] = Utf8 referencedObjects 
.const [126] = Utf8 Ljava/util/LinkedList; 
.const [127] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry 
.const [128] = Utf8 texture 
.const [129] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture; 
.const [130] = Utf8 java/util/LinkedList 
.const [131] = Utf8 size 
.const [132] = Utf8 ()I 
.const [133] = Utf8 de/audi/atip/log/LogChannel 
.const [134] = Utf8 log 
.const [135] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [136] = Utf8 java/util/LinkedList 
.const [137] = Utf8 iterator 
.const [138] = Utf8 ()Ljava/util/Iterator; 
.const [139] = Utf8 java/lang/Object 
.const [140] = Utf8 equals 
.const [141] = Utf8 (Ljava/lang/Object;)Z 
.const [142] = Utf8 de/audi/atip/log/LogChannel 
.const [143] = Utf8 log 
.const [144] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [145] = Utf8 de/audi/atip/log/LogChannel 
.const [146] = Utf8 log 
.const [147] = Utf8 (ILjava/lang/String;J)Z 
.const [148] = Utf8 java/util/LinkedList 
.const [149] = Utf8 isEmpty 
.const [150] = Utf8 ()Z 
.const [151] = Utf8 java/util/LinkedList 
.const [152] = Utf8 getFirst 
.const [153] = Utf8 ()Ljava/lang/Object; 
.const [154] = Utf8 de/audi/atip/log/LogChannel 
.const [155] = Utf8 log 
.const [156] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [157] = Utf8 java/util/LinkedList 
.const [158] = Utf8 clear 
.const [159] = Utf8 ()V 
.const [160] = Utf8 java/util/LinkedList 
.const [161] = Utf8 add 
.const [162] = Utf8 (Ljava/lang/Object;)Z 
.const [163] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry 
.const [164] = Utf8 isDeferredCacheDelete 
.const [165] = Utf8 ()Z 
.const [166] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry 
.const [167] = Utf8 decrementReferences 
.const [168] = Utf8 (Ljava/lang/Object;)Z 
.const [169] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry 
.const [170] = Utf8 <init> 
.const [171] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture;)V 
.const [172] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry 
.const [173] = Utf8 getRefcount 
.const [174] = Utf8 ()I 
.const [175] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry 
.const [176] = Utf8 incrementReferences 
.const [177] = Utf8 (Ljava/lang/Object;)Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture; 
.const [178] = Utf8 java/lang/Object 
.const [179] = Utf8 <init> 
.const [180] = Utf8 ()V 
.const [181] = Utf8 java/util/LinkedList 
.const [182] = Utf8 <init> 
.const [183] = Utf8 ()V 
.const [184] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry 
.const [185] = Utf8 isPermanent 
.const [186] = Utf8 ()Z 
.const [187] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry 
.const [188] = Utf8 deleted 
.const [189] = Utf8 Z 
.const [190] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry 
.const [191] = Utf8 referencedObjects 
.const [192] = Utf8 Ljava/util/LinkedList; 
.const [193] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry 
.const [194] = Utf8 texture 
.const [195] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture; 
.const [196] = Utf8 java/util/Iterator 
.const [197] = Utf8 hasNext 
.const [198] = Utf8 ()Z 
.const [199] = Utf8 java/util/Iterator 
.const [200] = Utf8 next 
.const [201] = Utf8 ()Ljava/lang/Object; 
.const [202] = Utf8 java/util/Iterator 
.const [203] = Utf8 remove 
.const [204] = Utf8 ()V 
.const [205] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry 
.const [206] = Class [205] 
.const [207] = Utf8 java/lang/Object 
.const [208] = Class [207] 
.const [209] = Utf8 texture 
.const [210] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture; 
.const [211] = Utf8 referencedObjects 
.const [212] = Utf8 Ljava/util/LinkedList; 
.const [213] = Utf8 deleted 
.const [214] = Utf8 Z 
.const [215] = Utf8 Code 
.const [216] = Utf8 <init> 
.const [217] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture;)V 
.const [218] = Utf8 getRefcount 
.const [219] = Utf8 ()I 
.const [220] = Utf8 decrementReferences 
.const [221] = Utf8 (Ljava/lang/Object;)Z 
.const [222] = Utf8 isDeferredCacheDelete 
.const [223] = Utf8 ()Z 
.const [224] = Utf8 isPermanent 
.const [225] = Utf8 ()Z 
.const [226] = Utf8 incrementReferences 
.const [227] = Utf8 (Ljava/lang/Object;)Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture; 
.const [228] = Utf8 getTexture 
.const [229] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture; 
.const [230] = Utf8 access$000 
.const [231] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry;Ljava/lang/Object;)Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture; 
.const [232] = Utf8 access$100 
.const [233] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry;)I 
.const [234] = Utf8 <init> 
.const [235] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedTexture;Lde/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$1;)V 
.const [236] = Utf8 access$300 
.const [237] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry;Ljava/lang/Object;)Z 
.const [238] = Utf8 access$400 
.const [239] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry;)Z 
.const [240] = Utf8 access$500 
.const [241] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry;)Ljava/util/LinkedList; 
.const [242] = Utf8 access$602 
.const [243] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/LRUTextureCache$CacheEntry;Z)Z 
.end class 
