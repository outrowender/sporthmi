.version 50 0 
.class public super [276] 
.super [278] 
.implements [280] 
.field private static final [281] [282] 
.field private final [283] [284] 
.field private final [285] [286] 
.field private final [287] [288] 
.field static synthetic [289] [290] 

.method public [292] : [293] 
    .attribute [291] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [49] 
L4:     aload_1 
L5:     ifnull L12 
L8:     aload_2 
L9:     ifnonnull L20 
L12:    new [57] 
L15:    dup 
L16:    invokespecial [50] 
L19:    athrow 
L20:    aload_0 
L21:    aload_2 
L22:    ldc [6] 
L24:    invokeinterface [58] 0 
L29:    putfield [59] 
L32:    aload_0 
L33:    aload_1 
L34:    putfield [60] 
L37:    aload_0 
L38:    aload_2 
L39:    putfield [61] 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [294] : [295] 
    .attribute [291] .code stack 5 locals 0 
L0:     aload_1 
L1:     ifnull L8 
L4:     aload_2 
L5:     ifnonnull L16 
L8:     new [57] 
L11:    dup 
L12:    invokespecial [50] 
L15:    athrow 
L16:    new [62] 
L19:    dup 
L20:    aload_0 
L21:    getfield [39] 
L24:    aload_1 
L25:    aload_2 
L26:    invokespecial [51] 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [296] : [297] 
    .attribute [291] .code stack 5 locals 1 
L0:     aload_1 
L1:     ifnonnull L12 
L4:     new [57] 
L7:     dup 
L8:     invokespecial [50] 
L11:    athrow 
        .catch [8] from L12 to L26 using L27 
L12:    aload_0 
L13:    getfield [39] 
L16:    aload_1 
L17:    invokevirtual [41] 
L20:    aconst_null 
L21:    invokeinterface [63] 0 
L26:    areturn 
L27:    astore_2 
L28:    aload_0 
L29:    getfield [38] 
L32:    ldc [9] 
L34:    ldc [10] 
L36:    ldc [11] 
L38:    aload_2 
L39:    invokevirtual [42] 
L42:    pop 
L43:    iconst_0 
L44:    anewarray [12] 
L47:    areturn 
L48:    
    .end code 
.end method 

.method public final [298] : [299] 
    .attribute [291] .code stack 5 locals 0 
L0:     aload_1 
L1:     ifnull L12 
L4:     aload_2 
L5:     ifnull L12 
L8:     aload_3 
L9:     ifnonnull L20 
L12:    new [57] 
L15:    dup 
L16:    invokespecial [50] 
L19:    athrow 
L20:    aload_0 
L21:    getfield [38] 
L24:    ldc [13] 
L26:    ldc [14] 
L28:    ldc [11] 
L30:    aload_1 
L31:    invokevirtual [41] 
L34:    invokestatic [15] 
L37:    invokevirtual [43] 
L40:    aload_0 
L41:    getfield [39] 
L44:    aload_1 
L45:    invokevirtual [41] 
L48:    aload_2 
L49:    aload_3 
L50:    invokeinterface [64] 0 
L55:    areturn 
L56:    
    .end code 
.end method 

.method public [300] : [301] 
    .attribute [291] .code stack 2 locals 1 
        .catch [16] from L0 to L6 using L9 
L0:     aload_1 
L1:     invokeinterface [65] 0 
L6:     goto L18 
L9:     astore_2 
L10:    new [57] 
L13:    dup 
L14:    invokespecial [50] 
L17:    athrow 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public final [302] : [303] 
    .attribute [291] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [17] 
L6:     ldc [18] 
L8:     ldc [11] 
L10:    aload_2 
L11:    invokestatic [15] 
L14:    iload_1 
L15:    i2l 
L16:    invokevirtual [44] 
L19:    aload_2 
L20:    ifnull L27 
L23:    aload_3 
L24:    ifnonnull L35 
L27:    new [57] 
L30:    dup 
L31:    invokespecial [50] 
L34:    athrow 
L35:    new [66] 
L38:    dup 
L39:    iconst_2 
L40:    invokespecial [52] 
L43:    astore 4 
L45:    aload 4 
L47:    ldc [20] 
L49:    aload_2 
L50:    invokevirtual [45] 
L53:    pop 
L54:    aload 4 
L56:    ldc [21] 
L58:    new [67] 
L61:    dup 
L62:    iload_1 
L63:    invokespecial [53] 
L66:    invokevirtual [45] 
L69:    pop 
L70:    aload_0 
L71:    getstatic [23] 
L74:    ifnonnull L89 
L77:    ldc [24] 
L79:    invokestatic [25] 
L82:    dup 
L83:    putstatic [54] 
L86:    goto L92 
L89:    getstatic [23] 
L92:    aload_3 
L93:    aload 4 
L95:    invokespecial [55] 
L98:    areturn 
L99:    nop 
L100:   
    .end code 
