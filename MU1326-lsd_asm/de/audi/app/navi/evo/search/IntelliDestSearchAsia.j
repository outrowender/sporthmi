.version 50 0 
.class public super [82] 
.super [84] 

.method public annotation [86] : [87] 
    .attribute [85] .code stack 9 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     iload 4 
L6:     aload 5 
L8:     aload 6 
L10:    aload 7 
L12:    aload 8 
L14:    invokespecial [16] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [88] : [89] 
    .attribute [85] .code stack 8 locals 1 
L0:     aload_0 
L1:     getfield [9] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_3 
L9:     aload_0 
L10:    getfield [10] 
L13:    ifeq L20 
L16:    iconst_1 
L17:    goto L21 
L20:    iconst_0 
L21:    i2l 
L22:    iload_2 
L23:    ifeq L30 
L26:    iconst_1 
L27:    goto L31 
L30:    iconst_0 
L31:    i2l 
L32:    invokevirtual [11] 
L35:    pop 
L36:    aload_0 
L37:    invokevirtual [12] 
L40:    istore 5 
L42:    iload_1 
L43:    iload 5 
L45:    if_icmpeq L66 
L48:    aload_0 
L49:    getfield [9] 
L52:    ldc [2] 
L54:    ldc [4] 
L56:    iload_1 
L57:    i2l 
L58:    iload 5 
L60:    i2l 
L61:    invokevirtual [13] 
L64:    pop 
L65:    return 
L66:    iload_2 
L67:    ifeq L102 
L70:    aload_0 
L71:    getfield [10] 
L74:    ifne L102 
L77:    aload_3 
L78:    getfield [14] 
L81:    iconst_2 
L82:    if_icmpne L102 
L85:    aload_0 
L86:    aload_3 
L87:    putfield [19] 
L90:    aload_0 
L91:    iload_2 
L92:    putfield [18] 
L95:    aload_0 
L96:    invokevirtual [15] 
L99:    goto L111 
L102:   aload_0 
L103:   iload_1 
L104:   iload_2 
L105:   aload_3 
L106:   iload 4 
L108:   invokespecial [17] 
L111:   return 
L112:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [20] 
.const [4] = String [21] 
.const [5] = Class [22] 
.const [6] = Class [23] 
.const [7] = Class [24] 
.const [8] = Class [25] 
.const [9] = Field [26] [27] 
.const [10] = Field [28] [29] 
.const [11] = Method [30] [31] 
.const [12] = Method [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Field [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Field [44] [45] 
.const [19] = Field [46] [47] 
.const [20] = Utf8 'IntelliDestSearchAsia#updatePotentialConflict conflictMatch=%1, conflictMode=%2, isConflict=%3, queryId=%4' 
.const [21] = Utf8 'IntelliDestSearch#updatePotentialConflict recveived conflict for queryId %1 but currentQuerryId is %2' 
.const [22] = Utf8 de/audi/app/navi/evo/search/IntelliDestSearchAsia 
.const [23] = Utf8 de/audi/app/navi/evo/search/IntelliDestSearch 
.const [24] = Utf8 de/audi/atip/log/LogChannel 
.const [25] = Utf8 org/dsi/ifc/search/ConflictMatch 
.const [26] = Class [48] 
.const [27] = NameAndType [49] [50] 
.const [28] = Class [51] 
.const [29] = NameAndType [52] [53] 
.const [30] = Class [54] 
.const [31] = NameAndType [55] [56] 
.const [32] = Class [57] 
.const [33] = NameAndType [58] [59] 
.const [34] = Class [60] 
.const [35] = NameAndType [61] [62] 
.const [36] = Class [63] 
.const [37] = NameAndType [64] [65] 
.const [38] = Class [66] 
.const [39] = NameAndType [67] [68] 
.const [40] = Class [69] 
.const [41] = NameAndType [70] [71] 
.const [42] = Class [72] 
.const [43] = NameAndType [73] [74] 
.const [44] = Class [75] 
.const [45] = NameAndType [76] [77] 
.const [46] = Class [78] 
.const [47] = NameAndType [79] [80] 
.const [48] = Utf8 de/audi/app/navi/evo/search/IntelliDestSearchAsia 
.const [49] = Utf8 logChannel 
.const [50] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [51] = Utf8 de/audi/app/navi/evo/search/IntelliDestSearchAsia 
.const [52] = Utf8 conflictMode 
.const [53] = Utf8 Z 
.const [54] = Utf8 de/audi/atip/log/LogChannel 
.const [55] = Utf8 log 
.const [56] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [57] = Utf8 de/audi/app/navi/evo/search/IntelliDestSearchAsia 
.const [58] = Utf8 getLastQueryID 
.const [59] = Utf8 ()I 
.const [60] = Utf8 de/audi/atip/log/LogChannel 
.const [61] = Utf8 log 
.const [62] = Utf8 (ILjava/lang/String;JJ)Z 
.const [63] = Utf8 org/dsi/ifc/search/ConflictMatch 
.const [64] = Utf8 type 
.const [65] = Utf8 I 
.const [66] = Utf8 de/audi/app/navi/evo/search/IntelliDestSearchAsia 
.const [67] = Utf8 restartSearch 
.const [68] = Utf8 ()V 
.const [69] = Utf8 de/audi/app/navi/evo/search/IntelliDestSearch 
.const [70] = Utf8 <init> 
.const [71] = Utf8 (Lde/audi/app/navi/evo/search/IntelliDestController;Lorg/osgi/framework/BundleContext;Lde/audi/atip/base/IFrameworkAccess;ILde/audi/tghu/navi/app/guidance/IVehicle;Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/search/LastDestSearch;)V 
.const [72] = Utf8 de/audi/app/navi/evo/search/IntelliDestSearch 
.const [73] = Utf8 updatePotentialConflict 
.const [74] = Utf8 (IZLorg/dsi/ifc/search/ConflictMatch;I)V 
.const [75] = Utf8 de/audi/app/navi/evo/search/IntelliDestSearchAsia 
.const [76] = Utf8 conflictMode 
.const [77] = Utf8 Z 
.const [78] = Utf8 de/audi/app/navi/evo/search/IntelliDestSearchAsia 
.const [79] = Utf8 lastConflictMatch 
.const [80] = Utf8 Lorg/dsi/ifc/search/ConflictMatch; 
.const [81] = Utf8 de/audi/app/navi/evo/search/IntelliDestSearchAsia 
.const [82] = Class [81] 
.const [83] = Utf8 de/audi/app/navi/evo/search/IntelliDestSearch 
.const [84] = Class [83] 
.const [85] = Utf8 Code 
.const [86] = Utf8 <init> 
.const [87] = Utf8 (Lde/audi/app/navi/evo/search/IntelliDestController;Lorg/osgi/framework/BundleContext;Lde/audi/atip/base/IFrameworkAccess;ILde/audi/tghu/navi/app/guidance/IVehicle;Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/search/LastDestSearch;)V 
.const [88] = Utf8 updatePotentialConflict 
.const [89] = Utf8 (IZLorg/dsi/ifc/search/ConflictMatch;I)V 
.end class 
