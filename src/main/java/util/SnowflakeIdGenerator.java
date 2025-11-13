package util;

public class SnowflakeIdGenerator {
    private static final long START_TIMESTAMP = 1485686400000L; //时间戳
    private static final long SEQUENCE_BIT = 12; //序列号占12bit
    private static final long MACHINE_BITS = 5; //机器ID占5bit
    private static final long DATACENTER_BITS = 5; //数据中心ID占5bit

    private static final long MAX_MACHINE_NUM = ~(-1L << MACHINE_BITS);
    private static final long MAX_DATACENTER = ~(-1L << DATACENTER_BITS);
    private static final long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);

    private static final long MACHINE_LEFT = SEQUENCE_BIT;
    private static final long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BITS;
    private static final long TIMESTAMP_LEFT = DATACENTER_LEFT + DATACENTER_BITS;

    private final long datacenterId;
    private final long machineId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public SnowflakeIdGenerator(long datacenterId, long machineId) {
        if (datacenterId > MAX_DATACENTER || datacenterId < 0) {
            throw new IllegalArgumentException("DatacenterId out of range");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    public synchronized long nextId() {
        long timestamp = currentTime();

        if (timestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards");
        }
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == 0L) {
                timestamp = nextMill();
            }
        } else {
            sequence = 0L;
        }
        lastTimestamp = timestamp;

        return (timestamp - START_TIMESTAMP) << TIMESTAMP_LEFT
                | (datacenterId << DATACENTER_LEFT)
                | (machineId << MACHINE_LEFT)
                | sequence;
    }

    private long nextMill() {
        long mill = currentTime();
        while (mill <= lastTimestamp) {
            mill = currentTime();
        }
        return mill;
    }

    private long currentTime() {
        return System.currentTimeMillis();
    }
}
