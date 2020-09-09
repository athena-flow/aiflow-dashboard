package com.aiflow.dashboard.db;

import com.aiflow.dashboard.db.util.IdGeneratorUtil;
import org.junit.Test;

public class IdGeneratorUtilTest {
    @Test
    public void test() {
        System.out.println(IdGeneratorUtil.getLongGuid());
    }
}
