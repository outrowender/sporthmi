.version 50 0 
.class public super [186] 
.super [188] 
.implements [190] 
.field private [191] [192] 
.field private [193] [194] 
.field private [195] [196] 
.field private [197] [198] 
.field private [199] [200] 

.method public [202] : [203] 
    .attribute [201] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [34] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [37] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [38] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [39] 
L19:    aload_0 
L20:    aload 4 
L22:    putfield [40] 
L25:    aload_0 
L26:    aload 5 
L28:    putfield [41] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [204] : [205] 
    .attribute [201] .code stack 9 locals 6 
L0:     iload_1 
L1:     iconst_m1 
L2:     if_icmpne L11 
L5:     sipush 300 
L8:     goto L12 
L11:    iload_1 
L12:    istore_3 
L13:    aload_0 
L14:    getfield [22] 
L17:    invokeinterface [42] 0 
L22:    istore 4 
L24:    iload 4 
L26:    i2f 
L27:    ldc [2] 
L29:    fdiv 
L30:    ldc [3] 
L32:    fmul 
L33:    f2i 
L34:    bipush 10 
L36:    invokestatic [4] 
L39:    istore 5 
L41:    aload_0 
L42:    getfield [23] 
L45:    invokeinterface [43] 0 
L50:    getfield [27] 
L53:    iload 5 
L55:    isub 
L56:    istore 6 
L58:    aload_0 
L59:    getfield [25] 
L62:    ldc [5] 
L64:    ldc [6] 
L66:    iload 4 
L68:    i2l 
L69:    iload 6 
L71:    i2l 
L72:    iload_3 
L73:    i2l 
L74:    invokevirtual [28] 
L77:    pop 
L78:    aload_0 
L79:    getfield [24] 
L82:    invokevirtual [29] 
L85:    aload_0 
L86:    getfield [24] 
L89:    iload 6 
L91:    iload_3 
L92:    invokevirtual [30] 
L95:    istore 7 
L97:    aload_0 
L98:    getfield [26] 
L101:   invokeinterface [44] 0 
L106:   astore 8 
L108:   aload 8 
L110:   new [45] 
L113:   dup 
L114:   aload_0 
L115:   aload_2 
L116:   iload 7 
L118:   invokespecial [35] 
L121:   invokevirtual [31] 
L124:   pop 
L125:   aload 8 
L127:   ldc [8] 
L129:   invokevirtual [32] 
L132:   return 
L133:   nop 
L134:   nop 
L135:   nop 
L136:   
    .end code 
.end method 

.method public [206] : [207] 
    .attribute [201] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [25] 
