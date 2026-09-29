.version 50 0 
.class public super abstract [260] 
.super [262] 
.implements [264] 
.implements [266] 
.field protected final [267] [268] 
.field protected final [269] [270] 
.field private volatile [271] [272] 
.field static synthetic [273] [274] 

.method public [276] : [277] 
    .attribute [275] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [46] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [52] 
L9:     aload_0 
L10:    aload_1 
L11:    invokeinterface [53] 0 
L16:    invokeinterface [54] 0 
L21:    putfield [55] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [278] : [279] 
    .attribute [275] .code stack 5 locals 1 
L0:     new [56] 
L3:     dup 
L4:     iconst_3 
L5:     invokespecial [47] 
L8:     astore_1 
L9:     aload_1 
L10:    ldc [6] 
L12:    new [57] 
L15:    dup 
L16:    aload_0 
L17:    invokevirtual [39] 
L20:    invokespecial [48] 
L23:    invokevirtual [40] 
L26:    pop 
L27:    aload_1 
L28:    ldc [8] 
L30:    ldc [9] 
L32:    invokevirtual [40] 
L35:    pop 
L36:    aload_0 
L37:    aload_0 
L38:    getfield [37] 
L41:    invokeinterface [58] 0 
L46:    getstatic [10] 
L49:    ifnonnull L64 
L52:    ldc [11] 
L54:    invokestatic [12] 
L57:    dup 
L58:    putstatic [49] 
L61:    goto L67 
L64:    getstatic [10] 
L67:    aload_0 
L68:    aload_1 
L69:    invokeinterface [59] 0 
L74:    putfield [60] 
L77:    return 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public [280] : [281] 
    .attribute [275] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [41] 
L4:     ifnull L25 
L7:     aload_0 
L8:     getfield [37] 
L11:    invokeinterface [58] 0 
L16:    aload_0 
L17:    getfield [41] 
L20:    invokeinterface [61] 0 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [282] : [283] 
    .attribute [275] .code stack 2 locals 1 
L0:     iload_1 
L1:     lookupswitch 
            0 : L126 
            1 : L76 
            14 : L176 
            34 : L226 
            35 : L267 
            44 : L201 
            52 : L151 
            53 : L101 
            default : L308 

L76:    aload_0 
L77:    getfield [37] 
L80:    invokeinterface [62] 0 
L85:    invokeinterface [63] 0 
L90:    ldc [13] 
L92:    invokeinterface [64] 0 
L97:    astore_2 
L98:    goto L310 
L101:   aload_0 
L102:   getfield [37] 
L105:   invokeinterface [62] 0 
L110:   invokeinterface [63] 0 
L115:   ldc [14] 
L117:   invokeinterface [64] 0 
L122:   astore_2 
L123:   goto L310 
L126:   aload_0 
L127:   getfield [37] 
L130:   invokeinterface [62] 0 
L135:   invokeinterface [63] 0 
L140:   ldc [15] 
L142:   invokeinterface [64] 0 
L147:   astore_2 
L148:   goto L310 
L151:   aload_0 
L152:   getfield [37] 
L155:   invokeinterface [62] 0 
L160:   invokeinterface [63] 0 
L165:   ldc [16] 
L167:   invokeinterface [64] 0 
L172:   astore_2 
L173:   goto L310 
L176:   aload_0 
L177:   getfield [37] 
L180:   invokeinterface [62] 0 
L185:   invokeinterface [63] 0 
L190:   ldc [17] 
L192:   invokeinterface [64] 0 
L197:   astore_2 
L198:   goto L310 
L201:   aload_0 
L202:   getfield [37] 
L205:   invokeinterface [62] 0 
L210:   invokeinterface [63] 0 
L215:   ldc [18] 
L217:   invokeinterface [64] 0 
L222:   astore_2 
L223:   goto L310 
L226:   aload_0 
L227:   getfield [37] 
L230:   invokeinterface [62] 0 
L235:   sipush 460 
L238:   invokeinterface [65] 0 
L243:   iconst_1 
L244:   if_icmpne L252 
L247:   aconst_null 
L248:   astore_2 
L249:   goto L310 
L252:   aload_0 
L253:   getfield [37] 
L256:   ldc [19] 
L258:   invokeinterface [66] 0 
L263:   astore_2 
L264:   goto L310 
L267:   aload_0 
L268:   getfield [37] 
L271:   invokeinterface [62] 0 
L276:   sipush 460 
L279:   invokeinterface [65] 0 
L284:   iconst_1 
L285:   if_icmpne L293 
L288:   aconst_null 
L289:   astore_2 
L290:   goto L310 
L293:   aload_0 
L294:   getfield [37] 
L297:   ldc [20] 
L299:   invokeinterface [66] 0 
L304:   astore_2 
L305:   goto L310 
L308:   aconst_null 
L309:   astore_2 
L310:   aload_2 
L311:   areturn 
L312:   
    .end code 
