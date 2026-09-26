.version 50 0 
.class public super [33] 
.super [35] 
.implements [37] 
.implements [39] 
.field private static final [40] [41] 

.method public annotation [43] : [44] 
    .attribute [42] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [8] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [45] : [46] 
    .attribute [42] .code stack 4 locals 4 
L0:     aload_1 
L1:     instanceof [2] 
L4:     ifeq L21 
L7:     aload_1 
L8:     checkcast [2] 
L11:    astore_3 
L12:    aload_2 
L13:    checkcast [2] 
L16:    astore 4 
L18:    goto L38 
L21:    aload_1 
L22:    checkcast [3] 
L25:    invokevirtual [5] 
L28:    astore_3 
L29:    aload_2 
L30:    checkcast [3] 
L33:    invokevirtual [5] 
L36:    astore 4 
L38:    aload_3 
L39:    invokevirtual [6] 
L42:    istore 5 
L44:    aload 4 
L46:    invokevirtual [6] 
L49:    istore 6 
L51:    aload_3 
L52:    getfield [7] 
L55:    aload 4 
L57:    getfield [7] 
L60:    lcmp 
L61:    ifge L66 
L64:    iconst_m1 
L65:    areturn 
L66:    aload_3 
L67:    getfield [7] 
L70:    aload 4 
L72:    getfield [7] 
L75:    lcmp 
L76:    ifle L81 
L79:    iconst_1 
L80:    areturn 
L81:    iload 5 
L83:    iload 6 
L85:    if_icmpge L90 
L88:    iconst_m1 
L89:    areturn 
L90:    iload 5 
L92:    iload 6 
L94:    if_icmple L99 
L97:    iconst_1 
L98:    areturn 
L99:    iconst_0 
L100:   areturn 
L101:   nop 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [9] 
.const [3] = Class [10] 
.const [4] = Class [11] 
.const [5] = Method [12] [13] 
.const [6] = Method [14] [15] 
.const [7] = Field [16] [17] 
.const [8] = Method [18] [19] 
.const [9] = Utf8 de/audi/tuner/app/amfm/AMFMStation 
.const [10] = Utf8 de/audi/tuner/app/TunerObjectContainer 
.const [11] = Utf8 java/lang/Object 
.const [12] = Class [20] 
.const [13] = NameAndType [21] [22] 
.const [14] = Class [23] 
.const [15] = NameAndType [24] [25] 
.const [16] = Class [26] 
.const [17] = NameAndType [27] [28] 
.const [18] = Class [29] 
.const [19] = NameAndType [30] [31] 
.const [20] = Utf8 de/audi/tuner/app/TunerObjectContainer 
.const [21] = Utf8 getAMFMService 
.const [22] = Utf8 ()Lde/audi/tuner/app/amfm/AMFMStation; 
.const [23] = Utf8 de/audi/tuner/app/amfm/AMFMStation 
.const [24] = Utf8 getServiceId 
.const [25] = Utf8 ()I 
.const [26] = Utf8 de/audi/tuner/app/amfm/AMFMStation 
.const [27] = Utf8 frequency 
.const [28] = Utf8 J 
.const [29] = Utf8 java/lang/Object 
.const [30] = Utf8 <init> 
.const [31] = Utf8 ()V 
.const [32] = Utf8 de/audi/tuner/app/amfm/stationlist/SortAlgoFrequency 
.const [33] = Class [32] 
.const [34] = Utf8 java/lang/Object 
.const [35] = Class [34] 
.const [36] = Utf8 java/util/Comparator 
.const [37] = Class [36] 
.const [38] = Utf8 java/io/Serializable 
.const [39] = Class [38] 
.const [40] = Utf8 serialVersionUID 
.const [41] = Utf8 J 
.const [42] = Utf8 Code 
.const [43] = Utf8 <init> 
.const [44] = Utf8 ()V 
.const [45] = Utf8 compare 
.const [46] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)I 
.end class 
