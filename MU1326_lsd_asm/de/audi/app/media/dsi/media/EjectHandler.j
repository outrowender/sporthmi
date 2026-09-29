.version 50 0 
.class public super [278] 
.super [280] 
.implements [282] 
.implements [284] 
.field private static final [285] [286] 
.field private final [287] [288] 
.field private final [289] [290] 
.field private final [291] [292] 
.field private [293] [294] 
.field private volatile [295] [296] 
.field private volatile [297] [298] 
.field static synthetic [299] [300] 

.method public [302] : [303] 
    .attribute [301] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [51] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [56] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [57] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [58] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [304] : [305] 
    .attribute [301] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     ldc [5] 
L6:     ldc [6] 
L8:     ldc [7] 
L10:    invokevirtual [36] 
L13:    pop 
L14:    aload_0 
L15:    getfield [35] 
L18:    aload_0 
L19:    invokeinterface [59] 0 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [306] : [307] 
    .attribute [301] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     ldc [5] 
L6:     ldc [8] 
L8:     ldc [7] 
L10:    invokevirtual [36] 
L13:    pop 
L14:    aload_0 
L15:    getfield [37] 
L18:    ifnull L39 
L21:    aload_0 
L22:    getfield [34] 
L25:    aload_0 
L26:    getfield [37] 
L29:    invokeinterface [61] 0 
L34:    aload_0 
L35:    aconst_null 
L36:    putfield [60] 
L39:    return 
L40:    
    .end code 
.end method 

.method public [308] : [309] 
    .attribute [301] .code stack 6 locals 7 
L0:     aload_0 
L1:     getfield [33] 
L4:     ldc [5] 
L6:     ldc [9] 
L8:     ldc [7] 
L10:    invokevirtual [36] 
L13:    pop 
L14:    aload_0 
L15:    getfield [38] 
L18:    astore_1 
L19:    aload_0 
L20:    getfield [39] 
L23:    astore_2 
L24:    ldc2_w [68] 
L27:    lstore_3 
L28:    iconst_0 
L29:    istore 5 
L31:    iload 5 
L33:    aload_1 
L34:    arraylength 
L35:    if_icmpge L97 
L38:    aload_1 
L39:    iload 5 
L41:    aaload 
L42:    astore 6 
L44:    aload 6 
L46:    invokevirtual [40] 
L49:    iconst_3 
L50:    if_icmpeq L62 
L53:    aload 6 
L55:    invokevirtual [40] 
L58:    iconst_4 
L59:    if_icmpne L66 
L62:    iconst_1 
L63:    goto L67 
L66:    iconst_0 
L67:    istore 7 
L69:    iload 7 
L71:    ifeq L91 
L74:    aload 6 
L76:    getfield [41] 
L79:    ifle L91 
L82:    aload 6 
L84:    invokevirtual [42] 
L87:    lstore_3 
L88:    goto L97 
L91:    iinc 5 1 
L94:    goto L31 
L97:    lload_3 
L98:    ldc2_w [68] 
L101:   lcmp 
L102:   ifne L120 
L105:   aload_0 
L106:   getfield [33] 
L109:   ldc [10] 
L111:   ldc [11] 
L113:   ldc [7] 
L115:   invokevirtual [36] 
L118:   pop 
L119:   return 
L120:   aload_0 
L121:   getfield [33] 
L124:   ldc [12] 
L126:   ldc [13] 
L128:   ldc [7] 
L130:   lload_3 
L131:   invokevirtual [43] 
L134:   pop 
L135:   aconst_null 
L136:   astore 5 
L138:   iconst_0 
L139:   istore 6 
L141:   iload 6 
L143:   aload_2 
L144:   arraylength 
L145:   if_icmpge L175 
L148:   aload_2 
L149:   iload 6 
L151:   aaload 
L152:   invokevirtual [44] 
L155:   lload_3 
L156:   lcmp 
L157:   ifne L169 
L160:   aload_2 
L161:   iload 6 
L163:   aaload 
L164:   astore 5 
L166:   goto L175 
L169:   iinc 6 1 
L172:   goto L141 
L175:   aload 5 
L177:   ifnonnull L195 
L180:   aload_0 
L181:   getfield [33] 
L184:   ldc [12] 
L186:   ldc [14] 
L188:   ldc [7] 
L190:   invokevirtual [36] 
L193:   pop 
L194:   return 
L195:   aload_0 
L196:   getfield [35] 
L199:   aload 5 
L201:   invokevirtual [44] 
L204:   aload 5 
L206:   invokevirtual [45] 
L209:   invokeinterface [64] 0 
L214:   pop 
L215:   return 
L216:   
    .end code 
