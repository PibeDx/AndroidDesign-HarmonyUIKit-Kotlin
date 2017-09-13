package com.josecuentas.androiddesign_harmony_ui_kit_kotlin.ui.dashboard.discover

import com.josecuentas.androiddesign_harmony_ui_kit_kotlin.domain.model.Discover

/**
 * Created by jcuentas on 13/09/17.
 */
class DiscoverDummy {

    //fun statics
    //ref: https://stackoverflow.com/a/40352734
    companion object {
        fun getDiscovers(): MutableList<Discover> {
            var discovers: MutableList<Discover> = ArrayList()
            discovers.add(Discover(1, "Great place for a picnic!", 2.1f, "1.3 KM NEARBY", "http://enviajes.cl/wp-content/uploads/2013/10/Lugares-turisticos-de-Peru-Machupichu.jpg"))
            discovers.add(Discover(1, "Great place for a picnic!", 2.2f, "1.3 KM NEARBY", "http://static.vix.com/es/sites/default/files/styles/large/public/imj/4/4-lugares-turisticos-que-desilucionan-5.jpg?itok=u2d9q4hk"))
            discovers.add(Discover(1, "Great place for a picnic!", 2.3f, "1.3 KM NEARBY", "https://www.viajejet.com/wp-content/viajes/Lugares-turisticos-de-Londres.jpg"))
            discovers.add(Discover(1, "Great place for a picnic!", 2.4f, "1.3 KM NEARBY", "http://stylo21.com/wp-content/uploads/2015/12/Rio-de-Janeiro.jpg"))
            discovers.add(Discover(1, "Great place for a picnic!", 2.5f, "1.3 KM NEARBY", "http://kipcool.com.mx/wp-content/uploads/2016/02/Lugares-tur%C3%ADsticos-Venecia.jpg"))
            discovers.add(Discover(1, "Great place for a picnic!", 2.7f, "1.3 KM NEARBY", "http://www.viajaraitalia.com/wp-content/uploads/2012/05/Coliseo-de-Roma-abril-2007.jpg"))
            return discovers
        }
    }

}