L4:     ldc [5] 
L6:     ldc [9] 
L8:     invokevirtual [33] 
L11:    pop 
L12:    aload_0 
L13:    getfield [24] 
L16:    invokevirtual [29] 
L19:    aload_0 
L20:    getfield [26] 
L23:    invokeinterface [44] 0 
L28:    astore_2 
L29:    aload_2 
L30:    new [46] 
L33:    dup 
L34:    aload_0 
L35:    aload_1 
L36:    invokespecial [36] 
L39:    invokevirtual [31] 
L42:    pop 
L43:    aload_2 
L44:    ldc [11] 
L46:    invokevirtual [32] 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1717986880 
.const [3] = Int 8257 
.const [4] = Method [47] [48] 
.const [5] = Int -2137614336 
.const [6] = String [49] 
.const [7] = Class [50] 
.const [8] = String [51] 
.const [9] = String [52] 
.const [10] = Class [53] 
.const [11] = String [54] 
.const [12] = Class [55] 
.const [13] = Class [56] 
.const [14] = Class [57] 
.const [15] = Class [58] 
.const [16] = Class [59] 
.const [17] = Class [60] 
.const [18] = Class [61] 
.const [19] = Class [62] 
.const [20] = Class [63] 
.const [21] = Class [64] 
.const [22] = Field [65] [66] 
.const [23] = Field [67] [68] 
.const [24] = Field [69] [70] 
.const [25] = Field [71] [72] 
.const [26] = Field [73] [74] 
.const [27] = Field [75] [76] 
.const [28] = Method [77] [78] 
.const [29] = Method [79] [80] 
.const [30] = Method [81] [82] 
.const [31] = Method [83] [84] 
.const [32] = Method [85] [86] 
.const [33] = Method [87] [88] 
.const [34] = Method [89] [90] 
.const [35] = Method [91] [92] 
.const [36] = Method [93] [94] 
.const [37] = Field [95] [96] 
.const [38] = Field [97] [98] 
.const [39] = Field [99] [100] 
.const [40] = Field [101] [102] 
.const [41] = Field [103] [104] 
.const [42] = InterfaceMethod [105] [106] 
.const [43] = InterfaceMethod [107] [108] 
.const [44] = InterfaceMethod [109] [110] 
.const [45] = Class [111] 
.const [46] = Class [112] 
.const [47] = Class [113] 
.const [48] = NameAndType [114] [115] 
.const [49] = Utf8 'SDSHandlerImpl#blockRoute() - speed: %1 km/h --> block offset: %2 m, block length: %3 m' 
.const [50] = Utf8 de/audi/tghu/navi/app/sds/SDSDetourHandlerImpl$1 
.const [51] = Utf8 'SDSHandlerImpl#blockRoute' 
.const [52] = Utf8 'SDSHandlerImpl#unblockRoute()' 
.const [53] = Utf8 de/audi/tghu/navi/app/sds/SDSDetourHandlerImpl$2 
.const [54] = Utf8 'SDSHandlerImpl#unblockRoute' 
.const [55] = Utf8 de/audi/tghu/navi/app/sds/SDSDetourHandlerImpl 
.const [56] = Utf8 java/lang/Object 
.const [57] = Utf8 de/audi/tghu/navi/app/guidance/IVehicle 
.const [58] = Utf8 java/lang/Math 
.const [59] = Utf8 de/audi/tghu/navi/app/routeguidance/IRouteManager 
.const [60] = Utf8 de/audi/tghu/navi/app/rp/TripHandler$TripData 
.const [61] = Utf8 de/audi/atip/log/LogChannel 
.const [62] = Utf8 de/audi/tghu/navi/app/guidance/SimpleDetourHandler 
.const [63] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [64] = Utf8 de/audi/tghu/command/CommandList 
.const [65] = Class [116] 
.const [66] = NameAndType [117] [118] 
.const [67] = Class [119] 
.const [68] = NameAndType [120] [121] 
.const [69] = Class [122] 
.const [70] = NameAndType [123] [124] 
.const [71] = Class [125] 
.const [72] = NameAndType [126] [127] 
.const [73] = Class [128] 
.const [74] = NameAndType [129] [130] 
.const [75] = Class [131] 
.const [76] = NameAndType [132] [133] 
.const [77] = Class [134] 
.const [78] = NameAndType [135] [136] 
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
.const [111] = Utf8 de/audi/tghu/navi/app/sds/SDSDetourHandlerImpl$1 
.const [112] = Utf8 de/audi/tghu/navi/app/sds/SDSDetourHandlerImpl$2 
.const [113] = Utf8 java/lang/Math 
.const [114] = Utf8 max 
.const [115] = Utf8 (II)I 
.const [116] = Utf8 de/audi/tghu/navi/app/sds/SDSDetourHandlerImpl 
.const [117] = Utf8 vehicle 
.const [118] = Utf8 Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [119] = Utf8 de/audi/tghu/navi/app/sds/SDSDetourHandlerImpl 
.const [120] = Utf8 routeManager 
.const [121] = Utf8 Lde/audi/tghu/navi/app/routeguidance/IRouteManager; 
.const [122] = Utf8 de/audi/tghu/navi/app/sds/SDSDetourHandlerImpl 
.const [123] = Utf8 simpleDetourHandler 
.const [124] = Utf8 Lde/audi/tghu/navi/app/guidance/SimpleDetourHandler; 
.const [125] = Utf8 de/audi/tghu/navi/app/sds/SDSDetourHandlerImpl 
.const [126] = Utf8 logChannel 
.const [127] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [128] = Utf8 de/audi/tghu/navi/app/sds/SDSDetourHandlerImpl 
.const [129] = Utf8 commandListFactory 
.const [130] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [131] = Utf8 de/audi/tghu/navi/app/rp/TripHandler$TripData 
.const [132] = Utf8 distanceToFinalDestination 
.const [133] = Utf8 I 
.const [134] = Utf8 de/audi/atip/log/LogChannel 
.const [135] = Utf8 log 
.const [136] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [137] = Utf8 de/audi/tghu/navi/app/guidance/SimpleDetourHandler 
.const [138] = Utf8 deleteBlockRouteBasedOnLength 
.const [139] = Utf8 ()V 
.const [140] = Utf8 de/audi/tghu/navi/app/guidance/SimpleDetourHandler 
.const [141] = Utf8 blockRouteExt 
.const [142] = Utf8 (II)Z 
.const [143] = Utf8 de/audi/tghu/command/CommandList 
.const [144] = Utf8 add 
.const [145] = Utf8 (Lde/audi/tghu/command/Command;)Lde/audi/tghu/command/ICommandList; 
.const [146] = Utf8 de/audi/tghu/command/CommandList 
.const [147] = Utf8 execute 
.const [148] = Utf8 (Ljava/lang/String;)V 
.const [149] = Utf8 de/audi/atip/log/LogChannel 
.const [150] = Utf8 log 
.const [151] = Utf8 (ILjava/lang/String;)Z 
.const [152] = Utf8 java/lang/Object 
.const [153] = Utf8 <init> 
.const [154] = Utf8 ()V 
.const [155] = Utf8 de/audi/tghu/navi/app/sds/SDSDetourHandlerImpl$1 
.const [156] = Utf8 <init> 
.const [157] = Utf8 (Lde/audi/tghu/navi/app/sds/SDSDetourHandlerImpl;Lde/audi/atip/interapp/NaviServiceListener;Z)V 
.const [158] = Utf8 de/audi/tghu/navi/app/sds/SDSDetourHandlerImpl$2 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (Lde/audi/tghu/navi/app/sds/SDSDetourHandlerImpl;Lde/audi/atip/interapp/NaviServiceListener;)V 
.const [161] = Utf8 de/audi/tghu/navi/app/sds/SDSDetourHandlerImpl 
.const [162] = Utf8 vehicle 
.const [163] = Utf8 Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [164] = Utf8 de/audi/tghu/navi/app/sds/SDSDetourHandlerImpl 
.const [165] = Utf8 routeManager 
.const [166] = Utf8 Lde/audi/tghu/navi/app/routeguidance/IRouteManager; 
.const [167] = Utf8 de/audi/tghu/navi/app/sds/SDSDetourHandlerImpl 
.const [168] = Utf8 simpleDetourHandler 
.const [169] = Utf8 Lde/audi/tghu/navi/app/guidance/SimpleDetourHandler; 
.const [170] = Utf8 de/audi/tghu/navi/app/sds/SDSDetourHandlerImpl 
.const [171] = Utf8 logChannel 
.const [172] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [173] = Utf8 de/audi/tghu/navi/app/sds/SDSDetourHandlerImpl 
.const [174] = Utf8 commandListFactory 
.const [175] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [176] = Utf8 de/audi/tghu/navi/app/guidance/IVehicle 
.const [177] = Utf8 getCarVelocity 
.const [178] = Utf8 ()I 
.const [179] = Utf8 de/audi/tghu/navi/app/routeguidance/IRouteManager 
.const [180] = Utf8 getTripDataAuto 
.const [181] = Utf8 ()Lde/audi/tghu/navi/app/rp/TripHandler$TripData; 
.const [182] = Utf8 de/audi/tghu/command/ICommandListFactory 
.const [183] = Utf8 createCommandList 
.const [184] = Utf8 ()Lde/audi/tghu/command/CommandList; 
.const [185] = Utf8 de/audi/tghu/navi/app/sds/SDSDetourHandlerImpl 
.const [186] = Class [185] 
.const [187] = Utf8 java/lang/Object 
.const [188] = Class [187] 
.const [189] = Utf8 de/audi/tghu/navi/app/sds/ISDSDetourHandler 
.const [190] = Class [189] 
.const [191] = Utf8 logChannel 
.const [192] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [193] = Utf8 commandListFactory 
.const [194] = Utf8 Lde/audi/tghu/command/ICommandListFactory; 
.const [195] = Utf8 simpleDetourHandler 
.const [196] = Utf8 Lde/audi/tghu/navi/app/guidance/SimpleDetourHandler; 
.const [197] = Utf8 routeManager 
.const [198] = Utf8 Lde/audi/tghu/navi/app/routeguidance/IRouteManager; 
.const [199] = Utf8 vehicle 
.const [200] = Utf8 Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [201] = Utf8 Code 
.const [202] = Utf8 <init> 
.const [203] = Utf8 (Lde/audi/tghu/navi/app/guidance/IVehicle;Lde/audi/tghu/navi/app/routeguidance/IRouteManager;Lde/audi/tghu/navi/app/guidance/SimpleDetourHandler;Lde/audi/atip/log/LogChannel;Lde/audi/tghu/command/ICommandListFactory;)V 
.const [204] = Utf8 blockRoute 
.const [205] = Utf8 (ILde/audi/atip/interapp/NaviServiceListener;)V 
.const [206] = Utf8 unblockRoute 
.const [207] = Utf8 (Lde/audi/atip/interapp/NaviServiceListener;)V 
.end class 