.end method 

.method public [310] : [311] 
    .attribute [301] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     ldc [5] 
L6:     ldc [15] 
L8:     ldc [7] 
L10:    invokevirtual [36] 
L13:    pop 
L14:    aload_0 
L15:    aload_1 
L16:    putfield [62] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [312] : [313] 
    .attribute [301] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     ldc [5] 
L6:     ldc [16] 
L8:     ldc [7] 
L10:    invokevirtual [36] 
L13:    pop 
L14:    aload_0 
L15:    aload_1 
L16:    putfield [63] 
L19:    aload_0 
L20:    getfield [37] 
L23:    ifnonnull L83 
L26:    aload_0 
L27:    getfield [33] 
L30:    ldc [5] 
L32:    ldc [17] 
L34:    ldc [7] 
L36:    invokevirtual [36] 
L39:    pop 
L40:    aload_0 
L41:    aload_0 
L42:    getfield [34] 
L45:    getstatic [18] 
L48:    ifnonnull L63 
L51:    ldc [19] 
L53:    invokestatic [20] 
L56:    dup 
L57:    putstatic [52] 
L60:    goto L66 
L63:    getstatic [18] 
L66:    aload_0 
L67:    new [65] 
L70:    dup 
L71:    iconst_0 
L72:    invokespecial [53] 
L75:    invokeinterface [66] 0 
L80:    putfield [60] 
L83:    return 
L84:    
    .end code 
.end method 

.method public [314] : [315] 
    .attribute [301] .code stack 2 locals 1 
L0:     new [67] 
L3:     dup 
L4:     invokespecial [54] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [7] 
L11:    invokevirtual [46] 
L14:    ldc [23] 
L16:    invokevirtual [46] 
L19:    aload_0 
L20:    invokevirtual [47] 
L23:    invokevirtual [48] 
L26:    pop 
L27:    aload_1 
L28:    invokevirtual [49] 
L31:    areturn 
L32:    
    .end code 
.end method 

.method static synthetic [316] : [317] 
    .attribute [301] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [55] 
