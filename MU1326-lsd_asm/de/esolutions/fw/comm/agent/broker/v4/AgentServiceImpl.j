.version 50 0 
.class public super [138] 
.super [140] 
.implements [142] 
.field private final [143] [144] 

.method public [146] : [147] 
    .attribute [145] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [30] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [148] : [149] 
    .attribute [145] .code stack 8 locals 5 
L0:     aload_1 
L1:     ifnonnull L5 
L4:     return 
L5:     aload_1 
L6:     arraylength 
L7:     anewarray [2] 
L10:    astore_2 
L11:    iconst_0 
L12:    istore_3 
L13:    iload_3 
L14:    aload_1 
L15:    arraylength 
L16:    if_icmpge L223 
L19:    aload_1 
L20:    iload_3 
L21:    aaload 
L22:    getfield [19] 
L25:    ldc [3] 
L27:    iand 
L28:    i2s 
L29:    istore 6 
L31:    aload_1 
L32:    iload_3 
L33:    aaload 
L34:    getfield [20] 
L37:    tableswitch 0 
            L70 
            L76 
            L64 
            default : L82 

L64:    iconst_2 
L65:    istore 4 
L67:    goto L106 
L70:    iconst_0 
L71:    istore 4 
L73:    goto L106 
L76:    iconst_1 
L77:    istore 4 
L79:    goto L106 
L82:    getstatic [4] 
L85:    iconst_4 
L86:    ldc [5] 
L88:    new [32] 
L91:    dup 
L92:    aload_1 
L93:    iload_3 
L94:    aaload 
L95:    getfield [20] 
L98:    invokespecial [27] 
L101:   invokevirtual [21] 
L104:   pop 
L105:   return 
L106:   aload_1 
L107:   iload_3 
L108:   aaload 
L109:   getfield [22] 
L112:   tableswitch 0 
            L162 
            L150 
            L156 
            L144 
            default : L168 

L144:   iconst_3 
L145:   istore 5 
L147:   goto L192 
L150:   iconst_1 
L151:   istore 5 
L153:   goto L192 
L156:   iconst_2 
L157:   istore 5 
L159:   goto L192 
L162:   iconst_0 
L163:   istore 5 
L165:   goto L192 
L168:   getstatic [4] 
L171:   iconst_4 
L172:   ldc [7] 
L174:   new [32] 
L177:   dup 
L178:   aload_1 
L179:   iload_3 
L180:   aaload 
L181:   getfield [22] 
L184:   invokespecial [27] 
L187:   invokevirtual [21] 
L190:   pop 
L191:   return 
L192:   aload_2 
L193:   iload_3 
L194:   new [31] 
L197:   dup 
L198:   iload 4 
L200:   iload 5 
L202:   aload_1 
L203:   iload_3 
L204:   aaload 
L205:   getfield [23] 
L208:   invokestatic [8] 
L211:   iload 6 
L213:   invokespecial [28] 
L216:   aastore 
L217:   iinc 3 1 
L220:   goto L13 
L223:   aload_0 
L224:   getfield [18] 
L227:   aload_2 
L228:   invokeinterface [33] 0 
L233:   return 
L234:   nop 
L235:   nop 
L236:   
    .end code 
.end method 

.method public [150] : [151] 
    .attribute [145] .code stack 6 locals 5 
