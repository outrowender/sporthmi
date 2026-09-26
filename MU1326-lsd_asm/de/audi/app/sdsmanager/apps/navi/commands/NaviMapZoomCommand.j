.version 50 0 
.class public super [105] 
.super [107] 
.field private static final [108] [109] 
.field private static final [110] [111] 
.field private [112] [113] 
.field private final [114] [115] 

.method public [117] : [118] 
    .attribute [116] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [22] 
L7:     aload_0 
L8:     new [24] 
L11:    dup 
L12:    aload_0 
L13:    getfield [15] 
L16:    invokespecial [23] 
L19:    putfield [25] 
L22:    aload_0 
L23:    aload 5 
L25:    putfield [25] 
L28:    aload_0 
L29:    aload 4 
L31:    iconst_0 
L32:    invokestatic [3] 
L35:    putfield [26] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [119] : [120] 
    .attribute [116] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [15] 
L4:     ldc [4] 
L6:     ldc [5] 
L8:     aload_0 
L9:     invokevirtual [18] 
L12:    aload_0 
L13:    getfield [17] 
L16:    i2l 
L17:    invokevirtual [19] 
L20:    pop 
L21:    sipush 3000 
L24:    istore_1 
L25:    aload_0 
L26:    getfield [17] 
L29:    lookupswitch 
            0 : L56 
            1 : L85 
            default : L114 

