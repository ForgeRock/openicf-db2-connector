package org.identityconnectors.db2;

import java.sql.*;
import java.util.Collection;

import org.identityconnectors.dbcommon.SQLUtil;
import org.identityconnectors.framework.test.TestHelpers;
import org.junit.*;

/** Test of DB2AuthorityReader */
public class DB2AuthorityReaderTest {
	
	private static Connection conn;
	private static DB2AuthorityReader testee;
	private static String testUser;
	
	
	/**
	 * Setup
	 * @throws Exception
	 */
	@BeforeClass
	public static void setup() throws Exception{
		conn = DB2ConnectorTest.createTestConnection();
		testee = new DB2AuthorityReader(conn);
		testUser = TestHelpers.getProperty("testUser",null);
	}
	
	/**
	 * TearDown
	 */
	@AfterClass
	public static void afterClass(){
		SQLUtil.closeQuietly(conn);
	}
	
	private void testAuthoritiesNotEmpty(final Collection<DB2Authority> authorities){
		Assert.assertTrue(!authorities.isEmpty());
	}

	/**
	 * Test reading database authorities
	 * @throws SQLException
	 */
	@Test
	public void testReadDatabaseAuthorities() throws SQLException {
		testee.readDatabaseAuthorities(testUser);
	}

	/**
	 * Test reading all authorities
	 * @throws SQLException
	 */
	@Test
	public void testReadAllAuthorities() throws SQLException {
		testAuthoritiesNotEmpty(testee.readAllAuthorities(testUser));
	}

	/**
	 * Test reading index authorities
	 * @throws SQLException
	 */
	@Test
	public void testReadIndexAuthorities() throws SQLException {
		testAuthoritiesNotEmpty(testee.readIndexAuthorities(testUser));
	}

	/**
	 * Test reading package authorities
	 * @throws SQLException
	 */
	@Test
	public void testReadPackageAuthorities() throws SQLException {
		testAuthoritiesNotEmpty(testee.readPackageAuthorities(testUser));
	}

	/**
	 * Test reading schema authorities
	 * @throws SQLException
	 */
	@Test
	public void testReadSchemaAuthorities() throws SQLException {
		testee.readSchemaAuthorities(testUser);
	}

	/**
	 * Test reading server authorities
	 * @throws SQLException
	 */
	@Test
	public void testReadServerAuthorities() throws SQLException {
		testee.readServerAuthorities(testUser);
	}

	/**
	 * Test reading table authorities
	 * @throws SQLException
	 */
	@Test
	public void testReadTableAuthorities() throws SQLException {
		testAuthoritiesNotEmpty(testee.readTableAuthorities(testUser));
	}

	/**
	 * Test reading tablespace authorities
	 * @throws SQLException
	 */
	@Test
	public void testReadTablespaceAuthorities() throws SQLException {
		testAuthoritiesNotEmpty(testee.readTablespaceAuthorities(testUser));
	}

}