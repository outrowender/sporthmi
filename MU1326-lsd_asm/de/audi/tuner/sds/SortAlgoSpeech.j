.version 50 0 
.class super [53] 
.super [55] 
.implements [57] 
.implements [59] 
.field private static final [60] [61] 
.field private [62] [63] 

.method [65] : [66] 
    .attribute [64] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [12] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [67] : [68] 
    .attribute [64] .code stack 3 locals 4 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_3 
L5:     aload_2 
L6:     checkcast [2] 
L9:     astore 4 
L11:    aload_0 
L12:    aload_3 
L13:    invokevirtual [9] 
L16:    invokespecial [11] 
L19:    istore 5 
L21:    aload_0 
L22:    aload 4 
L24:    invokevirtual [9] 
L27:    invokespecial [11] 
L30:    istore 6 
L32:    iload 5 
L34:    iload 6 
L36:    isub 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [69] : [70] 
    .attribute [64] .code stack 2 locals 2 
L0:     lload_1 
L1:     invokestatic [3] 
L4:     istore_3 
L5:     iload_3 
L6:     tableswitch 1 
            L88 
            L94 
            L94 
            L91 
            L66 
            L94 
            L85 
            L94 
            L94 
            L94 
            L64 
            default : L94 

L64:    iconst_0 
L65:    areturn 
L66:    lload_1 
L67:    invokestatic [4] 
L70:    istore 4 
L72:    iload 4 
L74:    aload_0 
L75:    getfield [8] 
L78:    if_icmpne L83 
L81:    iconst_2 
L82:    areturn 
L83:    iconst_4 
L84:    areturn 
L85:    bipush 6 
L87:    areturn 
L88:    bipush 8 
L90:    areturn 
L91:    bipush 10 
L93:    areturn 
L94:    iconst_m1 
L95:    areturn 
L96:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [13] 
.const [3] = Method [14] [15] 
.const [4] = Method [16] [17] 
.const [5] = Class [18] 
.const [6] = Class [19] 
.const [7] = Class [20] 
.const [8] = Field [21] [22] 
.const [9] = Method [23] [24] 
.const [10] = Method [25] [26] 
.const [11] = Method [27] [28] 
.const [12] = Field [29] [30] 
.const [13] = Utf8 java/lang/Long 
.const [14] = Class [31] 
.const [15] = NameAndType [32] [33] 
.const [16] = Class [34] 
.const [17] = NameAndType [35] [36] 
.const [18] = Utf8 de/audi/tuner/sds/SortAlgoSpeech 
.const [19] = Utf8 java/lang/Object 
.const [20] = Utf8 de/audi/tuner/app/RadioObjectIds 
.const [21] = Class [37] 
.const [22] = NameAndType [38] [39] 
.const [23] = Class [40] 
.const [24] = NameAndType [41] [42] 
.const [25] = Class [43] 
.const [26] = NameAndType [44] [45] 
.const [27] = Class [46] 
.const [28] = NameAndType [47] [48] 
.const [29] = Class [49] 
.const [30] = NameAndType [50] [51] 
.const [31] = Utf8 de/audi/tuner/app/RadioObjectIds 
.const [32] = Utf8 getBandComponent 
.const [33] = Utf8 (J)I 
.const [34] = Utf8 de/audi/tuner/app/RadioObjectIds 
.const [35] = Utf8 getEnsembleId 
.const [36] = Utf8 (J)I 
.const [37] = Utf8 de/audi/tuner/sds/SortAlgoSpeech 
.const [38] = Utf8 activeEnsemble 
.const [39] = Utf8 I 
.const [40] = Utf8 java/lang/Long 
.const [41] = Utf8 longValue 
.const [42] = Utf8 ()J 
.const [43] = Utf8 java/lang/Object 
.const [44] = Utf8 <init> 
.const [45] = Utf8 ()V 
.const [46] = Utf8 de/audi/tuner/sds/SortAlgoSpeech 
.const [47] = Utf8 convertForOrder 
.const [48] = Utf8 (J)I 
.const [49] = Utf8 de/audi/tuner/sds/SortAlgoSpeech 
.const [50] = Utf8 activeEnsemble 
.const [51] = Utf8 I 
.const [52] = Utf8 de/audi/tuner/sds/SortAlgoSpeech 
.const [53] = Class [52] 
.const [54] = Utf8 java/lang/Object 
.const [55] = Class [54] 
.const [56] = Utf8 java/util/Comparator 
.const [57] = Class [56] 
.const [58] = Utf8 java/io/Serializable 
.const [59] = Class [58] 
.const [60] = Utf8 serialVersionUID 
.const [61] = Utf8 J 
.const [62] = Utf8 activeEnsemble 
.const [63] = Utf8 I 
.const [64] = Utf8 Code 
.const [65] = Utf8 <init> 
.const [66] = Utf8 (I)V 
.const [67] = Utf8 compare 
.const [68] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)I 
.const [69] = Utf8 convertForOrder 
.const [70] = Utf8 (J)I 
.end class 
