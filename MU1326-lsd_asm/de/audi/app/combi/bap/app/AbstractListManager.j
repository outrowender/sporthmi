.version 50 0 
.class public super abstract [237] 
.super [239] 
.implements [241] 
.field protected final [242] [243] 
.field private final [244] [245] 
.field private final [246] [247] 
.field protected final [248] [249] 
.field private final [250] [251] 
.field private [252] [253] 

.method public [255] : [256] 
    .attribute [254] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [19] 
L9:     putfield [37] 
L12:    aload_0 
L13:    aload_1 
L14:    invokevirtual [21] 
L17:    putfield [38] 
L20:    aload_0 
L21:    iload_2 
L22:    putfield [39] 
L25:    aload_0 
L26:    aload_3 
L27:    putfield [40] 
L30:    aload_0 
L31:    new [41] 
L34:    dup 
L35:    iconst_2 
L36:    invokespecial [34] 
L39:    putfield [42] 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [257] : [258] 
    .attribute [254] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     ifeq L62 
L7:     aload_0 
L8:     aload_1 
L9:     invokespecial [35] 
L12:    aload_0 
L13:    new [43] 
L16:    dup 
L17:    aload_1 
L18:    aload_0 
L19:    getfield [24] 
L22:    aload_0 
L23:    getfield [20] 
L26:    invokespecial [36] 
L29:    putfield [44] 
L32:    aload_0 
L33:    getfield [26] 
L36:    invokevirtual [27] 
L39:    aload_0 
L40:    getfield [22] 
L43:    aload_0 
L44:    getfield [24] 
L47:    invokeinterface [45] 0 
L52:    invokevirtual [28] 
L55:    iconst_0 
L56:    invokeinterface [46] 0 
L61:    pop 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 

.method private [259] : [260] 
    .attribute [254] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [25] 
L4:     invokeinterface [47] 0 
L9:     ifne L54 
L12:    aload_0 
L13:    getfield [25] 
L16:    invokeinterface [48] 0 
L21:    astore_2 
L22:    aload_2 
L23:    invokeinterface [49] 0 
L28:    ifeq L51 
L31:    aload_2 
L32:    invokeinterface [50] 0 
L37:    checkcast [4] 
L40:    astore_3 
L41:    aload_3 
L42:    aload_1 
L43:    invokeinterface [51] 0 
L48:    goto L22 
L51:    goto L66 
L54:    aload_0 
L55:    getfield [20] 
L58:    ldc [5] 
L60:    ldc [6] 
L62:    invokevirtual [29] 
L65:    pop 
L66:    return 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [261] : [262] 
    .attribute [254] .code stack 1 locals 2 
L0:     aload_0 
L1:     getfield [25] 
L4:     invokeinterface [48] 0 
L9:     astore_1 
L10:    aload_1 
L11:    invokeinterface [49] 0 
L16:    ifeq L38 
L19:    aload_1 
L20:    invokeinterface [50] 0 
L25:    checkcast [4] 
L28:    astore_2 
L29:    aload_2 
L30:    invokeinterface [52] 0 
L35:    goto L10 
L38:    aload_0 
L39:    getfield [26] 
L42:    ifnull L52 
L45:    aload_0 
L46:    getfield [26] 
L49:    invokevirtual [30] 
L52:    return 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [263] : [264] 
    .attribute [254] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     ldc [5] 
L6:     ldc [7] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [31] 
L13:    pop 
L14:    aload_0 
L15:    getfield [24] 
L18:    ifnull L38 
L21:    aload_0 
L22:    getfield [24] 
L25:    aload_0 
L26:    iload_1 
L27:    invokevirtual [32] 
L30:    invokeinterface [53] 0 
L35:    goto L50 
L38:    aload_0 
L39:    getfield [20] 
L42:    ldc [8] 
L44:    ldc [9] 
L46:    invokevirtual [29] 
L49:    pop 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method protected abstract [265] : [266] 
    .attribute [254] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [54] 