L0:     aload_1 
L1:     ifnonnull L5 
L4:     return 
L5:     aload_1 
L6:     arraylength 
L7:     anewarray [9] 
L10:    astore_2 
L11:    iconst_0 
L12:    istore_3 
L13:    iload_3 
L14:    aload_1 
L15:    arraylength 
L16:    if_icmpge L66 
L19:    aload_1 
L20:    iload_3 
L21:    aaload 
L22:    astore 4 
L24:    aload 4 
L26:    invokevirtual [24] 
L29:    ldc [3] 
L31:    iand 
L32:    i2s 
L33:    istore 5 
L35:    aload 4 
L37:    invokevirtual [25] 
L40:    ldc [3] 
L42:    iand 
L43:    i2s 
L44:    istore 6 
L46:    aload_2 
L47:    iload_3 
L48:    new [34] 
L51:    dup 
L52:    iload 5 
L54:    iload 6 
L56:    invokespecial [29] 
L59:    aastore 
L60:    iinc 3 1 
L63:    goto L13 
L66:    aload_0 
L67:    getfield [18] 
L70:    aload_2 
L71:    invokeinterface [35] 0 
L76:    return 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [36] 
.const [3] = Int -65536 
.const [4] = Field [37] [38] 
.const [5] = String [39] 
.const [6] = Class [40] 
.const [7] = String [41] 
.const [8] = Method [42] [43] 
.const [9] = Class [44] 
.const [10] = Class [45] 
.const [11] = Class [46] 
.const [12] = Class [47] 
.const [13] = Class [48] 
.const [14] = Class [49] 
.const [15] = Class [50] 
.const [16] = Class [51] 
.const [17] = Class [52] 
.const [18] = Field [53] [54] 
.const [19] = Field [55] [56] 
.const [20] = Field [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Field [61] [62] 
.const [23] = Field [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Method [69] [70] 
.const [27] = Method [71] [72] 
.const [28] = Method [73] [74] 
.const [29] = Method [75] [76] 
.const [30] = Field [77] [78] 
.const [31] = Class [79] 
.const [32] = Class [80] 
.const [33] = InterfaceMethod [81] [82] 
.const [34] = Class [83] 
.const [35] = InterfaceMethod [84] [85] 
.const [36] = Utf8 de/esolutions/fw/comm/agent/broker/BrokerServiceUpdate 
.const [37] = Class [86] 
.const [38] = NameAndType [87] [88] 
.const [39] = Utf8 'Invalid serviceUpdate V3 action received: %1' 
.const [40] = Utf8 java/lang/Integer 
.const [41] = Utf8 'Invalid serviceUpdate V3 reason received: %1' 
.const [42] = Class [89] 
.const [43] = NameAndType [90] [91] 
.const [44] = Utf8 de/esolutions/fw/comm/agent/broker/BrokerAgentUpdate 
.const [45] = Utf8 de/esolutions/fw/comm/agent/broker/v4/AgentServiceImpl 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 de/esolutions/fw/comm/comm/broker/v4/UpdateEvent 
.const [48] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [49] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [50] = Utf8 de/esolutions/fw/comm/agent/broker/v4/BrokerIDLTool 
.const [51] = Utf8 de/esolutions/fw/comm/agent/broker/IBrokerServiceListener 
.const [52] = Utf8 de/esolutions/fw/comm/comm/broker/v4/AgentUpdateEvent 
.const [53] = Class [92] 
.const [54] = NameAndType [93] [94] 
.const [55] = Class [95] 
.const [56] = NameAndType [96] [97] 
.const [57] = Class [98] 
.const [58] = NameAndType [99] [100] 
.const [59] = Class [101] 
.const [60] = NameAndType [102] [103] 
.const [61] = Class [104] 
.const [62] = NameAndType [105] [106] 
.const [63] = Class [107] 
.const [64] = NameAndType [108] [109] 
.const [65] = Class [110] 
.const [66] = NameAndType [111] [112] 
.const [67] = Class [113] 
.const [68] = NameAndType [114] [115] 
.const [69] = Class [116] 
.const [70] = NameAndType [117] [118] 
.const [71] = Class [119] 
.const [72] = NameAndType [120] [121] 
.const [73] = Class [122] 
.const [74] = NameAndType [123] [124] 
.const [75] = Class [125] 
.const [76] = NameAndType [126] [127] 
.const [77] = Class [128] 
.const [78] = NameAndType [129] [130] 
.const [79] = Utf8 de/esolutions/fw/comm/agent/broker/BrokerServiceUpdate 
.const [80] = Utf8 java/lang/Integer 
.const [81] = Class [131] 
.const [82] = NameAndType [132] [133] 
.const [83] = Utf8 de/esolutions/fw/comm/agent/broker/BrokerAgentUpdate 
.const [84] = Class [134] 
.const [85] = NameAndType [135] [136] 
.const [86] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [87] = Utf8 BROKER 
.const [88] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [89] = Utf8 de/esolutions/fw/comm/agent/broker/v4/BrokerIDLTool 
.const [90] = Utf8 convertInstanceIDFromIDL 
.const [91] = Utf8 (Lde/esolutions/fw/comm/comm/broker/v4/InstanceID;)Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [92] = Utf8 de/esolutions/fw/comm/agent/broker/v4/AgentServiceImpl 
.const [93] = Utf8 listener 
.const [94] = Utf8 Lde/esolutions/fw/comm/agent/broker/IBrokerServiceListener; 
.const [95] = Utf8 de/esolutions/fw/comm/comm/broker/v4/UpdateEvent 
.const [96] = Utf8 home_agent_id 
.const [97] = Utf8 I 
.const [98] = Utf8 de/esolutions/fw/comm/comm/broker/v4/UpdateEvent 
.const [99] = Utf8 action 
.const [100] = Utf8 I 
.const [101] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [102] = Utf8 log 
.const [103] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [104] = Utf8 de/esolutions/fw/comm/comm/broker/v4/UpdateEvent 
.const [105] = Utf8 reason 
.const [106] = Utf8 I 
.const [107] = Utf8 de/esolutions/fw/comm/comm/broker/v4/UpdateEvent 
.const [108] = Utf8 svc_id 
.const [109] = Utf8 Lde/esolutions/fw/comm/comm/broker/v4/InstanceID; 
.const [110] = Utf8 de/esolutions/fw/comm/comm/broker/v4/AgentUpdateEvent 
.const [111] = Utf8 getAgent_id 
.const [112] = Utf8 ()I 
.const [113] = Utf8 de/esolutions/fw/comm/comm/broker/v4/AgentUpdateEvent 
.const [114] = Utf8 getAgent_epoch 
.const [115] = Utf8 ()I 
.const [116] = Utf8 java/lang/Object 
.const [117] = Utf8 <init> 
.const [118] = Utf8 ()V 
.const [119] = Utf8 java/lang/Integer 
.const [120] = Utf8 <init> 
.const [121] = Utf8 (I)V 
.const [122] = Utf8 de/esolutions/fw/comm/agent/broker/BrokerServiceUpdate 
.const [123] = Utf8 <init> 
.const [124] = Utf8 (IILde/esolutions/fw/comm/core/ServiceInstanceID;S)V 
.const [125] = Utf8 de/esolutions/fw/comm/agent/broker/BrokerAgentUpdate 
.const [126] = Utf8 <init> 
.const [127] = Utf8 (SS)V 
.const [128] = Utf8 de/esolutions/fw/comm/agent/broker/v4/AgentServiceImpl 
.const [129] = Utf8 listener 
.const [130] = Utf8 Lde/esolutions/fw/comm/agent/broker/IBrokerServiceListener; 
.const [131] = Utf8 de/esolutions/fw/comm/agent/broker/IBrokerServiceListener 
.const [132] = Utf8 serviceUpdate 
.const [133] = Utf8 ([Lde/esolutions/fw/comm/agent/broker/BrokerServiceUpdate;)V 
.const [134] = Utf8 de/esolutions/fw/comm/agent/broker/IBrokerServiceListener 
.const [135] = Utf8 agentUpdate 
.const [136] = Utf8 ([Lde/esolutions/fw/comm/agent/broker/BrokerAgentUpdate;)V 
.const [137] = Utf8 de/esolutions/fw/comm/agent/broker/v4/AgentServiceImpl 
.const [138] = Class [137] 
.const [139] = Utf8 java/lang/Object 
.const [140] = Class [139] 
.const [141] = Utf8 de/esolutions/fw/comm/comm/broker/v4/Agent 
.const [142] = Class [141] 
.const [143] = Utf8 listener 
.const [144] = Utf8 Lde/esolutions/fw/comm/agent/broker/IBrokerServiceListener; 
.const [145] = Utf8 Code 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (Lde/esolutions/fw/comm/agent/broker/IBrokerServiceListener;)V 
.const [148] = Utf8 serviceUpdate 
.const [149] = Utf8 ([Lde/esolutions/fw/comm/comm/broker/v4/UpdateEvent;)V 
.const [150] = Utf8 agentUpdate 
.const [151] = Utf8 ([Lde/esolutions/fw/comm/comm/broker/v4/AgentUpdateEvent;)V 
.end class 
