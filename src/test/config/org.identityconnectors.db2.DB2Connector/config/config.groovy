/*
 * DO NOT REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2012-2015 ForgeRock AS. All rights reserved.
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://opensource.org/licenses/CDDL-1.0
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * Header Notice in each file and include the License file
 * at http://opensource.org/licenses/CDDL-1.0
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 */

/* +---------------------------------------------------+
 *  ----------- Contract Tests configuration ------------
 *  +---------------------------------------------------+
 */

import org.identityconnectors.common.security.GuardedString

// Connector WRONG configuration for ValidateApiOpTests
connector.i1.wrong.host=""
connector.i2.wrong.login=""
connector.i3.wrong.password=new GuardedString("".toCharArray())

connType="type4"

type4.databaseName="sample"
type4.adminAccount="__configureme__"
type4.adminPassword="__configureme__"
type4.host="__configureme__"
type4.port="50000"


type2.alias="__configureme__"
type2.adminAccount="__configureme__"
type2.adminPassword="__configureme__"

//Type4
typeURL.url="jdbc:db2://127.0.0.1:50000/SAMPLE"
//Type2
//typeURL.url="jdbc:db2:sample"
typeURL.adminAccount="__configureme__"
typeURL.adminPassword="__configureme__"
typeURL.jdbcDriver="com.ibm.db2.jcc.DB2Driver"


environments {
    type2 {
        connType="type2"
    }
    type4 {
        connType="type4"
    }
}

testsuite {
    // path to bundle jar - property is set by ant - leave it as it is
    bundleJar=System.getProperty("bundleJar")
    bundleName=System.getProperty("bundleName")
    bundleVersion=System.getProperty("bundleVersion")
    connectorName=System.getProperty("connectorName")
}

