.version 50 0 
.class super [89] 
.super [91] 
.implements [93] 

.method private annotation [95] : [96] 
    .attribute [94] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [97] : [98] 
    .attribute [94] .code stack 3 locals 5 
L0:     invokestatic [2] 
L3:     astore 4 
L5:     aload 4 
L7:     ifnull L69 
L10:    new [23] 
L13:    dup 
L14:    invokespecial [21] 
L17:    astore 5 
L19:    new [24] 
L22:    dup 
L23:    aload 5 
L25:    invokespecial [22] 
L28:    astore 6 
L30:    aload 4 
L32:    aload 6 
L34:    invokevirtual [15] 
        .catch [6] from L37 to L45 using L48 
L37:    aload 5 
L39:    ldc [5] 
L41:    invokevirtual [16] 
L44:    astore_3 
L45:    goto L66 
L48:    astore 7 
L50:    aload 5 
L52:    invokevirtual [17] 
L55:    astore_3 
L56:    invokestatic [7] 
L59:    iconst_4 
L60:    ldc [8] 
L62:    invokevirtual [18] 
L65:    pop 
L66:    goto L72 
L69:    ldc [9] 
L71:    astore_3 
L72:    invokestatic [7] 
L75:    iconst_2 
L76:    aload_3 
L77:    invokevirtual [18] 
L80:    pop 
L81:    return 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method synthetic [99] : [100] 
    .attribute [94] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [25] [26] 
.const [3] = Class [27] 
.const [4] = Class [28] 
.const [5] = String [29] 
.const [6] = Class [30] 
.const [7] = Method [31] [32] 
.const [8] = String [33] 
.const [9] = String [34] 
.const [10] = Class [35] 
.const [11] = Class [36] 
.const [12] = Class [37] 
.const [13] = Class [38] 
.const [14] = Class [39] 
.const [15] = Method [40] [41] 
.const [16] = Method [42] [43] 
.const [17] = Method [44] [45] 
.const [18] = Method [46] [47] 
.const [19] = Method [48] [49] 
.const [20] = Method [50] [51] 
.const [21] = Method [52] [53] 
.const [22] = Method [54] [55] 
.const [23] = Class [56] 
.const [24] = Class [57] 
.const [25] = Class [58] 
.const [26] = NameAndType [59] [60] 
.const [27] = Utf8 java/io/ByteArrayOutputStream 
.const [28] = Utf8 java/io/PrintStream 
.const [29] = Utf8 UTF-8 
.const [30] = Utf8 java/io/UnsupportedEncodingException 
.const [31] = Class [61] 
.const [32] = NameAndType [62] [63] 
.const [33] = Utf8 'DiagnosisReport executeTraceCallback found UnsupportedEncodingException' 
.const [34] = Utf8 'DiagnosisReport failed: NO AGENT FOUND!' 
.const [35] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks$DiagnosisReport 
.const [36] = Utf8 java/lang/Object 
.const [37] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [38] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks 
.const [39] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [40] = Class [64] 
.const [41] = NameAndType [65] [66] 
.const [42] = Class [67] 
.const [43] = NameAndType [68] [69] 
.const [44] = Class [70] 
.const [45] = NameAndType [71] [72] 
.const [46] = Class [73] 
.const [47] = NameAndType [74] [75] 
.const [48] = Class [76] 
.const [49] = NameAndType [77] [78] 
.const [50] = Class [79] 
.const [51] = NameAndType [80] [81] 
.const [52] = Class [82] 
.const [53] = NameAndType [83] [84] 
.const [54] = Class [85] 
.const [55] = NameAndType [86] [87] 
.const [56] = Utf8 java/io/ByteArrayOutputStream 
.const [57] = Utf8 java/io/PrintStream 
.const [58] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [59] = Utf8 getAgent 
.const [60] = Utf8 ()Lde/esolutions/fw/comm/agent/Agent; 
.const [61] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks 
.const [62] = Utf8 access$000 
.const [63] = Utf8 ()Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [64] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [65] = Utf8 writeDiagnosisReport 
.const [66] = Utf8 (Ljava/io/PrintStream;)V 
.const [67] = Utf8 java/io/ByteArrayOutputStream 
.const [68] = Utf8 toString 
.const [69] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [70] = Utf8 java/io/ByteArrayOutputStream 
.const [71] = Utf8 toString 
.const [72] = Utf8 ()Ljava/lang/String; 
.const [73] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [74] = Utf8 log 
.const [75] = Utf8 (SLjava/lang/String;)Z 
.const [76] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks$DiagnosisReport 
.const [77] = Utf8 <init> 
.const [78] = Utf8 ()V 
.const [79] = Utf8 java/lang/Object 
.const [80] = Utf8 <init> 
.const [81] = Utf8 ()V 
.const [82] = Utf8 java/io/ByteArrayOutputStream 
.const [83] = Utf8 <init> 
.const [84] = Utf8 ()V 
.const [85] = Utf8 java/io/PrintStream 
.const [86] = Utf8 <init> 
.const [87] = Utf8 (Ljava/io/OutputStream;)V 
.const [88] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentCallbacks$DiagnosisReport 
.const [89] = Class [88] 
.const [90] = Utf8 java/lang/Object 
.const [91] = Class [90] 
.const [92] = Utf8 de/esolutions/fw/util/tracing/ITraceCallback 
.const [93] = Class [92] 
.const [94] = Utf8 Code 
.const [95] = Utf8 <init> 
.const [96] = Utf8 ()V 
.const [97] = Utf8 executeTraceCallback 
.const [98] = Utf8 (I[B)V 
.const [99] = Utf8 <init> 
.const [100] = Utf8 (Lde/esolutions/fw/comm/agent/osgi/AgentCallbacks$1;)V 
.end class 
