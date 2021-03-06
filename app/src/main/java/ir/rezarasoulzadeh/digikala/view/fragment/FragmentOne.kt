package ir.rezarasoulzadeh.digikala.view.fragment

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.rezarasoulzadeh.digikala.R
import ir.rezarasoulzadeh.digikala.model.SubCategory
import ir.rezarasoulzadeh.digikala.model.keys.SubCategoryKey
import kotlinx.android.synthetic.main.model_sub_category.view.*

class FragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sub_category, container, false)
        val subCategory = arguments?.getParcelableArrayList<SubCategory>(SubCategoryKey.KEY)
        setSubCategory(subCategory as List<SubCategory>, view)
        return view
    }

    fun setSubCategory(subCategory: List<SubCategory>, view: View) {
        val subCategoriesAdapter = SubCategoryAdapter(subCategory)
        val subCategoriesRecyclerView =
            view.findViewById<RecyclerView>(R.id.subCategoryRecyclerView)
        val horizontal =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        subCategoriesRecyclerView.layoutManager = horizontal
        subCategoriesRecyclerView.adapter = subCategoriesAdapter
    }

    inner class SubCategoryAdapter(private val subCategories: List<SubCategory>) :
        RecyclerView.Adapter<SubCategoryAdapter.SubCategoryViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.model_sub_category, parent, false)
            return SubCategoryViewHolder(view)
        }

        override fun getItemCount(): Int {
            return subCategories.size
        }

        override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {
            holder.bind(subCategories[position])
        }

        inner class SubCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(subCategory: SubCategory) {
                itemView.subCategoryImageView.setImageURI(Uri.parse(subCategory.imagePath))
                itemView.subCategoryTitleTextView.text = subCategory.title
            }
        }

    }

}
