.version 50 0 
.class public super [255] 
.super [257] 
.field public static final [258] [259] 
.field protected final [260] [261] 
.field protected final [262] [263] 
.field protected final [264] [265] 
.field private [266] [267] 

.method public [269] : [270] 
    .attribute [268] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [38] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [43] 
L9:     aload_0 
L10:    aload_1 
L11:    ldc [2] 
L13:    invokeinterface [44] 0 
L18:    putfield [45] 
L21:    aload_0 
L22:    iload_2 
L23:    putfield [46] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [271] : [272] 
    .attribute [268] .code stack 8 locals 3 
L0:     aload_0 
L1:     getfield [28] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     iload_1 
L9:     i2l 
L10:    iload_1 
L11:    ldc [5] 
L13:    idiv 
L14:    i2l 
L15:    invokevirtual [30] 
L18:    pop 
L19:    aconst_null 
L20:    astore 5 
L22:    iload_2 
L23:    ifeq L44 
L26:    aload_0 
L27:    invokespecial [39] 
L30:    iload_1 
L31:    iload 4 
L33:    aload_0 
L34:    getfield [29] 
L37:    invokeinterface [47] 0 
L42:    astore 5 
L44:    aload 5 
L46:    ifnonnull L234 
L49:    aload_0 
L50:    getfield [27] 
L53:    invokeinterface [48] 0 
L58:    iload_1 
L59:    invokeinterface [49] 0 
L64:    astore 6 
L66:    aload 6 
L68:    ifnull L209 
L71:    aload_0 
L72:    getfield [28] 
L75:    ldc [3] 
L77:    ldc [6] 
L79:    aload 6 
L81:    invokevirtual [31] 
L84:    pop 
L85:    getstatic [7] 
L88:    ifeq L150 
L91:    aload 6 
L93:    iload_1 
L94:    aload_0 
L95:    getfield [29] 
L98:    invokeinterface [50] 0 
L103:   astore 7 
L105:   aload 7 
L107:   ifnull L136 
L110:   aload_0 
L111:   invokespecial [39] 
L114:   iload_1 
L115:   aload 7 
L117:   iconst_0 
L118:   iload_2 
L119:   iload_3 
L120:   iload 4 
L122:   aload_0 
L123:   getfield [29] 
L126:   invokeinterface [51] 0 
L131:   astore 5 
L133:   goto L147 
L136:   aload_0 
L137:   invokespecial [39] 
L140:   invokeinterface [52] 0 
L145:   astore 5 
L147:   goto L234 
L150:   aload_0 
L151:   aload 6 
L153:   iload_1 
L154:   invokeinterface [53] 0 
L159:   invokevirtual [32] 
L162:   astore 7 
L164:   aload 7 
L166:   ifnull L195 
L169:   aload_0 
L170:   invokespecial [39] 
L173:   iload_1 
L174:   aload 7 
L176:   iconst_0 
L177:   iload_2 
L178:   iload_3 
L179:   iload 4 
L181:   aload_0 
L182:   getfield [29] 
L185:   invokeinterface [54] 0 
L190:   astore 5 
L192:   goto L206 
L195:   aload_0 
L196:   invokespecial [39] 
L199:   invokeinterface [52] 0 
L204:   astore 5 
L206:   goto L234 
L209:   aload_0 
L210:   getfield [28] 
L213:   ldc [3] 
L215:   ldc [8] 
L217:   iload_1 
L218:   i2l 
L219:   invokevirtual [33] 
L222:   pop 
L223:   aload_0 
L224:   invokespecial [39] 
L227:   invokeinterface [52] 0 
L232:   astore 5 
L234:   aload_0 
L235:   getfield [28] 
L238:   ldc [3] 
L240:   ldc [9] 
L242:   aload 5 
L244:   invokevirtual [31] 
L247:   pop 
L248:   aload 5 
L250:   areturn 
L251:   nop 
L252:   
    .end code 
.end method 

.method protected [273] : [274] 
    .attribute [268] .code stack 5 locals 2 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     aconst_null 
L5:     areturn 
        .catch [12] from L6 to L31 using L32 
L6:     new [55] 
L9:     dup 
L10:    aload_1 
L11:    invokevirtual [34] 
L14:    invokespecial [41] 
L17:    astore_2 
L18:    new [56] 
L21:    dup 
L22:    aload_2 
L23:    invokespecial [42] 
L26:    astore_3 
L27:    aload_3 
L28:    invokevirtual [35] 
L31:    areturn 
L32:    astore_2 
L33:    aload_0 
L34:    getfield [28] 
L37:    ldc [3] 
L39:    ldc [13] 
L41:    aload_1 
L42:    aload_2 
L43:    invokevirtual [36] 
L46:    pop 
L47:    aconst_null 
L48:    areturn 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method private [275] : [276] 
    .attribute [268] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ifnonnull L34 
