/*
 * Copyright 2004 Sun Microsystems, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.rometools.rome.io.impl;

import org.jdom2.Attribute;
import org.jdom2.Element;

import com.rometools.rome.feed.rss.Description;
import com.rometools.rome.feed.rss.Item;

/**
 * Feed Generator for RSS 0.94
 * <p/>
 *
 * @author Elaine Chien
 *
 */

public class RSS094Generator extends RSS093Generator {

    public RSS094Generator() {
        this("rss_0.94", "0.94");
    }

    protected RSS094Generator(final String feedType, final String version) {
        super(feedType, version);
    }

    @Override
    protected void populateItem(final Item item, final Element eItem, final int index) {
        super.populateItem(item, eItem, index);

        final Description description = item.getDescription();
        if (description != null && description.getType() != null) {
            final Element eDescription = eItem.getChild("description", getFeedNamespace());
            eDescription.setAttribute(new Attribute("type", description.getType()));
        }
        eItem.removeChild("expirationDate", getFeedNamespace());
    }

}
