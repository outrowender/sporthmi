.version 50 0 
.class public super [89] 
.super [91] 

.method public annotation [93] : [94] 
    .attribute [92] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [20] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [95] : [96] 
    .attribute [92] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     invokevirtual [15] 
L7:     ldc [2] 
L9:     ldc [3] 
L11:    aload_1 
L12:    invokevirtual [16] 
L15:    pop 
L16:    aload_0 
L17:    aload_1 
L18:    invokespecial [21] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected [97] : [98] 
    .attribute [92] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_2 
L2:     iload_1 
L3:     iconst_3 
L4:     if_icmpne L12 
L7:     iconst_0 
L8:     istore_2 
L9:     goto L30 
L12:    iload_1 
L13:    iconst_4 
L14:    if_icmpne L22 
L17:    iconst_1 
L18:    istore_2 
L19:    goto L30 
L22:    iload_1 
L23:    bipush 6 
L25:    if_icmpne L30 
L28:    iconst_2 
L29:    istore_2 
L30:    aload_0 
L31:    getfield [14] 
L34:    ldc [4] 
L36:    invokevirtual [17] 
L39:    invokeinterface [23] 0 
L44:    iload_2 
L45:    if_icmpeq L63 
L48:    aload_0 
L49:    getfield [14] 
L52:    ldc [4] 
L54:    invokevirtual [17] 
L57:    iload_2 
L58:    invokeinterface [24] 0 
L63:    return 
L64:    
    .end code 
.end method 

.method protected [99] : [100] 
    .attribute [92] .code stack 6 locals 1 
L0:     iload_1 
L1:     ifeq L8 
L4:     iconst_0 
L5:     goto L9 
L8:     iconst_1 
L9:     istore_2 
L10:    aload_0 
L11:    getfield [14] 
L14:    invokevirtual [15] 
L17:    ldc [2] 
L19:    ldc [5] 
L21:    iload_1 
L22:    iload_2 
L23:    i2l 
L24:    invokevirtual [18] 
L27:    pop 
L28:    aload_0 
L29:    getfield [14] 
L32:    ldc [6] 
L34:    invokevirtual [17] 
L37:    invokeinterface [23] 0 
L42:    iload_2 
L43:    if_icmpeq L61 
L46:    aload_0 
L47:    getfield [14] 
L50:    ldc [6] 
L52:    invokevirtual [17] 
L55:    iload_2 
L56:    invokeinterface [24] 0 
L61:    return 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method protected [101] : [102] 
    .attribute [92] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [14] 
L4:     invokevirtual [15] 
L7:     ldc [2] 
L9:     ldc [7] 
L11:    iload_1 
L12:    i2l 
L13:    invokevirtual [19] 
L16:    pop 
L17:    iconst_0 
L18:    istore_2 
L19:    iload_1 
L20:    iconst_3 
L21:    if_icmpne L29 
L24:    iconst_2 
L25:    istore_2 
L26:    goto L47 
L29:    iload_1 
L30:    bipush 6 
L32:    if_icmpne L40 
L35:    iconst_0 
L36:    istore_2 
L37:    goto L47 
L40:    iload_1 
L41:    iconst_5 
L42:    if_icmpne L47 
L45:    iconst_1 
L46:    istore_2 
L47:    aload_0 
L48:    getfield [14] 
L51:    ldc [8] 
L53:    invokevirtual [17] 
L56:    invokeinterface [23] 0 
L61:    iload_2 
L62:    if_icmpeq L80 
L65:    aload_0 
L66:    getfield [14] 
L69:    ldc [8] 
L71:    invokevirtual [17] 
L74:    iload_2 
L75:    invokeinterface [24] 0 
L80:    return 
L81:    nop 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method protected [103] : [104] 
    .attribute [92] .code stack 2 locals 1 
