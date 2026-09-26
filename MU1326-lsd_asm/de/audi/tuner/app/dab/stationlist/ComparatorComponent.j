.version 50 0 
.class public super [75] 
.super [77] 
.implements [79] 
.field private final [80] [81] 

.method public [83] : [84] 
    .attribute [82] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [17] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [85] : [86] 
    .attribute [82] .code stack 5 locals 3 
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
L23:    getfield [9] 
L26:    astore_3 
L27:    aload_2 
L28:    checkcast [2] 
L31:    getfield [9] 
L34:    astore 4 
L36:    goto L50 
L39:    aload_1 
L40:    checkcast [3] 
L43:    astore_3 
L44:    aload_2 
L45:    checkcast [3] 
L48:    astore 4 
L50:    aload_0 
L51:    getfield [8] 
L54:    invokevirtual [10] 
L57:    aload_3 
L58:    invokevirtual [11] 
L61:    aload 4 
L63:    invokevirtual [11] 
L66:    invokevirtual [12] 
L69:    istore 5 
L71:    iload 5 
L73:    ifne L112 
L76:    aload_0 
L77:    aload_3 
L78:    invokevirtual [13] 
L81:    aload 4 
L83:    invokevirtual [13] 
L86:    invokespecial [16] 
L89:    istore 5 
L91:    iload 5 
L93:    ifne L112 
L96:    aload_0 
L97:    aload_3 
L98:    invokevirtual [14] 
L101:   i2l 
L102:   aload 4 
L104:   invokevirtual [14] 
L107:   i2l 
L108:   invokespecial [16] 
L111:   areturn 
L112:   iload 5 
L114:   areturn 
L115:   nop 
L116:   
    .end code 
.end method 

.method private [87] : [88] 
    .attribute [82] .code stack 4 locals 0 
L0:     lload_1 
L1:     lload_3 
L2:     lcmp 
L3:     ifge L8 
L6:     iconst_m1 
L7:     areturn 
L8:     lload_1 
L9:     lload_3 
L10:    lcmp 
L11:    ifle L16 
L14:    iconst_1 
L15:    areturn 
L16:    iconst_0 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [18] 
.const [3] = Class [19] 
.const [4] = Class [20] 
.const [5] = Class [21] 
.const [6] = Class [22] 
.const [7] = Class [23] 
.const [8] = Field [24] [25] 
.const [9] = Field [26] [27] 
.const [10] = Method [28] [29] 
.const [11] = Method [30] [31] 
.const [12] = Method [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Field [42] [43] 
.const [18] = Utf8 de/audi/tuner/app/dab/DabStation 
.const [19] = Utf8 org/dsi/ifc/radio/ComponentInfo 
.const [20] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorComponent 
.const [21] = Utf8 java/lang/Object 
.const [22] = Utf8 de/audi/tuner/app/LanguageManager 
.const [23] = Utf8 java/text/Collator 
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
.const [38] = Class [65] 
.const [39] = NameAndType [66] [67] 
.const [40] = Class [68] 
.const [41] = NameAndType [69] [70] 
.const [42] = Class [71] 
.const [43] = NameAndType [72] [73] 
.const [44] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorComponent 
.const [45] = Utf8 langMngr 
.const [46] = Utf8 Lde/audi/tuner/app/LanguageManager; 
.const [47] = Utf8 de/audi/tuner/app/dab/DabStation 
.const [48] = Utf8 component 
.const [49] = Utf8 Lorg/dsi/ifc/radio/ComponentInfo; 
.const [50] = Utf8 de/audi/tuner/app/LanguageManager 
.const [51] = Utf8 getCollator 
.const [52] = Utf8 ()Ljava/text/Collator; 
.const [53] = Utf8 org/dsi/ifc/radio/ComponentInfo 
.const [54] = Utf8 getFullName 
.const [55] = Utf8 ()Ljava/lang/String; 
.const [56] = Utf8 java/text/Collator 
.const [57] = Utf8 compare 
.const [58] = Utf8 (Ljava/lang/String;Ljava/lang/String;)I 
.const [59] = Utf8 org/dsi/ifc/radio/ComponentInfo 
.const [60] = Utf8 getSID 
.const [61] = Utf8 ()J 
.const [62] = Utf8 org/dsi/ifc/radio/ComponentInfo 
.const [63] = Utf8 getEnsID 
.const [64] = Utf8 ()I 
.const [65] = Utf8 java/lang/Object 
.const [66] = Utf8 <init> 
.const [67] = Utf8 ()V 
.const [68] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorComponent 
.const [69] = Utf8 compare 
.const [70] = Utf8 (JJ)I 
.const [71] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorComponent 
.const [72] = Utf8 langMngr 
.const [73] = Utf8 Lde/audi/tuner/app/LanguageManager; 
.const [74] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorComponent 
.const [75] = Class [74] 
.const [76] = Utf8 java/lang/Object 
.const [77] = Class [76] 
.const [78] = Utf8 java/util/Comparator 
.const [79] = Class [78] 
.const [80] = Utf8 langMngr 
.const [81] = Utf8 Lde/audi/tuner/app/LanguageManager; 
.const [82] = Utf8 Code 
.const [83] = Utf8 <init> 
.const [84] = Utf8 (Lde/audi/tuner/app/LanguageManager;)V 
.const [85] = Utf8 compare 
.const [86] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)I 
.const [87] = Utf8 compare 
.const [88] = Utf8 (JJ)I 
.end class 