L9:     dup 
L10:    invokespecial [50] 
L13:    aload_1 
L14:    invokevirtual [32] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [70] [71] 
.const [3] = Class [72] 
.const [4] = Class [73] 
.const [5] = Int 1078071040 
.const [6] = String [74] 
.const [7] = String [75] 
.const [8] = String [76] 
.const [9] = String [77] 
.const [10] = Int -1601830656 
.const [11] = String [78] 
.const [12] = Int -2137614336 
.const [13] = String [79] 
.const [14] = String [80] 
.const [15] = String [81] 
.const [16] = String [82] 
.const [17] = String [83] 
.const [18] = Field [84] [85] 
.const [19] = String [86] 
.const [20] = Method [87] [88] 
.const [21] = Class [89] 
.const [22] = Class [90] 
.const [23] = String [91] 
.const [24] = Class [92] 
.const [25] = Class [93] 
.const [26] = Class [94] 
.const [27] = Class [95] 
.const [28] = Class [96] 
.const [29] = Class [97] 
.const [30] = Class [98] 
.const [31] = Class [99] 
.const [32] = Method [100] [101] 
.const [33] = Field [102] [103] 
.const [34] = Field [104] [105] 
.const [35] = Field [106] [107] 
.const [36] = Method [108] [109] 
.const [37] = Field [110] [111] 
.const [38] = Field [112] [113] 
.const [39] = Field [114] [115] 
.const [40] = Method [116] [117] 
.const [41] = Field [118] [119] 
.const [42] = Method [120] [121] 
.const [43] = Method [122] [123] 
.const [44] = Method [124] [125] 
.const [45] = Method [126] [127] 
.const [46] = Method [128] [129] 
.const [47] = Method [130] [131] 
.const [48] = Method [132] [133] 
.const [49] = Method [134] [135] 
.const [50] = Method [136] [137] 
.const [51] = Method [138] [139] 
.const [52] = Field [140] [141] 
.const [53] = Method [142] [143] 
.const [54] = Method [144] [145] 
.const [55] = Class [146] 
.const [56] = Field [147] [148] 
.const [57] = Field [149] [150] 
.const [58] = Field [151] [152] 
.const [59] = InterfaceMethod [153] [154] 
.const [60] = Field [155] [156] 
.const [61] = InterfaceMethod [157] [158] 
.const [62] = Field [159] [160] 
.const [63] = Field [161] [162] 
.const [64] = InterfaceMethod [163] [164] 
.const [65] = Class [165] 
.const [66] = InterfaceMethod [166] [167] 
.const [67] = Class [168] 
.const [68] = Long -1L 
.const [70] = Class [169] 
.const [71] = NameAndType [170] [171] 
.const [72] = Utf8 java/lang/ClassNotFoundException 
.const [73] = Utf8 java/lang/NoClassDefFoundError 
.const [74] = Utf8 '[%1.init]' 
.const [75] = Utf8 EjectHandler 
.const [76] = Utf8 '[%1.deinit]' 
.const [77] = Utf8 '[%1.ejectCD]' 
.const [78] = Utf8 '[%1.ejectCD] DVD/CD device not found.' 
.const [79] = Utf8 "[%1.ejectCD] Device found (deviceID='%2')" 
.const [80] = Utf8 '[%1.ejectCD] Media slot not found.' 
.const [81] = Utf8 '[%1.updateDeviceList]' 
.const [82] = Utf8 '[%1.updateMediaList]' 
.const [83] = Utf8 '[%1.updateMediaList] Registering as IEjectHandler' 
.const [84] = Class [172] 
.const [85] = NameAndType [173] [174] 
.const [86] = Utf8 'de.audi.atip.interapp.IEjectHandler' 
.const [87] = Class [175] 
.const [88] = NameAndType [176] [177] 
.const [89] = Utf8 java/util/Hashtable 
.const [90] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [91] = Utf8 '@' 
.const [92] = Utf8 de/audi/app/media/dsi/media/EjectHandler 
.const [93] = Utf8 java/lang/Object 
.const [94] = Utf8 java/lang/Class 
.const [95] = Utf8 de/audi/atip/log/LogChannel 
.const [96] = Utf8 de/audi/app/media/dsi/media/IMediaDSIBaseController 
.const [97] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [98] = Utf8 org/dsi/ifc/media/DeviceInfo 
.const [99] = Utf8 org/dsi/ifc/media/MediaInfo 
.const [100] = Class [178] 
.const [101] = NameAndType [179] [180] 
.const [102] = Class [181] 
.const [103] = NameAndType [182] [183] 
.const [104] = Class [184] 
.const [105] = NameAndType [185] [186] 
.const [106] = Class [187] 
.const [107] = NameAndType [188] [189] 
.const [108] = Class [190] 
.const [109] = NameAndType [191] [192] 
.const [110] = Class [193] 
.const [111] = NameAndType [194] [195] 
.const [112] = Class [196] 
.const [113] = NameAndType [197] [198] 
.const [114] = Class [199] 
.const [115] = NameAndType [200] [201] 
.const [116] = Class [202] 
.const [117] = NameAndType [203] [204] 
.const [118] = Class [205] 
.const [119] = NameAndType [206] [207] 
.const [120] = Class [208] 
.const [121] = NameAndType [209] [210] 
.const [122] = Class [211] 
.const [123] = NameAndType [212] [213] 
.const [124] = Class [214] 
.const [125] = NameAndType [215] [216] 
.const [126] = Class [217] 
.const [127] = NameAndType [218] [219] 
.const [128] = Class [220] 
.const [129] = NameAndType [221] [222] 
.const [130] = Class [223] 
.const [131] = NameAndType [224] [225] 
.const [132] = Class [226] 
.const [133] = NameAndType [227] [228] 
.const [134] = Class [229] 
.const [135] = NameAndType [230] [231] 
.const [136] = Class [232] 
.const [137] = NameAndType [233] [234] 
.const [138] = Class [235] 
.const [139] = NameAndType [236] [237] 
.const [140] = Class [238] 
.const [141] = NameAndType [239] [240] 
.const [142] = Class [241] 
.const [143] = NameAndType [242] [243] 
.const [144] = Class [244] 
.const [145] = NameAndType [245] [246] 
.const [146] = Utf8 java/lang/NoClassDefFoundError 
.const [147] = Class [247] 
.const [148] = NameAndType [248] [249] 
.const [149] = Class [250] 
.const [150] = NameAndType [251] [252] 
.const [151] = Class [253] 
.const [152] = NameAndType [254] [255] 
.const [153] = Class [256] 
.const [154] = NameAndType [257] [258] 
.const [155] = Class [259] 
.const [156] = NameAndType [260] [261] 
.const [157] = Class [262] 
.const [158] = NameAndType [263] [264] 
.const [159] = Class [265] 
.const [160] = NameAndType [266] [267] 
.const [161] = Class [268] 
.const [162] = NameAndType [269] [270] 
.const [163] = Class [271] 
.const [164] = NameAndType [272] [273] 
.const [165] = Utf8 java/util/Hashtable 
.const [166] = Class [274] 
.const [167] = NameAndType [275] [276] 
.const [168] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [169] = Utf8 java/lang/Class 
.const [170] = Utf8 forName 
.const [171] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [172] = Utf8 de/audi/app/media/dsi/media/EjectHandler 
.const [173] = Utf8 class$de$audi$atip$interapp$IEjectHandler 
.const [174] = Utf8 Ljava/lang/Class; 
.const [175] = Utf8 de/audi/app/media/dsi/media/EjectHandler 
.const [176] = Utf8 class$ 
.const [177] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [178] = Utf8 java/lang/NoClassDefFoundError 
.const [179] = Utf8 initCause 
.const [180] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [181] = Utf8 de/audi/app/media/dsi/media/EjectHandler 
.const [182] = Utf8 logger 
.const [183] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [184] = Utf8 de/audi/app/media/dsi/media/EjectHandler 
.const [185] = Utf8 serviceManager 
.const [186] = Utf8 Lde/audi/app/media/osgi/IServiceManager; 
.const [187] = Utf8 de/audi/app/media/dsi/media/EjectHandler 
.const [188] = Utf8 dsiBaseController 
.const [189] = Utf8 Lde/audi/app/media/dsi/media/IMediaDSIBaseController; 
.const [190] = Utf8 de/audi/atip/log/LogChannel 
.const [191] = Utf8 log 
.const [192] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [193] = Utf8 de/audi/app/media/dsi/media/EjectHandler 
.const [194] = Utf8 serviceRegistration 
.const [195] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [196] = Utf8 de/audi/app/media/dsi/media/EjectHandler 
.const [197] = Utf8 deviceList 
.const [198] = Utf8 [Lorg/dsi/ifc/media/DeviceInfo; 
.const [199] = Utf8 de/audi/app/media/dsi/media/EjectHandler 
.const [200] = Utf8 mediaList 
.const [201] = Utf8 [Lorg/dsi/ifc/media/MediaInfo; 
.const [202] = Utf8 org/dsi/ifc/media/DeviceInfo 
.const [203] = Utf8 getDeviceType 
.const [204] = Utf8 ()I 
.const [205] = Utf8 org/dsi/ifc/media/DeviceInfo 
.const [206] = Utf8 numSlots 
.const [207] = Utf8 I 
.const [208] = Utf8 org/dsi/ifc/media/DeviceInfo 
.const [209] = Utf8 getDeviceID 
.const [210] = Utf8 ()J 
.const [211] = Utf8 de/audi/atip/log/LogChannel 
.const [212] = Utf8 log 
.const [213] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [214] = Utf8 org/dsi/ifc/media/MediaInfo 
.const [215] = Utf8 getDeviceID 
.const [216] = Utf8 ()J 
.const [217] = Utf8 org/dsi/ifc/media/MediaInfo 
.const [218] = Utf8 getMediaID 
.const [219] = Utf8 ()J 
.const [220] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [221] = Utf8 append 
.const [222] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [223] = Utf8 java/lang/Object 
.const [224] = Utf8 hashCode 
.const [225] = Utf8 ()I 
.const [226] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [227] = Utf8 append 
.const [228] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [229] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [230] = Utf8 toString 
.const [231] = Utf8 ()Ljava/lang/String; 
.const [232] = Utf8 java/lang/NoClassDefFoundError 
.const [233] = Utf8 <init> 
.const [234] = Utf8 ()V 
.const [235] = Utf8 java/lang/Object 
.const [236] = Utf8 <init> 
.const [237] = Utf8 ()V 
.const [238] = Utf8 de/audi/app/media/dsi/media/EjectHandler 
.const [239] = Utf8 class$de$audi$atip$interapp$IEjectHandler 
.const [240] = Utf8 Ljava/lang/Class; 
.const [241] = Utf8 java/util/Hashtable 
.const [242] = Utf8 <init> 
.const [243] = Utf8 (I)V 
.const [244] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [245] = Utf8 <init> 
.const [246] = Utf8 ()V 
.const [247] = Utf8 de/audi/app/media/dsi/media/EjectHandler 
.const [248] = Utf8 logger 
.const [249] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [250] = Utf8 de/audi/app/media/dsi/media/EjectHandler 
.const [251] = Utf8 serviceManager 
.const [252] = Utf8 Lde/audi/app/media/osgi/IServiceManager; 
.const [253] = Utf8 de/audi/app/media/dsi/media/EjectHandler 
.const [254] = Utf8 dsiBaseController 
.const [255] = Utf8 Lde/audi/app/media/dsi/media/IMediaDSIBaseController; 
.const [256] = Utf8 de/audi/app/media/dsi/media/IMediaDSIBaseController 
.const [257] = Utf8 addMediaDeviceListener 
.const [258] = Utf8 (Lde/audi/app/media/dsi/media/IMediaDeviceListener;)V 
.const [259] = Utf8 de/audi/app/media/dsi/media/EjectHandler 
.const [260] = Utf8 serviceRegistration 
.const [261] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [262] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [263] = Utf8 unregisterService 
.const [264] = Utf8 (Lorg/osgi/framework/ServiceRegistration;)V 
.const [265] = Utf8 de/audi/app/media/dsi/media/EjectHandler 
.const [266] = Utf8 deviceList 
.const [267] = Utf8 [Lorg/dsi/ifc/media/DeviceInfo; 
.const [268] = Utf8 de/audi/app/media/dsi/media/EjectHandler 
.const [269] = Utf8 mediaList 
.const [270] = Utf8 [Lorg/dsi/ifc/media/MediaInfo; 
.const [271] = Utf8 de/audi/app/media/dsi/media/IMediaDSIBaseController 
.const [272] = Utf8 eject 
.const [273] = Utf8 (JJ)Z 
.const [274] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [275] = Utf8 registerService 
.const [276] = Utf8 (Ljava/lang/Class;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [277] = Utf8 de/audi/app/media/dsi/media/EjectHandler 
.const [278] = Class [277] 
.const [279] = Utf8 java/lang/Object 
.const [280] = Class [279] 
.const [281] = Utf8 de/audi/atip/interapp/IEjectHandler 
.const [282] = Class [281] 
.const [283] = Utf8 de/audi/app/media/dsi/media/IMediaDeviceListener 
.const [284] = Class [283] 
.const [285] = Utf8 LOGCLASS 
.const [286] = Utf8 Ljava/lang/String; 
.const [287] = Utf8 logger 
.const [288] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [289] = Utf8 serviceManager 
.const [290] = Utf8 Lde/audi/app/media/osgi/IServiceManager; 
.const [291] = Utf8 dsiBaseController 
.const [292] = Utf8 Lde/audi/app/media/dsi/media/IMediaDSIBaseController; 
.const [293] = Utf8 serviceRegistration 
.const [294] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [295] = Utf8 mediaList 
.const [296] = Utf8 [Lorg/dsi/ifc/media/MediaInfo; 
.const [297] = Utf8 deviceList 
.const [298] = Utf8 [Lorg/dsi/ifc/media/DeviceInfo; 
.const [299] = Utf8 class$de$audi$atip$interapp$IEjectHandler 
.const [300] = Utf8 Ljava/lang/Class; 
.const [301] = Utf8 Code 
.const [302] = Utf8 <init> 
.const [303] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/app/media/osgi/IServiceManager;Lde/audi/app/media/dsi/media/IMediaDSIBaseController;)V 
.const [304] = Utf8 init 
.const [305] = Utf8 ()V 
.const [306] = Utf8 deinit 
.const [307] = Utf8 ()V 
.const [308] = Utf8 ejectCD 
.const [309] = Utf8 ()V 
.const [310] = Utf8 updateDeviceList 
.const [311] = Utf8 ([Lorg/dsi/ifc/media/DeviceInfo;)V 
.const [312] = Utf8 updateMediaList 
.const [313] = Utf8 ([Lorg/dsi/ifc/media/MediaInfo;)V 
.const [314] = Utf8 toString 
.const [315] = Utf8 ()Ljava/lang/String; 
.const [316] = Utf8 class$ 
.const [317] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
