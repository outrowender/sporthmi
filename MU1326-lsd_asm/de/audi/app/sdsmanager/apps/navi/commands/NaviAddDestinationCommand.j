.version 50 0 
.class public super [97] 
.super [99] 
.field private static final [100] [101] 
.field private static final [102] [103] 
.field private static final [104] [105] 
.field private static final [106] [107] 
.field private final [108] [109] 
.field private final [110] [111] 

.method public [113] : [114] 
    .attribute [112] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [22] 
L7:     aload_0 
L8:     aload 4 
L10:    iconst_0 
L11:    invokestatic [2] 
L14:    putfield [23] 
L17:    aload_0 
L18:    aload 5 
L20:    putfield [24] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [112] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_0 
L9:     invokevirtual [19] 
L12:    aload_0 
L13:    getfield [16] 
L16:    i2l 
L17:    invokevirtual [20] 
L20:    pop 
L21:    aload_0 
L22:    getfield [16] 
L25:    tableswitch 0 
            L56 
            L70 
            L84 
            L99 
            default : L113 

L56:    aload_0 
L57:    getfield [17] 
L60:    iconst_0 
L61:    iconst_0 
L62:    invokeinterface [25] 0 
L67:    goto L141 
L70:    aload_0 
L71:    getfield [17] 
L74:    iconst_0 
L75:    iconst_1 
L76:    invokeinterface [25] 0 
L81:    goto L141 
L84:    aload_0 
L85:    getfield [17] 
L88:    bipush -2 
L90:    iconst_1 
L91:    invokeinterface [25] 0 
L96:    goto L141 
L99:    aload_0 
L100:   getfield [17] 
L103:   iconst_m1 
L104:   iconst_1 
L105:   invokeinterface [25] 0 
L110:   goto L141 
L113:   aload_0 
L114:   getfield [18] 
L117:   ldc [5] 
L119:   ldc [6] 
L121:   aload_0 
L122:   invokevirtual [19] 
L125:   aload_0 
L126:   getfield [16] 
L129:   i2l 
L130:   invokevirtual [20] 
L133:   pop 
L134:   aload_0 
L135:   sipush 3001 
L138:   invokevirtual [21] 
L141:   return 
L142:   nop 
L143:   nop 
L144:   
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [112] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [18] 
L4:     ldc [3] 
L6:     ldc [7] 
L8:     aload_0 
L9:     invokevirtual [19] 
L12:    iload_1 
L13:    i2l 
L14:    invokevirtual [20] 
L17:    pop 
L18:    iload_1 
L19:    invokestatic [8] 
L22:    istore_2 
L23:    aload_0 
L24:    getfield [18] 
L27:    ldc [3] 
L29:    ldc [9] 
L31:    aload_0 
L32:    invokevirtual [19] 
L35:    iload_2 
L36:    i2l 
L37:    invokevirtual [20] 
L40:    pop 
L41:    aload_0 
L42:    iload_2 
L43:    invokevirtual [21] 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [26] [27] 
.const [3] = Int -2137614336 
.const [4] = String [28] 
.const [5] = Int -1601830656 
.const [6] = String [29] 
.const [7] = String [30] 
.const [8] = Method [31] [32] 
.const [9] = String [33] 
.const [10] = Class [34] 
.const [11] = Class [35] 
.const [12] = Class [36] 
.const [13] = Class [37] 
.const [14] = Class [38] 
.const [15] = Class [39] 
.const [16] = Field [40] [41] 
.const [17] = Field [42] [43] 
.const [18] = Field [44] [45] 
.const [19] = Method [46] [47] 
.const [20] = Method [48] [49] 
.const [21] = Method [50] [51] 
.const [22] = Method [52] [53] 
.const [23] = Field [54] [55] 
.const [24] = Field [56] [57] 
.const [25] = InterfaceMethod [58] [59] 
.const [26] = Class [60] 
.const [27] = NameAndType [61] [62] 
.const [28] = Utf8 '[%1#execute] addDestination with routeOptions=%2!' 
.const [29] = Utf8 '[%1#execute] Unknown routeOptions=%2, sending ERROR!' 
.const [30] = Utf8 '[%1#responseAddSelectedDestinationAtIndex] result=%2' 
.const [31] = Class [63] 
.const [32] = NameAndType [64] [65] 
.const [33] = Utf8 '[%1#responseAddSelectedDestinationAtIndex] sdsRes=%2!' 
.const [34] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviAddDestinationCommand 
.const [35] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [36] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [37] = Utf8 de/audi/atip/log/LogChannel 
.const [38] = Utf8 de/audi/atip/interapp/NaviService 
.const [39] = Utf8 de/audi/app/sdsmanager/apps/navi/NaviSDSUtils 
.const [40] = Class [66] 
.const [41] = NameAndType [67] [68] 
.const [42] = Class [69] 
.const [43] = NameAndType [70] [71] 
.const [44] = Class [72] 
.const [45] = NameAndType [73] [74] 
.const [46] = Class [75] 
.const [47] = NameAndType [76] [77] 
.const [48] = Class [78] 
.const [49] = NameAndType [79] [80] 
.const [50] = Class [81] 
.const [51] = NameAndType [82] [83] 
.const [52] = Class [84] 
.const [53] = NameAndType [85] [86] 
.const [54] = Class [87] 
.const [55] = NameAndType [88] [89] 
.const [56] = Class [90] 
.const [57] = NameAndType [91] [92] 
.const [58] = Class [93] 
.const [59] = NameAndType [94] [95] 
.const [60] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [61] = Utf8 retrieveInteger 
.const [62] = Utf8 ([Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;I)I 
.const [63] = Utf8 de/audi/app/sdsmanager/apps/navi/NaviSDSUtils 
.const [64] = Utf8 getSDSResult 
.const [65] = Utf8 (B)I 
.const [66] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviAddDestinationCommand 
.const [67] = Utf8 routeOptions 
.const [68] = Utf8 I 
.const [69] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviAddDestinationCommand 
.const [70] = Utf8 naviService 
.const [71] = Utf8 Lde/audi/atip/interapp/NaviService; 
.const [72] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [73] = Utf8 logger 
.const [74] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [75] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviAddDestinationCommand 
.const [76] = Utf8 getName 
.const [77] = Utf8 ()Ljava/lang/String; 
.const [78] = Utf8 de/audi/atip/log/LogChannel 
.const [79] = Utf8 log 
.const [80] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [81] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviAddDestinationCommand 
.const [82] = Utf8 sendResult 
.const [83] = Utf8 (I)V 
.const [84] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [85] = Utf8 <init> 
.const [86] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;)V 
.const [87] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviAddDestinationCommand 
.const [88] = Utf8 routeOptions 
.const [89] = Utf8 I 
.const [90] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviAddDestinationCommand 
.const [91] = Utf8 naviService 
.const [92] = Utf8 Lde/audi/atip/interapp/NaviService; 
.const [93] = Utf8 de/audi/atip/interapp/NaviService 
.const [94] = Utf8 addSelectedDestinationAtIndex 
.const [95] = Utf8 (IZ)V 
.const [96] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviAddDestinationCommand 
.const [97] = Class [96] 
.const [98] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [99] = Class [98] 
.const [100] = Utf8 ROUTE_OPTION_STOPOVER_ADD 
.const [101] = Utf8 I 
.const [102] = Utf8 ROUTE_OPTION_STOPOVER_REPLACE 
.const [103] = Utf8 I 
.const [104] = Utf8 ROUTE_OPTION_REPLACE_ALL 
.const [105] = Utf8 I 
.const [106] = Utf8 ROUTE_OPTION_REPLACE_LAST_DEST 
.const [107] = Utf8 I 
.const [108] = Utf8 routeOptions 
.const [109] = Utf8 I 
.const [110] = Utf8 naviService 
.const [111] = Utf8 Lde/audi/atip/interapp/NaviService; 
.const [112] = Utf8 Code 
.const [113] = Utf8 <init> 
.const [114] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;[Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;Lde/audi/atip/interapp/NaviService;)V 
.const [115] = Utf8 execute 
.const [116] = Utf8 ()V 
.const [117] = Utf8 responseAddSelectedDestinationAtIndex 
.const [118] = Utf8 (B)V 
.end class 
