/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  The ASF licenses this file to You
* under the Apache License, Version 2.0 (the "License"); you may not
* use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.  For additional information regarding
* copyright in this work, please see the NOTICE file in the top level
* directory of this distribution.
*/
package org.apache.abdera.test.parser;

import java.util.Date;

import org.apache.abdera.Abdera;
import org.apache.abdera.model.Content;
import org.apache.abdera.model.Entry;

import junit.framework.TestCase;


public class EncodingTest extends TestCase {
    
    public void testContentEncoding() throws Exception {
        Abdera abdera = new Abdera();
        Entry entry = abdera.newEntry();
        entry.setId("http://example.com/entry/1");
        entry.setTitle("Whatever");
        entry.setUpdated(new Date());
        Content content = entry.getFactory().newContent(Content.Type.XML);
        String s = "<x>" + new Character((char) 224) + "</x>";
        content.setValue(s);
        content.setMimeType("application/xml+whatever");
        entry.setContentElement(content);
        assertNotNull(entry.getContent());
        assertEquals(s, entry.getContent());
    }

}
