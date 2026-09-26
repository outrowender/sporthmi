.version 50 0 
.class public super [65] 
.super [67] 
.implements [69] 
.field private final [70] [71] 
.field private final [72] [73] 

.method public [75] : [76] 
    .attribute [74] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [16] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [17] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [77] : [78] 
    .attribute [74] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     iload_1 
L9:     i2l 
L10:    iload_2 
L11:    i2l 
L12:    invokevirtual [12] 
L15:    pop 
L16:    iload_1 
L17:    sipush 211 
L20:    if_icmpne L31 
L23:    aload_0 
L24:    getfield [11] 
L27:    iconst_1 
L28:    invokevirtual [13] 
L31:    iload_1 
L32:    sipush 202 
L35:    if_icmpne L46 
L38:    aload_0 
L39:    getfield [11] 
L42:    iconst_1 
L43:    invokevirtual [13] 
L46:    iload_1 
L47:    sipush 212 
L50:    if_icmpne L64 
L53:    aload_0 
L54:    getfield [11] 
L57:    iconst_0 
L58:    invokevirtual [13] 
L61:    goto L76 
L64:    aload_0 
L65:    getfield [10] 
L68:    ldc [4] 
L70:    ldc [5] 
L72:    invokevirtual [14] 
L75:    pop 
L76:    return 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [18] 
.const [4] = Int 14808325 
.const [5] = String [19] 
.const [6] = Class [20] 
.const [7] = Class [21] 
.const [8] = Class [22] 
.const [9] = Class [23] 
.const [10] = Field [24] [25] 
.const [11] = Field [26] [27] 
.const [12] = Method [28] [29] 
.const [13] = Method [30] [31] 
.const [14] = Method [32] [33] 
.const [15] = Method [34] [35] 
.const [16] = Field [36] [37] 
.const [17] = Field [38] [39] 
.const [18] = Utf8 'CombiRouteGuidanceMapEventListener#onEvent() eventId=%1, value=%2' 
.const [19] = Utf8 'CombiRouteGuidanceMapEventListener#onEvent() unknown eventId' 
.const [20] = Utf8 de/audi/tghu/navi/app/cluster/CombiRouteGuidanceMapEventListener 
.const [21] = Utf8 java/lang/Object 
.const [22] = Utf8 de/audi/atip/log/LogChannel 
.const [23] = Utf8 de/audi/tghu/navi/app/cluster/CombiBAPListener 
.const [24] = Class [40] 
.const [25] = NameAndType [41] [42] 
.const [26] = Class [43] 
.const [27] = NameAndType [44] [45] 
.const [28] = Class [46] 
.const [29] = NameAndType [47] [48] 
.const [30] = Class [49] 
.const [31] = NameAndType [50] [51] 
.const [32] = Class [52] 
.const [33] = NameAndType [53] [54] 
.const [34] = Class [55] 
.const [35] = NameAndType [56] [57] 
.const [36] = Class [58] 
.const [37] = NameAndType [59] [60] 
.const [38] = Class [61] 
.const [39] = NameAndType [62] [63] 
.const [40] = Utf8 de/audi/tghu/navi/app/cluster/CombiRouteGuidanceMapEventListener 
.const [41] = Utf8 logger 
.const [42] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [43] = Utf8 de/audi/tghu/navi/app/cluster/CombiRouteGuidanceMapEventListener 
.const [44] = Utf8 combiBAPListener 
.const [45] = Utf8 Lde/audi/tghu/navi/app/cluster/CombiBAPListener; 
.const [46] = Utf8 de/audi/atip/log/LogChannel 
.const [47] = Utf8 log 
.const [48] = Utf8 (ILjava/lang/String;JJ)Z 
.const [49] = Utf8 de/audi/tghu/navi/app/cluster/CombiBAPListener 
.const [50] = Utf8 routeGuidanceActDeactResult 
.const [51] = Utf8 (I)V 
.const [52] = Utf8 de/audi/atip/log/LogChannel 
.const [53] = Utf8 log 
.const [54] = Utf8 (ILjava/lang/String;)Z 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 <init> 
.const [57] = Utf8 ()V 
.const [58] = Utf8 de/audi/tghu/navi/app/cluster/CombiRouteGuidanceMapEventListener 
.const [59] = Utf8 logger 
.const [60] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [61] = Utf8 de/audi/tghu/navi/app/cluster/CombiRouteGuidanceMapEventListener 
.const [62] = Utf8 combiBAPListener 
.const [63] = Utf8 Lde/audi/tghu/navi/app/cluster/CombiBAPListener; 
.const [64] = Utf8 de/audi/tghu/navi/app/cluster/CombiRouteGuidanceMapEventListener 
.const [65] = Class [64] 
.const [66] = Utf8 java/lang/Object 
.const [67] = Class [66] 
.const [68] = Utf8 de/audi/tghu/navi/app/map/event/MapEventListener 
.const [69] = Class [68] 
.const [70] = Utf8 logger 
.const [71] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [72] = Utf8 combiBAPListener 
.const [73] = Utf8 Lde/audi/tghu/navi/app/cluster/CombiBAPListener; 
.const [74] = Utf8 Code 
.const [75] = Utf8 <init> 
.const [76] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/cluster/CombiBAPListener;)V 
.const [77] = Utf8 onEvent 
.const [78] = Utf8 (II)V 
.end class 
