.version 50 0 
.class final super [216] 
.super [218] 
.field private [219] [220] 
.field private [221] [222] 
.field private [223] [224] 

.method [226] : [227] 
    .attribute [225] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [40] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [41] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [42] 
L19:    aload_0 
L20:    aload_1 
L21:    putfield [40] 
L24:    aload_0 
L25:    aload_2 
L26:    putfield [41] 
L29:    aload_0 
L30:    invokespecial [34] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method final [228] : [229] 
    .attribute [225] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     aconst_null 
L5:     goto L22 
L8:     aload_1 
L9:     invokeinterface [43] 0 
L14:    ldc [2] 
L16:    invokevirtual [28] 
L19:    checkcast [3] 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method private final [230] : [231] 
    .attribute [225] .code stack 7 locals 4 
L0:     aload_0 
L1:     getfield [25] 
L4:     invokeinterface [44] 0 
L9:     astore_1 
L10:    aload_0 
L11:    new [45] 
L14:    dup 
L15:    aload_1 
L16:    arraylength 
L17:    i2d 
L18:    ldc2_w [54] 
L21:    ddiv 
L22:    invokestatic [5] 
L25:    d2i 
L26:    iconst_1 
L27:    iadd 
L28:    invokespecial [35] 
L31:    putfield [42] 
L34:    iconst_0 
L35:    istore_2 
L36:    iload_2 
L37:    aload_1 
L38:    arraylength 
L39:    if_icmpge L77 
L42:    aload_1 
L43:    iload_2 
L44:    aaload 
L45:    astore_3 
L46:    aload_0 
L47:    aload_3 
L48:    invokespecial [36] 
L51:    astore 4 
L53:    aload 4 
L55:    ifnull L71 
L58:    aload_0 
L59:    getfield [27] 
L62:    aload 4 
L64:    aload_3 
L65:    invokeinterface [46] 0 
L70:    pop 
L71:    iinc 2 1 
L74:    goto L36 
L77:    return 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method [232] : [233] 
    .attribute [225] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     aload_1 
L5:     invokeinterface [47] 0 
L10:    checkcast [6] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method [234] : [235] 
    .attribute [225] .code stack 5 locals 1 
L0:     aload_1 
L1:     ifnonnull L5 
L4:     return 
L5:     aload_1 
L6:     invokeinterface [48] 0 
L11:    iconst_4 
L12:    if_icmpge L51 
L15:    new [49] 
L18:    dup 
L19:    new [50] 
L22:    dup 
L23:    invokespecial [37] 
L26:    ldc [9] 
L28:    invokevirtual [29] 
L31:    aload_0 
L32:    aload_1 
L33:    invokespecial [36] 
L36:    invokevirtual [29] 
L39:    ldc [10] 
L41:    invokevirtual [29] 
L44:    invokevirtual [30] 
L47:    invokespecial [38] 
L50:    athrow 
L51:    aload_1 
L52:    invokeinterface [48] 0 
L57:    bipush 32 
L59:    if_icmpeq L126 
L62:    aload_0 
L63:    getfield [26] 
L66:    ldc [11] 
L68:    ldc [12] 
L70:    aload_0 
L71:    aload_1 
L72:    invokespecial [36] 
L75:    invokevirtual [31] 
L78:    pop 
        .catch [13] from L79 to L85 using L88 
L79:    aload_1 
L80:    invokeinterface [51] 0 
L85:    goto L126 
L88:    astore_2 
L89:    new [49] 
L92:    dup 
L93:    new [50] 
L96:    dup 
L97:    invokespecial [37] 
L100:   ldc [14] 
L102:   invokevirtual [29] 
L105:   aload_0 
L106:   aload_1 
L107:   invokespecial [36] 
L110:   invokevirtual [29] 
L113:   ldc [15] 
L115:   invokevirtual [29] 
L118:   invokevirtual [30] 
L121:   aload_2 
L122:   invokespecial [39] 
L125:   athrow 
L126:   return 
L127:   nop 
L128:   
    .end code 
.end method 

.method [236] : [237] 
    .attribute [225] .code stack 5 locals 1 
