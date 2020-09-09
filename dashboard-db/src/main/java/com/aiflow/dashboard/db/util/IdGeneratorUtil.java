package com.aiflow.dashboard.db.util;

import java.text.SimpleDateFormat;

public class IdGeneratorUtil {
    /**
     * SnowFlake算法 64位Long类型生成唯一ID 第一位0，表明正数 2-42，41位，表示毫秒时间戳差值，起始值自定义
     * 43-52，10位，机器编号，5位数据中心编号，5位进程编号 53-64，12位，毫秒内计数器 本机内存生成，性能高
     * <p>
     * 主要就是三部分： 时间戳，进程id，序列号 时间戳41，id10位，序列号12位
     */

    private final static long beginTs = 1483200000000L;

    private long lastTs = 0L;

    private long processId;
    private int processIdBits = 10;

    private long sequence = 0L;
    private int sequenceBits = 12;

    // 10位进程ID标识
    public IdGeneratorUtil(long processId) {
        if (processId > ((1 << processIdBits) - 1)) {
            throw new RuntimeException("进程ID超出范围，设置位数" + processIdBits + "，最大"
                    + ((1 << processIdBits) - 1));
        }
        this.processId = processId;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    public synchronized long nextId() {
        long ts = timeGen();
        if (ts < lastTs) {// 刚刚生成的时间戳比上次的时间戳还小，出错
            throw new RuntimeException("时间戳顺序错误");
        }
        if (ts == lastTs) {// 刚刚生成的时间戳跟上次的时间戳一样，则需要生成一个sequence序列号
            // sequence循环自增
            sequence = (sequence + 1) & ((1 << sequenceBits) - 1);
            // 如果sequence=0则需要重新生成时间戳
            if (sequence == 0) {
                // 且必须保证时间戳序列往后
                ts = nextTs(lastTs);
            }
        } else {// 如果ts>lastTs，时间戳序列已经不同了，此时可以不必生成sequence了，直接取0
            sequence = 0L;
        }
        lastTs = ts;// 更新lastTs时间戳
        return ((ts - beginTs) << (processIdBits + sequenceBits)) | (processId << sequenceBits)
                | sequence;
    }

    protected long nextTs(long lastTs) {
        long ts = timeGen();
        while (ts <= lastTs) {
            ts = timeGen();
        }
        return ts;
    }

    /**
     * 20位末尾的数字id
     */
    public static int Guid = 100;

    public static String getGuid() {
        IdGeneratorUtil.Guid += 1;

        long now = System.currentTimeMillis();
        //获取4位年份数字
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        //获取时间戳
        String time = dateFormat.format(now);
        String info = now + "";
        //获取三位随机数
        //int ran = (int) ((Math.random() * 9 + 1) * 100);
        //要是一段时间内的数据连过大会有重复的情况，所以做以下修改
        int ran = 0;
        if (IdGeneratorUtil.Guid > 999) {
            IdGeneratorUtil.Guid = 100;
        }
        ran = IdGeneratorUtil.Guid;

        return time + info.substring(2, info.length()) + ran;
    }

    public static Long getLongGuid() {
        String guid = IdGeneratorUtil.getGuid();
        return Long.valueOf(guid);
    }
}