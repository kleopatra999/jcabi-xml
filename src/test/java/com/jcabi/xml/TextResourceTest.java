/**
 * Copyright (c) 2012-2017, jcabi.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the jcabi.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jcabi.xml;

import com.google.common.io.Files;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.CharEncoding;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Test case for {@link TextResource}.
 *
 * @author Carlos Miranda (miranda.cma@gmail.com)
 * @version $Id$
 */
public final class TextResourceTest {

    /**
     * TextResource should be able to read streams as text.
     * @throws Exception If something goes wrong.
     */
    @Test
    public void readsStreamAsText() throws Exception {
        final String text = "Blah!\u20ac\u2122";
        final InputStream stream = new ByteArrayInputStream(
            text.getBytes(CharEncoding.UTF_8)
        );
        MatcherAssert.assertThat(
            new TextResource(stream).toString(),
            Matchers.is(text)
        );
    }

    /**
     * TextResource should be able to read files as text.
     * @throws Exception If something goes wrong.
     */
    @Test
    public void readsFileAsText() throws Exception {
        final String text = "<a xmlns='urn:foo'><b>\u0433!</b></a>";
        final File file = new File(Files.createTempDir(), "dummy.xml");
        FileUtils.writeStringToFile(file, text, CharEncoding.UTF_8);
        MatcherAssert.assertThat(
            new TextResource(file).toString(),
            Matchers.is(text)
        );
    }

}
