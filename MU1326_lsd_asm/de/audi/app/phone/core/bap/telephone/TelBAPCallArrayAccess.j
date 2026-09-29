.version 50 0 
.class public super [94] 
.super [96] 
.field private static final [97] [98] 
.field private final [99] [100] 
.field private final [101] [102] 
.field private final [103] [104] 

.method [106] : [107] 
    .attribute [105] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     bipush 7 
L7:     anewarray [2] 
L10:    putfield [19] 
L13:    aload_0 
L14:    new [20] 
L17:    dup 
L18:    invokespecial [17] 
L21:    putfield [21] 
L24:    aload_0 
L25:    aload_1 
L26:    putfield [22] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method [108] : [109] 
    .attribute [105] .code stack 2 locals 3 
L0:     aconst_null 
L1:     astore_2 
L2:     aload_0 
L3:     getfield [12] 
L6:     dup 
L7:     astore_3 
L8:     monitorenter 
        .catch [0] from L9 to L28 using L31 
L9:     iload_1 
L10:    iflt L26 
L13:    iload_1 
L14:    bipush 7 
L16:    if_icmpge L26 
L19:    aload_0 
L20:    getfield [11] 
L23:    iload_1 
L24:    aaload 
L25:    astore_2 
L26:    aload_3 
L27:    monitorexit 
L28:    goto L38 
        .catch [0] from L31 to L35 using L31 
L31:    astore 4 
L33:    aload_3 
L34:    monitorexit 
L35:    aload 4 
L37:    athrow 
L38:    aload_2 
L39:    areturn 
L40:    
    .end code 
.end method 

.method [110] : [111] 
    .attribute [105] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [12] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L32 using L35 
L7:     aload_1 
L8:     ifnull L30 
L11:    aload_1 
L12:    arraylength 
L13:    bipush 7 
L15:    if_icmpne L30 
L18:    aload_1 
L19:    iconst_0 
L20:    aload_0 
L21:    getfield [11] 
L24:    iconst_0 
L25:    bipush 7 
L27:    invokestatic [4] 
L30:    aload_2 
L31:    monitorexit 
L32:    goto L40 
        .catch [0] from L35 to L38 using L35 
L35:    astore_3 
L36:    aload_2 
L37:    monitorexit 
L38:    aload_3 
L39:    athrow 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method [112] : [113] 
    .attribute [105] .code stack 2 locals 3 
L0:     iconst_m1 
L1:     istore_2 
L2:     aload_0 
L3:     getfield [12] 
L6:     dup 
L7:     astore_3 
L8:     monitorenter 
        .catch [0] from L9 to L44 using L47 
L9:     iload_1 
L10:    iflt L42 
L13:    iload_1 
L14:    bipush 7 
L16:    if_icmpge L42 
L19:    aload_0 
L20:    getfield [11] 
L23:    iload_1 
L24:    aaload 
L25:    ifnull L40 
L28:    aload_0 
L29:    getfield [11] 
L32:    iload_1 
L33:    aaload 
L34:    invokevirtual [13] 
L37:    goto L41 
L40:    iconst_m1 
L41:    istore_2 
L42:    aload_3 
L43:    monitorexit 
L44:    goto L54 
        .catch [0] from L47 to L51 using L47 
L47:    astore 4 
L49:    aload_3 
L50:    monitorexit 
L51:    aload 4 
L53:    athrow 
L54:    iload_2 
L55:    areturn 
L56:    
    .end code 
.end method 

.method [114] : [115] 
    .attribute [105] .code stack 4 locals 4 
L0:     bipush 7 
L2:     anewarray [5] 
L5:     astore_1 
L6:     aload_0 
L7:     getfield [12] 
L10:    dup 
L11:    astore_2 
L12:    monitorenter 
        .catch [0] from L13 to L54 using L57 
