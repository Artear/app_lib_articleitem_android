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

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artear.stevedore.stevedoreitems.presentation.contract.ArtearViewHolder
import com.artear.stevedore.stevedoreitems.presentation.contract.ItemAdapter
import com.artear.stevedore.stevedoreitems.presentation.model.ArtearItem
import com.artear.stevedore.stevedoreitems.presentation.model.ArtearSection


class ArticleItemAdapter(private val listener: ArticleOnClickListener?) : ItemAdapter<ArticleData<*>> {

    var viewHolder: RecyclerView.ViewHolder? = null
    var idLayout: Int? = null

    override fun isForViewType(item: ArtearItem): Boolean {
        return item.model is ArticleData
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(idLayout ?: R.layout.article_view_holder, parent, false)
        return viewHolder ?: ArticleViewHolder(view, listener)
    }

    override fun onBindViewHolderBase(holder: ArtearViewHolder<ArticleData<*>>,
                                      model: ArticleData<*>, artearSection: ArtearSection) {
        holder.bind(model, artearSection)
    }
}