L56:    aload_0 
L57:    getfield [15] 
L60:    ldc [4] 
L62:    ldc [6] 
L64:    aload_0 
L65:    invokevirtual [18] 
L68:    invokevirtual [20] 
L71:    pop 
L72:    aload_0 
L73:    getfield [16] 
L76:    iconst_m1 
L77:    invokeinterface [27] 0 
L82:    goto L139 
L85:    aload_0 
L86:    getfield [15] 
L89:    ldc [4] 
L91:    ldc [7] 
L93:    aload_0 
L94:    invokevirtual [18] 
L97:    invokevirtual [20] 
L100:   pop 
L101:   aload_0 
L102:   getfield [16] 
L105:   iconst_1 
L106:   invokeinterface [27] 0 
L111:   goto L139 
L114:   aload_0 
L115:   getfield [15] 
L118:   ldc [8] 
L120:   ldc [9] 
L122:   aload_0 
L123:   invokevirtual [18] 
L126:   aload_0 
L127:   getfield [17] 
L130:   i2l 
L131:   invokevirtual [19] 
L134:   pop 
L135:   sipush 3001 
L138:   istore_1 
L139:   aload_0 
L140:   iload_1 
L141:   invokevirtual [21] 
L144:   return 
L145:   nop 
L146:   nop 
L147:   nop 
L148:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [28] 
.const [3] = Method [29] [30] 
.const [4] = Int -2137614336 
.const [5] = String [31] 
.const [6] = String [32] 
.const [7] = String [33] 
.const [8] = Int -1601830656 
.const [9] = String [34] 
.const [10] = Class [35] 
.const [11] = Class [36] 
.const [12] = Class [37] 
.const [13] = Class [38] 
.const [14] = Class [39] 
.const [15] = Field [40] [41] 
.const [16] = Field [42] [43] 
.const [17] = Field [44] [45] 
.const [18] = Method [46] [47] 
.const [19] = Method [48] [49] 
.const [20] = Method [50] [51] 
.const [21] = Method [52] [53] 
.const [22] = Method [54] [55] 
.const [23] = Method [56] [57] 
.const [24] = Class [58] 
.const [25] = Field [59] [60] 
.const [26] = Field [61] [62] 
.const [27] = InterfaceMethod [63] [64] 
.const [28] = Utf8 de/audi/atip/interapp/def/NullMapService 
.const [29] = Class [65] 
.const [30] = NameAndType [66] [67] 
.const [31] = Utf8 '[%1#execute] zoomDirection=%2' 
.const [32] = Utf8 '[%1#execute] Zooming into map!' 
.const [33] = Utf8 '[%1#execute] Zooming out from map!' 
.const [34] = Utf8 '[%1#execute] Unknown zoomDirection %2!' 
.const [35] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviMapZoomCommand 
.const [36] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [37] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [38] = Utf8 de/audi/atip/log/LogChannel 
.const [39] = Utf8 de/audi/atip/interapp/MapService 
.const [40] = Class [68] 
.const [41] = NameAndType [69] [70] 
.const [42] = Class [71] 
.const [43] = NameAndType [72] [73] 
.const [44] = Class [74] 
.const [45] = NameAndType [75] [76] 
.const [46] = Class [77] 
.const [47] = NameAndType [78] [79] 
.const [48] = Class [80] 
.const [49] = NameAndType [81] [82] 
.const [50] = Class [83] 
.const [51] = NameAndType [84] [85] 
.const [52] = Class [86] 
.const [53] = NameAndType [87] [88] 
.const [54] = Class [89] 
.const [55] = NameAndType [90] [91] 
.const [56] = Class [92] 
.const [57] = NameAndType [93] [94] 
.const [58] = Utf8 de/audi/atip/interapp/def/NullMapService 
.const [59] = Class [95] 
.const [60] = NameAndType [96] [97] 
.const [61] = Class [98] 
.const [62] = NameAndType [99] [100] 
.const [63] = Class [101] 
.const [64] = NameAndType [102] [103] 
.const [65] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [66] = Utf8 retrieveInteger 
.const [67] = Utf8 ([Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;I)I 
.const [68] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [69] = Utf8 logger 
.const [70] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [71] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviMapZoomCommand 
.const [72] = Utf8 mapService 
.const [73] = Utf8 Lde/audi/atip/interapp/MapService; 
.const [74] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviMapZoomCommand 
.const [75] = Utf8 zoomDirection 
.const [76] = Utf8 I 
.const [77] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviMapZoomCommand 
.const [78] = Utf8 getName 
.const [79] = Utf8 ()Ljava/lang/String; 
.const [80] = Utf8 de/audi/atip/log/LogChannel 
.const [81] = Utf8 log 
.const [82] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [83] = Utf8 de/audi/atip/log/LogChannel 
.const [84] = Utf8 log 
.const [85] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [86] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviMapZoomCommand 
.const [87] = Utf8 sendResult 
.const [88] = Utf8 (I)V 
.const [89] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [90] = Utf8 <init> 
.const [91] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;)V 
.const [92] = Utf8 de/audi/atip/interapp/def/NullMapService 
.const [93] = Utf8 <init> 
.const [94] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [95] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviMapZoomCommand 
.const [96] = Utf8 mapService 
.const [97] = Utf8 Lde/audi/atip/interapp/MapService; 
.const [98] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviMapZoomCommand 
.const [99] = Utf8 zoomDirection 
.const [100] = Utf8 I 
.const [101] = Utf8 de/audi/atip/interapp/MapService 
.const [102] = Utf8 setIncrementalZoom 
.const [103] = Utf8 (I)V 
.const [104] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviMapZoomCommand 
.const [105] = Class [104] 
.const [106] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [107] = Class [106] 
.const [108] = Utf8 NAVI_MAP_ZOOM_IN 
.const [109] = Utf8 I 
.const [110] = Utf8 NAVI_MAP_ZOOM_OUT 
.const [111] = Utf8 I 
.const [112] = Utf8 mapService 
.const [113] = Utf8 Lde/audi/atip/interapp/MapService; 
.const [114] = Utf8 zoomDirection 
.const [115] = Utf8 I 
.const [116] = Utf8 Code 
.const [117] = Utf8 <init> 
.const [118] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;[Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;Lde/audi/atip/interapp/MapService;)V 
.const [119] = Utf8 execute 
.const [120] = Utf8 ()V 
.end class 