L13:    iconst_0 
L14:    istore_3 
L15:    iload_3 
L16:    bipush 7 
L18:    if_icmpge L52 
L21:    aload_1 
L22:    iload_3 
L23:    aload_0 
L24:    getfield [11] 
L27:    iload_3 
L28:    aaload 
L29:    ifnull L44 
L32:    aload_0 
L33:    getfield [11] 
L36:    iload_3 
L37:    aaload 
L38:    invokevirtual [14] 
L41:    goto L45 
L44:    aconst_null 
L45:    aastore 
L46:    iinc 3 1 
L49:    goto L15 
L52:    aload_2 
L53:    monitorexit 
L54:    goto L64 
        .catch [0] from L57 to L61 using L57 
L57:    astore 4 
L59:    aload_2 
L60:    monitorexit 
L61:    aload 4 
L63:    athrow 
L64:    aload_1 
L65:    areturn 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method [116] : [117] 
    .attribute [105] .code stack 4 locals 4 
L0:     bipush 7 
L2:     anewarray [6] 
L5:     astore_1 
L6:     aload_0 
L7:     getfield [12] 
L10:    dup 
L11:    astore_2 
L12:    monitorenter 
        .catch [0] from L13 to L54 using L57 
L13:    iconst_0 
L14:    istore_3 
L15:    iload_3 
L16:    bipush 7 
L18:    if_icmpge L52 
L21:    aload_1 
L22:    iload_3 
L23:    aload_0 
L24:    getfield [11] 
L27:    iload_3 
L28:    aaload 
L29:    ifnull L44 
L32:    aload_0 
L33:    getfield [11] 
L36:    iload_3 
L37:    aaload 
L38:    invokevirtual [15] 
L41:    goto L45 
L44:    aconst_null 
L45:    aastore 
L46:    iinc 3 1 
L49:    goto L15 
L52:    aload_2 
L53:    monitorexit 
L54:    goto L64 
        .catch [0] from L57 to L61 using L57 
L57:    astore 4 
L59:    aload_2 
L60:    monitorexit 
L61:    aload 4 
L63:    athrow 
L64:    aload_1 
L65:    areturn 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method [118] : [119] 
    .attribute [105] .code stack 5 locals 4 
L0:     bipush 7 
L2:     anewarray [7] 
L5:     astore_1 
L6:     aload_0 
L7:     getfield [12] 
L10:    dup 
L11:    astore_2 
L12:    monitorenter 
        .catch [0] from L13 to L62 using L65 
L13:    iconst_0 
L14:    istore_3 
L15:    iload_3 
L16:    bipush 7 
L18:    if_icmpge L60 
L21:    aload_1 
L22:    iload_3 
L23:    aload_0 
L24:    getfield [11] 
L27:    iload_3 
L28:    aaload 
L29:    ifnull L44 
L32:    aload_0 
L33:    getfield [11] 
L36:    iload_3 
L37:    aaload 
L38:    invokevirtual [16] 
L41:    goto L53 
L44:    new [23] 
L47:    dup 
L48:    ldc [8] 
L50:    invokespecial [18] 
L53:    aastore 
L54:    iinc 3 1 
L57:    goto L15 
L60:    aload_2 
L61:    monitorexit 
L62:    goto L72 
        .catch [0] from L65 to L69 using L65 
