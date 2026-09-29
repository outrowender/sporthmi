.version 50 0 
.class public super [57] 
.super [59] 
.implements [61] 
.field private final [62] [63] 

.method public [65] : [66] 
    .attribute [64] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [14] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [67] : [68] 
    .attribute [64] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     iconst_m1 
L5:     areturn 
L6:     aload_2 
L7:     ifnonnull L12 
L10:    iconst_1 
L11:    areturn 
L12:    aload_1 
L13:    instanceof [2] 
L16:    ifeq L39 
L19:    aload_1 
L20:    checkcast [2] 
L23:    invokevirtual [9] 
L26:    astore_3 
L27:    aload_2 
L28:    checkcast [2] 
L31:    invokevirtual [9] 
L34:    astore 4 
L36:    goto L56 
L39:    aload_1 
L40:    checkcast [3] 
L43:    getfield [10] 
L46:    astore_3 
L47:    aload_2 
L48:    checkcast [3] 
L51:    getfield [10] 
L54:    astore 4 
L56:    aload_0 
L57:    getfield [8] 
L60:    invokevirtual [11] 
L63:    aload_3 
L64:    aload 4 
L66:    invokevirtual [12] 
L69:    areturn 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [15] 
.const [3] = Class [16] 
.const [4] = Class [17] 
.const [5] = Class [18] 
.const [6] = Class [19] 
.const [7] = Class [20] 
.const [8] = Field [21] [22] 
.const [9] = Method [23] [24] 
.const [10] = Field [25] [26] 
.const [11] = Method [27] [28] 
.const [12] = Method [29] [30] 
.const [13] = Method [31] [32] 
.const [14] = Field [33] [34] 
.const [15] = Utf8 de/audi/tuner/app/dab/DabStation 
.const [16] = Utf8 org/dsi/ifc/radio/EnsembleInfo 
.const [17] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorEnsemble 
.const [18] = Utf8 java/lang/Object 
.const [19] = Utf8 de/audi/tuner/app/LanguageManager 
.const [20] = Utf8 java/text/Collator 
.const [21] = Class [35] 
.const [22] = NameAndType [36] [37] 
.const [23] = Class [38] 
.const [24] = NameAndType [39] [40] 
.const [25] = Class [41] 
.const [26] = NameAndType [42] [43] 
.const [27] = Class [44] 
.const [28] = NameAndType [45] [46] 
.const [29] = Class [47] 
.const [30] = NameAndType [48] [49] 
.const [31] = Class [50] 
.const [32] = NameAndType [51] [52] 
.const [33] = Class [53] 
.const [34] = NameAndType [54] [55] 
.const [35] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorEnsemble 
.const [36] = Utf8 langMngr 
.const [37] = Utf8 Lde/audi/tuner/app/LanguageManager; 
.const [38] = Utf8 de/audi/tuner/app/dab/DabStation 
.const [39] = Utf8 getFullName 
.const [40] = Utf8 ()Ljava/lang/String; 
.const [41] = Utf8 org/dsi/ifc/radio/EnsembleInfo 
.const [42] = Utf8 fullName 
.const [43] = Utf8 Ljava/lang/String; 
.const [44] = Utf8 de/audi/tuner/app/LanguageManager 
.const [45] = Utf8 getCollator 
.const [46] = Utf8 ()Ljava/text/Collator; 
.const [47] = Utf8 java/text/Collator 
.const [48] = Utf8 compare 
.const [49] = Utf8 (Ljava/lang/String;Ljava/lang/String;)I 
.const [50] = Utf8 java/lang/Object 
.const [51] = Utf8 <init> 
.const [52] = Utf8 ()V 
.const [53] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorEnsemble 
.const [54] = Utf8 langMngr 
.const [55] = Utf8 Lde/audi/tuner/app/LanguageManager; 
.const [56] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorEnsemble 
.const [57] = Class [56] 
.const [58] = Utf8 java/lang/Object 
.const [59] = Class [58] 
.const [60] = Utf8 java/util/Comparator 
.const [61] = Class [60] 
.const [62] = Utf8 langMngr 
.const [63] = Utf8 Lde/audi/tuner/app/LanguageManager; 
.const [64] = Utf8 Code 
.const [65] = Utf8 <init> 
.const [66] = Utf8 (Lde/audi/tuner/app/LanguageManager;)V 
.const [67] = Utf8 compare 
.const [68] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)I 
.end class 
