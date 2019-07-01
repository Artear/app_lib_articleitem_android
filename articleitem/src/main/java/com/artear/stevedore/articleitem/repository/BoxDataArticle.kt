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
package com.artear.stevedore.articleitem.repository

import com.artear.stevedore.stevedoreitems.repository.model.box.BoxData
import com.artear.stevedore.stevedoreitems.repository.model.link.Link
import com.artear.stevedore.stevedoreitems.repository.model.media.Media
import com.google.gson.annotations.JsonAdapter

@JsonAdapter(BoxDataArticleDeserializer::class)
data class BoxDataArticle(
        val id: Int, val title: String, val description: String,
        val link: Link, val media: Media
) : BoxData()