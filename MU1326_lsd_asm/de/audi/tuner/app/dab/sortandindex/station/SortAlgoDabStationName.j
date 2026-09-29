.version 50 0 
.class public super [81] 
.super [83] 

.method public [85] : [86] 
    .attribute [84] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     invokespecial [18] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [87] : [88] 
    .attribute [84] .code stack 1 locals 0 
L0:     aload_1 
L1:     invokevirtual [8] 
L4:     ifeq L15 
L7:     aload_1 
L8:     getfield [9] 
L11:    getfield [10] 
L14:    areturn 
L15:    aconst_null 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [89] : [90] 
    .attribute [84] .code stack 4 locals 1 
L0:     aload_1 
L1:     getfield [9] 
L4:     getfield [11] 
L7:     aload_2 
L8:     getfield [9] 
L11:    getfield [11] 
L14:    lcmp 
L15:    ifne L117 
L18:    aload_1 
L19:    invokevirtual [12] 
L22:    ifeq L51 
L25:    aload_2 
L26:    invokevirtual [12] 
L29:    ifeq L51 
L32:    aload_3 
L33:    aload_1 
L34:    getfield [13] 
L37:    getfield [14] 
L40:    aload_2 
L41:    getfield [13] 
L44:    getfield [14] 
L47:    invokevirtual [15] 
L50:    areturn 
L51:    aload_1 
L52:    invokevirtual [12] 
L55:    ifeq L60 
L58:    iconst_1 
L59:    areturn 
L60:    aload_2 
L61:    invokevirtual [12] 
L64:    ifeq L69 
L67:    iconst_m1 
L68:    areturn 
L69:    aload_3 
L70:    aload_1 
L71:    getfield [9] 
L74:    getfield [10] 
L77:    aload_2 
L78:    getfield [9] 
L81:    getfield [10] 
L84:    invokevirtual [15] 
L87:    istore 4 
L89:    iload 4 
L91:    ifne L114 
L94:    aload_3 
L95:    aload_1 
L96:    getfield [16] 
L99:    getfield [17] 
L102:   aload_2 
L103:   getfield [16] 
L106:   getfield [17] 
L109:   invokevirtual [15] 
L112:   istore 4 
L114:   iload 4 
L116:   areturn 
L117:   aload_3 
L118:   aload_1 
L119:   getfield [9] 
L122:   getfield [10] 
L125:   aload_2 
L126:   getfield [9] 
L129:   getfield [10] 
L132:   invokevirtual [15] 
L135:   areturn 
L136:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [19] 
.const [3] = Class [20] 
.const [4] = Class [21] 
.const [5] = Class [22] 
.const [6] = Class [23] 
.const [7] = Class [24] 
.const [8] = Method [25] [26] 
.const [9] = Field [27] [28] 
.const [10] = Field [29] [30] 
.const [11] = Field [31] [32] 
.const [12] = Method [33] [34] 
.const [13] = Field [35] [36] 
.const [14] = Field [37] [38] 
.const [15] = Method [39] [40] 
.const [16] = Field [41] [42] 
.const [17] = Field [43] [44] 
.const [18] = Method [45] [46] 
.const [19] = Utf8 de/audi/tuner/app/dab/sortandindex/station/AbstractDabStationComparatorAndIndexer 
.const [20] = Utf8 de/audi/tuner/app/dab/DabStation 
.const [21] = Utf8 org/dsi/ifc/radio/ServiceInfo 
.const [22] = Utf8 org/dsi/ifc/radio/ComponentInfo 
.const [23] = Utf8 java/text/Collator 
.const [24] = Utf8 org/dsi/ifc/radio/EnsembleInfo 
.const [25] = Class [47] 
.const [26] = NameAndType [48] [49] 
.const [27] = Class [50] 
.const [28] = NameAndType [51] [52] 
.const [29] = Class [53] 
.const [30] = NameAndType [54] [55] 
.const [31] = Class [56] 
.const [32] = NameAndType [57] [58] 
.const [33] = Class [59] 
.const [34] = NameAndType [60] [61] 
.const [35] = Class [62] 
.const [36] = NameAndType [63] [64] 
.const [37] = Class [65] 
.const [38] = NameAndType [66] [67] 
.const [39] = Class [68] 
.const [40] = NameAndType [69] [70] 
.const [41] = Class [71] 
.const [42] = NameAndType [72] [73] 
.const [43] = Class [74] 
.const [44] = NameAndType [75] [76] 
.const [45] = Class [77] 
.const [46] = NameAndType [78] [79] 
.const [47] = Utf8 de/audi/tuner/app/dab/DabStation 
.const [48] = Utf8 isService 
.const [49] = Utf8 ()Z 
.const [50] = Utf8 de/audi/tuner/app/dab/DabStation 
.const [51] = Utf8 service 
.const [52] = Utf8 Lorg/dsi/ifc/radio/ServiceInfo; 
.const [53] = Utf8 org/dsi/ifc/radio/ServiceInfo 
.const [54] = Utf8 fullName 
.const [55] = Utf8 Ljava/lang/String; 
.const [56] = Utf8 org/dsi/ifc/radio/ServiceInfo 
.const [57] = Utf8 sID 
.const [58] = Utf8 J 
.const [59] = Utf8 de/audi/tuner/app/dab/DabStation 
.const [60] = Utf8 isComponent 
.const [61] = Utf8 ()Z 
.const [62] = Utf8 de/audi/tuner/app/dab/DabStation 
.const [63] = Utf8 component 
.const [64] = Utf8 Lorg/dsi/ifc/radio/ComponentInfo; 
.const [65] = Utf8 org/dsi/ifc/radio/ComponentInfo 
.const [66] = Utf8 fullName 
.const [67] = Utf8 Ljava/lang/String; 
.const [68] = Utf8 java/text/Collator 
.const [69] = Utf8 compare 
.const [70] = Utf8 (Ljava/lang/String;Ljava/lang/String;)I 
.const [71] = Utf8 de/audi/tuner/app/dab/DabStation 
.const [72] = Utf8 ensemble 
.const [73] = Utf8 Lorg/dsi/ifc/radio/EnsembleInfo; 
.const [74] = Utf8 org/dsi/ifc/radio/EnsembleInfo 
.const [75] = Utf8 fullName 
.const [76] = Utf8 Ljava/lang/String; 
.const [77] = Utf8 de/audi/tuner/app/dab/sortandindex/station/AbstractDabStationComparatorAndIndexer 
.const [78] = Utf8 <init> 
.const [79] = Utf8 (Lde/audi/tuner/app/LanguageManager;Z)V 
.const [80] = Utf8 de/audi/tuner/app/dab/sortandindex/station/SortAlgoDabStationName 
.const [81] = Class [80] 
.const [82] = Utf8 de/audi/tuner/app/dab/sortandindex/station/AbstractDabStationComparatorAndIndexer 
.const [83] = Class [82] 
.const [84] = Utf8 Code 
.const [85] = Utf8 <init> 
.const [86] = Utf8 (Lde/audi/tuner/app/LanguageManager;)V 
.const [87] = Utf8 getStringUsedForIndexing 
.const [88] = Utf8 (Lde/audi/tuner/app/dab/DabStation;)Ljava/lang/String; 
.const [89] = Utf8 compare 
.const [90] = Utf8 (Lde/audi/tuner/app/dab/DabStation;Lde/audi/tuner/app/dab/DabStation;Ljava/text/Collator;)I 
.end class 