.end method 

.method public [304] : [305] 
    .attribute [291] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnonnull L12 
L4:     new [57] 
L7:     dup 
L8:     invokespecial [50] 
L11:    athrow 
L12:    aload_0 
L13:    getfield [39] 
L16:    aload_1 
L17:    invokeinterface [68] 0 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [306] : [307] 
    .attribute [291] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnonnull L12 
L4:     new [57] 
L7:     dup 
L8:     invokespecial [50] 
L11:    athrow 
L12:    aload_0 
L13:    getfield [39] 
L16:    aload_1 
L17:    invokeinterface [69] 0 
L22:    pop 
L23:    return 
L24:    
    .end code 
.end method 

.method public [308] : [309] 
    .attribute [291] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [17] 
L6:     ldc [26] 
L8:     ldc [11] 
L10:    aload_1 
L11:    invokestatic [15] 
L14:    iload_2 
L15:    i2l 
L16:    invokevirtual [44] 
L19:    aload_0 
L20:    getfield [40] 
L23:    aload_1 
L24:    iload_2 
L25:    invokeinterface [70] 0 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [310] : [311] 
    .attribute [291] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [17] 
L6:     ldc [27] 
L8:     ldc [11] 
L10:    aload_1 
L11:    invokestatic [15] 
L14:    iload_2 
L15:    i2l 
L16:    invokevirtual [44] 
L19:    aload_0 
L20:    getfield [40] 
L23:    aload_1 
L24:    iload_2 
L25:    invokeinterface [71] 0 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method private static [312] : [313] 
    .attribute [291] .code stack 3 locals 0 
L0:     aload_0 
L1:     ifnonnull L12 
L4:     new [57] 
L7:     dup 
L8:     invokespecial [50] 
L11:    athrow 
L12:    aload_0 
L13:    aload_0 
L14:    bipush 46 
L16:    invokevirtual [46] 
L19:    iconst_1 
L20:    iadd 
L21:    invokevirtual [47] 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public interface [314] : [315] 
    .attribute [291] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [40] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [316] : [317] 
    .attribute [291] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [39] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [318] : [319] 
    .attribute [291] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [56] 
