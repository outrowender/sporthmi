.version 50 0 
.class public super [77] 
.super [79] 
.field private static final [80] [81] 
.field private static final [82] [83] 

.method public annotation [85] : [86] 
    .attribute [84] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [14] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [87] : [88] 
    .attribute [84] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokevirtual [10] 
L4:     invokeinterface [16] 0 
L9:     ldc [2] 
L11:    aload_0 
L12:    aload_1 
L13:    invokevirtual [11] 
L16:    invokeinterface [17] 0 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected [89] : [90] 
    .attribute [84] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [10] 
L4:     invokeinterface [16] 0 
L9:     ldc [2] 
L11:    bipush 18 
L13:    invokeinterface [18] 0 
L18:    pop 
L19:    return 
L20:    
    .end code 
.end method 

.method protected [91] : [92] 
    .attribute [84] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [10] 
L4:     invokeinterface [16] 0 
L9:     ldc [2] 
L11:    invokeinterface [19] 0 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [93] : [94] 
    .attribute [84] .code stack 1 locals 0 
L0:     bipush 6 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [95] : [96] 
    .attribute [84] .code stack 7 locals 1 
L0:     iload_1 
L1:     bipush 8 
L3:     if_icmpne L11 
L6:     bipush 10 
L8:     goto L16 
L11:    aload_0 
L12:    iload_1 
L13:    invokespecial [15] 
L16:    istore_2 
L17:    aload_0 
L18:    invokevirtual [12] 
L21:    ldc [3] 
L23:    ldc [4] 
L25:    iload_1 
L26:    i2l 
L27:    iload_2 
L28:    i2l 
L29:    invokevirtual [13] 
L32:    pop 
L33:    iload_2 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1126697216 
.const [3] = Int 1078071040 
.const [4] = String [20] 
.const [5] = Class [21] 
.const [6] = Class [22] 
.const [7] = Class [23] 
.const [8] = Class [24] 
.const [9] = Class [25] 
.const [10] = Method [26] [27] 
.const [11] = Method [28] [29] 
.const [12] = Method [30] [31] 
.const [13] = Method [32] [33] 
.const [14] = Method [34] [35] 
.const [15] = Method [36] [37] 
.const [16] = InterfaceMethod [38] [39] 
.const [17] = InterfaceMethod [40] [41] 
.const [18] = InterfaceMethod [42] [43] 
.const [19] = InterfaceMethod [44] [45] 
.const [20] = Utf8 'segments(%1)->%2' 
.const [21] = Utf8 de/audi/app/car/evo/service/OilLevelComponentEvo 
.const [22] = Utf8 de/audi/app/car/core/service/AbstractOilLevelComponent 
.const [23] = Utf8 de/audi/app/car/common/app/ICarApplication 
.const [24] = Utf8 de/audi/app/car/common/mer/IMenuEntryRegistry 
.const [25] = Utf8 de/audi/atip/log/LogChannel 
.const [26] = Class [46] 
.const [27] = NameAndType [47] [48] 
.const [28] = Class [49] 
.const [29] = NameAndType [50] [51] 
.const [30] = Class [52] 
.const [31] = NameAndType [53] [54] 
.const [32] = Class [55] 
.const [33] = NameAndType [56] [57] 
.const [34] = Class [58] 
.const [35] = NameAndType [59] [60] 
.const [36] = Class [61] 
.const [37] = NameAndType [62] [63] 
.const [38] = Class [64] 
.const [39] = NameAndType [65] [66] 
.const [40] = Class [67] 
.const [41] = NameAndType [68] [69] 
.const [42] = Class [70] 
.const [43] = NameAndType [71] [72] 
.const [44] = Class [73] 
.const [45] = NameAndType [74] [75] 
.const [46] = Utf8 de/audi/app/car/evo/service/OilLevelComponentEvo 
.const [47] = Utf8 getApplication 
.const [48] = Utf8 ()Lde/audi/app/car/common/app/ICarApplication; 
.const [49] = Utf8 de/audi/app/car/evo/service/OilLevelComponentEvo 
.const [50] = Utf8 getMenuEntryVisibilityState 
.const [51] = Utf8 (Lorg/dsi/ifc/global/CarViewOption;)I 
.const [52] = Utf8 de/audi/app/car/evo/service/OilLevelComponentEvo 
.const [53] = Utf8 getLogChannel 
.const [54] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [55] = Utf8 de/audi/atip/log/LogChannel 
.const [56] = Utf8 log 
.const [57] = Utf8 (ILjava/lang/String;JJ)Z 
.const [58] = Utf8 de/audi/app/car/core/service/AbstractOilLevelComponent 
.const [59] = Utf8 <init> 
.const [60] = Utf8 (Lde/audi/app/car/common/app/ICarApplication;)V 
.const [61] = Utf8 de/audi/app/car/core/service/AbstractOilLevelComponent 
.const [62] = Utf8 segments 
.const [63] = Utf8 (I)I 
.const [64] = Utf8 de/audi/app/car/common/app/ICarApplication 
.const [65] = Utf8 getMenuEntryRegistry 
.const [66] = Utf8 ()Lde/audi/app/car/common/mer/IMenuEntryRegistry; 
.const [67] = Utf8 de/audi/app/car/common/mer/IMenuEntryRegistry 
.const [68] = Utf8 updateMenuEntryVisibility 
.const [69] = Utf8 (II)V 
.const [70] = Utf8 de/audi/app/car/common/mer/IMenuEntryRegistry 
.const [71] = Utf8 registerMenuEntry 
.const [72] = Utf8 (IS)Lde/audi/app/car/common/mer/IMenuEntry; 
.const [73] = Utf8 de/audi/app/car/common/mer/IMenuEntryRegistry 
.const [74] = Utf8 deregisterMenuEntry 
.const [75] = Utf8 (I)V 
.const [76] = Utf8 de/audi/app/car/evo/service/OilLevelComponentEvo 
.const [77] = Class [76] 
.const [78] = Utf8 de/audi/app/car/core/service/AbstractOilLevelComponent 
.const [79] = Class [78] 
.const [80] = Utf8 MAX_OIL_DSI 
.const [81] = Utf8 I 
.const [82] = Utf8 MAX_OIL_HMI 
.const [83] = Utf8 I 
.const [84] = Utf8 Code 
.const [85] = Utf8 <init> 
.const [86] = Utf8 (Lde/audi/app/car/common/app/ICarApplication;)V 
.const [87] = Utf8 updateMenuEntryVisibility 
.const [88] = Utf8 (Lorg/dsi/ifc/global/CarViewOption;)V 
.const [89] = Utf8 initVisibility 
.const [90] = Utf8 ()V 
.const [91] = Utf8 deinitVisibility 
.const [92] = Utf8 ()V 
.const [93] = Utf8 getID 
.const [94] = Utf8 ()I 
.const [95] = Utf8 segments 
.const [96] = Utf8 (I)I 
.end class 
