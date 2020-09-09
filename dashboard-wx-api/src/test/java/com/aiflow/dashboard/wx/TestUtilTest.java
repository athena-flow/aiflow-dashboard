package com.aiflow.dashboard.wx;

import com.aiflow.dashboard.wx.dto.RideOrderSnap;
import org.junit.Test;

public class TestUtilTest {
    @Test
    public void test() {
        String mobile = "";
        System.out.println(mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2"));
        mobile = "16811116667";
        System.out.println(mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2"));
        Byte status = 7;
        System.out.println(status == 7);
    }

    @Test
    public void testString() {
        String orderSn = "RIDE_1";
        System.out.println(orderSn.indexOf("RIDE_"));
        System.out.println(orderSn.indexOf("TEST_"));
        System.out.println(orderSn.contains("RIDE_"));
        System.out.println(orderSn.contains("TEST_"));
    }

    @Test
    public void testObject() {
        RideOrderSnap snap = new RideOrderSnap();
        snap.setKiloFee("10");
        System.out.println(snap.getKiloFee());
    }
}
