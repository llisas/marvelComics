package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.util;

import org.junit.Assert;
import org.junit.Test;

public class AppUtilsTest {

    @Test
    public void conversionIsCorrect() throws Exception {
        String value = "It&#39;s 100 years after the wall-crawler&#39;s";
        String expected = "It's 100 years after the wall-crawler's";
        Assert.assertEquals(expected, AppUtils.fromHtmlToString(value));
    }
    @Test
    public void conversionSupportsNull() throws Exception{
        String value = null;
        String expected = "error";
        Assert.assertEquals(expected,AppUtils.fromHtmlToString(value));
    }
}