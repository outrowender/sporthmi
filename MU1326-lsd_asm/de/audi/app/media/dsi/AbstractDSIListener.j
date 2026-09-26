.version 50 0 
.class public super abstract [78] 
.super [80] 
.field protected final [81] [82] 

.method public [84] : [85] 
    .attribute [83] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_1 
L5:     ifnonnull L16 
L8:     new [19] 
L11:    dup 
L12:    invokespecial [16] 
L15:    athrow 
L16:    aload_0 
L17:    aload_1 
L18:    putfield [20] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected abstract [86] : [87] 
    .attribute [83] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected final [88] : [89] 
    .attribute [83] .code stack 9 locals 0 
L0:     iload_3 
L1:     tableswitch 0 
            L50 
            L28 
            L30 
            default : L70 

L28:    iconst_1 
L29:    areturn 
L30:    aload_0 
L31:    getfield [11] 
L34:    ldc [3] 
L36:    ldc [4] 
L38:    aload_0 
L39:    invokevirtual [12] 
L42:    aload_1 
L43:    iload_2 
L44:    i2l 
L45:    invokevirtual [13] 
L48:    iconst_0 
L49:    areturn 
L50:    aload_0 
L51:    getfield [11] 
L54:    ldc [3] 
L56:    ldc [5] 
L58:    aload_0 
L59:    invokevirtual [12] 
L62:    aload_1 
L63:    iload_2 
L64:    i2l 
L65:    invokevirtual [13] 
L68:    iconst_0 
L69:    areturn 
L70:    aload_0 
L71:    getfield [11] 
L74:    ldc [3] 
L76:    ldc [6] 
L78:    aload_0 
L79:    invokevirtual [12] 
L82:    aload_1 
L83:    new [21] 
L86:    dup 
L87:    iload_2 
L88:    invokespecial [17] 
L91:    new [21] 
L94:    dup 
L95:    iload_3 
L96:    invokespecial [17] 
L99:    invokevirtual [14] 
L102:   iconst_0 
L103:   areturn 
L104:   
    .end code 
.end method 

.method protected final [90] : [91] 
    .attribute [83] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     iload_3 
L4:     invokespecial [18] 
L7:     areturn 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [22] 
.const [3] = Int 1078071040 
.const [4] = String [23] 
.const [5] = String [24] 
.const [6] = String [25] 
.const [7] = Class [26] 
.const [8] = Class [27] 
.const [9] = Class [28] 
.const [10] = Class [29] 
.const [11] = Field [30] [31] 
.const [12] = Method [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Method [44] [45] 
.const [19] = Class [46] 
.const [20] = Field [47] [48] 
.const [21] = Class [49] 
.const [22] = Utf8 java/lang/IllegalArgumentException 
.const [23] = Utf8 '[%1.%2] [%3] Received invalid update.' 
.const [24] = Utf8 '[%1.%2] [%3] Received invalid unknown update.' 
.const [25] = Utf8 "[%1.%2] [%3] Received undefined invalid update (validFlag='%4')." 
.const [26] = Utf8 java/lang/Integer 
.const [27] = Utf8 de/audi/app/media/dsi/AbstractDSIListener 
.const [28] = Utf8 java/lang/Object 
.const [29] = Utf8 de/audi/atip/log/LogChannel 
.const [30] = Class [50] 
.const [31] = NameAndType [51] [52] 
.const [32] = Class [53] 
.const [33] = NameAndType [54] [55] 
.const [34] = Class [56] 
.const [35] = NameAndType [57] [58] 
.const [36] = Class [59] 
.const [37] = NameAndType [60] [61] 
.const [38] = Class [62] 
.const [39] = NameAndType [63] [64] 
.const [40] = Class [65] 
.const [41] = NameAndType [66] [67] 
.const [42] = Class [68] 
.const [43] = NameAndType [69] [70] 
.const [44] = Class [71] 
.const [45] = NameAndType [72] [73] 
.const [46] = Utf8 java/lang/IllegalArgumentException 
.const [47] = Class [74] 
.const [48] = NameAndType [75] [76] 
.const [49] = Utf8 java/lang/Integer 
.const [50] = Utf8 de/audi/app/media/dsi/AbstractDSIListener 
.const [51] = Utf8 logger 
.const [52] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [53] = Utf8 de/audi/app/media/dsi/AbstractDSIListener 
.const [54] = Utf8 getLogClass 
.const [55] = Utf8 ()Ljava/lang/String; 
.const [56] = Utf8 de/audi/atip/log/LogChannel 
.const [57] = Utf8 log 
.const [58] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;J)V 
.const [59] = Utf8 de/audi/atip/log/LogChannel 
.const [60] = Utf8 log 
.const [61] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [62] = Utf8 java/lang/Object 
.const [63] = Utf8 <init> 
.const [64] = Utf8 ()V 
.const [65] = Utf8 java/lang/IllegalArgumentException 
.const [66] = Utf8 <init> 
.const [67] = Utf8 ()V 
.const [68] = Utf8 java/lang/Integer 
.const [69] = Utf8 <init> 
.const [70] = Utf8 (I)V 
.const [71] = Utf8 de/audi/app/media/dsi/AbstractDSIListener 
.const [72] = Utf8 isUpdateValid 
.const [73] = Utf8 (Ljava/lang/String;II)Z 
.const [74] = Utf8 de/audi/app/media/dsi/AbstractDSIListener 
.const [75] = Utf8 logger 
.const [76] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [77] = Utf8 de/audi/app/media/dsi/AbstractDSIListener 
.const [78] = Class [77] 
.const [79] = Utf8 java/lang/Object 
.const [80] = Class [79] 
.const [81] = Utf8 logger 
.const [82] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [83] = Utf8 Code 
.const [84] = Utf8 <init> 
.const [85] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [86] = Utf8 getLogClass 
.const [87] = Utf8 ()Ljava/lang/String; 
.const [88] = Utf8 isUpdateValid 
.const [89] = Utf8 (Ljava/lang/String;II)Z 
.const [90] = Utf8 isUpdateRelevant 
.const [91] = Utf8 (Ljava/lang/String;II)Z 
.end class 
