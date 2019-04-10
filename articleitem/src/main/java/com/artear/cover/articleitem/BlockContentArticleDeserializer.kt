/*
 * Copyright 2019 Artear S.A.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.artear.cover.articleitem

import com.artear.cover.coveritem.repository.getSafeModelObject
import com.artear.cover.coveritem.repository.model.link.Link
import com.artear.cover.coveritem.repository.model.media.Media
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class BlockContentArticleDeserializer : JsonDeserializer<BlockContentArticle> {

    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext):
            BlockContentArticle {

        val id = json.asJsonObject.get("id").asInt
        val title = json.asJsonObject.get("title").asString
        val description = json.asJsonObject.get("description").asString
        val link = json.getSafeModelObject("link", context, Link::class.java)
        val media = json.getSafeModelObject("media", context, Media::class.java)

        return BlockContentArticle(id, title, description, link, media)
    }
}
