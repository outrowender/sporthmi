.version 50 0 
.class public super abstract [217] 
.super [219] 
.implements [221] 
.field private static final [222] [223] 
.field private final [224] [225] 
.field private final [226] [227] 
.field protected final [228] [229] 
.field private final [230] [231] 
.field private [232] [233] 

.method public [235] : [236] 
    .attribute [234] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     aload_0 
L5:     new [34] 
L8:     dup 
L9:     invokespecial [30] 
L12:    putfield [35] 
L15:    aload_0 
L16:    aload_1 
L17:    putfield [36] 
L20:    aload_0 
L21:    aload_2 
L22:    putfield [37] 
L25:    aload_0 
L26:    aload_2 
L27:    aload_0 
L28:    invokevirtual [22] 
L31:    aload_0 
L32:    invokeinterface [38] 0 
L37:    putfield [39] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method protected abstract [237] : [238] 
    .attribute [234] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [239] : [240] 
    .attribute [234] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [241] : [242] 
    .attribute [234] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [243] : [244] 
    .attribute [234] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [234] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [20] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     ldc [5] 
L10:    aload_0 
L11:    invokevirtual [22] 
L14:    invokevirtual [24] 
L17:    invokevirtual [25] 
L20:    aload_0 
L21:    getfield [19] 
L24:    dup 
L25:    astore_1 
L26:    monitorenter 
        .catch [0] from L27 to L41 using L44 
L27:    aload_0 
L28:    new [40] 
L31:    dup 
L32:    iconst_0 
L33:    invokespecial [31] 
L36:    putfield [41] 
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
L50:    getfield [23] 
L53:    invokeinterface [42] 0 
L58:    return 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [234] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [20] 
L4:     ldc [7] 
L6:     ldc [8] 
L8:     ldc [5] 
L10:    aload_0 
L11:    invokevirtual [22] 
L14:    invokevirtual [24] 
L17:    invokevirtual [25] 
L20:    aload_0 
L21:    getfield [23] 
L24:    invokeinterface [43] 0 
L29:    aload_0 
L30:    getfield [19] 
L33:    dup 
L34:    astore_1 
L35:    monitorenter 
        .catch [0] from L36 to L50 using L53 
L36:    aload_0 
L37:    new [40] 
L40:    dup 
L41:    iconst_0 
L42:    invokespecial [31] 
L45:    putfield [41] 
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

.method public [249] : [250] 
    .attribute [234] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [19] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L13 using L14 
L7:     aload_0 
L8:     getfield [26] 
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

.method public [251] : [252] 
    .attribute [234] .code stack 5 locals 4 
L0:     aload_0 
L1:     new [44] 
L4:     dup 
L5:     aload_0 
L6:     aload_1 
L7:     invokespecial [32] 
L10:    invokevirtual [27] 
L13:    ifne L18 
L16:    aconst_null 
L17:    areturn 
L18:    aload_0 
L19:    getfield [21] 
L22:    aload_1 
L23:    invokeinterface [45] 0 
L28:    astore_2 
L29:    aload_2 
L30:    ifnonnull L45 
L33:    aload_0 
L34:    getfield [21] 
L37:    aload_1 
L38:    invokeinterface [46] 0 
L43:    aconst_null 
L44:    areturn 
L45:    aload_0 
L46:    getfield [20] 
L49:    ldc [7] 
L51:    ldc [10] 
L53:    ldc [5] 
L55:    aload_2 
L56:    invokevirtual [25] 
L59:    aload_0 
L60:    getfield [19] 
L63:    dup 
L64:    astore_3 
L65:    monitorenter 
        .catch [0] from L66 to L120 using L123 
L66:    new [40] 
L69:    dup 
L70:    aload_0 
L71:    getfield [26] 
L74:    invokeinterface [47] 0 
L79:    iconst_1 
L80:    iadd 
L81:    invokespecial [31] 
L84:    astore 4 
L86:    aload 4 
L88:    aload_0 
L89:    getfield [26] 
L92:    invokeinterface [48] 0 
L97:    pop 
L98:    aload 4 
L100:   aload_2 
L101:   invokeinterface [49] 0 
L106:   pop 
L107:   aload_0 
L108:   aload 4 
L110:   putfield [41] 
L113:   aload_0 
L114:   aload_2 
L115:   invokevirtual [28] 
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

.method public [253] : [254] 
    .attribute [234] .code stack 5 locals 3 