L0:     aload_1 
L1:     ifnonnull L5 
L4:     return 
L5:     aload_1 
L6:     invokeinterface [48] 0 
L11:    iconst_4 
L12:    if_icmpge L52 
L15:    new [49] 
L18:    dup 
L19:    new [50] 
L22:    dup 
L23:    invokespecial [37] 
L26:    ldc [9] 
L28:    invokevirtual [29] 
L31:    aload_1 
L32:    invokeinterface [52] 0 
L37:    invokevirtual [32] 
L40:    ldc [10] 
L42:    invokevirtual [29] 
L45:    invokevirtual [30] 
L48:    invokespecial [38] 
L51:    athrow 
L52:    aload_1 
L53:    invokeinterface [48] 0 
L58:    iconst_4 
L59:    if_icmpeq L126 
L62:    aload_0 
L63:    getfield [26] 
L66:    ldc [11] 
L68:    ldc [16] 
L70:    aload_0 
L71:    aload_1 
L72:    invokespecial [36] 
L75:    invokevirtual [31] 
L78:    pop 
        .catch [13] from L79 to L85 using L88 
L79:    aload_1 
L80:    invokeinterface [53] 0 
L85:    goto L126 
L88:    astore_2 
L89:    new [49] 
L92:    dup 
L93:    new [50] 
L96:    dup 
L97:    invokespecial [37] 
L100:   ldc [17] 
L102:   invokevirtual [29] 
L105:   aload_0 
L106:   aload_1 
L107:   invokespecial [36] 
L110:   invokevirtual [29] 
L113:   ldc [15] 
L115:   invokevirtual [29] 
L118:   invokevirtual [30] 
L121:   aload_2 
L122:   invokespecial [39] 
L125:   athrow 
L126:   return 
L127:   nop 
L128:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [56] 
.const [3] = Class [57] 
.const [4] = Class [58] 
.const [5] = Method [59] [60] 
.const [6] = Class [61] 
.const [7] = Class [62] 
.const [8] = Class [63] 
.const [9] = String [64] 
.const [10] = String [65] 
.const [11] = Int -2137614336 
.const [12] = String [66] 
.const [13] = Class [67] 
.const [14] = String [68] 
.const [15] = String [69] 
.const [16] = String [70] 
.const [17] = String [71] 
.const [18] = Class [72] 
.const [19] = Class [73] 
.const [20] = Class [74] 
.const [21] = Class [75] 
.const [22] = Class [76] 
.const [23] = Class [77] 
.const [24] = Class [78] 
.const [25] = Field [79] [80] 
.const [26] = Field [81] [82] 
.const [27] = Field [83] [84] 
.const [28] = Method [85] [86] 
.const [29] = Method [87] [88] 
.const [30] = Method [89] [90] 
.const [31] = Method [91] [92] 
.const [32] = Method [93] [94] 
.const [33] = Method [95] [96] 
.const [34] = Method [97] [98] 
.const [35] = Method [99] [100] 
.const [36] = Method [101] [102] 
.const [37] = Method [103] [104] 
.const [38] = Method [105] [106] 
.const [39] = Method [107] [108] 
.const [40] = Field [109] [110] 
.const [41] = Field [111] [112] 
.const [42] = Field [113] [114] 
.const [43] = InterfaceMethod [115] [116] 
.const [44] = InterfaceMethod [117] [118] 
.const [45] = Class [119] 
.const [46] = InterfaceMethod [120] [121] 
.const [47] = InterfaceMethod [122] [123] 
.const [48] = InterfaceMethod [124] [125] 
.const [49] = Class [126] 
.const [50] = Class [127] 
.const [51] = InterfaceMethod [128] [129] 
.const [52] = InterfaceMethod [130] [131] 
.const [53] = InterfaceMethod [132] [133] 
.const [54] = Double +0x18000000000000p-53 
.const [56] = Utf8 Bundle-Name 
.const [57] = Utf8 java/lang/String 
.const [58] = Utf8 java/util/HashMap 
.const [59] = Class [134] 
.const [60] = NameAndType [135] [136] 
.const [61] = Utf8 org/osgi/framework/Bundle 
.const [62] = Utf8 org/osgi/framework/BundleException 
.const [63] = Utf8 java/lang/StringBuffer 
.const [64] = Utf8 'Bundle ' 
.const [65] = Utf8 ' is not (yet) resolved!' 
.const [66] = Utf8 'BundleHandler: startBundle: %1 ' 
.const [67] = Utf8 java/lang/NoClassDefFoundError 
.const [68] = Utf8 'Start of bundle ' 
.const [69] = Utf8 ' failed due to undefined class!' 
.const [70] = Utf8 'BundleHandler: stopBundle: %1' 
.const [71] = Utf8 'Stop of bundle ' 
.const [72] = Utf8 de/audi/atip/startup/BundleHandler 
.const [73] = Utf8 java/lang/Object 
.const [74] = Utf8 java/util/Dictionary 
.const [75] = Utf8 org/osgi/framework/BundleContext 
.const [76] = Utf8 java/lang/Math 
.const [77] = Utf8 java/util/Map 
.const [78] = Utf8 de/audi/atip/log/LogChannel 
.const [79] = Class [137] 
.const [80] = NameAndType [138] [139] 
.const [81] = Class [140] 
.const [82] = NameAndType [141] [142] 
.const [83] = Class [143] 
.const [84] = NameAndType [144] [145] 
.const [85] = Class [146] 
.const [86] = NameAndType [147] [148] 
.const [87] = Class [149] 
.const [88] = NameAndType [150] [151] 
.const [89] = Class [152] 
.const [90] = NameAndType [153] [154] 
.const [91] = Class [155] 
.const [92] = NameAndType [156] [157] 
.const [93] = Class [158] 
.const [94] = NameAndType [159] [160] 
.const [95] = Class [161] 
.const [96] = NameAndType [162] [163] 
.const [97] = Class [164] 
.const [98] = NameAndType [165] [166] 
.const [99] = Class [167] 
.const [100] = NameAndType [168] [169] 
.const [101] = Class [170] 
.const [102] = NameAndType [171] [172] 
.const [103] = Class [173] 
.const [104] = NameAndType [174] [175] 
.const [105] = Class [176] 
.const [106] = NameAndType [177] [178] 
.const [107] = Class [179] 
.const [108] = NameAndType [180] [181] 
.const [109] = Class [182] 
.const [110] = NameAndType [183] [184] 
.const [111] = Class [185] 
.const [112] = NameAndType [186] [187] 
.const [113] = Class [188] 
.const [114] = NameAndType [189] [190] 
.const [115] = Class [191] 
.const [116] = NameAndType [192] [193] 
.const [117] = Class [194] 
.const [118] = NameAndType [195] [196] 
.const [119] = Utf8 java/util/HashMap 
.const [120] = Class [197] 
.const [121] = NameAndType [198] [199] 
.const [122] = Class [200] 
.const [123] = NameAndType [201] [202] 
.const [124] = Class [203] 
.const [125] = NameAndType [204] [205] 
.const [126] = Utf8 org/osgi/framework/BundleException 
.const [127] = Utf8 java/lang/StringBuffer 
.const [128] = Class [206] 
.const [129] = NameAndType [207] [208] 
.const [130] = Class [209] 
.const [131] = NameAndType [210] [211] 
.const [132] = Class [212] 
.const [133] = NameAndType [213] [214] 
.const [134] = Utf8 java/lang/Math 
.const [135] = Utf8 ceil 
.const [136] = Utf8 (D)D 
.const [137] = Utf8 de/audi/atip/startup/BundleHandler 
.const [138] = Utf8 bc 
.const [139] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [140] = Utf8 de/audi/atip/startup/BundleHandler 
.const [141] = Utf8 log 
.const [142] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [143] = Utf8 de/audi/atip/startup/BundleHandler 
.const [144] = Utf8 bundleMap 
.const [145] = Utf8 Ljava/util/Map; 
.const [146] = Utf8 java/util/Dictionary 
.const [147] = Utf8 get 
.const [148] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [149] = Utf8 java/lang/StringBuffer 
.const [150] = Utf8 append 
.const [151] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [152] = Utf8 java/lang/StringBuffer 
.const [153] = Utf8 toString 
.const [154] = Utf8 ()Ljava/lang/String; 
.const [155] = Utf8 de/audi/atip/log/LogChannel 
.const [156] = Utf8 log 
.const [157] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [158] = Utf8 java/lang/StringBuffer 
.const [159] = Utf8 append 
.const [160] = Utf8 (J)Ljava/lang/StringBuffer; 
.const [161] = Utf8 java/lang/Object 
.const [162] = Utf8 <init> 
.const [163] = Utf8 ()V 
.const [164] = Utf8 de/audi/atip/startup/BundleHandler 
.const [165] = Utf8 initBundleMap 
.const [166] = Utf8 ()V 
.const [167] = Utf8 java/util/HashMap 
.const [168] = Utf8 <init> 
.const [169] = Utf8 (I)V 
.const [170] = Utf8 de/audi/atip/startup/BundleHandler 
.const [171] = Utf8 getBundleName 
.const [172] = Utf8 (Lorg/osgi/framework/Bundle;)Ljava/lang/String; 
.const [173] = Utf8 java/lang/StringBuffer 
.const [174] = Utf8 <init> 
.const [175] = Utf8 ()V 
.const [176] = Utf8 org/osgi/framework/BundleException 
.const [177] = Utf8 <init> 
.const [178] = Utf8 (Ljava/lang/String;)V 
.const [179] = Utf8 org/osgi/framework/BundleException 
.const [180] = Utf8 <init> 
.const [181] = Utf8 (Ljava/lang/String;Ljava/lang/Throwable;)V 
.const [182] = Utf8 de/audi/atip/startup/BundleHandler 
.const [183] = Utf8 bc 
.const [184] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [185] = Utf8 de/audi/atip/startup/BundleHandler 
.const [186] = Utf8 log 
.const [187] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [188] = Utf8 de/audi/atip/startup/BundleHandler 
.const [189] = Utf8 bundleMap 
.const [190] = Utf8 Ljava/util/Map; 
.const [191] = Utf8 org/osgi/framework/Bundle 
.const [192] = Utf8 getHeaders 
.const [193] = Utf8 ()Ljava/util/Dictionary; 
.const [194] = Utf8 org/osgi/framework/BundleContext 
.const [195] = Utf8 getBundles 
.const [196] = Utf8 ()[Lorg/osgi/framework/Bundle; 
.const [197] = Utf8 java/util/Map 
.const [198] = Utf8 put 
.const [199] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [200] = Utf8 java/util/Map 
.const [201] = Utf8 get 
.const [202] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [203] = Utf8 org/osgi/framework/Bundle 
.const [204] = Utf8 getState 
.const [205] = Utf8 ()I 
.const [206] = Utf8 org/osgi/framework/Bundle 
.const [207] = Utf8 start 
.const [208] = Utf8 ()V 
.const [209] = Utf8 org/osgi/framework/Bundle 
.const [210] = Utf8 getBundleId 
.const [211] = Utf8 ()J 
.const [212] = Utf8 org/osgi/framework/Bundle 
.const [213] = Utf8 stop 
.const [214] = Utf8 ()V 
.const [215] = Utf8 de/audi/atip/startup/BundleHandler 
.const [216] = Class [215] 
.const [217] = Utf8 java/lang/Object 
.const [218] = Class [217] 
.const [219] = Utf8 bc 
.const [220] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [221] = Utf8 log 
.const [222] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [223] = Utf8 bundleMap 
.const [224] = Utf8 Ljava/util/Map; 
.const [225] = Utf8 Code 
.const [226] = Utf8 <init> 
.const [227] = Utf8 (Lorg/osgi/framework/BundleContext;Lde/audi/atip/log/LogChannel;)V 
.const [228] = Utf8 getBundleName 
.const [229] = Utf8 (Lorg/osgi/framework/Bundle;)Ljava/lang/String; 
.const [230] = Utf8 initBundleMap 
.const [231] = Utf8 ()V 
.const [232] = Utf8 getBundle 
.const [233] = Utf8 (Ljava/lang/String;)Lorg/osgi/framework/Bundle; 
.const [234] = Utf8 startBundle 
.const [235] = Utf8 (Lorg/osgi/framework/Bundle;)V 
.const [236] = Utf8 stopBundle 
.const [237] = Utf8 (Lorg/osgi/framework/Bundle;)V 
.end class 
