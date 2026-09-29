.version 50 0 
.class public super [89] 
.super [91] 
.field private final [92] [93] 
.field private final [94] [95] 
.field private final [96] [97] 

.method public [99] : [100] 
    .attribute [98] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [19] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [20] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [21] 
L19:    return 
L20:    
    .end code 
.end method 

.method public interface [101] : [102] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [103] : [104] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [105] : [106] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [98] .code stack 2 locals 1 
L0:     new [22] 
L3:     dup 
L4:     invokespecial [18] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [3] 
L11:    invokevirtual [14] 
L14:    pop 
L15:    aload_1 
L16:    ldc [4] 
L18:    invokevirtual [14] 
L21:    pop 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [11] 
L27:    invokevirtual [15] 
L30:    pop 
L31:    aload_1 
L32:    ldc [5] 
L34:    invokevirtual [14] 
L37:    pop 
L38:    aload_1 
L39:    ldc [6] 
L41:    invokevirtual [14] 
L44:    pop 
L45:    aload_1 
L46:    aload_0 
L47:    getfield [12] 
L50:    invokevirtual [15] 
L53:    pop 
L54:    aload_1 
L55:    ldc [5] 
L57:    invokevirtual [14] 
L60:    pop 
L61:    aload_1 
L62:    ldc [7] 
L64:    invokevirtual [14] 
L67:    pop 
L68:    aload_1 
L69:    aload_0 
L70:    getfield [13] 
L73:    invokevirtual [15] 
L76:    pop 
L77:    aload_1 
L78:    ldc [5] 
L80:    invokevirtual [14] 
L83:    pop 
L84:    aload_1 
L85:    ldc [8] 
L87:    invokevirtual [14] 
L90:    pop 
L91:    aload_1 
L92:    invokevirtual [16] 
L95:    areturn 
L96:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [98] .code stack 3 locals 2 
L0:     iconst_1 
L1:     istore_2 
L2:     bipush 31 
L4:     iload_2 
L5:     aload_0 
L6:     getfield [12] 
L9:     iadd 
L10:    aload_0 
L11:    getfield [13] 
L14:    iadd 
L15:    aload_0 
L16:    getfield [11] 
L19:    iadd 
L20:    imul 
L21:    istore_2 
L22:    iload_2 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [98] .code stack 2 locals 1 
L0:     aload_1 
L1:     instanceof [9] 
L4:     ifeq L51 
L7:     aload_1 
L8:     checkcast [9] 
L11:    astore_2 
L12:    aload_2 
L13:    getfield [12] 
L16:    aload_0 
L17:    getfield [12] 
L20:    if_icmpne L49 
L23:    aload_2 
L24:    getfield [13] 
L27:    aload_0 
L28:    getfield [13] 
L31:    if_icmpne L49 
L34:    aload_2 
L35:    getfield [11] 
L38:    aload_0 
L39:    getfield [11] 
L42:    if_icmpne L49 
L45:    iconst_1 
L46:    goto L50 
L49:    iconst_0 
L50:    areturn 
L51:    iconst_0 
L52:    areturn 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [23] 
.const [3] = String [24] 
.const [4] = String [25] 
.const [5] = String [26] 
.const [6] = String [27] 
.const [7] = String [28] 
.const [8] = String [29] 
.const [9] = Class [30] 
.const [10] = Class [31] 
.const [11] = Field [32] [33] 
.const [12] = Field [34] [35] 
.const [13] = Field [36] [37] 
.const [14] = Method [38] [39] 
.const [15] = Method [40] [41] 
.const [16] = Method [42] [43] 
.const [17] = Method [44] [45] 
.const [18] = Method [46] [47] 
.const [19] = Field [48] [49] 
.const [20] = Field [50] [51] 
.const [21] = Field [52] [53] 
.const [22] = Class [54] 
.const [23] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [24] = Utf8 TelBapRegisterStateStruct( 
.const [25] = Utf8 'registerState=' 
.const [26] = Utf8 ', ' 
.const [27] = Utf8 'networkType=' 
.const [28] = Utf8 'packetDataNetworkType=' 
.const [29] = Utf8 ')' 
.const [30] = Utf8 de/audi/app/phone/core/bap/TelBapRegisterStateStruct 
.const [31] = Utf8 java/lang/Object 
.const [32] = Class [55] 
.const [33] = NameAndType [56] [57] 
.const [34] = Class [58] 
.const [35] = NameAndType [59] [60] 
.const [36] = Class [61] 
.const [37] = NameAndType [62] [63] 
.const [38] = Class [64] 
.const [39] = NameAndType [65] [66] 
.const [40] = Class [67] 
.const [41] = NameAndType [68] [69] 
.const [42] = Class [70] 
.const [43] = NameAndType [71] [72] 
.const [44] = Class [73] 
.const [45] = NameAndType [74] [75] 
.const [46] = Class [76] 
.const [47] = NameAndType [77] [78] 
.const [48] = Class [79] 
.const [49] = NameAndType [80] [81] 
.const [50] = Class [82] 
.const [51] = NameAndType [83] [84] 
.const [52] = Class [85] 
.const [53] = NameAndType [86] [87] 
.const [54] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [55] = Utf8 de/audi/app/phone/core/bap/TelBapRegisterStateStruct 
.const [56] = Utf8 registerState 
.const [57] = Utf8 I 
.const [58] = Utf8 de/audi/app/phone/core/bap/TelBapRegisterStateStruct 
.const [59] = Utf8 networkType 
.const [60] = Utf8 I 
.const [61] = Utf8 de/audi/app/phone/core/bap/TelBapRegisterStateStruct 
.const [62] = Utf8 packetDataNetworkType 
.const [63] = Utf8 I 
.const [64] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [65] = Utf8 append 
.const [66] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [67] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [68] = Utf8 append 
.const [69] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [70] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [71] = Utf8 toString 
.const [72] = Utf8 ()Ljava/lang/String; 
.const [73] = Utf8 java/lang/Object 
.const [74] = Utf8 <init> 
.const [75] = Utf8 ()V 
.const [76] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [77] = Utf8 <init> 
.const [78] = Utf8 ()V 
.const [79] = Utf8 de/audi/app/phone/core/bap/TelBapRegisterStateStruct 
.const [80] = Utf8 registerState 
.const [81] = Utf8 I 
.const [82] = Utf8 de/audi/app/phone/core/bap/TelBapRegisterStateStruct 
.const [83] = Utf8 networkType 
.const [84] = Utf8 I 
.const [85] = Utf8 de/audi/app/phone/core/bap/TelBapRegisterStateStruct 
.const [86] = Utf8 packetDataNetworkType 
.const [87] = Utf8 I 
.const [88] = Utf8 de/audi/app/phone/core/bap/TelBapRegisterStateStruct 
.const [89] = Class [88] 
.const [90] = Utf8 java/lang/Object 
.const [91] = Class [90] 
.const [92] = Utf8 registerState 
.const [93] = Utf8 I 
.const [94] = Utf8 networkType 
.const [95] = Utf8 I 
.const [96] = Utf8 packetDataNetworkType 
.const [97] = Utf8 I 
.const [98] = Utf8 Code 
.const [99] = Utf8 <init> 
.const [100] = Utf8 (III)V 
.const [101] = Utf8 getRegisterState 
.const [102] = Utf8 ()I 
.const [103] = Utf8 getNetworkType 
.const [104] = Utf8 ()I 
.const [105] = Utf8 getPacketDataNetworkType 
.const [106] = Utf8 ()I 
.const [107] = Utf8 toString 
.const [108] = Utf8 ()Ljava/lang/String; 
.const [109] = Utf8 hashCode 
.const [110] = Utf8 ()I 
.const [111] = Utf8 equals 
.const [112] = Utf8 (Ljava/lang/Object;)Z 
.end class 
