.version 50 0 
.class public super abstract [216] 
.super [218] 
.implements [220] 
.field private static final [221] [222] 
.field private final [223] [224] 
.field private final [225] [226] 
.field protected final [227] [228] 
.field private final [229] [230] 
.field private [231] [232] 

.method public [234] : [235] 
    .attribute [233] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     new [33] 
L8:     dup 
L9:     invokespecial [29] 
L12:    putfield [34] 
L15:    aload_0 
L16:    aload_1 
L17:    putfield [35] 
L20:    aload_0 
L21:    aload_2 
L22:    putfield [36] 
L25:    aload_0 
L26:    aload_2 
L27:    aload_0 
L28:    invokevirtual [21] 
L31:    aload_0 
L32:    invokeinterface [37] 0 
L37:    putfield [38] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method protected abstract [236] : [237] 
    .attribute [233] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [238] : [239] 
    .attribute [233] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [240] : [241] 
    .attribute [233] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [242] : [243] 
    .attribute [233] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [244] : [245] 
    .attribute [233] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     ldc [5] 
L10:    aload_0 
L11:    invokevirtual [21] 
L14:    invokevirtual [23] 
L17:    invokevirtual [24] 
L20:    aload_0 
L21:    getfield [18] 
L24:    dup 
L25:    astore_1 
L26:    monitorenter 
        .catch [0] from L27 to L41 using L44 
L27:    aload_0 
L28:    new [39] 
L31:    dup 
L32:    iconst_0 
L33:    invokespecial [30] 
L36:    putfield [40] 
L39:    aload_1 
L40:    monitorexit 
L41:    goto L49 
        .catch [0] from L44 to L47 using L44 
L44:    astore_2 
L45:    aload_1 
L46:    monitorexit 
L47:    aload_2 
L48:    athrow 
L49:    aload_0 
L50:    getfield [22] 
L53:    invokeinterface [41] 0 
L58:    return 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [246] : [247] 
    .attribute [233] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [3] 
L6:     ldc [7] 
L8:     ldc [5] 
L10:    aload_0 
L11:    invokevirtual [21] 
L14:    invokevirtual [23] 
L17:    invokevirtual [24] 
L20:    aload_0 
L21:    getfield [22] 
L24:    invokeinterface [42] 0 
L29:    aload_0 
L30:    getfield [18] 
L33:    dup 
L34:    astore_1 
L35:    monitorenter 
        .catch [0] from L36 to L50 using L53 
L36:    aload_0 
L37:    new [39] 
L40:    dup 
L41:    iconst_0 
L42:    invokespecial [30] 
L45:    putfield [40] 
L48:    aload_1 
L49:    monitorexit 
L50:    goto L58 
        .catch [0] from L53 to L56 using L53 
L53:    astore_2 
L54:    aload_1 
L55:    monitorexit 
L56:    aload_2 
L57:    athrow 
L58:    return 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [248] : [249] 
    .attribute [233] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [18] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L13 using L14 
L7:     aload_0 
L8:     getfield [25] 
L11:    aload_1 
L12:    monitorexit 
L13:    areturn 
        .catch [0] from L14 to L17 using L14 
L14:    astore_2 
L15:    aload_1 
L16:    monitorexit 
L17:    aload_2 
L18:    athrow 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [250] : [251] 
    .attribute [233] .code stack 5 locals 4 
L0:     aload_0 
L1:     new [43] 
L4:     dup 
L5:     aload_0 
L6:     aload_1 
L7:     invokespecial [31] 
L10:    invokevirtual [26] 
L13:    ifne L18 
L16:    aconst_null 
L17:    areturn 
L18:    aload_0 
L19:    getfield [20] 
L22:    aload_1 
L23:    invokeinterface [44] 0 
L28:    astore_2 
L29:    aload_2 
L30:    ifnonnull L45 
L33:    aload_0 
L34:    getfield [20] 
L37:    aload_1 
L38:    invokeinterface [45] 0 
L43:    aconst_null 
L44:    areturn 
L45:    aload_0 
L46:    getfield [19] 
L49:    ldc [3] 
L51:    ldc [9] 
L53:    ldc [5] 
L55:    aload_2 
L56:    invokevirtual [24] 
L59:    aload_0 
L60:    getfield [18] 
L63:    dup 
L64:    astore_3 
L65:    monitorenter 
        .catch [0] from L66 to L120 using L123 
