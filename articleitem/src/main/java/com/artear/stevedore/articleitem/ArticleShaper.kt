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
package com.artear.stevedore.articleitem

import com.artear.domain.coroutine.DataShaper
import com.artear.stevedore.stevedoreitems.presentation.model.ArtearItem
import com.artear.stevedore.stevedoreitems.presentation.model.ArtearSection
import com.artear.stevedore.stevedoreitems.repository.model.box.Box
import com.artear.stevedore.stevedoreitems.repository.model.media.Media
import com.artear.stevedore.stevedoreitems.repository.model.media.MediaDataPicture
import com.artear.stevedore.stevedoreitems.repository.model.media.MediaDataYoutube
import com.artear.stevedore.stevedoreitems.repository.model.media.MediaType.*


class ArticleShaper : DataShaper<Box, ArtearItem> {

    override suspend fun transform(input: Box): ArtearItem {

        val boxDataArticle = (input.data as BoxDataArticle)
        val imageUrl = getImage(boxDataArticle.media)

        return imageUrl.let {
            val data = ArticleData(imageUrl,
                    boxDataArticle.title,
                    boxDataArticle.description,
                    boxDataArticle.link,
                    boxDataArticle.media.type == YOUTUBE,
                    input.style
            )
            ArtearItem(data, ArtearSection())
        }
    }

    private fun getImage(media: Media): String {
        return when (media.type) {
            PICTURE -> (media.data as MediaDataPicture).url
            YOUTUBE -> (media.data as MediaDataYoutube).image.url
            GALLERY -> TODO()
            VIDEO -> TODO()
        }
    }

}