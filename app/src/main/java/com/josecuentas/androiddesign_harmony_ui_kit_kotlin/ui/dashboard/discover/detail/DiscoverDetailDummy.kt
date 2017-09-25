package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dashboard.discover.detail

import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.R
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.domain.model.Autor
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.domain.model.Category
import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.domain.model.Recommend
import java.util.*

/**
 * Created by iPibeDx on 18/09/17.
 */
class DiscoverDetailDummy {
    companion object {
        fun getCategorys(): List<Category> {
            val categoryList: MutableList<Category> = ArrayList<Category>()
            categoryList.add(Category(categoryId = 1, resourceId = R.drawable.ic_hiking))
            categoryList.add(Category(categoryId = 2, resourceId = R.drawable.ic_cycling))
            categoryList.add(Category(categoryId = 3, resourceId = R.drawable.ic_swimming))
            categoryList.add(Category(categoryId = 4, resourceId = R.drawable.ic_running))
            categoryList.add(Category(categoryId = 5, resourceId = R.drawable.ic_campfire))
            categoryList.add(Category(categoryId = 6, resourceId = R.drawable.ic_animal))
            return categoryList
        }

        fun getRecommendList() : List<Recommend> {
            val recommendList = ArrayList<Recommend>()
            recommendList.add(
                    Recommend(1, 3, "Wow! I didn’t know that there is such a cool spot so " +
                            "close to my home town! \uD83D\uDC4DYou guys need to see that!", Date(), 1,
                            Autor(1, "Victoria ", "Banks")
                    )
            )
            recommendList.add(
                    Recommend(2, 5, "Wow! I didn’t know that there is such a cool spot so " +
                            "close to my home town! \uD83D\uDC4DYou guys need to see that!", Date(), 3,
                            Autor(1, "Victoria ", "Banks")
                    )
            )
            recommendList.add(
                    Recommend(3, 4, "Wow! I didn’t know that there is such a cool spot so " +
                            "close to my home town! \uD83D\uDC4DYou guys need to see that!", Date(), 5,
                            Autor(1, "Victoria ", "Banks")
                    )
            )
            recommendList.add(
                    Recommend(4, 2, "Wow! I didn’t know that there is such a cool spot so " +
                            "close to my home town! \uD83D\uDC4DYou guys need to see that!", Date(), 7,
                            Autor(1, "Victoria ", "Banks")
                    )
            )
            recommendList.add(
                    Recommend(5, 1, "Wow! I didn’t know that there is such a cool spot so " +
                            "close to my home town! \uD83D\uDC4DYou guys need to see that!", Date(), 2,
                            Autor(1, "Victoria ", "Banks")
                    )
            )
            return recommendList
        }

    }
}