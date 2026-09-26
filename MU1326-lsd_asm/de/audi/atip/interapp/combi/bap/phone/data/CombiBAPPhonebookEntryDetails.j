.version 50 0 
.class public final super [83] 
.super [85] 
.field private [86] [87] 
.field private [88] [89] 

.method public [91] : [92] 
    .attribute [90] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [19] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [20] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [93] : [94] 
    .attribute [90] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [95] : [96] 
    .attribute [90] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [97] : [98] 
    .attribute [90] .code stack 2 locals 1 
L0:     new [21] 
L3:     dup 
L4:     invokespecial [18] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [3] 
L11:    invokevirtual [13] 
L14:    pop 
L15:    aload_1 
L16:    ldc [4] 
L18:    invokevirtual [13] 
L21:    pop 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [11] 
L27:    invokevirtual [13] 
L30:    pop 
L31:    aload_1 
L32:    ldc [5] 
L34:    invokevirtual [13] 
L37:    pop 
L38:    aload_1 
L39:    ldc [6] 
L41:    invokevirtual [13] 
L44:    pop 
L45:    aload_1 
L46:    aload_0 
L47:    getfield [12] 
L50:    invokevirtual [14] 
L53:    pop 
L54:    aload_1 
L55:    ldc [7] 
L57:    invokevirtual [13] 
L60:    pop 
L61:    aload_1 
L62:    invokevirtual [15] 
L65:    areturn 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [99] : [100] 
    .attribute [90] .code stack 2 locals 1 
L0:     aload_1 
L1:     aload_0 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     areturn 
L7:     aload_1 
L8:     instanceof [8] 
L11:    ifeq L50 
L14:    aload_1 
L15:    checkcast [8] 
L18:    astore_2 
L19:    aload_0 
L20:    getfield [11] 
L23:    aload_2 
L24:    getfield [11] 
L27:    invokevirtual [16] 
L30:    ifeq L48 
L33:    aload_0 
L34:    getfield [12] 
L37:    aload_2 
L38:    getfield [12] 
L41:    if_icmpne L48 
L44:    iconst_1 
L45:    goto L49 
L48:    iconst_0 
L49:    areturn 
L50:    iconst_0 
L51:    areturn 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [22] 
.const [3] = String [23] 
.const [4] = String [24] 
.const [5] = String [25] 
.const [6] = String [26] 
.const [7] = String [27] 
.const [8] = Class [28] 
.const [9] = Class [29] 
.const [10] = Class [30] 
.const [11] = Field [31] [32] 
.const [12] = Field [33] [34] 
.const [13] = Method [35] [36] 
.const [14] = Method [37] [38] 
.const [15] = Method [39] [40] 
.const [16] = Method [41] [42] 
.const [17] = Method [43] [44] 
.const [18] = Method [45] [46] 
.const [19] = Field [47] [48] 
.const [20] = Field [49] [50] 
.const [21] = Class [51] 
.const [22] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [23] = Utf8 'CombiBAPPhonebookEntryDetails {' 
.const [24] = Utf8 'telNumber=' 
.const [25] = Utf8 ', ' 
.const [26] = Utf8 'numberType=' 
.const [27] = Utf8 '}' 
.const [28] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntryDetails 
.const [29] = Utf8 java/lang/Object 
.const [30] = Utf8 java/lang/String 
.const [31] = Class [52] 
.const [32] = NameAndType [53] [54] 
.const [33] = Class [55] 
.const [34] = NameAndType [56] [57] 
.const [35] = Class [58] 
.const [36] = NameAndType [59] [60] 
.const [37] = Class [61] 
.const [38] = NameAndType [62] [63] 
.const [39] = Class [64] 
.const [40] = NameAndType [65] [66] 
.const [41] = Class [67] 
.const [42] = NameAndType [68] [69] 
.const [43] = Class [70] 
.const [44] = NameAndType [71] [72] 
.const [45] = Class [73] 
.const [46] = NameAndType [74] [75] 
.const [47] = Class [76] 
.const [48] = NameAndType [77] [78] 
.const [49] = Class [79] 
.const [50] = NameAndType [80] [81] 
.const [51] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [52] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntryDetails 
.const [53] = Utf8 telNumber 
.const [54] = Utf8 Ljava/lang/String; 
.const [55] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntryDetails 
.const [56] = Utf8 numberType 
.const [57] = Utf8 I 
.const [58] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [59] = Utf8 append 
.const [60] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [61] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [62] = Utf8 append 
.const [63] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [64] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [65] = Utf8 toString 
.const [66] = Utf8 ()Ljava/lang/String; 
.const [67] = Utf8 java/lang/String 
.const [68] = Utf8 equals 
.const [69] = Utf8 (Ljava/lang/Object;)Z 
.const [70] = Utf8 java/lang/Object 
.const [71] = Utf8 <init> 
.const [72] = Utf8 ()V 
.const [73] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [74] = Utf8 <init> 
.const [75] = Utf8 ()V 
.const [76] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntryDetails 
.const [77] = Utf8 telNumber 
.const [78] = Utf8 Ljava/lang/String; 
.const [79] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntryDetails 
.const [80] = Utf8 numberType 
.const [81] = Utf8 I 
.const [82] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntryDetails 
.const [83] = Class [82] 
.const [84] = Utf8 java/lang/Object 
.const [85] = Class [84] 
.const [86] = Utf8 telNumber 
.const [87] = Utf8 Ljava/lang/String; 
.const [88] = Utf8 numberType 
.const [89] = Utf8 I 
.const [90] = Utf8 Code 
.const [91] = Utf8 <init> 
.const [92] = Utf8 (Ljava/lang/String;I)V 
.const [93] = Utf8 getTelNumber 
.const [94] = Utf8 ()Ljava/lang/String; 
.const [95] = Utf8 getNumberType 
.const [96] = Utf8 ()I 
.const [97] = Utf8 toString 
.const [98] = Utf8 ()Ljava/lang/String; 
.const [99] = Utf8 hasSameContent 
.const [100] = Utf8 (Ljava/lang/Object;)Z 
.end class 
