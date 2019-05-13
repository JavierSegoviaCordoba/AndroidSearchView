package com.javiersc.materialsearchview.view.materialsearchview.setups
/*

import android.text.Editable
import android.text.TextWatcher
import com.javiersc.materialsearchview.view.menu.MenuMaterialSearchView
import kotlinx.android.synthetic.main.component_search_text.view.*

internal fun setupTextInputEditText(menuMaterialSearchView: MenuMaterialSearchView) =
    with(menuMaterialSearchView.textInputEditText) {
        setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) showSoftKeyboard(context) else hideSoftKeyboard(context)
        }
        setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                menuMaterialSearchView.submitObservable = v?.text.toString()
                menuMaterialSearchView.close()
            }
            true
        }
        addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                menuMaterialSearchView.queryObservable = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                if (count == 0) menuMaterialSearchView.adapter?.suggestionAdapter?.submitList(emptyList())
                else {
                    val itemList = menuMaterialSearchView.adapter?.suggestionAdapter?.currentList
                    val suggestionList = menuMaterialSearchView.adapter?.suggestionList
                    if (itemList != null && suggestionList != null) {
                        val filteredList =
                            filterList(charSequence, itemList.toList(), suggestionList)
                        menuMaterialSearchView.adapter?.suggestionAdapter?.submitList(filteredList)
                    }
                }
                fixRecyclerViewHeight(menuMaterialSearchView)
            }
        })
    }*/
