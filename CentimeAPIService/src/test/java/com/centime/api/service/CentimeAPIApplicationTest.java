
package com.centime.api.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jmahajan
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CentimeAPIApplicationTest {

	@Test
	public void contextLoad() {
		Assert.assertTrue(Boolean.TRUE);
	}

}