.end method 

.method public [284] : [285] 
    .attribute [275] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [21] 
L6:     ldc [22] 
L8:     aload_0 
L9:     invokevirtual [42] 
L12:    iload_1 
L13:    i2l 
L14:    invokevirtual [43] 
L17:    pop 
L18:    iload_1 
L19:    aload_0 
L20:    invokevirtual [44] 
L23:    if_icmpne L51 
L26:    aload_0 
L27:    getfield [37] 
L30:    invokeinterface [67] 0 
L35:    sipush 1001 
L38:    iload_2 
L39:    new [56] 
L42:    dup 
L43:    invokespecial [50] 
L46:    invokeinterface [68] 0 
L51:    return 
L52:    
    .end code 
.end method 

.method public [286] : [287] 
    .attribute [275] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [21] 
L6:     ldc [23] 
L8:     aload_0 
L9:     invokevirtual [42] 
L12:    iload_1 
L13:    i2l 
L14:    invokevirtual [43] 
L17:    pop 
L18:    iload_1 
L19:    aload_0 
L20:    invokevirtual [44] 
L23:    if_icmpne L51 
L26:    aload_0 
L27:    getfield [37] 
L30:    invokeinterface [67] 0 
L35:    sipush 1002 
L38:    iload_2 
L39:    new [56] 
L42:    dup 
L43:    invokespecial [50] 
L46:    invokeinterface [68] 0 
L51:    return 
L52:    
    .end code 
.end method 

.method public enum [288] : [289] 
    .attribute [275] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [290] : [291] 
    .attribute [275] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [292] : [293] 
    .attribute [275] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [294] : [295] 
    .attribute [275] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [21] 
L6:     ldc [24] 
L8:     aload_0 
L9:     invokevirtual [42] 
L12:    iload_1 
L13:    i2l 
L14:    invokevirtual [43] 
L17:    pop 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [296] : [297] 
    .attribute [275] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [21] 
L6:     ldc [25] 
L8:     aload_0 
L9:     invokevirtual [42] 
L12:    iload_1 
L13:    i2l 
L14:    invokevirtual [43] 
L17:    pop 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected abstract [298] : [299] 
    .attribute [275] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [300] : [301] 
    .attribute [275] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method static synthetic [302] : [303] 
    .attribute [275] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [51] 
