.version 50 0 
.class public super [75] 
.super [77] 
.implements [79] 

.method public annotation [81] : [82] 
    .attribute [80] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public enum [83] : [84] 
    .attribute [80] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [85] : [86] 
    .attribute [80] .code stack 10 locals 4 
L0:     aload_1 
L1:     invokeinterface [18] 0 
L6:     astore_3 
L7:     aload_3 
L8:     bipush 18 
L10:    baload 
L11:    sipush 256 
L14:    imul 
L15:    aload_3 
L16:    bipush 17 
L18:    baload 
L19:    iadd 
L20:    istore 4 
L22:    aload_3 
L23:    bipush 20 
L25:    baload 
L26:    sipush 256 
L29:    imul 
L30:    aload_3 
L31:    bipush 19 
L33:    baload 
L34:    iadd 
L35:    istore 5 
L37:    iload 4 
L39:    sipush 257 
L42:    if_icmpne L95 
        .catch [4] from L45 to L72 using L75 
L45:    aload_1 
L46:    iconst_1 
L47:    anewarray [2] 
L50:    dup 
L51:    iconst_0 
L52:    new [19] 
L55:    dup 
L56:    aload_3 
L57:    bipush 12 
L59:    iload 5 
L61:    ldc [3] 
L63:    invokespecial [16] 
L66:    aastore 
L67:    invokeinterface [20] 0 
L72:    goto L136 
L75:    astore 6 
L77:    aload_1 
L78:    iconst_1 
L79:    anewarray [2] 
L82:    dup 
L83:    iconst_0 
L84:    ldc [5] 
L86:    aastore 
L87:    invokeinterface [20] 0 
L92:    goto L136 
L95:    aload_1 
L96:    iconst_1 
L97:    anewarray [2] 
L100:   dup 
L101:   iconst_0 
L102:   new [21] 
L105:   dup 
L106:   invokespecial [17] 
L109:   ldc [7] 
L111:   invokevirtual [13] 
L114:   iload 4 
L116:   invokestatic [8] 
L119:   invokevirtual [13] 
L122:   ldc [9] 
L124:   invokevirtual [13] 
L127:   invokevirtual [14] 
L130:   aastore 
L131:   invokeinterface [20] 0 
L136:   return 
L137:   nop 
L138:   nop 
L139:   nop 
L140:   
    .end code 
.end method 

.method public enum [87] : [88] 
    .attribute [80] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [22] 
.const [3] = String [23] 
.const [4] = Class [24] 
.const [5] = String [25] 
.const [6] = Class [26] 
.const [7] = String [27] 
.const [8] = Method [28] [29] 
.const [9] = String [30] 
.const [10] = Class [31] 
.const [11] = Class [32] 
.const [12] = Class [33] 
.const [13] = Method [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = InterfaceMethod [44] [45] 
.const [19] = Class [46] 
.const [20] = InterfaceMethod [47] [48] 
.const [21] = Class [49] 
.const [22] = Utf8 java/lang/String 
.const [23] = Utf8 UTF-8 
.const [24] = Utf8 java/io/UnsupportedEncodingException 
.const [25] = Utf8 'UTF-8 Encoding not supported ' 
.const [26] = Utf8 java/lang/StringBuffer 
.const [27] = Utf8 'unsupported message type ' 
.const [28] = Class [50] 
.const [29] = NameAndType [51] [52] 
.const [30] = Utf8 ' (should be 0x0101)' 
.const [31] = Utf8 java/lang/Object 
.const [32] = Utf8 de/esolutions/fw/util/tracing/message/ITraceMessage 
.const [33] = Utf8 java/lang/Integer 
.const [34] = Class [53] 
.const [35] = NameAndType [54] [55] 
.const [36] = Class [56] 
.const [37] = NameAndType [57] [58] 
.const [38] = Class [59] 
.const [39] = NameAndType [60] [61] 
.const [40] = Class [62] 
.const [41] = NameAndType [63] [64] 
.const [42] = Class [65] 
.const [43] = NameAndType [66] [67] 
.const [44] = Class [68] 
.const [45] = NameAndType [69] [70] 
.const [46] = Utf8 java/lang/String 
.const [47] = Class [71] 
.const [48] = NameAndType [72] [73] 
.const [49] = Utf8 java/lang/StringBuffer 
.const [50] = Utf8 java/lang/Integer 
.const [51] = Utf8 toString 
.const [52] = Utf8 (I)Ljava/lang/String; 
.const [53] = Utf8 java/lang/StringBuffer 
.const [54] = Utf8 append 
.const [55] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [56] = Utf8 java/lang/StringBuffer 
.const [57] = Utf8 toString 
.const [58] = Utf8 ()Ljava/lang/String; 
.const [59] = Utf8 java/lang/Object 
.const [60] = Utf8 <init> 
.const [61] = Utf8 ()V 
.const [62] = Utf8 java/lang/String 
.const [63] = Utf8 <init> 
.const [64] = Utf8 ([BIILjava/lang/String;)V 
.const [65] = Utf8 java/lang/StringBuffer 
.const [66] = Utf8 <init> 
.const [67] = Utf8 ()V 
.const [68] = Utf8 de/esolutions/fw/util/tracing/message/ITraceMessage 
.const [69] = Utf8 getMessageData 
.const [70] = Utf8 ()[B 
.const [71] = Utf8 de/esolutions/fw/util/tracing/message/ITraceMessage 
.const [72] = Utf8 setDecodedMessage 
.const [73] = Utf8 ([Ljava/lang/String;)V 
.const [74] = Utf8 de/esolutions/fw/util/tracing/decode/vwdebug/VWDebugBinaryMessageDecoder 
.const [75] = Class [74] 
.const [76] = Utf8 java/lang/Object 
.const [77] = Class [76] 
.const [78] = Utf8 de/esolutions/fw/util/tracing/decode/ITraceMessageDecoder 
.const [79] = Class [78] 
.const [80] = Utf8 Code 
.const [81] = Utf8 <init> 
.const [82] = Utf8 ()V 
.const [83] = Utf8 init 
.const [84] = Utf8 (Lde/esolutions/fw/util/tracing/config/TraceConfigDecoder;)V 
.const [85] = Utf8 decodeMessage 
.const [86] = Utf8 (Lde/esolutions/fw/util/tracing/message/ITraceMessage;Lde/esolutions/fw/util/tracing/format/ITraceEntityResolver;)V 
.const [87] = Utf8 init 
.const [88] = Utf8 (Lde/esolutions/fw/util/config/ConfigValue;)V 
.end class 
