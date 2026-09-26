.version 50 0 
.class public super [69] 
.super [71] 
.implements [73] 
.field private final [74] [75] 

.method public [77] : [78] 
    .attribute [76] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [16] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [79] : [80] 
    .attribute [76] .code stack 3 locals 3 
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
L73:    ifne L90 
L76:    aload_0 
L77:    aload_3 
L78:    invokevirtual [13] 
L81:    aload 4 
L83:    invokevirtual [13] 
L86:    invokespecial [15] 
L89:    areturn 
L90:    iload 5 
L92:    areturn 
L93:    nop 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method private [81] : [82] 
    .attribute [76] .code stack 2 locals 0 
L0:     iload_1 
L1:     iload_2 
L2:     if_icmpge L7 
L5:     iconst_m1 
L6:     areturn 
L7:     iload_1 
L8:     iload_2 
L9:     if_icmple L14 
L12:    iconst_1 
L13:    areturn 
L14:    iconst_0 
L15:    areturn 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [17] 
.const [3] = Class [18] 
.const [4] = Class [19] 
.const [5] = Class [20] 
.const [6] = Class [21] 
.const [7] = Class [22] 
.const [8] = Field [23] [24] 
.const [9] = Field [25] [26] 
.const [10] = Method [27] [28] 
.const [11] = Method [29] [30] 
.const [12] = Method [31] [32] 
.const [13] = Method [33] [34] 
.const [14] = Method [35] [36] 
.const [15] = Method [37] [38] 
.const [16] = Field [39] [40] 
.const [17] = Utf8 de/audi/tuner/app/dab/DabStation 
.const [18] = Utf8 org/dsi/ifc/radio/ServiceInfo 
.const [19] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorService 
.const [20] = Utf8 java/lang/Object 
.const [21] = Utf8 de/audi/tuner/app/LanguageManager 
.const [22] = Utf8 java/text/Collator 
.const [23] = Class [41] 
.const [24] = NameAndType [42] [43] 
.const [25] = Class [44] 
.const [26] = NameAndType [45] [46] 
.const [27] = Class [47] 
.const [28] = NameAndType [48] [49] 
.const [29] = Class [50] 
.const [30] = NameAndType [51] [52] 
.const [31] = Class [53] 
.const [32] = NameAndType [54] [55] 
.const [33] = Class [56] 
.const [34] = NameAndType [57] [58] 
.const [35] = Class [59] 
.const [36] = NameAndType [60] [61] 
.const [37] = Class [62] 
.const [38] = NameAndType [63] [64] 
.const [39] = Class [65] 
.const [40] = NameAndType [66] [67] 
.const [41] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorService 
.const [42] = Utf8 langMngr 
.const [43] = Utf8 Lde/audi/tuner/app/LanguageManager; 
.const [44] = Utf8 de/audi/tuner/app/dab/DabStation 
.const [45] = Utf8 service 
.const [46] = Utf8 Lorg/dsi/ifc/radio/ServiceInfo; 
.const [47] = Utf8 de/audi/tuner/app/LanguageManager 
.const [48] = Utf8 getCollator 
.const [49] = Utf8 ()Ljava/text/Collator; 
.const [50] = Utf8 org/dsi/ifc/radio/ServiceInfo 
.const [51] = Utf8 getFullName 
.const [52] = Utf8 ()Ljava/lang/String; 
.const [53] = Utf8 java/text/Collator 
.const [54] = Utf8 compare 
.const [55] = Utf8 (Ljava/lang/String;Ljava/lang/String;)I 
.const [56] = Utf8 org/dsi/ifc/radio/ServiceInfo 
.const [57] = Utf8 getEnsID 
.const [58] = Utf8 ()I 
.const [59] = Utf8 java/lang/Object 
.const [60] = Utf8 <init> 
.const [61] = Utf8 ()V 
.const [62] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorService 
.const [63] = Utf8 compare 
.const [64] = Utf8 (II)I 
.const [65] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorService 
.const [66] = Utf8 langMngr 
.const [67] = Utf8 Lde/audi/tuner/app/LanguageManager; 
.const [68] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorService 
.const [69] = Class [68] 
.const [70] = Utf8 java/lang/Object 
.const [71] = Class [70] 
.const [72] = Utf8 java/util/Comparator 
.const [73] = Class [72] 
.const [74] = Utf8 langMngr 
.const [75] = Utf8 Lde/audi/tuner/app/LanguageManager; 
.const [76] = Utf8 Code 
.const [77] = Utf8 <init> 
.const [78] = Utf8 (Lde/audi/tuner/app/LanguageManager;)V 
.const [79] = Utf8 compare 
.const [80] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)I 
.const [81] = Utf8 compare 
.const [82] = Utf8 (II)I 
.end class 
