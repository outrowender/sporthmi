.version 50 0 
.class super [253] 
.super [255] 
.implements [257] 
.field private final [258] [259] 
.field private final [260] [261] 
.field private static final [262] [263] 
.field private final [264] [265] 
.field private volatile [266] [267] 
.field private [268] [269] 
.field private final synthetic [270] [271] 

.method public [273] : [274] 
    .attribute [272] .code stack 8 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [46] 
L5:     aload_0 
L6:     invokespecial [40] 
L9:     aload_0 
L10:    new [47] 
L13:    dup 
L14:    invokespecial [41] 
L17:    putfield [48] 
L20:    aload_0 
L21:    iconst_0 
L22:    putfield [49] 
L25:    aload_0 
L26:    iconst_1 
L27:    putfield [50] 
L30:    aload_0 
L31:    aload_2 
L32:    putfield [51] 
L35:    aload_0 
L36:    new [52] 
L39:    dup 
L40:    ldc [4] 
L42:    ldc_w [1] 
L45:    iconst_1 
L46:    aload_0 
L47:    invokespecial [42] 
L50:    putfield [53] 
L53:    return 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [275] : [276] 
    .attribute [272] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     invokevirtual [28] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [277] : [278] 
    .attribute [272] .code stack 6 locals 2 
L0:     aload_0 
L1:     getfield [23] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L60 using L63 
L7:     aload_0 
L8:     getfield [24] 
L11:    ifne L58 
L14:    aload_0 
L15:    getfield [29] 
L18:    ldc [5] 
L20:    ldc [6] 
L22:    aload_0 
L23:    getfield [30] 
L26:    ldc_w [1] 
L29:    invokevirtual [31] 
L32:    pop 
L33:    aload_0 
L34:    invokespecial [43] 
L37:    aload_0 
L38:    invokevirtual [32] 
L41:    new [54] 
L44:    dup 
L45:    aload_0 
L46:    aload_0 
L47:    getfield [26] 
L50:    invokespecial [44] 
L53:    invokeinterface [55] 0 
L58:    aload_2 
L59:    monitorexit 
L60:    goto L68 
        .catch [0] from L63 to L66 using L63 
L63:    astore_3 
L64:    aload_2 
L65:    monitorexit 
L66:    aload_3 
L67:    athrow 
L68:    return 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [279] : [280] 
    .attribute [272] .code stack 9 locals 6 
L0:     aload_0 
L1:     getfield [23] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L154 using L157 
L7:     aload_0 
L8:     getfield [25] 
L11:    ifeq L152 
L14:    aload_0 
L15:    iconst_1 
L16:    putfield [49] 
L19:    aload_0 
L20:    invokespecial [43] 
L23:    aload_0 
L24:    getfield [29] 
L27:    ldc [5] 
L29:    ldc [8] 
L31:    aload_0 
L32:    getfield [30] 
L35:    aload_1 
L36:    invokevirtual [33] 
L39:    aload_0 
L40:    getfield [27] 
L43:    invokevirtual [34] 
L46:    pop 
L47:    iconst_0 
L48:    istore_3 
L49:    aload_1 
L50:    ifnull L71 
L53:    aload_1 
L54:    invokestatic [9] 
L57:    istore 4 
L59:    iload 4 
L61:    iconst_m1 
L62:    if_icmpeq L71 
L65:    iload 4 
L67:    invokestatic [10] 
L70:    istore_3 
L71:    iload_3 
L72:    istore 4 
L74:    aload_0 
L75:    getfield [22] 
L78:    invokestatic [11] 
L81:    invokevirtual [35] 
L84:    istore 5 
L86:    iload 4 
L88:    ifeq L97 
L91:    iload 5 
L93:    iconst_m1 
L94:    if_icmpne L101 
L97:    iconst_3 
L98:    goto L102 
L101:   iconst_0 
L102:   istore 6 
L104:   aload_0 
L105:   getfield [29] 
L108:   ldc [5] 
L110:   ldc [12] 
L112:   iload 6 
L114:   i2l 
L115:   iload 4 
L117:   i2l 
L118:   iload 5 
L120:   i2l 
L121:   invokevirtual [36] 
L124:   pop 
L125:   aload_0 
L126:   invokevirtual [32] 
L129:   new [56] 
L132:   dup 
L133:   aload_0 
L134:   aload_0 
L135:   getfield [26] 
L138:   iload 6 
L140:   iload 4 
L142:   iload 5 
L144:   invokespecial [45] 
L147:   invokeinterface [55] 0 
L152:   aload_2 
L153:   monitorexit 
L154:   goto L164 
        .catch [0] from L157 to L161 using L157 
