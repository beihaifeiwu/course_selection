package com.course.selection.test;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

public class CommonTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyÄêMMÔÂddÈÕ E");
		System.out.println(sdf.format(new Date()));
	}

}