L66:    new [39] 
L69:    dup 
L70:    aload_0 
L71:    getfield [25] 
L74:    invokeinterface [46] 0 
L79:    iconst_1 
L80:    iadd 
L81:    invokespecial [30] 
L84:    astore 4 
L86:    aload 4 
L88:    aload_0 
L89:    getfield [25] 
L92:    invokeinterface [47] 0 
L97:    pop 
L98:    aload 4 
L100:   aload_2 
L101:   invokeinterface [48] 0 
L106:   pop 
L107:   aload_0 
L108:   aload 4 
L110:   putfield [40] 
L113:   aload_0 
L114:   aload_2 
L115:   invokevirtual [27] 
L118:   aload_3 
L119:   monitorexit 
L120:   goto L130 
        .catch [0] from L123 to L127 using L123 
L123:   astore 5 
L125:   aload_3 
L126:   monitorexit 
L127:   aload 5 
L129:   athrow 
L130:   aload_2 
L131:   areturn 
L132:   
    .end code 
.end method 

.method public [252] : [253] 
    .attribute [233] .code stack 5 locals 3 
L0:     aload_0 
L1:     new [43] 
L4:     dup 
L5:     aload_0 
L6:     aload_1 
L7:     invokespecial [31] 
L10:    invokevirtual [26] 
L13:    ifne L17 
L16:    return 
L17:    aload_2 
L18:    ifnonnull L22 
L21:    return 
L22:    aload_0 
L23:    getfield [19] 
L26:    ldc [3] 
L28:    ldc [10] 
L30:    ldc [5] 
L32:    aload_2 
L33:    invokevirtual [24] 
L36:    aload_0 
L37:    aload_2 
L38:    invokevirtual [28] 
L41:    aload_0 
L42:    getfield [20] 
L45:    aload_1 
L46:    invokeinterface [45] 0 
L51:    aload_0 
L52:    getfield [18] 
L55:    dup 
L56:    astore_3 
L57:    monitorenter 
        .catch [0] from L58 to L88 using L91 
L58:    new [49] 
L61:    dup 
L62:    aload_0 
L63:    getfield [25] 
L66:    invokespecial [32] 
L69:    astore 4 
L71:    aload 4 
L73:    aload_2 
L74:    invokeinterface [50] 0 
L79:    pop 
L80:    aload_0 
L81:    aload 4 
L83:    putfield [40] 
L86:    aload_3 
L87:    monitorexit 
L88:    goto L98 
        .catch [0] from L91 to L95 using L91 
L91:    astore 5 
L93:    aload_3 
L94:    monitorexit 
L95:    aload 5 
L97:    athrow 
L98:    return 
L99:    nop 
L100:   
    .end code 
.end method 

.method public enum [254] : [255] 
    .attribute [233] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [51] 