L9:     dup 
L10:    invokespecial [45] 
L13:    aload_1 
L14:    invokevirtual [36] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [69] [70] 
.const [3] = Class [71] 
.const [4] = Class [72] 
.const [5] = Class [73] 
.const [6] = String [74] 
.const [7] = Class [75] 
.const [8] = String [76] 
.const [9] = String [77] 
.const [10] = Field [78] [79] 
.const [11] = String [80] 
.const [12] = Method [81] [82] 
.const [13] = Int 533999616 
.const [14] = Int 886321152 
.const [15] = Int 668217344 
.const [16] = Int 869543936 
.const [17] = Int 802435072 
.const [18] = Int 819212288 
.const [19] = Int 1087647744 
.const [20] = Int 1070870528 
.const [21] = Int 1078071040 
.const [22] = String [83] 
.const [23] = String [84] 
.const [24] = String [85] 
.const [25] = String [86] 
.const [26] = Class [87] 
.const [27] = Class [88] 
.const [28] = Class [89] 
.const [29] = Class [90] 
.const [30] = Class [91] 
.const [31] = Class [92] 
.const [32] = Class [93] 
.const [33] = Class [94] 
.const [34] = Class [95] 
.const [35] = Class [96] 
.const [36] = Method [97] [98] 
.const [37] = Field [99] [100] 
.const [38] = Field [101] [102] 
.const [39] = Method [103] [104] 
.const [40] = Method [105] [106] 
.const [41] = Field [107] [108] 
.const [42] = Method [109] [110] 
.const [43] = Method [111] [112] 
.const [44] = Method [113] [114] 
.const [45] = Method [115] [116] 
.const [46] = Method [117] [118] 
.const [47] = Method [119] [120] 
.const [48] = Method [121] [122] 
.const [49] = Field [123] [124] 
.const [50] = Method [125] [126] 
.const [51] = Class [127] 
.const [52] = Field [128] [129] 
.const [53] = InterfaceMethod [130] [131] 
.const [54] = InterfaceMethod [132] [133] 
.const [55] = Field [134] [135] 
.const [56] = Class [136] 
.const [57] = Class [137] 
.const [58] = InterfaceMethod [138] [139] 
.const [59] = InterfaceMethod [140] [141] 
.const [60] = Field [142] [143] 
.const [61] = InterfaceMethod [144] [145] 
.const [62] = InterfaceMethod [146] [147] 
.const [63] = InterfaceMethod [148] [149] 
.const [64] = InterfaceMethod [150] [151] 
.const [65] = InterfaceMethod [152] [153] 
.const [66] = InterfaceMethod [154] [155] 
.const [67] = InterfaceMethod [156] [157] 
.const [68] = InterfaceMethod [158] [159] 
.const [69] = Class [160] 
.const [70] = NameAndType [161] [162] 
.const [71] = Utf8 java/lang/ClassNotFoundException 
.const [72] = Utf8 java/lang/NoClassDefFoundError 
.const [73] = Utf8 java/util/Hashtable 
.const [74] = Utf8 moduleID 
.const [75] = Utf8 java/lang/Integer 
.const [76] = Utf8 ApplicationName 
.const [77] = Utf8 TerminalMode 
.const [78] = Class [163] 
.const [79] = NameAndType [164] [165] 
.const [80] = Utf8 'de.audi.atip.hmi.HMIApplication' 
.const [81] = Class [166] 
.const [82] = NameAndType [167] [168] 
.const [83] = Utf8 '<<- [%1.screenVisible] %2' 
.const [84] = Utf8 '<<- [%1.screenHidden] %2' 
.const [85] = Utf8 '<<- [%1.screenFadedOut] %2' 
.const [86] = Utf8 '<<- [%1.screenConnected] %2' 
.const [87] = Utf8 de/audi/app/terminalmode/AbstractTerminalModeHMIApplication 
.const [88] = Utf8 java/lang/Object 
.const [89] = Utf8 java/lang/Class 
.const [90] = Utf8 de/audi/app/terminalmode/IContext 
.const [91] = Utf8 de/audi/app/terminalmode/ITerminalLogger 
.const [92] = Utf8 de/audi/app/terminalmode/osgi/IServiceManager 
.const [93] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [94] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [95] = Utf8 de/audi/atip/log/LogChannel 
.const [96] = Utf8 de/audi/app/terminalmode/actionproxy/IActionProxyDispatcher 
.const [97] = Class [169] 
.const [98] = NameAndType [170] [171] 
.const [99] = Class [172] 
.const [100] = NameAndType [173] [174] 
.const [101] = Class [175] 
.const [102] = NameAndType [176] [177] 
.const [103] = Class [178] 
.const [104] = NameAndType [179] [180] 
.const [105] = Class [181] 
.const [106] = NameAndType [182] [183] 
.const [107] = Class [184] 
.const [108] = NameAndType [185] [186] 
.const [109] = Class [187] 
.const [110] = NameAndType [188] [189] 
.const [111] = Class [190] 
.const [112] = NameAndType [191] [192] 
.const [113] = Class [193] 
.const [114] = NameAndType [194] [195] 
.const [115] = Class [196] 
.const [116] = NameAndType [197] [198] 
.const [117] = Class [199] 
.const [118] = NameAndType [200] [201] 
.const [119] = Class [202] 
.const [120] = NameAndType [203] [204] 
.const [121] = Class [205] 
.const [122] = NameAndType [206] [207] 
.const [123] = Class [208] 
.const [124] = NameAndType [209] [210] 
.const [125] = Class [211] 
.const [126] = NameAndType [212] [213] 
.const [127] = Utf8 java/lang/NoClassDefFoundError 
.const [128] = Class [214] 
.const [129] = NameAndType [215] [216] 
.const [130] = Class [217] 
.const [131] = NameAndType [218] [219] 
.const [132] = Class [220] 
.const [133] = NameAndType [221] [222] 
.const [134] = Class [223] 
.const [135] = NameAndType [224] [225] 
.const [136] = Utf8 java/util/Hashtable 
.const [137] = Utf8 java/lang/Integer 
.const [138] = Class [226] 
.const [139] = NameAndType [227] [228] 
.const [140] = Class [229] 
.const [141] = NameAndType [230] [231] 
.const [142] = Class [232] 
.const [143] = NameAndType [233] [234] 
.const [144] = Class [235] 
.const [145] = NameAndType [236] [237] 
.const [146] = Class [238] 
.const [147] = NameAndType [239] [240] 
.const [148] = Class [241] 
.const [149] = NameAndType [242] [243] 
.const [150] = Class [244] 
.const [151] = NameAndType [245] [246] 
.const [152] = Class [247] 
.const [153] = NameAndType [248] [249] 
.const [154] = Class [250] 
.const [155] = NameAndType [251] [252] 
.const [156] = Class [253] 
.const [157] = NameAndType [254] [255] 
.const [158] = Class [256] 
.const [159] = NameAndType [257] [258] 
.const [160] = Utf8 java/lang/Class 
.const [161] = Utf8 forName 
.const [162] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [163] = Utf8 de/audi/app/terminalmode/AbstractTerminalModeHMIApplication 
.const [164] = Utf8 class$de$audi$atip$hmi$HMIApplication 
.const [165] = Utf8 Ljava/lang/Class; 
.const [166] = Utf8 de/audi/app/terminalmode/AbstractTerminalModeHMIApplication 
.const [167] = Utf8 class$ 
.const [168] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [169] = Utf8 java/lang/NoClassDefFoundError 
.const [170] = Utf8 initCause 
.const [171] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [172] = Utf8 de/audi/app/terminalmode/AbstractTerminalModeHMIApplication 
.const [173] = Utf8 context 
.const [174] = Utf8 Lde/audi/app/terminalmode/IContext; 
.const [175] = Utf8 de/audi/app/terminalmode/AbstractTerminalModeHMIApplication 
.const [176] = Utf8 logger 
.const [177] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [178] = Utf8 de/audi/app/terminalmode/AbstractTerminalModeHMIApplication 
.const [179] = Utf8 getId 
.const [180] = Utf8 ()I 
.const [181] = Utf8 java/util/Hashtable 
.const [182] = Utf8 put 
.const [183] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [184] = Utf8 de/audi/app/terminalmode/AbstractTerminalModeHMIApplication 
.const [185] = Utf8 registration 
.const [186] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [187] = Utf8 de/audi/app/terminalmode/AbstractTerminalModeHMIApplication 
.const [188] = Utf8 getLogClass 
.const [189] = Utf8 ()Ljava/lang/String; 
.const [190] = Utf8 de/audi/atip/log/LogChannel 
.const [191] = Utf8 log 
.const [192] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [193] = Utf8 de/audi/app/terminalmode/AbstractTerminalModeHMIApplication 
.const [194] = Utf8 getTerminalModeScreenId 
.const [195] = Utf8 ()I 
.const [196] = Utf8 java/lang/NoClassDefFoundError 
.const [197] = Utf8 <init> 
.const [198] = Utf8 ()V 
.const [199] = Utf8 java/lang/Object 
.const [200] = Utf8 <init> 
.const [201] = Utf8 ()V 
.const [202] = Utf8 java/util/Hashtable 
.const [203] = Utf8 <init> 
.const [204] = Utf8 (I)V 
.const [205] = Utf8 java/lang/Integer 
.const [206] = Utf8 <init> 
.const [207] = Utf8 (I)V 
.const [208] = Utf8 de/audi/app/terminalmode/AbstractTerminalModeHMIApplication 
.const [209] = Utf8 class$de$audi$atip$hmi$HMIApplication 
.const [210] = Utf8 Ljava/lang/Class; 
.const [211] = Utf8 java/util/Hashtable 
.const [212] = Utf8 <init> 
.const [213] = Utf8 ()V 
.const [214] = Utf8 de/audi/app/terminalmode/AbstractTerminalModeHMIApplication 
.const [215] = Utf8 context 
.const [216] = Utf8 Lde/audi/app/terminalmode/IContext; 
.const [217] = Utf8 de/audi/app/terminalmode/IContext 
.const [218] = Utf8 getLogger 
.const [219] = Utf8 ()Lde/audi/app/terminalmode/ITerminalLogger; 
.const [220] = Utf8 de/audi/app/terminalmode/ITerminalLogger 
.const [221] = Utf8 main 
.const [222] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [223] = Utf8 de/audi/app/terminalmode/AbstractTerminalModeHMIApplication 
.const [224] = Utf8 logger 
.const [225] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [226] = Utf8 de/audi/app/terminalmode/IContext 
.const [227] = Utf8 getServiceManager 
.const [228] = Utf8 ()Lde/audi/app/terminalmode/osgi/IServiceManager; 
.const [229] = Utf8 de/audi/app/terminalmode/osgi/IServiceManager 
.const [230] = Utf8 registerService 
.const [231] = Utf8 (Ljava/lang/Class;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [232] = Utf8 de/audi/app/terminalmode/AbstractTerminalModeHMIApplication 
.const [233] = Utf8 registration 
.const [234] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [235] = Utf8 de/audi/app/terminalmode/osgi/IServiceManager 
.const [236] = Utf8 unregisterService 
.const [237] = Utf8 (Lorg/osgi/framework/ServiceRegistration;)V 
.const [238] = Utf8 de/audi/app/terminalmode/IContext 
.const [239] = Utf8 getFramework 
.const [240] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [241] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [242] = Utf8 getHmiServiceApp 
.const [243] = Utf8 ()Lde/audi/atip/hmi/IHMIServiceApp; 
.const [244] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [245] = Utf8 getButtonModel 
.const [246] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ButtonModelApp; 
.const [247] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [248] = Utf8 getSysConst 
.const [249] = Utf8 (I)I 
.const [250] = Utf8 de/audi/app/terminalmode/IContext 
.const [251] = Utf8 getButtonModel 
.const [252] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ButtonModelApp; 
.const [253] = Utf8 de/audi/app/terminalmode/IContext 
.const [254] = Utf8 getActionProxyDispatcher 
.const [255] = Utf8 ()Lde/audi/app/terminalmode/actionproxy/IActionProxyDispatcher; 
.const [256] = Utf8 de/audi/app/terminalmode/actionproxy/IActionProxyDispatcher 
.const [257] = Utf8 notifyActionProxyCall 
.const [258] = Utf8 (IILjava/util/Map;)V 
.const [259] = Utf8 de/audi/app/terminalmode/AbstractTerminalModeHMIApplication 
.const [260] = Class [259] 
.const [261] = Utf8 java/lang/Object 
.const [262] = Class [261] 
.const [263] = Utf8 de/audi/atip/hmi/HMIApplication 
.const [264] = Class [263] 
.const [265] = Utf8 de/audi/app/terminalmode/ITerminalModeComponent 
.const [266] = Class [265] 
.const [267] = Utf8 logger 
.const [268] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [269] = Utf8 context 
.const [270] = Utf8 Lde/audi/app/terminalmode/IContext; 
.const [271] = Utf8 registration 
.const [272] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [273] = Utf8 class$de$audi$atip$hmi$HMIApplication 
.const [274] = Utf8 Ljava/lang/Class; 
.const [275] = Utf8 Code 
.const [276] = Utf8 <init> 
.const [277] = Utf8 (Lde/audi/app/terminalmode/IContext;)V 
.const [278] = Utf8 init 
.const [279] = Utf8 ()V 
.const [280] = Utf8 deinit 
.const [281] = Utf8 ()V 
.const [282] = Utf8 getVirtualButton 
.const [283] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ButtonModelApp; 
.const [284] = Utf8 screenVisible 
.const [285] = Utf8 (II)V 
.const [286] = Utf8 screenHidden 
.const [287] = Utf8 (II)V 
.const [288] = Utf8 popupVisible 
.const [289] = Utf8 (II)V 
.const [290] = Utf8 popupHidden 
.const [291] = Utf8 (II)V 
.const [292] = Utf8 popupRemoved 
.const [293] = Utf8 (II)V 
.const [294] = Utf8 screenFadedOut 
.const [295] = Utf8 (II)V 
.const [296] = Utf8 screenConnected 
.const [297] = Utf8 (II)V 
.const [298] = Utf8 getLogClass 
.const [299] = Utf8 ()Ljava/lang/String; 
.const [300] = Utf8 getTerminalModeScreenId 
.const [301] = Utf8 ()I 
.const [302] = Utf8 class$ 
.const [303] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
