import java.net.NetworkInterface;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Enumeration;

public class NumberGen{

    public  static void main(String []arg){
        System.out.println("current milis -- "+Instant.now().toEpochMilli());
        System.out.println("-----------------------");
        for (int i = 0; i < 100 ; i++) {
            NumberGen numberGen = new NumberGen();
            System.out.println("Generated number -- " + numberGen.nextId());
        }
    }
    private static final int UNUSED_BITS = 1; // Sign bit, Unused (always set to 0)
    private static final int EPOCH_BITS = 41;
    private static final int NODE_ID_BITS = 10;
    private static final int SEQUENCE_BITS = 12;

    private static final int maxNodeId = (int)(Math.pow(2, NODE_ID_BITS) - 1);
    private static final int maxSequence = (int)(Math.pow(2, SEQUENCE_BITS) - 1);

    // Custom Epoch (January 1, 2015 Midnight UTC = 2015-01-01T00:00:00Z)
    private static final long CUSTOM_EPOCH = 1420070400000L;
    private static final long CUSTOM_EPOCH_2020 = 1594614560551L;
    private static final long CUSTOM_EPOCH_JAN_2020 = 1577836800000L;

    private final int nodeId;

    private volatile long lastTimestamp = -1L;
    private volatile long sequence = 0L;

    // Create SequenceGenerator with a nodeId
    public NumberGen(int nodeId) {
        if(nodeId < 0 || nodeId > maxNodeId) {
            throw new IllegalArgumentException(String.format("NodeId must be between %d and %d", 0, maxNodeId));
        }
        this.nodeId = nodeId;
    }

    // Let SequenceGenerator generate a nodeId
    public NumberGen() {
        this.nodeId = createNodeId();
    }

    public synchronized long nextId() {
        long currentTimestamp = timestamp();

        if(currentTimestamp < lastTimestamp) {
            throw new IllegalStateException("Invalid System Clock!");
        }

        if (currentTimestamp == lastTimestamp) {
            sequence = (sequence + 1) & maxSequence;
            if(sequence == 0) {
                // Sequence Exhausted, wait till next millisecond.
                currentTimestamp = waitNextMillis(currentTimestamp);
            }
        } else {
            // reset sequence to start with zero for the next millisecond
            sequence = 0;
        }

        lastTimestamp = currentTimestamp;

        long id = currentTimestamp << (NODE_ID_BITS + SEQUENCE_BITS);
        id |= (nodeId << SEQUENCE_BITS);
        id |= sequence;
        return id;
    }


    // Get current timestamp in milliseconds, adjust for the custom epoch.
    private static long timestamp() {
        return Instant.now().toEpochMilli() - CUSTOM_EPOCH_JAN_2020;
    }

    // Block and wait till next millisecond
    private long waitNextMillis(long currentTimestamp) {
        while (currentTimestamp == lastTimestamp) {
            currentTimestamp = timestamp();
        }
        return currentTimestamp;
    }

    private int createNodeId() {
        int nodeId;
        try {
            StringBuilder sb = new StringBuilder();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                byte[] mac = networkInterface.getHardwareAddress();
                if (mac != null) {
                    for(int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X", mac[i]));
                    }
                }
            }
            nodeId = sb.toString().hashCode();
        } catch (Exception ex) {
            nodeId = (new SecureRandom().nextInt());
        }
        nodeId = nodeId & maxNodeId;
        return nodeId;
    }
//    current milis -- 1594616717391
//-----------------------
//Generated number -- 70380078565269504
//Generated number -- 70380080641449984
//Generated number -- 70380082633744384
//Generated number -- 70380084705730560
//Generated number -- 70380086685442048
//Generated number -- 70380088690319360
//Generated number -- 70380090628087808
//Generated number -- 70380092616187904
//Generated number -- 70380094700756992
//Generated number -- 70380096906960896
//Generated number -- 70380101428420608
//Generated number -- 70380103433297920
//Generated number -- 70380105484312576
//Generated number -- 70380108164472832
//Generated number -- 70380110769135616
//Generated number -- 70380113373798400
//Generated number -- 70380116234313728
//Generated number -- 70380118713147392
//Generated number -- 70380122504798208
//Generated number -- 70380125172375552
//Generated number -- 70380127667986432
//Generated number -- 70380129643503616
//Generated number -- 70380132046839808
//Generated number -- 70380135096098816
//Generated number -- 70380139445592064
//Generated number -- 70380141618241536
//Generated number -- 70380144206127104
//Generated number -- 70380146794012672
//Generated number -- 70380148815667200
//Generated number -- 70380150946373632
//Generated number -- 70380152930279424
//Generated number -- 70380155140677632
//Generated number -- 70380157103611904
//Generated number -- 70380159255289856
//Generated number -- 70380161226612736
//Generated number -- 70380163248267264
//Generated number -- 70380165274116096
//Generated number -- 70380167178330112
//Generated number -- 70380169149652992
//Generated number -- 70380171091615744
//Generated number -- 70380173008412672
//Generated number -- 70380175017484288
//Generated number -- 70380176980418560
//Generated number -- 70380178943352832
//Generated number -- 70380181023727616
//Generated number -- 70380183565475840
//Generated number -- 70380185712959488
//Generated number -- 70380187646533632
//Generated number -- 70380189840154624
//Generated number -- 70380191731785728
//Generated number -- 70380193640194048
//Generated number -- 70380195536019456
//Generated number -- 70380197440233472
//Generated number -- 70380199331864576
//Generated number -- 70380201227689984
//Generated number -- 70380203127709696
//Generated number -- 70380204998369280
//Generated number -- 70380206902583296
//Generated number -- 70380208790020096
//Generated number -- 70380210761342976
//Generated number -- 70380212900438016
//Generated number -- 70380214922092544
//Generated number -- 70380216952135680
//Generated number -- 70380218881515520
//Generated number -- 70380220865421312
//Generated number -- 70380222778023936
//Generated number -- 70380224694820864
//Generated number -- 70380226603229184
//Generated number -- 70380228511637504
//Generated number -- 70380230424240128
//Generated number -- 70380232341037056
//Generated number -- 70380234241056768
//Generated number -- 70380236162048000
//Generated number -- 70380238049484800
//Generated number -- 70380240041779200
//Generated number -- 70380241954381824
//Generated number -- 70380243883761664
//Generated number -- 70380245796364288
//Generated number -- 70380247713161216
//Generated number -- 70380249646735360
//Generated number -- 70380251550949376
//Generated number -- 70380253492912128
//Generated number -- 70380255732670464
//Generated number -- 70380257745936384
//Generated number -- 70380259683704832
//Generated number -- 70380261604696064
//Generated number -- 70380263605379072
//Generated number -- 70380265547341824
//Generated number -- 70380267443167232
//Generated number -- 70380269343186944
//Generated number -- 70380271289344000
//Generated number -- 70380273210335232
//Generated number -- 70380275122937856
//Generated number -- 70380277035540480
//Generated number -- 70380279157858304
//Generated number -- 70380281275981824
//Generated number -- 70380283389911040
//Generated number -- 70380285373816832
//Generated number -- 70380287353528320
//Generated number -- 70380289345822720

}