.const [3] = Class [55] 
.const [4] = Class [56] 
.const [5] = Int -2137614336 
.const [6] = String [57] 
.const [7] = String [58] 
.const [8] = Int -1601830656 
.const [9] = String [59] 
.const [10] = Class [60] 
.const [11] = Class [61] 
.const [12] = Class [62] 
.const [13] = Class [63] 
.const [14] = Class [64] 
.const [15] = Class [65] 
.const [16] = Class [66] 
.const [17] = Class [67] 
.const [18] = Class [68] 
.const [19] = Method [69] [70] 
.const [20] = Field [71] [72] 
.const [21] = Method [73] [74] 
.const [22] = Field [75] [76] 
.const [23] = Field [77] [78] 
.const [24] = Field [79] [80] 
.const [25] = Field [81] [82] 
.const [26] = Field [83] [84] 
.const [27] = Method [85] [86] 
.const [28] = Method [87] [88] 
.const [29] = Method [89] [90] 
.const [30] = Method [91] [92] 
.const [31] = Method [93] [94] 
.const [32] = Method [95] [96] 
.const [33] = Method [97] [98] 
.const [34] = Method [99] [100] 
.const [35] = Method [101] [102] 
.const [36] = Method [103] [104] 
.const [37] = Field [105] [106] 
.const [38] = Field [107] [108] 
.const [39] = Field [109] [110] 
.const [40] = Field [111] [112] 
.const [41] = Class [113] 
.const [42] = Field [114] [115] 
.const [43] = Class [116] 
.const [44] = Field [117] [118] 
.const [45] = InterfaceMethod [119] [120] 
.const [46] = InterfaceMethod [121] [122] 
.const [47] = InterfaceMethod [123] [124] 
.const [48] = InterfaceMethod [125] [126] 
.const [49] = InterfaceMethod [127] [128] 
.const [50] = InterfaceMethod [129] [130] 
.const [51] = InterfaceMethod [131] [132] 
.const [52] = InterfaceMethod [133] [134] 
.const [53] = InterfaceMethod [135] [136] 
.const [54] = Utf8 java/util/ArrayList 
.const [55] = Utf8 de/audi/app/bap/dsi/DSIServiceTracker 
.const [56] = Utf8 de/audi/app/combi/bap/fw/arrays/fastlist/IListAdapterFastList 
.const [57] = Utf8 '[AbstractListManager#initListAdapters] No list adapters for FastList registered' 
.const [58] = Utf8 '[AbstractListManager#setOperationState] %1' 
.const [59] = Utf8 '[AbstractListManager#setOperationState] DSI not available' 
.const [60] = Utf8 de/audi/app/combi/bap/app/AbstractListManager 
.const [61] = Utf8 java/lang/Object 
.const [62] = Utf8 de/audi/app/combi/bap/fw/AbstractCombiModule 
.const [63] = Utf8 de/audi/app/combi/bap/dsi/fastlist/IDSIFastListScrollingController 
.const [64] = Utf8 java/lang/Class 
.const [65] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [66] = Utf8 java/util/List 
.const [67] = Utf8 java/util/Iterator 
.const [68] = Utf8 de/audi/atip/log/LogChannel 
.const [69] = Class [137] 
.const [70] = NameAndType [138] [139] 
.const [71] = Class [140] 
.const [72] = NameAndType [141] [142] 
.const [73] = Class [143] 
.const [74] = NameAndType [144] [145] 
.const [75] = Class [146] 
.const [76] = NameAndType [147] [148] 
.const [77] = Class [149] 
.const [78] = NameAndType [150] [151] 
.const [79] = Class [152] 
.const [80] = NameAndType [153] [154] 
.const [81] = Class [155] 
.const [82] = NameAndType [156] [157] 
.const [83] = Class [158] 
.const [84] = NameAndType [159] [160] 
.const [85] = Class [161] 
.const [86] = NameAndType [162] [163] 
.const [87] = Class [164] 
.const [88] = NameAndType [165] [166] 
.const [89] = Class [167] 
.const [90] = NameAndType [168] [169] 
.const [91] = Class [170] 
.const [92] = NameAndType [171] [172] 
.const [93] = Class [173] 
.const [94] = NameAndType [174] [175] 
.const [95] = Class [176] 
.const [96] = NameAndType [177] [178] 
.const [97] = Class [179] 
.const [98] = NameAndType [180] [181] 
.const [99] = Class [182] 
.const [100] = NameAndType [183] [184] 
.const [101] = Class [185] 
.const [102] = NameAndType [186] [187] 
.const [103] = Class [188] 
.const [104] = NameAndType [189] [190] 
.const [105] = Class [191] 
.const [106] = NameAndType [192] [193] 
.const [107] = Class [194] 
.const [108] = NameAndType [195] [196] 
.const [109] = Class [197] 
.const [110] = NameAndType [198] [199] 
.const [111] = Class [200] 
.const [112] = NameAndType [201] [202] 
.const [113] = Utf8 java/util/ArrayList 
.const [114] = Class [203] 
.const [115] = NameAndType [204] [205] 
.const [116] = Utf8 de/audi/app/bap/dsi/DSIServiceTracker 
.const [117] = Class [206] 
.const [118] = NameAndType [207] [208] 
.const [119] = Class [209] 
.const [120] = NameAndType [210] [211] 
.const [121] = Class [212] 
.const [122] = NameAndType [213] [214] 
.const [123] = Class [215] 
.const [124] = NameAndType [216] [217] 
.const [125] = Class [218] 
.const [126] = NameAndType [219] [220] 
.const [127] = Class [221] 
.const [128] = NameAndType [222] [223] 
.const [129] = Class [224] 
.const [130] = NameAndType [225] [226] 
.const [131] = Class [227] 
.const [132] = NameAndType [228] [229] 
.const [133] = Class [230] 
.const [134] = NameAndType [231] [232] 
.const [135] = Class [233] 
.const [136] = NameAndType [234] [235] 
.const [137] = Utf8 de/audi/app/combi/bap/fw/AbstractCombiModule 
.const [138] = Utf8 getLogChannel 
.const [139] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [140] = Utf8 de/audi/app/combi/bap/app/AbstractListManager 
.const [141] = Utf8 logChannel 
.const [142] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [143] = Utf8 de/audi/app/combi/bap/fw/AbstractCombiModule 
.const [144] = Utf8 getFrameworkAccess 
.const [145] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [146] = Utf8 de/audi/app/combi/bap/app/AbstractListManager 
.const [147] = Utf8 frameworkAccess 
.const [148] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [149] = Utf8 de/audi/app/combi/bap/app/AbstractListManager 
.const [150] = Utf8 mostListSupported 
.const [151] = Utf8 Z 
.const [152] = Utf8 de/audi/app/combi/bap/app/AbstractListManager 
.const [153] = Utf8 dsiFastListScrollingController 
.const [154] = Utf8 Lde/audi/app/combi/bap/dsi/fastlist/IDSIFastListScrollingController; 
.const [155] = Utf8 de/audi/app/combi/bap/app/AbstractListManager 
.const [156] = Utf8 fastListAdapters 
.const [157] = Utf8 Ljava/util/List; 
.const [158] = Utf8 de/audi/app/combi/bap/app/AbstractListManager 
.const [159] = Utf8 dsiServiceTracker 
.const [160] = Utf8 Lde/audi/app/bap/dsi/DSIServiceTracker; 
.const [161] = Utf8 de/audi/app/bap/dsi/DSIServiceTracker 
.const [162] = Utf8 start 
.const [163] = Utf8 ()V 
.const [164] = Utf8 java/lang/Class 
.const [165] = Utf8 getName 
.const [166] = Utf8 ()Ljava/lang/String; 
.const [167] = Utf8 de/audi/atip/log/LogChannel 
.const [168] = Utf8 log 
.const [169] = Utf8 (ILjava/lang/String;)Z 
.const [170] = Utf8 de/audi/app/bap/dsi/DSIServiceTracker 
.const [171] = Utf8 stop 
.const [172] = Utf8 ()V 
.const [173] = Utf8 de/audi/atip/log/LogChannel 
.const [174] = Utf8 log 
.const [175] = Utf8 (ILjava/lang/String;J)Z 
.const [176] = Utf8 de/audi/app/combi/bap/app/AbstractListManager 
.const [177] = Utf8 convertMostOperationState 
.const [178] = Utf8 (I)I 
.const [179] = Utf8 java/lang/Object 
.const [180] = Utf8 <init> 
.const [181] = Utf8 ()V 
.const [182] = Utf8 java/util/ArrayList 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (I)V 
.const [185] = Utf8 de/audi/app/combi/bap/app/AbstractListManager 
.const [186] = Utf8 initListAdapters 
.const [187] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [188] = Utf8 de/audi/app/bap/dsi/DSIServiceTracker 
.const [189] = Utf8 <init> 
.const [190] = Utf8 (Lorg/osgi/framework/BundleContext;Lde/audi/app/bap/dsi/IDSIController;Lde/audi/atip/log/LogChannel;)V 
.const [191] = Utf8 de/audi/app/combi/bap/app/AbstractListManager 
.const [192] = Utf8 logChannel 
.const [193] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [194] = Utf8 de/audi/app/combi/bap/app/AbstractListManager 
.const [195] = Utf8 frameworkAccess 
.const [196] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [197] = Utf8 de/audi/app/combi/bap/app/AbstractListManager 
.const [198] = Utf8 mostListSupported 
.const [199] = Utf8 Z 
.const [200] = Utf8 de/audi/app/combi/bap/app/AbstractListManager 
.const [201] = Utf8 dsiFastListScrollingController 
.const [202] = Utf8 Lde/audi/app/combi/bap/dsi/fastlist/IDSIFastListScrollingController; 
.const [203] = Utf8 de/audi/app/combi/bap/app/AbstractListManager 
.const [204] = Utf8 fastListAdapters 
.const [205] = Utf8 Ljava/util/List; 
.const [206] = Utf8 de/audi/app/combi/bap/app/AbstractListManager 
.const [207] = Utf8 dsiServiceTracker 
.const [208] = Utf8 Lde/audi/app/bap/dsi/DSIServiceTracker; 
.const [209] = Utf8 de/audi/app/combi/bap/dsi/fastlist/IDSIFastListScrollingController 
.const [210] = Utf8 getDSIClass 
.const [211] = Utf8 ()Ljava/lang/Class; 
.const [212] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [213] = Utf8 startDSIService 
.const [214] = Utf8 (Ljava/lang/String;I)Z 
.const [215] = Utf8 java/util/List 
.const [216] = Utf8 isEmpty 
.const [217] = Utf8 ()Z 
.const [218] = Utf8 java/util/List 
.const [219] = Utf8 iterator 
.const [220] = Utf8 ()Ljava/util/Iterator; 
.const [221] = Utf8 java/util/Iterator 
.const [222] = Utf8 hasNext 
.const [223] = Utf8 ()Z 
.const [224] = Utf8 java/util/Iterator 
.const [225] = Utf8 next 
.const [226] = Utf8 ()Ljava/lang/Object; 
.const [227] = Utf8 de/audi/app/combi/bap/fw/arrays/fastlist/IListAdapterFastList 
.const [228] = Utf8 init 
.const [229] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [230] = Utf8 de/audi/app/combi/bap/fw/arrays/fastlist/IListAdapterFastList 
.const [231] = Utf8 deinit 
.const [232] = Utf8 ()V 
.const [233] = Utf8 de/audi/app/combi/bap/dsi/fastlist/IDSIFastListScrollingController 
.const [234] = Utf8 pushMOSTOperationState 
.const [235] = Utf8 (I)V 
.const [236] = Utf8 de/audi/app/combi/bap/app/AbstractListManager 
.const [237] = Class [236] 
.const [238] = Utf8 java/lang/Object 
.const [239] = Class [238] 
.const [240] = Utf8 de/audi/app/bap/fw/arrays/IListManager 
.const [241] = Class [240] 
.const [242] = Utf8 logChannel 
.const [243] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [244] = Utf8 frameworkAccess 
.const [245] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [246] = Utf8 mostListSupported 
.const [247] = Utf8 Z 
.const [248] = Utf8 fastListAdapters 
.const [249] = Utf8 Ljava/util/List; 
.const [250] = Utf8 dsiFastListScrollingController 
.const [251] = Utf8 Lde/audi/app/combi/bap/dsi/fastlist/IDSIFastListScrollingController; 
.const [252] = Utf8 dsiServiceTracker 
.const [253] = Utf8 Lde/audi/app/bap/dsi/DSIServiceTracker; 
.const [254] = Utf8 Code 
.const [255] = Utf8 <init> 
.const [256] = Utf8 (Lde/audi/app/combi/bap/fw/AbstractCombiModule;ZLde/audi/app/combi/bap/dsi/fastlist/IDSIFastListScrollingController;)V 
.const [257] = Utf8 init 
.const [258] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [259] = Utf8 initListAdapters 
.const [260] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [261] = Utf8 deinit 
.const [262] = Utf8 ()V 
.const [263] = Utf8 setOperationState 
.const [264] = Utf8 (I)V 
.const [265] = Utf8 convertMostOperationState 
.const [266] = Utf8 (I)I 
.end class 