L7:     aload_0 
L8:     aload_0 
L9:     getfield [27] 
L12:    invokeinterface [58] 0 
L17:    aload_0 
L18:    getfield [29] 
L21:    invokeinterface [59] 0 
L26:    invokeinterface [60] 0 
L31:    putfield [57] 
L34:    aload_0 
L35:    getfield [37] 
L38:    areturn 
L39:    nop 
L40:    
    .end code 
.end method 

.method static [277] : [278] 
    .attribute [268] .code stack 1 locals 1 
L0:     ldc [14] 
L2:     invokestatic [15] 
L5:     astore_0 
L6:     aload_0 
L7:     ifnull L17 
L10:    iconst_1 
L11:    putstatic [40] 
L14:    goto L21 
L17:    iconst_0 
L18:    putstatic [40] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [61] 
.const [3] = Int -2137614336 
.const [4] = String [62] 
.const [5] = Int -1601830656 
.const [6] = String [63] 
.const [7] = Field [64] [65] 
.const [8] = String [66] 
.const [9] = String [67] 
.const [10] = Class [68] 
.const [11] = Class [69] 
.const [12] = Class [70] 
.const [13] = String [71] 
.const [14] = String [72] 
.const [15] = Method [73] [74] 
.const [16] = Class [75] 
.const [17] = Class [76] 
.const [18] = Class [77] 
.const [19] = Class [78] 
.const [20] = Class [79] 
.const [21] = Class [80] 
.const [22] = Class [81] 
.const [23] = Class [82] 
.const [24] = Class [83] 
.const [25] = Class [84] 
.const [26] = Class [85] 
.const [27] = Field [86] [87] 
.const [28] = Field [88] [89] 
.const [29] = Field [90] [91] 
.const [30] = Method [92] [93] 
.const [31] = Method [94] [95] 
.const [32] = Method [96] [97] 
.const [33] = Method [98] [99] 
.const [34] = Method [100] [101] 
.const [35] = Method [102] [103] 
.const [36] = Method [104] [105] 
.const [37] = Field [106] [107] 
.const [38] = Method [108] [109] 
.const [39] = Method [110] [111] 
.const [40] = Field [112] [113] 
.const [41] = Method [114] [115] 
.const [42] = Method [116] [117] 
.const [43] = Field [118] [119] 
.const [44] = InterfaceMethod [120] [121] 
.const [45] = Field [122] [123] 
.const [46] = Field [124] [125] 
.const [47] = InterfaceMethod [126] [127] 
.const [48] = InterfaceMethod [128] [129] 
.const [49] = InterfaceMethod [130] [131] 
.const [50] = InterfaceMethod [132] [133] 
.const [51] = InterfaceMethod [134] [135] 
.const [52] = InterfaceMethod [136] [137] 
.const [53] = InterfaceMethod [138] [139] 
.const [54] = InterfaceMethod [140] [141] 
.const [55] = Class [142] 
.const [56] = Class [143] 
.const [57] = Field [144] [145] 
.const [58] = InterfaceMethod [146] [147] 
.const [59] = InterfaceMethod [148] [149] 
.const [60] = InterfaceMethod [150] [151] 
.const [61] = Utf8 'Fw.HMIService.Main' 
.const [62] = Utf8 'ResourceManager: HMIServiceImpl.getImage(id = %1, %2) called; moduleId == %3 ' 
.const [63] = Utf8 'ResourceManager: HMIServiceImpl.getImage(): targetHmiBundle == %1 ' 
.const [64] = Class [152] 
.const [65] = NameAndType [153] [154] 
.const [66] = Utf8 'ResourceManager: HMIServiceImpl.getImage(): No HMIBundle for ID %1 ' 
.const [67] = Utf8 'ResourceManager: HMIServiceImpl.getImage() finished: returning: %1 ' 
.const [68] = Utf8 java/net/URI 
.const [69] = Utf8 java/io/File 
.const [70] = Utf8 java/net/URISyntaxException 
.const [71] = Utf8 'ResourceManager#getFilePathFromUrl: can not build URI from url: %1' 
.const [72] = Utf8 ImageRoot 
.const [73] = Class [155] 
.const [74] = NameAndType [156] [157] 
.const [75] = Utf8 de/audi/tghu/hmi/ResourceManager 
.const [76] = Utf8 java/lang/Object 
.const [77] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [78] = Utf8 de/audi/atip/log/LogChannel 
.const [79] = Utf8 de/audi/atip/hmi/view/IImageLoader 
.const [80] = Utf8 de/audi/atip/hmi/HMIService 
.const [81] = Utf8 de/audi/atip/hmi/HMIBundle 
.const [82] = Utf8 java/net/URL 
.const [83] = Utf8 de/audi/atip/hmi/IHMITerminalRegistry 
.const [84] = Utf8 de/audi/atip/hmi/HMITerminal 
.const [85] = Utf8 java/lang/System 
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
.const [98] = Class [176] 
.const [99] = NameAndType [177] [178] 
.const [100] = Class [179] 
.const [101] = NameAndType [180] [181] 
.const [102] = Class [182] 
.const [103] = NameAndType [183] [184] 
.const [104] = Class [185] 
.const [105] = NameAndType [186] [187] 
.const [106] = Class [188] 
.const [107] = NameAndType [189] [190] 
.const [108] = Class [191] 
.const [109] = NameAndType [192] [193] 
.const [110] = Class [194] 
.const [111] = NameAndType [195] [196] 
.const [112] = Class [197] 
.const [113] = NameAndType [198] [199] 
.const [114] = Class [200] 
.const [115] = NameAndType [201] [202] 
.const [116] = Class [203] 
.const [117] = NameAndType [204] [205] 
.const [118] = Class [206] 
.const [119] = NameAndType [207] [208] 
.const [120] = Class [209] 
.const [121] = NameAndType [210] [211] 
.const [122] = Class [212] 
.const [123] = NameAndType [213] [214] 
.const [124] = Class [215] 
.const [125] = NameAndType [216] [217] 
.const [126] = Class [218] 
.const [127] = NameAndType [219] [220] 
.const [128] = Class [221] 
.const [129] = NameAndType [222] [223] 
.const [130] = Class [224] 
.const [131] = NameAndType [225] [226] 
.const [132] = Class [227] 
.const [133] = NameAndType [228] [229] 
.const [134] = Class [230] 
.const [135] = NameAndType [231] [232] 
.const [136] = Class [233] 
.const [137] = NameAndType [234] [235] 
.const [138] = Class [236] 
.const [139] = NameAndType [237] [238] 
.const [140] = Class [239] 
.const [141] = NameAndType [240] [241] 
.const [142] = Utf8 java/net/URI 
.const [143] = Utf8 java/io/File 
.const [144] = Class [242] 
.const [145] = NameAndType [243] [244] 
.const [146] = Class [245] 
.const [147] = NameAndType [246] [247] 
.const [148] = Class [248] 
.const [149] = NameAndType [249] [250] 
.const [150] = Class [251] 
.const [151] = NameAndType [252] [253] 
.const [152] = Utf8 de/audi/tghu/hmi/ResourceManager 
.const [153] = Utf8 LOAD_FROM_FILE 
.const [154] = Utf8 Z 
.const [155] = Utf8 java/lang/System 
.const [156] = Utf8 getProperty 
.const [157] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [158] = Utf8 de/audi/tghu/hmi/ResourceManager 
.const [159] = Utf8 framework 
.const [160] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [161] = Utf8 de/audi/tghu/hmi/ResourceManager 
.const [162] = Utf8 logHMIService 
.const [163] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [164] = Utf8 de/audi/tghu/hmi/ResourceManager 
.const [165] = Utf8 terminalID 
.const [166] = Utf8 I 
.const [167] = Utf8 de/audi/atip/log/LogChannel 
.const [168] = Utf8 log 
.const [169] = Utf8 (ILjava/lang/String;JJ)Z 
.const [170] = Utf8 de/audi/atip/log/LogChannel 
.const [171] = Utf8 log 
.const [172] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [173] = Utf8 de/audi/tghu/hmi/ResourceManager 
.const [174] = Utf8 getFilePathFromUrl 
.const [175] = Utf8 (Ljava/net/URL;)Ljava/lang/String; 
.const [176] = Utf8 de/audi/atip/log/LogChannel 
.const [177] = Utf8 log 
.const [178] = Utf8 (ILjava/lang/String;J)Z 
.const [179] = Utf8 java/net/URL 
.const [180] = Utf8 toExternalForm 
.const [181] = Utf8 ()Ljava/lang/String; 
.const [182] = Utf8 java/io/File 
.const [183] = Utf8 getAbsolutePath 
.const [184] = Utf8 ()Ljava/lang/String; 
.const [185] = Utf8 de/audi/atip/log/LogChannel 
.const [186] = Utf8 log 
.const [187] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)Z 
.const [188] = Utf8 de/audi/tghu/hmi/ResourceManager 
.const [189] = Utf8 imageLoader 
.const [190] = Utf8 Lde/audi/atip/hmi/view/IImageLoader; 
.const [191] = Utf8 java/lang/Object 
.const [192] = Utf8 <init> 
.const [193] = Utf8 ()V 
.const [194] = Utf8 de/audi/tghu/hmi/ResourceManager 
.const [195] = Utf8 getImageLoader 
.const [196] = Utf8 ()Lde/audi/atip/hmi/view/IImageLoader; 
.const [197] = Utf8 de/audi/tghu/hmi/ResourceManager 
.const [198] = Utf8 LOAD_FROM_FILE 
.const [199] = Utf8 Z 
.const [200] = Utf8 java/net/URI 
.const [201] = Utf8 <init> 
.const [202] = Utf8 (Ljava/lang/String;)V 
.const [203] = Utf8 java/io/File 
.const [204] = Utf8 <init> 
.const [205] = Utf8 (Ljava/net/URI;)V 
.const [206] = Utf8 de/audi/tghu/hmi/ResourceManager 
.const [207] = Utf8 framework 
.const [208] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [209] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [210] = Utf8 getLogChannel 
.const [211] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [212] = Utf8 de/audi/tghu/hmi/ResourceManager 
.const [213] = Utf8 logHMIService 
.const [214] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [215] = Utf8 de/audi/tghu/hmi/ResourceManager 
.const [216] = Utf8 terminalID 
.const [217] = Utf8 I 
.const [218] = Utf8 de/audi/atip/hmi/view/IImageLoader 
.const [219] = Utf8 getImageFromCache 
.const [220] = Utf8 (III)Ljava/lang/Object; 
.const [221] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [222] = Utf8 getHMIService 
.const [223] = Utf8 ()Lde/audi/atip/hmi/HMIService; 
.const [224] = Utf8 de/audi/atip/hmi/HMIService 
.const [225] = Utf8 getHMIBundle 
.const [226] = Utf8 (I)Lde/audi/atip/hmi/HMIBundle; 
.const [227] = Utf8 de/audi/atip/hmi/HMIBundle 
.const [228] = Utf8 getImagePath 
.const [229] = Utf8 (II)Ljava/lang/String; 
.const [230] = Utf8 de/audi/atip/hmi/view/IImageLoader 
.const [231] = Utf8 loadImage 
.const [232] = Utf8 (ILjava/lang/String;ZZIII)Ljava/lang/Object; 
.const [233] = Utf8 de/audi/atip/hmi/view/IImageLoader 
.const [234] = Utf8 getErrorImage 
.const [235] = Utf8 ()Ljava/lang/Object; 
.const [236] = Utf8 de/audi/atip/hmi/HMIBundle 
.const [237] = Utf8 getImageUrlFromClassloader 
.const [238] = Utf8 (I)Ljava/net/URL; 
.const [239] = Utf8 de/audi/atip/hmi/view/IImageLoader 
.const [240] = Utf8 loadImageAbsolutePath 
.const [241] = Utf8 (ILjava/lang/String;ZZIII)Ljava/lang/Object; 
.const [242] = Utf8 de/audi/tghu/hmi/ResourceManager 
.const [243] = Utf8 imageLoader 
.const [244] = Utf8 Lde/audi/atip/hmi/view/IImageLoader; 
.const [245] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [246] = Utf8 getHMITerminalRegistry 
.const [247] = Utf8 ()Lde/audi/atip/hmi/IHMITerminalRegistry; 
.const [248] = Utf8 de/audi/atip/hmi/IHMITerminalRegistry 
.const [249] = Utf8 getTerminal 
.const [250] = Utf8 (I)Lde/audi/atip/hmi/HMITerminal; 
.const [251] = Utf8 de/audi/atip/hmi/HMITerminal 
.const [252] = Utf8 getImageLoader 
.const [253] = Utf8 ()Lde/audi/atip/hmi/view/IImageLoader; 
.const [254] = Utf8 de/audi/tghu/hmi/ResourceManager 
.const [255] = Class [254] 
.const [256] = Utf8 java/lang/Object 
.const [257] = Class [256] 
.const [258] = Utf8 LOAD_FROM_FILE 
.const [259] = Utf8 Z 
.const [260] = Utf8 logHMIService 
.const [261] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [262] = Utf8 framework 
.const [263] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [264] = Utf8 terminalID 
.const [265] = Utf8 I 
.const [266] = Utf8 imageLoader 
.const [267] = Utf8 Lde/audi/atip/hmi/view/IImageLoader; 
.const [268] = Utf8 Code 
.const [269] = Utf8 <init> 
.const [270] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;I)V 
.const [271] = Utf8 getImageImpl 
.const [272] = Utf8 (IZII)Ljava/lang/Object; 
.const [273] = Utf8 getFilePathFromUrl 
.const [274] = Utf8 (Ljava/net/URL;)Ljava/lang/String; 
.const [275] = Utf8 getImageLoader 
.const [276] = Utf8 ()Lde/audi/atip/hmi/view/IImageLoader; 
.const [277] = Utf8 <clinit> 
.const [278] = Utf8 ()V 
.end class 
