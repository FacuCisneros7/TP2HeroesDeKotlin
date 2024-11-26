package repositories

import data.Sport

object SportRepository {

    fun getFootball(): Sport {
        return Sport(
            1L,
            "Futbol",
            4.3,
            "https://images.vexels.com/media/users/3/320306/isolated/preview/01adb8fcdea1009c64532efad2fa3c10-world-cup-soccer-symbolic-logo.png"        )
    }

    fun getBasketball(): Sport {
        return Sport(
            2L,
            "Basquet",
            4.9,
            "https://cdn.pixabay.com/photo/2019/06/10/15/11/basketball-4264543_1280.png"
        )
    }

    fun getAthletics(): Sport {
        return Sport(
            3L,
            "Atletismo",
            4.7,
            "https://images.vexels.com/content/197938/preview/athleteics-blue-31cd94.png"
        )
    }

    fun getSwimming(): Sport {
        return Sport(
            4L,
            "Natación",
            4.8,
            "https://png.pngtree.com/png-vector/20220531/ourmid/pngtree-isolated-swimming-logo-from-white-background-png-image_4769565.png"
        )
    }

    fun getGymnastics(): Sport {
        return Sport(
            5L,
            "Gimnasia",
            4.2,
            "https://png.pngtree.com/png-clipart/20220111/original/pngtree-rhythmic-gymnastics-silhouette-png-image_7083822.png"
        )
    }

    fun getCycling(): Sport {
        return Sport(
            6L,
            "Ciclismo",
            3.9,
            "https://images.vexels.com/media/users/3/129495/isolated/preview/07cbba7486bb2d9fada8510fb4b598c3-icono-de-circulo-deportivo-bmx.png"
        )
    }

    fun getRowing(): Sport {
        return Sport(
            7L,
            "Remo",
            4.1,
            "https://cdn3.iconfinder.com/data/icons/water-sports-icons/512/Rowing-512.png"
        )
    }

    fun getFencing(): Sport {
        return Sport(
            8L,
            "Esgrima",
            3.7,
            "https://cdn-icons-png.flaticon.com/512/6541/6541954.png"
        )
    }

    fun getJudo(): Sport {
        return Sport(
            9L,
            "Judo",
            4.3,
            "https://www.realjudo.net/wp-content/uploads/2017/02/JMJC_LogoPieces_600s_Guys.png"
        )
    }

    fun getTennis(): Sport {
        return Sport(
            10L,
            "Tenis",
            3.5,
            "https://images.emojiterra.com/google/noto-emoji/unicode-16.0/color/1024px/1f3be.png"
        )
    }


}