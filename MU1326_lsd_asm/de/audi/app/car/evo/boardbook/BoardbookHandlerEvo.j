.version 50 0 
.class public super [71] 
.super [73] 
.field private [74] [75] 

.method public [77] : [78] 
    .attribute [76] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_3 
L3:     invokeinterface [14] 0 
L8:     invokespecial [13] 
L11:    aload_0 
L12:    aload_3 
L13:    putfield [15] 
L16:    aload_3 
L17:    invokeinterface [16] 0 
L22:    ldc [2] 
L24:    bipush 23 
L26:    invokeinterface [17] 0 
L31:    pop 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [79] : [80] 
    .attribute [76] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     iload_1 
L9:     invokevirtual [12] 
L12:    pop 
L13:    iload_1 
L14:    ifeq L37 
L17:    aload_0 
L18:    getfield [10] 
L21:    invokeinterface [16] 0 
L26:    ldc [2] 
L28:    iconst_0 
L29:    invokeinterface [18] 0 
L34:    goto L54 
L37:    aload_0 
L38:    getfield [10] 
L41:    invokeinterface [16] 0 
L46:    ldc [2] 
L48:    iconst_0 
L49:    invokeinterface [18] 0 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1177094400 
.const [3] = Int 1078071040 
.const [4] = String [19] 
.const [5] = Class [20] 
.const [6] = Class [21] 
.const [7] = Class [22] 
.const [8] = Class [23] 
.const [9] = Class [24] 
.const [10] = Field [25] [26] 
.const [11] = Field [27] [28] 
.const [12] = Method [29] [30] 
.const [13] = Method [31] [32] 
.const [14] = InterfaceMethod [33] [34] 
.const [15] = Field [35] [36] 
.const [16] = InterfaceMethod [37] [38] 
.const [17] = InterfaceMethod [39] [40] 
.const [18] = InterfaceMethod [41] [42] 
.const [19] = Utf8 'BoardbookHandlerEVO#indicateBoardbookAvailable %1' 
.const [20] = Utf8 de/audi/app/car/evo/boardbook/BoardbookHandlerEvo 
.const [21] = Utf8 de/audi/app/car/core/boardbook/BoardbookHandler 
.const [22] = Utf8 de/audi/app/car/common/app/ICarApplication 
.const [23] = Utf8 de/audi/app/car/common/mer/IMenuEntryRegistry 
.const [24] = Utf8 de/audi/atip/log/LogChannel 
.const [25] = Class [43] 
.const [26] = NameAndType [44] [45] 
.const [27] = Class [46] 
.const [28] = NameAndType [47] [48] 
.const [29] = Class [49] 
.const [30] = NameAndType [50] [51] 
.const [31] = Class [52] 
.const [32] = NameAndType [53] [54] 
.const [33] = Class [55] 
.const [34] = NameAndType [56] [57] 
.const [35] = Class [58] 
.const [36] = NameAndType [59] [60] 
.const [37] = Class [61] 
.const [38] = NameAndType [62] [63] 
.const [39] = Class [64] 
.const [40] = NameAndType [65] [66] 
.const [41] = Class [67] 
.const [42] = NameAndType [68] [69] 
.const [43] = Utf8 de/audi/app/car/evo/boardbook/BoardbookHandlerEvo 
.const [44] = Utf8 app 
.const [45] = Utf8 Lde/audi/app/car/common/app/ICarApplication; 
.const [46] = Utf8 de/audi/app/car/evo/boardbook/BoardbookHandlerEvo 
.const [47] = Utf8 logChannel 
.const [48] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [49] = Utf8 de/audi/atip/log/LogChannel 
.const [50] = Utf8 log 
.const [51] = Utf8 (ILjava/lang/String;Z)Z 
.const [52] = Utf8 de/audi/app/car/core/boardbook/BoardbookHandler 
.const [53] = Utf8 <init> 
.const [54] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/atip/base/IFrameworkAccess;)V 
.const [55] = Utf8 de/audi/app/car/common/app/ICarApplication 
.const [56] = Utf8 getFrameworkAccess 
.const [57] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [58] = Utf8 de/audi/app/car/evo/boardbook/BoardbookHandlerEvo 
.const [59] = Utf8 app 
.const [60] = Utf8 Lde/audi/app/car/common/app/ICarApplication; 
.const [61] = Utf8 de/audi/app/car/common/app/ICarApplication 
.const [62] = Utf8 getMenuEntryRegistry 
.const [63] = Utf8 ()Lde/audi/app/car/common/mer/IMenuEntryRegistry; 
.const [64] = Utf8 de/audi/app/car/common/mer/IMenuEntryRegistry 
.const [65] = Utf8 registerMenuEntry 
.const [66] = Utf8 (IS)Lde/audi/app/car/common/mer/IMenuEntry; 
.const [67] = Utf8 de/audi/app/car/common/mer/IMenuEntryRegistry 
.const [68] = Utf8 updateMenuEntryVisibility 
.const [69] = Utf8 (II)V 
.const [70] = Utf8 de/audi/app/car/evo/boardbook/BoardbookHandlerEvo 
.const [71] = Class [70] 
.const [72] = Utf8 de/audi/app/car/core/boardbook/BoardbookHandler 
.const [73] = Class [72] 
.const [74] = Utf8 app 
.const [75] = Utf8 Lde/audi/app/car/common/app/ICarApplication; 
.const [76] = Utf8 Code 
.const [77] = Utf8 <init> 
.const [78] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/atip/hmi/HMIService;Lde/audi/app/car/common/app/ICarApplication;)V 
.const [79] = Utf8 indicateBoardbookAvailable 
.const [80] = Utf8 (Z)V 
.end class 
