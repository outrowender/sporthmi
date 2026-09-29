.version 50 0 
.class public super [79] 
.super [81] 
.implements [83] 
.field private final [84] [85] 

.method public [87] : [88] 
    .attribute [86] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [19] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [89] : [90] 
    .attribute [86] .code stack 3 locals 4 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     iconst_m1 
L5:     areturn 
L6:     aload_2 
L7:     ifnonnull L12 
L10:    iconst_1 
L11:    areturn 
L12:    aload_1 
L13:    checkcast [2] 
L16:    astore_3 
L17:    aload_2 
L18:    checkcast [2] 
L21:    astore 4 
L23:    ldc [3] 
L25:    astore 5 
L27:    ldc [3] 
L29:    astore 6 
L31:    aload_3 
L32:    invokevirtual [11] 
L35:    iconst_2 
L36:    if_icmpne L51 
L39:    aload_3 
L40:    getfield [12] 
L43:    invokevirtual [13] 
L46:    astore 5 
L48:    goto L68 
L51:    aload_3 
L52:    invokevirtual [11] 
L55:    iconst_3 
L56:    if_icmpne L68 
L59:    aload_3 
L60:    getfield [14] 
L63:    invokevirtual [15] 
L66:    astore 5 
L68:    aload 4 
L70:    invokevirtual [11] 
L73:    iconst_2 
L74:    if_icmpne L90 
L77:    aload 4 
L79:    getfield [12] 
L82:    invokevirtual [13] 
L85:    astore 6 
L87:    goto L109 
L90:    aload 4 
L92:    invokevirtual [11] 
L95:    iconst_3 
L96:    if_icmpne L109 
L99:    aload 4 
L101:   getfield [14] 
L104:   invokevirtual [15] 
L107:   astore 6 
L109:   aload_0 
L110:   getfield [10] 
L113:   invokevirtual [16] 
L116:   aload 5 
L118:   aload 6 
L120:   invokevirtual [17] 
L123:   areturn 
L124:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [20] 
.const [3] = String [21] 
.const [4] = Class [22] 
.const [5] = Class [23] 
.const [6] = Class [24] 
.const [7] = Class [25] 
.const [8] = Class [26] 
.const [9] = Class [27] 
.const [10] = Field [28] [29] 
.const [11] = Method [30] [31] 
.const [12] = Field [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Field [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Method [44] [45] 
.const [19] = Field [46] [47] 
.const [20] = Utf8 de/audi/tuner/app/dab/DabStation 
.const [21] = Utf8 '' 
.const [22] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorFlatList 
.const [23] = Utf8 java/lang/Object 
.const [24] = Utf8 org/dsi/ifc/radio/ServiceInfo 
.const [25] = Utf8 org/dsi/ifc/radio/ComponentInfo 
.const [26] = Utf8 de/audi/tuner/app/LanguageManager 
.const [27] = Utf8 java/text/Collator 
.const [28] = Class [48] 
.const [29] = NameAndType [49] [50] 
.const [30] = Class [51] 
.const [31] = NameAndType [52] [53] 
.const [32] = Class [54] 
.const [33] = NameAndType [55] [56] 
.const [34] = Class [57] 
.const [35] = NameAndType [58] [59] 
.const [36] = Class [60] 
.const [37] = NameAndType [61] [62] 
.const [38] = Class [63] 
.const [39] = NameAndType [64] [65] 
.const [40] = Class [66] 
.const [41] = NameAndType [67] [68] 
.const [42] = Class [69] 
.const [43] = NameAndType [70] [71] 
.const [44] = Class [72] 
.const [45] = NameAndType [73] [74] 
.const [46] = Class [75] 
.const [47] = NameAndType [76] [77] 
.const [48] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorFlatList 
.const [49] = Utf8 langMngr 
.const [50] = Utf8 Lde/audi/tuner/app/LanguageManager; 
.const [51] = Utf8 de/audi/tuner/app/dab/DabStation 
.const [52] = Utf8 getType 
.const [53] = Utf8 ()I 
.const [54] = Utf8 de/audi/tuner/app/dab/DabStation 
.const [55] = Utf8 service 
.const [56] = Utf8 Lorg/dsi/ifc/radio/ServiceInfo; 
.const [57] = Utf8 org/dsi/ifc/radio/ServiceInfo 
.const [58] = Utf8 getFullName 
.const [59] = Utf8 ()Ljava/lang/String; 
.const [60] = Utf8 de/audi/tuner/app/dab/DabStation 
.const [61] = Utf8 component 
.const [62] = Utf8 Lorg/dsi/ifc/radio/ComponentInfo; 
.const [63] = Utf8 org/dsi/ifc/radio/ComponentInfo 
.const [64] = Utf8 getFullName 
.const [65] = Utf8 ()Ljava/lang/String; 
.const [66] = Utf8 de/audi/tuner/app/LanguageManager 
.const [67] = Utf8 getCollator 
.const [68] = Utf8 ()Ljava/text/Collator; 
.const [69] = Utf8 java/text/Collator 
.const [70] = Utf8 compare 
.const [71] = Utf8 (Ljava/lang/String;Ljava/lang/String;)I 
.const [72] = Utf8 java/lang/Object 
.const [73] = Utf8 <init> 
.const [74] = Utf8 ()V 
.const [75] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorFlatList 
.const [76] = Utf8 langMngr 
.const [77] = Utf8 Lde/audi/tuner/app/LanguageManager; 
.const [78] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorFlatList 
.const [79] = Class [78] 
.const [80] = Utf8 java/lang/Object 
.const [81] = Class [80] 
.const [82] = Utf8 java/util/Comparator 
.const [83] = Class [82] 
.const [84] = Utf8 langMngr 
.const [85] = Utf8 Lde/audi/tuner/app/LanguageManager; 
.const [86] = Utf8 Code 
.const [87] = Utf8 <init> 
.const [88] = Utf8 (Lde/audi/tuner/app/LanguageManager;)V 
.const [89] = Utf8 compare 
.const [90] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)I 
.end class 