L9:     dup 
L10:    invokespecial [48] 
L13:    aload_1 
L14:    invokevirtual [37] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [72] [73] 
.const [3] = Class [74] 
.const [4] = Class [75] 
.const [5] = Class [76] 
.const [6] = String [77] 
.const [7] = Class [78] 
.const [8] = Class [79] 
.const [9] = Int -1601830656 
.const [10] = String [80] 
.const [11] = String [81] 
.const [12] = Class [82] 
.const [13] = Int -2137614336 
.const [14] = String [83] 
.const [15] = Method [84] [85] 
.const [16] = Class [86] 
.const [17] = Int 1078071040 
.const [18] = String [87] 
.const [19] = Class [88] 
.const [20] = String [89] 
.const [21] = String [90] 
.const [22] = Class [91] 
.const [23] = Field [92] [93] 
.const [24] = String [94] 
.const [25] = Method [95] [96] 
.const [26] = String [97] 
.const [27] = String [98] 
.const [28] = Class [99] 
.const [29] = Class [100] 
.const [30] = Class [101] 
.const [31] = Class [102] 
.const [32] = Class [103] 
.const [33] = Class [104] 
.const [34] = Class [105] 
.const [35] = Class [106] 
.const [36] = Class [107] 
.const [37] = Method [108] [109] 
.const [38] = Field [110] [111] 
.const [39] = Field [112] [113] 
.const [40] = Field [114] [115] 
.const [41] = Method [116] [117] 
.const [42] = Method [118] [119] 
.const [43] = Method [120] [121] 
.const [44] = Method [122] [123] 
.const [45] = Method [124] [125] 
.const [46] = Method [126] [127] 
.const [47] = Method [128] [129] 
.const [48] = Method [130] [131] 
.const [49] = Method [132] [133] 
.const [50] = Method [134] [135] 
.const [51] = Method [136] [137] 
.const [52] = Method [138] [139] 
.const [53] = Method [140] [141] 
.const [54] = Field [142] [143] 
.const [55] = Method [144] [145] 
.const [56] = Class [146] 
.const [57] = Class [147] 
.const [58] = InterfaceMethod [148] [149] 
.const [59] = Field [150] [151] 
.const [60] = Field [152] [153] 
.const [61] = Field [154] [155] 
.const [62] = Class [156] 
.const [63] = InterfaceMethod [157] [158] 
.const [64] = InterfaceMethod [159] [160] 
.const [65] = InterfaceMethod [161] [162] 
.const [66] = Class [163] 
.const [67] = Class [164] 
.const [68] = InterfaceMethod [165] [166] 
.const [69] = InterfaceMethod [167] [168] 
.const [70] = InterfaceMethod [169] [170] 
.const [71] = InterfaceMethod [171] [172] 
.const [72] = Class [173] 
.const [73] = NameAndType [174] [175] 
.const [74] = Utf8 java/lang/ClassNotFoundException 
.const [75] = Utf8 java/lang/NoClassDefFoundError 
.const [76] = Utf8 java/lang/IllegalArgumentException 
.const [77] = Utf8 'App.Media.OSGI' 
.const [78] = Utf8 de/audi/app/media/osgi/ServiceTrackerImpl 
.const [79] = Utf8 java/lang/Exception 
.const [80] = Utf8 '[%1.getServiceReferences] %2.' 
.const [81] = Utf8 ServiceManagerImpl 
.const [82] = Utf8 org/osgi/framework/ServiceReference 
.const [83] = Utf8 "[%1.registerService] '%2'." 
.const [84] = Class [176] 
.const [85] = NameAndType [177] [178] 
.const [86] = Utf8 java/lang/NullPointerException 
.const [87] = Utf8 '[%1.registerDSIListener] [%2,%3]' 
.const [88] = Utf8 java/util/Hashtable 
.const [89] = Utf8 DEVICE_NAME 
.const [90] = Utf8 DEVICE_INSTANCE 
.const [91] = Utf8 java/lang/Integer 
.const [92] = Class [179] 
.const [93] = NameAndType [180] [181] 
.const [94] = Utf8 'org.dsi.ifc.base.DSIListener' 
.const [95] = Class [182] 
.const [96] = NameAndType [183] [184] 
.const [97] = Utf8 '[%1.startDSIService] [%2,%3]' 
.const [98] = Utf8 '[%1.stopDSIService] [%2,%3]' 
.const [99] = Utf8 de/audi/app/media/osgi/ServiceManagerImpl 
.const [100] = Utf8 java/lang/Object 
.const [101] = Utf8 java/lang/Class 
.const [102] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [103] = Utf8 org/osgi/framework/BundleContext 
.const [104] = Utf8 de/audi/atip/log/LogChannel 
.const [105] = Utf8 org/osgi/framework/ServiceRegistration 
.const [106] = Utf8 java/util/Dictionary 
.const [107] = Utf8 java/lang/String 
.const [108] = Class [185] 
.const [109] = NameAndType [186] [187] 
.const [110] = Class [188] 
.const [111] = NameAndType [189] [190] 
.const [112] = Class [191] 
.const [113] = NameAndType [192] [193] 
.const [114] = Class [194] 
.const [115] = NameAndType [195] [196] 
.const [116] = Class [197] 
.const [117] = NameAndType [198] [199] 
.const [118] = Class [200] 
.const [119] = NameAndType [201] [202] 
.const [120] = Class [203] 
.const [121] = NameAndType [204] [205] 
.const [122] = Class [206] 
.const [123] = NameAndType [207] [208] 
.const [124] = Class [209] 
.const [125] = NameAndType [210] [211] 
.const [126] = Class [212] 
.const [127] = NameAndType [213] [214] 
.const [128] = Class [215] 
.const [129] = NameAndType [216] [217] 
.const [130] = Class [218] 
.const [131] = NameAndType [219] [220] 
.const [132] = Class [221] 
.const [133] = NameAndType [222] [223] 
.const [134] = Class [224] 
.const [135] = NameAndType [225] [226] 
.const [136] = Class [227] 
.const [137] = NameAndType [228] [229] 
.const [138] = Class [230] 
.const [139] = NameAndType [231] [232] 
.const [140] = Class [233] 
.const [141] = NameAndType [234] [235] 
.const [142] = Class [236] 
.const [143] = NameAndType [237] [238] 
.const [144] = Class [239] 
.const [145] = NameAndType [240] [241] 
.const [146] = Utf8 java/lang/NoClassDefFoundError 
.const [147] = Utf8 java/lang/IllegalArgumentException 
.const [148] = Class [242] 
.const [149] = NameAndType [243] [244] 
.const [150] = Class [245] 
.const [151] = NameAndType [246] [247] 
.const [152] = Class [248] 
.const [153] = NameAndType [249] [250] 
.const [154] = Class [251] 
.const [155] = NameAndType [252] [253] 
.const [156] = Utf8 de/audi/app/media/osgi/ServiceTrackerImpl 
.const [157] = Class [254] 
.const [158] = NameAndType [255] [256] 
.const [159] = Class [257] 
.const [160] = NameAndType [258] [259] 
.const [161] = Class [260] 
.const [162] = NameAndType [261] [262] 
.const [163] = Utf8 java/util/Hashtable 
.const [164] = Utf8 java/lang/Integer 
.const [165] = Class [263] 
.const [166] = NameAndType [264] [265] 
.const [167] = Class [266] 
.const [168] = NameAndType [267] [268] 
.const [169] = Class [269] 
.const [170] = NameAndType [270] [271] 
.const [171] = Class [272] 
.const [172] = NameAndType [273] [274] 
.const [173] = Utf8 java/lang/Class 
.const [174] = Utf8 forName 
.const [175] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [176] = Utf8 de/audi/app/media/osgi/ServiceManagerImpl 
.const [177] = Utf8 getClassnameWithoutPackage 
.const [178] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [179] = Utf8 de/audi/app/media/osgi/ServiceManagerImpl 
.const [180] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [181] = Utf8 Ljava/lang/Class; 
.const [182] = Utf8 de/audi/app/media/osgi/ServiceManagerImpl 
.const [183] = Utf8 class$ 
.const [184] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [185] = Utf8 java/lang/NoClassDefFoundError 
.const [186] = Utf8 initCause 
.const [187] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [188] = Utf8 de/audi/app/media/osgi/ServiceManagerImpl 
.const [189] = Utf8 logger 
.const [190] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [191] = Utf8 de/audi/app/media/osgi/ServiceManagerImpl 
.const [192] = Utf8 osgiBundleContext 
.const [193] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [194] = Utf8 de/audi/app/media/osgi/ServiceManagerImpl 
.const [195] = Utf8 framework 
.const [196] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [197] = Utf8 java/lang/Class 
.const [198] = Utf8 getName 
.const [199] = Utf8 ()Ljava/lang/String; 
.const [200] = Utf8 de/audi/atip/log/LogChannel 
.const [201] = Utf8 log 
.const [202] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)Z 
.const [203] = Utf8 de/audi/atip/log/LogChannel 
.const [204] = Utf8 log 
.const [205] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [206] = Utf8 de/audi/atip/log/LogChannel 
.const [207] = Utf8 log 
.const [208] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;J)V 
.const [209] = Utf8 java/util/Dictionary 
.const [210] = Utf8 put 
.const [211] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [212] = Utf8 java/lang/String 
.const [213] = Utf8 lastIndexOf 
.const [214] = Utf8 (I)I 
.const [215] = Utf8 java/lang/String 
.const [216] = Utf8 substring 
.const [217] = Utf8 (I)Ljava/lang/String; 
.const [218] = Utf8 java/lang/NoClassDefFoundError 
.const [219] = Utf8 <init> 
.const [220] = Utf8 ()V 
.const [221] = Utf8 java/lang/Object 
.const [222] = Utf8 <init> 
.const [223] = Utf8 ()V 
.const [224] = Utf8 java/lang/IllegalArgumentException 
.const [225] = Utf8 <init> 
.const [226] = Utf8 ()V 
.const [227] = Utf8 de/audi/app/media/osgi/ServiceTrackerImpl 
.const [228] = Utf8 <init> 
.const [229] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/Class;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [230] = Utf8 java/util/Hashtable 
.const [231] = Utf8 <init> 
.const [232] = Utf8 (I)V 
.const [233] = Utf8 java/lang/Integer 
.const [234] = Utf8 <init> 
.const [235] = Utf8 (I)V 
.const [236] = Utf8 de/audi/app/media/osgi/ServiceManagerImpl 
.const [237] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [238] = Utf8 Ljava/lang/Class; 
.const [239] = Utf8 de/audi/app/media/osgi/ServiceManagerImpl 
.const [240] = Utf8 registerService 
.const [241] = Utf8 (Ljava/lang/Class;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [242] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [243] = Utf8 getLogChannel 
.const [244] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [245] = Utf8 de/audi/app/media/osgi/ServiceManagerImpl 
.const [246] = Utf8 logger 
.const [247] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [248] = Utf8 de/audi/app/media/osgi/ServiceManagerImpl 
.const [249] = Utf8 osgiBundleContext 
.const [250] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [251] = Utf8 de/audi/app/media/osgi/ServiceManagerImpl 
.const [252] = Utf8 framework 
.const [253] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [254] = Utf8 org/osgi/framework/BundleContext 
.const [255] = Utf8 getServiceReferences 
.const [256] = Utf8 (Ljava/lang/String;Ljava/lang/String;)[Lorg/osgi/framework/ServiceReference; 
.const [257] = Utf8 org/osgi/framework/BundleContext 
.const [258] = Utf8 registerService 
.const [259] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [260] = Utf8 org/osgi/framework/ServiceRegistration 
.const [261] = Utf8 unregister 
.const [262] = Utf8 ()V 
.const [263] = Utf8 org/osgi/framework/BundleContext 
.const [264] = Utf8 getService 
.const [265] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [266] = Utf8 org/osgi/framework/BundleContext 
.const [267] = Utf8 ungetService 
.const [268] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [269] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [270] = Utf8 startDSIService 
.const [271] = Utf8 (Ljava/lang/String;I)Z 
.const [272] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [273] = Utf8 stopDSIService 
.const [274] = Utf8 (Ljava/lang/String;I)V 
.const [275] = Utf8 de/audi/app/media/osgi/ServiceManagerImpl 
.const [276] = Class [275] 
.const [277] = Utf8 java/lang/Object 
.const [278] = Class [277] 
.const [279] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [280] = Class [279] 
.const [281] = Utf8 LOGCLASS 
.const [282] = Utf8 Ljava/lang/String; 
.const [283] = Utf8 osgiBundleContext 
.const [284] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [285] = Utf8 framework 
.const [286] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [287] = Utf8 logger 
.const [288] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [289] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [290] = Utf8 Ljava/lang/Class; 
.const [291] = Utf8 Code 
.const [292] = Utf8 <init> 
.const [293] = Utf8 (Lorg/osgi/framework/BundleContext;Lde/audi/atip/base/IFrameworkAccess;)V 
.const [294] = Utf8 createServiceTracker 
.const [295] = Utf8 (Ljava/lang/Class;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)Lde/audi/app/media/osgi/IServiceTracker; 
.const [296] = Utf8 getServiceReferences 
.const [297] = Utf8 (Ljava/lang/Class;)[Lorg/osgi/framework/ServiceReference; 
.const [298] = Utf8 registerService 
.const [299] = Utf8 (Ljava/lang/Class;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [300] = Utf8 unregisterService 
.const [301] = Utf8 (Lorg/osgi/framework/ServiceRegistration;)V 
.const [302] = Utf8 registerDSIListener 
.const [303] = Utf8 (ILjava/lang/String;Lorg/dsi/ifc/base/DSIListener;)Lorg/osgi/framework/ServiceRegistration; 
.const [304] = Utf8 getService 
.const [305] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [306] = Utf8 releaseService 
.const [307] = Utf8 (Lorg/osgi/framework/ServiceReference;)V 
.const [308] = Utf8 startDSIService 
.const [309] = Utf8 (Ljava/lang/String;I)Z 
.const [310] = Utf8 stopDSIService 
.const [311] = Utf8 (Ljava/lang/String;I)V 
.const [312] = Utf8 getClassnameWithoutPackage 
.const [313] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [314] = Utf8 getFrameworkAccess 
.const [315] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [316] = Utf8 getBundleContext 
.const [317] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [318] = Utf8 class$ 
.const [319] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