.const [3] = Int 1078071040 
.const [4] = String [52] 
.const [5] = String [53] 
.const [6] = Class [54] 
.const [7] = String [55] 
.const [8] = Class [56] 
.const [9] = String [57] 
.const [10] = String [58] 
.const [11] = Class [59] 
.const [12] = Class [60] 
.const [13] = Class [61] 
.const [14] = Class [62] 
.const [15] = Class [63] 
.const [16] = Class [64] 
.const [17] = Class [65] 
.const [18] = Field [66] [67] 
.const [19] = Field [68] [69] 
.const [20] = Field [70] [71] 
.const [21] = Method [72] [73] 
.const [22] = Field [74] [75] 
.const [23] = Method [76] [77] 
.const [24] = Method [78] [79] 
.const [25] = Field [80] [81] 
.const [26] = Method [82] [83] 
.const [27] = Method [84] [85] 
.const [28] = Method [86] [87] 
.const [29] = Method [88] [89] 
.const [30] = Method [90] [91] 
.const [31] = Method [92] [93] 
.const [32] = Method [94] [95] 
.const [33] = Class [96] 
.const [34] = Field [97] [98] 
.const [35] = Field [99] [100] 
.const [36] = Field [101] [102] 
.const [37] = InterfaceMethod [103] [104] 
.const [38] = Field [105] [106] 
.const [39] = Class [107] 
.const [40] = Field [108] [109] 
.const [41] = InterfaceMethod [110] [111] 
.const [42] = InterfaceMethod [112] [113] 
.const [43] = Class [114] 
.const [44] = InterfaceMethod [115] [116] 
.const [45] = InterfaceMethod [117] [118] 
.const [46] = InterfaceMethod [119] [120] 
.const [47] = InterfaceMethod [121] [122] 
.const [48] = InterfaceMethod [123] [124] 
.const [49] = Class [125] 
.const [50] = InterfaceMethod [126] [127] 
.const [51] = Utf8 java/lang/Object 
.const [52] = Utf8 '[%1.init] [%2]' 
.const [53] = Utf8 AbstractServiceListTracker 
.const [54] = Utf8 java/util/ArrayList 
.const [55] = Utf8 '[%1.deinit] [%2]' 
.const [56] = Utf8 de/audi/app/media/osgi/AbstractServiceListTracker$PropertyDictonary 
.const [57] = Utf8 "[%1.addingService] '%2'" 
.const [58] = Utf8 "[%1.removedService] '%2'" 
.const [59] = Utf8 java/util/LinkedList 
.const [60] = Utf8 de/audi/app/media/osgi/AbstractServiceListTracker 
.const [61] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [62] = Utf8 java/lang/Class 
.const [63] = Utf8 de/audi/atip/log/LogChannel 
.const [64] = Utf8 de/audi/app/media/osgi/IServiceTracker 
.const [65] = Utf8 java/util/List 
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
.const [96] = Utf8 java/lang/Object 
.const [97] = Class [173] 
.const [98] = NameAndType [174] [175] 
.const [99] = Class [176] 
.const [100] = NameAndType [177] [178] 
.const [101] = Class [179] 
.const [102] = NameAndType [180] [181] 
.const [103] = Class [182] 
.const [104] = NameAndType [183] [184] 
.const [105] = Class [185] 
.const [106] = NameAndType [186] [187] 
.const [107] = Utf8 java/util/ArrayList 
.const [108] = Class [188] 
.const [109] = NameAndType [189] [190] 
.const [110] = Class [191] 
.const [111] = NameAndType [192] [193] 
.const [112] = Class [194] 
.const [113] = NameAndType [195] [196] 
.const [114] = Utf8 de/audi/app/media/osgi/AbstractServiceListTracker$PropertyDictonary 
.const [115] = Class [197] 
.const [116] = NameAndType [198] [199] 
.const [117] = Class [200] 
.const [118] = NameAndType [201] [202] 
.const [119] = Class [203] 
.const [120] = NameAndType [204] [205] 
.const [121] = Class [206] 
.const [122] = NameAndType [207] [208] 
.const [123] = Class [209] 
.const [124] = NameAndType [210] [211] 
.const [125] = Utf8 java/util/LinkedList 
.const [126] = Class [212] 
.const [127] = NameAndType [213] [214] 
.const [128] = Utf8 de/audi/app/media/osgi/AbstractServiceListTracker 
.const [129] = Utf8 mutex 
.const [130] = Utf8 Ljava/lang/Object; 
.const [131] = Utf8 de/audi/app/media/osgi/AbstractServiceListTracker 
.const [132] = Utf8 logger 
.const [133] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [134] = Utf8 de/audi/app/media/osgi/AbstractServiceListTracker 
.const [135] = Utf8 serviceManager 
.const [136] = Utf8 Lde/audi/app/media/osgi/IServiceManager; 
.const [137] = Utf8 de/audi/app/media/osgi/AbstractServiceListTracker 
.const [138] = Utf8 getTrackedServiceClass 
.const [139] = Utf8 ()Ljava/lang/Class; 
.const [140] = Utf8 de/audi/app/media/osgi/AbstractServiceListTracker 
.const [141] = Utf8 serviceTracker 
.const [142] = Utf8 Lde/audi/app/media/osgi/IServiceTracker; 
.const [143] = Utf8 java/lang/Class 
.const [144] = Utf8 getName 
.const [145] = Utf8 ()Ljava/lang/String; 
.const [146] = Utf8 de/audi/atip/log/LogChannel 
.const [147] = Utf8 log 
.const [148] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [149] = Utf8 de/audi/app/media/osgi/AbstractServiceListTracker 
.const [150] = Utf8 foundServices 
.const [151] = Utf8 Ljava/util/List; 
.const [152] = Utf8 de/audi/app/media/osgi/AbstractServiceListTracker 
.const [153] = Utf8 checkServiceProperties 
.const [154] = Utf8 (Ljava/util/Dictionary;)Z 
.const [155] = Utf8 de/audi/app/media/osgi/AbstractServiceListTracker 
.const [156] = Utf8 serviceAdded 
.const [157] = Utf8 (Ljava/lang/Object;)V 
.const [158] = Utf8 de/audi/app/media/osgi/AbstractServiceListTracker 
.const [159] = Utf8 serviceRemoved 
.const [160] = Utf8 (Ljava/lang/Object;)V 
.const [161] = Utf8 java/lang/Object 
.const [162] = Utf8 <init> 
.const [163] = Utf8 ()V 
.const [164] = Utf8 java/util/ArrayList 
.const [165] = Utf8 <init> 
.const [166] = Utf8 (I)V 
.const [167] = Utf8 de/audi/app/media/osgi/AbstractServiceListTracker$PropertyDictonary 
.const [168] = Utf8 <init> 
.const [169] = Utf8 (Lde/audi/app/media/osgi/AbstractServiceListTracker;Lorg/osgi/framework/ServiceReference;)V 
.const [170] = Utf8 java/util/LinkedList 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (Ljava/util/Collection;)V 
.const [173] = Utf8 de/audi/app/media/osgi/AbstractServiceListTracker 
.const [174] = Utf8 mutex 
.const [175] = Utf8 Ljava/lang/Object; 
.const [176] = Utf8 de/audi/app/media/osgi/AbstractServiceListTracker 
.const [177] = Utf8 logger 
.const [178] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [179] = Utf8 de/audi/app/media/osgi/AbstractServiceListTracker 
.const [180] = Utf8 serviceManager 
.const [181] = Utf8 Lde/audi/app/media/osgi/IServiceManager; 
.const [182] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [183] = Utf8 createServiceTracker 
.const [184] = Utf8 (Ljava/lang/Class;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)Lde/audi/app/media/osgi/IServiceTracker; 
.const [185] = Utf8 de/audi/app/media/osgi/AbstractServiceListTracker 
.const [186] = Utf8 serviceTracker 
.const [187] = Utf8 Lde/audi/app/media/osgi/IServiceTracker; 
.const [188] = Utf8 de/audi/app/media/osgi/AbstractServiceListTracker 
.const [189] = Utf8 foundServices 
.const [190] = Utf8 Ljava/util/List; 
.const [191] = Utf8 de/audi/app/media/osgi/IServiceTracker 
.const [192] = Utf8 'open' 
.const [193] = Utf8 ()V 
.const [194] = Utf8 de/audi/app/media/osgi/IServiceTracker 
.const [195] = Utf8 close 
.const [196] = Utf8 ()V 
.const [197] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [198] = Utf8 getService 
.const [199] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [200] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [201] = Utf8 releaseService 
.const [202] = Utf8 (Lorg/osgi/framework/ServiceReference;)V 
.const [203] = Utf8 java/util/List 
.const [204] = Utf8 size 
.const [205] = Utf8 ()I 
.const [206] = Utf8 java/util/List 
.const [207] = Utf8 addAll 
.const [208] = Utf8 (Ljava/util/Collection;)Z 
.const [209] = Utf8 java/util/List 
.const [210] = Utf8 add 
.const [211] = Utf8 (Ljava/lang/Object;)Z 
.const [212] = Utf8 java/util/List 
.const [213] = Utf8 remove 
.const [214] = Utf8 (Ljava/lang/Object;)Z 
.const [215] = Utf8 de/audi/app/media/osgi/AbstractServiceListTracker 
.const [216] = Class [215] 
.const [217] = Utf8 java/lang/Object 
.const [218] = Class [217] 
.const [219] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [220] = Class [219] 
.const [221] = Utf8 LOGCLASS 
.const [222] = Utf8 Ljava/lang/String; 
.const [223] = Utf8 mutex 
.const [224] = Utf8 Ljava/lang/Object; 
.const [225] = Utf8 serviceManager 
.const [226] = Utf8 Lde/audi/app/media/osgi/IServiceManager; 
.const [227] = Utf8 logger 
.const [228] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [229] = Utf8 serviceTracker 
.const [230] = Utf8 Lde/audi/app/media/osgi/IServiceTracker; 
.const [231] = Utf8 foundServices 
.const [232] = Utf8 Ljava/util/List; 
.const [233] = Utf8 Code 
.const [234] = Utf8 <init> 
.const [235] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/app/media/osgi/IServiceManager;)V 
.const [236] = Utf8 getTrackedServiceClass 
.const [237] = Utf8 ()Ljava/lang/Class; 
.const [238] = Utf8 serviceAdded 
.const [239] = Utf8 (Ljava/lang/Object;)V 
.const [240] = Utf8 serviceRemoved 
.const [241] = Utf8 (Ljava/lang/Object;)V 
.const [242] = Utf8 checkServiceProperties 
.const [243] = Utf8 (Ljava/util/Dictionary;)Z 
.const [244] = Utf8 init 
.const [245] = Utf8 ()V 
.const [246] = Utf8 deinit 
.const [247] = Utf8 ()V 
.const [248] = Utf8 getServices 
.const [249] = Utf8 ()Ljava/util/List; 
.const [250] = Utf8 addingService 
.const [251] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [252] = Utf8 removedService 
.const [253] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [254] = Utf8 modifiedService 
.const [255] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.end class 