L65:    astore 4 
L67:    aload_2 
L68:    monitorexit 
L69:    aload 4 
L71:    athrow 
L72:    aload_1 
L73:    areturn 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [24] 
.const [3] = Class [25] 
.const [4] = Method [26] [27] 
.const [5] = Class [28] 
.const [6] = Class [29] 
.const [7] = Class [30] 
.const [8] = Int -65536 
.const [9] = Class [31] 
.const [10] = Class [32] 
.const [11] = Field [33] [34] 
.const [12] = Field [35] [36] 
.const [13] = Method [37] [38] 
.const [14] = Method [39] [40] 
.const [15] = Method [41] [42] 
.const [16] = Method [43] [44] 
.const [17] = Method [45] [46] 
.const [18] = Method [47] [48] 
.const [19] = Field [49] [50] 
.const [20] = Class [51] 
.const [21] = Field [52] [53] 
.const [22] = Field [54] [55] 
.const [23] = Class [56] 
.const [24] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [25] = Utf8 java/lang/Object 
.const [26] = Class [57] 
.const [27] = NameAndType [58] [59] 
.const [28] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallState 
.const [29] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallInfo 
.const [30] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CallStartTime 
.const [31] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCallArrayAccess 
.const [32] = Utf8 java/lang/System 
.const [33] = Class [60] 
.const [34] = NameAndType [61] [62] 
.const [35] = Class [63] 
.const [36] = NameAndType [64] [65] 
.const [37] = Class [66] 
.const [38] = NameAndType [67] [68] 
.const [39] = Class [69] 
.const [40] = NameAndType [70] [71] 
.const [41] = Class [72] 
.const [42] = NameAndType [73] [74] 
.const [43] = Class [75] 
.const [44] = NameAndType [76] [77] 
.const [45] = Class [78] 
.const [46] = NameAndType [79] [80] 
.const [47] = Class [81] 
.const [48] = NameAndType [82] [83] 
.const [49] = Class [84] 
.const [50] = NameAndType [85] [86] 
.const [51] = Utf8 java/lang/Object 
.const [52] = Class [87] 
.const [53] = NameAndType [88] [89] 
.const [54] = Class [90] 
.const [55] = NameAndType [91] [92] 
.const [56] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CallStartTime 
.const [57] = Utf8 java/lang/System 
.const [58] = Utf8 arraycopy 
.const [59] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [60] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCallArrayAccess 
.const [61] = Utf8 bapPhoneCalls 
.const [62] = Utf8 [Lde/audi/app/phone/core/bap/telephone/TelBAPCall; 
.const [63] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCallArrayAccess 
.const [64] = Utf8 lock 
.const [65] = Utf8 Ljava/lang/Object; 
.const [66] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [67] = Utf8 getCallID 
.const [68] = Utf8 ()I 
.const [69] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [70] = Utf8 getCallState 
.const [71] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallState; 
.const [72] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [73] = Utf8 getCallInfo 
.const [74] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallInfo; 
.const [75] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCall 
.const [76] = Utf8 getCallStartTime 
.const [77] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/data/CallStartTime; 
.const [78] = Utf8 java/lang/Object 
.const [79] = Utf8 <init> 
.const [80] = Utf8 ()V 
.const [81] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CallStartTime 
.const [82] = Utf8 <init> 
.const [83] = Utf8 (I)V 
.const [84] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCallArrayAccess 
.const [85] = Utf8 bapPhoneCalls 
.const [86] = Utf8 [Lde/audi/app/phone/core/bap/telephone/TelBAPCall; 
.const [87] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCallArrayAccess 
.const [88] = Utf8 lock 
.const [89] = Utf8 Ljava/lang/Object; 
.const [90] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCallArrayAccess 
.const [91] = Utf8 log 
.const [92] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [93] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPCallArrayAccess 
.const [94] = Class [93] 
.const [95] = Utf8 java/lang/Object 
.const [96] = Class [95] 
.const [97] = Utf8 MAX_CALLS 
.const [98] = Utf8 I 
.const [99] = Utf8 bapPhoneCalls 
.const [100] = Utf8 [Lde/audi/app/phone/core/bap/telephone/TelBAPCall; 
.const [101] = Utf8 log 
.const [102] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [103] = Utf8 lock 
.const [104] = Utf8 Ljava/lang/Object; 
.const [105] = Utf8 Code 
.const [106] = Utf8 <init> 
.const [107] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [108] = Utf8 getBAPCall 
.const [109] = Utf8 (I)Lde/audi/app/phone/core/bap/telephone/TelBAPCall; 
.const [110] = Utf8 setArray 
.const [111] = Utf8 ([Lde/audi/app/phone/core/bap/telephone/TelBAPCall;)V 
.const [112] = Utf8 getDSICallID 
.const [113] = Utf8 (I)I 
.const [114] = Utf8 getCallStateArray 
.const [115] = Utf8 ()[Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallState; 
.const [116] = Utf8 getCallInfoArray 
.const [117] = Utf8 ()[Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallInfo; 
.const [118] = Utf8 getCallStartingTimesArray 
.const [119] = Utf8 ()[Lde/audi/atip/interapp/combi/bap/phone/data/CallStartTime; 
.end class 
