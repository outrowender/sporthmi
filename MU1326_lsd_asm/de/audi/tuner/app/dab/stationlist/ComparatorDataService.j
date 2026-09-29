.version 50 0 
.class public super [51] 
.super [53] 
.implements [55] 
.implements [57] 
.field private static final [58] [59] 

.method public annotation [61] : [62] 
    .attribute [60] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [9] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [63] : [64] 
    .attribute [60] .code stack 5 locals 3 
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
L23:    aload_0 
L24:    aload_3 
L25:    getfield [5] 
L28:    aload 4 
L30:    getfield [5] 
L33:    invokespecial [10] 
L36:    istore 5 
L38:    iload 5 
L40:    ifne L61 
L43:    aload_0 
L44:    aload_3 
L45:    getfield [6] 
L48:    aload 4 
L50:    getfield [6] 
L53:    invokespecial [10] 
L56:    istore 5 
L58:    goto L64 
L61:    iload 5 
L63:    areturn 
L64:    iload 5 
L66:    ifne L87 
L69:    aload_0 
L70:    aload_3 
L71:    getfield [7] 
L74:    aload 4 
L76:    getfield [7] 
L79:    invokespecial [11] 
L82:    istore 5 
L84:    goto L90 
L87:    iload 5 
L89:    areturn 
L90:    iload 5 
L92:    ifne L110 
L95:    aload_0 
L96:    aload_3 
L97:    getfield [8] 
L100:   aload 4 
L102:   getfield [8] 
L105:   invokespecial [10] 
L108:   istore 5 
L110:   iload 5 
L112:   areturn 
L113:   nop 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method private [65] : [66] 
    .attribute [60] .code stack 2 locals 0 
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

.method private [67] : [68] 
    .attribute [60] .code stack 4 locals 0 
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
.const [2] = Class [12] 
.const [3] = Class [13] 
.const [4] = Class [14] 
.const [5] = Field [15] [16] 
.const [6] = Field [17] [18] 
.const [7] = Field [19] [20] 
.const [8] = Field [21] [22] 
.const [9] = Method [23] [24] 
.const [10] = Method [25] [26] 
.const [11] = Method [27] [28] 
.const [12] = Utf8 org/dsi/ifc/radio/DataServiceInfo 
.const [13] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorDataService 
.const [14] = Utf8 java/lang/Object 
.const [15] = Class [29] 
.const [16] = NameAndType [30] [31] 
.const [17] = Class [32] 
.const [18] = NameAndType [33] [34] 
.const [19] = Class [35] 
.const [20] = NameAndType [36] [37] 
.const [21] = Class [38] 
.const [22] = NameAndType [39] [40] 
.const [23] = Class [41] 
.const [24] = NameAndType [42] [43] 
.const [25] = Class [44] 
.const [26] = NameAndType [45] [46] 
.const [27] = Class [47] 
.const [28] = NameAndType [48] [49] 
.const [29] = Utf8 org/dsi/ifc/radio/DataServiceInfo 
.const [30] = Utf8 ensID 
.const [31] = Utf8 I 
.const [32] = Utf8 org/dsi/ifc/radio/DataServiceInfo 
.const [33] = Utf8 ensECC 
.const [34] = Utf8 I 
.const [35] = Utf8 org/dsi/ifc/radio/DataServiceInfo 
.const [36] = Utf8 sID 
.const [37] = Utf8 J 
.const [38] = Utf8 org/dsi/ifc/radio/DataServiceInfo 
.const [39] = Utf8 sCIDI 
.const [40] = Utf8 I 
.const [41] = Utf8 java/lang/Object 
.const [42] = Utf8 <init> 
.const [43] = Utf8 ()V 
.const [44] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorDataService 
.const [45] = Utf8 compare 
.const [46] = Utf8 (II)I 
.const [47] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorDataService 
.const [48] = Utf8 compare 
.const [49] = Utf8 (JJ)I 
.const [50] = Utf8 de/audi/tuner/app/dab/stationlist/ComparatorDataService 
.const [51] = Class [50] 
.const [52] = Utf8 java/lang/Object 
.const [53] = Class [52] 
.const [54] = Utf8 java/util/Comparator 
.const [55] = Class [54] 
.const [56] = Utf8 java/io/Serializable 
.const [57] = Class [56] 
.const [58] = Utf8 serialVersionUID 
.const [59] = Utf8 J 
.const [60] = Utf8 Code 
.const [61] = Utf8 <init> 
.const [62] = Utf8 ()V 
.const [63] = Utf8 compare 
.const [64] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)I 
.const [65] = Utf8 compare 
.const [66] = Utf8 (II)I 
.const [67] = Utf8 compare 
.const [68] = Utf8 (JJ)I 
.end class 
