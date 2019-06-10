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

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.artear.stevedore.stevedoreitems.presentation.contract.ArtearViewHolder
import com.artear.stevedore.stevedoreitems.presentation.model.ArtearSection
import kotlinx.android.synthetic.main.article_view_holder.view.*


class ArticleViewHolder(itemView: View, private var listener: ArticleOnClickListener? = null) :
        RecyclerView.ViewHolder(itemView), ArtearViewHolder<ArticleData<*>> {

    override fun bind(model: ArticleData<*>, artearSection: ArtearSection) {

        model.style

        itemView.apply {
           contentTitle.text = model.title
        }

        itemView.setOnClickListener {
            listener?.run {
                model.link?.let { link ->
                    onArticleClick(link)
                }
            }
        }

    }

}