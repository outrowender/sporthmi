.version 50 0 
.class public super [99] 
.super [101] 
.field private [102] [103] 

.method public [105] : [106] 
    .attribute [104] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [16] 
L5:     aload_0 
L6:     iconst_m1 
L7:     putfield [17] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [107] : [108] 
    .attribute [104] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [9] 
L4:     invokeinterface [18] 0 
L9:     bipush 16 
L11:    bipush 41 
L13:    invokeinterface [19] 0 
L18:    pop 
L19:    return 
L20:    
    .end code 
.end method 

.method protected [109] : [110] 
    .attribute [104] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [9] 
L4:     invokeinterface [18] 0 
L9:     bipush 16 
L11:    invokeinterface [20] 0 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [111] : [112] 
    .attribute [104] .code stack 4 locals 0 
L0:     aload_1 
L1:     invokevirtual [10] 
L4:     ifnull L53 
L7:     aload_1 
L8:     invokevirtual [10] 
L11:    getfield [11] 
L14:    iconst_3 
L15:    if_icmpne L53 
L18:    aload_0 
L19:    getfield [8] 
L22:    iconst_1 
L23:    if_icmpne L123 
L26:    aload_0 
L27:    invokevirtual [9] 
L30:    invokeinterface [18] 0 
L35:    bipush 16 
L37:    aload_0 
L38:    aload_1 
L39:    getfield [12] 
L42:    invokevirtual [13] 
L45:    invokeinterface [21] 0 
L50:    goto L123 
L53:    aload_1 
L54:    invokevirtual [10] 
L57:    ifnull L106 
L60:    aload_1 
L61:    invokevirtual [10] 
L64:    getfield [14] 
L67:    iconst_3 
L68:    if_icmpne L106 
L71:    aload_0 
L72:    getfield [8] 
L75:    iconst_1 
L76:    if_icmpne L123 
L79:    aload_0 
L80:    invokevirtual [9] 
L83:    invokeinterface [18] 0 
L88:    bipush 16 
L90:    aload_0 
L91:    aload_1 
L92:    getfield [15] 
L95:    invokevirtual [13] 
L98:    invokeinterface [21] 0 
L103:   goto L123 
L106:   aload_0 
L107:   invokevirtual [9] 
L110:   invokeinterface [18] 0 
L115:   bipush 16 
L117:   iconst_1 
L118:   invokeinterface [21] 0 
L123:   return 
L124:   
    .end code 
.end method 

.method protected [113] : [114] 
    .attribute [104] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [17] 