L0:     aload_0 
L1:     new [44] 
L4:     dup 
L5:     aload_0 
L6:     aload_1 
L7:     invokespecial [32] 
L10:    invokevirtual [27] 
L13:    ifne L17 
L16:    return 
L17:    aload_2 
L18:    ifnonnull L22 
L21:    return 
L22:    aload_0 
L23:    getfield [20] 
L26:    ldc [7] 
L28:    ldc [11] 
L30:    ldc [5] 
L32:    aload_2 
L33:    invokevirtual [25] 
L36:    aload_0 
L37:    aload_2 
L38:    invokevirtual [29] 
L41:    aload_0 
L42:    getfield [21] 
L45:    aload_1 
L46:    invokeinterface [46] 0 
L51:    aload_0 
L52:    getfield [19] 
L55:    dup 
L56:    astore_3 
L57:    monitorenter 
        .catch [0] from L58 to L88 using L91 
L58:    new [50] 
L61:    dup 
L62:    aload_0 
L63:    getfield [26] 
L66:    invokespecial [33] 
L69:    astore 4 
L71:    aload 4 
L73:    aload_2 
L74:    invokeinterface [51] 0 
L79:    pop 
L80:    aload_0 
L81:    aload 4 
L83:    putfield [41] 
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

.method public enum [255] : [256] 
    .attribute [234] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [52] 
