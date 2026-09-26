.version 50 0 
.class public super [66] 
.super [68] 
.implements [70] 
.field private [71] [72] 
.field private [73] [74] 

.method public [76] : [77] 
    .attribute [75] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [11] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [12] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [78] : [79] 
    .attribute [75] .code stack 2 locals 0 
L0:     iload_1 
L1:     ifeq L24 
L4:     aload_0 
L5:     getfield [7] 
L8:     aload_0 
L9:     getfield [8] 
L12:    invokevirtual [9] 
L15:    iconst_1 
L16:    invokeinterface [13] 0 
L21:    goto L41 
L24:    aload_0 
L25:    getfield [7] 
L28:    aload_0 
L29:    getfield [8] 
L32:    invokevirtual [9] 
L35:    iconst_0 
L36:    invokeinterface [13] 0 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [80] : [81] 
    .attribute [75] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     ldc [2] 
L6:     invokevirtual [9] 
L9:     iload_1 
L10:    invokeinterface [13] 0 
L15:    aload_0 
L16:    getfield [7] 
L19:    aload_0 
L20:    getfield [8] 
L23:    invokevirtual [9] 
L26:    iload_1 
L27:    invokeinterface [14] 0 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [82] : [83] 
    .attribute [75] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     aload_0 
L5:     getfield [8] 
L8:     invokevirtual [9] 
L11:    invokeinterface [15] 0 
L16:    iconst_1 
L17:    if_icmpne L24 
L20:    iconst_1 
L21:    goto L25 
L24:    iconst_0 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -1256323584 
.const [3] = Class [16] 
.const [4] = Class [17] 
.const [5] = Class [18] 
.const [6] = Class [19] 
.const [7] = Field [20] [21] 
.const [8] = Field [22] [23] 
.const [9] = Method [24] [25] 
.const [10] = Method [26] [27] 
.const [11] = Field [28] [29] 
.const [12] = Field [30] [31] 
.const [13] = InterfaceMethod [32] [33] 
.const [14] = InterfaceMethod [34] [35] 
.const [15] = InterfaceMethod [36] [37] 
.const [16] = Utf8 de/audi/app/navi/evo/presentationmode/DemoModeModelAccess 
.const [17] = Utf8 java/lang/Object 
.const [18] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [19] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [20] = Class [38] 
.const [21] = NameAndType [39] [40] 
.const [22] = Class [41] 
.const [23] = NameAndType [42] [43] 
.const [24] = Class [44] 
.const [25] = NameAndType [45] [46] 
.const [26] = Class [47] 
.const [27] = NameAndType [48] [49] 
.const [28] = Class [50] 
.const [29] = NameAndType [51] [52] 
.const [30] = Class [53] 
.const [31] = NameAndType [54] [55] 
.const [32] = Class [56] 
.const [33] = NameAndType [57] [58] 
.const [34] = Class [59] 
.const [35] = NameAndType [60] [61] 
.const [36] = Class [62] 
.const [37] = NameAndType [63] [64] 
.const [38] = Utf8 de/audi/app/navi/evo/presentationmode/DemoModeModelAccess 
.const [39] = Utf8 env 
.const [40] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [41] = Utf8 de/audi/app/navi/evo/presentationmode/DemoModeModelAccess 
.const [42] = Utf8 demoModeChoiceModel 
.const [43] = Utf8 I 
.const [44] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [45] = Utf8 getChoiceModel 
.const [46] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [47] = Utf8 java/lang/Object 
.const [48] = Utf8 <init> 
.const [49] = Utf8 ()V 
.const [50] = Utf8 de/audi/app/navi/evo/presentationmode/DemoModeModelAccess 
.const [51] = Utf8 env 
.const [52] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [53] = Utf8 de/audi/app/navi/evo/presentationmode/DemoModeModelAccess 
.const [54] = Utf8 demoModeChoiceModel 
.const [55] = Utf8 I 
.const [56] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [57] = Utf8 setValue 
.const [58] = Utf8 (I)V 
.const [59] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [60] = Utf8 setStatus 
.const [61] = Utf8 (I)V 
.const [62] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [63] = Utf8 getStatus 
.const [64] = Utf8 ()I 
.const [65] = Utf8 de/audi/app/navi/evo/presentationmode/DemoModeModelAccess 
.const [66] = Class [65] 
.const [67] = Utf8 java/lang/Object 
.const [68] = Class [67] 
.const [69] = Utf8 de/audi/tghu/navi/app/presentationmode/IDemoModeModelAccess 
.const [70] = Class [69] 
.const [71] = Utf8 env 
.const [72] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [73] = Utf8 demoModeChoiceModel 
.const [74] = Utf8 I 
.const [75] = Utf8 Code 
.const [76] = Utf8 <init> 
.const [77] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;I)V 
.const [78] = Utf8 updateDemoModeState 
.const [79] = Utf8 (Z)V 
.const [80] = Utf8 setDemoStatus 
.const [81] = Utf8 (I)V 
.const [82] = Utf8 isDemoModeActive 
.const [83] = Utf8 ()Z 
.end class 
