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

import com.artear.cover.coveritem.presentation.model.ArtearObject
import com.artear.cover.coveritem.presentation.model.ArtearStyle
import com.artear.cover.coveritem.repository.model.link.Link


data class ArticleData<T : ArtearStyle>(
        val imageUrl: String,
        val title: String,
        val description: String?,
        val link: Link?,
        val isVideoContent: Boolean, val style: T) : ArtearObject<T>()

class ArticleStyle(val backgroundColor: String) : ArtearStyle()