L5:     iload_1 
L6:     iconst_1 
L7:     if_icmpne L30 
L10:    aload_0 
L11:    invokevirtual [9] 
L14:    invokeinterface [18] 0 
L19:    bipush 16 
L21:    iconst_0 
L22:    invokeinterface [21] 0 
L27:    goto L47 
L30:    aload_0 
L31:    invokevirtual [9] 
L34:    invokeinterface [18] 0 
L39:    bipush 16 
L41:    iconst_1 
L42:    invokeinterface [21] 0 
L47:    return 
L48:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [104] .code stack 1 locals 0 
L0:     bipush 11 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [22] 
.const [3] = Class [23] 
.const [4] = Class [24] 
.const [5] = Class [25] 
.const [6] = Class [26] 
.const [7] = Class [27] 
.const [8] = Field [28] [29] 
.const [9] = Method [30] [31] 
.const [10] = Method [32] [33] 
.const [11] = Field [34] [35] 
.const [12] = Field [36] [37] 
.const [13] = Method [38] [39] 
.const [14] = Field [40] [41] 
.const [15] = Field [42] [43] 
.const [16] = Method [44] [45] 
.const [17] = Field [46] [47] 
.const [18] = InterfaceMethod [48] [49] 
.const [19] = InterfaceMethod [50] [51] 
.const [20] = InterfaceMethod [52] [53] 
.const [21] = InterfaceMethod [54] [55] 
.const [22] = Utf8 de/audi/app/earlyfunc/hybrid/TargetRangeComponentEvo 
.const [23] = Utf8 de/audi/app/earlyfunc/core/hybrid/AbstractTargetRangeComponent 
.const [24] = Utf8 de/audi/app/car/common/app/ICarApplication 
.const [25] = Utf8 de/audi/app/car/common/mer/IMenuEntryRegistry 
.const [26] = Utf8 org/dsi/ifc/carkombi/BCViewOptions 
.const [27] = Utf8 org/dsi/ifc/carkombi/BCConfiguration 
.const [28] = Class [56] 
.const [29] = NameAndType [57] [58] 
.const [30] = Class [59] 
.const [31] = NameAndType [60] [61] 
.const [32] = Class [62] 
.const [33] = NameAndType [63] [64] 
.const [34] = Class [65] 
.const [35] = NameAndType [66] [67] 
.const [36] = Class [68] 
.const [37] = NameAndType [69] [70] 
.const [38] = Class [71] 
.const [39] = NameAndType [72] [73] 
.const [40] = Class [74] 
.const [41] = NameAndType [75] [76] 
.const [42] = Class [77] 
.const [43] = NameAndType [78] [79] 
.const [44] = Class [80] 
.const [45] = NameAndType [81] [82] 
.const [46] = Class [83] 
.const [47] = NameAndType [84] [85] 
.const [48] = Class [86] 
.const [49] = NameAndType [87] [88] 
.const [50] = Class [89] 
.const [51] = NameAndType [90] [91] 
.const [52] = Class [92] 
.const [53] = NameAndType [93] [94] 
.const [54] = Class [95] 
.const [55] = NameAndType [96] [97] 
.const [56] = Utf8 de/audi/app/earlyfunc/hybrid/TargetRangeComponentEvo 
.const [57] = Utf8 currentState 
.const [58] = Utf8 I 
.const [59] = Utf8 de/audi/app/earlyfunc/hybrid/TargetRangeComponentEvo 
.const [60] = Utf8 getApplication 
.const [61] = Utf8 ()Lde/audi/app/car/common/app/ICarApplication; 
.const [62] = Utf8 org/dsi/ifc/carkombi/BCViewOptions 
.const [63] = Utf8 getConfiguration 
.const [64] = Utf8 ()Lorg/dsi/ifc/carkombi/BCConfiguration; 
.const [65] = Utf8 org/dsi/ifc/carkombi/BCConfiguration 
.const [66] = Utf8 primaryEngineType 
.const [67] = Utf8 I 
.const [68] = Utf8 org/dsi/ifc/carkombi/BCViewOptions 
.const [69] = Utf8 currentRange1 
.const [70] = Utf8 Lorg/dsi/ifc/global/CarViewOption; 
.const [71] = Utf8 de/audi/app/earlyfunc/hybrid/TargetRangeComponentEvo 
.const [72] = Utf8 getMenuEntryVisibilityState 
.const [73] = Utf8 (Lorg/dsi/ifc/global/CarViewOption;)I 
.const [74] = Utf8 org/dsi/ifc/carkombi/BCConfiguration 
.const [75] = Utf8 secondaryEngineType 
.const [76] = Utf8 I 
.const [77] = Utf8 org/dsi/ifc/carkombi/BCViewOptions 
.const [78] = Utf8 currentRange2 
.const [79] = Utf8 Lorg/dsi/ifc/global/CarViewOption; 
.const [80] = Utf8 de/audi/app/earlyfunc/core/hybrid/AbstractTargetRangeComponent 
.const [81] = Utf8 <init> 
.const [82] = Utf8 (Lde/audi/app/car/common/app/ICarApplication;)V 
.const [83] = Utf8 de/audi/app/earlyfunc/hybrid/TargetRangeComponentEvo 
.const [84] = Utf8 currentState 
.const [85] = Utf8 I 
.const [86] = Utf8 de/audi/app/car/common/app/ICarApplication 
.const [87] = Utf8 getMenuEntryRegistry 
.const [88] = Utf8 ()Lde/audi/app/car/common/mer/IMenuEntryRegistry; 
.const [89] = Utf8 de/audi/app/car/common/mer/IMenuEntryRegistry 
.const [90] = Utf8 registerMenuEntry 
.const [91] = Utf8 (IS)Lde/audi/app/car/common/mer/IMenuEntry; 
.const [92] = Utf8 de/audi/app/car/common/mer/IMenuEntryRegistry 
.const [93] = Utf8 deregisterMenuEntry 
.const [94] = Utf8 (I)V 
.const [95] = Utf8 de/audi/app/car/common/mer/IMenuEntryRegistry 
.const [96] = Utf8 updateMenuEntryVisibility 
.const [97] = Utf8 (II)V 
.const [98] = Utf8 de/audi/app/earlyfunc/hybrid/TargetRangeComponentEvo 
.const [99] = Class [98] 
.const [100] = Utf8 de/audi/app/earlyfunc/core/hybrid/AbstractTargetRangeComponent 
.const [101] = Class [100] 
.const [102] = Utf8 currentState 
.const [103] = Utf8 I 
.const [104] = Utf8 Code 
.const [105] = Utf8 <init> 
.const [106] = Utf8 (Lde/audi/app/car/common/app/ICarApplication;)V 
.const [107] = Utf8 initVisibility 
.const [108] = Utf8 ()V 
.const [109] = Utf8 deinitVisibility 
.const [110] = Utf8 ()V 
.const [111] = Utf8 updateMenuEntryVisibility 
.const [112] = Utf8 (Lorg/dsi/ifc/carkombi/BCViewOptions;)V 
.const [113] = Utf8 updateVisibilityForRangeAtStateChange 
.const [114] = Utf8 (I)V 
.const [115] = Utf8 getID 
.const [116] = Utf8 ()I 
.end class 