L157:   astore 7 
L159:   aload_2 
L160:   monitorexit 
L161:   aload 7 
L163:   athrow 
L164:   return 
L165:   nop 
L166:   nop 
L167:   nop 
L168:   
    .end code 
.end method 

.method private [281] : [282] 
    .attribute [272] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     invokestatic [11] 
L7:     aconst_null 
L8:     invokevirtual [37] 
L11:    aload_0 
L12:    iconst_0 
L13:    putfield [50] 
L16:    aload_0 
L17:    getfield [38] 
L20:    invokestatic [14] 
L23:    ifne L37 
L26:    aload_0 
L27:    getfield [22] 
L30:    invokestatic [11] 
L33:    iconst_0 
L34:    invokevirtual [39] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [58] 
.const [3] = Class [59] 
.const [4] = String [60] 
.const [5] = Int -2137614336 
.const [6] = String [61] 
.const [7] = Class [62] 
.const [8] = String [63] 
.const [9] = Method [64] [65] 
.const [10] = Method [66] [67] 
.const [11] = Method [68] [69] 
.const [12] = String [70] 
.const [13] = Class [71] 
.const [14] = Method [72] [73] 
.const [15] = Class [74] 
.const [16] = Class [75] 
.const [17] = Class [76] 
.const [18] = Class [77] 
.const [19] = Class [78] 
.const [20] = Class [79] 
.const [21] = Class [80] 
.const [22] = Field [81] [82] 
.const [23] = Field [83] [84] 
.const [24] = Field [85] [86] 
.const [25] = Field [87] [88] 
.const [26] = Field [89] [90] 
.const [27] = Field [91] [92] 
.const [28] = Method [93] [94] 
.const [29] = Field [95] [96] 
.const [30] = Field [97] [98] 
.const [31] = Method [99] [100] 
.const [32] = Method [101] [102] 
.const [33] = Method [103] [104] 
.const [34] = Method [105] [106] 
.const [35] = Method [107] [108] 
.const [36] = Method [109] [110] 
.const [37] = Method [111] [112] 
.const [38] = Field [113] [114] 
.const [39] = Method [115] [116] 
.const [40] = Method [117] [118] 
.const [41] = Method [119] [120] 
.const [42] = Method [121] [122] 
.const [43] = Method [123] [124] 
.const [44] = Method [125] [126] 
.const [45] = Method [127] [128] 
.const [46] = Field [129] [130] 
.const [47] = Class [131] 
.const [48] = Field [132] [133] 
.const [49] = Field [134] [135] 
.const [50] = Field [136] [137] 
.const [51] = Field [138] [139] 
.const [52] = Class [140] 
.const [53] = Field [141] [142] 
.const [54] = Class [143] 
.const [55] = InterfaceMethod [144] [145] 
.const [56] = Class [146] 
.const [57] = Int -2012020736 
.const [58] = Utf8 java/lang/Object 
.const [59] = Utf8 de/audi/atip/timer/Timer 
.const [60] = Utf8 'Stop waiting for update Timer' 
.const [61] = Utf8 '%1#fireTimer - timeout of %2 ms reached, waiting for updates will be stopped.' 
.const [62] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand$1 
.const [63] = Utf8 '%1#updateCurrentTrafficSign - currentTrafficSign=%2' 
.const [64] = Class [147] 
.const [65] = NameAndType [148] [149] 
.const [66] = Class [150] 
.const [67] = NameAndType [151] [152] 
.const [68] = Class [153] 
.const [69] = NameAndType [154] [155] 
.const [70] = Utf8 'UpdateTrafficSignCommand#updateCurrentTrafficSign() - notify SDS with result=%1, currentSpeedLimit=%2, currentSpeedLimitUnit=%3' 
.const [71] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand$2 
.const [72] = Class [156] 
.const [73] = NameAndType [157] [158] 
.const [74] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [75] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [76] = Utf8 de/audi/atip/log/LogChannel 
.const [77] = Utf8 de/audi/tghu/command/ICommandList 
.const [78] = Utf8 de/audi/tghu/navi/app/tr/TrafficUtil 
.const [79] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService 
.const [80] = Utf8 de/audi/tghu/navi/app/tr/TrafficRegulationService 
.const [81] = Class [159] 
.const [82] = NameAndType [160] [161] 
.const [83] = Class [162] 
.const [84] = NameAndType [163] [164] 
.const [85] = Class [165] 
.const [86] = NameAndType [166] [167] 
.const [87] = Class [168] 
.const [88] = NameAndType [169] [170] 
.const [89] = Class [171] 
.const [90] = NameAndType [172] [173] 
.const [91] = Class [174] 
.const [92] = NameAndType [175] [176] 
.const [93] = Class [177] 
.const [94] = NameAndType [178] [179] 
.const [95] = Class [180] 
.const [96] = NameAndType [181] [182] 
.const [97] = Class [183] 
.const [98] = NameAndType [184] [185] 
.const [99] = Class [186] 
.const [100] = NameAndType [187] [188] 
.const [101] = Class [189] 
.const [102] = NameAndType [190] [191] 
.const [103] = Class [192] 
.const [104] = NameAndType [193] [194] 
.const [105] = Class [195] 
.const [106] = NameAndType [196] [197] 
.const [107] = Class [198] 
.const [108] = NameAndType [199] [200] 
.const [109] = Class [201] 
.const [110] = NameAndType [202] [203] 
.const [111] = Class [204] 
.const [112] = NameAndType [205] [206] 
.const [113] = Class [207] 
.const [114] = NameAndType [208] [209] 
.const [115] = Class [210] 
.const [116] = NameAndType [211] [212] 
.const [117] = Class [213] 
.const [118] = NameAndType [214] [215] 
.const [119] = Class [216] 
.const [120] = NameAndType [217] [218] 
.const [121] = Class [219] 
.const [122] = NameAndType [220] [221] 
.const [123] = Class [222] 
.const [124] = NameAndType [223] [224] 
.const [125] = Class [225] 
.const [126] = NameAndType [226] [227] 
.const [127] = Class [228] 
.const [128] = NameAndType [229] [230] 
.const [129] = Class [231] 
.const [130] = NameAndType [232] [233] 
.const [131] = Utf8 java/lang/Object 
.const [132] = Class [234] 
.const [133] = NameAndType [235] [236] 
.const [134] = Class [237] 
.const [135] = NameAndType [238] [239] 
.const [136] = Class [240] 
.const [137] = NameAndType [241] [242] 
.const [138] = Class [243] 
.const [139] = NameAndType [244] [245] 
.const [140] = Utf8 de/audi/atip/timer/Timer 
.const [141] = Class [246] 
.const [142] = NameAndType [247] [248] 
.const [143] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand$1 
.const [144] = Class [249] 
.const [145] = NameAndType [250] [251] 
.const [146] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand$2 
.const [147] = Utf8 de/audi/tghu/navi/app/tr/TrafficUtil 
.const [148] = Utf8 retrieveCurrentSignID 
.const [149] = Utf8 (Lorg/dsi/ifc/trafficregulation/TrafficSignInformation;)I 
.const [150] = Utf8 de/audi/tghu/navi/app/tr/TrafficUtil 
.const [151] = Utf8 extractSpeedLimitFromSignID 
.const [152] = Utf8 (I)I 
.const [153] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService 
.const [154] = Utf8 access$000 
.const [155] = Utf8 (Lde/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService;)Lde/audi/tghu/navi/app/tr/TrafficRegulationService; 
.const [156] = Utf8 de/audi/tghu/navi/app/tr/TrafficUtil 
.const [157] = Utf8 isTrafficRegulationInfoEnabled 
.const [158] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)Z 
.const [159] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [160] = Utf8 this$0 
.const [161] = Utf8 Lde/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService; 
.const [162] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [163] = Utf8 mutex 
.const [164] = Utf8 Ljava/lang/Object; 
.const [165] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [166] = Utf8 updateReceived 
.const [167] = Utf8 Z 
.const [168] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [169] = Utf8 stillListeningForUpdates 
.const [170] = Utf8 Z 
.const [171] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [172] = Utf8 naviServiceListener 
.const [173] = Utf8 Lde/audi/atip/interapp/NaviServiceListener; 
.const [174] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [175] = Utf8 updateTrafficSignTimer 
.const [176] = Utf8 Lde/audi/atip/timer/Timer; 
.const [177] = Utf8 de/audi/atip/timer/Timer 
.const [178] = Utf8 start 
.const [179] = Utf8 ()V 
.const [180] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [181] = Utf8 logger 
.const [182] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [183] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [184] = Utf8 CLASS_NAME 
.const [185] = Utf8 Ljava/lang/String; 
.const [186] = Utf8 de/audi/atip/log/LogChannel 
.const [187] = Utf8 log 
.const [188] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [189] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [190] = Utf8 getCommandList 
.const [191] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [192] = Utf8 de/audi/atip/log/LogChannel 
.const [193] = Utf8 log 
.const [194] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [195] = Utf8 de/audi/atip/timer/Timer 
.const [196] = Utf8 cancel 
.const [197] = Utf8 ()Z 
.const [198] = Utf8 de/audi/tghu/navi/app/tr/TrafficRegulationService 
.const [199] = Utf8 getCurrentSpeedLimitUnit 
.const [200] = Utf8 ()B 
.const [201] = Utf8 de/audi/atip/log/LogChannel 
.const [202] = Utf8 log 
.const [203] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [204] = Utf8 de/audi/tghu/navi/app/tr/TrafficRegulationService 
.const [205] = Utf8 registerCurrentTrafficSignObserver 
.const [206] = Utf8 (Lde/audi/tghu/navi/app/tr/TrafficRegulationService$CurrentTrafficSignObserver;)V 
.const [207] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [208] = Utf8 env 
.const [209] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [210] = Utf8 de/audi/tghu/navi/app/tr/TrafficRegulationService 
.const [211] = Utf8 setEnableTrafficRegulationInfo 
.const [212] = Utf8 (Z)V 
.const [213] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [214] = Utf8 <init> 
.const [215] = Utf8 ()V 
.const [216] = Utf8 java/lang/Object 
.const [217] = Utf8 <init> 
.const [218] = Utf8 ()V 
.const [219] = Utf8 de/audi/atip/timer/Timer 
.const [220] = Utf8 <init> 
.const [221] = Utf8 (Ljava/lang/String;JZLde/audi/atip/timer/TimerListener;)V 
.const [222] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [223] = Utf8 turnOffListeningForUpdates 
.const [224] = Utf8 ()V 
.const [225] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand$1 
.const [226] = Utf8 <init> 
.const [227] = Utf8 (Lde/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand;Lde/audi/atip/interapp/NaviServiceListener;)V 
.const [228] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand$2 
.const [229] = Utf8 <init> 
.const [230] = Utf8 (Lde/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand;Lde/audi/atip/interapp/NaviServiceListener;BIB)V 
.const [231] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [232] = Utf8 this$0 
.const [233] = Utf8 Lde/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService; 
.const [234] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [235] = Utf8 mutex 
.const [236] = Utf8 Ljava/lang/Object; 
.const [237] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [238] = Utf8 updateReceived 
.const [239] = Utf8 Z 
.const [240] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [241] = Utf8 stillListeningForUpdates 
.const [242] = Utf8 Z 
.const [243] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [244] = Utf8 naviServiceListener 
.const [245] = Utf8 Lde/audi/atip/interapp/NaviServiceListener; 
.const [246] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [247] = Utf8 updateTrafficSignTimer 
.const [248] = Utf8 Lde/audi/atip/timer/Timer; 
.const [249] = Utf8 de/audi/tghu/command/ICommandList 
.const [250] = Utf8 commandFinishedWithPostCommand 
.const [251] = Utf8 (Lde/audi/tghu/command/Command;)V 
.const [252] = Utf8 de/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService$UpdateTrafficSignCommand 
.const [253] = Class [252] 
.const [254] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [255] = Class [254] 
.const [256] = Utf8 de/audi/tghu/navi/app/tr/TrafficRegulationService$CurrentTrafficSignObserver 
.const [257] = Class [256] 
.const [258] = Utf8 naviServiceListener 
.const [259] = Utf8 Lde/audi/atip/interapp/NaviServiceListener; 
.const [260] = Utf8 updateTrafficSignTimer 
.const [261] = Utf8 Lde/audi/atip/timer/Timer; 
.const [262] = Utf8 UPDATE_TRAFFIC_SIGN_TIMEOUT 
.const [263] = Utf8 J 
.const [264] = Utf8 mutex 
.const [265] = Utf8 Ljava/lang/Object; 
.const [266] = Utf8 updateReceived 
.const [267] = Utf8 Z 
.const [268] = Utf8 stillListeningForUpdates 
.const [269] = Utf8 Z 
.const [270] = Utf8 this$0 
.const [271] = Utf8 Lde/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService; 
.const [272] = Utf8 Code 
.const [273] = Utf8 <init> 
.const [274] = Utf8 (Lde/audi/tghu/navi/app/interapp/TrafficRegulationInterAppService;Lde/audi/atip/interapp/NaviServiceListener;)V 
.const [275] = Utf8 execute 
.const [276] = Utf8 ()V 
.const [277] = Utf8 fireTimer 
.const [278] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [279] = Utf8 updateCurrentTrafficSign 
.const [280] = Utf8 (Lorg/dsi/ifc/trafficregulation/TrafficSignInformation;)V 
.const [281] = Utf8 turnOffListeningForUpdates 
.const [282] = Utf8 ()V 
.end class 