.const [3] = Int 14808325 
.const [4] = String [53] 
.const [5] = String [54] 
.const [6] = Class [55] 
.const [7] = Int 1078071040 
.const [8] = String [56] 
.const [9] = Class [57] 
.const [10] = String [58] 
.const [11] = String [59] 
.const [12] = Class [60] 
.const [13] = Class [61] 
.const [14] = Class [62] 
.const [15] = Class [63] 
.const [16] = Class [64] 
.const [17] = Class [65] 
.const [18] = Class [66] 
.const [19] = Field [67] [68] 
.const [20] = Field [69] [70] 
.const [21] = Field [71] [72] 
.const [22] = Method [73] [74] 
.const [23] = Field [75] [76] 
.const [24] = Method [77] [78] 
.const [25] = Method [79] [80] 
.const [26] = Field [81] [82] 
.const [27] = Method [83] [84] 
.const [28] = Method [85] [86] 
.const [29] = Method [87] [88] 
.const [30] = Method [89] [90] 
.const [31] = Method [91] [92] 
.const [32] = Method [93] [94] 
.const [33] = Method [95] [96] 
.const [34] = Class [97] 
.const [35] = Field [98] [99] 
.const [36] = Field [100] [101] 
.const [37] = Field [102] [103] 
.const [38] = InterfaceMethod [104] [105] 
.const [39] = Field [106] [107] 
.const [40] = Class [108] 
.const [41] = Field [109] [110] 
.const [42] = InterfaceMethod [111] [112] 
.const [43] = InterfaceMethod [113] [114] 
.const [44] = Class [115] 
.const [45] = InterfaceMethod [116] [117] 
.const [46] = InterfaceMethod [118] [119] 
.const [47] = InterfaceMethod [120] [121] 
.const [48] = InterfaceMethod [122] [123] 
.const [49] = InterfaceMethod [124] [125] 
.const [50] = Class [126] 
.const [51] = InterfaceMethod [127] [128] 
.const [52] = Utf8 java/lang/Object 
.const [53] = Utf8 '[%1.init] [%2]' 
.const [54] = Utf8 AbstractServiceListTracker 
.const [55] = Utf8 java/util/ArrayList 
.const [56] = Utf8 '[%1.deinit] [%2]' 
.const [57] = Utf8 de/audi/app/terminalmode/osgi/AbstractServiceListTracker$PropertyDictonary 
.const [58] = Utf8 "[%1.addingService] '%2'" 
.const [59] = Utf8 "[%1.removedService] '%2'" 
.const [60] = Utf8 java/util/LinkedList 
.const [61] = Utf8 de/audi/app/terminalmode/osgi/AbstractServiceListTracker 
.const [62] = Utf8 de/audi/app/terminalmode/osgi/IServiceManager 
.const [63] = Utf8 java/lang/Class 
.const [64] = Utf8 de/audi/atip/log/LogChannel 
.const [65] = Utf8 de/audi/app/terminalmode/osgi/IServiceTracker 
.const [66] = Utf8 java/util/List 
.const [67] = Class [129] 
.const [68] = NameAndType [130] [131] 
.const [69] = Class [132] 
.const [70] = NameAndType [133] [134] 
.const [71] = Class [135] 
.const [72] = NameAndType [136] [137] 
.const [73] = Class [138] 
.const [74] = NameAndType [139] [140] 
.const [75] = Class [141] 
.const [76] = NameAndType [142] [143] 
.const [77] = Class [144] 
.const [78] = NameAndType [145] [146] 
.const [79] = Class [147] 
.const [80] = NameAndType [148] [149] 
.const [81] = Class [150] 
.const [82] = NameAndType [151] [152] 
.const [83] = Class [153] 
.const [84] = NameAndType [154] [155] 
.const [85] = Class [156] 
.const [86] = NameAndType [157] [158] 
.const [87] = Class [159] 
.const [88] = NameAndType [160] [161] 
.const [89] = Class [162] 
.const [90] = NameAndType [163] [164] 
.const [91] = Class [165] 
.const [92] = NameAndType [166] [167] 
.const [93] = Class [168] 
.const [94] = NameAndType [169] [170] 
.const [95] = Class [171] 
.const [96] = NameAndType [172] [173] 
.const [97] = Utf8 java/lang/Object 
.const [98] = Class [174] 
.const [99] = NameAndType [175] [176] 
.const [100] = Class [177] 
.const [101] = NameAndType [178] [179] 
.const [102] = Class [180] 
.const [103] = NameAndType [181] [182] 
.const [104] = Class [183] 
.const [105] = NameAndType [184] [185] 
.const [106] = Class [186] 
.const [107] = NameAndType [187] [188] 
.const [108] = Utf8 java/util/ArrayList 
.const [109] = Class [189] 
.const [110] = NameAndType [190] [191] 
.const [111] = Class [192] 
.const [112] = NameAndType [193] [194] 
.const [113] = Class [195] 
.const [114] = NameAndType [196] [197] 
.const [115] = Utf8 de/audi/app/terminalmode/osgi/AbstractServiceListTracker$PropertyDictonary 
.const [116] = Class [198] 
.const [117] = NameAndType [199] [200] 
.const [118] = Class [201] 
.const [119] = NameAndType [202] [203] 
.const [120] = Class [204] 
.const [121] = NameAndType [205] [206] 
.const [122] = Class [207] 
.const [123] = NameAndType [208] [209] 
.const [124] = Class [210] 
.const [125] = NameAndType [211] [212] 
.const [126] = Utf8 java/util/LinkedList 
.const [127] = Class [213] 
.const [128] = NameAndType [214] [215] 
.const [129] = Utf8 de/audi/app/terminalmode/osgi/AbstractServiceListTracker 
.const [130] = Utf8 mutex 
.const [131] = Utf8 Ljava/lang/Object; 
.const [132] = Utf8 de/audi/app/terminalmode/osgi/AbstractServiceListTracker 
.const [133] = Utf8 logger 
.const [134] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [135] = Utf8 de/audi/app/terminalmode/osgi/AbstractServiceListTracker 
.const [136] = Utf8 serviceManager 
.const [137] = Utf8 Lde/audi/app/terminalmode/osgi/IServiceManager; 
.const [138] = Utf8 de/audi/app/terminalmode/osgi/AbstractServiceListTracker 
.const [139] = Utf8 getTrackedServiceClass 
.const [140] = Utf8 ()Ljava/lang/Class; 
.const [141] = Utf8 de/audi/app/terminalmode/osgi/AbstractServiceListTracker 
.const [142] = Utf8 serviceTracker 
.const [143] = Utf8 Lde/audi/app/terminalmode/osgi/IServiceTracker; 
.const [144] = Utf8 java/lang/Class 
.const [145] = Utf8 getName 
.const [146] = Utf8 ()Ljava/lang/String; 
.const [147] = Utf8 de/audi/atip/log/LogChannel 
.const [148] = Utf8 log 
.const [149] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [150] = Utf8 de/audi/app/terminalmode/osgi/AbstractServiceListTracker 
.const [151] = Utf8 foundServices 
.const [152] = Utf8 Ljava/util/List; 
.const [153] = Utf8 de/audi/app/terminalmode/osgi/AbstractServiceListTracker 
.const [154] = Utf8 checkServiceProperties 
.const [155] = Utf8 (Ljava/util/Dictionary;)Z 
.const [156] = Utf8 de/audi/app/terminalmode/osgi/AbstractServiceListTracker 
.const [157] = Utf8 serviceAdded 
.const [158] = Utf8 (Ljava/lang/Object;)V 
.const [159] = Utf8 de/audi/app/terminalmode/osgi/AbstractServiceListTracker 
.const [160] = Utf8 serviceRemoved 
.const [161] = Utf8 (Ljava/lang/Object;)V 
.const [162] = Utf8 java/lang/Object 
.const [163] = Utf8 <init> 
.const [164] = Utf8 ()V 
.const [165] = Utf8 java/util/ArrayList 
.const [166] = Utf8 <init> 
.const [167] = Utf8 (I)V 
.const [168] = Utf8 de/audi/app/terminalmode/osgi/AbstractServiceListTracker$PropertyDictonary 
.const [169] = Utf8 <init> 
.const [170] = Utf8 (Lde/audi/app/terminalmode/osgi/AbstractServiceListTracker;Lorg/osgi/framework/ServiceReference;)V 
.const [171] = Utf8 java/util/LinkedList 
.const [172] = Utf8 <init> 
.const [173] = Utf8 (Ljava/util/Collection;)V 
.const [174] = Utf8 de/audi/app/terminalmode/osgi/AbstractServiceListTracker 
.const [175] = Utf8 mutex 
.const [176] = Utf8 Ljava/lang/Object; 
.const [177] = Utf8 de/audi/app/terminalmode/osgi/AbstractServiceListTracker 
.const [178] = Utf8 logger 
.const [179] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [180] = Utf8 de/audi/app/terminalmode/osgi/AbstractServiceListTracker 
.const [181] = Utf8 serviceManager 
.const [182] = Utf8 Lde/audi/app/terminalmode/osgi/IServiceManager; 
.const [183] = Utf8 de/audi/app/terminalmode/osgi/IServiceManager 
.const [184] = Utf8 createServiceTracker 
.const [185] = Utf8 (Ljava/lang/Class;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)Lde/audi/app/terminalmode/osgi/IServiceTracker; 
.const [186] = Utf8 de/audi/app/terminalmode/osgi/AbstractServiceListTracker 
.const [187] = Utf8 serviceTracker 
.const [188] = Utf8 Lde/audi/app/terminalmode/osgi/IServiceTracker; 
.const [189] = Utf8 de/audi/app/terminalmode/osgi/AbstractServiceListTracker 
.const [190] = Utf8 foundServices 
.const [191] = Utf8 Ljava/util/List; 
.const [192] = Utf8 de/audi/app/terminalmode/osgi/IServiceTracker 
.const [193] = Utf8 'open' 
.const [194] = Utf8 ()V 
.const [195] = Utf8 de/audi/app/terminalmode/osgi/IServiceTracker 
.const [196] = Utf8 close 
.const [197] = Utf8 ()V 
.const [198] = Utf8 de/audi/app/terminalmode/osgi/IServiceManager 
.const [199] = Utf8 getService 
.const [200] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [201] = Utf8 de/audi/app/terminalmode/osgi/IServiceManager 
.const [202] = Utf8 releaseService 
.const [203] = Utf8 (Lorg/osgi/framework/ServiceReference;)V 
.const [204] = Utf8 java/util/List 
.const [205] = Utf8 size 
.const [206] = Utf8 ()I 
.const [207] = Utf8 java/util/List 
.const [208] = Utf8 addAll 
.const [209] = Utf8 (Ljava/util/Collection;)Z 
.const [210] = Utf8 java/util/List 
.const [211] = Utf8 add 
.const [212] = Utf8 (Ljava/lang/Object;)Z 
.const [213] = Utf8 java/util/List 
.const [214] = Utf8 remove 
.const [215] = Utf8 (Ljava/lang/Object;)Z 
.const [216] = Utf8 de/audi/app/terminalmode/osgi/AbstractServiceListTracker 
.const [217] = Class [216] 
.const [218] = Utf8 java/lang/Object 
.const [219] = Class [218] 
.const [220] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [221] = Class [220] 
.const [222] = Utf8 LOGCLASS 
.const [223] = Utf8 Ljava/lang/String; 
.const [224] = Utf8 mutex 
.const [225] = Utf8 Ljava/lang/Object; 
.const [226] = Utf8 serviceManager 
.const [227] = Utf8 Lde/audi/app/terminalmode/osgi/IServiceManager; 
.const [228] = Utf8 logger 
.const [229] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [230] = Utf8 serviceTracker 
.const [231] = Utf8 Lde/audi/app/terminalmode/osgi/IServiceTracker; 
.const [232] = Utf8 foundServices 
.const [233] = Utf8 Ljava/util/List; 
.const [234] = Utf8 Code 
.const [235] = Utf8 <init> 
.const [236] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/app/terminalmode/osgi/IServiceManager;)V 
.const [237] = Utf8 getTrackedServiceClass 
.const [238] = Utf8 ()Ljava/lang/Class; 
.const [239] = Utf8 serviceAdded 
.const [240] = Utf8 (Ljava/lang/Object;)V 
.const [241] = Utf8 serviceRemoved 
.const [242] = Utf8 (Ljava/lang/Object;)V 
.const [243] = Utf8 checkServiceProperties 
.const [244] = Utf8 (Ljava/util/Dictionary;)Z 
.const [245] = Utf8 init 
.const [246] = Utf8 ()V 
.const [247] = Utf8 deinit 
.const [248] = Utf8 ()V 
.const [249] = Utf8 getServices 
.const [250] = Utf8 ()Ljava/util/List; 
.const [251] = Utf8 addingService 
.const [252] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [253] = Utf8 removedService 
.const [254] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [255] = Utf8 modifiedService 
.const [256] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.end class 
