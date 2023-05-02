package com.rafli.productlist.ui.product_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rafli.productlist.data.model.Product
import com.rafli.productlist.databinding.ItemProductBinding

class ProductListAdapter(
    private val productList: ArrayList<Product>
) : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.productName.text = product.productName
            binding.productRating.text = product.rating.toString()
            Glide.with(binding.productImage.context)
                .load(product.productImage)
                .into(binding.productImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProductViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
        holder.bind(productList[position])

    fun addData(list: List<Product>) {
        productList.addAll(list)
    }
}