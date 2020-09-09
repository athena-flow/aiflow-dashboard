package com.aiflow.dashboard.db;

import org.junit.Test;
import com.aiflow.dashboard.db.util.DbUtil;

import java.io.File;

public class DbUtilTest {
    @Test
    public void testBackup() {
        File file = new File("test.sql");
        DbUtil.backup(file, "dashboard", "dashboard123456", "dashboard");
    }

//    这个测试用例会重置dashboard数据库，所以比较危险，请开发者注意
//    @Test
    public void testLoad() {
        File file = new File("test.sql");
        DbUtil.load(file, "dashboard", "dashboard123456", "dashboard");
    }
}
