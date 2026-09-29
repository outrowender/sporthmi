.version 50 0 
.class super [57] 
.super [59] 
.implements [61] 
.field private final [62] [63] 

.method [65] : [66] 
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
L1:     instanceof [2] 
L4:     ifeq L27 
L7:     aload_1 
L8:     checkcast [2] 
L11:    getfield [9] 
L14:    astore_3 
L15:    aload_2 
L16:    checkcast [2] 
L19:    getfield [9] 
L22:    astore 4 
L24:    goto L46 
L27:    aload_1 
L28:    checkcast [3] 
L31:    iconst_0 
L32:    invokevirtual [10] 
L35:    astore_3 
L36:    aload_2 
L37:    checkcast [3] 
L40:    iconst_0 
L41:    invokevirtual [10] 
L44:    astore 4 
L46:    aload_3 
L47:    ifnonnull L52 
L50:    iconst_1 
L51:    areturn 
L52:    aload 4 
L54:    ifnonnull L59 
L57:    iconst_m1 
L58:    areturn 
L59:    aload_0 
L60:    getfield [8] 
L63:    invokevirtual [11] 
L66:    aload_3 
L67:    aload 4 
L69:    invokevirtual [12] 
L72:    areturn 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
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
.const [9] = Field [23] [24] 
.const [10] = Method [25] [26] 
.const [11] = Method [27] [28] 
.const [12] = Method [29] [30] 
.const [13] = Method [31] [32] 
.const [14] = Field [33] [34] 
.const [15] = Utf8 org/dsi/ifc/sdars/CategoryInfo 
.const [16] = Utf8 de/audi/tuner/app/sdars/CategoryFilterRow 
.const [17] = Utf8 de/audi/tuner/app/sdars/SortAlgoCategory 
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
.const [35] = Utf8 de/audi/tuner/app/sdars/SortAlgoCategory 
.const [36] = Utf8 langMngr 
.const [37] = Utf8 Lde/audi/tuner/app/LanguageManager; 
.const [38] = Utf8 org/dsi/ifc/sdars/CategoryInfo 
.const [39] = Utf8 fullLabel 
.const [40] = Utf8 Ljava/lang/String; 
.const [41] = Utf8 de/audi/tuner/app/sdars/CategoryFilterRow 
.const [42] = Utf8 getText 
.const [43] = Utf8 (I)Ljava/lang/String; 
.const [44] = Utf8 de/audi/tuner/app/LanguageManager 
.const [45] = Utf8 getCollator 
.const [46] = Utf8 ()Ljava/text/Collator; 
.const [47] = Utf8 java/text/Collator 
.const [48] = Utf8 compare 
.const [49] = Utf8 (Ljava/lang/String;Ljava/lang/String;)I 
.const [50] = Utf8 java/lang/Object 
.const [51] = Utf8 <init> 
.const [52] = Utf8 ()V 
.const [53] = Utf8 de/audi/tuner/app/sdars/SortAlgoCategory 
.const [54] = Utf8 langMngr 
.const [55] = Utf8 Lde/audi/tuner/app/LanguageManager; 
.const [56] = Utf8 de/audi/tuner/app/sdars/SortAlgoCategory 
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
