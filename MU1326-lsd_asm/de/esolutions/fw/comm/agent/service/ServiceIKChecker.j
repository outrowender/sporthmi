.version 50 0 
.class public super [121] 
.super [123] 
.field private final [124] [125] 

.method public [127] : [128] 
    .attribute [126] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [31] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [126] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     aconst_null 
L5:     invokevirtual [20] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [126] .code stack 8 locals 7 
L0:     aload_2 
L1:     ifnonnull L17 
L4:     getstatic [2] 
L7:     iconst_2 
L8:     ldc [3] 
L10:    aload_1 
L11:    invokevirtual [21] 
L14:    pop 
L15:    iconst_0 
L16:    areturn 
L17:    aload_3 
L18:    ifnonnull L34 
L21:    getstatic [2] 
L24:    iconst_2 
L25:    ldc [4] 
L27:    aload_1 
L28:    invokevirtual [21] 
L31:    pop 
L32:    iconst_0 
L33:    areturn 
L34:    aload_2 
L35:    invokevirtual [22] 
L38:    astore 5 
L40:    aload_3 
L41:    invokevirtual [22] 
L44:    astore 6 
L46:    aload 5 
L48:    aload 6 
L50:    invokevirtual [23] 
L53:    ifne L73 
L56:    getstatic [2] 
L59:    iconst_2 
L60:    ldc [5] 
L62:    aload_1 
L63:    aload 5 
L65:    aload 6 
L67:    invokevirtual [24] 
L70:    pop 
L71:    iconst_0 
L72:    areturn 
L73:    aload_2 
L74:    invokevirtual [25] 
L77:    istore 7 
L79:    aload_3 
L80:    invokevirtual [25] 
L83:    istore 8 
L85:    iload 7 
L87:    iload 8 
L89:    if_icmpeq L123 
L92:    getstatic [2] 
L95:    iconst_2 
L96:    ldc [6] 
L98:    aload_1 
L99:    new [32] 
L102:   dup 
L103:   iload 7 
L105:   invokespecial [30] 
L108:   new [32] 
L111:   dup 
L112:   iload 8 
L114:   invokespecial [30] 
L117:   invokevirtual [24] 
L120:   pop 
L121:   iconst_0 
L122:   areturn 
L123:   aload_2 
L124:   invokevirtual [26] 
L127:   astore 9 
L129:   aload_3 
L130:   invokevirtual [26] 
L133:   astore 10 
L135:   aload 9 
L137:   aload 10 
L139:   invokevirtual [23] 
L142:   ifeq L160 
L145:   getstatic [2] 
L148:   iconst_2 
L149:   ldc [8] 
L151:   aload_1 
L152:   aload_2 
L153:   aload_3 
L154:   invokevirtual [24] 
L157:   pop 
L158:   iconst_1 
L159:   areturn 
L160:   aload 9 
L162:   invokevirtual [27] 
L165:   ifne L176 
L168:   aload 10 
L170:   invokevirtual [27] 
L173:   ifeq L191 
L176:   getstatic [2] 
L179:   iconst_2 
L180:   ldc [9] 
L182:   aload_1 
L183:   aload_2 
L184:   aload_3 
L185:   invokevirtual [24] 
L188:   pop 
L189:   iconst_1 
L190:   areturn 
L191:   aload_0 
L192:   getfield [19] 
L195:   istore 11 
L197:   aload 4 
L199:   ifnull L217 
L202:   aload 4 
L204:   invokevirtual [28] 
L207:   ifne L214 
L210:   iconst_1 
L211:   goto L215 
L214:   iconst_0 
L215:   istore 11 
L217:   iload 11 
L219:   ifeq L237 
L222:   getstatic [2] 
L225:   iconst_3 
L226:   ldc [10] 
L228:   aload_1 
L229:   aload_2 
L230:   aload_3 
L231:   invokevirtual [24] 
L234:   pop 
L235:   iconst_1 
L236:   areturn 
L237:   getstatic [2] 
L240:   iconst_2 
L241:   ldc [11] 
L243:   aload_1 
L244:   aload_2 
L245:   aload_3 
L246:   invokevirtual [24] 
L249:   pop 
L250:   iconst_0 
L251:   areturn 
L252:   
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [126] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnull L8 
L4:     aload_2 
L5:     ifnonnull L10 
L8:     iconst_0 
L9:     areturn 
L10:    aload_1 
L11:    invokevirtual [22] 
L14:    aload_2 
L15:    invokevirtual [22] 
L18:    invokevirtual [23] 
L21:    ifeq L51 
L24:    aload_1 
L25:    invokevirtual [26] 
L28:    aload_2 
L29:    invokevirtual [26] 
L32:    invokevirtual [23] 
L35:    ifeq L51 
L38:    aload_1 
L39:    invokevirtual [25] 
L42:    aload_2 
L43:    invokevirtual [25] 
L46:    if_icmpne L51 
L49:    iconst_1 
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
.const [2] = Field [33] [34] 
.const [3] = String [35] 
.const [4] = String [36] 
.const [5] = String [37] 
.const [6] = String [38] 
.const [7] = Class [39] 
.const [8] = String [40] 
.const [9] = String [41] 
.const [10] = String [42] 
.const [11] = String [43] 
.const [12] = Class [44] 
.const [13] = Class [45] 
.const [14] = Class [46] 
.const [15] = Class [47] 
.const [16] = Class [48] 
.const [17] = Class [49] 
.const [18] = Class [50] 
.const [19] = Field [51] [52] 
.const [20] = Method [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Method [61] [62] 
.const [25] = Method [63] [64] 
.const [26] = Method [65] [66] 
.const [27] = Method [67] [68] 
.const [28] = Method [69] [70] 
.const [29] = Method [71] [72] 
.const [30] = Method [73] [74] 
.const [31] = Field [75] [76] 
.const [32] = Class [77] 
.const [33] = Class [78] 
.const [34] = NameAndType [79] [80] 
.const [35] = Utf8 '%1: no mine service ID!' 
.const [36] = Utf8 '%1: no other service ID!' 
.const [37] = Utf8 '%1: service UUID mismatch: %2 != %3!' 
.const [38] = Utf8 '%1: service handle mismatch: %2 != %3!' 
.const [39] = Utf8 java/lang/Integer 
.const [40] = Utf8 '%1: full match with IK: %2 == %3!' 
.const [41] = Utf8 '%1: match with zero IK: %2 == %3' 
.const [42] = Utf8 '%1: IK mismatch (IGNORED): %2 =! %3!' 
.const [43] = Utf8 '%1: IK mismatch (failed): %2 =! %3!' 
.const [44] = Utf8 de/esolutions/fw/comm/agent/service/ServiceIKChecker 
.const [45] = Utf8 java/lang/Object 
.const [46] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [47] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [48] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [49] = Utf8 de/esolutions/fw/comm/core/ServiceUUID 
.const [50] = Utf8 java/lang/Boolean 
.const [51] = Class [81] 
.const [52] = NameAndType [82] [83] 
.const [53] = Class [84] 
.const [54] = NameAndType [85] [86] 
.const [55] = Class [87] 
.const [56] = NameAndType [88] [89] 
.const [57] = Class [90] 
.const [58] = NameAndType [91] [92] 
.const [59] = Class [93] 
.const [60] = NameAndType [94] [95] 
.const [61] = Class [96] 
.const [62] = NameAndType [97] [98] 
.const [63] = Class [99] 
.const [64] = NameAndType [100] [101] 
.const [65] = Class [102] 
.const [66] = NameAndType [103] [104] 
.const [67] = Class [105] 
.const [68] = NameAndType [106] [107] 
.const [69] = Class [108] 
.const [70] = NameAndType [109] [110] 
.const [71] = Class [111] 
.const [72] = NameAndType [112] [113] 
.const [73] = Class [114] 
.const [74] = NameAndType [115] [116] 
.const [75] = Class [117] 
.const [76] = NameAndType [118] [119] 
.const [77] = Utf8 java/lang/Integer 
.const [78] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [79] = Utf8 IKCHECKER 
.const [80] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [81] = Utf8 de/esolutions/fw/comm/agent/service/ServiceIKChecker 
.const [82] = Utf8 ignoreIK 
.const [83] = Utf8 Z 
.const [84] = Utf8 de/esolutions/fw/comm/agent/service/ServiceIKChecker 
.const [85] = Utf8 isCompatible 
.const [86] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/comm/core/ServiceInstanceID;Lde/esolutions/fw/comm/core/ServiceInstanceID;Ljava/lang/Boolean;)Z 
.const [87] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [88] = Utf8 log 
.const [89] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [90] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [91] = Utf8 getServiceUUID 
.const [92] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceUUID; 
.const [93] = Utf8 de/esolutions/fw/comm/core/ServiceUUID 
.const [94] = Utf8 equals 
.const [95] = Utf8 (Ljava/lang/Object;)Z 
.const [96] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [97] = Utf8 log 
.const [98] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [99] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [100] = Utf8 getHandle 
.const [101] = Utf8 ()I 
.const [102] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [103] = Utf8 getInterfaceKey 
.const [104] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceUUID; 
.const [105] = Utf8 de/esolutions/fw/comm/core/ServiceUUID 
.const [106] = Utf8 isZero 
.const [107] = Utf8 ()Z 
.const [108] = Utf8 java/lang/Boolean 
.const [109] = Utf8 booleanValue 
.const [110] = Utf8 ()Z 
.const [111] = Utf8 java/lang/Object 
.const [112] = Utf8 <init> 
.const [113] = Utf8 ()V 
.const [114] = Utf8 java/lang/Integer 
.const [115] = Utf8 <init> 
.const [116] = Utf8 (I)V 
.const [117] = Utf8 de/esolutions/fw/comm/agent/service/ServiceIKChecker 
.const [118] = Utf8 ignoreIK 
.const [119] = Utf8 Z 
.const [120] = Utf8 de/esolutions/fw/comm/agent/service/ServiceIKChecker 
.const [121] = Class [120] 
.const [122] = Utf8 java/lang/Object 
.const [123] = Class [122] 
.const [124] = Utf8 ignoreIK 
.const [125] = Utf8 Z 
.const [126] = Utf8 Code 
.const [127] = Utf8 <init> 
.const [128] = Utf8 (Z)V 
.const [129] = Utf8 isCompatible 
.const [130] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/comm/core/ServiceInstanceID;Lde/esolutions/fw/comm/core/ServiceInstanceID;)Z 
.const [131] = Utf8 isCompatible 
.const [132] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/comm/core/ServiceInstanceID;Lde/esolutions/fw/comm/core/ServiceInstanceID;Ljava/lang/Boolean;)Z 
.const [133] = Utf8 isEquals 
.const [134] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;Lde/esolutions/fw/comm/core/ServiceInstanceID;)Z 
.end class 