L0:     iconst_1 
L1:     istore_2 
L2:     iload_1 
L3:     iconst_1 
L4:     if_icmpne L12 
L7:     iconst_1 
L8:     istore_2 
L9:     goto L29 
L12:    iload_1 
L13:    iconst_2 
L14:    if_icmpne L22 
L17:    iconst_2 
L18:    istore_2 
L19:    goto L29 
L22:    iload_1 
L23:    iconst_3 
L24:    if_icmpne L29 
L27:    iconst_0 
L28:    istore_2 
L29:    aload_0 
L30:    iload_2 
L31:    invokespecial [22] 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [25] 
.const [4] = Int -14875136 
.const [5] = String [26] 
.const [6] = Int -2145122816 
.const [7] = String [27] 
.const [8] = Int 1967616 
.const [9] = Class [28] 
.const [10] = Class [29] 
.const [11] = Class [30] 
.const [12] = Class [31] 
.const [13] = Class [32] 
.const [14] = Field [33] [34] 
.const [15] = Method [35] [36] 
.const [16] = Method [37] [38] 
.const [17] = Method [39] [40] 
.const [18] = Method [41] [42] 
.const [19] = Method [43] [44] 
.const [20] = Method [45] [46] 
.const [21] = Method [47] [48] 
.const [22] = Method [49] [50] 
.const [23] = InterfaceMethod [51] [52] 
.const [24] = InterfaceMethod [53] [54] 
.const [25] = Utf8 'RouteCriteriaModelAccess#onStart() - %1' 
.const [26] = Utf8 'RouteCriteriaModelAccess#setFreewaysModel(%1) - choice: %2' 
.const [27] = Utf8 'RouteCriteriaModelAccess#setTrailerModel(%1) - mode: %1' 
.const [28] = Utf8 de/audi/app/navi/evo/setup/RouteCriteriaModelAccess 
.const [29] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [30] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [31] = Utf8 de/audi/atip/log/LogChannel 
.const [32] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
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
.const [43] = Class [70] 
.const [44] = NameAndType [71] [72] 
.const [45] = Class [73] 
.const [46] = NameAndType [74] [75] 
.const [47] = Class [76] 
.const [48] = NameAndType [77] [78] 
.const [49] = Class [79] 
.const [50] = NameAndType [80] [81] 
.const [51] = Class [82] 
.const [52] = NameAndType [83] [84] 
.const [53] = Class [85] 
.const [54] = NameAndType [86] [87] 
.const [55] = Utf8 de/audi/app/navi/evo/setup/RouteCriteriaModelAccess 
.const [56] = Utf8 env 
.const [57] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [58] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [59] = Utf8 getLogChannel 
.const [60] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [61] = Utf8 de/audi/atip/log/LogChannel 
.const [62] = Utf8 log 
.const [63] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [64] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [65] = Utf8 getChoiceModel 
.const [66] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [67] = Utf8 de/audi/atip/log/LogChannel 
.const [68] = Utf8 log 
.const [69] = Utf8 (ILjava/lang/String;ZJ)Z 
.const [70] = Utf8 de/audi/atip/log/LogChannel 
.const [71] = Utf8 log 
.const [72] = Utf8 (ILjava/lang/String;J)Z 
.const [73] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [74] = Utf8 <init> 
.const [75] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [76] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [77] = Utf8 onUpdateCriteria 
.const [78] = Utf8 (Lde/audi/tghu/navi/app/setup/IRouteCriteria;)V 
.const [79] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [80] = Utf8 setSeasonalRestricted 
.const [81] = Utf8 (I)V 
.const [82] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [83] = Utf8 getValue 
.const [84] = Utf8 ()I 
.const [85] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [86] = Utf8 setValue 
.const [87] = Utf8 (I)V 
.const [88] = Utf8 de/audi/app/navi/evo/setup/RouteCriteriaModelAccess 
.const [89] = Class [88] 
.const [90] = Utf8 de/audi/app/navi/setup/RouteCriterialCoreModelAccess 
.const [91] = Class [90] 
.const [92] = Utf8 Code 
.const [93] = Utf8 <init> 
.const [94] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [95] = Utf8 onStart 
.const [96] = Utf8 (Lde/audi/tghu/navi/app/setup/IRouteCriteria;)V 
.const [97] = Utf8 setTrafficReroutingModel 
.const [98] = Utf8 (I)V 
.const [99] = Utf8 setFreewaysModel 
.const [100] = Utf8 (Z)V 
.const [101] = Utf8 setTrailerModel 
.const [102] = Utf8 (I)V 
.const [103] = Utf8 setSeasonalRestricted 
.const [104] = Utf8 (I)V 
.end class 
